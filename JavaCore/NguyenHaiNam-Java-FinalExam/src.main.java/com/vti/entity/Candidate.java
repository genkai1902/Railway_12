package com.vti.entity;

public abstract class Candidate {
	int id;
	String firstName;
	String lastName;
	String email;
	String phone;
	String password;
	CandidateType type;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CandidateType getType() {
		return type;
	}
	public void setType(CandidateType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		String intro = "ID " + id + ", Candidate Type: " + type + "\nFull name: " + firstName + " " + lastName + ", Email: " + email + ", Phone: " + phone;
		return intro;
	}
}
