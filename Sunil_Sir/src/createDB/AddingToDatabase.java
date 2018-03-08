package createDB;

	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.Reader;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class AddingToDatabase {

		public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
			Connection con=null;
			Statement stmt=null;
		FileReader f=new FileReader("e://varu/a.txt");
			try {
				Scanner sc=new Scanner(f);
				BufferedReader br = new BufferedReader(f);
				String st;
				while ((st = br.readLine()) != null) {
		            System.out.println(st);
		            String[] word=st.split(",");
		            System.out.println(word.toString());
				}
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
				stmt=con.createStatement();
				
				
			} catch (SQLException | IOException e) {
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
				if(stmt!=null)
				{
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}
	
	

