package com.vti.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.vti.datalayer.HocSinhRepository;
import com.vti.datalayer.IHocSinhRepository;
import com.vti.entity.HocSinh;

public class HocSinhServiceImplement implements IHocSinhService{

	IHocSinhRepository hocSinhRepository;
	
	public HocSinhServiceImplement() {
		hocSinhRepository = new HocSinhRepository();
	}
	
	public List<HocSinh> getAll() throws ClassNotFoundException, SQLException, ParseException {
		return hocSinhRepository.getAll();
	}

	public void createHSG() throws ClassNotFoundException, SQLException {
		hocSinhRepository.createHSG();
	}

	public void createHSK() throws ClassNotFoundException, SQLException {
		hocSinhRepository.createHSK();	
	}

	public void createHSY() throws ClassNotFoundException, SQLException, ParseException {
		hocSinhRepository.createHSY();		
	}

	public void displayList() throws ClassNotFoundException, SQLException, ParseException {
		List<HocSinh> listStudent = getAll();
		for (HocSinh hocSinh : listStudent) {
			System.out.println(hocSinh);
		}
	}

	public void searchByID() throws ClassNotFoundException, SQLException, ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ID hoc sinh can tim kiem: ");
		int searchID = sc.nextInt();
		boolean isFound = false;
		List<HocSinh> listStudent = getAll();
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

	
	public void createNewStudent() throws ClassNotFoundException, SQLException {
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
					createHSG();
					break;
				case 2:
					System.out.println("HSK");
					createHSK();
					break;
				case 3:
					System.out.println("HSY");
					createHSY();
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

}
