package org.jecm17.jdbcApp;
import java.sql.*;
public class insertDemo  {
	public static void main(String[] args)
	{
	Connection con=null;
	PreparedStatement pstmt = null;
	String qry="insert into student.tejas values(?,?,?)";
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver class loaded and Registered ");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Connection established with dbserver");
		pstmt=con.prepareStatement(qry);
		System.out.println("platform created");
		pstmt.setInt(1,1);
		pstmt.setString(2,"Tejas");
		pstmt.setDouble(3, 76);
		pstmt.executeUpdate();
		
		pstmt.setInt(1,2);
		pstmt.setString(2,"abc");
		pstmt.setDouble(3, 76);
		pstmt.executeUpdate();
		
		
		pstmt.setInt(1,3);
		pstmt.setString(2,"xyz");
		pstmt.setDouble(3, 76);
		pstmt.executeUpdate();
		
		System.out.println(" data inserted into db successfully");
		
		
	} 
	catch (ClassNotFoundException | SQLException e) 
	{
		
		e.printStackTrace();
	;	
	} 
	finally
	{
		if(pstmt!=null)
		{
			try 
			{
				pstmt.close();
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


