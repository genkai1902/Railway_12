package com.vti.Ex1Ex2;

import java.time.LocalDateTime;

public class Exam {
	private int id;
	private String code;
	private String title;
	private CategoryQuestion category;
	private int duration;
	private Account creator;
	private LocalDateTime createDate;
	private Question[] questions;
	
	public int getID() {
		return this.id;
	}
	public String getCode() {
		return this.code;
	}
	public String getTitle() {
		return this.title;
	}
	public CategoryQuestion getCategory() {
		return this.category;
	}
	public int getDuration() {
		return this.duration;
	}
	public Account getCreator() {
		return this.creator;
	}
	public LocalDateTime getCreateDate() {
		return this.createDate;
	}
	public Question[] getQuestions() {
		return this.questions;
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
}
