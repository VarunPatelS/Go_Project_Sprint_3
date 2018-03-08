package com.jrs.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLDatabaseManager {

	static MySQLDatabaseManager mgr = MySQLDatabaseManager.getInstance();
	
	private static MySQLDatabaseManager _instance = null;
	
	public static MySQLDatabaseManager getInstance(){
		if(_instance == null){
			synchronized (MySQLDatabaseManager.class) {
				_instance = new MySQLDatabaseManager();
			}
		}
		return _instance;
	}
	
	private Connection conn = null;

	private MySQLDatabaseManager(){
		conn = null;
	}
	
	public static Connection getConnection(){
		return getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
	}
	
	/*public static Connection getConnection(String url, String user, String pass){
			try {
				if(getInstance().conn == null || getInstance().conn.isClosed()){
					Class.forName("com.mysql.jdbc.Driver");
					getInstance().conn = 
							DriverManager.getConnection(url, user, pass);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
			return getInstance().conn;
	}*/
	public static Connection getConnection(String url){
		try {
			if(getInstance().conn == null || getInstance().conn.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
				getInstance().conn = 
						DriverManager.getConnection(url);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
		return getInstance().conn;
}
	
	
	
	
	public boolean saveToDos(List<String> todoList){
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			getConnection().setAutoCommit(false);
			// first delete all
			stmt = getConnection().createStatement();
			stmt.execute("DELETE FROM TODOLIST");
			
			// save new list.

			pstmt = getConnection().prepareStatement("INSERT INTO TODOLIST (ITEM) VALUES (?)");
			for(String item : todoList){
				pstmt.setString(1, item);
				pstmt.execute();
			}
					
		} catch (Exception e) {
			try {
				getConnection().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		} finally{
			close(stmt);
			close(pstmt);
		}
		try {
			getConnection().commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public List<String> loadAllToDos(){
		List<String> itemList = new ArrayList<String>();
		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TODOLIST");
			
			while(rs.next()){
				itemList.add(rs.getString(1));
			}
		} catch (Exception e) {

		} finally{
			close(stmt);
		}
		
		
		return itemList;
	}

	public static void close(AutoCloseable closeaable) {
		try {
			if(closeaable != null){
				closeaable.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection conn = MySQLDatabaseManager.getConnection();
		if(conn != null){
			System.out.println("Connected to DB.");
			close(conn);
			
			List<String> itemList = mgr.loadAllToDos();
			System.out.println("Items - " + itemList);
			
			itemList.add("New Item - " + Math.random());
			mgr.saveToDos(itemList);
			System.out.println("Saved all");
			
			itemList = mgr.loadAllToDos();
			System.out.println("Reloaded Items - " + itemList);
			
			
			
		} else {
			System.err.println("Unable to connect to DB.");
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		close(conn);
		conn = null;
		super.finalize();
	}
}
