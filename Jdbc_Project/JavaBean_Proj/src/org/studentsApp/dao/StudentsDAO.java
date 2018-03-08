package org.studentsApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.studentsApp.dto.StudentInfoBean;

public class StudentsDAO {
	public void insert(StudentInfoBean bean) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=tiger");
			pstmt=con.prepareStatement("insert into jeje19.student06 values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPhone());
			pstmt.setString(4, bean.getEmail());
			pstmt.setString(5, bean.getDegree());
			pstmt.setInt(6, bean.getYop());
			pstmt.setString(7, bean.getPassword());
			pstmt.setString(8, bean.getIsAdmin());
			int cout=pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			if (pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
