DROP DATABASE IF EXISTS QLHS;
CREATE DATABASE QLHS;
USE QLHS;

DROP TABLE IF EXISTS HocSinh;
CREATE TABLE HocSinh(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoTen VARCHAR(250),
    email VARCHAR(250),
    tuoi INT,
    sdt VARCHAR(50),
    doituyenHSG ENUM("TOAN", "LY", "HOA"),
    diemTB FLOAT,
    diemThapNhat FLOAT,
    ngayMoiPH DATE
);

INSERT INTO 	HocSinh (hoTen, email, tuoi, sdt, doiTuyenHSG, diemTB, diemThapNhat, ngayMoiPH)
VALUES 			("nam", "nam@vti", 18, "097...", "TOAN", NULL, NULL, NULL),
				("minh", "minh@vti", 18, "098...", "LY", NULL, NULL, NULL),
				("son", "son@vti", 18, "096...", "HOA", NULL, NULL, NULL),
				("duy", "duy@vti", 18, "095...", NULL, null, 4.0, "2021-06-30"),
				("tuong", "tuong@vti", 18, "094...", NULL, 7.5, NULL, NULL),
				("dung", "dung@vti", 18, "093...", NULL, NULL, 4.5, "2021-06-30"),
                ("huy", "huy@vti", 18, "092...", NULL, 7.0, NULL, NULL),
                ("giang", "giang@vti", 18, "091...", NULL, 7.0, NULL, NULL);
                
SELECT * FROM HocSinh;