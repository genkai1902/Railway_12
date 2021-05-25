USE testingsystem4;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale 
CREATE OR REPLACE VIEW account_sale AS
	SELECT		t1.*, t2.departmentName
	FROM		`Account` t1
	JOIN		department t2 ON t1.departmentID = t2.departmentID
	WHERE		departmentName LIKE 'SALE';

SELECT * FROM account_sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất 
CREATE OR REPLACE VIEW Group_member_statistic AS
	SELECT		a.AccountID, a.FullName, a.Username, COUNT(g.groupID) AS Number_of_joined_groups
	FROM		`account` a
	INNER JOIN	groupaccount g ON a.AccountID = g.accountID
	GROUP BY	a.accountID HAVING COUNT(g.GroupID)
	ORDER BY	COUNT(g.groupID) DESC;

SELECT * FROM Group_member_statistic;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi 
CREATE OR REPLACE VIEW long_question AS
	SELECT		*
	FROM		question
	WHERE length(content) > 35;

DELETE
FROM	long_question
WHERE	length(content) > 35;

SELECT * FROM long_question;


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất 
CREATE OR REPLACE VIEW biggest_dep AS
	WITH cte_T AS
		(SELECT COUNT(DepartmentID) AS maxC 
		 FROM `account` 
		 GROUP BY DepartmentID)
	
	SELECT		d.DepartmentID, d.DepartmentName, COUNT(a.DepartmentID) AS Number_of_Members
	FROM		`account` a 
	INNER JOIN	department d ON a.departmentID = d.DepartmentID
	GROUP BY	a.DepartmentID HAVING COUNT(a.departmentID) = (SELECT MAX(maxC) FROM cte_T);

SELECT * FROM biggest_dep;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Lambird tạo
CREATE OR REPLACE VIEW lambird AS
	SELECT		q.CreatorID, q.QuestionID, q.Content, q.CategoryID, q.TypeID
	FROM		question q
	INNER JOIN	`account` a ON q.CreatorID = a.AccountID
	WHERE		a.FullName LIKE '%Lambird';
SELECT * FROM lambird;