package com.vti.entity;

import java.time.LocalDateTime;

public class Question {
	private int id;
	private String content;
	private CategoryQuestion category;
	private TypeQuestion type;
	private Account creator;
	private LocalDateTime createDate;
	private Answer[] answers;

	public int getId() {
		return this.id;
	}

	public String getContent() {
		return this.content;
	}

	public CategoryQuestion getCategory() {
		return this.category;
	}

	public TypeQuestion getType() {
		return this.type;
	}

	public Account getCreator() {
		return this.creator;
	}

	public LocalDateTime getCreateDate() {
		return this.createDate;
	}

	public Answer[] getAnswers() {
		return answers;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setCategory(CategoryQuestion category) {
		this.category = category;
	}

	public void setType(TypeQuestion type) {
		this.type = type;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
}
