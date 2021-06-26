package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtilities {
	// Connect to MySQL
	public static Connection setMySQLConnection() throws SQLException, ClassNotFoundException{
		String hostName = "localhost";
		String dbName = "QLHS";
		String username = "root";
		String password = "root";
		return setMySQLConnection(hostName, dbName, username, password);
	}

	public static Connection setMySQLConnection(String hostName, String dbName, String username, String password) throws SQLException, ClassNotFoundException {
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useSSL=false";
		Connection conn = DriverManager.getConnection(connectionURL, username, password);
		return conn;
	}
}
