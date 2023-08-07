-- DDL & 더미데이터입력 (create table...) + commit

DROP TABLE PERSON;
DROP TABLE JOB;
DROP SEQUENCE PERSON_PNO_SEQ;

CREATE TABLE JOB (
JNO NUMBER(2,0) PRIMARY KEY,
JNAME VARCHAR2 (20) UNIQUE
);

CREATE SEQUENCE PERSON_PNO_SEQ START WITH 1 MAXVALUE 99999 NOCACHE NOCYCLE;


CREATE TABLE PERSON (
PNO NUMBER(5) PRIMARY KEY,
JNO NUMBER(2,0) NOT NULL,
PNAME VARCHAR2 (50) NOT NULL,
KOR NUMBER(3,0) CHECK (KOR BETWEEN 0 AND 100),
ENG NUMBER(3,0) CHECK (ENG BETWEEN 0 AND 100),
MAT NUMBER(3,0) CHECK (MAT BETWEEN 0 AND 100),
FOREIGN KEY (JNO) REFERENCES JOB (JNO)
);

INSERT INTO JOB VALUES (10, '배우');
INSERT INTO JOB VALUES (20,'가수');
INSERT INTO JOB VALUES (30,'개그맨');
SELECT * FROM JOB; 

INSERT INTO PERSON VALUES (PERSON_PNO_SEQ.NEXTVAL, 10,'정우성',90,80,81);
INSERT INTO PERSON VALUES (PERSON_PNO_SEQ.NEXTVAL, 10,'박세영',80,90,80);
INSERT INTO PERSON VALUES (PERSON_PNO_SEQ.NEXTVAL, 20,'배수지',20,90,90);
DROP TABLE PERSON;

SELECT * FROM PERSON;
COMMIT;