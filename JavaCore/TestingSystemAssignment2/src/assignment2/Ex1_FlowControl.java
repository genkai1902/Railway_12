package assignment2;


public class Ex1_FlowControl {

//	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

// Create group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "DB Fresher";

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "C++ Fresher";
		

// Create Deparment
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketting";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "HR";
		

// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Dev";

		Position position2 = new Position();
		position2.id = 2;
		position2.name = "Test";

		Position position3 = new Position();
		position3.id = 3;
		position3.name = "Scrum Master";

		Position position4 = new Position();
		position4.id = 4;
		position4.name = "PM";

// Create account
		Account account1 = new Account();
		account1.id = 1;
		account1.department = department1;
		account1.email = "An@gmail.com";
		account1.fullname = "Nguyen Van An";
		account1.position = position1;
		account1.username = "an.nguyenvan";

		Account account2 = new Account();
		account2.id = 2;
		account2.department = department1;
		account2.email = "Linh@gmail.com";
		account2.fullname = "Nguyen Hoai Linh";
		account2.position = position3;
		account2.username = "Linh.nguyenhoai";

		Account account3 = new Account();
		account3.id = 3;
		account3.department = department2;
		account3.email = "ha@gmail.com";
		account3.fullname = "Pham Hai Ha";
		account3.position = position1;
		account3.username = "Ha.phamhai";

// add group to account
		Group[] groupOfAccount1 = { group1 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group3 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group1 };
		account3.groups = groupOfAccount3;

// add account to group
		Account[] accountOfGroups1 = { account1, account2, account3 };
		group1.accounts = accountOfGroups1;
		

		// IF
//		Question 1:
//		Kiểm tra account thứ 2 Nếu không có phòng ban (tức là department == null) thì sẽ in ra text "Nhân viên này chưa có phòng ban"
//		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"

		System.out.println("________________________Question 1________________________");

		if (account2.department == null) {
			System.out.println("Nhan vien nay chua co phong ban.");
		} else {
			System.out.println("Phong ban cua nhan vien nay la " + account2.department.name);
		}

//		Question 2:
//		Kiểm tra account thứ 2 Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//		Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//		Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//		Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"		

		System.out.println("________________________Question 2________________________");

		if (account2.groups.length == 0) {
			System.out.println("Nhan vien nay khong tham gia group.");
		} else if (account2.groups.length == 1) {
			System.out.println("Nhan vien nay tham gia group " + account2.groups[0].name);
		} else if (account2.groups.length == 2) {
			System.out.println(
					"Nhan vien nay tham gia 2 group la " + account2.groups[0].name + ", " + account2.groups[1].name);
		} else if (account2.groups.length == 3) {
			System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group.");
		} else {
			System.out.println("Nhan vien nay hong chuyen o tat ca cac group");
		}

//		Question 3:
//		Sử dụng toán tử ternary để làm Question 1

		System.out.println("________________________Question 3________________________");

		System.out.println((account2.department == null ? "Nhan vien nay chua co phong ban"
				: "Phong ban cua nhan vien nay la " + account2.department.name));

//		Question 4:
//		Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của account thứ 1 Nếu Position = Dev thì in ra text "Đây là Developer"
//		Nếu không phải thì in ra text "Người này không phải là Developer"

		System.out.println("________________________Question 4________________________");

		System.out.println(account1.position.name == "Dev" ? "Day la Developer" : "Nguoi nay khong phai la Developer");

		// SWITCH CASE
//		Question 5:
//		Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//		Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//		Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//		Còn lại in ra "Nhóm có nhiều thành viên"

		System.out.println("________________________Question 5________________________");

		switch (accountOfGroups1.length) {
		case 1:
			System.out.println("Nhom co 1 thanh vien.");
			break;
		case 2:
			System.out.println("Nhom co 2 thanh vien.");
			break;
		case 3:
			System.out.println("Nhom co 3 thanh vien.");
			break;
		default:
			System.out.println("Nhom co nhieu thanh vien.");
			break;
		}

//		Question 6:
//		Sử dụng switch case để làm lại Question 2

