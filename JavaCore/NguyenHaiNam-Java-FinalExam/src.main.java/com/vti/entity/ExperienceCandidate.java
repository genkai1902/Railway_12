package com.vti.entity;

public class ExperienceCandidate extends Candidate{
	int expInYear;
	String proSkill;
	public int getExpInYear() {
		return expInYear;
	}
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}
	public String getProSkill() {
		return proSkill;
	}
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}
	@Override
	public String toString() {
		return super.toString() + "\nExp In Year: " + expInYear + ", Pro Skill: " + proSkill;
	}
}
