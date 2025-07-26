package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {

	private static String url = "jdbc:mysql://localhost:3306/foodapp";
	private static String username ="root";
	private static String password = "Jacop@15";
	private static Connection connection;
	
	
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection  = DriverManager.getConnection(url,username,password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}	
}


