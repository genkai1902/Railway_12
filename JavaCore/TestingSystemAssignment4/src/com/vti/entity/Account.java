package com.vti.entity;

import java.util.Date;

public class Account {
	private int id;
	private Date createDate;
	private Department department;
	private String email;
	private String fullname;
	private Position position;
	private String username;
	private Group[] groups;

	public int getId() {
		return this.id;
	}
	public Date getCreateDate() {
		return this.createDate;
	}
	public Department getDepartment() {
		return this.department;
	}
	public Group[] getGroups() {
		return this.groups;
	}
	public Position getPosition() {
		return this.position;
	}
	public String getEmail() {
		return this.email;
	}
	public String getFullname() {
		return this.fullname;
	}
	public String getUsername() {
		return this.username;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}
}
