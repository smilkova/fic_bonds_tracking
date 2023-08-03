--book database
INSERT INTO book(book_id, name) VALUES (1,'trading_book_1');
INSERT INTO book(book_id, name) VALUES (2,'trading_book_2');
INSERT INTO book(book_id, name) VALUES (3,'trading_book_3');
INSERT INTO book(book_id, name) VALUES (4,'trading_book_4');
INSERT INTO book(book_id, name) VALUES (5,'trading_book_6');




--users database
INSERT INTO users(user_id, name, email, role) VALUES (1, 'Christopher Chan', 'Chris1@bank.com', 'Trader');
INSERT INTO users(user_id, name, email, role) VALUES (2, 'Jimin Park', 'Jimin1@bank.com', 'Trader');
INSERT INTO users(user_id, name, email, role) VALUES (3, 'Felix Lee', 'fLee@bank.com', 'Trader');


--book_users
INSERT INTO book_user(book_id, user_id) VALUES(1,1);
INSERT INTO book_user(book_id, user_id) VALUES(2,1);
INSERT INTO book_user(book_id, user_id) VALUES(3,1);
INSERT INTO book_user(book_id, user_id) VALUES(1,2);
INSERT INTO book_user(book_id, user_id) VALUES(1,3);
INSERT INTO book_user(book_id, user_id) VALUES(4,3);
INSERT INTO book_user(book_id, user_id) VALUES(4,2);
INSERT INTO book_user(book_id, user_id) VALUES(5,2);
