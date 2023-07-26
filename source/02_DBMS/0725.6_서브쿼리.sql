-- [VI] Sub Query: ���� Query (SQL) �ȿ� QUERY (SQL��)�� �����Ǿ� �ִ� ��.
-- �� 1. ���� ���� ����
-- ���������� �ʿ��� ����?
-- ex. �޿��� ���� ���� �޴� ����� ��� ����
SELECT EMPNO, ENAME FROM EMP WHERE SAL= (SELECT MAX(SAL) FROM EMP); -- ���������� ��
SELECT * FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP); -- ��������, ��������
-- ���� ������ ���� ���� �켱, ���� �������� �����.

-- ���� ������ ���� (1) ������ �������� (���������� �������� �������� ���) �����ڸ� ���. =
-- SELECT MAX(SAL) FROM EMP�� 5õ���� ���� 1����� ��� =, >=, <=, != ������ ���� ���� �� ����.
-- EX. SCOTT�� ������ �μ����� �ٹ��ϴ� ����� �Ϲ�, �޿�
SELECT ENAME, SAL FROM EMP WHERE DEPTNO =
(SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
AND ENAME != 'SCOTT';
     
-- ���� ������ ���� (2) ������ �������� (���������� ���� ����� 2���̻�) IN, ALL, >ANY(SOME), EXISTS
-- EX. SCOTT�̳� KING�� ������ �μ����� �ٹ��ϴ� ����� �̸�, �޿�
-- �켱 ���������� �ۼ�..SCOTT�� KING�� �μ���ȣ�� ���
SELECT DEPTNO FROM EMP WHERE ENAME IN ('SCOTT', 'KING'); -- ������ ��������. 10�� 20���� ���� ����
SELECT ENAME, SAL
FROM EMP
WHERE DEPTNO = 
(SELECT DEPTNO FROM EMP WHERE ENAME IN ('SCOTT', 'KING')); -- ����. = �����ڸ� ��� �Ұ�
-- �� ���� = ��� IN�� ����Ͽ� �ذ�
SELECT ENAME, SAL
FROM EMP
WHERE DEPTNO IN 
(SELECT DEPTNO FROM EMP WHERE ENAME IN ('SCOTT','KING'));

-- �� 2. ���� ���� ����
-- SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� ��� ����
-- DALLAS, 50���μ� �ٹ����� ���ϴ� ����� �߰��Ϸ���? -- �켱 DEPT�� ���� �߰��ؾ� ��... LOC�� DEPT�� �����Ƿ�..
INSERT INTO DEPT VALUES  (50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (8000,'ȫ�浿',50); -- EMPNO, ENAME, DEPTNO�� ���� �־� ����
SELECT EMP.*, ENAME, LOC FROM EMP,DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO 
AND LOC = (SELECT LOC FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND ENAME = 'SCOTT');
ROLLBACK; -- ������ �߰�, ����, ����, �˻� ���� ���..
-- COMMIT; �����͸� ������ ����Ŭ�� INSERT�Ͽ� �����ϴ� ��.
-- EX2. ���� �Ի� ���� �̸��� ���� �Ի��� ���.. ���� ���� �Ի����� ���
SELECT ENAME, HIREDATE FROM EMP 
WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
-- EX3. �ֱ� �Ի� ���� �̸��� �ֱ� �Ի���
SELECT ENAME, HIREDATE FROM EMP 
WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
-- EX4. ���� �Ի� ���� �̸��� ���� �Ի���, �ֱ� �Ի� ���� �̸��� �ֱ� �Ի���
SELECT E1.ENAME, E1.HIREDATE, E2.ENAME, E2.HIREDATE
FROM EMP E1, EMP E2
WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) 
AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
-- SELECT���� ���������� �߰��� �� ����. �����Ի��ڸ� ���ϴ� SELECT���� SELECT �ȿ� ����
SELECT
    (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)) �����Ի���,
    (SELECT MIN(HIREDATE) FROM EMP) �����Ի���,
    (SELECT ENAME FROM EMP WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP )) �ֱ��Ի���,
    (SELECT MAX (HIREDATE) FROM EMP) �ֱ��Ի���
    FROM DUAL;
    
-- EX5. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT SUM(SAL) FROM EMP 
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

-- EX6. SCOTT�� ������ JOB�� ���� ����� ��� �ʵ�
SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'; --��������
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'); -- ��������

-- EX7. ��������OR JOIN ��� ����.. �޶󽺿� �ٹ��ϴ� ����� �̸��� �μ���ȣ�� ���
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS';
SELECT ENAME, DEPTNO FROM EMP 
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
SELECT ENAME, E.DEPTNO FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND LOC = 'DALLAS';

