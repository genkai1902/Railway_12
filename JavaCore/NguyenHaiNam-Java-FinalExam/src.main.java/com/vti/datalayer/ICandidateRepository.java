package com.vti.datalayer;

import java.sql.SQLException;

public interface ICandidateRepository {
	public void addNewExpCandidate() throws ClassNotFoundException, SQLException;
	public void addNewFresherCandidate() throws ClassNotFoundException, SQLException;
	public void login() throws ClassNotFoundException, SQLException, Exception;
}
