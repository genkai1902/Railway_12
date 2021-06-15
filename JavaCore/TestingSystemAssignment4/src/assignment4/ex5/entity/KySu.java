package assignment4.ex5.entity;

public class KySu extends CanBo{
	
	private String nganhDT;
	
	public KySu(String name, int age, Gender gender, String address,String nganh) {
		super(name, age, gender, address);
		// TODO Auto-generated constructor stub
		this.nganhDT = nganh;
	}
	
	public String getNganhDT() {
		return this.nganhDT;
	}
	
	public void setNganhDT(String nganh) {
		this.nganhDT = nganh;
	}
	
}
