package assignment2;

import java.util.Random;
import java.util.Scanner;

public class Ex7_Revision {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);

//			1 - viết hàm tính chu vi hình chữ nhật
//		System.out.print("Nhap chieu dai: ");
//		int a1 = scanner.nextInt();
//		System.out.print("Nhap chieu rong: ");
//		int b1 = scanner.nextInt();
//		int chuvi = tinhChuVi(a1, b1);
//		System.out.println("Chu vi hinh chu nhat la: " + chuvi);
//
//			2 - viết hàm tính diện tích hình vuông.
//		System.out.print("Nhap chieu dai canh hinh vuong: ");
//		int a2 = scanner.nextInt();
//		int dTich = sVuong(a2);
//		System.out.println("Dien tich hinh vuong la: " + dTich);
		
//			3 - Viết chương trình tìm tất cả các số chia hết cho 7 nhưng không phải bội số của 5, nằm trong đoạn 10 và 200
//		System.out.println("Tu 10 den 200, cac boi so cua 7 nhung khong chia het cho 5 la:");
//		boiSoCuaBay();
		
//			4 - Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ. Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32.
//		System.out.print("Nhap vao so nguyen bat ky: ");
//		int q4 = scanner.nextInt();
//		tongChuSo(q4);
		
//			5 - Viết chương trình giải phương trình bậc 2
//		System.out.print("Nhap vao so a = ");
//		float a = scanner.nextFloat();
//		System.out.print("Nhap vao so b = ");
//		float b = scanner.nextFloat();
//		System.out.print("Nhap vao so c = ");
//		float c = scanner.nextFloat();
//		giaiPTbac2(a, b, c);
		
//			6 - Viết chương trình đăng nhập tài khoản, cho phép nhập vào username và password, nếu nhập đúng thông báo đăng nhập thành công
//		adminLogIn();
		
		
	}

	public static int tinhChuVi(int a, int b) {
		int chuVi = (a + b) * 2;
		return chuVi;
	}

	public static int sVuong(int a) {
		int dTich = a * a;
		return dTich;
	}

	public static void boiSoCuaBay() {
		for (int i = 10; i <= 200; i++) {
			if (i % 7 == 0 && i % 5 != 0) {
				System.out.print(i + "   ");
			}
		}
	}
	
	public static void tongChuSo(int i) {
		int tong = 0;
		while (i>0) {
			int soDu = i%10;
			i = i/10;
			tong += soDu;
		}
		System.out.println("Tong cua cac chu so trong so vua nhap la: "+ tong);
	}
	
	public static void giaiPTbac2(float a, float b, float c) {
		float d = b*b - 4*a*c;
		if (d < 0) {
			System.out.println("Phuong trinh vo nghiem.");
		} else {
			if (d == 0) {
				System.out.println("Phuong trinh co 1 nghiem la: "+(-(b/(2*a))));
			} else {
				System.out.println("Phuong trinh co 2 nghiem la:");
				System.out.println("x1 = "+((-b+Math.sqrt(d))/(2*a)));
				System.out.println("x2 = "+((-b-Math.sqrt(d))/(2*a)));
			}
		}
	}
	
	public static void adminLogIn() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");
		String id = scanner.next();
		System.out.print("Password: ");
		String pw = scanner.next();
		if (id.equals("admin") && pw.equals("admin")){
			System.out.println("Dang nhap thanh cong.");
		} else if (!id.equals("admin")) {
				System.out.println("Sai tai khoan hoac mat khau.");
				adminLogIn();
			} else {
				System.out.println("Sai mat khau.");
				adminLogIn();
			}
		scanner.close();
	}

}
