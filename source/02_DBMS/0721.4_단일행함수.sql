-- [IV] �������Լ�
-- �Լ� = �������Լ��� �׷��Լ��� ����
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
-- ���������� �Ǵ� �Լ�.
SELECT SUM(SAL), AVG(SAL) FROM EMP;
-- ���� ���� 1������ ����� �����Լ�.
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
-- ��ü�� �ƴ�, DEPTNO�� �հ� ����� ����ϰ� �ʹٸ�? -- �׷��Լ��� ������ ��.
-- �������Լ��� ���� : ���ڰ����Լ�, �ݿø�or����(��¥���).. ���ڰ����Լ�
-- 1998/12/12 --> 1998/**/** ������ ǥ���� ��
-- 1. ���� ���� �Լ�
SELECT FLOOR (34.5678) FROM DUAL;
-- DUAL ���̺��� ����Ŭ���� ������ 1��, 1��¥�� �������̺�.
SELECT * FROM DUAL;
SELECT FLOOR (34.5678*100)/100 FROM DUAL;
-- �ڹ�ó�� FLOOR�� �� ���� ������ �ſ� �����ϹǷ� TRUNC�� �ַ� �����.
SELECT TRUNC(34.5678,2) FROM DUAL; -- �Ҽ��� 2��°�ڸ����� ����.
SELECT TRUNC(34.5678) FROM DUAL; -- �ƹ��͵� ���� ��쿡���� �Ҽ����� ����.
SELECT TRUNC(34.5678,-1) FROM DUAL; -- ���̳ʽ��� �ִ� ���, ���� �ڸ� �̻󿡼� ����.
 -- EX. EMP ���̺��� �̸�, �޿� (���� �ڸ� ����)
 SELECT ENAME, TRUNC(SAL,-2) FROM EMP;
 SELECT ROUND(34.5678) FROM DUAL; -- ��� x�� �Ҽ����ݿø�
 SELECT ROUND(34.5678,2) FROM DUAL; -- �Ҽ��� 2�ڸ����� ����. (3��°���� �ݿø���)
 SELECT ROUND (34.5678,-1) FROM DUAL; -- ù��° �ڸ����� �ݿø� -> 30
 SELECT CEIL(34.5678) FROM DUAL;
 SELECT MOD (5,2) FROM DUAL; -- 5�� 2�� ���� ������ = 1
 -- EX. Ȧ�� �⵵�� �Ի��� ����� ��� ������ ���
 SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE,'RR'),2)=1;

-- 2. ���� ���� �Լ�
-- (1) ��ҹ��ڰ���
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- ù���ڸ��빮��. ��������
SELECT UPPER ('welcome to oracle') upper FROM DUAL; -- ��δ빮��
SELECT LOWER ('WELCOME TO ORACLE') FROM DUAL; -- ��μҹ���
-- EX. �̸��� Scott�� ������ ��� �ʵ�
SELECT * FROM EMP WHERE UPPER(ENAME) = 'SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME) = 'Scott';
SELECT * FROM EMP WHERE LOWER(ENAME) = 'scott';

-- (2) ���ڿ����Լ� (CONCAT.. MYsql�� ���� ||�� �����Ƿ� ����)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
-- EX. SMITH�� MANAGER��
SELECT ENAME || '�� ' || JOB || '�̴�' msg FROM EMP WHERE ENAME='SMITH';
SELECT CONCAT(CONCAT(ENAME, '��'), CONCAT(JOB,'��')) MSG FROM EMP;
-- (3) SUBSTR( STR, ������ġ, ���ڰ���) : STR ���ڸ� ���� ��ġ���� ���� ������ŭ ������.
-- ������ġ�� 1���� ����, ��ġ�� ������ ��� ������ �ڸ����� ��.
-- SUBSTRB( STR, ���۹���Ʈ��ġ, ���ڹ���Ʈ��) : ������ ����Ʈ��
SELECT SUBSTR('�����������',1,3) FROM DUAL; -- ���ڼ���ŭ ����.
SELECT SUBSTRB ('LOL CRAP', 1,3) FROM DUAL;
SELECT SUBSTRB('�����������',1,3) FROM DUAL; -- ����Ŭ���� �ѱ��� 3����Ʈ�� ��޵ǹǷ� �ѱ��ڸ� ����Ǿ���
SELECT SUBSTRB('�����ͺ��̽�', 2,5) FROM DUAL;
SELECT SUBSTR ('010-9999-1234', -4,4) FROM DUAL;
SELECT SUBSTR('ORACLE', -1,1) FROM DUAL;
SELECT SUBSTR(123, -1, 1) FROM DUAL; --���� �����͵� �����.
-- EX. 9�Ͽ� �Ի��� ����� ��� ����
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE,'DD'), -2,2)='09';
-- (4) LENGTH (STR) : STR�� ���ڼ�. LENGTHB(STR) : STR�� ����Ʈ��
SELECT LENGTH('ABC') FROM DUAL; -- 3
SELECT LENGTHB('ABC') FROM DUAL; -- 3
SELECT LENGTHB('����Ŭ') FROM DUAL; -- 9

