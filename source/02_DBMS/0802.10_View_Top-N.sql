-- [X] VIEW, IN-LINE VIEW, ��TOP-N��
DROP TABLE EMP1;
CREATE TABLE EMP1 AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; --�λ����� �� �� �ִ� ������. �޿������͸� �M
-- ������ �Ի��Ѵٸ�? EMP1 �����͸� ������Ʈ�Ѵ� �ϴ��� EMP���� �ݿ����� �ʴ� ������ ����.
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%';
INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) VALUES (1111,'ȫ',40);
SELECT * FROM EMP1; --ȫ�˻�o
SELECT * FROM EMP; -- ȫ�˻�X
DROP TABLE EMP1;
-- 1. VIEW : ���� ���� ������ �ذ��ϱ� ���� ������� ���� ���̺�. 1) �ܼ���, 2)���պ�
-- ���� ���̺��� ���� ����. �������� ��������� X
-- (1) �ܼ���
CREATE OR REPLACE VIEW EMPV0
AS (SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP);
SELECT * FROM EMPV0;
-- EMPV0�� �����ϸ� EMP���� �����.
SELECT * FROM USER_TABLES WHERE TABLE_NAME LIKE 'EMP%'; -- �̿Ͱ��� �˻��ص� EMPV0�� ã�� �� ����.
SELECT * FROM USER_VIEWS; -- �̿� ���� VIEWS�� �˻��ؾ� ã�� �� ����.
INSERT INTO EMPV0 VALUES (1111,'ȫ','MANAGER',NULL,SYSDATE,40); -- VIEW�� INSERT��
SELECT * FROM EMP; -- EMP���� �߰��� �����Ͱ� ���� ���� Ȯ���� �� ����.
ROLLBACK; -- INSERT, DELETE���� �ѹ��� ������. (COMMIT ���� Ȯ��)

CREATE OR REPLACE VIEW EMPV0
AS SELECT * FROM EMP WHERE DEPTNO = 30; -- SALES �μ��� ������ (Ư�� ��)�� ����������?
SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES (111,'ȫ','MANAGER',NULL,SYSDATE,NULL,NULL,30);
SELECT * FROM EMP;
INSERT INTO EMPV0 (EMPNO, ENAME, DEPTNO) VALUES (112, '��', 40); -- VIEW�� 30���� �����ϵ��� �����Ͽ������� �������.
-- EMP������ �̸� Ȯ���� �� ������, EMPV0������ Ȯ���� �� ����.
UPDATE EMP SET EMPNO=1111 WHERE ENAME = 'ȫ';
UPDATE EMP SET EMPNO=1112 WHERE ENAME = '��';
-- ���� 30�� ������ �����ϴٸ�, 30�� �μ� �ο��� INSERT �����ϵ��� ������ �����ϰ� �ʹٸ�?
-- WITH CHECK OPTION �߰� : ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
-- WITH READ ONLY �߰�: �б� ����. ���̺� ������ �Ұ�����.

CREATE OR REPLACE VIEW EMPV0
AS SELECT * FROM EMP WHERE DEPTNO = 30
WITH CHECK OPTION;
INSERT INTO EMPV0 (EMPNO, ENAME, DEPTNO) VALUES (112, '��', 40); -- 40�� �μ��� CHECK-OPTION�� �ɷ� ������.
INSERT INTO EMPV0 (EMPNO, ENAME, DEPTNO) VALUES (1113,'��',30);
DELETE FROM EMPV0 WHERE DEPTNO = 20; -- 0���� ����. ����� �� �ǹǷ� ���������� ����.

-- �б� ���� �� ����� ��. (WITH READ ONLY Ȥ�� �߰����� �ʾƵ� �б� ������ �Ǵ� ���)
CREATE OR REPLACE VIEW EMPV0
AS SELECT * FROM EMP
WITH READ ONLY; -- �翬�� ������ ���� ���� ����.
DELETE FROM EMPV0 WHERE EMPNO < 2000; -- READ-ONLY VIEW ����.
DELETE FROM EMP WHERE EMPNO <2000;
COMMIT;

