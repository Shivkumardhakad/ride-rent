package com.riderent.riderent.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/riderent_db";
	private static final String USERNAME = "root"; 
	private static final String PASSWORD = "Shiv@123"; 

	public static Connection getConnection() {
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver not found!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Fail ho gaya!");
		}
		return connection;
	}
}