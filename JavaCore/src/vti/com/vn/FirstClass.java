package vti.com.vn;

import java.util.Date;

public class FirstClass {

	public static void main(String[] args) {
		Department department = new Department();
		department.id = 1;
		department.departmentName = "Sale";
		System.out.println("ID: " + department.id);
		System.out.println("departmentName: " + department.departmentName);

		Position posistion = new Position();
		posistion.id = 2;
		posistion.positionName = PositionName.DEV;
		System.out.println("ID: " + posistion.id);
		System.out.println("PositionName: " + posistion.positionName);

		Group group1 = new Group();
		group1.id = 1;
		group1.groupName = "Nhom 1";

		Group group2 = new Group();
		group2.id = 2;
		group2.groupName = "Nhom 2";

		Group group3 = new Group();
		group3.id = 3;
		group3.groupName = "Nhom 3";

		Account account = new Account();
		account.id = 1;
		account.email = "nam.nh@vti.com.vn";
		account.fullName = "Nguyen Hai Nam";
		account.userName = "genkai";
		account.department = department;
		account.position = posistion;
		Date date = new Date();
		account.createDate = date;
		Group[] dsNhom = {group1,group2,group3};
		account.dsNhom = dsNhom;

		System.out.println("Account ID: " + account.id);
		System.out.println("Account Email: " + account.email);
		System.out.println("Account Full Name: " + account.fullName);
		System.out.println("Account User Name: " + account.userName);
		System.out.println("Account Department: " + account.department.departmentName);
		System.out.println("Account Position: " + account.position.positionName);
		System.out.println("Account Create Date: " + account.createDate.toString());
		System.out.print("Account Joined Groups: ");
		for (int i = 0; i < account.dsNhom.length; i++) {
			System.out.print(account.dsNhom[i].groupName + "\t");
		}
	}
}
