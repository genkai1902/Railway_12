package assignment3;

import java.util.Scanner;

public class Ex4_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			Question 1:
//		Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );
		// nhieu khoang trang dang gap loi
		Scanner scanner = new Scanner(System.in);
//		System.out.println("____________________Question 1____________________");
//		System.out.print("Nhap vao mot chuoi ky tu: ");
//		String str = scanner.nextLine();
//		System.out.println(countChar(str));

		// Question 2:
//		Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
//		System.out.println("____________________Question 2____________________");
//		String s1 = scanner.nextLine();
//		String s2 = scanner.nextLine();
//		System.out.println(s1 + ' ' + s2);

//			Question 3:
//		Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư viết hoa chữ cái đầu thì viết hoa lên
		System.out.println("____________________Question 3____________________");
		String name = scanner.nextLine();
		upperName(name);

//			Question 4:
//		Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra VD:
//		Người dùng nhập vào "Nam", hệ thống sẽ in ra "Ký tự thứ 1 là: N" "Ký tự thứ 1 là: A" "Ký tự thứ 1 là: M"
		System.out.println("____________________Question 4____________________");
		name = scanner.nextLine();
		charInName(name);

//			Question 5:
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
		System.out.println("____________________Question 5____________________");
		

//			Question 6:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và sau đó hệ thống sẽ tách ra họ, tên , tên đệm VD:
//		Người dùng nhập vào "Nguyễn Văn Nam"
//		Hệ thống sẽ in ra "Họ là: Nguyễn" "Tên đệm là: Văn" "Tên là: Nam"
		System.out.println("____________________Question 6____________________");

//			Question 7:
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau: a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
		System.out.println("____________________Question 7____________________");
	}

	public static int countChar(String str) {
		if (str == null) {
			return 0;
		}
		int count = 0;
		int maxSize = str.length() - 1;
		char[] characters = str.toCharArray();
		boolean isChar = false;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(characters[i]) && i != maxSize) {
				isChar = true;
			} else if (!Character.isLetter(characters[i]) && i != maxSize) {
//				if (characters[i] != ' ' && characters[i] != '\n' && characters[i] != '\t') {
				count++;
//				} else {
				isChar = false;
//				}
			} else if (Character.isLetter(characters[i]) && i == maxSize) {
				count++;
			}
		}
		return count;
	}
	
	public static void upperName(String name) {
		char[] chars = name.toCharArray();
		if (name != null) {
			chars[0] = Character.toUpperCase(chars[0]);
			for (int i = 0; i < name.length(); i++) {
				if (chars[i] == ' ') {
					chars[i+1] = Character.toUpperCase(chars[i+1]);
				}
				System.out.print(chars[i]);
			}	
		}
		System.out.println("");
	}
	
	public static void charInName(String name) {
		if (name != null) {
			char[] chars = name.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				System.out.println("Ky tu thu "+ (i+1)+ " la "+chars[i]);
			}
		}
	}
	
	public static void standardize(String name) {
		char[] chars = name.toCharArray();
		if (chars[i] == ' ' && chars[i+1] == ' ') {
			chars[i] = '';
		} else {

		}
	
}
