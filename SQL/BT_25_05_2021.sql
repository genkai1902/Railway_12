-- Cho table sau:
-- Department (Department_Number, Department_Name)
-- Employee_Table (Employee_Number, Employee_Name, Department_Number)
-- Employee_Skill_Table (Employee_Number, Skill_Number, Date Registered)
-- Skill_Table (Skill_Number, Skill_Name)
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP DATABASE IF EXISTS Employees_Management;

CREATE DATABASE Employees_Management;
USE Employees_Management;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentNumber INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(50)
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
	EmployeeNumber INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmployeeName VARCHAR(50),
    DepartmentNumber INT UNSIGNED,
    FOREIGN KEY (DepartmentNumber) REFERENCES Department(DepartmentNumber)
);

DROP TABLE IF EXISTS Skill;
CREATE TABLE Skill(
	SkillNumber INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    SkillName VARCHAR(50)
);

DROP TABLE IF EXISTS Employee_Skill;
CREATE TABLE Employee_Skill(
	EmployeeNumber INT UNSIGNED,
    SkillNumber INT UNSIGNED,
    DateRegistered DATETIME DEFAULT NOW(),
    PRIMARY KEY (EmployeeNumber, SkillNumber),
    FOREIGN KEY (EmployeeNumber) REFERENCES Employee(EmployeeNumber),
    FOREIGN KEY (SkillNumber) REFERENCES Skill(SkillNumber)
);

-- Question 2: Thêm ít nhất 10 bản ghi vào table
INSERT INTO Department (DepartmentName)
VALUES 	('Engineering'),
		('Product Management'),
        ('Research and Development');
        
INSERT INTO Employee (EmployeeName, departmentNumber)
VALUES	('Hoang Xuan Bach', 3),
		('Nguyen Xuan Hoang', 1),
        ('Phan Dan Phuong', 2),
        ('Nguyen Ba Hung', 1),
        ('Nguyen Phuong Nam', 1),
        ('Tran Anh Ngoc', 2),
        ('Ngo Duc Thao', 3),
        ('Truong Giang Anh', 1),
        ('Cao Huy Cuong', 1),
        ('Tran Tien Thanh', 2);
        
INSERT INTO Skill (SkillName)
VALUES	('Java'),
		('.NET'),
        ('PHP'),
        ('Python'),
        ('NodeJS'),
        ('React'),
        ('Angular'),
        ('VueJS');
        
INSERT INTO Employee_Skill (EmployeeNumber, SkillNumber)
VALUES	(1,1),
		(1,2),
        (1,6),
        (2,1),
        (2,4),
        (3,7),
        (3,2),
        (4,8),
        (4,4),
        (4,1),
        (5,3),
        (6,3),
        (6,7),
        (7,6),
        (7,2),
        (8,1),
        (8,2),
        (8,8),
        (9,3),
        (9,6),
        (10,2),
        (10,5);

-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
-- Hướng dẫn: sử dụng UNION
SELECT 		*
FROM 		Employee e 
JOIN 		Employee_Skill es ON e.employeeNumber = es.employeeNumber
WHERE 		es.SkillNumber = 1;

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 		d.*
FROM		Department d
JOIN		Employee e ON d.departmentNumber = e.departmentNumber
GROUP BY 	d.departmentNumber HAVING COUNT(d.departmentNumber) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.
-- Hướng dẫn: sử dụng GROUP BY
SELECT		e.EmployeeNumber, e.EmployeeName, d.DepartmentName
FROM		Employee e
JOIN		Department d ON e.departmentNumber = d.departmentNumber
GROUP BY	e.DepartmentNumber, e.employeeNumber;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.
-- Hướng dẫn: sử dụng DISTINCT
SELECT		e.EmployeeNumber, e.EmployeeName, e.DepartmentNumber, es.DateRegistered
FROM		Employee e
JOIN		Employee_Skill es ON e.employeeNumber = es.employeeNumber
GROUP BY	e.employeeNumber HAVING COUNT(es.employeeNumber) > 1;

