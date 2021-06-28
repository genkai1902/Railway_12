package jdbc.connection;

public class HocSinh {
	private int id;
	private String name;
	private String email;
	private int age;
	private String phoneNum;
	private String rank;

	public int getId() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		String display = "ID: " + id + ", Hoc luc: " + rank + "\nHo ten: " + name + ", Email: " + email + ", tuoi: "
				+ age + ", sdt: " + phoneNum;
		return display;
	}

}
