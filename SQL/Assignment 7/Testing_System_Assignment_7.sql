USE TestingSystem3;

-- DROP TRIGGER IF EXISTS check_create_time;
-- DELIMITER $$
-- CREATE TRIGGER check_create_time
-- 	BEFORE INSERT ON `question`
--     FOR EACH ROW
-- 		BEGIN
-- 			IF NEW.`createDate` > NOW() 
--             -- THEN SET NEW.`createDate` = NOW();
--             THEN SIGNAL SQLSTATE '12345'
--             SET MESSAGE_TEXT = 'Khong the insert date lon hon nam hien tai';
-- 			END IF;
-- 		END $$
-- DELIMITER ;

-- INSERT INTO `testingsystem3`.`question` (`QuestionID`, `Content`, `CategoryID`, `TypeID`, `CreatorID`, `CreateDate`) 
-- VALUES ('256', 'cau hoi khac nua', '10', '7', '216', '2077-05-27 19:41:06');

-- SELECT * FROM question;

-- -- =========================================
-- DELETE
-- FROM question
-- WHERE questionid = 2;

-- DROP TRIGGER IF EXISTS trigger_del_question;
-- DELIMITER $$
-- CREATE TRIGGER trigger_del_question
-- 	BEFORE DELETE ON question
--     FOR EACH ROW
--     BEGIN
-- 		DELETE FROM answer WHERE questionID = OLD.questionID;
-- 	END $$
-- DELIMITER ;
	
-- Question 1: Tạo trigger không cho phép người dùng tao Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS add_group;
DELIMITER $$
CREATE TRIGGER add_group
	BEFORE INSERT ON `group`
    FOR EACH ROW
    BEGIN
		IF NEW.createDate < subdate(NOW(), interval 1 year)
			THEN SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Khong the tao group co ngay tao hon 1 nam truoc';
		END IF;
    END $$
DELIMITER ;

INSERT INTO `testingsystem3`.`group` (`GroupID`, `GroupName`, `CreatorID`, `CreateDate`) 
VALUES ('11', '11', '11', '2020-04-10 00:00:00');


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"
DROP TRIGGER IF EXISTS block_add_saledep;
DELIMITER $$
CREATE TRIGGER block_add_saledep
	BEFORE INSERT ON `account`
	FOR EACH ROW
	BEGIN
		DECLARE v_departmentID INT;
		SELECT departmentID INTO v_departmentID FROM department WHERE departmentName LIKE 'Sale';
		IF NEW.departmentID = v_departmentID
			THEN SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
		END IF;
	END $$
DELIMITER ;

INSERT INTO `testingsystem3`.`account` (`AccountID`, `Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`) 
VALUES ('255', 'asdasdf@gmail.com', 'asdasdf', 'asdasdf', '8', '2', '2020-12-03 00:00:00');


-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
DROP TRIGGER IF EXISTS set_group;
DELIMITER $$
CREATE TRIGGER set_group
	BEFORE INSERT ON `groupaccount`
    FOR EACH ROW
    BEGIN
		DECLARE v_countAcc INT;
        SELECT COUNT(accountID) INTO v_countAcc FROM groupaccount GROUP BY groupID HAVING groupID = NEW.groupID;
		IF v_countAcc >= 18
			THEN SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'This group has reached its limitation.';
		END IF;
	END $$
DELIMITER ;

INSERT INTO `groupaccount` (groupID, accountID, joindate)
VALUES 	(1, 255, '2020-07-20');

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
DROP TRIGGER IF EXISTS set_exam;
DELIMITER $$
CREATE TRIGGER set_exam
	BEFORE INSERT ON `examquestion`
    FOR EACH ROW
    BEGIN
		DECLARE v_countQ INT;
        SELECT COUNT(questionID) INTO v_countQ FROM examquestion GROUP BY examID HAVING examID = NEW.examID;
        IF v_countQ >= 17
			THEN SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'This exam has reached its limitation.';
		END IF;
	END $$
DELIMITER ;

INSERT INTO `examquestion` (examID, questionID)
VALUES (4, 25);

-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, không cho phép user xóa), 
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó 
DROP TRIGGER IF EXISTS del_email;
DELIMITER $$
CREATE TRIGGER del_email
	BEFORE DELETE ON `account`
    FOR EACH ROW
    BEGIN
		DECLARE v_accountID INT;
        SELECT accountID INTO v_accountID FROM `account` WHERE email = OLD.email;
        IF OLD.email LIKE 'admin@gmail.com' THEN 
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = "Cannot delete admin's email";
		ELSE
			UPDATE `group` SET CreatorID = NULL WHERE CreatorID = v_accountID;
			DELETE FROM groupaccount WHERE accountID = v_accountID;
            UPDATE question SET CreatorID = NULL WHERE CreatorID = v_accountID;
            UPDATE exam SET CreatorID = NULL WHERE CreatorID = v_accountID;            
		END IF;
	END $$
DELIMITER ;
DELETE FROM `account` WHERE AccountID = 1;
DELETE FROM `account` WHERE AccountID = 2;

