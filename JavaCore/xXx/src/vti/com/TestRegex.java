package vti.com;

import java.util.regex.Pattern;

public class TestRegex {

	public static void main(String[] args) {
		String test = "b";
		System.out.println(Pattern.matches("[a-z]", test));

	}

}
