package com.vti.service;

import java.sql.SQLException;

public interface ICandidateService {
	public void login() throws ClassNotFoundException, SQLException, Exception;
	public void addNewExpCandidate() throws ClassNotFoundException, SQLException;
	public void addNewFresherCandidate() throws ClassNotFoundException, SQLException;
	public void addNewCandidate();
}
