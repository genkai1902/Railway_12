package assignment2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Ex2_SystemOutPrintf {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//			Question 1:
//			Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
		
		System.out.println("________________________Question 1________________________");
		int q1 = 5;
		System.out.printf("So nguyen co gia tri: %d\n", q1);
		
//			Question 2:
//			Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000
		
		System.out.println("________________________Question 2________________________");
		long q2 = 100000000L;
		System.out.printf(Locale.US,"So nguyen co gia tri: %,d\n", q2);
		
//			Question 3:
//			Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau
		
		System.out.println("________________________Question 3________________________");
		double q3 = 5.567098;
		System.out.printf("So thuc co gia tri: %.4f\n", q3);
		
//			Question 4:
//			Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau: Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau: Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
		
		System.out.println("________________________Question 4________________________");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao ho va ten: ");
		String hoTen = scanner.nextLine();
		System.out.printf("Ten toi la \"%s\" va toi dang doc than.\n", hoTen);
		
//			Question 5:
//			Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s
		
		System.out.println("________________________Question 5________________________");
		LocalDateTime localDT = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(localDT.format(dateFormatter));
		
		
//			Question 6:
//			In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)
		
		System.out.println("________________________Question 6________________________");
		
		
	}

}
