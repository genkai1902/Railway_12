package assignment4.vti.Ex4Ex6;

import java.util.Scanner;

public class Ex6_Abstraction {
	public static void main(String[] args) {
		// khai bao va insert data (cau 1a)
//		VietnamesePhone vnPhone = new VietnamesePhone();
//		vnPhone.insertContact("giang", "097...");
//		vnPhone.insertContact("nam", "097...");
//		vnPhone.insertContact("phuong", "097...");
//		vnPhone.insertContact("giang", "0987...");

		Scanner scanner = new Scanner(System.in);
		
		// cau 1d
//		System.out.print("Nhap ten muon tim: ");
//		String searchName = scanner.nextLine();
//		vnPhone.searchContact(searchName);
		
		// cau 1b
//		System.out.print("Nhap ten muon xoa: ");
//		String delName = scanner.nextLine();
//		vnPhone.removeContact(delName);
		
		// cau 1c
//		System.out.print("Nhap ten can sua sdt: ");
//		String updateName = scanner.nextLine();
//		System.out.print("Nhap sdt moi: ");
//		String newNum = scanner.nextLine();
//		vnPhone.updateContact(updateName, newNum);

		//------------------------------------------------------------------
		// insert data cho cau 2 va 3
		User user1 = new Manager("manager", 2.5);
		User user2 = new Employee("emp1", 1.7);
		User user3 = new Employee("emp2", 1.4);
		User user4 = new Waiter("waiter", 1.5);
		
		//cau 3
		System.out.println("Luong cua user 1 la: "+user1.calculatePay());
		System.out.println("Luong cuar user 2 la: "+user2.calculatePay());
		System.out.println("Luong cuar user 3 la: "+user3.calculatePay());
		System.out.println("Luong cuar user 4 la: "+user4.calculatePay());
		
		scanner.close();

	}
}