-- EX8. 'KING'�� ���ӻ���� ����� �̸��� �޿� (��������, SELFJOIN)
SELECT EMPNO FROM EMP WHERE ENAME = 'KING';
SELECT ENAME, SAL FROM EMP WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
SELECT W.EMPNO, W.ENAME, W.SAL FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';

-- EX9. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
SELECT ROUND(AVG(SAL),1) FROM EMP; -- ��������
SELECT ENAME, SAL FROM EMP 
WHERE SAL <= (SELECT ROUND(AVG(SAL),1) FROM EMP);

-- EX10. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿��� ��ձ޿��� ��� (�Ҽ���1�ڸ�)
SELECT ROUND(AVG(SAL),1) FROM EMP;
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP),1) 
FROM EMP WHERE SAL <= (SELECT ROUND(AVG(SAL),1) FROM EMP);

-- EX11. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿����� ���̸� ���
SELECT AVG(SAL) FROM EMP; -- ����
SELECT ENAME, SAL, ROUND(ABS(SAL - (SELECT AVG(SAL) FROM EMP))) CHAYI
FROM EMP WHERE SAL <= (SELECT AVG(SAL) FROM EMP);


-- ������ ���߿� ��������
-- SCOTT�� JOB�� �μ���ȣ�� ���� ������ ��� �ʵ带 ���.. 
SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT') AND 
DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); 
-- ���ε� �� ���� ������ �ſ� ����.. �̷� ���� ���߿� ���������� �����.
SELECT * FROM EMP
WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
-- WHERE���� (JOB,DEPTNO�� �ְ�, SELECT ���� JOB,DEPTNO�� �ѹ��� �־���). ��, ������ �ݵ�� ������� �� ��.

-- �� 3. �����༭������ (IN, ALL, ANY(=SOME), EXITSTS ���� ���...
-- (1) IN ������ - ���������� ��� �� �ϳ��� ��ġ�ϸ� ��
-- EX. �μ��� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ������ ���߿� ��������.. ���⼭ �̸��� ����ϰ� �;?
SELECT DEPTNO, MAX(HIREDATE), ENAME FROM EMP GROUP BY DEPTNO, ENAME; -- �̷��� �ϴ� ��� 14���� ��� ��µǹǷ� �ǹ̰� ����.
SELECT ENAME, HIREDATE, DEPTNO
FROM EMP
WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); -- �� �� �ϳ��� ������ ��µ�.
-- �̷��� ������ ���߿��� ���� = ��ſ� IN�� ����� ��.
-- EX. �޿��� 3000 �̻� �޴� ����� �Ҽӵ� �μ��� ������� ��� �ʵ�
SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- ��������
SELECT * FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >= 3000 GROUP BY DEPTNO);

-- (2) ALL : �������� ����� ��� �����ϸ� ��
-- EX. 30�� �μ� ���� ��� �޿����� ū ������ ��� �ʵ�
SELECT SAL FROM EMP WHERE DEPTNO = 30; -- ��������, 950,1250,1500,1600,2850
SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);
-- 30�� �μ������� �ִ� �޿����� �޿��� ū ������ ��� �ʵ� ���
SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

-- (3) ANY(=SOME), �������� ������ ����� �ϳ� �̻� �����ϸ� ��
-- 30�� �μ� ���� �Ѹ� ���̶� �޿��� ū ������ ��� �ʵ�
SELECT SAL FROM EMP WHERE DEPTNO = 30;
SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30); -- ������ �������� (ANY) �̿�
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO =30); -- ������ �������� �̿�

-- (4) EXISTS : �������� ����� �����ϸ� ��. EXISTS�� ��� ���������� �ܵ� (F9) ������� �ʴ� ���� Ư¡��.
-- ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP M WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR); --  EXISTS ���������� �̿�
SELECT DISTINCT E2.EMPNO, E2.ENAME, E2.SAL FROM EMP E1, EMP E2 WHERE  E1.MGR = E2.EMPNO; -- ���������� �̿�
-- ���Ӻ��ϰ� ���� �������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL FROM EMP M WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO = MGR); -- ����X�� NOT�� �ٿ��� ���
SELECT E1.ENAME, E2.EMPNO, E2.ENAME, E2.SAL
FROM EMP E1, EMP E2
WHERE E1.MGR(+) = E2.EMPNO AND E1.MGR IS NULL; -- �������� + �ƿ������α��� Ȱ���ؾ��ϹǷ� ����

