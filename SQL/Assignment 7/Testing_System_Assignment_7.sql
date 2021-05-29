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
        IF OLD.email LIKE 'admin@gmail.com'
			THEN SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = "Cannot delete admin's email";
		END IF;
	END $$
DELIMITER ;

DELETE FROM `account` WHERE AccountID = 1;

-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID 
-- thì sẽ được phân vào phòng ban "waiting Department"
DROP TRIGGER IF EXISTS set_default_dep;
DELIMITER $$
CREATE TRIGGER set_default_dep
	BEFORE INSERT ON `account`
    FOR EACH ROW
    BEGIN
		DECLARE v_depID INT UNSIGNED;
        SELECT NEW.departmentID INTO v_depID FROM `account` LIMIT 1;
        IF v_depID IS NULL
			THEN SET NEW.DepartmentID = 13;
		END IF;
	END $$
DELIMITER ;

INSERT INTO `testingsystem3`.`department` (`DepartmentID`, `DepartmentName`) VALUES ('13', 'waiting department');

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
        SELECT COUNT(*) INTO v_countTA FROM answer GROUP BY QuestionID;
        SELECT COUNT(*) INTO v_countC FROM answer GROUP BY QuestionID, isCorrect HAVING isCorrect = 1;
        IF v_countTA > 4 OR v_countC > 2
			THEN SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Cau hoi da dat gioi han cau tra loi hoac co qua nhieu dap an dung.';
		END IF;
	END $$
DELIMITER ;
INSERT INTO `testingsystem3`.`answer` (`AnswerID`, `Content`, `QuestionID`, `isCorrect`) VALUES ('254', 'abc6789', '35', b'1');


-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database 
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
-- Question 12: Lấy ra thông tin exam trong đó: Duration <= 30 thì sẽ đổi thành giá trị "Short time" 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time" Duration > 60 thì sẽ đổi thành giá trị "Long time"
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few 
-- Nếu số lượng user trong group <= 20 và > 5  thì sẽ có giá trị là normal 
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher 
-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"