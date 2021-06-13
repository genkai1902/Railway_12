package assignment3;

import java.time.LocalDate;

public class Ex2_DefaultValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//			Question 1:
//		Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo): 
//		 Email: "Email 1" 
//		 Username: "User name 1" 
//		 FullName: "Full name 1" 
//		 CreateDate: now
		Account[] accounts = new Account[5];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account();
			accounts[i].email = "Email "+(i+1);
			accounts[i].username = "Username " + (i+1);
			accounts[i].fullName = "Full name " + (i+1);
			accounts[i].createDate = LocalDate.now();
		}
		for (Account account : accounts) {
			System.out.println(account);
		}
	}

}
