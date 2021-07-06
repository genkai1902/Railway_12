package com.vti.frontend;

import java.sql.SQLException;

import com.vti.utils.ScannerUtils;

public class Program {

	public static void main(String[] args) throws Exception {
		menu();
	}
	
	private static void menu() throws Exception {
		Function function = new Function();
		ScannerUtils scannerutils = null;
		System.out.println("1. Đăng ký");
		System.out.println("2. Đăng nhập");
		System.out.println("Mời bạn chọn chức năng: ");
		int choice = scannerutils.inputFunction(1, 2, "Bạn chỉ được chọn chức năng 1 hoặc 2. Mời bạn nhập lại!");
		switch (choice) {
		case 1:
			function.addNewCandidate();
			break;
		default:
			function.login();
			break;
		}
		
	}
}
