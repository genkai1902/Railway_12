DROP DATABASE IF EXISTS TTHS;
CREATE DATABASE TTHS;
USE TTHS;

DROP TABLE IF EXISTS HocSinh;
CREATE TABLE HocSinh(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(250),
    email VARCHAR(250),
    age INT,
    phoneNumber VARCHAR(50),
    teamHSG ENUM("TOAN", "LY", "HOA"),
    avgMark FLOAT,
    worstMark FLOAT,
    meetingDate DATE,
    `rank` VARCHAR(50)
);

INSERT INTO 	HocSinh (`name`, email, age, phoneNumber, teamHSG, avgMark, worstMark, meetingDate, `rank`)
VALUES 			("nam", "nam@vti", 18, "097...", "TOAN", NULL, NULL, NULL, 'GIOI'),
				("minh", "minh@vti", 18, "098...", "LY", NULL, NULL, NULL, 'GIOI'),
				("son", "son@vti", 18, "096...", "HOA", NULL, NULL, NULL, 'GIOI'),
				("duy", "duy@vti", 18, "095...", NULL, null, 4.0, "2021-06-30", 'YEU'),
				("tuong", "tuong@vti", 18, "094...", NULL, 7.5, NULL, NULL, 'KHA'),
-- 				("dung", "dung@vti", 18, "093...", NULL, NULL, 4.5, "2021-06-30", 'YEU'),
--              ("huy", "huy@vti", 18, "092...", NULL, 7.0, NULL, NULL, 'KHA'),
                ("giang", "giang@vti", 18, "091...", NULL, 7.0, NULL, NULL, 'KHA');
                
SELECT * FROM HocSinh;