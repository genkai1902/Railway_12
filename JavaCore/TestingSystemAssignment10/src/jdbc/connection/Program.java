package jdbc.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection ... ");
		Connection conn = getMyConnection();
		int choice = 0;
		while (choice != 5) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Chao mung ban den voi chuong trinh Quan Ly Hoc Sinh");
			System.out.println("------------------ * * * ------------------");
			System.out.println("1. Danh sach hoc sinh");
			System.out.println("2. Them moi hoc sinh");
			System.out.println("3. Tim kiem theo ID");
			System.out.println("4. Sua thong tin hoc sinh");
			System.out.println("5. Thoat");
			System.out.println("Moi ban chon chuc nang: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				displayList(conn);
				break;
			case 2:
				createNewStudent(conn);
				break;
			case 3:
				displayStudentByID(conn);
				break;
			case 4:
				displayStudentByID(conn);
				break;
			default:
				break;
			}
		}
		System.out.println("Cam on ban da su dung dich vu!");
		conn.close();
	}

	public static List<Hocsinh> getHocSinh(Connection connection) throws SQLException {
		String sql = "SELECT id, hoTen, email, tuoi, sdt, doituyenHSG, diemTB, diemThapNhat, ngayMoiPH, xepLoai FROM HocSinh";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		ResultSet rs = pStatement.executeQuery();
		List<Hocsinh> listStudent = new ArrayList<Hocsinh>();
		while (rs.next()) { 
			int mhs = rs.getInt("id");
			String hoTen = rs.getString("hoTen");
			String email = rs.getString("email");
			int tuoi = rs.getInt("tuoi");
			String sdt = rs.getString("sdt");
			String xepLoai = rs.getString("xepLoai");
			String doiTuyenHSG = rs.getString("doituyenHSG");
			float diemTrungBinh = rs.getFloat("diemTB");
			float diemThapNhat = rs.getFloat("diemThapNhat");
			Date ngayHPH = rs.getDate("ngayMoiPH");
			
			if ("GIOI".equals(xepLoai)) {
				HocSinhGioi hocSinh = new HocSinhGioi();
				hocSinh.setId(mhs);
				hocSinh.setName(hoTen);
				hocSinh.setEmail(email);
				hocSinh.setAge(tuoi);
				hocSinh.setPhoneNum(sdt);
				hocSinh.setLoaiHS(xepLoai);
				hocSinh.setDoiTuyenHSG(EDoiTuyen.fromValue(doiTuyenHSG));
				listStudent.add(hocSinh);
			}
			
			if ("KHA".equals(xepLoai)) {
				HocSinhKha hocSinh = new HocSinhKha();
				hocSinh.setId(mhs);
				hocSinh.setName(hoTen);
				hocSinh.setEmail(email);
				hocSinh.setAge(tuoi);
				hocSinh.setPhoneNum(sdt);
				hocSinh.setLoaiHS(xepLoai);
				hocSinh.setAvgMark(diemTrungBinh);
				listStudent.add(hocSinh);
			}
			
			if ("YEU".equals(xepLoai)) {
				HocSinhYeu hocSinh = new HocSinhYeu();
				hocSinh.setId(mhs);
				hocSinh.setName(hoTen);
				hocSinh.setEmail(email);
				hocSinh.setAge(tuoi);
				hocSinh.setPhoneNum(sdt);
				hocSinh.setLoaiHS(xepLoai);
				hocSinh.setBadMark(diemThapNhat);
				hocSinh.setMeetingDate(ngayHPH);
				listStudent.add(hocSinh);
			}
		}
		return listStudent;
	}

	public static void displayList(Connection connection) throws SQLException {
		List<Hocsinh> listHS = getHocSinh(connection);
		for (Hocsinh hocsinh : listHS) {
			System.out.println(hocsinh);
		}
	}
	
	public static void createNewStudent(Connection connection) throws SQLException, ClassNotFoundException {
		System.out.println("Ban da chon chuc nang \"Them moi hoc sinh\"");
		System.out.println("Chon 1 de them moi hoc sinh gioi.");
		System.out.println("Chon 2 de them moi hoc sinh kha.");
		System.out.println("Chon 3 de them moi hoc sinh yeu.");
		System.out.println("Chon 0 de quay lai menu chinh.");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
//		case 0:
//			main(null);
//			break;
		case 1:
			createHSG(connection);
			break;
		case 2:
			createHSK(connection);
			break;
		case 3:
			createHSY(connection);
			break;
		default:
			break;
		}
		
	}
	
	public static void createHSG(Connection connection) throws SQLException {
		String sql = "INSERT INTO `HocSinh` (hoTen, email, tuoi, sdt, doiTuyenHSG, xepLoai) VALUES (?, ?, ?, ?, ?, \"GIOI\")";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		// input from scanner
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		String hoTen = sc.nextLine();
		System.out.println("Moi ban nhap email: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Moi ban nhap vao doi tuyen HSG: ");
		String doiTuyenHSG = sc.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		int tuoi = sc.nextInt();
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
		String sql = "INSERT INTO `HocSinh` (hoTen, email, tuoi, sdt, diemTB, xepLoai) VALUES (?, ?, ?, ?, ?, \"KHA\")";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		String hoTen = sc.nextLine();
		System.out.println("Moi ban nhap email: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		int tuoi = sc.nextInt();
		System.out.println("Moi ban nhap diem trung binh: ");
		float diemTB = sc.nextFloat();

		pStatement.setString(1, hoTen);
		pStatement.setString(2, email);
		pStatement.setInt(3, tuoi);
		pStatement.setString(4, sdt);
		pStatement.setFloat(5, diemTB);

		int effectedRecordAmount = pStatement.executeUpdate();

		System.out.println("Effected Record Amount (Create Hoc Sinh): " + effectedRecordAmount);
	}

	public static void createHSY(Connection connection) throws SQLException {
		String sql = "Insert into HocSinh (hoTen, email, tuoi, sdt, diemThapNhat, ngayMoiPH, xepLoai) VALUES (?,?,?,?,?,?, \"YEU\")";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Moi ban nhap vao ngay hop phu huynh (theo dinh dang \"yyyy-MM-dd\"");
		String date = sc.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		int tuoi = sc.nextInt();
		System.out.println("Moi ban nhap diem trung binh: ");
		float badMark = sc.nextFloat();
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, tuoi);
		ps.setString(4, sdt);
		ps.setFloat(5, badMark);
		ps.setString(6, date);
		int eff = ps.executeUpdate();
		System.out.println("Effected Record Amount (Create Hoc Sinh): " + eff);
	}

	public static void displayStudentByID(Connection connection) throws SQLException {
		List<Hocsinh> listStudent = getHocSinh(connection);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Moi ban nhap vao ID hoc sinh: ");
		int searchID = sc.nextInt();
		boolean found = false;
		for (Hocsinh hocsinh : listStudent) {
			if (searchID == hocsinh.getId()) {
				System.out.println(hocsinh);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Khong co hoc sinh nao co ID = " + searchID);
		}
	}
	
	public static void updateStudent(Connection connection) throws SQLException {
		System.out.println("Moi ban nhap vao ID cua hoc sinh can sua thong tin: ");
		Scanner sc =  new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Moi ban nhap vao xep loai hoc sinh: ");
		String xepLoai = sc.next();
		if (xepLoai.equalsIgnoreCase("GIOI")) {
			updateHSG(connection, id);
		} else if (xepLoai.equalsIgnoreCase("KHA")) {
			updateHSK(connection, id);
		} else {
			updateHSY(connection, id);
		}
	}
	
	public static void updateHSG(Connection connection, int id) throws SQLException {
		String sql = "UPDATE `hocsinh` SET `hoTen` = ?, `email` = ?, `tuoi` = ?, `sdt` = ?, `doituyenHSG` = ? WHERE `id` = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Moi ban nhap vao doi tuyen HSG: ");
		String doiTuyenHSG = sc.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		int tuoi = sc.nextInt();
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, tuoi);
		ps.setString(4, sdt);
		ps.setString(5, doiTuyenHSG);
		ps.setInt(6, id);
		int effectedRecordAmount = ps.executeUpdate();
		System.out.println("Effected Record Amount (Update Hoc Sinh): " + effectedRecordAmount);
	}
	
	public static void updateHSK(Connection connection, int id) throws SQLException {
		String sql = "Update `HocSinh` Set hoTen = ? , email = ?, tuoi = ?, sdt = ?, diemTB = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		int tuoi = sc.nextInt();
		System.out.println("Moi ban nhap diem trung binh: ");
		float avg = sc.nextFloat();
		
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, tuoi);
		ps.setString(4, sdt);
		ps.setFloat(5, avg);
		ps.setInt(6, id);
		
		int eff = ps.executeUpdate();
		System.out.println("Effected Record Amount (Update Hoc Sinh): " + eff);
	}
	
	public static void updateHSY(Connection connection, int id) throws SQLException {
		String sql = "Update `HocSinh` Set hoTen = ?, email = ?, tuoi = ?, sdt = ?, diemThapNhat = ?, ngayMoiPH = ? WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap ten: ");
		String name = sc.nextLine();
		System.out.println("Moi ban nhap email: ");
		String email = sc.nextLine();
		System.out.println("Moi ban nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Moi ban nhap vao ngay hop phu huynh (theo dinh dang \"yyyy-MM-dd\"");
		String date = sc.nextLine();
		System.out.println("Moi ban nhap tuoi: ");
		int age = sc.nextInt();
		System.out.println("Moi ban nhap diem trung binh: ");
		float badMark = sc.nextFloat();
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3, age);
		ps.setString(4, sdt);
		ps.setFloat(5, badMark);
		ps.setString(6, date);
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
