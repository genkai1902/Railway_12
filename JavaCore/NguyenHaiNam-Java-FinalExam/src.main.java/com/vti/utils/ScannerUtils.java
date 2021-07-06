package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static String inputString() {

			String inputString = scanner.nextLine();
			inputString = inputString.trim();
			inputString = inputString.replaceAll("\\s+", " ");

			return inputString;
	}
	
	public static String inputString(String errorMessage) {
		while (true) {

			String inputString = scanner.nextLine();
			inputString = inputString.trim();
			inputString = inputString.replaceAll("\\s+", " ");

			return inputString;
		}
	}
	
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String input = scanner.nextLine();
				input = input.trim();
				int output = Integer.parseInt(input);
				return output;
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			int id = ScannerUtils.inputInt(errorMessage);
			if (id < 0 || id > 10) {
				System.err.println(errorMessage);
			} else {
				return id;
			}
		}
	}
	
	public static String inputEmail(String errorMessage) {
		while (true) {
			String email = ScannerUtils.inputString(errorMessage);
			if (email == null || !email.contains("@")) {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại email: ");
			} else {
				return email;
			}
		}
	}
	
	public static String inputPhoneNumber(String errorMessage) {
		while (true) {
			String number = ScannerUtils.inputString(errorMessage);
			if (number.length() > 12 || number.length() < 9) {
				System.err.println(errorMessage);
				continue;
			}

			if (number.charAt(0) != '0') {
				System.err.println(errorMessage);
				continue;
			}

			boolean isNumber = true;

			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.println(errorMessage);
				System.out.print("Mời bạn nhập lại phone number: ");
			}

		}
	}
	
	public static String inputPassword(String errorMessage) {
		while (true) {
			String password = ScannerUtils.inputString(errorMessage);
			if (password.length() < 6 || password.length() > 12) {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại password: ");
				continue;
			}

			boolean hasAtLeast1Character = false;

			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.err.println(errorMessage);
				System.out.print("Mời bạn nhập lại password: ");
			}
		}
	}
	
	public static int inputFunction(int a, int b, String errorMessage) {
		while (true) {
			int number = ScannerUtils.inputInt(errorMessage);
			if (number >= a && number <= b) {
				return number;
			} else {
				System.err.println(errorMessage);
			}
		}
	}
}
