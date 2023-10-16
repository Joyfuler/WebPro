--테이블제거
DROP TABLE MVC_MEMBER;
--테이블생성
CREATE TABLE MVC_MEMBER(
MID VARCHAR2(30) PRIMARY KEY,
MPW VARCHAR2(30) NOT NULL,
MNAME VARCHAR2(30) NOT NULL,
MEMAIL VARCHAR2(30),
MPHOTO VARCHAR2(30) NOT NULL, -- 회원가입시 사진업로드 안할 경우 기본이미지(noimg.jpg) 사용
MBIRTH DATE,
MADDRESS VARCHAR2(300),
MRDATE DATE  DEFAULT SYSDATE NOT NULL
);


--더미데이터
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('son','1','손흥민','son@naver.com','son.jpg','1992/07/08','강원도');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
commit;
SELECT * FROM MVC_MEMBER ORDER BY mRDATE DESC;


-- DAO에 들어갈 QUERY
-- (1) 회원mid 중복체크
SELECT COUNT(*) CNT FROM MVC_MEMBER WHERE MID = 'gayun';
-- (2) 회원가입
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('aaa','111','넌짱','hong@naver.com','NOIMG.JPG','1989/11/05','서울시');
    COMMIT;
-- (3) 로그인
SELECT * FROM MVC_MEMBER WHERE MID = 'CHANG' AND MPW = '111';
-- (4) mid로 dto 가져오기 (로그인 성공시 session.setAttribute)
SELECT * FROM MVC_MEMBER WHERE MID = 'CHANG';
-- (5) 회원정보 수정
UPDATE MVC_MEMBER
SET MPW= '222', MNAME= '홍수길수동수', MEMAIL='HONGS@NAVER.CO.KR', MPHOTO = '222.JPG', MBIRTH = '1990-01-02', 
MADDRESS = '부산시'
WHERE MID = 'CHANG' AND MPW = '111';

COMMIT;
-- (6) 회원 리스트 (페이징)
SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A) WHERE RN BETWEEN 2 AND 4;
-- (7) 회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
-- (8) 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID = '222';
COMMIT;
select * from mvc_member;