-- (5) LPAD (STR, �ڸ���, ä�﹮��) : STR ���� ���..STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���ڷ� ���.
-- ���� ä�� ���ڰ� ���ٸ�, �������� ä��. 
-- RPAD (STR, �ڸ���, ä�﹮��) : STR�� �ڸ�����ŭ Ȯ���ϰ�, ������ ���ڸ��� ä�� ���ڷ� ���
SELECT LPAD('ORACLE', 7, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '*') FROM DUAL;
SELECT ENAME, LPAD(SAL,4,'') FROM EMP;
DESC EMP;
SELECT RPAD (ENAME, 11, '-') ENAME, LPAD(SAL, 6, '*') SAL FROM EMP;
SELECT LPAD (ENAME, 11) ENAME, RPAD(SAL, 6) SAL FROM EMP ;
-- EX. ��� �̸� ��� (7369 S****, 7521 W**).. �ձ��� 1���� ���� *�� ä��� ��. SUBSTR, LENGTH, RPAD ���. �̸��� ���ڼ��� ��������, ���̸�ŭ * ���
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*') FROM EMP;
-- EX. ���, �̸�, ��å(9�ڸ� Ȯ��) , �Ի��� ��� (7369 Smith __����___****K 80/12/**) : LPAD, �������۾� (-1), HIREDATE(SUBSTR�� ����������), CONCAT
SELECT EMPNO, INITCAP(ENAME) ENAME, LPAD((LPAD(SUBSTR(JOB,-1,1),LENGTH(JOB),'*')),9,' ') LPAD, TO_CHAR(HIREDATE,'RR/MM/') || '**'  RPAD FROM EMP;

-- (6) INSTR(STR, ã������) : STR���� ù��° ���ں��� ã�� ���ڰ� ������ ��ġ (������ 0)
-- INSTR(STR, ã������, ������ġ) : STR���� ���� ��ġ���� ã�� ���ڰ� ������ ��ġ. ������ġ�� �ں��� ������ ��� -1
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- (2)
SELECT INSTR('ABCABC','B',3) FROM DUAL; --����° �ڸ����� B�� ��ġ�� ã��. ��, ã�� ��ġ ���� ���� ó������ �� ��. (5)
SELECT INSTR('ABCABC','B',-1) FROM DUAL; -- �ڿ������� '��������' B�� ��ġ�� ã��. ã�� ��ġ ���� ���� ó������ �� ��. (5)
SELECT INSTR('ABCABC','B',-3) FROM DUAL; -- �ڿ��� ����°���� '��������' B�� ��ġ�� ã��. ã�� ��ġ ���� ���� ó������ �� ��. (2)
-- EX. 9���� �Ի��� ����� ��� ������ ���
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE, 'RR-MM-DD'), '09', 4) = 4; -- 09��� ���� �׹�°���� ã�Ƽ� �ٷ� �´ٴ� ����. YY-MM-DD
-- EX. 9�Ͽ� �Ի��� ����� ��� ������ ���
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE, 'RR-MM-DD'), '09', 7) = 7; -- 09��� ���� 7��°���� ã�Ƽ�(1����) �ٷ� �´ٴ� ����.

-- (7) �������� : TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT '    ORACLE     ' MSG FROM DUAL;
SELECT TRIM('    ORACLE     ') MSG FROM DUAL;
SELECT LTRIM('    ORACLE     ') MSG FROM DUAL;
SELECT RTRIM('    ORACLE     ') MSG FROM DUAL;
-- (8) REPLACE(STR, �ٲ���ҹ���, �ٲ���)
SELECT ENAME, REPLACE(ENAME, 'A', 'XXX') RNAME FROM EMP ;
SELECT REPLACE(SAL, '0', 'X') FROM EMP;
SELECT REPLACE(TO_CHAR(HIREDATE,'RR-MM-DD'), '0', '*') FROM EMP ;

-- 3. ��¥ ���� �Լ� �� �����
--(1) ����ð��Է� - SYSDATE 
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR-MM-DD HH24:MI:SS'; -- MM�� �� �����̹Ƿ� MI�� �������
ALTER SESSION SET NLS_DATE_FORMAT =  'RR-MM-DD';
SELECT * FROM EMP; -- HIREDATE���� ��¥�� �Է��Ͽ����Ƿ� �ú��ʴ� 0�� 0������ ���
--(2) ��¥��� - ����Ŭ Ÿ�� (��¥, ����, ����) �� ��¥�� ���ڴ� ���갡��
SELECT SYSDATE-01 �����̽ð�, SYSDATE, SYSDATE+1 �����̽ð� FROM DUAL; -- +1�� �Ͽ� +�� ����
-- EX. �ݳ�������
SELECT SYSDATE ����, SYSDATE +14 �ݳ��� FROM DUAL;
SELECT TRUNC(SYSDATE-(TO_DATE('2023-06-26 09:30:00', 'RR-MM-DD HH24:MI:SS'))) FROM DUAL;
-- ��¥ ���� �Ҽ����� �ſ� ������Ƿ� TRUNC�� ���� �Ҽ����� ������ ��ĥ�� �������� �� �� ����.
-- EX. ���� ~ ����������� ��ĥ ��������?
SELECT '������� '||ABS(TRUNC(SYSDATE-(TO_DATE('2023-12-11 13:20:20', 'RR-MM-DD HH24:MI:SS'))))||'��' FROM DUAL;
-- EX. EMP���� �̸�, �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-(TO_DATE(HIREDATE))) FROM EMP;
-- EX. EMP���� �̸�, �Ի���, �ٹ�'��'��
SELECT ENAME, HIREDATE, 
TRUNC((SYSDATE-(TO_DATE(HIREDATE))) / 7) �ٹ��ϼ�,
TRUNC((SYSDATE-(TO_DATE(HIREDATE))) / 365.25 )  �ٹ���� FROM EMP; -- 2���� 4�⸶�� �Ϸ簡 �� ��⶧���� 0.25�� �߰���
-- (4) MONTH_BETWEEN(����1, ����2) ���� ������ ���� 28��, 30��, 31�ϵ� �����Ƿ� �Լ��� ���� �����. 
-- ����� ����1���� ����2�� ���Ƿ�, ����1�� �������� �����ؾ���.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
-- EX. �̸�, �Ի��� ���� ȸ�翡�� ���� ���� �� �翵��(������ �Ѵ޿� �ѹ�, �󿩱� 1�� 2��)
SELECT ENAME, SAL * TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) +
NVL (COMM,0 ) * 2 * TRUNC((SYSDATE - HIREDATE) / 365) COST -- �󿩱��� 1�⿡ �ι��̹Ƿ�, ������ ������ ���ϱ� 2�� ���־���
FROM EMP;
-- �� ���̿� ����� ���� ��¥�� ��� ADD_MONTHS (Ư������, ������) ���
-- �̸�, �Ի���, ����������� (�����Ⱓ 3����)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) ����������� FROM EMP;
SELECT ADD_MONTHS(TO_DATE('22.8.31', 'RR-MM-DD'),3) FROM DUAL;
-- �Ի����� 22.11.30�̸� �����Ⱓ�� 23.2.28
SELECT * FROM EMP;
INSERT INTO EMP VALUES (8000, 'ȫ�浿', NULL, NULL, '22/11/30', NULL, NULL, 40);
ROLLBACK; -- INSERT�� �����.
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE,3) FROM EMP;
-- (5) NEXT_DAY (Ư������, '��') : Ư�� �������� ó�� �����ϴ� �����. ���� ����Ŭ�� �ѱ۹����̹Ƿ� �Ͽ�ȭ�������θ� ����
SELECT NEXT_DAY(SYSDATE, 'ȭ') FROM DUAL;

-- (6) LAST_DAY (Ư������) : Ư�� ������ ���� (�޿� ���缭 28,29,30,31 �ڵ����)
SELECT LAST_DAY (SYSDATE) FROM DUAL;
-- �̸�, �Ի���, ù ���޳� (���޳��� ����)
SELECT ENAME, HIREDATE, ADD_MONTHS (LAST_DAY(HIREDATE),1) SALARY FROM EMP;
SELECT ENAME, HIREDATE, LAST_DAY (ADD_MONTHS(HIREDATE, 1)) SALARY FROM EMP;
SELECT ENAME, HIREDATE, LAST_DAY (ADD_MONTHS(HIREDATE, 1)) +10 SALARY FROM EMP;

-- (7) ROUND (��¥, 'XX')  XX; YEAR, MONTH,DAY
--      TRUNC (��¥, 'XX')  XX: YEAR, MONTH,DAY
SELECT ROUND (34.5678,1) FROM DUAL;
SELECT TRUNC (34.5678,1) FROM DUAL;
SELECT ROUND(HIREDATE, 'MONTH') FROM EMP; --�� ����� ������ �ݿø���. 16~31���̸� ������ 1�Ϸ�...
SELECT ROUND (HIREDATE, 'YEAR') FROM EMP; -- 6�������� �ش�� 1����. 7�����ʹ� ������ 1����
SELECT ROUND (TO_DATE(SYSDATE,'RR-MM-DD')) FROM EMP; -- �ƹ��͵� ���� ������ ����� 0�� 0������ �̵���.
SELECT ROUND (SYSDATE, 'DAY' ) FROM DUAL; -- ����� ����� �Ͽ��Ϸ� �̵�
SELECT TRUNC (SYSDATE, 'DAY') FROM DUAL; -- ����� ������ ������ �Ͽ��Ϸ� �̵�
SELECT TRUNC (SYSDATE, 'MONTH') FROM DUAL; -- ����� ������ ���� 1�Ϸ� �̵�.
SELECT TRUNC (SYSDATE, 'YEAR') FROM DUAL; -- ����� ������ ���� 1��1�Ϸ� �̵�.
-- �̸�, �Ի���, ù ���޳� (10��) : 1~9�� �Ի�� �̹��� 10�� ����, 11�� ���� �Ի�� ������ 10�� ����
SELECT ENAME, HIREDATE, ROUND(HIREDATE+6, 'MONTH')+9 NEXTSAL FROM EMP; -- HIREDATE�� ���� 6���� ���ؼ� 9���� 15�Ϸ� ���Ǿ� �̹��޿� ����
-- �̸�, �Ի���, ù ���޳� (20��) : 1~19�� �Ի�� �̹��� 20�� ����, 20�� ���� �Ի�� ������ 20�� ����
SELECT ENAME, HIREDATE, (ROUND(HIREDATE -4, 'MONTH')+19) NEXTSAL FROM EMP;

-- 4 .����ȯ�Լ� (TO_CHAR ��������ȯ / TO_DATE ��¥����ȯ)
-- (1) TO_CHAR (��¥��, '�������')
-- ������� : YYYY�⵵ 4�ڸ� / RR�⵵ 2�ڸ� / MM �� / DD �� / DY ���� 
-- HH24 / HH12 / AM�̳� PM / MI�� �� / SS ��
-- ������Ŀ� ���ڸ� ������ ��� " " ����ؾ� ��.
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"��"-MM"��"-DD"��" DY"����" HH24"��" MI"��" SS"��"') FROM EMP;
SELECT ENAME, TO_CHAR(HIREDATE, 'RR"��" MM"��" DD"��" DY"����" AM HH12:MI:SS') FROM EMP;
-- (2) TO_CHAR (������, '�������')
      -- ������� 0 : �ڸ���. ��������� �ڸ����� ������ �����ͺ��� ������ 0���� ä��
      -- ������� 9 : �ڸ���. ��������� �ڸ����� ������ �����ͺ��� ���Ƶ� ������ ������ ��ŭ�� �����. ��, �ڸ������ٴ� �� ���� �־�� ��.
      -- ������� , . : 
      -- ������� L : ������ȭ����. (�ѱ��� ��� ��)
      SELECT TO_CHAR (12345, '000,000') FROM DUAL; -- �ڸ�����ŭ ���.
      SELECT TO_CHAR (12345, '999,999') FROM DUAL; -- �ڸ����� ������� �ش� ������� ��µ�.
      SELECT TO_CHAR (1004.76, '99,999.9') FROM DUAL; -- �Ҽ������ε� ����.
      SELECT TO_CHAR (1200, 'L9,999') FROM DUAL; -- L���� ��, �� �ڸ����� 9 ������� ��µ�.
      SELECT TO_CHAR (1200, '$9,999') FROM DUAL;
      -- EX. �̸�, �޿�, ���ڸ����� �޸��� �߰��� $SAL
      SELECT ENAME, SAL, TO_CHAR(SAL, '$999,000') FROM EMP;
      
-- (3) TO_DATE (����, '����') YYYY, MM, DD...
SELECT * FROM EMP
WHERE HIREDATE BETWEEN TO_DATE('81/05/01','RR-MM-DD') AND TO_DATE('83/05/01','RR-MM-DD');
SELECT * FROM EMP
WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') BETWEEN '81/05/01' AND '83/05/01'; -- TO_CHAR() �̿�
-- DD/MM/RR ������ ������ �ٲ� ��� BETWEEN - AND�� ����� �������� ������ ����
-- (4) TO_NUMBER ('����', "����")
SELECT TO_CHAR(TO_NUMBER ('3,456', '9,999') +1 ,'9,999')  FROM DUAL;
SELECT '3456' + 1 FROM DUAL;

-- 5. NVL() (NULL�� ���� �ִ� ������. NULL�� ��츦 ����� ���� �������) �Ű����� 2���� Ÿ���� ��ġ�ؾ� ��.
-- Ÿ���� �ٸ� ��쿣 ����ȯ�� �̿��� �� ���� Ÿ���� �����־�� ��.
-- EX. ����̸�, ���ӻ���̸�(���ӻ�簡 ������ CEO��� ���)
SELECT W.ENAME, NVL(M.ENAME, 'CEO') MANAGER
FROM EMP W, EMP M
WHERE W.MGR  = M.EMPNO(+);
-- EX. ����̸�, ����� ��� (����� ����� ������ CEO�� ���)
SELECT W.ENAME, NVL(TO_CHAR(M.EMPNO), 'CEO')
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);

-- 6. ��Ÿ�Լ� (ETC)
-- (1) EXTRACT ; ��¥�� �����Ϳ��� �⵵, ��, �ϸ� �����ϰ��� �� �� ���
SELECT HIREDATE, EXTRACT (YEAR FROM HIREDATE) CHUCHUL FROM EMP; -- ��¥�� ���ڷ� ����
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY') CHUCHUL FROM EMP;
SELECT HIREDATE, EXTRACT (MONTH FROM HIREDATE) CHUCHUL FROM EMP; -- �� 0�� �����.
SELECT HIREDATE, TO_CHAR(HIREDATE, 'MM') CHUCHUL FROM EMP; -- �� 0�� ����
SELECT HIREDATE, EXTRACT (DAY FROM HIREDATE) CHUCHUL FROM EMP; --�ϸ� ���ڷ� ������ 0����
SELECT HIREDATE, TO_CHAR(HIREDATE, 'DD') CHUCHUL FROM EMP; --  0����

-- (2) LEVEL ������ ��� (���������� ��Ȯ�ϰ� �ϱ� ���ؼ�)
SELECT ENAME, SAL FROM EMP;
SELECT LEVEL, LPAD('��', LEVEL * 3) || ENAME ENAME, SAL FROM EMP
 START WITH MGR IS NULL -- ó�� �����ϴ� ������ ����.
 CONNECT BY PRIOR EMPNO = MGR; -- ���� ������ ����

-- �ڡ� <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT TO_CHAR(SYSDATE, 'RR-MM-DD') "Current date" FROM DUAL;
-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL * 1.15 AS "New Salary", ((SAL * 1.15) - SAL) "Increase"  FROM  EMP;
--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE,6),'��') MONDAY FROM EMP;
--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) GAEWOLSOO, 
SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) GEUPYEOCHONGGYE
FROM EMP;
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL,5,'*') SAL FROM EMP;
--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"') YOIL FROM EMP;
--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME) LENGTH, JOB FROM EMP WHERE LENGTH(ENAME) >=6;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM,0) BONUS, SAL+NVL(COMM,0) NET FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME,2,3) ENAME FROM EMP;
--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 12;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, '    '||ENAME ENAME,  LPAD(SAL,10,'*') �޿� FROM EMP; -- 10�ڸ� Ȯ���ϰ�, ��ĭ���� *�ֱ� 
-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME AS    ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') �Ի��� FROM EMP;
--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
DESC EMP;
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL,'$99,999') SAL FROM EMP WHERE DEPTNO = 20;
SELECT * FROM EMP;
INSERT INTO EMP VALUES (8000,'ȫ�浿',NULL, NULL, SYSDATE, 90000, NULL, 40);