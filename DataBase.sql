// LOGIN TABLE
CREATE TABLE LOGINDETAIL (
    USER_ID NUMBER PRIMARY KEY,
    USER_NAME VARCHAR2(20 ), 
    USER_FIRST_NAME VARCHAR2(20 ), 
    USER_LAST_NAME VARCHAR2(20 ), 
    USER_CITY VARCHAR2(20 ), 
    USER_EMAIL VARCHAR2(30 ), 
    USER_MOBILE NUMBER(20)
);

// creating sequence of auto increment of user id 
CREATE SEQUENCE AUTO_INCREMENT_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

// creating trigger of sequence
CREATE OR REPLACE TRIGGER LOGINDETAIL_AUTO_INCREMENT
BEFORE INSERT ON LOGINDETAIL
FOR EACH ROW
BEGIN
    :NEW.USER_ID := AUTO_INCREMENT_SEQ.NEXTVAL;
END;
/

INSERT INTO LOGINDETAIL (USER_NAME, USER_FIRST_NAME, USER_LAST_NAME, USER_CITY, USER_EMAIL, USER_MOBILE)
VALUES ('harihs', 'harish', 'kumawat', 'mumbai', 'harish@example.com', 1234567890);

INSERT INTO LOGINDETAIL (USER_NAME, USER_FIRST_NAME, USER_LAST_NAME, USER_CITY, USER_EMAIL, USER_MOBILE)
VALUES ('jane_doe', 'Jane', 'Doe', 'pune', 'jane.doe@example.com', 9876543210);


// Question table 
CREATE TABLE QUESTION
   (QUS_ID NUMBER PRIMARY KEY,	
    QUS VARCHAR2(50 ), 
	OPTION1  VARCHAR2(50 ), 
	OPTION2 VARCHAR2(50 ), 
	OPTION3 VARCHAR2(50  ), 
	OPTION4 VARCHAR2(50  ), 
	ANSWER VARCHAR2(50 )
   )

// creating sequence of auto increment of question id 
CREATE SEQUENCE AUTO_INCREMENT_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

// creating trigger of sequence
CREATE OR REPLACE TRIGGER QUESTION_AUTO_INCREMENT
BEFORE INSERT ON QUESTION
FOR EACH ROW
BEGIN
    :NEW.QUS_ID := AUTO_INCREMENT_SEQ.NEXTVAL;
END;
/


INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'What is the size of int in Java?', '2 bytes', '4 bytes', '8 bytes', '16 bytes', 'B');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'Which of the following is not a Java keyword?', 'class', 'if', 'then', 'void', 'C');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'Which operator is used to compare two values?', '=', '==', '===', '<>', 'B');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
('Which of these is a valid identifier in Java?', '123abc', '_123abc', '123_abc', 'None of these', 'B');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'Which method is the entry point of any Java ?', 'main()', 'start()', 'run()', 'init()', 'A');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'to used to handle exceptions in Java?', 'try-catch', 'throw-try', 'try-finally', 'throw-catch', 'A');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'What is the default value of a boolean ', 'true', 'false', 'null', '0', 'B');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
('Which keyword is used to inherit a class in Java?', 'inherits', 'extends', 'implements', 'super', 'B');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'Which of the following is not an access modifier?', 'public', 'protected', 'private', 'static', 'D');

INSERT INTO QUESTION (  QUS, OPTION1, OPTION2, OPTION3, OPTION4, ANSWER) VALUES
( 'What is the extension of a compiled Java file?', '.java', '.js', '.class', '.exe', 'C');




// response table
CREATE TABLE RESPONSE 
   (RESPONSE_ID NUMBER PRIMARY KEY,
    USER_ID NUMBER NOT NULL,
    USER_NAME VARCHAR2(20 ), 
	SCORE VARCHAR2(20),
    CONSTRAINT FK_USER_ID FOREIGN KEY (USER_ID) REFERENCES LOGINDETAIL(USER_ID)
   )

//// creating sequence of auto increment of response id 
CREATE SEQUENCE AUTO_INCREMENT_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;  

// creating trigger for sequence
CREATE OR REPLACE TRIGGER RESPONSE_AUTO_INCREMENT
BEFORE INSERT ON RESPONSE
FOR EACH ROW
BEGIN
    :NEW.RESPONSE_ID := AUTO_INCREMENT_SEQ.NEXTVAL;
END;
/

INSERT INTO RESPONSE(USER_ID,USER_NAME,SCORE) VALUES (1,'HARISH','15');

// from delete the table 
drop table logindetail;
drop table response;
drop table question;
DELETE logindetail;

