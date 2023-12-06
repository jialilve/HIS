package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String jbdcstr="com.mysql.jdbc.Driver";
	public static Connection getConnection() 
	{
		 try
		{
	     
		 Class.forName(jbdcstr); 
		 String url="";
		 String username="";
		 String password="";
		 Connection connection=DriverManager.getConnection(url,username,password);
		 return connection;
		} 
		 catch (ClassNotFoundException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		 
	}
  
}
