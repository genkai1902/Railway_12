package assignment2;

import java.util.Random;
import java.util.Scanner;

public class Ex7_Revision {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		// 1 - viết hàm tính chu vi hình chữ nhật
//		System.out.print("Nhap chieu dai: ");
//		int a1 = scanner.nextInt();
//		System.out.print("Nhap chieu rong: ");
//		int b1 = scanner.nextInt();
//		int chuvi = tinhChuVi(a1, b1);
//		System.out.println("Chu vi hinh chu nhat la: " + chuvi);
//
////		2 - viết hàm tính diện tích hình vuông.
//		System.out.print("Nhap chieu dai canh hinh vuong: ");
//		int a2 = scanner.nextInt();
//		int dTich = sVuong(a2);
//		System.out.println("Dien tich hinh vuong la: " + dTich);
		boiSoCuaBay();

//		3 - Viết chương trình tìm tất cả các số chia hết cho 7 nhưng không phải bội số của 5, nằm trong đoạn 10 và 200
//		4 - Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ. Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32.
//		5 - Viết chương trình giải phương trình bậc 2
//		6 - Viết chương trình đăng nhập tài khoản, cho phép nhập vào username và password, nếu nhập đúng thông báo đăng nhập thành công

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
		int a;
		
	}

}
