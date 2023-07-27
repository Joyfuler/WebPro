-- [VII] DDL, DML, DCL
-- SQL = DDL(���̺� ����, ���̺� ����, ���̺� ���� ����, ���̺��� ��� ������ ����)
--          DML (SELECT, INSERT, DELETE, UPDATE)
--          DCL(����ڰ��� ����, ����ڿ��� ���Ѻο�, ���ѹ�Ż, ����ڰ��� ����, Ʈ������ ��ɾ�)            

-- �ڡڡڡڡ� DDL �ڡڡڡڡ�
-- 1. ���̺� ����(CREATE TABLE ���̺�� ....) : ���̺� ������ ����
CREATE TABLE BOOK ( --���� �ʵ�� Ÿ�� �� ����..
BOOKID NUMBER(4), -- BOOKID�ʵ� ����.. Ÿ���� ���� 4�ڸ�
BOOKNAME VARCHAR2 (20), -- BOOKNAME �ʵ� Ÿ���� ���� 20����Ʈ. VARCHAR2�� �ִ� 4õ���� ��. Ȥ�� ������ ���� CLOB�ε� ����� ������.
PUBLISHER VARCHAR2 (20), -- ���ǻ� ����
RDATE DATE,                   -- �������. Ÿ���� DATE(��¥)
PRICE NUMBER(7,2), -- å����.. ��ü 7�ڸ� ��, �Ҽ��� 2�ڸ����� �Ҽ���
PRIMARY KEY (BOOKID) -- BOOKID�� ������ ���̹Ƿ� �ߺ��� �Ұ����ϵ��� �����ϴ� �����̸Ӹ�Ű. NULL�� ���� �Է��� �Ұ���.
);

SELECT * FROM BOOK;
DESC BOOK; -- BOOKID�� �����̸Ӹ�Ű�̹Ƿ� NOTNULL�� ǥ�õ� ��.
DROP TABLE BOOK; -- ���̺��� ������. ���������� DROP CREATE... (�ǹ���������ߴ�ū�ϳ�������)
CREATE TABLE BOOK (
BOOKID NUMBER (4) PRIMARY KEY, --�����̸Ӹ�Ű�� Ÿ�� �ٷ� ���� ������ ���� ����.
BOOKNAME VARCHAR2 (20),
PUBLISHER VARCHAR2 (20),
RDATE DATE,
PRICE NUMBER (8,2)
);

-- ���������ξ��� DEPT ���̺� �����
CREATE TABLE DEPT01 (
    DEPTNO NUMBER (2) PRIMARY KEY, -- 10,20,30,40...
    DNAME VARCHAR2 (14),
    LOC VARCHAR2(13)
);

SELECT * FROM DEPT01;
-- EMP01 : EMPNO(���ڳ��ڸ� �� PK), ENAME(����10), SAL(����7,2), DEPTNO (����2, DEPT�� FK�� ����Ǿ� ����)
CREATE TABLE EMP01 (
EMPNO NUMBER (4) PRIMARY KEY,
ENAME VARCHAR2 (10),
SAL NUMBER(7,2),
DEPTNO NUMBER(2) REFERENCES DEPT01 (DEPTNO) -- DEPT01 �� DEPTNO�� ����� ���� �Է��� �����ϵ��� FK�� ����.
);

-- ���������� �̿��� ���̺� ����...? (BACKUP)
CREATE TABLE EMP02
AS
SELECT * FROM EMP; -- �������� ����� EMP02���̺� ���� �� �����ͷ� �� (�������� ������) �� ��� �뵵�� ���.

SELECT * FROM EMP02;
-- Ư�� �ʵ常 �̾ư��� �ʹٸ�?
CREATE TABLE EMP03 -- Ư�� �� ���
AS
SELECT EMPNO, ENAME, DEPTNO FROM EMP;

CREATE TABLE EMP04
AS
SELECT * FROM EMP WHERE DEPTNO=10; -- DEPTNO�� 10�� �μ� �����͸� �����Ͽ� EMP04���̺�����.. Ư�������
SELECT * FROM EMP04;
-- EMP05�� EMP�� ������ ����.. �����͸� �� �ְڴٸ�?
CREATE TABLE EMP05
AS
SELECT * FROM EMP WHERE 1>2; --WHERE ������ �Ϻη� FALSE�� �����Ͽ� Ÿ��Ʋ�� ��������, �����͸� �������� �� �� ����.
SELECT * FROM EMP05;

SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM�� EMP���� ���� �о���� ������ ����.

-- 2. ���̺� �������� (ALTER TABLE ���̺�� ADD () || MODIFY () || DROP ()  ... ��ó�⿡�� ���´ٰ���...
-- (1) �ʵ��߰� (ADD)
SELECT * FROM EMP03; -- EMPNO(����4�ڸ�), ENAME(����10�ڸ�),DEPTNO(����2�ڸ�) 
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7)); -- �ش� Ÿ���� JOB, SAL ���̺��� �߰���.
SELECT * FROM EMP03;

-- (2) �ʵ� ���� (MODIFY)
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- ����. �̹� ���ڵ����Ͱ� �� �ֱ� ������, ���� Ÿ�����θ� ������ ������.
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5));
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4)); -- ���� JOB �����ʹ� ��� NULL�̱� ������ ������� ������ ������.
SELECT MAX(LENGTH(ENAME)) FROM EMP03; -- ENAME�� 6����Ʈ�ۿ� �Ⱦ�... EMP03�� ENAME�� 6���ڰ� ��������̹Ƿ� 6������ ���� �� ����.
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6)); -- �� ���� �������� ���̱����� ��Ұ� ����. (�����δ� ���� ������ ������)

-- (3) �ʵ� ���� (DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; -- JOB�̶�� �ʵ�(��)�� ������.
ALTER TABLE EMP03 DROP COLUMN DEPTNO;

-- 3. ���̺� ���� (DROP TABLE ���̺��) -- ��ǳ����. ��� ����������!!!
DROP TABLE EMP01; --EMP01 ���̺��� ������
CREATE TABLE EMP01
AS
SELECT * FROM EMP;
SELECT * FROM EMP01;
DROP TABLE DEPT; -- ����. EMP�� DEPT�� DEPTNO�� REFERENCES �ϰ� �����Ƿ�, ���� ������ �� ����. EMP ���̺��� ������ �Ķ�� ����

-- 4. ���̺��� ��� ���� ���� (TRUNCATE TABLE ���̺��)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- �� ���� ROLLBACK�� �Ұ��ϴ� ������ ��.
SELECT * FROM EMP03;

-- 5. ���̺�� ���� (RENAME ���̺�� TO �ٲ� ���̺��.. �ǹ������� ���� ������ ��ó�⿡�� ���ü���)
RENAME EMP03 TO EMP003;
SELECT * FROM EMP003;

-- 6. ������ ��ųʸ� (�����ͺ��̽� �ڿ��� ȿ�������� �����ϱ� ���� �ý��� ���̺�. �� ���� �Ұ�)
-- ������ ��ųʸ� �� - ����� ���� ������ �� �ִ� �����Ͱ� ���� �ٸ� ���� ���̺�. ���� ��...
-- (1) USER_XXX : �� �������� �����ϰ� �ִ� ��ü(TABLE ���̺�, CONSTRAINTS ��������, VIEW��, INDEX�ε���) Ȯ��
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_VIEWS; --�������� �����Ƿ� ������ X
SELECT * FROM USER_INDEXES;

-- (2) ALL_XXX : �� �������� �����ϰ� ���� ������, ������ �� �ִ� ��ü�� Ȯ����.
SELECT * FROM ALL_TABLES; --���� ������ SCOTT�� DBA �����̹Ƿ�, ��� ������ ����
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;
SELECT * FROM ALL_INDEXES;

-- (3) DBA_XXX : DBA ���ѿ����� ���� ������ DBMS�� ��� ��ü (���̺�, ��������, ��, �ε���) - ���� ������ SCOTT�� DBA ������ ������ �����Ƿ� ALL�� ���̰� ����.
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;
SELECT * FROM DBA_INDEXES;

-- �ڡڡڡڡ� DML �ڡڡڡڡ� -- ROLLBACK ������ ��ɾ��
-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ��3....); -- �� ��� ��� �ʵ��� ���� �ݵ�� �־�� ��. 
-- ���� �ְ� ���� �ʴٸ� VALUES�� ���� �����ϴ� ����� ����� ���� ����.
-- INSERT INTO ���̺�� (�ʵ�1, �ʵ�2, ..) VALUES (��1, ��2, ...) �� �� VALUES�� �������� ���� �ʵ�� NULL�� ��.

SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'SEOUL');
INSERT INTO DEPT01 VALUES (60, 'SALES', NULL); --������� NULL�߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (70, 'RESEARCH', '���빮'); -- �ʵ�� VALUES �ʵ尪
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (80, 'IT'); -- �������� NULL�߰�. ��õ��� ���� �ʵ忡�� �ڵ����� NULL�� ���Ե�
COMMIT; -- �߰��� �����͸� ���������� �ݿ�. Ʈ������ ��ɾ�(DML�� ����). ������ ó���� ���� ������ ����Ŭ�� ������ �ݿ���.
-- ���������� �̿��� INSERT.. ���θ� ��ٱ���?!
-- DEPT���̺��� 10~30 �μ��� DEPT01�� INSERT (AS�� ��ȣ ���� �ٷ� SELECT������ �������� ����)
INSERT INTO DEPT01
SELECT * FROM DEPT WHERE DEPTNO BETWEEN 10 AND 30;
SELECT * FROM DEPT01 ORDER BY DEPTNO;
ROLLBACK; -- COMMIT�� �� ������ Ʈ������ �۾��� �����. �̹� COMMIT�� ����� ���� �ѹ���� ����.

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

-- 2. UPDATE ���̺� SET �ʵ��1 = ��1, �ʵ��2 = ��2,... [WHERE ����]; 
-- �ǵ��� WHERE�� �־��� ��. �ش� �ʵ��� ���� ��� �����Ǳ� ����. (���� ��� ���� ������ �����̶�� WHERE ������� �ʾƵ� ��)
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT EMPNO, ENAME, SAL, DEPTNO, HIREDATE FROM EMP;
SELECT * FROM EMP01;
UPDATE EMP01 SET DEPTNO = 30;
ROLLBACK;
-- ��� ����(EMP01)�� �޿�(SAL)�� 10% �λ�
UPDATE EMP01 SET SAL = SAL * 1.10;
-- EX. EMP01�� 10�� �μ� ������ �Ի����� ���÷�, �μ���ȣ�� 30������
UPDATE EMP01 SET HIREDATE = SYSDATE, DEPTNO=30 
WHERE DEPTNO=10;
SELECT * FROM EMP01;
-- EX. �޿��� 3000 �̻��� ����� �޿��� 10% �λ�
UPDATE EMP01 SET SAL = SAL * 1.10 WHERE SAL >= 3000;
-- EX. �ٹ����� DALLAS�� ������ �޿��� 1000 �޷� �λ�.
UPDATE EMP01 SET SAL = SAL + 1000 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- UPDATE ���������� EQUI JOIN�� �Ұ����ϹǷ�, �ʿ��� �����Ͱ� �ٸ� ���̺��̶�� �ݵ�� ���������� ����Ͽ� ������ �������־����.
-- EX. SCOTT ����� �μ���ȣ�� 20, ������ MANAGER�� ����
UPDATE EMP02 SET DEPTNO = 20, JOB = 'MANAGER' WHERE ENAME = 'SCOTT';
SELECT * FROM EMP02 WHERE ENAME = 'SCOTT';

-- EX. �޿��� 1500 ������ ������ �޿��� 1500���� ����
UPDATE EMP02 SET SAL = 1500 WHERE SAL <=1500;
SELECT * FROM EMP02;

-- EX. ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����.. �����������
UPDATE EMP02 SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
SELECT * FROM EMP02;
UPDATE EMP02 SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
SELECT * FROM EMP02;
SELECT * FROM EMP01;
DELETE FROM EMP01;
ROLLBACK;

-- EMP01 : 30�� �μ� ������ ����
DELETE FROM EMP01 WHERE DEPTNO=30;
SELECT * FROM EMP01;
ROLLBACK;

-- EMP01: �μ����� SALES �μ��� ������ ����
DELETE FROM EMP01 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- EMP01 : FORD ����� ����
DELETE FROM EMP01 WHERE ENAME = 'FORD';

-- SAM01: JOB�� NULL�� ����� ����
SELECT * FROM SAM01 WHERE JOB IS NULL;
DELETE FROM SAM01 WHERE JOB IS NULL;

-- SAM01: ENAME�� ORANGE�� ����� ����
DELETE FROM SAM01 WHERE ENAME = 'ORANGE';

-- EMP01: �޿��� 1500 ������ ������ �޿��� 1500
UPDATE EMP01 SET SAL =1500 WHERE SAL <=1500;

--

-- �� �������� (CREATE TABLE, DROP TABLE, INSERT, UPDATE, DELETE, COMMIT)
CREATE TABLE MY_DATA(
ID NUMBER(4) PRIMARY KEY,
NAME VARCHAR2 (10),
USERID VARCHAR2(30),
SALARY NUMBER (10,2)
);

