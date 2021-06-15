package assignment4.ex5.entity;

public class CongNhan extends CanBo {
	private String bacCongNhan;

	public CongNhan(String name, int age, String gender, String address, String bac) {
		super(name, age, gender, address);
		this.bacCongNhan = bac;
	}

	public String getBac() {
		return this.bacCongNhan;
	}

	public void setBac(String bac) {
		this.bacCongNhan = bac;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", Cap bac: " + bacCongNhan;
	}
}
