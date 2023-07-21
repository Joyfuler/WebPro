-- SELECT문 - 조회
-- 1. SELECT 문장 작성법 (실행방법 : CTRL + ENTER)
SHOW USER; -- 대소문자는 구분하지않으나 대부분 대문자를 사용. java에 넣는 경우가 많으므로, 구분을 위함
SELECT * FROM TAB; -- 현재 계정이 가지고 있는 테이블 정보를 모두 출력
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
-- EX4. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12) 을 연봉순으로 출력.
SELECT ENAME, SAL, SAL*12 AS ANNUALSAL
FROM EMP WHERE SAL*12>2400 ORDER BY ANNUALSAL;
-- ORDER BY 는 SELECT보다 해석이 나중이므로 사용이 가능함.
-- EX5. 부서 번호가 10번(DEPTNO)이거나 JOB이 MANAGER인 직원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
-- EX6. 부서 번호가 10번 부서가 아닌 직원의 모든 필드
SELECT * FROM EMP WHERE NOT DEPTNO = 10;
-- 5. 산술연산자 (SELECT, WHERE, ORDER BY 모두 사용 가능) +,-,*,/
SELECT EMPNO, ENAME, SAL, SAL* 1.1 올릴월급 FROM EMP;
-- EX. 모든 사원의 이름 (ENAME) , 월급 (SAL), 상여 (COMM) 연봉 (SALARY * 12+ COMM)
SELECT ENAME, SAL, COMM, SAL*12+ NVL(COMM,0) 연봉 FROM EMP;
-- 산술연산 결과는 과정에 null이 있으면 결과도 null이 됨.
-- NVL(NULL일 수도 있는 필드명, 대체값) 이용. 타입은 통일해야함.
DESC EMP; --  EMP의 설명보기.
-- NVL을 이용해, 모든 사원의 이름과 상사의 사번 출력. 상사의 사번이 없으면 -1로 반환
SELECT ENAME, NVL(MGR,-1) FROM EMP;
-- NVL을 이용해, 모든 사원의 이름과 상사의 사번 출력. 상사의 사번이 없으면 CEO로 반환
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;
-- 숫자를 VARCHAR2로 바꿀수 없으므로 MGR을 CHAR 형태로 변환함.
-- 연결연산자 (||) 필드의 앞뒤를 이어줌.(문자연결)
SELECT ENAME || '은(는)' || JOB || '이다' AS MSG FROM EMP;
-- 모든 사원에 대해 SMITH: ANNUAL SALARY = xxx 포맷으로 출력
SELECT ENAME || ': ANNUAL SALARY= ' || (SAL*12+NVL(COMM,0)) AS "MSG" FROM EMP;
-- 오류... 연결연산자가 우선이므로, 문자열로 취급하였음. 문자와 숫자 덧셈이므로 오류 발생. 따라서 우선순위를 바꿀 수 있도록 숫자에 괄호를 넣어주자.
-- 7. 중복제거
SELECT DISTINCT JOB FROM EMP; -- DISTINCT를 통해 JOB값 중 중복되는 값을 제거할 수 있음.
SELECT DISTINCT DEPTNO FROM EMP;
-- ★ ★ ★ 연습문제
--1. emp 테이블의 구조 출력
DESC EMP;
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB; -- 시스템에서 기본적으로 만들어지는 테이블명.
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE> '81/01/31';
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') > '81/01/31';
-- 날짜 세팅이 RR/MM/DD가 아닐 수 있으므로, TO_CHAR로 감싸 형식을 맞춘 후 숫자를 비교해준다.
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB= 'SALESMAN';
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>= 2500 AND JOB='MANAGER';
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은' || JOB ||  ' 업무이고 연봉은 ' || (SAL *12+NVL(COMM,0)) || '이다' AS MSG FROM EMP;

