package com.vti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtils {
	
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "CANDIDATE";
		String username = "root";
		String password = "root";
		return getMySQLConnection(hostName, dbName, username, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String username, String password) throws SQLException, ClassNotFoundException {
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useSSL=false";
		Connection conn = DriverManager.getConnection(connectionURL, username, password);
		return conn;
	}
}
