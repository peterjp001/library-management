package com.biblio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

public class dbConnection {
	
//	private static String jdbcURL = "jdbc:mysql://localhost:3306/gestionbibliouneph?useSSL=false;useUnicode=yes&characterEncoding=UTF-8";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "";
	
	protected static  Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio?characterEncoding=UTF-8",jdbcUsername, jdbcPassword);
//			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}
