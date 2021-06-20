-- Programming III
-- Task: Login System	
CREATE DATABASE IF NOT EXISTS `login` 
 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

--
-- table structure
--

CREATE TABLE IF NOT EXISTS `login`.`login` (
	`ID` int(4) NOT NULL AUTO_INCREMENT, 
	`name` varchar(50),
	`salt` varchar(50),
	`password` varchar(100),
	 PRIMARY KEY (ID)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

--
-- Passwords, Tom = password, Dean = thomas, Sarah = jane, Koby = tell
--


USE login;
INSERT INTO login (name,salt,password) VALUES ("Tom","vSsPSrGZJkg2vbKZ1kJHEg==","a8c918e7a7cabcd1c7b5cf0cdf2bb0c6");
INSERT INTO login (name,salt,password) VALUES ("Dean","GeakKr43IDmAtDjhbwQ1Fw==","92bd5f1fbc79a8fb54eb7aef0a911548");
INSERT INTO login (name,salt,password) VALUES ("Sarah","BTSr6aMEevF6SElDwWVyRA==","68c1b89e805ebc25786a104c3b349dc1");
INSERT INTO login (name,salt,password) VALUES ("Koby","WnCrVujbIjRdYIwzFIVG9A==","1e5c13783536f5ea0aaddc4ee385222f");

USE login;
SELECT * FROM login;

