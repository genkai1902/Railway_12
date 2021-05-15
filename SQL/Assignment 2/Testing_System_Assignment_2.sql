DROP DATABASE IF EXISTS Testing_System_Assignment_2;
CREATE DATABASE Testing_System_Assignment_2;

USE Testing_System_Assignment_2;

CREATE TABLE Department (
	DepartmentID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
    DepartmentName VARCHAR(50) NOT NULL
    );

CREATE TABLE `Position` (
	PositionID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
    PositionName ENUM("Dev","Test","Scrum Master", "PM") DEFAULT("Dev")
);

CREATE TABLE `Account` (
	AccountID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
    Email VARCHAR(100) NOT NULL,
    Username VARCHAR(50) NOT NULL,
    FullName VARCHAR(50) NOT NULL,
    DepartmentID TINYINT REFERENCES Department(DepartmentID),
    PositionID INT UNSIGNED REFERENCES `Position`(PositionID),
    CreateDate DATE
); 
   
CREATE TABLE `Group` (
	GroupID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
    GroupName VARCHAR(50) NOT NULL,
    CreatorID INT REFERENCES `Account`(AccountID),
    CreateDate DATE
);

CREATE TABLE GroupAccount(
	GroupID INT REFERENCES `Group`(GroupID),
    AccountID INT UNSIGNED REFERENCES `Account`(AccountID),
    JoinDate DATE
);

CREATE TABLE TypeQuestion(
	TypeID TINYINT AUTO_INCREMENT PRIMARY KEY UNIQUE KEY,
    TypeName ENUM("Essay", "Multiple-Choice")
);

CREATE TABLE CategoryQuestion (
	CategoryID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50)
);

CREATE TABLE Question(
	QuestionID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(250),
    CategoryID INT UNSIGNED REFERENCES CategoryQuestion(CategoryID),
    TypeID TINYINT REFERENCES TypeQuestion(TypeID),
    CreatorID INT REFERENCES `Account`(AccountID),
    CreateDate DATE
);

CREATE TABLE Answer(
	AnswerID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(250),
    QuestionID INT UNSIGNED REFERENCES Question(QuestionID),
    isCorrect BOOLEAN NOT NULL
);

CREATE TABLE Exam(
	ExamID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code` CHAR(5) UNIQUE KEY,
    Title VARCHAR(50),
    CategoryID INT UNSIGNED REFERENCES CategoryQuestion(CategoryID),
    Duration TINYINT,
    CreatorID INT REFERENCES `Account`(AccountID),
    CreateDate DATE
);

CREATE TABLE ExamQuestion(
	ExamID INT UNSIGNED REFERENCES Exam(ExamID),
    QuestionID INT UNSIGNED REFERENCES Question.QuestionID
);