-- Question 6: 	Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID 
-- 				thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS set_default_dep;
DELIMITER $$
CREATE TRIGGER set_default_dep
	BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		DECLARE v_depID INT;
        SELECT departmentID INTO v_depID FROM department WHERE DepartmentName = 'waiting department';
        IF NEW.DepartmentID IS NULL THEN 
			SET NEW.DepartmentID = v_depID;
		END IF;
	END $$
DELIMITER ;

INSERT INTO `testingsystem3`.`account` (`Email`, `Username`, `FullName`, `PositionID`, `CreateDate`) 
VALUES ('abc6789@gmail.com', 'abc6789', 'a b c', '3', '2021-05-05 00:00:00');


-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS set_max_answer;
DELIMITER $$
CREATE TRIGGER set_max_answer
	BEFORE INSERT ON `answer`
    FOR EACH ROW
    BEGIN
		DECLARE v_countTA INT;
        DECLARE v_countC INT;
        SELECT COUNT(*) INTO v_countTA FROM answer WHERE QuestionID = NEW.questionID;
        SELECT COUNT(*) INTO v_countC FROM answer WHERE QuestionID = NEW.questionID AND isCorrect = 1;
        IF v_countTA < 4 THEN 
			IF v_countC >= 2 THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'Cau hoi co qua nhieu dap an dung.';
			END IF;
        ELSE
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'Cau hoi da dat gioi han so luong cau tra loi.';
		END IF;
	END $$
DELIMITER ;
INSERT INTO `testingsystem3`.`answer` (`Content`, `QuestionID`, `isCorrect`) VALUES ('abc6789', '35', 1);


-- Question 8: 	Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định 
-- 				Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database 
DROP TRIGGER IF EXISTS check_insert_gender;
DELIMITER $$
CREATE TRIGGER check_insert_gender
	BEFORE INSERT ON `account`
    FOR EACH ROW 
    BEGIN
		IF NEW.gender = 'nam' THEN
			SET NEW.gender = 'M';
		ELSEIF NEW.gender = 'nu' THEN
			SET NEW.gender = 'F';
        ELSEIF NEW.gender = 'chua xac dinh' THEN
			SET NEW.gender = 'U';  
		END IF;
	END $$
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
DROP TRIGGER IF EXISTS del_exam;
DELIMITER $$
CREATE TRIGGER del_exam
	BEFORE DELETE ON exam
    FOR EACH ROW
    BEGIN
		DECLARE v_createdate DATETIME;
        SELECT createDate INTO v_createDate FROM exam WHERE CreateDate = OLD.CreateDate;
        IF date_sub(NOW(), interval 2 day) < v_createDate THEN
			SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Khong duoc phep xoa bai thi moi tao duoi 2 ngay';
		END IF;
	END $$
DELIMITER ;

DELETE FROM exam WHERE code = 'vtiq011';
INSERT INTO `exam` (`Code`, `Title`, `CategoryID`, `Duration`, `CreatorID`, `CreateDate`) 
VALUES ('VTIQ011', 'test', '2', '60', '2', '2021-05-29 00:00:00');


-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
DROP TRIGGER IF EXISTS check_update_question;
DELIMITER $$
CREATE TRIGGER check_update_question
	BEFORE UPDATE ON `question`
    FOR EACH ROW
    BEGIN
		DECLARE v_count INT;
        SELECT count(*) INTO v_count FROM examquestion WHERE questionID = NEW.questionID;
			IF v_count > 0 THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'Khong the sua cau hoi da ton tai trong bai kiem tra.';
			END IF;
	END $$
DELIMITER ;

DROP TRIGGER IF EXISTS check_delete_question;
DELIMITER $$
CREATE TRIGGER check_delete_question
	BEFORE UPDATE ON `question`
    FOR EACH ROW
    BEGIN
		DECLARE v_count INT;
        SELECT count(*) INTO v_count FROM examquestion WHERE questionID = OLD.questionID;
			IF v_count > 0 THEN
				SIGNAL SQLSTATE '12345'
				SET MESSAGE_TEXT = 'Khong the xoa cau hoi da ton tai trong bai kiem tra.';
			END IF;
	END $$
DELIMITER ;


-- Question 12: Lấy ra thông tin exam trong đó: Duration <= 30 thì sẽ đổi thành giá trị "Short time" 30 < Duration <= 60 
-- 				thì sẽ đổi thành giá trị "Medium time" Duration > 60 thì sẽ đổi thành giá trị "Long time"


-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
				-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few 
				-- Nếu số lượng user trong group <= 20 và > 5  thì sẽ có giá trị là normal 
				-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher 
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
-- DROP TRIGGER IF EXISTS thong_ke_phong_ban;
-- DELIMITER $$
-- CREATE TRIGGER thong_ke_phong_ban

SELECT d.departmentID, d.departmentName, case 
when count(a.departmentID) = 0 THEN 'Khong co ai'
ELSE count(a.departmentID)
END AS 'So luong User'
FROM department d LEFT JOIN `account` a ON d.departmentID = a.DepartmentID group by d.DepartmentID;


-- 1- 2- 3-a 4-b 5-b 6-c 7-b 8-d 9-d 10-b 11-d 12-d 13-a 14-d 15-a 16-c 17-b 18-d 19-c 20-a 21-a 22-a 23-b 24-a 25-c 