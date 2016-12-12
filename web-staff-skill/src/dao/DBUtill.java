package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtill {
	
	public static final String url;
	public static final String user;
	public static final String password;
	static{
		url = "jdbc:mysql://127.0.0.1:3306/dev22db";
		user = "root";
		password = "java0000";
	}
	
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn;
		
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("url :"+url);
		conn = DriverManager.getConnection(url, user, password);
	System.out.println("db연결확인 conn : " + conn);
	return conn;

	}
}
