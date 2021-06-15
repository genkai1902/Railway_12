package assignment4.ex5.entity;

public class CanBo {
	String name;
	int age;
	String gender;
	String address;

	public CanBo(String name, int age, String gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String getGender() {
		return this.gender;
	}

	public String getAddress() {
		return this.address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Ten: " + name + ", Tuoi: " + age + ", Dia chi: " + address + ", gioiTinh: " + gender;
	}
}
