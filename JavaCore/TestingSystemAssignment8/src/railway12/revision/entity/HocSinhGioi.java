package railway12.revision.entity;

public class HocSinhGioi extends HocSinh {

	private EDoiTuyen doiTuyen;

	public HocSinhGioi(String name, int age, String email, String num, EDoiTuyen doiTuyen) {
		super(name, age, email, num);
		this.doiTuyen = doiTuyen;
	}

	@Override
	public String toString() {
		String info = "Name: " + this.getName() + ", Age: " + this.getAge() + ", Email: " + this.getEmail()
				+ ", Phone number: " + this.getPhoneNum() + ", Doi tuyen HSG: " + this.doiTuyen;
		return info;
	}

}
