-- SELECT�� - ��ȸ
-- 1. SELECT ���� �ۼ��� (������ : CTRL + ENTER)
SHOW USER; -- ��ҹ��ڴ� �������������� ��κ� �빮�ڸ� ���. java�� �ִ� ��찡 �����Ƿ�, ������ ����
SELECT * FROM TAB; -- ���� ������ ������ �ִ� ���̺� ������ ��� ���
SELECT * FROM EMP; -- EMP ���̺��� ���� ��� �� (�ʵ�) ���
SELECT * FROM DEPT; -- DEPT ���̺��� ��� ��, ��� �� ���.. 20 ���� 30 �Ǹ�...
SELECT * FROM SALGRADE; -- SALGRADE ���̺��� ��� ��(�ʵ�), ��� �� ���.. ������ 700~1200�̸� 1���, 1201~1400�̸� 2���...
-- ��� �� ����� �Ȱ�, Ư�� ���� ����ϰ� �ʹٸ�?
-- 2. Ư�� ���� ����ϴ� ���
DESC EMP; 
-- EMP ���̺��� ���� ������. (description) NUMBER(4) �� ���� 4�ڸ������� ����, VARCHAR2(10)�� ��� 10�ڸ������� ���ڿ�.
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
-- EMP ���̺� �� �� �ʵ� �̸��� ���� �����͸� �����.
SELECT EMPNO, ENAME, SAL, JOB, MGR, COMM FROM EMP;
-- EMP ���̺� ��... MGR ���ӻ��...
SELECT EMPNO AS "�� ��", ENAME AS "�� ��", SAL AS "�� ��", JOB AS "�� å" FROM EMP;
-- ALIAS (��Ī)
SELECT EMPNO AS "�� ��", ENAME AS �̸�, SAL AS �޿�, JOB AS ��å FROM EMP;
-- ���Ⱑ ���� ��쿣 �ֵ���ǥ�� ���� �ʾƵ� ������. �Ϲ������� SELECT ���� ���� �ٲٰ� FROM�� �־� �������� ����.
SELECT EMPNO "N O", ENAME NAME, SAL SALARY, JOB FROM EMP;
-- as�� ���� �ʰ� �ʵ��� ��Ī�� ������ ���� ����. ��, ��¥ �ʵ��� �̸��� �ٲ� ���� �ƴ϶�, ȭ�鿡 ���̴� ��Ī�� �ٲ� ��.
-- Ư���� ���� SELECT (��) from (���̺�) ,�׷��� Ư���� �ุ ����Ϸ���?
-- 3. Ư�� �� ��� : WHERE (������). �񱳿����ڴ� =, �̿ܿ��� ���� (!=, <>, >, >=, <, <=...)
SELECT EMPNO ���, ENAME �̸�, SAL �޿� FROM EMP WHERE SAL=3000;
-- �� ���� ����ϰ�, �� �� �޿��� 3õ�̶�� ���ǿ� �����ϴ� ����� ���
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL != 3000;
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL <> 3000;
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL ^= 3000;
SELECT * FROM EMP WHERE SAL < 3000;
-- ��� �� �߿��� ���� 3õ �̸��� ��� �ο��� ���. �׷��� ���ڰ� �ƴ� ���ڿ��� ũ�� �񱳰� ������.
-- ����(VARCHAR2), DATE�� ����. 
-- ex1) ����̸�(ENAME)�� 'A','B','C'�� �����ϴ� ����� ��� �ʵ� ����ϴ� ���, A<AA<AAA<... <B < BA <BAA < BB <...C
SELECT * FROM EMP WHERE ENAME < 'D';
-- D���� ���� �̸��� �˻������Ƿ� C���� ������� ��µ�.
-- ex2) 81�⵵ ������ �Ի��� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE HIREDATE < '82/01/01';
-- ex3) �μ���ȣ�� 10�� �μ��� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE DEPTNO = 10;
-- ���ڴ� �⺻������ '�� �̿��Ͽ� ���. 
-- ex4) �̸��� FORD�� ������ ���(EMPNO), �̸�(ENAME), ����� (MGR) ���
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME='FORD';
-- ��, �������� ��ҹ��ڴ� �����ϹǷ� �̿� ������ ��. ������ �Է� �ø�ŭ�� ��ҹ��ڸ� Ȯ��!
-- 4. �������� : AND, OR, NOT
-- ex1) �޿�(SAL)�� 2000�̻�, 3000 ������ ������ ��� �ʵ带 ���.
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL<= 3000;
-- SELECT�� ���� ��(x)�� ����, WHERE�� ���� ��(y)�� ������.
-- ex) 82�⵵�� �Ի��� ����� ��� �ʵ带 ���.
SELECT * FROM EMP WHERE HIREDATE > '12/31/1981' AND HIREDATE < '01/01/1983';
-- ��¥ ǥ����� �����ϴ� ���? (����� YY-MM-DD ����..) �׷��� �ý��۸��� ǥ������ �ٸ��� ��ɾ �ٲ��� �ϹǷ� ������ �߻���.
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
-- ���� ������ ���� �����. 
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') > '81/12/31'
AND TO_CHAR(HIREDATE, 'RR/MM/DD') < '83/01/01';
-- ��¥ ǥ����� �����ϴ� ���
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
-- EX3. ������ 2400�̻��� ������ ENAME, SAL, ����(SAL*12) ���
SELECT ENAME, SAL, SAL*12 AS ����
FROM EMP WHERE SAL*12 >= 2400;
-- WHERE������ �ʵ��� ��Ī�� ����� �� ����. EMP ���̺��� �������� ��(FROM)�� �� ù��° �ؼ�,
-- ������ �����ϴ� ���̺��� �߸��� ��(WHERE)�� �ι�° �ؼ�, �� �� ������ �ʵ带 ����ϴ� (SELECT)�� �� ��°��.
-- ���� SELECT�� ANNUALSAL�� �־ WHERE���� ������� ����.
-- EX4. ������ 2400�̻��� ������ ENAME, SAL, ����(SAL*12) �� ���������� ���.
SELECT ENAME, SAL, SAL*12 AS ANNUALSAL
FROM EMP WHERE SAL*12>2400 ORDER BY ANNUALSAL;
-- ORDER BY �� SELECT���� �ؼ��� �����̹Ƿ� ����� ������.
-- EX5. �μ� ��ȣ�� 10��(DEPTNO)�̰ų� JOB�� MANAGER�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
-- EX6. �μ� ��ȣ�� 10�� �μ��� �ƴ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE NOT DEPTNO = 10;
-- 5. ��������� (SELECT, WHERE, ORDER BY ��� ��� ����) +,-,*,/
SELECT EMPNO, ENAME, SAL, SAL* 1.1 �ø����� FROM EMP;
-- EX. ��� ����� �̸� (ENAME) , ���� (SAL), �� (COMM) ���� (SALARY * 12+ COMM)
SELECT ENAME, SAL, COMM, SAL*12+ NVL(COMM,0) ���� FROM EMP;
-- ������� ����� ������ null�� ������ ����� null�� ��.
-- NVL(NULL�� ���� �ִ� �ʵ��, ��ü��) �̿�. Ÿ���� �����ؾ���.
DESC EMP; --  EMP�� ������.
-- NVL�� �̿���, ��� ����� �̸��� ����� ��� ���. ����� ����� ������ -1�� ��ȯ
SELECT ENAME, NVL(MGR,-1) FROM EMP;
-- NVL�� �̿���, ��� ����� �̸��� ����� ��� ���. ����� ����� ������ CEO�� ��ȯ
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;
-- ���ڸ� VARCHAR2�� �ٲܼ� �����Ƿ� MGR�� CHAR ���·� ��ȯ��.
-- ���Ῥ���� (||) �ʵ��� �յڸ� �̾���.(���ڿ���)
SELECT ENAME || '��(��)' || JOB || '�̴�' AS MSG FROM EMP;
-- ��� ����� ���� SMITH: ANNUAL SALARY = xxx �������� ���
SELECT ENAME || ': ANNUAL SALARY= ' || (SAL*12+NVL(COMM,0)) AS "MSG" FROM EMP;
-- ����... ���Ῥ���ڰ� �켱�̹Ƿ�, ���ڿ��� ����Ͽ���. ���ڿ� ���� �����̹Ƿ� ���� �߻�. ���� �켱������ �ٲ� �� �ֵ��� ���ڿ� ��ȣ�� �־�����.
-- 7. �ߺ�����
SELECT DISTINCT JOB FROM EMP; -- DISTINCT�� ���� JOB�� �� �ߺ��Ǵ� ���� ������ �� ����.
SELECT DISTINCT DEPTNO FROM EMP;
-- �� �� �� ��������
--1. emp ���̺��� ���� ���
DESC EMP;
--2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
--3. �� scott �������� ��밡���� ���̺� ���
SELECT * FROM TAB; -- �ý��ۿ��� �⺻������ ��������� ���̺��.
--4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;
--6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE> '81/01/31';
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') > '81/01/31';
-- ��¥ ������ RR/MM/DD�� �ƴ� �� �����Ƿ�, TO_CHAR�� ���� ������ ���� �� ���ڸ� �����ش�.
--7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB= 'SALESMAN';
--8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
--9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
--10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
--11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
--12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>= 2500 AND JOB='MANAGER';
--13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME || '��' || JOB ||  ' �����̰� ������ ' || (SAL *12+NVL(COMM,0)) || '�̴�' AS MSG FROM EMP;

