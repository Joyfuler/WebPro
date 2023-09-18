-- 테이블 지운 후 만들기

DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
ID VARCHAR2(30) NOT NULL PRIMARY KEY,
PW VARCHAR2(30) NOT NULL,
NAME VARCHAR2(30) NOT NULL,
PHONE1 VARCHAR2(5),
PHONE2 VARCHAR2(5),
PHONE3 VARCHAR2(5),
GENDER VARCHAR2(1),
EMAIL VARCHAR2(30),
BIRTH DATE,
ADDRESS VARCHAR2(200),
RDATE DATE NOT NULL
);
-- 참조와 관계없이 무조건 삭제
SELECT * FROM MEMBER;

-- 1. 회원가입시 id 중복체크 : public int confirmID(String id)
SELECT count(*) FROM MEMBER WHERE ID='JANG';
-- 0이면 중복 x, 1이면 중복o

-- 2. 회원가입 INSERT : public int joinMember(MemberDto member) --> 각 매개변수를 모두 합쳐 객체로 만든 member.  이후 member.getId()....
INSERT INTO MEMBER (ID,PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
VALUES ('JANG', '111', '장진', '010','9999','8888','m','hong@hong.com',TO_DATE('1999-12-12','yyyy-mm-dd'),'서울서대문',SYSDATE);
SELECT * FROM MEMBER;
-- int인 이유는 성공 or 실패이므로

-- 3. 로그인  : public int  loginCheck (String id, String pw) --
SELECT * FROM MEMBER WHERE ID = 'A';
-- 이후 IF (RS.NEXT()가 FALSE라면 ALERT로 아이디/비밀번호가 틀립니다를 출력


-- 4. 로그인 성공시 SESSION에 setAttribute할 회원 정보 (id로 dto 가져오기)
-- public MemberDto getMember (String id)
-- 만일 정보가 일치하면 세션을 객체화하여 넘김
SELECT * FROM MEMBER WHERE ID LIKE  '%A%';


-- 5. 회원정보 수정 (아이디는 수정불가, 나머지는 수정가능)
-- public int modifyMember (MemberDto dto) --> 수정해야 할 매개변수를 가져와 객체로
UPDATE MEMBER SET PW = '111', 
NAME = '신길동',
PHONE1='010'
,PHONE2='8888',
PHONE3='7777',
GENDER='M',
EMAIL='aa@bb.co.kr',
BIRTH='1999-01-01',
ADDRESS='부산서구'
WHERE ID = 'AAA';

SELECT * FROM MEMBER;
INSERT INTO MEMBER (ID,PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
VALUES ('AAA', '111', '홍길동', '010','6666','5555','m','honggildong@hong.com',TO_DATE('1977-03-11','yyyy-mm-dd'),'부산동구',SYSDATE);


