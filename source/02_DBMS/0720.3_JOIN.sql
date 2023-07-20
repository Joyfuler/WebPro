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


-- 3.

-- 4. 

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
SELECT M.ENAME, W.ENAME  FROM EMP W, EMP M WHERE W.ENAME!=M.ENAME;
--10. �����, ����, ����� ������ �˻��Ͻÿ�

--11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
