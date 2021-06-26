package qlhs.entity;

import java.time.LocalDate;

public class HocSinhYeu extends HocSinh{
	
	private float diemYeuNhat;
	private LocalDate ngayHPH;
	
	public HocSinhYeu(String name, int age, String email, String num, float diem, String date) {
		super(name, age, email, num);
		this.diemYeuNhat = diem;
//		this.ngayHPH = new SimpleDateFormat("dd-MM-yyyy").parse(date); // chỉ sd được cho Date type, LocalDate phải sử dụng cách khác
		this.ngayHPH = LocalDate.parse(date);
	}
	
	@Override
	public String toString() {
		String info = "Name: " + this.getName() + ", Age: " + this.getAge() + ", Email: " + this.getEmail()
				+ ", Phone number: " + this.getPhoneNum() + ", Diem thap nhat: " + this.diemYeuNhat + ", Ngay hop PH: " + this.ngayHPH;
		return info;
	}
	
}
