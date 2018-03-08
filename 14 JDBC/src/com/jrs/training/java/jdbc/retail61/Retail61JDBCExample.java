package com.jrs.training.java.jdbc.retail61;

import com.jrs.training.java.jdbc.MySQLDatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Retail61JDBCExample {

	public static void main(String[] args) throws Exception{
		// create a connection.
		String url = "jdbc:mysql://localhost:3306/retail_61";
		String user="root";
		String pass = "root";
		
		Connection conn = MySQLDatabaseManager.getConnection(url, user, pass);
		//exampleOfStatement(conn);
		
		String qry = "INSERT INTO customers(ID, NAME, AGE, ADDRESS, SALARY) "
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(qry);
		ps.setString(2, "Abhi");
		ps.setInt(3, 25);
		ps.setInt(1, 10);
		ps.setString(4, "Bangalore");
		ps.setFloat(5, 10.25f);
		
		ps.executeUpdate();
		
		ps.setString(2, "Sandeep");
		ps.setInt(3, 13);
		ps.setInt(1, 11);
		ps.setString(4, "Andhra");
		ps.setFloat(5, 123.25f);
		
		ps.executeUpdate();
		
		conn.close();
	}

	public static void exampleOfStatement(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		String cond = "R%";
		String qry = "SELECT * FROM CUSTOMERS WHERE NAME LIKE ?";
		ResultSet rs = stmt.executeQuery(qry);
		ResultSetMetaData rsmd = rs.getMetaData();
		for(int i=1; i<=rsmd.getColumnCount(); i++){
			System.out.print(rsmd.getColumnName(i) + " : ");
		}
		System.out.println("");
		
		while(rs!= null && rs.next()){
			for(int i=1; i<=rsmd.getColumnCount(); i++){
				System.out.print(rs.getString(i) + " : ");
			}
			System.out.println("");
		}
	}

}
