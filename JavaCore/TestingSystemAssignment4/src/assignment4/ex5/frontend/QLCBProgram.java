package assignment4.ex5.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment4.ex5.entity.CanBo;
import assignment4.ex5.entity.CongNhan;
import assignment4.ex5.entity.KySu;
import assignment4.ex5.entity.NhanVien;

public class QLCBProgram {
	static List<CanBo> danhSachCB = new ArrayList<CanBo>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("----------------------- * * * -----------------------");
		System.out.println("Chao mung den voi phan mem Quan ly can bo");

		int choice = 0;
		while (choice != 5) {

			System.out.println("-----------------------");
			System.out.println("1. Them moi can bo");
			System.out.println("2. Tim kiem theo ho ten");
			System.out.println("3. Hien thi thong tin can bo");
			System.out.println("4. Xoa theo ten can bo");
			System.out.println("5. Thoat");
			System.out.print("Moi ban chon chuc nang: ");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				addPersonel();
				break;
			case 2:
				searchByName();
				break;
			case 3:
				showAllPersonel();
				break;
			case 4:
				delByName();
				break;
			default:
				System.out.println("Moi ban chon chuc nang chinh xac.");
				System.out.println("--------------------------");
				break;
			}
			System.out.println("Cam on ban da su dung dich vu. Vui long danh gia 5* cho chung toi nhe ^^");
		}

	}

	public static void addPersonel() {
		System.out.println("Them moi can bo");
		System.out.println("--------------------------");
		System.out.println("1. Cong nhan");
		System.out.println("2. Ky su");
		System.out.println("3. Nhan vien van phong");
		System.out.println("4. Quay lai");
		System.out.print("Moi ban nhap vao loai cong nhan: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			addWorker();
			break;
		case 2:
			addEngineer();
			break;
		case 3:
			addOfficer();
			break;
		case 4:
			main(null);
			break;
		default:
			System.out.println("Nhap loi, moi ban nhap lai");
			addPersonel();
			break;
		}
		sc.close();

	}

	public static void addWorker() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban dien ten cong nhan: ");
		String name = sc.nextLine();
		System.out.println("Moi ban dien tuoi cong nhan: ");
		int age = sc.nextInt();
		System.out.println("Moi ban dien gioi tinh cong nhan: ");
		String gender = sc.next();
		System.out.println("Moi ban dien dia chi cong nhan: ");
		String address = sc.nextLine();
		System.out.println("Moi ban dien cap bac cong nhan: ");
		String bac = sc.nextLine();

		CongNhan congNhan = new CongNhan(name, age, gender, address, bac);
		danhSachCB.add(congNhan);
		sc.close();
	}

	public static void addEngineer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban dien ten ky su: ");
		String name = sc.nextLine();
		System.out.println("Moi ban dien tuoi ky su: ");
		int age = sc.nextInt();
		System.out.println("Moi ban dien gioi tinh ky su: ");
		String gender = sc.next();
		System.out.println("Moi ban dien dia chi ky su: ");
		String address = sc.nextLine();
		System.out.println("Moi ban dien nganh dao tao cua ky su: ");
		String nganhDT = sc.nextLine();

		KySu kySu = new KySu(name, age, gender, address, nganhDT);
		danhSachCB.add(kySu);
		sc.close();
	}

	public static void addOfficer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban dien ten NVVP: ");
		String name = sc.nextLine();
		System.out.println("Moi ban dien tuoi NVVP: ");
		int age = sc.nextInt();
		System.out.println("Moi ban dien gioi tinh NVVP: ");
		String gender = sc.next();
		System.out.println("Moi ban dien dia chi NVVP: ");
		String address = sc.nextLine();
		System.out.println("Moi ban dien cong viec cua NVVP: ");
		String cv = sc.nextLine();

		NhanVien nvvp = new NhanVien(name, age, gender, address, cv);
		danhSachCB.add(nvvp);
		sc.close();
	}

	public static void searchByName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Moi nhap ten can bo can tim kiem: ");
		String searchName = sc.nextLine();
		if (searchName == null || searchName.equals("")) {
			System.out.println("Khong co can bo khong co ten");
		} else {
			for (CanBo canBo : danhSachCB) {
				if (searchName.equals(canBo.getName())) {
					System.out.println(canBo.toString());
				} else {
					System.out.println("Khong tim thay can bo: " + searchName);
				}
			}
		}
		sc.close();
	}
	
	public static void showAllPersonel() {
		System.out.println("Thong tin can bo: ");
		for (CanBo canBo : danhSachCB) {
			System.out.println(canBo.toString());
		}
	}
	
	public static void delByName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao ten can bo can xoa: ");
		String delName = sc.nextLine();
		if (delName == null || delName.equals("")) {
			System.out.println("Khong co can bo khong co ten");
		} else {
			List<CanBo> canBoXoa = new ArrayList<CanBo>();
			for (CanBo canBo : danhSachCB) {
				if (delName.equals(canBo.getName())) {
					canBoXoa.add(canBo);
				}				
			}
			if (canBoXoa.size() > 0) {
				canBoXoa.removeAll(canBoXoa);
			} else {
				System.out.println("Khong tim thay can bo: " + delName);
			}
		}	
		sc.close();
	}
}
