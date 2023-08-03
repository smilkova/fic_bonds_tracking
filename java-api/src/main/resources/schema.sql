DROP DATABASE IF EXISTS `bonds`;
CREATE DATABASE `bonds`;
use bonds;

CREATE TABLE `book` (
  `book_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) NOT NULL
);

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
);

CREATE TABLE `counter_party` (
  `cp_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) NOT NULL
);

CREATE TABLE `book_user` (
  `book_id` int NOT NULL,
  `user_id` int NOT NULL,
  KEY `FK1_book_id` (`book_id`),
  KEY `FK_user_id` (`user_id`)
);


CREATE TABLE `securities` (
  `security_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `isin` varchar(50) DEFAULT NULL,
  `cusip` varchar(50) DEFAULT NULL,
  `issuer_name` varchar(255) NOT NULL,
  `maturity_date` datetime NOT NULL,
  `coupon` float NOT NULL,
  `type` varchar(255) NOT NULL,
  `face_value` float NOT NULL,
  `currency` varchar(10) NOT NULL,
  `status` varchar(32) DEFAULT NULL
);

CREATE TABLE `trade` (
  `trade_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `book_id` int NOT NULL,
  `security_id` int NOT NULL,
  `counterparty_id` int NOT NULL,
  `currency` varchar(10) NOT NULL,
  `status` varchar(32) NOT NULL,
  `quantity` int NOT NULL,
  `unit_price` float NOT NULL,
  `buy_sell` varchar(32) NOT NULL,
  `trade_date` datetime NOT NULL,
  `settlement_date` datetime NOT NULL,
  KEY `FK_security_id` (`security_id`),
  KEY `FK_counterparty_id` (`counterparty_id`),
  KEY `FK_book_id` (`book_id`)
);

ALTER TABLE book_user ADD PRIMARY KEY(book_id, user_id);

