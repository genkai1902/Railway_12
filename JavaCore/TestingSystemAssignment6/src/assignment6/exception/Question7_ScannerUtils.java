package assignment6.exception;

import java.util.Scanner;

public class Question7_ScannerUtils {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert an integer: ");
		String input = scanner.nextLine();
		System.out.println(inputInt(input));
	}
	
	public static int inputInt(String input) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		try {
			i = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("\"" + input + "\" is a wrong input. Please insert an integer, not a string!");
		}
		return i;
	}
	
//	public static int inputInt() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Insert an integer: ");
//		String input = sc.nextLine();
//		try {
//			int i = Integer.parseInt(input);
//			return i;
//		} catch (Exception e) {
//			System.out.println("\"" + input + "\" is a wrong input. Please insert an integer, not a string!");
//		}
//
//	}
	
}
