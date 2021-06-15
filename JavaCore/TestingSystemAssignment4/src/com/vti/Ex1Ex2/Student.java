package com.vti.Ex1Ex2;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private int diem;
	
	public Student(int id, String name, String hometown) {
		this.diem = 0;
	}
	
	public void setDiem(int diem) {
		this.diem = diem;
	}
	
	public void diemCong(int diemCong) {
		diem += diemCong;
	}
	
	public void inThongTinSV() {
		
	}
}
