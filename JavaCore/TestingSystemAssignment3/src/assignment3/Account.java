package assignment3;

import java.time.LocalDate;

public class Account {
	String email;
	String username;
	String fullName;
	LocalDate createDate;
	
	@Override
	public String toString() {
		String str = "Email: " + email +"\nUsername: "+username+"\nFull Name: "
				+fullName+"\nCreate Date: "+createDate;
		return str;
	}
}