CREATE OR REPLACE VIEW EMPV0 AS SELECT ENAME, JOB FROM EMP;
-- �ܼ��� �����ÿ��� NOT NULL (PK�� EMPNO ��) �ʵ带 ���� ���� ��� ��ǻ� �б� ������ ��.
SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES ('ȫ��', 'MANAGER'); 
-- ���, MGR, SAL, COMM,DEPTNO�� �ڵ����� NULL�� �Է�. �׷��� EMPNO�� PRIMARY KEY�̹Ƿ� NULL�� �Ұ�

-- (2) ���պ� : 2�� �̻��� ���̺�� ������ ��. 1���� ���̺�� ������ �ʵ带 �̿��� ��, DML�� ������ ���
-- �� 2�� �̻��� ���̺� ����
CREATE OR REPLACE VIEW EMPV0 
AS (SELECT EMPNO, ENAME, JOB, DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO);
SELECT * FROM EMPV0; -- ��ġ �μ��̸��� �ִ� ��ó�� ��ġ�Ⱑ ����. �� INSERT �Ұ�.
INSERT INTO EMPV0 VALUES (1111,'ȫ','MANAGER','SALES'); -- ����. ������ ����� VIEW�δ� INSERT�� ����� �� ����, SELECT�� ������.

-- �� �������� �ʴ� ������ �ʵ� (����)�� ����.
CREATE OR REPLACE VIEW EMPV0 
AS SELECT EMPNO, ENAME, SAL, SAL*12 ���� FROM EMP;
SELECT * FROM EMPV0;
INSERT INTO EMPV0 VALUES (1111, 'ȫ', 100,1200); -- ����. ������ �ʵ忡�� INSERT�� �� ����, SELECT�� ������.
-- �ڡڡڡ� ���պ� ���ÿ��� �ʵ��� �̸��� �ߺ����� �ʵ��� �ϰ�, �̸��� * �� Ư�����ڰ� ���� �ʵ��� ����. _ ���� ����
CREATE OR REPLACE VIEW EMPV0 (EMPNO, ENAME, SAL, YEAR_SAL) -- ��Ī�� ���� �E �� ����
AS SELECT EMPNO, ENAME, SAL, SAL*12 FROM EMP;
SELECT * FROM EMPV0; --�̿� ���� ����� SAL*12���� YEAR_SAL ���̺�� ��.

CREATE OR REPLACE VIEW EMPV0 (DEPTNO, AVG) -- �׷��Լ��� �����ʵ带 �Բ� �־ ����� ���� GROUP BY ����Ͽ���
AS SELECT DEPTNO, ROUND(AVG(SAL)) FROM EMP GROUP BY DEPTNO;
SELECT * FROM EMPV0;


-- 2. �ζ��κ� (IN-LINE VIEW) : FROM���� ���������� �ζ��κ�� �ϸ�, FROM���� ���� ���������� �Ͻ������� VIEWó�� �ۿ�
-- EX. �޿��� 2000 �� �ʰ��ϴ� ����� ��ձ޿�
SELECT AVG(SAL) FROM EMP WHERE SAL >2000; -- �⺻���
SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000); -- FROM�� �������� Ȱ����. 
-- ���⿡�� ��ȣ �ȿ� �ִ� SAL>2000�� �޿��� ���� �Ͻ������� VIEW�� ������� ��.

-- EX. �μ� ��� �޿����� �޿��� ���� ����� ���, �̸�, �޿� �μ���ȣ ���
SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP E
WHERE SAL > ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO)); -- ������ WHERE���� ���������� �־ �ذ��Ͽ���.

SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP; -- A
SELECT DEPTNO, AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO; -- B. A�� B�� ������.
SELECT EMPNO, ENAME, SAL, E.DEPTNO, ROUND(AVGSAL) 
    FROM EMP E, (SELECT DEPTNO,AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B WHERE E.DEPTNO=B.DEPTNO AND SAL>AVGSAL;
    -- FROM�� �켱 �������Ƿ�, ROUND(AVGSAL)�� �Է�)

