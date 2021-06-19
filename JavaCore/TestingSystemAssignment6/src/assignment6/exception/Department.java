package assignment6.exception;

import assignment6.exception.ScannerUtils;

public class Department {
	private static int countID = 0;
	private int id;
	private String name;
	
	
	public Department() throws Exception {
		this.id = ++countID;
		this.name = setName();
	}

//	public int setId() throws Exception {
//		try {
//			System.out.println("Insert ID: ");
//			this.id = ScannerUtils.inputInt();
//			return this.id;
//		} catch (Exception e) {
//			throw new Exception("Please insert a number for department ID.");
//		}
//	}
	public String setName(){
		System.out.println("Insert department name: ");
		this.name = ScannerUtils.inputString();
		return this.name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
