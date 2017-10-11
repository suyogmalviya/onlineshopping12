DROP DATABASE IF EXISTS onlineshoppingn;
CREATE DATABASE onlineshoppingn ;
USE onlineshoppingn;
CREATE TABLE category (
	id INT NOT NULL,
	NAME VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY(id)
);

INSERT  INTO `category`(`id`,`name`,`description`,`image_url`,`is_active`) 
VALUES (1,'praveen','dsdsad','787687686','dads');