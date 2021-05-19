-- Ta có database để quản lý fresher, có table Trainee với các trường như sau:
-- 			TraineeID: định danh của thực tập sinh (auto increment).
-- 			Full_Name: tên đầy đủ của thực tập sinh.
-- 			Birth_Date: ngày sinh của thực tập sinh.
-- 			Gender: chỉ có 3 giá trị MALE, FEMALE, and UNKNOWN.
-- 			ET_IQ: (IQ) - Điểm test đầu vào của thực tập sinh (integer có giá trị từ 0 ➔20)
-- 			ET_Gmath: (Gmath) - Điểm test đầu vào của thực tập sinh (integer có giá trị từ 0 ➔20)
-- 			ET_English: (English) - Điểm test đầu vào của thực tập sinh (integer có giá trị từ 0 ➔50)
-- 			Training_Class: mã lớp của thực tập sinh đang học VD: 'VTI001', 'VTI002',....
-- 			Evaluation_Notes: Ghi thông tin trường thực tập sinh đang theo học ví dụ: 'DHBKHN', 'DHQGHN', 'HVBCVT'…
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu

-- Tạo database
DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;

USE Fresher;

-- Thiết lập database
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FullName NVARCHAR(50),
    Birth_Date DATE,
    Gender ENUM("Male", "Female", "Unknown"),
    ET_IQ TINYINT UNSIGNED CHECK(ET_IQ <= 20),
    ET_Gmath TINYINT UNSIGNED CHECK(ET_Gmath <= 20),
    ET_English TINYINT UNSIGNED CHECK(ET_English <= 50),
    Training_Class CHAR(6),
    Evaluation_Notes NVARCHAR(50)
);

-- Question 2: Thêm ít nhất 10 bản ghi vào table
INSERT INTO Trainee (FullName,				Birth_Date,			Gender,		ET_IQ,	ET_Gmath,	ET_English,		Training_Class,		Evaluation_Notes)
VALUES				('Nguyen Hai Nam',		'1997-02-19',		'Male',		'15',	'15',		'45',			'VTI001',			'DHMHN'),
					('Nguyen Chau Giang',	'1997-04-09',		'Female',	'13',	'14',		'40',			'VTI001',			'DHY'),
                    ('Le Thanh Duy',		'1999-02-03',		'Male',		'7',	'8',		'46',			'VTI002',			'DHVH'),
                    ('Vu Quang Huy',		'1992-01-27',		'Male',		'15',	'15',		'43',			'VTI003',			'DHMHN'),
                    ('Nguyen Hoang Minh',	'1990-09-02',		'Male',		'15',	'15',		'47',			'VTI002',			'DHMHN'),
                    ('Mai Duc Son',			'1997-02-10',		'Male',		'15',	'15',		'45',			'VTI002',			'DHMHN'),
                    ('Pham Ngoc Tuong',		'1989-01-21',		'Female',	'15',	'15',		'45',			'VTI001',			'DHMHN'),
                    ('Ha Hue Chi',			'2000-06-30',		'Female',	'15',	'15',		'40',			'VTI003',			'DHMHN'),
                    ('Nguyen Hong Giang',	'1994-07-27',		'Female',	'15',	'15',		'44',			'VTI002',			'DHMHN'),
                    ('Pham Ngoc Quynh',		'1985-03-18',		'Female',	'15',	'15',		'45',			'VTI001',			'DHMHN');

-- Question 3: Insert 1 bản ghi mà có điểm ET_IQ =30. Sau đó xem kết quả.
INSERT INTO Trainee	(FullName,				Birth_Date,			Gender,		ET_IQ,	ET_Gmath,	ET_English,		Training_Class,		Evaluation_Notes)
VALUES				('Pham Huy Bach',		'1997-12-21',		'Male',		'30',	'15',		'15',			'VTI007',			'DHMHN');

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, và sắp xếp theo ngày sinh. Điểm ET_IQ >=12, ET_Gmath>=12, ET_English>=20
SELECT		*
FROM		Trainee
WHERE		ET_IQ >= 12 AND ET_Gmath >= 12 AND ET_English >=20
ORDER BY	Birth_Date;

-- Question 5: Viết lệnh để lấy ra thông tin thực tập sinh có tên bắt đầu bằng chữ N và kết thúc bằng chữ G
SELECT		*
FROM 		Trainee
WHERE		FullName LIKE ('N%g');

-- Question 6: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có ký thự thứ 2 là chữ G
SELECT		*
FROM		Trainee
WHERE		FullName LIKE ('_g%');

-- Question 7: Viết lệnh để lấy ra thông tin thực tập sinh mà tên có 10 ký tự và ký tự cuối cùng là i
SELECT		*
FROM		Trainee
WHERE		length(FullName) = 10 AND FullName LIKE ('%i');

-- Question 8: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, lọc bỏ các tên trùng nhau.
SELECT		DISTINCT FullName
FROM		Trainee;

