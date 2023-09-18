-- DROP & CREATE SEQUENCE, TABLE, DUMMY DATA?

DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
CID VARCHAR2(50) NOT NULL PRIMARY KEY,
CPW VARCHAR2(50) NOT NULL,
CNAME VARCHAR2(50) NOT NULL,
CTEL VARCHAR2(50),
CEMAIL VARCHAR2(50),
CADDRESS VARCHAR2(50),
CBIRTH DATE,
CGENDER VARCHAR2(1),
CRDATE DATE DEFAULT SYSDATE
);

-- 1. 회원가입시 아이디 중복체크 (public int confirmID (String id)
SELECT COUNT(*) COUNTS FROM CUSTOMER WHERE CID = 'aaa';

-- 2. 회원가입 insert (public int joinCustomer(CustomerDto customer)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
VALUES ('aaa', 'ccc', '장장', '010-9999-8888','tr@tr.com','서울마포',TO_DATE('1999-01-01','YYYY-MM-DD'), 'm' );

-- 3. 로그인 :public int loginCheck (String id, String pw)
SELECT * FROM CUSTOMER WHERE CID = 'aaa'; 
-- 반드시 1줄출력, 0 OR 1


-- 4. 로그인 성공시 session에 setattribute  (public CustomerDto getCustomer (String id)
SELECT * FROM CUSTOMER WHERE CID = 'aaa';


-- 5. 회원정보수정 public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW = '222',
CNAME = '김김김',
CTEL = '010-8888-7777',
CEMAIL = 'RE@RE.COM',
CADDRESS = '부산서구',
CBIRTH = '1999-03-03',
CGENDER = 'F'
WHERE CID = 'aaa';


SELECT * FROM CUSTOMER;


