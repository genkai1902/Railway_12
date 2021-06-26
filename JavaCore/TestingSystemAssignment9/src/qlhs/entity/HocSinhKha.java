package qlhs.entity;

public class HocSinhKha extends HocSinh{
	
	private float diemTB;

	public HocSinhKha(String name, int age, String email, String num, float average) {
		super(name, age, email, num);
		this.diemTB = average;
	}
	
	@Override
	public String toString() {
		String info = "Name: " + this.getName() + ", Age: " + this.getAge() + ", Email: " + this.getEmail()
				+ ", Phone number: " + this.getPhoneNum() + ", Diem trung binh: " + this.diemTB;
		return info;
	}
	
}
