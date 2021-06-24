package jdbc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection ... ");
		Connection conn = getMyConnection();
		getHocSinh(conn);
		conn.close();
	}
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException{
		return MySQLConnUtils.getMySQLConnection();
	}
	
	public static void getHocSinh(Connection connection) throws SQLException {
		//Tạo một String câu lệnh MySQL
		String sql = "SELECT id, hoTen, email, sdt FROM HocSinh WHERE id = 1 ";
		String pSql = "SELECT id, hoTen, email, sdt FROM HocSinh WHERE id = ? OR email LIKE ? ";
		// Tạo đối tượng statement
		Statement statement = connection.createStatement();
		/* Đối với đối tượng chưa xác định (muốn truyền tham số vào câu lệnh SQL thì không sử dụng Statement)
		 Tạo đối tượng PreparedStatement để sử dụng với câu lệnh SQL cần truyền tham số */
		PreparedStatement pStatement = connection.prepareStatement(pSql);
		
		// Đặt giá trị cho dấu ? (questionMark index, value) *questionMark index bắt đầu từ 1
		pStatement.setInt(1, 5);
		pStatement.setString(2, "h%");
		
		// Thực thi câu lệnh SQL trả về đối tượng ResultSet
		ResultSet rs = statement.executeQuery(sql); // đối với Statement thì cần truyền vào câu lệnh
		ResultSet prs = pStatement.executeQuery(); // đối với Prepared Statement thì KHÔNG truyền câu lệnh
		
		// Duyệt trên kết quả trả về
			// sử dụng đối tượng Statement
		while (rs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
			int mhs = rs.getInt("id");
			String hoTen = rs.getString("hoTen");
			String email = rs.getString("email");
			String sdt = rs.getString("sdt");
			System.out.println("------------------------");
			System.out.println("ID hoc sinh: " + mhs);
			System.out.println("Ho ten: : " + hoTen);
			System.out.println("Email: " + email);
			System.out.println("So dien thoai: " + sdt);
		}
			// sử dụng đối tượng PreparedStatement
		while (prs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
			int mhs = prs.getInt("id");
			String hoTen = prs.getString("hoTen");
			String email = prs.getString("email");
			String sdt = prs.getString("sdt");
			System.out.println("------------------------");
			System.out.println("ID hoc sinh: " + mhs);
			System.out.println("Ho ten: : " + hoTen);
			System.out.println("Email: " + email);
			System.out.println("So dien thoai: " + sdt);
		}
	}
}
