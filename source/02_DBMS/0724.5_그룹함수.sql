-- [V] �׷��Լ� (�����Լ�) : SUM, AVG, MAX, MIN, COUNT, STDDEV(ǥ������), VARIANCE(�л�)
SELECT MAX(SAL) FROM EMP; --SAL �� �ְ� �Ѹ�
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; 
-- DEPTNO�� �ִ� ������ ���ϰ� �ʹٸ�, �ݵ�� GROUP BY�� �߰��ϰ� �Ȱ��� �־�� ��.
-- �ִ� ������ �޴� 1��� �� �޿��� ����ϰ� �ʹٸ�?
SELECT ENAME, MAX(SAL) FROM EMP GROUP BY ENAME; -- X..�������� �ʿ�
SELECT ENAME, SAL FROM EMP WHERE SAL= (SELECT MAX(SAL) FROM EMP); -- 2������. SELECT�� �ΰ� ��
-- 1. �׷��Լ��� �ǽ�
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT AVG(SAL), SUM(SAL) / COUNT(SAL) FROM EMP; -- AVG�� SUM���� COUNT�� ���� ��.. ������
SELECT SUM(COMM) FROM EMP; -- �󿩱������� 2200
SELECT COMM/14 FROM EMP; -- �󿩱��� ����� 2200���� 14�� ���� ��...? �ƴϸ� �󿩱��� ���� ������� �߸� ��հ�?
SELECT SUM(COMM) / COUNT(COMM) FROM EMP;  -- ����Ŭ�� NULL�� �����ϰ� ���� ������� ����� ����. (2200/4 = 550)
-- ��ջ� �ƴ϶� ��� �׷��Լ��� NULL�� �����ϰ� ������.
SELECT COUNT(*) FROM EMP; -- EMP ���̺��� �� �� ���� 14��.
-- EX. SAL�� ���, ��, �ּҰ�, �ִ밪, �л�, ǥ������, ���� (�Ҽ��� ���ڸ����� �ݿø�)
SELECT ROUND(AVG(SAL),1), SUM(SAL), MAX(SAL), MIN(SAL), ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL),1), COUNT(SAL) FROM EMP;
-- �׷��Լ� MIN, MAX, COUNT�� ������, ������, ��¥�� ��� ����
SELECT MIN(ENAME), MIN(HIREDATE) FROM EMP;
-- źźex1. �Ի����� ���� ������ ����� �Ի��ϰ� ���� �ֱٿ� �Ի��� ����� �Ի����� ���. 
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE= (SELECT MAX(HIREDATE) FROM EMP);
-- źźex2. (���) 80/12/17:155590��° 83/01/12:14803��°
	--  (hint : TRUNC, MIN, ||)
    
SELECT MAX(HIREDATE) ||': '|| TRUNC(SYSDATE-MAX(HIREDATE)) ||'��°',  
MIN(HIREDATE) || ': ' ||TRUNC(SYSDATE-MIN(HIREDATE)) || '��°' FROM EMP;
-- źźex3.  (���) 80��12��17�� �����Ի�:15,558��° 83��01��12�� �ֱ��Ի� :14,803��°
   --  (hint :TRUNC, MIN, ||, TO_CHAR)
SELECT TO_CHAR(MIN(HIREDATE), 'RR"��"MM"��"DD"�� �����Ի�: "')||  TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'999,999')) || '��°' FIRST FROM EMP;
SELECT TO_CHAR(MAX(HIREDATE), 'RR"��"MM"��"DD"�� �����Ի�: "') || TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)),'999,999')) || '��°' LAST FROM EMP;
   
-- źźex4. 10�� �μ� �Ҽ��� ��� �߿��� Ŀ�̼��� �޴� ����� ���� ���� ���ÿ�.
SELECT COUNT(COMM)||'��' FROM EMP WHERE COMM IS NOT NULL AND DEPTNO=10;

-- �� 2. GROUP BY ��
-- EX. �μ���ȣ�� �ִ�޿�, ��ձ޿� (�μ���ȣ �� ����)
SELECT DEPTNO, MAX(SAL), TRUNC(AVG(SAL),1) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO; -- GROUP BY�� �Ҷ��� DEPTNO�� �״�� ���ٰ�
-- GROUP BY �������� �ʵ��� ��Ī�� ����� �� ����. ��, ORDER BY �������� ��� ����.
SELECT DEPTNO �μ�, MAX(SAL) MAX, TRUNC(AVG(SAL)) AVG
FROM EMP GROUP BY DEPTNO ORDER BY MAX; -- GROUP BY�� ���� �ؼ��ǹǷ�, AS�� ����� �� ����. ó���� ���ǵ� ��� ����ؾ� ��.
-- �ݸ� ORDER BY�� �������� �ؼ��ǹǷ� �μ��� �־ �����.
-- ������� GROUP BY�� Ư�� ���� ���ؼ��� �׷�ȭ�� �����Ѵٴ� ���� Ư¡.