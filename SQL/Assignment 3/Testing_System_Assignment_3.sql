USE TestingSystem3;

-- Question 2: lấy ra tất cả các phòng ban
SELECT 		*
FROM		Department
ORDER BY	DepartmentID;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT		*
FROM		Department
WHERE		DepartmentName = 'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT		*, length(fullname)
FROM		`Account`
WHERE		length(fullname) = (SELECT 	MAX(length(fullname)) 
								FROM 	`Account`);
		

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT		*, length(fullname)
FROM		Account
WHERE		DepartmentID = 3 AND length(fullname) = (SELECT 	MAX(length(fullname)) 
													 FROM 		Account 
                                                     WHERE 		DepartmentID = 3);                                                     
-- =============================                                                     
SELECT		*, length(FullName)
FROM		(SELECT * FROM account WHERE departmentID = 3) AS Vt
WHERE		length(fullname) = (SELECT MAX(length(fullname))
								FROM (SELECT * FROM account WHERE DepartmentID = 3) AS Vt);
-- =============================
WITH cte_Vt AS (SELECT * FROM `Account` WHERE departmentID = 3)
SELECT		*
FROM		cte_Vt
WHERE		length(FullName) = (SELECT 	MAX(length(FullName))
								FROM	cte_Vt);

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT		*
FROM		`Group`
WHERE		CreateDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT		QuestionID, Count(QuestionID) AS Number_of_Answer
FROM		Answer
GROUP BY	QuestionID
HAVING		COUNT(QuestionID) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT		ExamID, Title
FROM		Exam
WHERE		Duration >= 60 AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT		GroupName, CreateDate
FROM		`Group`
ORDER BY	CreateDate DESC
LIMIT		5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT		COUNT(*) AS 'So nhan vien', DepartmentID
FROM		`Account`
WHERE		DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "T" và kết thúc bằng chữ "e"
SELECT		*
FROM		`Account`
WHERE		FullName LIKE 'T%e';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE
FROM		Exam
WHERE		CreateDate < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung liên quan "%3642%"
SELECT		*
FROM		Question;

DELETE
FROM		Question
WHERE		Content LIKE '%3642%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE		`Account`
SET			FullName = 'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
WHERE		AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
-- Câu này em bị Error 1062 suốt mà không sửa không làm được
-- Liên kết nhiều-nhiều

SELECT		*
FROM		GroupAccount
WHERE		GroupID = 2 AND accountID = 13;

UPDATE		`GroupAccount`
SET			GroupID = 2
WHERE		AccountID = 1000;
