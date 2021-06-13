package assignment3;

import java.util.Random;
import java.util.Scanner;

public class Ex1_DatatypeCasting {

	public static void main(String[] args) {
//			Question 1:
//		Khai báo 2 số lương có kiểu dữ liệu là float.
//		Khởi tạo Lương của Account 1 là 5240.5 $ 
//		Khởi tạo Lương của Account 2 là 10970.055$ 
//		Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra 
//		Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra

		float luongAcc1 = 5240.5f;
		float luongAcc2 = 10970.555f;
		int roundLuong1 = (int) luongAcc1;
		int roundLuong2 = Math.round(luongAcc2);
		System.out.println("Luong account 1 la: " + roundLuong1);
		System.out.println("Luong account 2 la: " + roundLuong2);

//			Question 2:
//		Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)

		Random random = new Random();
		int rNum = random.nextInt(99999);
//			C1
		while (rNum <= 10000) {
			rNum *= 10;
		}
		System.out.println("So random la: " + rNum);

//			C2
//		String str = String.format("%05d", rNum);
//		System.out.printf("%s",str);

//			Question 3:
//		Lấy 2 số cuối của số ở Question 2 và in ra.
//		Gợi ý: 	Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối 
//				Cách 2: chia lấy dư số đó cho 100

//		C1
		String str2c1 = String.valueOf(rNum);
//		String str2c2 = "" + rNum;
//		String str2c3 = Integer.toString(rNum);
		
		System.out.printf("Hai so cuoi cua random number la: %s\n",str2c1);

//		C2
		int haiSoCuoi = rNum % 100;
		System.out.println("Hai so cuoi cua random number la: " + haiSoCuoi);

//			Question 4:
//		Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
		thuong();

	}

	public static void thuong() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap so a: ");
		int a = scanner.nextInt();
		System.out.print("Nhap so b: ");
		int b = scanner.nextInt();
		System.out.println("Thuong cua hai so " + a + " va " + b + " la: " + (a / b));
		scanner.close();
	}
}
