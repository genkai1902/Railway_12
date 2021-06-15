package assignment4.ex5.entity;

public class KySu extends CanBo {

	private String nganhDT;

	public KySu(String name, int age, String gender, String address, String nganh) {
		super(name, age, gender, address);
		this.nganhDT = nganh;
	}

	public String getNganhDT() {
		return this.nganhDT;
	}

	public void setNganhDT(String nganh) {
		this.nganhDT = nganh;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", Nganh dao tao: " + nganhDT;
	}
}
