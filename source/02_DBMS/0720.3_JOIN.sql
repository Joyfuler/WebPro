-- [III] JOIN ; ���̺��� 2�� �̻� ������ �����͸� �˻��ϴ� ���
-- SCOTT�� ��� �����͸� �˰� �ʹٸ�?
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;
-- CROSS JOIN (FROM ���� ���̺��� 2�� �̻� ���� ��)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT'; -- �ΰ��� ��ġ�� �������� SCOTT�� ���� 1������ 4���� �Ҿ.
-- �ǹ��ִ� �ڷḦ ����� ���ؼ��� �ʵ��� ���� ���� �͵��� �������־����.
-- 1.�� �� �� EQUI JOIN (���� ����) - �����ʵ�(DEPTNO)�� ���� ��ġ�Ǵ� ���Ǹ� JOIN�ϰ��� �� ��
SELECT * FROM EMP, DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO AND ENAME = 'SCOTT';
-- ũ�ν� ������ WHERE �ڿ� �ΰ�, WHERE �߿����� ���� �տ� �� ��. ex) WHERE ~ ~ AND �ٸ�����
SELECT * FROM EMP, DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO;
-- �׷��� DEPTNO�� DEPTNO_1�� ���ʿ��� �ʵ尡 2���� �������� ������ ����.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO AS EMP�μ���, DNAME, LOC 
FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;
-- ���� �ٸ� ���̺� ���� �̸��� �ʵ尡 �ִ� ���, EMP.DEPTNO ������ � ���̺� �ִ� �ʵ������� ������ �־����.
-- �ʵ�� �̿ܿ�, �ʵ�� ��Ī�� �� �� ����.
SELECT EMPNO NO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC
FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO; 
-- ���̺��� ��Ī�� ���� ���, �� ���̺� ���� ����� �� ���� ��Ī�� ����ؾ� ��. (�ʵ�ʹٸ�)
-- EX. �޿��� 2000 �̻��� ������ �̸�, ��å, �޿�, �μ���, �ٹ���, �μ���ȣ ���
SELECT ENAME, JOB, SAL, DNAME, LOC, E.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000;
-- EX. 20�� �μ��� ������ �̸�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, E.DEPTNO, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND D.DEPTNO = 20;
-- EX. �ٹ��� (LOC) �� CHICAGO�� ����� �̸�, ����, �޿�, �μ���ȣ�� ���
SELECT ENAME, JOB, SAL, D.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC='CHICAGO';
-- EX. �μ���ȣ�� 10�̰ų� 20�� ����� �̸�, ����, �ٹ��� (�޿���) ���
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10,20) ORDER BY SAL;
-- EX. JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����(SAL+COMM) * 12, �μ���, �ٹ���(������ ū ��) ���
SELECT ENAME, JOB, SAL, COMM, (SAL+NVL(COMM,0)) * 12 AS YEONBONG, DNAME, D.LOC
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') ORDER BY YEONBONG DESC;
-- EX. COMM�� NULL�̰� SAL�� 1200�̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� (�μ����, �޿� ū �� ����)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL >= 1200 ORDER BY DNAME, SAL DESC;
--? źź ������
--��	���忡�� �ٹ��ϴ� ����� �̸��� �޿��� ����Ͻÿ�
SELECT ENAME, SAL 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND D.LOC = 'NEW YORK';
--��	ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի����� ����Ͻÿ�
SELECT ENAME, HIREDATE 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
--��	������ MANAGER�� ����� �̸�, �μ����� ����Ͻÿ�
SELECT ENAME, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
--��	Comm�� null�� �ƴ� ����� �̸�, �޿�, �μ��ڵ�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, E.DEPTNO, LOC 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;