INSERT INTO MY_DATA VALUES (1, 'Scott','ssott',10000.00);
INSERT INTO MY_DATA VALUES(2,'Ford','fford',13000.00);
INSERT INTO MY_DATA VALUES(3, 'Patel', 'ppatel', 33000.00);
INSERT INTO MY_DATA VALUES(4, 'Report', 'rreport', 23500.00);
INSERT INTO MY_DATA VALUES (5, 'Good', 'ggood', 44450.00);

SELECT ID "ID - number(4)", NAME "NAME - varchar2(10)", USERID "USERID - varchar2(30)", TO_CHAR(SALARY,'99,999.99') "SALARY - number(10,2)" FROM MY_DATA;
COMMIT;
UPDATE MY_DATA SET SALARY = 65000.00 WHERE ID =3;
SELECT * FROM MY_DATA;
DELETE FROM MY_DATA WHERE NAME = 'Ford';
ROLLBACK;
UPDATE MY_DATA SET SALARY = 15000.00 WHERE SALARY <=15000.00;
DROP TABLE MY_DATA;

-- �ڡڡڡڡ� ��������
-- (1) PRIMARY KEY : ���̺��� �� ���� ������ ������ �ĺ��ϱ� ���� �ʵ�
-- (2) FREIGN KEY (�ܷ�Ű) : DEPT�� DEPTNO�� EMP�� DEPTNO�� ����� ��ó��,
-- ���̺��� ���� �ٸ� ���̺��� ���� ������ ��.
-- (3) NOT NULL : �ش� �ʵ尡 ���� NULL�� ���� ���ϵ��� ��. 
-- (4) UNIQUE : ������ ���� ��������, NULL�� ���� �� ������ ���� �� ��� ����. PRIMARY���� �� ���� ����
-- (5) CHECK (����) : �ش� ������ �����ϴ� ���� INSERT, UPDATE�� ����. NULL�� ���
-- (6) DEFAULT (�⺻��) : 
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (99, 'XX');
SELECT * FROM DEPT01 WHERE DEPTNO=99;

CREATE TABLE DEPT1 (
DEPTNO NUMBER (2) PRIMARY KEY,
DNAME VARCHAR2 (14) NOT NULL UNIQUE,
LOC VARCHAR2 (13) NOT NULL
);

SELECT * FROM DEPT1;
SELECT * FROM USER_TABLES;
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'DEPT1';

-- ���� ������ �׻� �θ����̺��� �켱 ������. ���� EMP�� DEPTNO�� �ְ� �ʹٸ� �켱 DETPNO�� INSERT �ؾ���. ������ ��������� ����.
DROP TABLE EMP1;
CREATE TABLE EMP1 (
EMPNO NUMBER (4) PRIMARY KEY,
ENAME VARCHAR2(10) NOT NULL,
JOB VARCHAR2 (9) NOT NULL,
MGR NUMBER(4),
HIREDATE DATE DEFAULT SYSDATE, -- NULL�� ��� ���� �ð��� �Էµ�.
SAL NUMBER(7,2) CHECK (SAL>0), -- SAL�� 0�� ���� INSERT, UPDATE�� �Ұ�����.
COMM NUMBER(7,2),
DEPTNO NUMBER(2),
 -- �ش� ��Ʈ�� �ٸ� ������ ������ ��
FOREIGN KEY (DEPTNO) REFERENCES DEPT1(DEPTNO)
);
INSERT INTO EMP1 (EMPNO, ENAME, JOB) VALUES (1000,'Ȳ�浿','MANAGER');
SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB) VALUES (1001,'��浿','SALESMAN');
UPDATE EMP1 SET DEPTNO = 10 WHERE ENAME = '��浿';
INSERT INTO DEPT1 SELECT * FROM DEPT;
INSERT INTO DEPT1 VALUES (40, 'IT' , 'SEOUL'); -- 40 PK�� �̹� ������
INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- DNAME�� ���� UNIQUE�̹Ƿ� SALES�� ���� ����
INSERT INTO DEPT1 (DEPTNO, DNAME) VALUES (50, 'IT'); -- LOC�� NOT NULL�̹Ƿ� NULL�� ���Խ� ������.
INSERT INTO DEPT1 VALUES (50, 'IT', 'SEOUL');
SELECT * FROM DEPT1;

