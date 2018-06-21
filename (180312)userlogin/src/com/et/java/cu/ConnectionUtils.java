package com.et.java.cu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static Connection conn = null;

	public static synchronized Connection getConnection(){
		
		if(conn == null){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/et_student", "root", "sa");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
}
