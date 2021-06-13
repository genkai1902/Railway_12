package railway12;

import java.time.LocalDate;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone phone1 = new Phone(1, "Note 10", "Android", 10000000d);
//		phone1.id = 1;
//		phone1.tenDT = "Note 10";
//		phone1.hDH = "Android";
//		phone1.giaTien = 10000000d;
		
		System.out.println(phone1.getTen());
		
		phone1.setTen("Iphone 12 Pro Max");
		phone1.setHDH("iOS");
		phone1.setGia(20000000d);
		
		System.out.println(phone1.getTen());
		
//		Department d1 = new Department();
//		System.out.println(d1.id + "   " + d1.nameDepartment);
//		
//		Department d2 = new Department("Sale");
//		System.out.println(d2.id + "   " + d2.nameDepartment);
//		
//		Account acc1 = new Account(1, "mail@gmail.com", "user1", "first", "last", "Dev", LocalDate.of(2019, 03, 28));
//		System.out.println(acc1.fullName + "   " + acc1.createDate);
		
	}

}
