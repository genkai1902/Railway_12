package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

import com.vti.controller.HocSinhController;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Get connection...");
		HocSinhController hsController = new HocSinhController();
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
					hsController.createNewStudent();
					System.out.println("------------------------");
					break;
				case 2:
					System.out.println("Danh sách học sinh");
					hsController.displayList();
					System.out.println("------------------------");
					break;
				case 3:
					System.out.println("Tìm kiếm học sinh theo ID");
					hsController.searchByID();
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
}
