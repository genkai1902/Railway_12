package assignment6.exception;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static int inputInt() throws Exception {
		while (true) {
			try {
				String str = scanner.nextLine();
				int i = Integer.parseInt(str);
				return i; // chỗ này là break
			} catch (Exception e) {
				System.err.println("Re-insert: "); //chỗ này là continue?
		}
//			throw new Exception("\"" + str + "\" is a wrong input. Please insert an integer, not a string!");
//			System.out.println("\"" + input + "\" is a wrong input. Please insert an integer, not a string!");
		}
	}
	
//	public static int inputInt() {
//		System.out.println("Insert an integer: ");
//		String input = sc.nextLine();
//		try {
//			int i = Integer.parseInt(input);
//			return i;
//		} catch (Exception e) {
//			System.out.println("\"" + input + "\" is a wrong input. Please insert an integer, not a string!");
//		}
//		return i;
//	}
	
	public static float inputFloat() throws Exception {
		while (true) {
			try {
				String str = scanner.nextLine();
				float i = Float.parseFloat(str);
				return i;
			} catch (Exception e) {
				System.err.println("Re-insert: ");
			}
		}
	}
	
	public static double inputDouble() throws Exception {
		while (true) {
			try {
				String str = scanner.nextLine();
				double i = Double.parseDouble(str);
				return i;
			} catch (Exception e) {
				System.err.println("Re-insert: ");
			}
		}
	}
	
	public static String inputString() {
		while (true) {
			String str = scanner.nextLine();
			if (!str.isEmpty()) {
				return str;
			} else {
				System.err.println("Re-insert: ");
			}
		}
	}
		
	
}
