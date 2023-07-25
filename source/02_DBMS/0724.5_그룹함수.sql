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
SELECT ROUND(AVG(SAL),1), SUM(SAL), MAX(SAL), MIN(SAL), 
ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL),1), COUNT(SAL) 
FROM EMP;
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
SELECT TO_CHAR(MIN(HIREDATE), 'RR"��"MM"��"DD"�� �����Ի�: "')|| TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'999,999')) || '��°' FIRST FROM EMP;
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
-- EX. �μ��� �ִ�޿�, ��ձ޿� (�μ�������� ����)
SELECT DNAME, MAX(SAL) MAXSAL, TRUNC(AVG(SAL)) AVGSAL 
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO GROUP BY DNAME ORDER BY DNAME;
-- EX. SAL�� 5õ �̸��� ����� ���ؼ��� �μ���ȣ��, �����, �ִ�޿�, �ּұ޿�, ��ձ޿� (�μ���ȣ �� ����
SELECT D.DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL) 
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND E.SAL < 5000 GROUP BY D.DEPTNO ORDER BY D.DEPTNO;

-- �� 3. HAVING��
    -- EX. �μ���ȣ�� ��ձ޿� (��ձ޿��� 2000 �̻��� �μ��� ���)
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO HAVING AVG(SAL) >= 2000; 
-- �ؼ��ϴ� ������ (1) FROM, (2) WHERE, (3) SELECT �̹Ƿ�, SELECT ���� �ִ� AVG(SAL)�� ���� ���� �� �� ����. ����  WHERE�� ����� �� ����.
-- �ʵ��� ������ ����Ͽ� ��� ���� �ÿ��� WHERE�� ���������,  �׷��Լ��� ������ ���� �񱳸� ���ؼ��� HAVING�� ����ؾ� ��.
-- ��ġ�� GROUP BY �ڿ� �Ϲ������� �����. (���������δ� �տ� �ᵵ ���������� ����)
-- EX. SAL �� 5000 �̸��� ����� ���� �μ��� �ּұ޿�, ��ձ޿�, �ִ�޿�(��, ��ձ޿��� 1800�̻��� �μ��� ���)
SELECT DNAME, MIN(SAL), ROUND(AVG(SAL),2), MAX(SAL) 
FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO AND SAL <5000 
GROUP BY DNAME
HAVING AVG(SAL)>=1800
ORDER BY AVG(SAL) DESC;

-- �� 4. �׷��Լ� ����� ���谪 - ROLLUP * �׷��Լ�: SUM(SAL), MAX(SAL) ���...
SELECT NVL(TO_CHAR(DEPTNO),'����'), SUM(SAL) 
FROM EMP GROUP BY ROLLUP(DEPTNO);
-- GROUP BY�� �Ǵ� DEPTNO�� ROLLUP�� �߰��Ͽ� ��ü���� ��µǰ� �� �� ����.
-- NVL ���� ���ؼ��� �հ� ���� Ÿ���� �����ؾ� �ϹǷ�, NULL�� �� �� �ִ� DEPTNO�� NVL�� ������ ��, ���¸� ���߱� ���� TO_CHAR�� ����Ͽ���.
SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO, JOB;
SELECT DEPTNO, NVL(JOB,'�հ�'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);
-- DEPTNO���� ROLLUP�Ǿ� ����� ������. (NULL��..)
-- ��<�� ��������>

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*) INWONSOO, MAX(SAL) MAXSAL, MIN(SAL) MINSAL, SUM(SAL) SUMSAL 
FROM EMP;
-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(JOB) INWONSOO 
FROM EMP 
GROUP BY JOB;
--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL) - MIN(SAL) CHAYI 
FROM EMP;
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DNAME, COUNT(DNAME) INWONSOO, 
ROUND(AVG(SAL),1) AVG, MIN(SAL) MINSAL, 
MAX(SAL) MAXSAL, SUM(SAL) SUMSAL
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
GROUP BY DNAME ORDER BY SUM(SAL) DESC;
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*) COUNT, 
ROUND(AVG(SAL),1) AVG, SUM(SAL) SUMSAL
FROM EMP
GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*) COUNT, 
AVG(SAL) AVGSAL, SUM(SAL) SUMSAL
FROM EMP
GROUP BY JOB, DEPTNO ORDER BY JOB, DEPTNO;
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(ENAME) SAWONSOO
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(ENAME) >= 5;
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(ENAME) SAWONSOO
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY DNAME
HAVING COUNT(ENAME) >=5;
--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, ROUND(AVG(SAL),1) AVG, SUM(SAL) SUMSAL
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) >= 3000;
--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL) SUMSAL
FROM EMP
GROUP BY JOB
HAVING SUM(SAL) > 5000 
ORDER BY SUM(SAL) DESC;
--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DNAME, ROUND(AVG(SAL),1) AVG, SUM(SAL) SUMSAL, MIN(SAL) MINSAL
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
GROUP BY DNAME;
--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT MAX(ROUND(AVG(SAL),1)) AVG, MAX(SUM(SAL)) SUMSAL, MAX(MIN(SAL)) MINSAL
FROM EMP
GROUP BY DEPTNO;

--13. ��� ���̺��� �Ʒ��� ����� ���
--   YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE,'RR') YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
FROM EMP
WHERE TO_CHAR(HIREDATE, 'RR') BETWEEN 80 AND 83
GROUP BY TO_CHAR(HIREDATE,'RR') ORDER BY YEAR;


-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'RRRR'),'total') YEAR , COUNT(*) COUNT
FROM EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'RRRR'));
--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL) MAXSAL, MIN(SAL) MINSAL, SUM(SAL) SUMSAL, ROUND(AVG(SAL),1) AVG
FROM EMP;
--16. �μ��� �ο��� ���
SELECT DNAME, COUNT(EMPNO)
FROM EMP, DEPT
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO -- EMP���� DEPTNO�� NULL�� ��찡 �����Ƿ� ���ʿ� (+)�� ����� ������ ������
GROUP BY DNAME;
--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(DEPTNO) >=6;

SELECT DNAME,  COUNT(*) FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY DNAME
HAVING COUNT(*) >= 6;