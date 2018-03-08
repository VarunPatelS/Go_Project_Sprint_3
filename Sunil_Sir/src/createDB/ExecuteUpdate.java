package createDB;

import java.sql.*;

public class ExecuteUpdate {

	public static void main(String[] args) 
	{
		String qry="create table test.udent(id int(10),name varchar(20))";
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver");
			//con=DriverManager.getConnection("jdbc:mysql://DESKTOP-VSKAKRK:3306?user=root&password=admin");
			String url="jdbc:mysql://DESKTOP-VSKAKRK:3306";
			String user="root";
			String password="admin";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("GetCon");
			stmt= con.createStatement();
			stmt.executeUpdate(qry);
		} 
		catch (ClassNotFoundException | SQLException e) {	e.printStackTrace();	}
		
	}

}
