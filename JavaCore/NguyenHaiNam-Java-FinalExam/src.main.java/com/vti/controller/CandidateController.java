package com.vti.controller;

import java.sql.SQLException;

import com.vti.service.CandidateServiceImplement;
import com.vti.service.ICandidateService;

public class CandidateController {
	ICandidateService candidateService;
	public CandidateController() {
		candidateService = new CandidateServiceImplement();
	}
	
	public void login() throws Exception{
		candidateService.login();
	}
	
	public void addNewExpCandidate() throws ClassNotFoundException, SQLException {
		candidateService.addNewCandidate();
	}
	
	public void addNewFresherCandidate() throws ClassNotFoundException, SQLException {
		candidateService.addNewFresherCandidate();
	}
	
	public void addNewCandidate() {
		candidateService.addNewCandidate();
	}
}
