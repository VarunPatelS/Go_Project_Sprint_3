package org.jecm15.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import java.sql.DatabaseMetaData;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Direct2nsStep {

	public static void main(String[] args) {

		
		try {
			DataSource ds = new MysqlDataSource();
			
			Connection con = ds.getConnection("root", "admin");
			DatabaseMetaData dm = con.getMetaData();
			String version = dm.getDatabaseProductVersion();
			System.out.println("the version is "+version);
			String name = dm.getDriverName();
			System.out.println("the name is "+name);
			String DatabaseProductName = dm.getDatabaseProductName();
			System.out.println("the name is "+DatabaseProductName);
			String UrlName = dm.getURL();
			System.out.println("the name is "+UrlName);
			Boolean Procedure = dm.allProceduresAreCallable();
			System.out.println("the name is "+Procedure);
						
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
