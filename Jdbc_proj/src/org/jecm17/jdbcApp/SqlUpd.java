package org.jecm17.jdbcApp;
import java.sql.*;
public class SqlUpd  {
	public static void main(String[] args)
	{
	Connection con=null;
	Statement stmt=null;
	String qry="update student.tejas set name='efg' where id=2";
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver class loaded and Registered ");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Connection established with dbserver");
		stmt=con.createStatement();
		System.out.println("platform created");
		stmt.executeUpdate(qry); 
		System.out.println("data updated to db");
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





