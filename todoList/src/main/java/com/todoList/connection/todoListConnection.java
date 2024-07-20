package com.todoList.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class todoListConnection {
	
	public static Connection getListItems() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return  DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Error in connection class");
			
			return null;
		}
	}
	
	
}
