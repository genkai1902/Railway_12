package jdbc.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MySQLPreparedStatement {
	public static void getAllHocSinh(Connection connection) throws SQLException {
		String sql = "SELECT id, hoTen, email, tuoi, sdt FROM HocSinh";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("hoTen");
			String email = rs.getString("tuoi");
			String 
		}
	}

}
