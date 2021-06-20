package railway12.lesson7;

import java.io.Serializable;

public class Student implements Serializable{
	int msv;
	String hoTen;
	String tenTruong = "Buu chinh vien thong";
	
	public Student(int msv, String hoTen) {
		this.msv = msv;
		this.hoTen = hoTen;
	}
	
	void display() {
		System.out.println(msv + " - " + hoTen + " - " + tenTruong);
	}
	
}
