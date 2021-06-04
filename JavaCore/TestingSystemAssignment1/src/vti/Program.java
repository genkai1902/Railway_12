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
		
// In thong tin account
		System.out.println("Account ID: "+acc1.accountID);
		System.out.println("Ho va ten: "+acc1.fullName);
		System.out.println("Email dang ki: "+acc1.email);
		System.out.println("Username: "+acc1.username);
		System.out.println("Phong ban: "+acc1.department.departmentName);
		System.out.println("Vi tri: "+acc1.position.positionName);
		System.out.println("Ngay tham gia: "+acc1.createDate);

	}

}
