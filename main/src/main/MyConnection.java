package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
 public static Connection getConnection() {
	
	 Connection conn = null;
	 
	 try {
	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/stdmgdb", "root", "");
		System.out.println("Conn succ");
		
	} catch (Exception e) {
		System.out.println(e);
	}
	 return conn;
}


}
 