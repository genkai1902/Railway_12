package qlhs.entity;

import java.util.ArrayList;
import java.util.List;

public class HocSinh {
	List<HocSinh> dsHocSinh = new ArrayList<HocSinh>();
	private String name;
	private int age;
	private String email;
	private String phoneNum;
	
	public HocSinh(String name, int age, String email, String num) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.phoneNum = num;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
