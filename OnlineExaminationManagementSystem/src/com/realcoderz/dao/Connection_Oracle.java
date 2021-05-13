package com.realcoderz.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_Oracle {
	
	public static Connection getConnection() throws Exception{
		Connection con=null;
		//Load and register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Established the connection
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "Arvind");
		//check conn is null or not 
		return con;
	}

}
