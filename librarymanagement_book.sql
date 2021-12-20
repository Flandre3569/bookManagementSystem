create table book
(
    bookId     varchar(11)   not null
        primary key,
    bookName   varchar(255)  null,
    author     varchar(255)  null,
    price      double(10, 2) null,
    remarks    varchar(255)  null,
    isBorrowed int           null
);

INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1000', '人间失格', '太宰治', 18, '社会心理', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1001', '我们仨', '杨绛', 15, '我们仨的故事', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1002', '解忧杂货店', '东野圭吾', 29, '悬疑精品', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1004', '青苹果', '小神刘', 23, '苹果', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1005', '饭神', '小凡', 55, '吃饭艺术', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1006', '酒货', '金刚', 45, '无', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1007', '蝙蝠侠', '小帅', 34, '无', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1008', '大侠', '小夏', 56, '无', 1);
INSERT INTO librarymanagement.book (bookId, bookName, author, price, remarks, isBorrowed) VALUES ('1234', 'xiaobai', '小白', 20, '小白', 0);
