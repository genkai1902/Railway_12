package com.vti.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vti.entity.ExperienceCandidate;
import com.vti.entity.FresherCandidate;
import com.vti.utils.MySQLConnectionUtils;
import com.vti.utils.ScannerUtils;

public class CandidateRepository implements ICandidateRepository{
	private MySQLConnectionUtils jdbcUtils;
	private ScannerUtils scannerutils;
	public CandidateRepository() {
		jdbcUtils = new MySQLConnectionUtils();
	}

	@Override
	public void login() throws Exception {
		String sql = "SELECT firstName, lastName, email, phone, `password`, `role`, expInYear, proSkill, graduateRank FROM Candidates WHERE email LIKE ? AND `password` LIKE ?";
		Connection conn = jdbcUtils.getMySQLConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("Mời bạn nhập vào email: ");
		ps.setString(1, scannerutils.inputEmail("Địa chỉ email không hợp lệ"));
		System.out.println("Moi ban nhap vao mat khau: ");
		ps.setString(2, scannerutils.inputPassword("Định dạng mật khẩu không chính xác"));
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			System.out.println("Login thành công!");
			int id = rs.getInt(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);		
			String email = rs.getString(4);
			String phone = rs.getString(5);
			
			String role = rs.getString(7);
			int expInYear = rs.getInt(8);			
			String graduationRank = rs.getString(9);		
			String proSkill = rs.getString(10);		
			
			
			if ("EXP".equals(role)) {
				ExperienceCandidate candidate = new ExperienceCandidate();
				candidate.setId(id);
				candidate.setFirstName(firstName);
				candidate.setLastName(lastName);
				candidate.setEmail(email);
				candidate.setPhone(phone);
				candidate.setProSkill(proSkill);
				candidate.setExpInYear(expInYear);
				System.out.println(candidate);
			} else {
				FresherCandidate candidate = new FresherCandidate();
				candidate.setId(id);
				candidate.setFirstName(firstName);
				candidate.setLastName(lastName);
				candidate.setEmail(email);
				candidate.setPhone(phone);
				candidate.setRank(graduationRank);
				System.out.println(candidate);
			}
		} else {
			System.out.println("Sai địa chỉ email hoặc mật khẩu.");
		}
	}

	@Override
	public void addNewExpCandidate() throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Candidates ( firstName, lastName, email, phone, `password`, `role`, expInYear, proSkill, graduateRank ) VALUES ( ?, ?, ?, ?, ?, 'EXP', ?, ?, NULL);";
		Connection conn = jdbcUtils.getMySQLConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("Mời bạn nhập vào họ ứng viên: ");
		ps.setString(1, scannerutils.inputString());
		System.out.println("Mời bạn nhập vào tên ứng viên: ");
		ps.setString(2, scannerutils.inputString());
		System.out.println("Mời bạn nhập vào email của ứng viên: ");
		ps.setString(3, scannerutils.inputEmail("Định dạnh của email chưa chính xác, mời bạn nhập lại!"));
		System.out.println("Mời bạn nhập vào số điện thoại của ứng viên: ");
		ps.setString(4, scannerutils.inputPhoneNumber("Số điện thoại không hợp lệ, mời bạn nhập lại!"));
		System.out.println("Mời bạn nhập vào mật khẩu: ");
		ps.setString(5, scannerutils.inputPassword("Mật khẩu bắt buộc phải có 1 ký tự in hoa!"));
		System.out.println("Mời bạn nhập vào kỹ năng chuyên môn: ");
		ps.setString(7, scannerutils.inputString());
		System.out.println("Mời bạn nhập vào số năm kinh nghiệm: ");
		ps.setInt(6, scannerutils.inputPositiveInt("Số năm kinh nghiệm không hợp lệ, mời bạn nhập lại!"));
		
		int effRA = ps.executeUpdate();
		System.out.println("Số ứng viên thêm mới thành công: " + effRA);
	}

	@Override
	public void addNewFresherCandidate() throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO Candidates ( firstName, lastName, email, phone, `password`, `role`, expInYear, proSkill, graduateRank ) VALUES ( ?, ?, ?, ?, ?, 'FRESHER', NULL, NULL, ?);";
		Connection conn = jdbcUtils.getMySQLConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		System.out.println("Mời bạn nhập vào họ ứng viên: ");
		ps.setString(1, scannerutils.inputString());
		System.out.println("Mời bạn nhập vào tên ứng viên: ");
		ps.setString(2, scannerutils.inputString());
		System.out.println("Mời bạn nhập vào email của ứng viên: ");
		ps.setString(3, scannerutils.inputEmail("Định dạnh của email chưa chính xác, mời bạn nhập lại!"));
		System.out.println("Mời bạn nhập vào số điện thoại của ứng viên: ");
		ps.setString(4, scannerutils.inputPhoneNumber("Số điện thoại không hợp lệ, mời bạn nhập lại!"));
		System.out.println("Mời bạn nhập vào mật khẩu: ");
		ps.setString(5, scannerutils.inputPassword("Mật khẩu bắt buộc phải có 1 ký tự in hoa!"));
		System.out.println("Mời bạn nhập vào hạng tốt nghiệp (Excellent - Good - Fair - Poor): ");
		ps.setString(6, scannerutils.inputString().toUpperCase());
		
		int effRA = ps.executeUpdate();
		System.out.println("Số ứng viên thêm mới thành công: " + effRA);
	}

}
