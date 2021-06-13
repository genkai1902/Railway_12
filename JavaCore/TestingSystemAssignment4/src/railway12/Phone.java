package railway12;

public class Phone {
	private int id;
	private String tenDT;
	private String hDH;
	private double giaTien;
	
	public Phone(int id, String ten, String hDH, double gia) {
		this.id = id;
		this.tenDT = ten;
		this.hDH = hDH;
		this.giaTien = gia;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTen() {
		return this.tenDT;
	}
	
	public String getHDH() {
		return this.hDH;
	}
	
	public double getGia() {
		return this.giaTien;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTen(String name) {
		this.tenDT = name;
	}
	
	public void setHDH(String hDH) {
		this.hDH = hDH;
	}
	
	public void setGia(double gia) {
		this.giaTien = gia;
	}
}
