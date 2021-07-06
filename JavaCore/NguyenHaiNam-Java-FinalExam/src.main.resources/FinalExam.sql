DROP DATABASE IF EXISTS CANDIDATE;
CREATE DATABASE CANDIDATE;
USE CANDIDATE;

DROP TABLE IF EXISTS Candidates;
CREATE TABLE Candidates(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(50) UNIQUE KEY NOT NULL,
    phone VARCHAR(12) CHECK(length(phone) >= 9),
    `password` VARCHAR(12) UNIQUE KEY NOT NULL CHECK(length(`Password`) >= 6),
    `role` ENUM('EXP' , 'FRESHER'),
    expInYear INT UNSIGNED,
    proSkill VARCHAR(250),
    graduateRank ENUM ('EXCELLENT', 'GOOD', 'FAIR', 'POOR')
);

INSERT INTO Candidates 	( firstName, lastName, email, phone, `password`, `role`, expInYear, proSkill, graduateRank )
VALUES 					( 'Nam', 'Nguyen', 'nam@gmail.com', '0978439602', 'haiNamN', 'EXP', 3, 'SQL', NULL);

SELECT * FROM Candidates;
