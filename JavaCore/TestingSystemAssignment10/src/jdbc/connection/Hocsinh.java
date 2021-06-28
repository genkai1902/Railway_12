package jdbc.connection;

public class Hocsinh {
	private int id;
	private String name;
	private String email;
	private int age;
	private String phoneNum;
	private String loaiHS;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getLoaiHS() {
		return loaiHS;
	}
	public void setLoaiHS(String loaiHS) {
		this.loaiHS = loaiHS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String display = "ID: " + id + ", xep loai: " + loaiHS + "\nHo ten: " + name + ", tuoi: " + age + ", email: " + email + ", sdt: " + phoneNum;
		return display;
	}
}
