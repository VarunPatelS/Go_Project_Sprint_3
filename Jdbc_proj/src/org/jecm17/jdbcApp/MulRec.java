package org.jecm17.jdbcApp;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class MulRec {
		public static void main(String[] args)
		{
		Connection con=null;
		Statement stmt=null;
		String qry1="insert into student.tejas values (4,'sunil',70)";
		String qry2="insert into student.tejas values (5,'varun',70)";
		String qry3="insert into student.tejas values (6,'Adhi',70)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver class loaded and Registered ");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection established with dbserver");
			stmt=con.createStatement();
			System.out.println("platform created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("data inserted into db successfully");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
			
		} 
		finally
		{
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} 
				catch (SQLException e) 
				{
					
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				
				}
				catch(SQLException e)
			
			{
					e.printStackTrace();
			}
			
		}
		}
		}

		

	}


