package vti;

import java.util.Date;

public class Program {

	public static void main(String[] args) {

		Date date = new Date();

// Khai bao va insert du lieu theo class Department
		Department dep1 = new Department();
		dep1.departmentID = 1;
		dep1.departmentName = "Engineering";

		Department dep2 = new Department();
		dep2.departmentID = 2;
		dep2.departmentName = "Product Management";

		Department dep3 = new Department();
		dep3.departmentID = 3;
		dep3.departmentName = "Research and Development";

		Department dep4 = new Department();
		dep4.departmentID = 4;
		dep4.departmentName = "Support";

// Khai bao va insert du lieu theo class Position
		Position pos1 = new Position();
		pos1.positionID = 1;
		pos1.positionName = PositionName.DEV;

		Position pos2 = new Position();
		pos2.positionID = 2;
		pos2.positionName = PositionName.TEST;

		Position pos3 = new Position();
		pos3.positionID = 3;
		pos3.positionName = PositionName.SCRUM_MASTER;

		Position pos4 = new Position();
		pos4.positionID = 4;
		pos4.positionName = PositionName.PM;

// Khai bao va insert du lieu theo class Account
		Account acc1 = new Account();
		acc1.accountID = 1;
		acc1.email = "vtiacc1@gmail.com";
		acc1.fullName = "Nguyen Acc1";
		acc1.username = "vtiacc1";
		acc1.position = pos1;
		acc1.department = dep1;
		acc1.createDate = date;

		Account acc2 = new Account();
		acc2.accountID = 2;
		acc2.email = "vtiacc2@gmail.com";
		acc2.fullName = "Tran Acc2";
		acc2.username = "vtiacc2";
		acc2.position = pos2;
		acc2.department = dep4;
		acc2.createDate = date;

		Account acc3 = new Account();
		acc3.accountID = 3;
		acc3.email = "vtiacc3@gmail.com";
		acc3.fullName = "Pham Acc3";
		acc3.username = "vtiacc3";
		acc3.position = pos1;
		acc3.department = dep2;
		acc3.createDate = date;

// Khai bao va insert du lieu theo class Group
		Group swim = new Group();
		swim.groupID = 1;
		swim.groupName = "Swimming group";
		swim.groupCreatorID = acc1;
		Account[] groupacc1 = { acc1, acc3 };
		swim.accounts = groupacc1;
		swim.groupCreateDate = date;

		Group run = new Group();
		run.groupID = 2;
		run.groupName = "Running group";
		run.groupCreatorID = acc3;
		Account[] groupacc2 = { acc2, acc3 };
		run.accounts = groupacc2;
		run.groupCreateDate = date;

		Group camp = new Group();
		camp.groupID = 3;
		camp.groupName = "Camping group";
		camp.groupCreatorID = acc2;
		Account[] groupacc3 = { acc1, acc2 };
		camp.accounts = groupacc3;
		camp.groupCreateDate = date;

// In thong tin account
		System.out.println("Account ID: " + acc1.accountID);
		System.out.println("Ho va ten: " + acc1.fullName);
		System.out.println("Email dang ki: " + acc1.email);
		System.out.println("Username: " + acc1.username);
		System.out.println("Phong ban: " + acc1.department.departmentName);
		System.out.println("Vi tri: " + acc1.position.positionName);
		System.out.println("Ngay tham gia: " + acc1.createDate);

	}

}
