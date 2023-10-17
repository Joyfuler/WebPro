DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE MVC_MEMBER;
DROP TABLE ADMIN CASCADE CONSTRAINTS;
----------------------------------------------------------------------
--                    MVC_MEMBER    테이블 생성                      --
----------------------------------------------------------------------
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30) UNIQUE,
    mPHOTO VARCHAR2(30) NOT NULL, -- 회원가입시 사진업로드를 안 할시 기본 이미지로(NOIMG.JPG)
    mBIRTH DATE,
    mADDRESS VARCHAR2(300),
    mRDATE DATE DEFAULT SYSDATE NOT NULL        
);

-- DUMMY DATA
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jang','1','장동건',null,'jang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jo','1','조현우',null,'jo.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kang','1','강동원',null,'kang.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kim','1','김태희',null,'kim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lee','1','이선빈',null,'lee.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lim','1','임요한',null,'lim.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('park','1','박보검',null,'park.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('rain','1','비',null,'rain.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('sgy','1','송가연',null,'songkayeon.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('son','1','손흥민',null,'son.jpg',null,null);
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song','1','송중기',null,'song.jpg',null,null);
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;
commit;
----------------------------------------------------------------------
--                   FILEBOARD 테이블 생성                           --
----------------------------------------------------------------------

SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
CREATE TABLE FILEBOARD (
    FID NUMBER(6) PRIMARY KEY,
    FTITLE VARCHAR2(100) NOT NULL,
    FCONTENT VARCHAR2 (4000),
    FFILENAME VARCHAR2(100),
    FRDATE DATE DEFAULT SYSDATE NOT NULL,
    FHIT NUMBER(6) NOT NULL,
    FGROUP NUMBER(6) NOT NULL,
    FSTEP NUMBER(6) NOT NULL,
    FINDENT NUMBER(6) NOT NULL,
    FIP VARCHAR2(30) NOT NULL,
    MID VARCHAR2(30) REFERENCES MVC_MEMBER (MID)
);

CREATE SEQUENCE FILEBOARD_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;

INSERT INTO FILEBOARD (FID, FTITLE,FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, '안녕하세요ㅎ', '날씨가좋네요^^', '11.JPG', 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.1.1.2');
UPDATE FILEBOARD SET MID = 'go' WHERE FID = '2'; 
INSERT INTO FILEBOARD (FID, FTITLE,FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP,MID)
    VALUES (FILEBOARD_SEQ.NEXTVAL, '안녕하세요22', '날씨가좋네요^^', '11.JPG', 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.1.1.5', 'gayun');    
COMMIT;

INSERT INTO FILEBOARD (FID, FTITLE,FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP,MID)
    VALUES (FILEBOARD_SEQ.NEXTVAL, '안녕하세요44', '날씨가좋네요^^', '11.JPG', 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.5.3.5', 'gayun');    
 
 INSERT INTO FILEBOARD (FID, FTITLE,FCONTENT, FFILENAME, FHIT, FGROUP, FSTEP, FINDENT, FIP,MID)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 're: 안녕하세요44', '날씨가좋네요^^', '11.JPG', 0, 4, 1, 1, '127.5.3.5', 'gayun');    
----------------------------------------------------------------------
--                   ADMIN TABLE    테이블 생성                      -- 
----------------------------------------------------------------------
CREATE TABLE ADMIN(
AID VARCHAR2(30) PRIMARY KEY,
APW VARCHAR2(30),
ANAME VARCHAR2(30)
);

INSERT INTO ADMIN (AID, APW, ANAME)
     VALUES ('admin01', '111', '김관리');
COMMIT;
------------------------------------------------
--                 확인용                      -- 
------------------------------------------------
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
SELECT F.*,M.MNAME FROM FILEBOARD F, MVC_MEMBER M WHERE F.MID = M.MID AND FID = 4;
SELECT * FROM ADMIN WHERE AID = 'admin01' AND APW = '111';
SELECT * FROM ADMIN WHERE AID = 'admin01';
SELECT ROWNUM RN, A.*, M.MNAME FROM (SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) A, MVC_MEMBER M WHERE A.MID = M.MID;
SELECT * FROM (SELECT ROWNUM RN, A.*, M.MNAME FROM (SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP) A, MVC_MEMBER M WHERE A.MID = M.MID) WHERE RN BETWEEN 1 AND 4;
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MID = 'gayun';
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MEMAIL = 'go@naver.com';
SELECT COUNT(*) CNT FROM FILEBOARD;
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FID = 4;
UPDATE FILEBOARD SET FTITLE = '안녕하세요33', FCONTENT = '날씨가 너무좋네요^^', FFILENAME = '12.JPG', FIP = '128.12.5.3' WHERE FID = 4;
DELETE FROM FILEBOARD WHERE FID=4;
select * from admin;
ROLLBACK;
COMMIT;
DELETE FROM FILEBOARD WHERE MID = 'AAA';
SELECT * FROM MVC_MEMBER;