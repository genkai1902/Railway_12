package railway12.function;

import java.util.Scanner;

public class ProgramFunction {

	public static void main(String[] args) {
		/* Lam mot may ATM */
		int nhap;
		System.out.println("Chao mung ban den voi ngan hang VTI");
		do {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Moi ban chon chuc nang");
			System.out.println("------------------------------------");
			System.out.println("1. Rut tien");
			System.out.println("2. Chuyen tien");
			System.out.println("3. Truy van giao dich");
			System.out.println("4. Thanh toan hoa don");
			System.out.println("5. Dau tu");
			System.out.println("6. Thoat");
			System.out.print("Moi ban chon chuc nang: ");
			nhap = scanner.nextInt();
			ATM(nhap);
		} while (nhap != 6);

	}

	public static void hienThiTen() {
		System.out.println("Toi la ai, day la dau????");
	}

	public static int tongCuaHaiSo(int a, int b) {
		int tong = a + b;
		return tong;
	}

	public static String nhapTen() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap ho va ten: ");
		String s = scanner.nextLine();
		return s;
	}

	public static void ATM(int nhap) {
		switch (nhap) {
		case 1:
			System.out.println("Ban da chon chuc nang: Rut tien");
			break;
		case 2:
			System.out.println("Ban da chon chuc nang: Chuyen tien");
			break;
		case 3:
			System.out.println("Ban da chon chuc nang: Truy van giao dich");
			break;
		case 4:
			System.out.println("Ban da chon chuc nang: Thanh toan hoa don");
			break;
		case 5:
			System.out.println("Ban da chon chuc nang: Dau tu");
			break;
		case 6:
			System.out.println("Cam on quy khach da su dung dich vu.\nXin chao va hen gap lai quy khach!");
			break;
		default:
			System.out.println("Nhap loi, moi ban nhap chinh xac chuc nang.");
			break;
		}
	}

}