		System.out.println("________________________Question 6________________________");

		switch (account2.groups.length) {
		case 0:
			System.out.println("Thanh vien nay chua tham gia group.");
			break;
		case 1:
			System.out.println("Thanh vien nay tham gia group " + account2.groups[0].name);
			break;
		case 2:
			System.out.println(
					"Thanh vien nay chua tham gia 2 group " + account2.groups[0].name + ", " + account2.groups[1].name);
			break;
		case 3:
			System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group.");
			break;
		default:
			System.out.println("Nhan vien nay hong chuyen o tat ca cac group");
			break;
		}

//		Question 7:
//		Sử dụng switch case để làm lại Question 4

		System.out.println("________________________Question 7________________________");

		switch (account1.position.name) {
		case "Test":
			System.out.println("Day la Tester.");
			break;
		case "Scrum Master":
			System.out.println("Day la Scrum Master.");
			break;
		case "PM":
			System.out.println("Day la Project Manager.");
			break;
		default:
			System.out.println("Day la Developer.");
			break;
		}

//		FOREACH
//		Question 8:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ

		System.out.println("________________________Question 8________________________");

		Account[] totalacc = { account1, account2, account3 };
		for (Account item : totalacc) {
			System.out.println("Email: " + item.email + "\nFull name: " + item.fullname + "\nDepartment: "
					+ item.department.name + "\n");
		}
		;

//		Question 9:
//		In ra thông tin các phòng ban bao gồm: id và name

		System.out.println("________________________Question 9________________________");

		Department[] totalDep = { department1, department2, department3 };
		for (Department department : totalDep) {
			System.out.println("Department ID: " + department.id + "\nDepartment Name: " + department.name + "\n");
		}
		;

		// FOR
//		Question 10:
//		In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau: 
//		Thông tin account thứ 1 là:
//		Email: NguyenVanA@gmail.com
//		Full name: Nguyễn Văn A Phòng ban: Sale Thông tin account thứ 2 là:
//		Email: NguyenVanB@gmail.com
//		Full name: Nguyễn Văn B Phòng ban: Marketting

		System.out.println("________________________Question 10________________________");
		Account[] accArray = { account1, account2, account3 };
		for (int i = 0; i < accArray.length - 1; i++) {
			System.out.println("Thong tin account thu " + (i + 1) + " la: \nEmail: " + accArray[i].email
					+ "\nFull name: " + accArray[i].fullname + "\nPhong ban: " + accArray[i].department.name + "\n");
		}
		;

//		Question 11:
//		In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau: Thông tin department thứ 1 là: Id: 1 Name: Sale Thông tin department thứ 2 là: Id: 2 Name: Marketing

		System.out.println("________________________Question 11________________________");
		Department[] depArray = { department1, department2, department3 };
		for (int i = 0; i < depArray.length - 1; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: \nID: " + depArray[i].id + "\nName: "
					+ depArray[i].name + "\n");
		}
		;

//		Question 12:
//		Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10

		System.out.println("________________________Question 12________________________");
		for (int i = 0; i < 2; i++) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: \nID: " + depArray[i].id + "\nName: "
					+ depArray[i].name + "\n");
		}
		;

//		Question 13:
//		In ra thông tin tất cả các account ngoại trừ account thứ 2

		System.out.println("________________________Question 13________________________");
		for (int i = 0; i < accArray.length; i++) {
			if (i == 1) {
				continue;
			} else {
				System.out.println(accArray[i].email);
				System.out.println(accArray[i].fullname);
				System.out.println(accArray[i].username);
				System.out.println(accArray[i].position.name);
				System.out.println(accArray[i].department.name + "\n");
			}
		}
		;

