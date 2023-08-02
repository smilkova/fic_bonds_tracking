DROP table IF EXISTS book;
DROP table IF EXISTS users;
DROP table IF EXISTS counter_party;
DROP table IF EXISTS book_user;
DROP table IF EXISTS securities;
DROP table IF EXISTS trade;


CREATE TABLE book (
    book_id INT auto_increment primary key,
    book_name VARCHAR(200) NOT NULL
);

CREATE TABLE users (
    user_id INT auto_increment primary key,
    bondholder VARCHAR(500) NOT NULL
);

create table counter_party (
    cp_id int auto_increment primary key,
    user_id int not null,
    constraint user_id_fk2 foreign key (user_id) references users(user_id)
);

CREATE TABLE book_user (
    book_user_id int auto_increment primary key,
    book_id int not null,
    user_id int not null,
    constraint book_id_fk1 foreign key (book_id) references book(book_id),
    constraint user_id_fk1 foreign key (user_id) references users(user_id)
);

create table securities (
    security_id int auto_increment primary key,
    unit_price decimal(6,2) not null,
    bond_currency varchar(3) not null,
    coupon_rate decimal(5,3) not null,
    cusip varchar(20) not null,
    isin varchar(20) not null,
    face_value int(4) not null,
    issuer_name varchar(200) not null,
    mature_date date default current_timestamp,
    status varchar(30) default not null, --change from enum active inactive
    bond_type varchar(4) not null, --govn, sovn, corp
    book_id int not null,
    constraint book_id_fk2 foreign key (book_id) references book(book_id)
);

create table trade (
    trade_id int auto_increment primary key,
    trade_type varchar(30) default null, --changed from enum, buy sell
    currency varchar(3) not null,
    quantity int(5) not null,
    settle_date date default current_timestamp,
    t_status varchar(10) not null,
    trade_date date default current_timestamp,
    book_id int not null,
    security_id int not null,
    cp_id int not null,
    constraint book_id_fk3 foreign key (book_id) references book(book_id),
    constraint security_id_fk1 foreign key (security_id) references securities(security_id),
    constraint cp_id_fk foreign key (cp_id) references counter_party(cp_id)

);