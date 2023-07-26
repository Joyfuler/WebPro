-- [VII] DDL, DML, DCL
-- SQL = DDL(테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블의 모든 데이터 제거)
--          DML (SELECT, INSERT, DELETE, UPDATE)
--          DCL(사용자계정 생성, 사용자에게 권한부여, 권한박탈, 사용자계정 삭제, 트랜젝션 명령어)            

-- ★★★★★ DDL ★★★★★
-- 1. 테이블 생성(CREATE TABLE 테이블명 ....) : 테이블 구조를 정의
CREATE TABLE BOOK ( --이후 필드와 타입 등 지정..
BOOKID NUMBER(4), -- BOOKID필드 지정.. 타입은 숫자 4자리
BOOKNAME VARCHAR2 (20), -- BOOKNAME 필드 타입은 문자 20바이트. VARCHAR2는 최대 4천까지 들어감. 혹은 제한이 없는 CLOB로도 사용이 가능함.
PUBLISHER VARCHAR2 (20), -- 출판사 정보
RDATE DATE,                   -- 등록일자. 타입은 DATE(날짜)
PRICE NUMBER(7,2), -- 책가격.. 전체 7자리 중, 소숫점 2자리까지 소숫점
PRIMARY KEY (BOOKID) -- BOOKID는 유일한 값이므로 중복이 불가능하도록 설정하는 프라이머리키. NULL값 또한 입력이 불가능.
);

SELECT * FROM BOOK;
DESC BOOK; -- BOOKID가 프라이머리키이므로 NOTNULL이 표시된 것.
DROP TABLE BOOK; -- 테이블을 삭제함. 연습용으로 DROP CREATE... (실무에서사용했다큰일나니주의)
CREATE TABLE BOOK (
BOOKID NUMBER (4) PRIMARY KEY, --프라이머리키를 타입 바로 옆에 기입할 수도 있음.
BOOKNAME VARCHAR2 (20),
PUBLISHER VARCHAR2 (20),
RDATE DATE,
PRICE NUMBER (8,2)
);

-- 연습용으로쓰던 DEPT 테이블 만들기
CREATE TABLE DEPT01 (
    DEPTNO NUMBER (2) PRIMARY KEY, -- 10,20,30,40...
    DNAME VARCHAR2 (14),
    LOC VARCHAR2(13)
);

SELECT * FROM DEPT01;
-- EMP01 : EMPNO(숫자네자리 및 PK), ENAME(문자10), SAL(숫자7,2), DEPTNO (숫자2, DEPT와 FK로 연결되어 있음)
CREATE TABLE EMP01 (
EMPNO NUMBER (4) PRIMARY KEY,
ENAME VARCHAR2 (10),
SAL NUMBER(7,2),
DEPTNO NUMBER(2) REFERENCES DEPT01 (DEPTNO) -- DEPT01 중 DEPTNO에 저장된 값만 입력이 가능하도록 FK를 설정.
);

-- 서브쿼리를 이용한 테이블 생성...? (BACKUP)
CREATE TABLE EMP02
AS
SELECT * FROM EMP; -- 서브쿼리 결과로 EMP02테이블 생성 후 데이터로 들어감 (제약조건 미포함) 즉 백업 용도로 사용.

SELECT * FROM EMP02;
-- 특정 필드만 뽑아가고 싶다면?
CREATE TABLE EMP03 -- 특정 행 출력
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP;

CREATE TABLE EMP04
AS
SELECT * FROM EMP WHERE DEPTNO=10; -- DEPTNO가 10인 부서 데이터만 추출하여 EMP04테이블추출.. 특정열출력
SELECT * FROM EMP04;
-- EMP05는 EMP의 구조만 추출.. 데이터를 안 넣겠다면?
CREATE TABLE EMP05
AS
SELECT * FROM EMP WHERE 1>2; --WHERE 조건을 일부러 FALSE로 설정하여 타이틀만 가져오고, 데이터를 버리도록 할 수 있음.
SELECT * FROM EMP05;

SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM은 EMP에서 행을 읽어들인 순서를 말함.

-- 2. 테이블 구조변경 (ALTER TABLE 테이블명 ADD () || MODIFY () || DROP ()  ... 정처기에서 나온다고함...
-- (1) 필드추가 (ADD)
SELECT * FROM EMP03; -- EMPNO(숫자4자리), ENAME(문자10자리),DEPTNO(숫자2자리) 
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7)); -- 해당 타입의 JOB, SAL 테이블을 추가함.
SELECT * FROM EMP03;

-- (2) 필드 수정 (MODIFY)
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 오류. 이미 숫자데이터가 들어가 있기 때문에, 숫자 타입으로만 변경이 가능함.
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5));
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4)); -- 현재 JOB 데이터는 모두 NULL이기 때문에 마음대로 변경이 가능함.
SELECT MAX(LENGTH(ENAME)) FROM EMP03; -- ENAME은 6바이트밖에 안씀... EMP03의 ENAME은 6글자가 최장길이이므로 6까지는 줄일 수 있음.
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6)); -- 즉 기존 데이터의 길이까지는 축소가 가능. (실제로는 거의 쓰이지 않지만)

-- (3) 필드 삭제 (DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB이라는 필드(행)가 삭제됨.
ALTER TABLE EMP03 DROP COLUMN DEPTNO;

-- 3. 테이블 삭제 (DROP TABLE 테이블명) -- 폭풍위험. 사용 각별히주의!!!
DROP TABLE EMP01; --EMP01 테이블을 삭제함
CREATE TABLE EMP01
AS
SELECT * FROM EMP;
SELECT * FROM EMP01;
DROP TABLE DEPT; -- 오류. EMP가 DEPT의 DEPTNO를 REFERENCES 하고 있으므로, 먼저 삭제할 수 없음. EMP 테이블을 삭제한 후라면 가능

-- 4. 테이블의 모든 행을 제거 (TRUNCATE TABLE 테이블명)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- 이 역시 ROLLBACK이 불가하니 주의할 것.
SELECT * FROM EMP03;

-- 5. 테이블명 변경 (RENAME 테이블명 TO 바꿀 테이블명.. 실무에서는 거의 없으나 정처기에선 나올수도)
RENAME EMP03 TO EMP003;
SELECT * FROM EMP003;

-- 6. 데이터 딕셔너리 (데이터베이스 자원을 효율적으로 관리하기 위한 시스템 테이블. 단 접근 불가)
-- 데이터 딕셔너리 뷰 - 사람에 따라서 접근할 수 있는 데이터가 서로 다른 가상 테이블. 월급 등...
-- (1) USER_XXX : 현 계정에서 소유하고 있는 객체(TABLE 테이블, CONSTRAINTS 제약조건, VIEW뷰, INDEX인덱스) 확인
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_VIEWS; --만든적이 없으므로 데이터 X
SELECT * FROM USER_INDEXES;

-- (2) ALL_XXX : 현 계정에서 소유하고 있진 않지만, 접근할 수 있는 객체를 확인함.
SELECT * FROM ALL_TABLES; --현재 접속한 SCOTT은 DBA 권한이므로, 모두 접근이 가능
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
SELECT * FROM ALL_INDEXES;

-- (3) DBA_XXX : DBA 권한에서만 접근 가능한 DBMS의 모든 객체 (테이블, 제약조건, 뷰, 인덱스) - 현재 접속한 SCOTT이 DBA 권한을 가지고 있으므로 ALL과 차이가 없음.
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;
SELECT * FROM DBA_INDEXES;

-- ★★★★★ DML ★★★★★ -- ROLLBACK 가능한 명령어들
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, 값3....); -- 이 경우 모든 필드의 값을 반드시 넣어야 함. 
-- 값을 넣고 싶지 않다면 VALUES를 빼고 기입하는 방법을 사용할 수도 있음.
-- INSERT INTO 테이블명 (필드1, 필드2, ..) VALUES (값1, 값2, ...) 이 중 VALUES가 지정되지 않은 필드는 NULL이 됨.

SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'SEOUL');
INSERT INTO DEPT01 VALUES (60, 'SALES', NULL); --명시적인 NULL추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (70, 'RESEARCH', '서대문'); -- 필드명 VALUES 필드값
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (80, 'IT'); -- 묵시적인 NULL추가. 명시되지 않은 필드에는 자동으로 NULL이 산입됨
COMMIT; -- 추가한 데이터를 영구적으로 반영. 트랜젝션 명령어(DML만 적용). 데이터 처리를 위한 단위로 오라클에 실제로 반영함.
-- 서브쿼리를 이용한 INSERT.. 쇼핑몰 장바구니?!
-- DEPT테이블의 10~30 부서를 DEPT01로 INSERT (AS나 괄호 없이 바로 SELECT문으로 서브쿼리 가능)
INSERT INTO DEPT01
SELECT * FROM DEPT WHERE DEPTNO BETWEEN 10 AND 30;
SELECT * FROM DEPT01 ORDER BY DEPTNO;
ROLLBACK; -- COMMIT을 한 이후의 트랜젝션 작업을 취소함. 이미 COMMIT이 수행된 것은 롤백되지 않음.

DROP TABLE SAM01;
CREATE TABLE SAM01 (
EMPNO NUMBER (4) PRIMARY KEY,
ENAME VARCHAR2 (10),
JOB VARCHAR2 (9),
SAL NUMBER (7,2)
);

SELECT * FROM SAM01;
INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL, 2000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1040, 'CAT', 2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO =10;
SELECT * FROM SAM01 ORDER BY EMPNO;
COMMIT;

-- 2. UPDATE 테이블 SET 필드명1 = 값1, 필드명2 = 값2,... [WHERE 조건]; 
-- 되도록 WHERE을 넣어줄 것. 해당 필드의 값이 모두 수정되기 때문. (물론 모든 값을 수정할 생각이라면 WHERE 사용하지 않아도 됨)
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT EMPNO, ENAME, SAL, DEPTNO, HIREDATE FROM EMP;
SELECT * FROM EMP01;
UPDATE EMP01 SET DEPTNO = 30;
ROLLBACK;
-- 모든 직원(EMP01)의 급여(SAL)을 10% 인상
UPDATE EMP01 SET SAL = SAL * 1.10;
-- EX. EMP01의 10번 부서 직원의 입사일을 오늘로, 부서번호는 30번으로
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO=30 
WHERE DEPTNO=10;
SELECT * FROM EMP01;
-- EX. 급여가 3000 이상인 사원만 급여를 10% 인상
UPDATE EMP01 SET SAL = SAL * 1.10 WHERE SAL >= 3000;
-- EX. 근무지가 DALLAS인 직원의 급여를 1000 달러 인상.
UPDATE EMP01 SET SAL = SAL + 1000 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- UPDATE 문구에서는 EQUI JOIN이 불가능하므로, 필요한 데이터가 다른 테이블이라면 반드시 서브쿼리를 사용하여 조건을 지정해주어야함.
-- EX. SCOTT 사원의 부서번호를 20, 직급을 MANAGER로 수정
UPDATE EMP02 SET DEPTNO = 20, JOB = 'MANAGER' WHERE ENAME = 'SCOTT';
SELECT * FROM EMP02 WHERE ENAME = 'SCOTT';

-- EX. 급여가 1500 이하인 직원의 급여를 1500으로 수정
UPDATE EMP02 SET SAL = 1500 WHERE SAL <=1500;
SELECT * FROM EMP02;

-- EX. 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정.. 서브쿼리사용
UPDATE EMP02 SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
SELECT * FROM EMP02;
UPDATE EMP02 SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
SELECT * FROM EMP02;


-- DML 