--8. SQL������ (BETWEEN, IN, LIKE, IS NULL) 
-- (1) BETWEEN A AND B : A���� B����..�׻� A�� ���� ������ �Է��Ұ�
-- �޿��� 1500 �̻��̰� 3000 ������ ����� ���, �̸� �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
-- EX. �޿��� 1500�̸�, 3000 �ʰ��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
-- 1500���� 3000 ������ ����� ���������Ƿ�, 1500 �̸��� 3000 �ʰ��� ����� ��µ�.
-- EX. �̸��� 'A', 'B', 'C'�� �����ϴ� ������ ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME!= 'D';
-- C�� �����ϴ� ��� A~B������ ���. D�� �����ؾ� C�� ���۵Ǵ� �ο��� ��� ����� ������.
-- EX. 82�⵵�� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
-- (2) IN (OR�� ���ϰ� ���)
-- EX. �μ���ȣ (DEPTNO)�� 10,20,40�� �μ��� ������ ��� �ʵ带 ���
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40); 
-- OR�� ������ �ݺ��� �ʿ� ����, IN�� �ش��ϴ� ���� ��� ��������� �ذ��.
-- EX. �μ���ȣ�� 10,20,40���� ������ ����ʵ�
SELECT * FROM EMP WHERE DEPTNO!= 10 AND DEPTNO!= 20 AND DEPTNO != 40;
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
-- EX. ����� 7902, 7788, 7566�� ����� ��� ����
SELECT * FROM EMP WHERE EMPNO IN (7902,7788,7566);
-- (3) LIKE ���� : %(0�����̻�), _(�ѱ���)�� ������ ����
-- EX. �̸��� M���� �����ϴ� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
-- M% = �̸��� M�̰ų�, M���� �����ϴ� �̸��� ��� �˻�.
-- EX. �̸��� M�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%M%'; --�߰��� M�� ���� ��츦 ��ΰ˻�. (M, ~M, M~, ~M~)
-- EX. �̸��� N�� ����ְų�, JOB�� N�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
-- EX. �̸��� 'S'�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';
-- EX. ����(SAL)�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
-- EX. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
-- ����� 1���� ���� 1��. ��Ȯ�� ���ڼ��� �˰� �ִٸ�...
-- EX. 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '__/01/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '%/01/%';
-- ���ϵ�ī���Լ� _ %
-- (4) IS NULL (���� NULL���� �˻��� �� ���)
-- EX. �󿩱�(COMM)�� ���� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL; -- NULL�� =�� ���� �� ����. �ݵ�� IS NULL�� ã�ƾ�..
-- EX. �󿩱��� �ִ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM != 0; 
-- ������ ���� IS NOT NULL ���.
-- 9. ���� (��������, ��������) ORDER BY
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL;
-- �޿��� ������������ ����. ORDER BY �� �������� ����� ��. ASCENDING SORT (ASC �����Ǿ� ����. �⺻��)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC;
-- DESCENDING SORT(DESC�� �������� �־���� ��. ORDER BY ~ DESC)
-- ���� 2���� �̻� ������ �� ������ �ְ� �ʹٸ�?
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME; -- �̸� �������� ����(ABC��)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- �Ի��� �������� ���� (���� ������ ū ����, DESC�� �ݴ�)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE; 
-- �޿��� ��������, �Ի��� �������� (����~����, �� �ֽ��Ի��� ��. ��ǥ�� ��������)

