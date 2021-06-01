-- Tao va su dung database
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

-- 1. Tạo table với các ràng buộc và kiểu dữ liệu Thêm ít nhất 3 bản ghi vào table
-- Tao bang Country(country_id, country_name) 
DROP TABLE IF EXISTS Country;
CREATE TABLE Country(
	countryID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    countryName VARCHAR(50));

-- Tao bang	Location(location_id, street_address, postal_code, country_id) 
DROP TABLE IF EXISTS Location;
CREATE TABLE Location(
	locationID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    streetAddress VARCHAR(50),
    postalCode VARCHAR(10),
    countryID INT UNSIGNED,
    FOREIGN KEY (countryID) REFERENCES Country(countryID));

-- Tao bang	Employee(employee_id, full_name, email, location_id)
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
	employeeID INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(50),
    email VARCHAR(50),
    locationID INT UNSIGNED,
    FOREIGN KEY (locationID) REFERENCES Location(locationID));

-- Insert du lieu vao db
insert into Country (countryName) values ('Vietnam');
insert into Country (countryName) values ('China');
insert into Country (countryName) values ('Japan');
insert into Country (countryName) values ('Singapore');

insert into Location (streetAddress, postalCode, countryID) values ('5 Ridge Oak Trail', '10000', 1);
insert into Location (streetAddress, postalCode, countryID) values ('43 Corben Pass', '18160', 2);
insert into Location (streetAddress, postalCode, countryID) values ('70 Banding Center', '37511', 3);
insert into Location (streetAddress, postalCode, countryID) values ('12381 Summit Trail', '6604', 4);

insert into Employee (fullName, email, locationID) values ('Whitman Atchly', 'watchlyc@cloudflare.com', 1);
insert into Employee (fullName, email, locationID) values ('Rana Rundle', 'nn03@gmail.com', 1);
insert into Employee (fullName, email, locationID) values ('Esteban Nanuccioi', 'enanuccioi7@paginegialle.it', 1);
insert into Employee (fullName, email, locationID) values ('Reiko Shirtcliffe', 'rshirtcliffe2@fastcompany.com', 2);
insert into Employee (fullName, email, locationID) values ('Beaufort Rounding', 'broundinge@dagondesign.com', 2);
insert into Employee (fullName, email, locationID) values ('Cleo Mould', 'cmould8@hc360.com', 3);
insert into Employee (fullName, email, locationID) values ('Brittni Claisse', 'bclaisse9@pen.io', 3);
insert into Employee (fullName, email, locationID) values ('Hanna Britnell', 'hbritnell3@cafepress.com', 2);
insert into Employee (fullName, email, locationID) values ('Arleen Breache', 'abreache1@washington.edu', 4);
insert into Employee (fullName, email, locationID) values ('Eda Heinonen', 'eheinonen6@archive.org', 4);
insert into Employee (fullName, email, locationID) values ('Alicia Maly', 'amalyb@auda.org.au', 3);
insert into Employee (fullName, email, locationID) values ('Silvain Pitone', 'spitoned@telegraph.co.uk', 3);
insert into Employee (fullName, email, locationID) values ('Isabelita Farraway', 'ifarraway4@gmpg.org', 2);
insert into Employee (fullName, email, locationID) values ('Normand Bliss', 'nblissa@clickbank.net', 2);
insert into Employee (fullName, email, locationID) values ('Filberte Danick', 'fdanick5@twitpic.com', 4);

-- 2. Viết lệnh để 
-- 	a) Lấy tất cả các nhân viên thuộc Việt nam 
SELECT 	e.*
FROM 	Employee e
JOIN	Location l ON e.locationID = l.locationID
JOIN	Country c ON l.countryID = c.countryID
WHERE	c.countryName LIKE 'Vietnam';

-- 	b) Lấy ra tên quốc gia của employee có email là "nn03@gmail.com" 
SELECT 	c.*
FROM	country c
JOIN	location l ON c.countryID = l.countryID
JOIN	employee e ON e.locationID = l.locationID
WHERE	e.email LIKE 'nn03@gmail.com';

-- 	c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.
SELECT	c.CountryName, l.StreetAddress, COUNT(*) AS NumberOfEmployees
FROM	location l 
JOIN	country c ON l.countryID = c.countryID
JOIN	employee e ON l.locationID = e.locationID
GROUP BY c.CountryID;

-- 3. Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS max_employee;
DELIMITER $$
CREATE TRIGGER max_employee
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
	DECLARE v_countE INT;
    SELECT COUNT(*) INTO v_countE FROM employee WHERE NEW.locationID = locationID;
	IF v_countE >=10 THEN
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'Quoc gia nay khong the tuyen nhieu hon 10 thuc tap sinh.';
    END IF;
END $$
DELIMITER ;

insert into Employee (fullName, email, locationID) values ('Red Cristofari', 'rcristofari0@umn.edu', 1);
insert into Employee (fullName, email, locationID) values ('Concordia Digweed', 'cdigweed1@weebly.com', 1);
insert into Employee (fullName, email, locationID) values ('Uriah O''Dyvoie', 'uodyvoie2@accuweather.com', 1);
insert into Employee (fullName, email, locationID) values ('Jarrett Bugs', 'jbugs3@tinypic.com', 1);
insert into Employee (fullName, email, locationID) values ('Claire Matyatin', 'cmatyatin4@ibm.com', 1);
insert into Employee (fullName, email, locationID) values ('Shelden Giovannelli', 'sgiovannelli5@myspace.com', 1);
insert into Employee (fullName, email, locationID) values ('Karoly Aggs', 'kaggs6@pbs.org', 1);
insert into Employee (fullName, email, locationID) values ('Ettie Hyslop', 'ehyslop7@reference.com', 1);
insert into Employee (fullName, email, locationID) values ('Byran Favela', 'bfavela8@slideshare.net', 1);
insert into Employee (fullName, email, locationID) values ('Scott Lage', 'slage9@ustream.tv', 1);
insert into Employee (fullName, email, locationID) values ('Charmian Iacofo', 'ciacofoa@ezinearticles.com', 1);
insert into Employee (fullName, email, locationID) values ('Judie Buney', 'jbuneyb@amazon.co.jp', 1);
insert into Employee (fullName, email, locationID) values ('Inger Shreve', 'ishrevec@hhs.gov', 1);
insert into Employee (fullName, email, locationID) values ('Georgie Gever', 'ggeverd@wisc.edu', 1);
insert into Employee (fullName, email, locationID) values ('Carlyn Whitehead', 'cwhiteheade@rakuten.co.jp', 1);

-- 4. Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null
DROP TRIGGER IF EXISTS del_location;
DELIMITER $$
CREATE TRIGGER del_location
BEFORE DELETE ON location
FOR EACH ROW
BEGIN
	DECLARE v_locationID INT;
    SELECT locationID INTO v_locationID FROM location WHERE locationID = OLD.locationID;
	UPDATE employee SET locationID = NULL WHERE locationID = v_locationID;
END $$
DELIMITER ;

DELETE FROM location WHERE postalCode = 18160;