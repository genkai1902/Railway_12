package com.vti.datalayer;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.vti.entity.HocSinh;

public interface IHocSinhRepository {
	List<HocSinh> getAll() throws ClassNotFoundException, SQLException, ParseException;
	void createHSG() throws ClassNotFoundException, SQLException;
	void createHSK() throws ClassNotFoundException, SQLException;
	void createHSY() throws ClassNotFoundException, SQLException, ParseException;
}
