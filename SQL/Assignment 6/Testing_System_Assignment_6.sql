USE TestingSystem3;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó 
DROP PROCEDURE IF EXISTS get_departmentname_by_id;
DELIMITER $$
CREATE PROCEDURE get_account_by_departmentname (IN in_departmentname VARCHAR(50))
	BEGIN
		SELECT a.*, d.departmentName FROM `account` a JOIN department d ON a.departmentID = d.departmentID 
        WHERE DepartmentName = in_departmentname;
	END $$
DELIMITER ;

CALL get_account_by_departmentname('marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group 
DROP PROCEDURE IF EXISTS get_number_of_accounts;
DELIMITER $$
CREATE PROCEDURE get_number_of_accounts()
	BEGIN
		SELECT groupID,(SELECT groupname from `group` WHERE groupID = ga.groupID) AS groupName,count(*) AS SL 
        FROM Groupaccount ga 
        GROUP BY GroupID;
	END $$
DELIMITER ;

CALL get_number_of_accounts();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại 
DROP PROCEDURE IF EXISTS get_typequestion_monthly_statistic;
DELIMITER $$
CREATE PROCEDURE get_typequestion_monthly_statistic()
	BEGIN
		SELECT typeID, COUNT(*) AS SL
        FROM question
        WHERE month(createdate) = month(curdate())
        GROUP BY typeID;
	END $$
DELIMITER ;

CALL get_typequestion_monthly_statistic();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất 
DROP PROCEDURE IF EXISTS get_typeID_by_max_question;
DELIMITER $$
CREATE PROCEDURE get_typeID_by_max_question(OUT out_typeID MEDIUMINT)
	BEGIN
		SELECT typeID INTO out_typeID
        FROM question GROUP BY typeID HAVING count(*) = 
        (SELECT MAX(SL) FROM (SELECT Count(*) AS SL FROM question GROUP BY typeID) AS COUNT_SL);
	END $$
DELIMITER ;

SET @id = 0;
CALL get_typeID_by_max_question(@id);
SELECT @id;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question 
SELECT typename FROM typequestion WHERE typeID = @id;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào 
DROP PROCEDURE IF EXISTS find_fullname_or_username;
DELIMITER $$
CREATE PROCEDURE find_fullname_or_username(IN str_input VARCHAR(50))
	BEGIN
		SELECT a.Username, g.GroupName FROM `account` a
        JOIN `groupaccount` ga ON a.accountID = ga.accountID
        JOIN `group` g ON ga.groupID = g.groupID
        WHERE a.username LIKE str_input OR g.GroupName LIKE str_input;
    END $$
DELIMITER ;

CALL find_fullname_or_username('%yba%');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán: 
-- username sẽ giống email nhưng bỏ phần @..mail đi 
-- positionID: sẽ có default là developer 
-- departmentID: sẽ được cho vào 1 phòng chờ 
-- Sau đó in ra kết quả tạo thành công 
DROP PROCEDURE IF EXISTS insert_new_user;
DELIMITER $$
CREATE PROCEDURE insert_new_user(IN in_usermail VARCHAR(100), IN in_fullname NVARCHAR(50))
	BEGIN
		DECLARE username VARCHAR(50) DEFAULT substring_index(in_email, '@', 1);
		DECLARE positionID MEDIUMINT UNSIGNED DEFAULT 1;
        DECLARE departmentID MEDIUMINT UNSIGNED DEFAULT 5;
                
		INSERT INTO `account` (fullname, Email, username, positionID, departmentID)
		VALUES	(in_fullname, in_usermail, username, positionID, departmentID);
        
        SELECT * FROM `account` a
        WHERE a.username = username;
	END $$
DELIMITER ;

CALL insert_new_user('nam.nguyenhai@vtiacademy.edu.vn', 'Nguyen Hai Nam');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất 
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID 
DROP PROCEDURE IF EXISTS del_exam_by_ID;
DELIMITER $$
CREATE PROCEDURE del_exam_by_ID(IN _in_examID MEDIUMINT UNSIGNED)
	BEGIN
		SELECT * FROM exam
        WHERE examID = in_examID;
	END $$
DELIMITER ;

CALL del_exam_by_ID(1);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc 
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")