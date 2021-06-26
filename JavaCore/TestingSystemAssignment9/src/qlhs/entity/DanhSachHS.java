package qlhs.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import qlhs.frontend.QLHS;

public class DanhSachHS {
	static List<HocSinh> dsHocSinh = new ArrayList<HocSinh>();
	
	public static void addStudent(HocSinh student) {
		dsHocSinh.add(student);
	}
	
	public static void showAllStudent() {
		for (HocSinh hocSinh : dsHocSinh) {
			System.out.println(hocSinh);
		}
	}
	
	public static void searchByName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("----- Tim kiem hoc sinh theo ten -----");
		System.out.println("Moi ban nhap vao ten hoc sinh can tim: ");
		String name = sc.nextLine();
		for (HocSinh hocSinh : dsHocSinh) {
			int count = 0;
			if (hocSinh.getName().equalsIgnoreCase(name)) {
				count++;
				System.out.println(hocSinh);
				if (count > 0) {
					System.out.println("Khong co hoc sinh nao co ten: " + name);
				}
			}	
		}
		System.out.println("-----------------------------------");
		System.out.println("Nhan phim 0 de quay lai menu chinh.");
		int back = sc.nextInt();
		while (back != 0) {
			System.out.println("Nhan phim 0 de quay lai menu chinh.");
			back = sc.nextInt();
		}
		QLHS.main(null);
	}
}
