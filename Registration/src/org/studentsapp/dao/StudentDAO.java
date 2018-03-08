package org.studentsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.studentsapp.dto.StudentInfoBean;

public class StudentDAO {
	
	public void insert(StudentInfoBean bean)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection open");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement("insert into stud.regi value(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,bean.getId());
			pstmt.setString(2,bean.getName());
			pstmt.setString(3,bean.getPhone());
			pstmt.setString(4,bean.getEmail());
			pstmt.setString(5,bean.getDegree());
			pstmt.setInt(6,bean.getYOP());
			pstmt.setString(7,bean.getPassword());
			pstmt.setString(8,bean.getIsAdmin());
		}
		catch (ClassNotFoundException | SQLException e) {
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
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
