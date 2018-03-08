package org.jecm15.StroedApp;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStmt {

	public static void main(String[] args) {

		Connection con=null;
		CallableStatement cstmt=null;
		ResultSet rs=null;
		String qry="{call student.getstudent(?)}";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int sid=sc.nextInt();
		sc.close();
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		cstmt=con.prepareCall(qry);
		cstmt.setInt(1, sid);
		rs=cstmt.executeQuery();
			if(rs.next())
			{
				String name=rs.getString(2);
				String course=rs.getString(3);
				String perc=rs.getString(4);
				System.out.println(name+" "+course+" "+perc);
			}
		
			else
			{
				System.err.println("No Data Found");
			}
		}
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cstmt!=null)
			{
				try {
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
		
		
		
	}


