package com.vti.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entity.HocSinh;

public interface IHocSinhService {
	List<HocSinh> getAll() throws ClassNotFoundException, SQLException, ParseException;
	void createHSG() throws ClassNotFoundException, SQLException;
	void createHSK() throws ClassNotFoundException, SQLException;
	void createHSY() throws ClassNotFoundException, SQLException, ParseException;
	void displayList() throws ClassNotFoundException, SQLException, ParseException;
	void searchByID() throws ClassNotFoundException, SQLException, ParseException;
	void createNewStudent() throws ClassNotFoundException, SQLException;
}