-- �Ѱ���������
--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000; 
--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME,DEPTNO FROM EMP WHERE EMPNO = 7788;
--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12 + NVL(COMM,0) >=2400 ORDER BY SAL;
--4.	�Ի����� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE TO_DATE(HIREDATE, 'RR-MM-DD') BETWEEN '81-02-20' AND '81-05-01' ORDER BY HIREDATE;
SELECT ENAME, JOB , HIREDATE FROM EMP WHERE HIREDATE BETWEEN TO_DATE('81-02-20') AND TO_DATE('81-05-01') ORDER BY HIREDATE;
--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;
--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME AS "employee", SAL AS "Monthly Salary" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN (10,30);
--7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'RR-MM-DD') LIKE '%82-%';
--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME!='Q' ORDER BY ENAME;
--9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > SAL * 1.1;
--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000,3000,5000);
--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
--��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE ('%L%L%') AND ( DEPTNO=30 OR MGR=7782);
--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR-MM-DD') LIKE ('81-%');
--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
-- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR-MM-DD') LIKE ('81-%') AND NOT JOB = 'SALESMAN';
--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
-- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE ASC;
--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE ('__N%');
--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE ('%A%');
--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12+NVL(COMM,0) AS YEONBONG FROM EMP WHERE SAL*12 > 35000;

SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME='SCOTT';






















