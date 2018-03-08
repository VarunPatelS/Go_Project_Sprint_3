package com.jrs.training.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleDatabaseManager {

	
	private static OracleDatabaseManager _instance = null;
	
	public static OracleDatabaseManager getInstance(){
		if(_instance == null){
			synchronized (OracleDatabaseManager.class) {
				_instance = new OracleDatabaseManager();
			}
		}
		return _instance;
	}
	
	private Connection conn = null;

	private OracleDatabaseManager(){
		conn = null;
	}
	
	public Connection getConnection(){
			try {
				if(getInstance().conn == null || getInstance().conn.isClosed()){
					Class.forName("oracle.jdbc.OracleDriver");
					getInstance().conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.41.247:1521:xe", "dev_56", "dev_56");
					//getInstance().conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.43:1521:xe", "system", "vinay");
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM \"HR\".\"COUNTRIES\"");
			
			while(rs.next()){
				itemList.add(rs.getString(2));
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
		OracleDatabaseManager mgr = OracleDatabaseManager.getInstance();
		Connection conn = mgr.getConnection();
		if(conn != null){
			System.out.println("Connected to DB.");
			close(conn);
			
			Statement st = null;
			try {
				st = mgr.getConnection().createStatement();
				st.addBatch("drop table EMPLOYEE");
				st.addBatch("create table EMPLOYEE ( id INT NOT NULL, first_name VARCHAR(20) default NULL, last_name VARCHAR(20) default NULL, salary INT default NULL, 	PRIMARY KEY (id) )");
				st.addBatch("drop SEQUENCE EMPLOYEE_SEQ");
				st.addBatch("CREATE SEQUENCE EMPLOYEE_SEQ");
				st.addBatch("CREATE OR REPLACE TRIGGER EMPLOYEE_bir BEFORE INSERT ON EMPLOYEE FOR EACH ROW BEGIN   SELECT EMPLOYEE_SEQ.NEXTVAL  INTO   :new.id   FROM   dual; END");
				st.executeBatch();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				close(st);
			}
			/*
			
			List<String> itemList = mgr.loadAllToDos();
			System.out.println("Items - " + itemList);
			itemList.add("New Item - " + Math.random());
			mgr.saveToDos(itemList);
			System.out.println("Saved all");
			
			itemList = mgr.loadAllToDos();
			System.out.println("Reloaded Items - " + itemList);
			*/
			
			
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