-- 2. NON EQUI JOIN : ���� ���� ����� ����. ���� ���� X�� ��...
SELECT * FROM EMP WHERE ENAME = 'SCOTT' ; -- SALL�� 3õ.. �޿������ ��������?
SELECT * FROM SALGRADE; -- SALGRADE�� Ȯ���� ��� 2001~3000 ���̿� �ִ� 4�����.
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; -- CROSS JOIN (EMP�� 1�� * SALGRADE�� 5���� ������ 5���̳� ���...)
SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME = 'SCOTT';   -- ������~������ ����
-- SAL�̶�� ���� LOSAL�� HISAL ���̿� ���� �� ���.
-- EX. ��� ����� ���, �̸�, ��å, �����, �޿�, �޿����(1���,2���, ...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'��' AS GRADE 
FROM EMP, SALGRADE 
WHERE SAL BETWEEN LOSAL AND HISAL;
-- Ȥ�� SAL >= LOSAL AND SAL <=HISAL;
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, EMP.DEPTNO, DNAME, LOC 
FROM EMP, DEPT, SALGRADE 
WHERE EMP.DEPTNO=DEPT.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
-- ���� �� ������ ������, �ߺ����� ���� ���� ������
--	�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL;
--	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM,0))* 12 YEONBONG, DNAME 
FROM DEPT, EMP, SALGRADE 
WHERE DEPT.DEPTNO=EMP.DEPTNO AND SAL BETWEEN LOSAL AND HISAL ORDER BY DNAME, YEONBONG DESC;
---	�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, DEPT.DEPTNO, DNAME 
FROM EMP,DEPT, SALGRADE
WHERE DEPT.DEPTNO=EMP.DEPTNO AND (SAL BETWEEN LOSAL AND HISAL) 
AND SAL BETWEEN 1000 AND 3000 ORDER BY DNAME, JOB, SAL DESC;
---	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
FROM EMP, DEPT, SALGRADE
WHERE DEPT.DEPTNO=EMP.DEPTNO AND (SAL BETWEEN LOSAL AND HISAL) 
AND TO_CHAR(HIREDATE, 'RR') LIKE '81' ORDER BY GRADE DESC;

-- 3. SELF JOIN
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME
FROM EMP WORKER, EMP MANAGER
WHERE WORKER.ENAME='SMITH'; -- ũ�ν�����.. SMITH��� �̸��� ��� ����� �� �޶�پ���.
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME FROM EMP W, EMP M WHERE W.ENAME='SMITH' AND W.MGR=M.EMPNO;
-- EX. ��� ����� ���, �̸�, ����� ���, ����� �̸�
SELECT W.EMPNO, W.ENAME, W.MGR, M.EMPNO, M.ENAME
FROM EMP W, EMP M
WHERE W.MGR=M.EMPNO; -- ��, ��簡 ���� ��� MGR�� (null)�� ����. EMPNO�� NULL�� ����� �����Ƿ� 1���� ����� �ȵ�.
-- EX. 'SMITH'�� ���� FORD��' �������� 13�� ���
SELECT W.ENAME||'�� ���� '||M.ENAME||'�̴�.' AS MSG
FROM EMP W, EMP M
WHERE W.MGR=M.EMPNO; -- ����ȣ�� ����� ����� �����ϹǷ�...
-- źź. �Ŵ����� KING�� ������� �̸��� ������ ����Ͻÿ�.
SELECT W.ENAME, W.JOB, M.ENAME SANGSANAME
FROM EMP W, EMP M
WHERE W.MGR=M.EMPNO AND M.ENAME='KING';

-- SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT M.ENAME
FROM EMP W, EMP M, DEPT
WHERE W.DEPTNO=DEPT.DEPTNO AND W.DEPTNO=M.DEPTNO AND W.ENAME ='SCOTT' AND M.ENAME != W.ENAME;
-- �ߺ��Ǵ� ���̵� ����� ���� M.ENAME != W.ENAME�� ����Ͽ���.

-- SCOTT�� ������ �ٹ������� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
SELECT M.ENAME
FROM EMP W, EMP M, DEPT WW, DEPT MM
WHERE W.DEPTNO=WW.DEPTNO AND M.DEPTNO=MM.DEPTNO
AND WW.LOC=MM.LOC AND W.ENAME = 'SCOTT'
AND M.ENAME != W.ENAME;
 -- ���� �̸� �ߺ��� �����ϱ� ���� != NAME �� �־��ֱ�!

-- DEPT ���̺��� 50�μ��� �Է�. (50�μ��� DALLAS �ٹ����� �߰�)
SELECT * FROM DEPT;
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');
-- EMP ���̺��� DEPTNO 50�� �߰�.(���: DALLAS�� �ٹ����� �μ���ȣ: 20,50)
SELECT * FROM EMP ;
INSERT INTO EMP VALUES (8000, 'ȫ�浿', NULL, NULL, NULL, 800, NULL, 50);

SELECT * FROM EMP WHERE ENAME= 'SCOTT';
SELECT * FROM DEPT WHERE DEPTNO=20;
SELECT * FROM DEPT;
-- ������ ���󺹱�.. (DEPT 50�� INSERT, EMP 8000�� ��� INSERT)
ROLLBACK;

