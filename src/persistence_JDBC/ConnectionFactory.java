package persistence_JDBC;

import java.sql.*;

public class ConnectionFactory {
	private static String USERNAME = "root";
	private static String PASSWORD = "0312";
	private static String URL = "jdbc:mysql://localhost:3306/assignment_db";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			throw new RuntimeException("Error " + e);
		}
	}
	
	public static Connection getConnection(String url, String username, String password) {
		try {
			return DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			throw new RuntimeException("Error " + e);
		}
	}
	
	
	
	
}
