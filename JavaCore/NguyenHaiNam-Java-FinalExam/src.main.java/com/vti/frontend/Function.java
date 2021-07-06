package com.vti.frontend;

import java.sql.SQLException;

import com.vti.controller.CandidateController;

public class Function {
	private CandidateController candidateController;
	
	public Function() {
		candidateController = new CandidateController();
	}
	
	public void login() throws Exception{
		candidateController.login();
	}
	
	public void addNewCandidate() {
		candidateController.addNewCandidate();
	}
}