SELECT * FROM EMP1;
INSERT INTO EMP1 (EMPNO, ENAME, JOB, DEPTNO)
VALUES (1001, '��浿', 'MANAGER', 60);
UPDATE EMP1 SET ENAME = 'ȫ�浿' WHERE ENAME = 'Ȳ�浿';

DROP TABLE BOOKCATEGORY CASCADE CONSTRAINTS; -- �����ϴ� ���̺�� ������� ���̺��� ������.
CREATE TABLE BOOKCATEGORY (
CATEGORYCODE NUMBER(3) PRIMARY KEY,
CATEGORYNAME VARCHAR2(50) UNIQUE,
OFFICE_LOC VARCHAR2(50) NOT NULL
);

CREATE TABLE BOOK (
BOOKNO VARCHAR2(10) PRIMARY KEY,
CATEGORYCODE NUMBER(3),
BOOKNAME VARCHAR2(50) NOT NULL,
PUBLISHER VARCHAR2(50),
PUBYEAR NUMBER(4) DEFAULT EXTRACT (YEAR FROM SYSDATE),
FOREIGN KEY (CATEGORYCODE) REFERENCES BOOKCATEGORY (CATEGORYCODE)
);

INSERT INTO BOOKCATEGORY VALUES (100, 'ö��', '3�� �ι���');
INSERT INTO BOOKCATEGORY VALUES (400, 'IT', '4�� ���н�');
INSERT INTO BOOK (BOOKNO, CATEGORYCODE, BOOKNAME, PUBLISHER) VALUES ('100A01', 100, 'ö������ ��', '��������');
INSERT INTO BOOK VALUES ('400A01', 400, '�̰��� DB��', '��������', 2022);
SELECT * FROM BOOK;
SELECT * FROM BOOKCATEGORY;
SELECT BOOKNO, BOOKNAME, PUBLISHER, PUBYEAR, CATEGORYNAME, OFFICE_LOC 
FROM BOOK, BOOKCATEGORY
WHERE BOOK.CATEGORYCODE = BOOKCATEGORY.CATEGORYCODE;

-- SQLȰ�� ����

DROP TABLE MAJOR;
DROP TABLE STUDENT;

CREATE TABLE MAJOR (
MCODE NUMERIC(1) PRIMARY KEY,
MNAME VARCHAR(30),
MOFFICE VARCHAR(50)
);

CREATE TABLE STUDENT (
SNO VARCHAR(3) PRIMARY KEY,
SNAME VARCHAR(50),
SSCORE NUMERIC(3) CHECK (SSCORE BETWEEN 0 AND 100),
MCODE NUMERIC(1),
FOREIGN KEY (MCODE) REFERENCES MAJOR (MCODE)
);

INSERT INTO MAJOR VALUES (1, '��ǻ�Ͱ���', 'A101ȣ');
INSERT INTO MAJOR VALUES (2, '������', 'A102ȣ');
INSERT INTO STUDENT VALUES (101, 'ȫ�浿', 99, 1);
INSERT INTO STUDENT VALUES (102, '�ű浿', 100, 2);
SELECT S.SNO AS "�й�", S.SNAME AS "�̸�", S.SSCORE AS "����", M.MCODE "�а��ڵ�", M.MNAME "�а���", M.MOFFICE "�а��繫��"
FROM STUDENT S, MAJOR M
WHERE S.MCODE = M.MCODE;

-- �ڡڡڡڡ� DCL : ��������, ���Ѻο�, ���ѹ�Ż ���� ���� �ڡڡڡڡ�--
-- 1) ��������
CREATE USER scott2 IDENTIFIED BY tiger;
-- 2) ���Ѻο� (���Ǳ��� == �α����� �����ϰ� �ϴ� �۾�)
GRANT CREATE SESSION TO scott2;
GRANT CREATE TABLE TO scott2; -- ���������� �ο�... �ѹ��� ���̺� ���� ��� ������ �� �ְڴٸ�?
GRANT ALL ON EMP TO scott2; -- EMP�� ���� ��� ������ SCOTT2���� �ο���.
GRANT SELECT ON DEPT TO scott2; -- ����Ʈ�� �����ϵ��� ���Ѻο�.


-- 3) ���� ��Ż (DEPT, EMP)
REVOKE ALL ON EMP FROM scott2;
REVOKE ALL ON DEPT FROM scott2;

-- 4) ���� ���� (scott2) - ��������
DROP USER scott2 CASCADE; -- ���� �������϶��� ����