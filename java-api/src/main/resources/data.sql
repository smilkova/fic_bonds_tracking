--book database
INSERT INTO book(book_id, name) VALUES (1,'trading_book_1');
INSERT INTO book(book_id, name) VALUES (2,'trading_book_1');
INSERT INTO book(book_id, name) VALUES (3,'trading_book_2');
INSERT INTO book(book_id, name) VALUES (4,'trading_book_2');
INSERT INTO book(book_id, name) VALUES (5,'trading_book_3');
INSERT INTO book(book_id, name) VALUES (6,'trading_book_2');
INSERT INTO book(book_id, name) VALUES (7,'trading_book_2');
INSERT INTO book(book_id, name) VALUES (8,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (9,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (10,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (11,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (12,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (13,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (14,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (15,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (16,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (17,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (18,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (19,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (20,'trading_book_6');
INSERT INTO book(book_id, name) VALUES (21,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (22,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (23,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (24,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (25,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (26,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (27,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (28,'trading_book_4');



--users database
CREATE TABLE users (
  user_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  role varchar(255) NOT NULL,
  PRIMARY KEY (user_id)
);

