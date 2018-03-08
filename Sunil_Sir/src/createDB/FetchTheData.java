package createDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchTheData {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String str="select * from student.data ";
		String str1="select * from student.colldata ";
		String str2="select a.*,b.* from student.data a, student.collData b where a.id=b.id";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection done");
			
			pstmt=con.prepareStatement(str2);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name=rs.getString(2);
				String course=rs.getString(3);
				//String name1=rs.getString(6);
				String college=rs.getString(7);
								
				
				System.out.println(id+"  "+name+"  "+course+"  "+college);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
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
