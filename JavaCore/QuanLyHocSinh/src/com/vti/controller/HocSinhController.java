package com.vti.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entity.HocSinh;
import com.vti.service.HocSinhServiceImplement;
import com.vti.service.IHocSinhService;

public class HocSinhController {
	
	IHocSinhService hocSinhService;
	public HocSinhController() {
		hocSinhService = new HocSinhServiceImplement();
	}
	
	public List<HocSinh> getAll() throws ClassNotFoundException, SQLException, ParseException {
		return hocSinhService.getAll();
	}

	public void displayList() throws ClassNotFoundException, SQLException, ParseException {
		hocSinhService.displayList();
	}

	public void searchByID() throws ClassNotFoundException, SQLException, ParseException {
		hocSinhService.searchByID();
	}
	
	public void createNewStudent() throws ClassNotFoundException, SQLException {
		hocSinhService.createNewStudent();
	}
	
	public void createHSG() throws ClassNotFoundException, SQLException {
		hocSinhService.createHSG();
	}

	public void createHSK() throws ClassNotFoundException, SQLException {
		hocSinhService.createHSK();	
	}

	public void createHSY() throws ClassNotFoundException, SQLException, ParseException {
		hocSinhService.createHSY();		
	}
}