--8. SQL연산자 (BETWEEN, IN, LIKE, IS NULL) 
-- (1) BETWEEN A AND B : A부터 B까지..항상 A가 작은 값으로 입력할것
-- 급여가 1500 이상이고 3000 이하인 사람의 사번, 이름 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
-- EX. 급여가 1500미만, 3000 초과인 사람의 모든 필드
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
-- 1500에서 3000 사이인 사람을 제외했으므로, 1500 미만과 3000 초과인 사람이 출력됨.
-- EX. 이름이 'A', 'B', 'C'로 시작하는 직원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME!= 'D';
-- C로 설정하는 경우 A~B까지만 출력. D로 설정해야 C로 시작되는 인원을 모두 출력이 가능함.
-- EX. 82년도에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
-- (2) IN (OR를 편리하게 사용)
-- EX. 부서번호 (DEPTNO)가 10,20,40번 부서인 직원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40); 
-- OR를 여러번 반복할 필요 없이, IN에 해당하는 수를 모두 집어넣으면 해결됨.
-- EX. 부서번호가 10,20,40번을 제외한 모든필드
SELECT * FROM EMP WHERE DEPTNO!= 10 AND DEPTNO!= 20 AND DEPTNO != 40;
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
-- EX. 사번이 7902, 7788, 7566인 사원의 모든 정보
SELECT * FROM EMP WHERE EMPNO IN (7902,7788,7566);
-- (3) LIKE 패턴 : %(0글자이상), _(한글자)을 포함한 패턴
-- EX. 이름이 M으로 시작하는 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
-- M% = 이름이 M이거나, M으로 시작하는 이름을 모두 검색.
-- EX. 이름에 M이 들어가는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%M%'; --중간에 M이 들어가는 경우를 모두검색. (M, ~M, M~, ~M~)
-- EX. 이름에 N이 들어있거나, JOB에 N이 들어가는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%';
-- EX. 이름이 'S'로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';
-- EX. 월급(SAL)이 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';
-- EX. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/__/__';
-- 언더바 1개당 글자 1개. 정확한 글자수를 알고 있다면...
-- EX. 1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '__/01/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '%/01/%';
-- 와일드카드함수 _ %
-- (4) IS NULL (값이 NULL인지 검색할 때 사용)
-- EX. 상여금(COMM)이 없는 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NULL; -- NULL은 =로 비교할 수 없음. 반드시 IS NULL로 찾아야..
-- EX. 상여금이 있는 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM != 0; 
-- 부정일 때는 IS NOT NULL 사용.
-- 9. 정렬 (오름차순, 내림차순) ORDER BY
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL;
-- 급여를 오름차순으로 정렬. ORDER BY 는 마지막에 출력할 것. ASCENDING SORT (ASC 생략되어 있음. 기본값)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC;
-- DESCENDING SORT(DESC는 수동으로 넣어줘야 함. ORDER BY ~ DESC)
-- 만일 2가지 이상 조건을 건 정렬을 넣고 싶다면?
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME; -- 이름 오름차순 정렬(ABC순)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- 입사일 오름차순 정렬 (작은 수부터 큰 수로, DESC면 반대)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, HIREDATE; 
-- 급여순 내림차순, 입사일 내림차순 (높은~낮은, 즉 최신입사일 순. 쉼표로 구분하자)

-- 총괄연습문제
--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=3000; 
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME,DEPTNO FROM EMP WHERE EMPNO = 7788;
--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL*12 + NVL(COMM,0) >=2400 ORDER BY SAL;
--4.	입사일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE TO_DATE(HIREDATE, 'RR-MM-DD') BETWEEN '81-02-20' AND '81-05-01' ORDER BY HIREDATE;
SELECT ENAME, JOB , HIREDATE FROM EMP WHERE HIREDATE BETWEEN TO_DATE('81-02-20') AND TO_DATE('81-05-01') ORDER BY HIREDATE;
--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;
--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME AS "employee", SAL AS "Monthly Salary" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN (10,30);
--7.	hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'RR-MM-DD') LIKE '%82-%';
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME!='Q' ORDER BY ENAME;
--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > SAL * 1.1;
--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB IN ('CLERK','ANALYST') AND SAL NOT IN (1000,3000,5000);
--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE ('%L%L%') AND ( DEPTNO=30 OR MGR=7782);
--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR-MM-DD') LIKE ('81-%');
--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR-MM-DD') LIKE ('81-%') AND NOT JOB = 'SALESMAN';
--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE ASC;
--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE ('__N%');
--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE ('%A%');
--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12+NVL(COMM,0) AS YEONBONG FROM EMP WHERE SAL*12 > 35000;

SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME='SCOTT';






















