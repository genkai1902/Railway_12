package com.vti.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.vti.entity.EDoiTuyen;
import com.vti.entity.HocSinh;
import com.vti.entity.HocSinhGioi;
import com.vti.entity.HocSinhKha;
import com.vti.entity.HocSinhYeu;
import com.vti.utils.MySQLConnectionUtils;

public class HocSinhRepository implements IHocSinhRepository{
	private MySQLConnectionUtils jdbcUtils;
	public HocSinhRepository() {
		jdbcUtils = new MySQLConnectionUtils();
	}

	public List<HocSinh> getAll() throws ClassNotFoundException, SQLException, ParseException {
		String sql = "SELECT * FROM HocSinh;";
		Connection connection = jdbcUtils.getMySQLConnection();
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

	public void createHSG() throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `HocSinh` (`name`, email, age, phoneNumber, teamHSG, `rank`)  "
				+ "VALUES 	(?,		 ?,		?,	 ?,			  ?,		\"GIOI\")";
		Connection connection = jdbcUtils.getMySQLConnection();
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

	public void createHSK() throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `HocSinh` (`name`, email, age, phoneNumber, avgMark, `rank`)  "
				+ "VALUES 	(?,		 ?,		?,	 ?,			  ?,		\"KHA\")";
		Connection connection = jdbcUtils.getMySQLConnection();
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

	public void createHSY() throws ClassNotFoundException, SQLException, ParseException {
		String sql = "INSERT INTO `HocSinh` (`name`, email, age, phoneNumber, worstMark, meetingDate, `rank`)  "
				+ "VALUES 	(?,		 ?,		?,	 ?,			  ?,	  	? 			,\"KHA\")";
		Connection connection = jdbcUtils.getMySQLConnection();
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

}
