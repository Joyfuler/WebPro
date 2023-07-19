-- SELECT�� - ��ȸ
-- 1. SELECT ���� �ۼ��� (������ : CTRL + ENTER)
SHOW USER; -- ��ҹ��ڴ� �������������� ��κ� �빮�ڸ� ���. java�� �ִ� ��찡 �����Ƿ�, ������ ����
SELECT * FROM TAB; -- ���� ������ ������ �ִ� ���̺� ����
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
-- EX3. ������ 2400�̻��� ������ ENAME, SAL, ����(SAL*12) �� ���������� ���.
SELECT ENAME, SAL, SAL*12 AS ANNUALSAL
FROM EMP WHERE SAL*12>2400 ORDER BY ANNUALSAL;
-- ORDER BY �� SELECT���� �ؼ��� �����̹Ƿ� ����� ������.