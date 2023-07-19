-- SELECT문 - 조회
-- 1. SELECT 문장 작성법 (실행방법 : CTRL + ENTER)
SHOW USER; -- 대소문자는 구분하지않으나 대부분 대문자를 사용. java에 넣는 경우가 많으므로, 구분을 위함
SELECT * FROM TAB; -- 현재 계정이 가지고 있는 테이블 정보
SELECT * FROM EMP; -- EMP 테이블이 가진 모든 열 (필드) 출력
SELECT * FROM DEPT; -- DEPT 테이블의 모든 열, 모든 행 출력.. 20 연구 30 판매...
SELECT * FROM SALGRADE; -- SALGRADE 테이블의 모든 열(필드), 모든 행 출력.. 월급이 700~1200이면 1등급, 1201~1400이면 2등급...
-- 모든 열 출력이 싫고, 특정 열만 출력하고 싶다면?
-- 2. 특정 열만 출력하는 방법
DESC EMP; 
-- EMP 테이블의 열을 보여줌. (description) NUMBER(4) 인 경우는 4자리까지의 숫자, VARCHAR2(10)인 경우 10자리까지의 문자열.
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
-- EMP 테이블 중 위 필드 이름을 가진 데이터를 출력함.
SELECT EMPNO, ENAME, SAL, JOB, MGR, COMM FROM EMP;
-- EMP 테이블 중... MGR 직속상사...
SELECT EMPNO AS "사 번", ENAME AS "이 름", SAL AS "급 여", JOB AS "직 책" FROM EMP;
-- ALIAS (별칭)
SELECT EMPNO AS "사 번", ENAME AS 이름, SAL AS 급여, JOB AS 직책 FROM EMP;
-- 띄어쓰기가 없는 경우엔 쌍따옴표를 넣지 않아도 괜찮음. 일반적으로 SELECT 이후 줄을 바꾸고 FROM을 넣어 가독성을 높임.
SELECT EMPNO "N O", ENAME NAME, SAL SALARY, JOB FROM EMP;
-- as를 넣지 않고 필드의 별칭을 변경할 수도 있음. 단, 진짜 필드의 이름을 바꾼 것이 아니라, 화면에 보이는 별칭만 바꾼 것.
-- 특정한 열은 SELECT (열) from (테이블) ,그런데 특정한 행만 출력하려면?
-- 3. 특정 행 출력 : WHERE (조건절). 비교연산자는 =, 이외에는 동일 (!=, <>, >, >=, <, <=...)
SELECT EMPNO 사번, ENAME 이름, SAL 급여 FROM EMP WHERE SAL=3000;
-- 위 행을 출력하고, 그 중 급여가 3천이라는 조건에 부합하는 사람을 출력
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL != 3000;
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL <> 3000;
SELECT EMPNO NO, ENAME ENAME, SAL FROM EMP WHERE SAL ^= 3000;
SELECT * FROM EMP WHERE SAL < 3000;
-- 모든 열 중에서 월급 3천 미만인 모든 인원을 출력. 그런데 숫자가 아닌 문자열도 크기 비교가 가능함.
-- 문자(VARCHAR2), DATE도 가능. 
-- ex1) 사원이름(ENAME)이 'A','B','C'로 시작하는 사원의 모든 필드 출력하는 경우, A<AA<AAA<... <B < BA <BAA < BB <...C
SELECT * FROM EMP WHERE ENAME < 'D';
-- D보다 작은 이름을 검색했으므로 C까지 사람들이 출력됨.
-- ex2) 81년도 이전에 입사한 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE HIREDATE < '82/01/01';
-- ex3) 부서번호가 10번 부서인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO = 10;
-- 문자는 기본적으로 '를 이용하여 출력. 
-- ex4) 이름이 FORD인 직원의 사번(EMPNO), 이름(ENAME), 상사의 (MGR) 출력
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME='FORD';
-- 단, 데이터의 대소문자는 구분하므로 이에 주의할 것. 데이터 입력 시만큼은 대소문자를 확인!
-- 4. 논리연산자 : AND, OR, NOT
-- ex1) 급여(SAL)가 2000이상, 3000 이하인 직원의 모든 필드를 출력.
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL<= 3000;
-- SELECT로 나올 열(x)을 지정, WHERE로 나올 행(y)을 지정함.
-- ex) 82년도에 입사한 사원의 모든 필드를 출력.
SELECT * FROM EMP WHERE HIREDATE > '12/31/1981' AND HIREDATE < '01/01/1983';
-- 날짜 표기법을 변경하는 방법? (현재는 YY-MM-DD 형식..) 그런데 시스템마다 표기방법이 다르면 명령어도 바뀌어야 하므로 문제가 발생함.
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
-- 따라서 다음과 같이 사용함. 
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') > '81/12/31'
AND TO_CHAR(HIREDATE, 'RR/MM/DD') < '83/01/01';
-- 날짜 표기법을 복귀하는 방법
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
-- EX3. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12) 출력
SELECT ENAME, SAL, SAL*12 AS 연봉
FROM EMP WHERE SAL*12 >= 2400;
-- WHERE절에는 필드의 별칭을 사용할 수 없음. EMP 테이블을 가져오는 것(FROM)이 맨 첫번째 해석,
-- 조건을 만족하는 테이블을 추리는 것(WHERE)이 두번째 해석, 이 중 지정된 필드를 출력하는 (SELECT)가 세 번째임.
-- 따라서 SELECT에 ANNUALSAL을 넣어도 WHERE에는 적용되지 않음.
-- EX3. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12) 을 연봉순으로 출력.
SELECT ENAME, SAL, SAL*12 AS ANNUALSAL
FROM EMP WHERE SAL*12>2400 ORDER BY ANNUALSAL;
-- ORDER BY 는 SELECT보다 해석이 나중이므로 사용이 가능함.