package com.vti.Ex1Ex2;

public class Answer {
	private int id;
	private String content;
	private Question[] questions;
	private boolean isCorrect;

	public int getId() {
		return this.id;
	}

	public String getContent() {
		return this.content;
	}

	public Question[] getQuestions() {
		return this.questions;
	}

	public boolean isCorrect() {
		return this.isCorrect;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}

	public void setCorrect(boolean correct) {
		isCorrect = correct;
	}
}
