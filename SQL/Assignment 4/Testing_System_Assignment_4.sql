USE TestingSystem4;

-- Exercise 1: Join
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT		t1.AccountID, t1.FullName, t2.DepartmentName
FROM		`Account` t1
INNER JOIN	Department t2 ON t1.DepartmentID = t2.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2019
SELECT		t1.*, t2.DepartmentName
FROM		`Account` t1
INNER JOIN	Department t2 ON t1.DepartmentID = t2.DepartmentID
WHERE		CreateDate > '2019-12-20';
 
-- Question 3: Viết lệnh để lấy ra tất cả các developer 
SELECT		t1.AccountID, t1.FullName, t2.PositionName
FROM		`Account` t1
INNER JOIN	`Position` t2 ON t1.PositionID = t2.PositionID
WHERE		PositionName LIKE 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có > 30 nhân viên 
SELECT		t1.DepartmentID, t1.DepartmentName
FROM		Department t1
INNER JOIN	`Account` t2 ON t1.DepartmentID = t2.DepartmentID
GROUP BY	t1.DepartmentID HAVING COUNT(*) > 30;	

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
SELECT		t1.QuestionID, t1.Content, t1.CategoryID, t1.TypeID, t1.CreatorID
FROM		Question t1
INNER JOIN	ExamQuestion t2 ON t1.QuestionID = t2.QuestionID
GROUP BY	t1.QuestionID HAVING COUNT(*) = 	(SELECT max(CountQ) 
												 FROM 	(SELECT 	count(QuestionID) AS CountQ
														 FROM 		ExamQuestion
														 GROUP BY 	questionID) AS maxCount);

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question 
SELECT		t1.CategoryName, COUNT(t2.questionID) AS Number_of_use
FROM		CategoryQuestion t1
LEFT JOIN	Question t2 ON t1.CategoryID = t2.CategoryID
GROUP BY	t2.CategoryID
ORDER BY	COUNT(*) DESC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam 
SELECT 		t1.QuestionID, t1.Content, COUNT(t2.QuestionID) AS NumberOfAppearances FROM question t1
LEFT JOIN	examquestion t2 ON t1.QuestionID = t2.QuestionID
GROUP BY	t1.QuestionID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất 
SELECT		t1.QuestionID, t1.Content, COUNT(*) AS Number_of_Answer
FROM		Question t1
INNER JOIN	Answer t2 ON t1.QuestionID = t2.QuestionID
GROUP BY	t1.QuestionID 
HAVING COUNT(*) = (SELECT MAX(maxC) FROM (SELECT COUNT(*) AS maxC FROM answer GROUP BY questionID) AS maxCount);

-- Question 9: Thống kê số lượng account trong mỗi group 
SELECT		t1.GroupID, t1.GroupName, COUNT(*) AS Number_of_Member
FROM		`Group` t1
INNER JOIN	GroupAccount t2 ON t1.GroupID = t2.GroupID
GROUP BY	t1.GroupID HAVING COUNT(*);

-- Question 10: Tìm chức vụ có ít người nhất 
SELECT		t1.PositionID, t1.PositionName, COUNT(*) AS Number_of_employee
FROM		`Position` t1
INNER JOIN	`Account` t2 ON t1.PositionID = t2.PositionID
GROUP BY	t1.PositionID 
HAVING COUNT(*) = 	(SELECT min(minCount) 
					 FROM (SELECT COUNT(*) AS minCount 
						   FROM `Account` GROUP BY PositionID) AS minPoT);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM 
SELECT		t2.DepartmentID, t2.DepartmentName, t3.PositionName, COUNT(*) AS Number_of_employees
FROM		`Account` t1
INNER JOIN	Department t2 ON t1.DepartmentID = t2.DepartmentID
INNER JOIN	`Position` t3 ON t1.PositionID = t3.PositionID
GROUP BY	t1.PositionID, t1.DepartmentID;

-- Question 11.1: Thống kê mỗi bài kiểm tra có bao nhiêu câu hỏi
SELECT		t2.title, t3.Content, COUNT(*) AS SL
FROM		examquestion t1
INNER JOIN	exam t2 ON t1.examID = t2.examID
INNER JOIN	question t3 ON t1.questionID = t3.questionID
GROUP BY	t1.questionID, t1.examID;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
SELECT		t1.QuestionID, t1.Content AS QuestionContent, t2.TypeName, t1.CreatorID, t3.Content AS Answer
FROM		Question t1
INNER JOIN	TypeQuestion t2 ON t1.TypeID = t2.TypeID
INNER JOIN	Answer t3 ON t1.QuestionID = t3.QuestionID;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
SELECT		t1.TypeName, COUNT(*) AS NumberOfQuestion
FROM		TypeQuestion t1
INNER JOIN	Question t2 ON t1.TypeID = t2.TypeID
GROUP BY	t1.TypeID HAVING COUNT(*);

-- Question 15: Lấy ra group không có account nào 
SELECT		*
FROM		`Group` t1
LEFT JOIN	`GroupAccount` t2 ON t1.GroupID = t2.GroupID
WHERE		t2.AccountID IS NULL;

-- Question 16: Lấy ra question không có answer nào
SELECT 		* 
FROM 		question t1
LEFT JOIN 	answer t2 ON t1.questionID = t2.questionID
WHERE		t2.questionID IS NULL;


-- Exercise 2: Union
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1 b) Lấy các account thuộc nhóm thứ 2 c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT		t1.*
FROM		`Account` t1
JOIN		`GroupAccount` t2 ON t1.AccountID = t2.AccountID
WHERE		t2.GroupID IN ('1')
UNION
SELECT		t1.*
FROM		`Account` t1
JOIN		GroupAccount t2 ON t1.AccountID = t2.AccountID
WHERE		t2.GroupID = 2;

-- Question 18:
-- a) Lấy các group có lớn hơn 23 thành viên b) Lấy các group có nhỏ hơn 27 thành viên c) Ghép 2 kết quả từ câu a) và câu b)
SELECT		GroupID, COUNT(*) AS NumberOfMember
FROM		GroupAccount
GROUP BY	GroupID HAVING COUNT(*) >= 23
UNION
SELECT		GroupID, COUNT(*) AS NumberOfMember
FROM 		GroupAccount
GROUP BY	GroupID HAVING COUNT(*) <=27;