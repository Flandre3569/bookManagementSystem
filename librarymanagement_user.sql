create table user
(
    userId   varchar(25) not null
        primary key,
    password varchar(25) null,
    identity varchar(25) null,
    bookNum  int         null
);

INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('123', '123', '用户', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('222', '123', '用户', 4);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('333', '123', '用户', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('444', '123', '用户', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('555', '666', '用户', 4);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('666', '666', '用户', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('999', '999', '用户', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('cyx', '123', '管理员', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('fmx', '123', '管理员', 0);
INSERT INTO librarymanagement.user (userId, password, identity, bookNum) VALUES ('lgz', '123', '管理员', 0);