SELECT EMPNO, ENAME, SAL, E.DEPTNO, AVGSAL
FROM EMP E, (SELECT DEPTNO,AVG(SAL) AVGSAL FROM EMP GROUP BY DEPTNO) B WHERE E.DEPTNO=B.DEPTNO AND SAL> AVGSAL;
-- FROM�� AVGSAL�� SELECT�� AVGSAL ������� �ϴµ�...?
    
-- 3. TOP-N ���� (TOP 1~10��, 11��~20��, ...) ������� �Ϻ� ����ϰ� ����.
-- ROWNUM(���̺�κ��� ������ ����)�� INLINE-VIEW�� �̿��� TOP-N ����
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ��ϼ����� ROWNUM �ű�
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20;
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL; -- ȭ�� ����� SAL �������, �׷��� ROWNUM�� ������ ������ ǥ���ϹǷ� ���ĵ��� ����.
-- FROM���� �ؼ��� ���� �����̹Ƿ�, FROM���� SORT�ϵ��� �ϰ� �ϸ� ��.
-- 1����� �������. �׷��� 1~10, 11~20 ������ ��������?
SELECT ROWNUM, ENAME, SAL 
FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM BETWEEN 1 AND 10;
-- �̰ű��� �Ǵµ�, 6~10��?
SELECT ROWNUM, ENAME, SAL 
FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM BETWEEN 6 AND 10;
-- ��µ��� ����. ROWNUM�� WHERE������ ����ñ� ����. TOP-N������ ���� ������ ��ü�� �ٽ� ������� ��.
SELECT ROWNUM RN, ENAME, SAL FROM 
(SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC); -- �޿��� ������ ����� ��������. ROWNUM�� ��ü�� ����.
SELECT ROWNUM, RN, ENAME, SAL 
FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)) 
WHERE RN BETWEEN 6 AND 10;
-- RN�̶�� ��ŷ�� ���� �������. 

SELECT ROWNUM, RN, ENAME, SAL 
FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL)) 
WHERE RN BETWEEN 10 AND 15;

-- EX. �̸���(ABC��)���� 6��°���� 10��°���� ����� ��� ���� ���
SELECT * FROM (SELECT ROWNUM RN, E.* FROM (SELECT * FROM EMP ORDER BY ENAME) E)
WHERE RN BETWEEN 5 AND 10;

-- EX. �Ի��ֽż�...
SELECT * FROM (SELECT ROWNUM RN, E.* FROM (SELECT * FROM EMP ORDER BY HIREDATE) E)
WHERE RN BETWEEN 5 AND 10;


--�ڡڡڡڡ� �������� �ڡڡڡڡ�
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
AS SELECT DNAME, ENAME FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��, WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU (ENAME, SANGSANAME)
AS SELECT W.ENAME ENAME1, M.ENAME ENAME2 FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���)
SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC;
SELECT ROWNUM RANK, DEPTNO, SUMSAL 
FROM (SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC);

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�. ? ģ�� ����
SELECT ROWNUM, E.* 
FROM (SELECT ROWNUM RANK, DEPTNO, SUMSAL FROM 
(SELECT DEPTNO, SUM(SAL) SUMSAL FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC))  E
WHERE RANK BETWEEN 2 AND 3;
-- �������̺��� ��ȣ �� Ư�����ڸ� ���� �� �����Ƿ� �ݵ�� alias�� ���� �̸��� �������������.
    
-- E.*�� ���� �ʹٸ�, ���� �ٱ��� FROM�� �̸��� ���� �����ְ�, �� �̸����� .* �� ������.

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT ROWNUM, A.*
FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A
WHERE ROWNUM <=5;

-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT * 
FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE 
FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
WHERE RN BETWEEN 6 AND 10;