//		Question 14:
//		In ra thông tin tất cả các account có id < 2

		System.out.println("________________________Question 14________________________");
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i].id == 2) {
				break;
			}
			System.out.println(accArray[i].email);
			System.out.println(accArray[i].fullname);
			System.out.println(accArray[i].username);
			System.out.println(accArray[i].position.name);
			System.out.println(accArray[i].department.name + "\n");
		}
		;

//		Question 15:
//		In ra các số chẵn nhỏ hơn hoặc bằng 20

		System.out.println("________________________Question 15________________________");
		for (int i = 0; i < 21; i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.println(i);
		}
		;

		// WHILE
//		Question 16:
//		Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue

		System.out.println("________________________Question 16________________________");
//		-10-
		int i = 0;
		while (i < accArray.length - 1) {
			System.out.println("Thong tin account thu " + (i + 1) + " la: \nEmail: " + accArray[i].email
					+ "\nFull name: " + accArray[i].fullname + "\nPhong ban: " + accArray[i].department.name + "\n");
			i++;
		}
		;

//		-11-
		i = 0;
		while (i < depArray.length - 1) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: \nID: " + depArray[i].id + "\nName: "
					+ depArray[i].name + "\n");
			i++;
		}
		;

//		-12-
		i = 0;
		while (i < 2) {
			System.out.println("Thong tin department thu " + (i + 1) + " la: \nID: " + depArray[i].id + "\nName: "
					+ depArray[i].name + "\n");
			i++;
		}
		;

//		-13-
		i = 0;
		while (i < accArray.length) {
			if (i != 1) {
				System.out.println(accArray[i].email);
				System.out.println(accArray[i].fullname);
				System.out.println(accArray[i].username);
				System.out.println(accArray[i].position.name);
				System.out.println(accArray[i].department.name + "\n");
			}
			i++;
		}
		;

//		-14-
		i = 0;
		while (i < 2) {
			System.out.println(accArray[i].email);
			System.out.println(accArray[i].fullname);
			System.out.println(accArray[i].username);
			System.out.println(accArray[i].position.name);
			System.out.println(accArray[i].department.name + "\n");
			i++;
		}
		;

//		-15-
		i = 0;
		while (i <= 20) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		;

		// DO-WHILE
//		Question 17:
//		Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue

		System.out.println("________________________Question 17________________________");
//		-10-
		i = 0;
		do {
			System.out.println("Thong tin account thu " + (i + 1) + " la: \nEmail: " + accArray[i].email
					+ "\nFull name: " + accArray[i].fullname + "\nPhong ban: " + accArray[i].department.name + "\n");
			i++;
		} while (i < accArray.length - 1);

//		-11-
		i = 0;
		do {
			System.out.println("Thong tin department thu " + (i + 1) + " la: \nID: " + depArray[i].id + "\nName: "
					+ depArray[i].name + "\n");
			i++;
		} while (i < depArray.length - 1);

//		-12-
		i = 0;
		do {
			System.out.println("Thong tin department thu " + (i + 1) + " la: \nID: " + depArray[i].id + "\nName: "
					+ depArray[i].name + "\n");
			i++;
		} while (i < 2);

//		-13-
		i = 0;
		do {
			if (i != 1) {
				System.out.println(accArray[i].email);
				System.out.println(accArray[i].fullname);
				System.out.println(accArray[i].username);
				System.out.println(accArray[i].position.name);
				System.out.println(accArray[i].department.name + "\n");
			}
			i++;
		} while (i < accArray.length);

//		-14-
		i = 0;
		do {
			System.out.println(accArray[i].email);
			System.out.println(accArray[i].fullname);
			System.out.println(accArray[i].username);
			System.out.println(accArray[i].position.name);
			System.out.println(accArray[i].department.name + "\n");
			i++;
		} while (i < 2);

//		-15-
		i = 0;
		do {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		} while (i <= 20);

	}
}