-- Question 9: Viết lệnh để lấy ra Fullname của các thực tập sinh trong lớp, sắp xếp các tên này theo thứ tự từ A-Z.
SELECT		FullName
FROM		Trainee
ORDER BY	FullName;

-- Question 10: Viết lệnh để lấy ra thông tin thực tập sinh có tên dài nhất
SELECT		*
FROM		Trainee
WHERE		length(FullName) = (SELECT 	MAX(length(FullName))
								FROM	Trainee);

-- Question 11: Viết lệnh để lấy ra ID, Fullname và Ngày sinh thực tập sinh có tên dài nhất
SELECT		TraineeID, FullName, Birth_Date
FROM		Trainee
WHERE		length(FullName) = (SELECT	MAX(length(FullName))
								FROM	Trainee);

-- Question 12: Viết lệnh để lấy ra Tên, và điểm IQ, Gmath, English thực tập sinh có tên dài nhất
SELECT		FullName, ET_IQ, ET_Gmath, ET_English
FROM		Trainee
WHERE		length(FullName) = (SELECT	MAX(length(FullName))
								FROM	Trainee);

-- Question 13 Lấy ra 5 thực tập sinh có tuổi nhỏ nhất
SELECT		*
FROM		Trainee
ORDER BY	Birth_Date DESC
LIMIT 		5;

-- Question 14: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người thỏa mãn số điểm như sau:
-- 			ET_IQ + ET_Gmath>=30
-- 			ET_IQ>=8
-- 			ET_Gmath>=8
-- 			ET_English>=18
SELECT		FullName
FROM		Trainee
WHERE		ET_IQ >= 8 AND ET_Gmath >= 8 AND ET_English >= 18 AND (ET_IQ + ET_Gmath) >= 30;

-- Question 15: Xóa thực tập sinh có TraineeID = 3
DELETE
FROM 		Trainee
WHERE		TraineeID = 3;

-- Question 16: Xóa thực tập sinh có tổng điểm ET_IQ, ET_Gmath <=15
DELETE		
FROM		Trainee
WHERE 		ET_IQ + ET_Gmath <= 15;

-- Question 17: Xóa thực tập sinh quá 30 tuổi.
DELETE
FROM		Trainee
WHERE		year(curdate()) - year(Birth_Date) >= 30;

-- Question 18: Thực tập sinh có TraineeID = 3 được chuyển sang lớp " VTI003". Hãy cập nhật thông tin vào database.
UPDATE		Trainee
SET			Training_Class = 'VTI003'
WHERE		TraineeID = 3;

-- Question 19: Do có sự nhầm lẫn khi nhập liệu nên thông tin của học sinh số 10 đang bị sai, hãy cập nhật lại tên thành “LeVanA”, điểm ET_IQ =10, điểm ET_Gmath =15, điểm ET_English = 30.
UPDATE		Trainee
SET			FullName = 'Le Van A', ET_IQ = 10, ET_Gmath = 15, ET_English = 30
WHERE		TraineeID = 10;

-- Question 20: Đếm xem trong lớp VTI001 có bao nhiêu thực tập sinh.
SELECT		Training_Class, COUNT(*) AS Number_of_Trainee
FROM		Trainee
WHERE		Training_Class = 'VTI001'
GROUP BY	Training_Class;

-- Question 22: Đếm tổng số thực tập sinh trong lớp VTI001 và VTI003 có bao nhiêu thực tập sinh.
SELECT		COUNT(*) AS Number_of_Trainee
FROM		Trainee
GROUP BY 	Training_Class HAVING Training_Class = 'VTI001' OR Training_Class = 'VTI003';

-- Question 23: Lấy ra số lượng các thực tập sinh theo giới tính: Male, Female, Unknown.
SELECT		Gender, COUNT(*)
FROM		Trainee
GROUP BY	Gender;

-- Question 25: Lấy ra lớp có lớn hơn 4 thực tập viên
SELECT		Training_Class, COUNT(*) AS Number_of_Trainees
FROM		Trainee
GROUP BY	Training_Class HAVING COUNT(*) >= 4;

-- Question 26: Lấy ra trường có ít hơn 4 thực tập viên tham gia khóa học
SELECT		Training_Class, COUNT(*) AS Number_of_Trainees
FROM		Trainee
GROUP BY	Training_Class HAVING COUNT(*) < 4;

-- Question 27: Bước 1: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI001'
-- 			Bước 2: Lấy ra danh sách thông tin ID, Fullname, lớp thực tập viên có lớp 'VTI002'
-- 			Bước 3: Sử dụng UNION để nối 2 kết quả ở bước 1 và 2
SELECT		*
FROM		Trainee
WHERE		Training_Class = 'VTI001'
UNION
SELECT		*
FROM		Trainee
WHERE		Training_Class = 'VTI002';
