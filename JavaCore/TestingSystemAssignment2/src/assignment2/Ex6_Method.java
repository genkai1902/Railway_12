package assignment2;

public class Ex6_Method {

	public static void main(String[] args) {

		// Create Deparment
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Dev";

		// Create account
		Account account1 = new Account();
		account1.id = 1;
		account1.department = department1;
		account1.email = "An@gmail.com";
		account1.fullname = "Nguyen Van An";
		account1.position = position1;
		account1.username = "an.nguyenvan";

		inSoChan();
		System.out.println();
		inAccount(account1);
		inSoNguyenDuong();
	}

//		Question 1:
//			Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
	public static void inSoChan() {
		System.out.println("________________________Question 1________________________");
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

//		Question 2:
//			Tạo method để in thông tin các account
	public static void inAccount(Account account) {
		System.out.println("________________________Question 2________________________");
		System.out.println("Account ID: " + account.id);
		System.out.println("Full name: " + account.fullname);
		System.out.println("Email: " + account.email);
		System.out.println("Username: " + account.username);
		System.out.println("Department: " + account.department.name);
		System.out.println("Position: " + account.position.name);

	}

//		Question 3:
//			Tạo method để in ra các số nguyên dương nhỏ hơn 10
	public static void inSoNguyenDuong() {
		System.out.println("________________________Question 3________________________");
		for (int i = 0; i <= 10; i++) {
			System.out.print(i + " ");
		}
	}

//		Question 4:
//			Nhap so bat ki tu 1 - 10, in ra
	
	
}
