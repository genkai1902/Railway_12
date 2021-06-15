package com.vti.Ex1Ex2;

import java.util.Date;

public class Group {
	private int id;
	private String name;
	private Date createDate;
	private Account[] accounts;

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public Account[] getAccounts() {
		return this.accounts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
}
