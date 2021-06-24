package railway12.revision.backend;

import java.util.Scanner;

import railway12.revision.entity.DanhSachHS;
import railway12.revision.entity.EDoiTuyen;
import railway12.revision.entity.HocSinh;
import railway12.revision.entity.HocSinhGioi;
import railway12.revision.entity.HocSinhKha;
import railway12.revision.entity.HocSinhYeu;
import railway12.revision.frontend.QLHS;

public class AddNewStudent {
	public static void addStudent() {
		System.out.println("Ban da chon chuc nang \"Them moi hoc sinh\"");
		System.out.println("Chon 1 de them moi hoc sinh gioi.");
		System.out.println("Chon 2 de them moi hoc sinh kha.");
		System.out.println("Chon 3 de them moi hoc sinh yeu.");
		System.out.println("Chon 0 de quay lai menu chinh.");
		int choice;
		Scanner scadd = new Scanner(System.in);
		while (true) {
			try {
				choice = scadd.nextInt();
				switch (choice) {
				case 0:
					QLHS.main(null);
					break;
				case 1:
					Scanner sc01 = new Scanner(System.in);
					System.out.println("Them moi hoc sinh gioi");
					System.out.println("----- * * * -----");
					System.out.println("Moi ban nhap ten hoc sinh: ");
					String name = sc01.nextLine();
					System.out.println("Moi ban nhap tuoi hoc sinh: ");
					int age = Integer.parseInt(sc01.nextLine());
					System.out.println("Moi ban nhap email cua hoc sinh: ");
					String email = sc01.nextLine();
					System.out.println("Moi ban nhap so dien thoai cua hoc sinh: ");
					String phoneNum = sc01.nextLine();
					System.out.println("Moi ban nhap doi tuyen HSG cua hoc sinh: ");
					String doiTuyen = sc01.nextLine();
					EDoiTuyen dT = EDoiTuyen.fromValue(doiTuyen);
					HocSinh hsg = new HocSinhGioi(name, age, email, phoneNum, dT);
					DanhSachHS.addStudent(hsg);
					addStudent();
					break;
				case 2:
					Scanner sc02 = new Scanner(System.in);
					System.out.println("Them moi hoc sinh kha");
					System.out.println("----- * * * -----");
					System.out.println("Moi ban nhap ten hoc sinh: ");
					name = sc02.nextLine();
					System.out.println("Moi ban nhap tuoi hoc sinh: ");
					age = Integer.parseInt(sc02.nextLine());
					System.out.println("Moi ban nhap email cua hoc sinh: ");
					email = sc02.nextLine();
					System.out.println("Moi ban nhap so dien thoai cua hoc sinh: ");
					phoneNum = sc02.nextLine();
					System.out.println("Moi ban nhap diem trung binh cua hoc sinh: ");
					float diemTrungBinh = sc02.nextFloat();
					HocSinh hsk = new HocSinhKha(name, age, email, phoneNum, diemTrungBinh);
					DanhSachHS.addStudent(hsk);
					addStudent();
					break;
				case 3:
					Scanner sc03 = new Scanner(System.in);
					System.out.println("Them moi hoc sinh yeu");
					System.out.println("----- * * * -----");
					System.out.println("Moi ban nhap ten hoc sinh: ");
					name = sc03.nextLine();
					System.out.println("Moi ban nhap tuoi hoc sinh: ");
					age = Integer.parseInt(sc03.nextLine());
					System.out.println("Moi ban nhap email cua hoc sinh: ");
					email = sc03.nextLine();
					System.out.println("Moi ban nhap so dien thoai cua hoc sinh: ");
					phoneNum = sc03.nextLine();
					System.out.println("Moi ban nhap ngay hop PH (theo dinh dang: yyyy-MM-dd): ");
					String date = sc03.nextLine();
					System.out.println("Moi ban nhap diem thap nhat cua hoc sinh: ");
					float minMark = sc03.nextFloat();
					
					HocSinh hsy = new HocSinhYeu(name, age, email, phoneNum, minMark, date);
					DanhSachHS.addStudent(hsy);
					addStudent();
					break;
				default:
					System.out.println("Chuc nang ban chon chua chinh xac, moi thu lai!");
					addStudent();
					break;
				}
			} catch (Exception e) {
				System.err.println("Moi ban nhap vao lua chon chinh xac.");
			}
		}
	}
}