-- źź1. �μ����� ���� �޿��� ���� �޴� ����� ��� ������ ���(IN ������ �̿�)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT * FROM EMP E, DEPT D, SALGRADE WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND (E.DEPTNO,E.SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO)
ORDER BY E.DEPTNO;
-- �������̹Ƿ� IN�� ����ؾ�...

-- źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT * FROM DEPT
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');

-- źź3. �޿��� 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� �޿��� �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL
AND SAL >= ANY (SELECT SAL FROM EMP WHERE SAL =3000 GROUP BY SAL,GRADE);

-- źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
SELECT TO_CHAR(HIREDATE,'Q') BUNGI, EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY TO_CHAR(HIREDATE,'Q'));


-- źź5. �޿��� 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, �޿�, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE
FROM EMP
WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL <3000);

-- źź6. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB 
FROM EMP
WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')
AND JOB != 'SALESMAN';

SELECT ENAME, SAL, JOB
FROM EMP
WHERE  SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN');

-- źź7. SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB
FROM EMP
WHERE SAL >= ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');

SELECT ENAME, SAL, JOB
FROM EMP
WHERE  SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN');

-- �� �� �������� 

--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE FROM EMP 
WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL FROM EMP 
WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO FROM EMP 
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME FROM EMP, DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO AND SAL <=(SELECT AVG(SAL) FROM EMP);

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE 
FROM EMP, SALGRADE 
WHERE SAL BETWEEN LOSAL AND HISAL 
AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');

--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
FROM EMP, SALGRADE, DEPT
WHERE SAL BETWEEN LOSAL AND HISAL AND EMP.DEPTNO = DEPT.DEPTNO
AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
ORDER BY SAL DESC;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL 
FROM EMP
WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
FROM EMP,DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO 
AND DNAME = 
(SELECT DNAME FROM DEPT,EMP 
WHERE DEPT.DEPTNO = EMP.DEPTNO 
AND ENAME = 'CLARK')
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT ENAME, HIREDATE
FROM EMP
WHERE DEPTNO = 
(SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
ORDER BY SAL DESC;

-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB, SAL
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE INITCAP(LOC) = 'Dallas');

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT E1.ENAME, E1.SAL
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO AND
E2.EMPNO = (SELECT EMPNO FROM EMP WHERE INITCAP(ENAME) = 'King');

-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT * FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30);

-- 19.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT * FROM EMP
WHERE (JOB, SAL) = (SELECT JOB,SAL FROM EMP WHERE ENAME = 'FORD')
AND ENAME != 'FORD';

-- 20. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') OR
SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD') ORDER BY JOB, SAL DESC;

-- 21. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD')
AND ENAME != 'SCOTT' AND ENAME != 'WARD';

-- 22. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB, LOC
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
AND JOB IN (SELECT JOB FROM EMP,DEPT WHERE  EMP.DEPTNO = DEPT.DEPTNO AND LOC = 'CHICAGO');

-- 23. �μ� ��� ���޺��� ������ ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT EMPNO, ENAME, SAL, E.DEPTNO
FROM EMP E
WHERE SAL >= (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO GROUP BY DEPTNO);
-- ���, �̸�, �޿�, �μ���ȣ, �ش� �μ��� ��� �޿�
SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO GROUP BY DEPTNO)) AVG
FROM EMP E
WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);

-- 24. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT EMPNO, ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB)) AVG
FROM EMP E
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB);

SELECT EMPNO, ENAME, E.SAL, JOB, ROUND((SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB)) AVG
FROM EMP E
WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB);

-- 25. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO AND W.MGR IS NOT NULL
ORDER BY DEPTNO;

SELECT DISTINCT JOB, ENAME, EMPNO, DEPTNO
FROM EMP M
WHERE EXISTS (SELECT * FROM EMP WHERE M.EMPNO =MGR); 


-- 26.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT M.EMPNO, M.ENAME, M.JOB, M.DEPTNO
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO AND W.MGR IS NULL;

SELECT DISTINCT JOB, ENAME, EMPNO, DEPTNO
FROM EMP M
WHERE NOT EXISTS (SELECT * FROM EMP WHERE M.EMPNO=MGR); -- �������� ����ȣ�� EMPNO�� �ƴ� ��.

SELECT JOB, ENAME, EMPNO, DEPTNO
FROM EMP
WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL); -- NULL�� �ƴ� �͵��� ���ִ� ������ �߰��Ͽ� NOT IN�� ��� ����.



SELECT W.ENAME, W.JOB
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';

SELECT * FROM EMP
WHERE (JOB,SAL) IN (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD')
AND ENAME != 'FORD';