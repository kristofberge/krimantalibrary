package com.krimanta.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection conn;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC Driver found");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found");
			e.printStackTrace();
			return null;
		}

		if (conn != null)
			return conn;
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "krimanta",
					"6Miljoen");
			System.out.println("DB connection established");
		} catch (SQLException e) {
			System.out.println("DB connection failed");
			e.printStackTrace();
		}
		
		return conn;

	}

}
