package com.vti.entity;

public class FresherCandidate extends Candidate {
	GraduateRank rank;

	public GraduateRank getRank() {
		return rank;
	}

	public void setRank(String rank) throws Exception {
		this.rank = GraduateRank.fromValue(rank);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nGraduate Rank: " + rank;
	}
}
