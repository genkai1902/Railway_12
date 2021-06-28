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
//		createHSG(conn);
//		updateHSG(conn);
//		createHSK(conn);
//		updateHSK(conn);
//		createHSY(conn);
//		updateHSY(conn);
		deleteHocSinh(conn);
		getHocSinh(conn);
		conn.close();
	}

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void getHocSinh(Connection connection) throws SQLException {
		// Tạo một String câu lệnh MySQL
		String sql = "SELECT id, hoTen, email, sdt FROM HocSinh";
//		String pSql = "SELECT id, hoTen, email, sdt FROM HocSinh WHERE id = ? OR email LIKE ? ";
		// Tạo đối tượng statement
		Statement statement = connection.createStatement();
		/*
		 * Đối với đối tượng chưa xác định (muốn truyền tham số vào câu lệnh SQL thì
		 * không sử dụng Statement) Tạo đối tượng PreparedStatement để sử dụng với câu
		 * lệnh SQL cần truyền tham số
		 */
//		PreparedStatement pStatement = connection.prepareStatement(pSql);

		// Đặt giá trị cho dấu ? (questionMark index, value) *questionMark index bắt đầu
		// từ 1
//		pStatement.setInt(1, 9);
//		pStatement.setString(2, "doanh%");

		// Thực thi câu lệnh SQL trả về đối tượng ResultSet
		ResultSet rs = statement.executeQuery(sql); // đối với Statement thì cần truyền vào câu lệnh
//		ResultSet prs = pStatement.executeQuery(); // đối với Prepared Statement thì KHÔNG truyền câu lệnh

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
//		while (prs.next()) { // Di chuyển con trỏ xuống bản ghi kế tiếp
//			int mhs = prs.getInt("id");
//			String hoTen = prs.getString("hoTen");
//			String email = prs.getString("email");
//			String sdt = prs.getString("sdt");
//			System.out.println("------------------------");
//			System.out.println("ID hoc sinh: " + mhs);
//			System.out.println("Ho ten: : " + hoTen);
//			System.out.println("Email: " + email);
//			System.out.println("So dien thoai: " + sdt);
		}

	public static void createHSG(Connection connection) throws SQLException {
		String sql = "INSERT INTO `HocSinh` (hoTen, email, tuoi, sdt, doiTuyenHSG) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		// input from scanner
		String hoTen = "Trach Van Doanh";
		String email = "doanhtv@vnext.com";
		int tuoi = 21;
		String sdt = "0968555111";
		String doiTuyenHSG = "toan";
		// set parameters
		pStatement.setString(1, hoTen);
		pStatement.setString(2, email);
		pStatement.setInt(3, tuoi);
		pStatement.setString(4, sdt);
		pStatement.setString(5, doiTuyenHSG);
		// execute SQL query
		int effectedRecordAmount = pStatement.executeUpdate();
		// handling result set
		System.out.println("Effected Record Amount (Create Hoc Sinh): " + effectedRecordAmount);
	}

	public static void createHSK(Connection connection) throws SQLException {
		String sql = "INSERT INTO `HocSinh` (hoTen, email, tuoi, sdt, diemTB) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);

		String hoTen = "Nguyen Chau Giang";
		String email = "giangnc@gmail";
		int tuoi = 18;
		String sdt = "097...";
		float diemTB = 6.0f;

		pStatement.setString(1, hoTen);
		pStatement.setString(2, email);
		pStatement.setInt(3, tuoi);
		pStatement.setString(4, sdt);
		pStatement.setFloat(5, diemTB);

		int effectedRecordAmount = pStatement.executeUpdate();

		System.out.println("Effected Record Amount (Create Hoc Sinh): " + effectedRecordAmount);
	}

	public static void createHSY(Connection connection) throws SQLException {
		String sql = "Insert into HocSinh (hoTen, email, tuoi, sdt, diemThapNhat, ngayMoiPH) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		String name = "tien";
		String email = "fairy@gmail";
		int tuoi = 18;
		String sdt = "096...";
		float badMark = 4.0f;
		String date = "2021-06-30";
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, tuoi);
		ps.setString(4, sdt);
		ps.setFloat(5, badMark);
		ps.setString(6, date);
		int eff = ps.executeUpdate();
		System.out.println("Effected Record Amount (Create Hoc Sinh): " + eff);
	}

	public static void updateHSG(Connection connection) throws SQLException {
		String sql = "UPDATE `hocsinh` SET `hoTen` = ?, `email` = ?, `tuoi` = ?, `sdt` = ?, `doituyenHSG` = ? WHERE `id` = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		String name = "Le Chi Pheo";
		String email = "pheolc@gmail";
		int tuoi = 19;
		String sdt = "9999";
		String dtHSG = "hoa";
		int id = 9;
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, tuoi);
		ps.setString(4, sdt);
		ps.setString(5, dtHSG);
		ps.setInt(6, id);
		int effectedRecordAmount = ps.executeUpdate();
		System.out.println("Effected Record Amount (Update Hoc Sinh): " + effectedRecordAmount);
	}
	
	public static void updateHSK(Connection connection) throws SQLException {
		String sql = "Update `HocSinh` Set hoTen = ? , email = ?, tuoi = ?, sdt = ?, diemTB = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		String name = "chau giang";
		String email = "jin@gmail";
		int tuoi = 17;
		String sdt = "000";
		float avg = 6.5f;
		int id = 10;
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, tuoi);
		ps.setString(4, sdt);
		ps.setFloat(5, avg);
		ps.setInt(6, id);
		
		int eff = ps.executeUpdate();
		System.out.println("Effected Record Amount (Update Hoc Sinh): " + eff);
	}
	
	public static void updateHSY(Connection connection) throws SQLException {
		String sql = "Update `HocSinh` Set hoTen = ?, email = ?, tuoi = ?, sdt = ?, diemThapNhat = ?, ngayMoiPH = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		String name = "tien";
		String email = "tien@gmail";
		int age = 18;
		String sdt = "093...";
		float badMark = 5.0f;
		String ngayMoiPH = "2021-07-01";
		int id = 11;
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, age);
		ps.setString(4, sdt);
		ps.setFloat(5, badMark);
		ps.setString(6, ngayMoiPH);
		ps.setInt(7, id);
		int eff = ps.executeUpdate();
		System.out.println("Effected Record Amount (Update Hoc Sinh): " + eff);
	}
	
	public static void deleteHocSinh(Connection connection) throws SQLException {
		String sql = "Delete From `HocSinh` WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		int id = 13;
		ps.setInt(1, id);
		int eff = ps.executeUpdate();
		System.out.println("Effected Record Amount (Delete Hoc Sinh): " + eff);
	}
}
