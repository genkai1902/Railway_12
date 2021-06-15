package assignment4.vti.Ex4Ex6;

public class Ex4_Encapsulation {
	public static void main(String[] args) {
		Student std = new Student("nam", "hanoi");
		System.out.println(std.getName());
		std.setDiemHL(7);
		System.out.println(std.getDiemHL());
		std.diemCong(4);
		System.out.println(std.getDiemHL());
		std.thongTinSV();
	}
}
