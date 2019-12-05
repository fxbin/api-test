CREATE TABLE IF NOT EXISTS `user`(
  `id` INT UNSIGNED AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `age` INTEGER NOT NULL,
  `create_date` DATE,
  PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `address`(
  `id` INT UNSIGNED AUTO_INCREMENT,
  `userId` INT ,
  `address` VARCHAR(100) NOT NULL,
  `create_date` DATE,
  PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO USER (username,age,create_date)VALUES ('TOM',10,'2019-10-11 12:10:10');
INSERT INTO USER (username,age,create_date)VALUES ('DONE',15,'2019-10-10 12:10:10');
INSERT INTO USER (username,age,create_date)VALUES ('ECHO',20,'2019-10-15 12:10:10');
INSERT INTO USER (username,age,create_date)VALUES ('MARY',10,'2019-10-10 12:10:10');
INSERT INTO address (userId,address,create_date)VALUE (1,'chengdu','2019-11-12 00:00:00');
INSERT INTO address (userId,address,create_date)VALUE (2,'beijing','2019-11-12 00:00:00');
INSERT INTO address (userId,address,create_date)VALUE (3,'shanghai','2019-11-12 00:00:00');
INSERT INTO address (userId,address,create_date)VALUE (4,'hangzhou','2019-11-12 00:00:00');