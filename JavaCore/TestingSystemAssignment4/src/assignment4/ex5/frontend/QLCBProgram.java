package assignment4.ex5.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment4.ex5.entity.CanBo;
import assignment4.ex5.entity.CongNhan;
import assignment4.ex5.entity.Gender;

public class QLCBProgram {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("----------------------- * * * -----------------------");
		System.out.println("Chao mung den voi phan mem Quan ly can bo");
		while (choice != 5) {
		System.out.println("Moi ban chon chuc nang");
		System.out.println("-----------------------");
		System.out.println("1. Them moi can bo");
		System.out.println("2. Tim kiem theo ho ten");
		System.out.println("3. Hien thi thong tin can bo");
		System.out.println("4. Xoa theo ten can bo");
		System.out.println("5. Thoat");
		
		List<CanBo> danhSachCB	= new ArrayList<>();
		choice = scanner.nextInt();
		scanner.close();
		
			switch (choice) {
			case 1:
				System.out.println("Them moi can bo");
				System.out.println("--------------------------");
				System.out.println("1. Cong nhan");
				System.out.println("2. Ky su");
				System.out.println("3. Nhan vien van phong");
				System.out.print("Moi ban nhap vao loai cong nhan: ");
				Scanner scan1 = new Scanner(System.in);
				int loaiCB = scan1.nextInt();
				switch (loaiCB) {
				case 1:
					System.out.println("Moi ban dien ten cong nhan: ");
					String name = scan1.nextLine();
					System.out.println("Moi ban dien tuoi cong nhan: ");
					int age =  scan1.nextInt();
					System.out.println("Moi ban dien gioi tinh cong nhan: ");
//					Gender gender = gender.valueOf(scanner.next().toUpperCase());
					System.out.println("Moi ban dien dia chi cong nhan: ");
					String address = scan1.nextLine();
					System.out.println("Moi ban dien cap bac cong nhan: ");
					String bac = scan1.nextLine();
					
					CongNhan congNhan = new CongNhan(name, age, null, address, bac);
					danhSachCB.add(congNhan);
					System.out.println("Cong nhan");
					break;
				case 2:
					System.out.println("Ky su");
					break;
				case 3:
					System.out.println("Nhan vien");
					break;	
				default:
					System.out.println("Error!!!");
					break;
				}
				break;
			case 2:
				System.out.println("Tim kiem theo ho ten");
				System.out.println("--------------------------");
				break;
			case 3:
				System.out.println("Hien thi thong tin can bo");
				System.out.println("--------------------------");
				break;
			case 4:
				System.out.println("Xoa theo ten can bo");
				System.out.println("--------------------------");
				break;	
			case 5:
				System.out.println("Cam on ban da su dung dich vu. Vui long danh gia 5* cho chung toi nhe ^^");
				break;	
			default:
				System.out.println("Moi ban chon chuc nang chinh xac.");
				System.out.println("--------------------------");
				break;
			}
		}
		
	}
}