-- 4. OUTER JOIN : SELF JOIN�̳� EQUI JOIN �� ���ǿ� �������� �ʾ� ��µ��� �ʴ� ���� ��Ÿ���� �ϴ� ���.
-- (1) SELF JOIN���� OUTER JOIN �ϴ� ���
-- ���� ���� ��縦 ����ϴ� ���
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+) AND W.ENAME= 'KING';
-- ���� ���� ������ ����ϴ� ���
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO AND M.ENAME='SMITH';
-- (+)�� ��ġ�� ���� ���� ���, Ȥ�� ���� ����� ����� ���� ����.
-- EX.
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME ENAME2
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);
-- EX. 'SMITH'�� ���� '~��' �������� ���. 'KING�� ���� ����'
SELECT W.ENAME||'�� ���� '|| NVL(M.ENAME, '��')|| '��.' AS MSG
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO;
SELECT W.ENAME, W.MGR, M.EMPNO, M.ENAME
FROM EMP W, EMP M
WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL;
-- ������ �ϱ޻��, �������� ���� ����� �� ���� �����Ͱ� ������(NULL) �ش� �κ��� ����ϸ� ��.

-- (2) EQUI JOIN���� OUTER JOIN �ϴ� ���
-- ��� ��µ� �� ������, ����� DEPT �� DEPTNO�� 40���� ������ ����. �ش� �μ��� ������ �������� �ʱ� ����
SELECT * FROM EMP; -- 14��
SELECT * FROM DEPT; -- 4��.. 2���� �ѹ��� ����ϴ� ���, 40�� �μ��� ����. �� ���� �ش� ���� ���� �ʿ� (+)�� ���ָ� �ذ�.
SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO(+) = DEPT.DEPTNO;

-- PART 1.

--1. �̸�, ���ӻ���
SELECT W.ENAME, M.ENAME SANGSA
FROM EMP W, EMP M
WHERE W.MGR=M.EMPNO;
--2. �̸�, �޿�, ����, ���ӻ���
SELECT W.ENAME, W.SAL, W.JOB, M.ENAME AS SANGSA
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO;
--3. �̸�, �޿�, ����, ���ӻ��� . (��簡 ���� �������� ��ü ���� �� ���.
    --��簡 ���� �� '����'���� ���)
SELECT W.ENAME, W.SAL, W.JOB, NVL(M.ENAME,'����') AS SANGSA
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);
--4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME, W.SAL, DNAME, M.ENAME AS SANGSA
FROM EMP W, EMP M, DEPT D
WHERE W.DEPTNO= D.DEPTNO AND W.MGR = M.EMPNO;
--5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME, W.SAL, D.DEPTNO, DNAME, D.LOC, M.ENAME AS SANGSA
FROM EMP W, EMP M, DEPT D
WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+);
--6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME, W.SAL, S.GRADE, DNAME, M.ENAME AS SANGSA
FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE  W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL AND W.SAL >=2000;
--7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME, W.SAL, S.GRADE, NVL(M.ENAME,'����') AS SANGSA
FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO(+) AND W.SAL BETWEEN LOSAL AND HISAL ORDER BY DNAME;
--8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. ����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME, W.SAL, S.GRADE, DNAME, (W.SAL+ NVL(W.COMM,0))*12 AS YEONBONG, M.ENAME AS SANGSA
FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL;
--9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME, W.SAL, S.GRADE, DNAME, ((W.SAL+ NVL(W.COMM,0))*12) AS YEONBONG, M.ENAME AS SANGSA
FROM EMP W, EMP M, DEPT D, SALGRADE S
WHERE W.DEPTNO=D.DEPTNO AND W.MGR=M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL ORDER BY DNAME, YEONBONG DESC;

--  PART2
--1. ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO;
--2. NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT ENAME, JOB, SAL, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND LOC= 'NEW YORK';
--3. ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND COMM > 0;
-- ���ʽ��� �����Ƿ�, COMM�� 0���� Ŀ����.
--4. �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE ('%L%');
--5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO ORDER BY ENAME;
--6. ���, �����, �޿�, �μ����� �˻��϶�. 
    --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND SAL >=2000 ORDER BY SAL DESC;
--7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
-- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND ( JOB = 'MANAGER' AND SAL>=2500) ORDER BY EMPNO;
--8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL, S.GRADE
FROM EMP E, SALGRADE S WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY SAL DESC;
--9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
SELECT W.ENAME, NVL(M.ENAME,'����') AS SANGSA
FROM EMP W, EMP M
WHERE W.MGR= M.EMPNO(+);
--10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT A.ENAME, B.ENAME AS SANGSA, C.ENAME AS SANGSAOFSANGSA
FROM EMP A, EMP B, EMP C
WHERE A.MGR=B.EMPNO AND B.MGR=C.EMPNO(+);
--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT A.ENAME, NVL(B.ENAME,'����') AS SANGSA, NVL(C.ENAME,'����') AS SANGSAOFSANGSA
FROM EMP A, EMP B, EMP C
WHERE A.MGR=B.EMPNO(+) AND B.MGR=C.EMPNO(+);


