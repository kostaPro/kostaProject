DROP TABLE article_tb;
DROP TABLE board_tb;
DROP TABLE comment_tb;

DROP SEQUENCE article_seq;
DROP SEQUENCE board_seq;
DROP SEQUENCE comment_seq;

CREATE TABLE article_tb(
id NUMBER PRIMARY KEY,
title VARCHAR2(100),
authorName VARCHAR2(50),
regDate DATE,
contents VARCHAR2(2000),
boardId NUMBER);

CREATE TABLE board_tb(
id NUMBER PRIMARY KEY,
name VARCHAR2(100),
createdDate DATE,
creatorName VARCHAR2(50)
);

CREATE TABLE comment_tb(
id NUMBER PRIMARY KEY,
authorName VARCHAR2(50),
regDate DATE,
comments VARCHAR2(1000),
articleId NUMBER
);

CREATE SEQUENCE article_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comment_seq START WITH 1 INCREMENT BY 1;

INSERT INTO board_tb (id, name, createdDate, creatorName) VALUES(board_seq.nextval, 'Java', sysdate, 'JIN');
COMMIT;