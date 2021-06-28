package jdbc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = getMyConnection();
		int choice = 0;
		while (choice != 4) {
			System.out.println("Chào mừng bạn đến với chương trình Quản Lý Học Sinh");
			System.out.println("------------------ * * * ------------------");
			System.out.println("1. Thêm mới học sinh");
			System.out.println("2. Danh sách học sinh");
			System.out.println("3. Tìm kiếm theo ID");
			System.out.println("4. Thoát");
			System.out.println("Mời bạn chọn chức năng: ");
			Scanner sc = new Scanner(System.in);
			try {
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Thêm mới học sinh");
					createNewStudent(conn);
					System.out.println("------------------------");
					break;
				case 2:
					System.out.println("Danh sách học sinh");
					displayList(conn);
					System.out.println("------------------------");
					break;
				case 3:
					System.out.println("Tìm kiếm học sinh theo ID");
					searchByID(conn);
					System.out.println("------------------------");
					break;
				case 4:
					System.out.println("Cảm ơn bạn đã sử dụng chương trình.");
					System.out.println("Vui lòng đánh giá chúng tôi 5* nhé!");
					break;
				default:
					System.err.println("Không có chức năng tương ứng, mời bạn chọn lại!");
					break;
				}
			} catch (Exception e) {
				System.err.println("Mời bạn nhập chính xác các chức năng được hiển thị!");
			}
		}
	}
	
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException {
		Connection connection = MySQLConnectionUtils.getMySQLConnection();
		return connection;
	}
	
	public static List<HocSinh> getAll(Connection connection) throws SQLException, ParseException {
		String sql = "SELECT * FROM HocSinh;";
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<HocSinh> listStudent = new ArrayList<HocSinh>();
		while (rs.next()) {
			int mhs = rs.getInt("id");
			String hoTen = rs.getString("name");
			String email = rs.getString("email");
			int tuoi = rs.getInt("age");
			String sdt = rs.getString("phoneNumber");
			String xepLoai = rs.getString("rank");
			String doituyenHSG = rs.getString("teamHSG");
			float diemTrungBinh = rs.getFloat("avgMark");
			float diemThapNhat = rs.getFloat("worstMark");
			Date ngayHPH = rs.getDate("meetingDate");
			
			if ("GIOI".equals(xepLoai)) {
				HocSinhGioi student = new HocSinhGioi();
				student.setID(mhs);
				student.setName(hoTen);
				student.setEmail(email);
				student.setAge(tuoi);
				student.setPhoneNum(sdt);
				student.setRank(xepLoai);
				student.setDoiTuyenHSG(EDoiTuyen.fromValue(doituyenHSG));
				listStudent.add(student);		
			}
			if ("KHA".equals(xepLoai)) {
				HocSinhKha student = new HocSinhKha();
				student.setID(mhs);
				student.setName(hoTen);
				student.setEmail(email);
				student.setAge(tuoi);
				student.setPhoneNum(sdt);
				student.setRank(xepLoai);
				student.setAvg(diemTrungBinh);
				listStudent.add(student);
			}
			if ("YEU".equals(xepLoai)) {
				HocSinhYeu student = new HocSinhYeu();
				student.setID(mhs);
				student.setName(hoTen);
				student.setEmail(email);
				student.setAge(tuoi);
				student.setPhoneNum(sdt);
				student.setRank(xepLoai);
				student.setBadMark(diemThapNhat);
				student.setHopPH(ngayHPH);
				listStudent.add(student);
			}
		}
		return listStudent;
	}
	
	public static void displayList(Connection connection) throws SQLException, ParseException {
		List<HocSinh> listStudent = getAll(connection);
		for (HocSinh hocSinh : listStudent) {
			System.out.println(hocSinh);
		}
	}
	
	public static void createNewStudent(Connection connection) {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("------------------------");
				System.out.println("1. Them moi hoc sinh gioi");
				System.out.println("2. Them moi hoc sinh kha");
				System.out.println("3. Them moi hoc sinh yeu");
				System.out.println("Moi ban chon chuc nang: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("HSG");
					createHSG(connection);
					break;
				case 2:
					System.out.println("HSK");
					createHSK(connection);
					break;
				case 3:
					System.out.println("HSY");
					createHSY(connection);
					break;
				default:
					System.err.println("Chuc nang khong chinh xac, moi ban nhap lai!");
					break;
				}
			} catch (Exception e) {
				System.err.println("Moi ban nhap chinh xac chuc nang!");
			}
		}
	}
	
	public static void createHSG(Connection connection) throws SQLException {
		String sql = "INSERT INTO `HocSinh` (`name`, email, age, phoneNumber, teamHSG, `rank`)  "
								+ "VALUES 	(?,		 ?,		?,	 ?,			  ?,		\"GIOI\")";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten hoc sinh: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email cua hoc sinh: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap so dien thoai cua hoc sinh: ");
		String phoneNum = sc.nextLine();
		System.out.println("Moi ban nhap doi tuyen HSG: ");
		String teamHSG = sc.nextLine();
		System.out.println("Moi ban nhap tuoi hoc sinh: ");
		int age = sc.nextInt();
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, age);
		ps.setString(4, phoneNum);
		ps.setString(5, teamHSG);
		int effectedRecordAmount = ps.executeUpdate();
		System.out.println("So luong ban ghi thay doi (Tao moi hoc sinh): " + effectedRecordAmount);
	}
	
	public static void createHSK(Connection connection) throws SQLException {
		String sql = "INSERT INTO `HocSinh` (`name`, email, age, phoneNumber, avgMark, `rank`)  "
								+ "VALUES 	(?,		 ?,		?,	 ?,			  ?,		\"KHA\")";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten hoc sinh: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email cua hoc sinh: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap so dien thoai cua hoc sinh: ");
		String phoneNum = sc.nextLine();
		System.out.println("Moi ban nhap tuoi hoc sinh: ");
		int age = sc.nextInt();
		System.out.println("Moi ban nhap diem trung binh cua hoc sinh: ");
		float avg = sc.nextFloat();
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, age);
		ps.setString(4, phoneNum);
		ps.setFloat(5, avg);
		int effectedRecordAmount = ps.executeUpdate();
		System.out.println("So luong ban ghi thay doi (Tao moi hoc sinh): " + effectedRecordAmount);
	}
	
	public static void createHSY(Connection connection) throws SQLException, ParseException {
		String sql = "INSERT INTO `HocSinh` (`name`, email, age, phoneNumber, worstMark, meetingDate, `rank`)  "
								+ "VALUES 	(?,		 ?,		?,	 ?,			  ?,	  	? 			,\"KHA\")";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten hoc sinh: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email cua hoc sinh: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap so dien thoai cua hoc sinh: ");
		String phoneNum = sc.nextLine();
		System.out.println("Moi ban nhap ngay hop phu huynh (yyyy-MM-dd): ");
		String date = sc.nextLine();
		System.out.println("Moi ban nhap tuoi hoc sinh: ");
		int age = sc.nextInt();
		System.out.println("Moi ban nhap diem thap nhat cua hoc sinh: ");
		float bad = sc.nextFloat();
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, age);
		ps.setString(1, phoneNum);
		ps.setFloat(4, bad);
		ps.setString(6, date);
		int effectedRecordAmount = ps.executeUpdate();
		System.out.println("So luong ban ghi thay doi (Tao moi hoc sinh): " + effectedRecordAmount);
	}
	
	public static void searchByID(Connection connection) throws SQLException, ParseException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ID hoc sinh can tim kiem: ");
		int searchID = sc.nextInt();
		boolean isFound = false;
		List<HocSinh> listStudent = getAll(connection);
		for (HocSinh hocSinh : listStudent) {
			if (searchID == hocSinh.getId()) {
				System.out.println(hocSinh);
				isFound = true;
			}
		}
		if (!isFound) {
			System.out.println("Khong tim thay thong tin hoc sinh co ID: " + searchID);
		}
	}
}
