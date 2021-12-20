create table borrow
(
    userId     varchar(11)  null,
    bookId     varchar(11)  not null
        primary key,
    bookName   varchar(255) null,
    author     varchar(255) null,
    borrowTime date         null,
    returnTime date         null
);

INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('222', '1000', '人间失格', '太宰治', '2021-06-25', '2021-08-24');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('222', '1001', '我们仨', '杨绛', '2021-06-25', '2021-08-24');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('222', '1002', '解忧杂货店', '东野圭吾', '2021-06-25', '2021-08-24');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('222', '1004', '青苹果', '小神刘', '2021-06-25', '2021-08-24');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('555', '1005', '饭神', '小凡', '2021-06-25', '2021-09-03');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('555', '1006', '酒货', '金刚', '2021-06-25', '2021-09-03');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('555', '1007', '蝙蝠侠', '小帅', '2021-06-25', '2021-09-03');
INSERT INTO librarymanagement.borrow (userId, bookId, bookName, author, borrowTime, returnTime) VALUES ('555', '1008', '大侠', '小夏', '2021-06-25', '2021-08-24');
