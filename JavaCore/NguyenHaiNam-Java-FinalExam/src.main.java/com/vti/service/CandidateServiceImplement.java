package com.vti.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.datalayer.CandidateRepository;
import com.vti.datalayer.ICandidateRepository;

public class CandidateServiceImplement implements ICandidateService{
	
	ICandidateRepository candidateRepo;
	public CandidateServiceImplement() {
		candidateRepo = new CandidateRepository();
	}
	
	@Override
	public void login() throws Exception {
		candidateRepo.login();
	}

	@Override
	public void addNewExpCandidate() throws ClassNotFoundException, SQLException {
		candidateRepo.addNewExpCandidate();
	}

	@Override
	public void addNewFresherCandidate() throws ClassNotFoundException, SQLException {
		candidateRepo.addNewFresherCandidate();	
	}

	@Override
	public void addNewCandidate() {
		while (true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("------------------------");
				System.out.println("1. Thêm mới ứng viên có kinh nghiệm");
				System.out.println("2. Thêm mới ứng viên chưa có kinh nghiệm");
				System.out.println("Mời bạn chọn chức năng: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					addNewExpCandidate();
					break;
				case 2:
					addNewFresherCandidate();
					break;
				default:
					System.err.println("Chức năng không chính xác, mời bạn nhập lại!");
					break;
				}
			} catch (SQLException e) {
				System.err.println("Loại tốt nghiệp chưa chính xác!");
			} catch (Exception e) {
				System.err.println("Mời bạn nhập chính xác chức năng!");
			}	
		}
	}

}
