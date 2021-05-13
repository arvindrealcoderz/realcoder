package com.realcoderz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Mysql {

	
	public static Connection getConnection() {
		Connection con=null;
		//Load and register jdbc driver
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Established the connection
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/realcoderz","root","root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//check conn is null or not 
		return con;
	}

}
