-- [IV] 단일행함수
-- 함수 = 단일행함수와 그룹함수로 구성
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
-- 단일행적용 되는 함수.
SELECT SUM(SAL), AVG(SAL) FROM EMP;
-- 여러 행을 1행으로 만드는 집계함수.
SELECT DEPTNO, SUM(SAL), AVG(SAL) FROM EMP GROUP BY DEPTNO;
-- 전체가 아닌, DEPTNO별 합과 평균을 계산하고 싶다면? -- 그룹함수를 적용할 것.
-- 단일행함수의 종류 : 숫자관련함수, 반올림or내림(날짜계산).. 문자관련함수
-- 1998/12/12 --> 1998/**/** 등으로 표시할 때
-- 1. 숫자 관련 함수
SELECT FLOOR (34.5678) FROM DUAL;
-- DUAL 테이블은 오라클에서 제공한 1행, 1열짜리 더미테이블.
SELECT * FROM DUAL;
SELECT FLOOR (34.5678*100)/100 FROM DUAL;
-- 자바처럼 FLOOR를 쓸 수도 있지만 매우 불편하므로 TRUNC를 주로 사용함.
SELECT TRUNC(34.5678,2) FROM DUAL; -- 소숫점 2번째자리에서 내림.
SELECT TRUNC(34.5678) FROM DUAL; -- 아무것도 없는 경우에서는 소숫점을 버림.
SELECT TRUNC(34.5678,-1) FROM DUAL; -- 마이너스를 넣는 경우, 일의 자리 이상에서 버림.
 -- EX. EMP 테이블에서 이름, 급여 (십의 자리 내림)
 SELECT ENAME, TRUNC(SAL,-2) FROM EMP;
 SELECT ROUND(34.5678) FROM DUAL; -- 언급 x시 소숫점반올림
 SELECT ROUND(34.5678,2) FROM DUAL; -- 소숫점 2자리까지 남김. (3번째에서 반올림됨)
 SELECT ROUND (34.5678,-1) FROM DUAL; -- 첫번째 자리에서 반올림 -> 30
 SELECT CEIL(34.5678) FROM DUAL;
 SELECT MOD (5,2) FROM DUAL; -- 5를 2로 나눈 나머지 = 1
 -- EX. 홀수 년도에 입사한 사원의 모든 정보를 출력
 SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE,'RR'),2)=1;

-- 2. 문자 관련 함수
-- (1) 대소문자관련
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- 첫문자만대문자. 어절단위
SELECT UPPER ('welcome to oracle') upper FROM DUAL; -- 모두대문자
SELECT LOWER ('WELCOME TO ORACLE') FROM DUAL; -- 모두소문자
-- EX. 이름이 Scott인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(ENAME) = 'SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME) = 'Scott';
SELECT * FROM EMP WHERE LOWER(ENAME) = 'scott';

-- (2) 문자연결함수 (CONCAT.. MYsql의 경우는 ||이 없으므로 주의)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
-- EX. SMITH는 MANAGER다
SELECT ENAME || '는 ' || JOB || '이다' msg FROM EMP WHERE ENAME='SMITH';
SELECT CONCAT(CONCAT(ENAME, '는'), CONCAT(JOB,'다')) MSG FROM EMP;
-- (3) SUBSTR( STR, 시작위치, 문자갯수) : STR 문자를 시작 위치부터 문자 갯수만큼 추출함.
-- 시작위치는 1부터 시작, 위치가 음수인 경우 끝부터 자리수를 셈.
-- SUBSTRB( STR, 시작바이트위치, 문자바이트수) : 추출할 바이트수
SELECT SUBSTR('ㅋㅋ개웃기네',1,3) FROM DUAL; -- 글자수만큼 추출.
SELECT SUBSTRB ('LOL CRAP', 1,3) FROM DUAL;
SELECT SUBSTRB('ㅋㅋ개웃기네',1,3) FROM DUAL; -- 오라클에서 한글은 3바이트로 취급되므로 한글자만 추출되었음
SELECT SUBSTRB('데이터베이스', 2,5) FROM DUAL;
SELECT SUBSTR ('010-9999-1234', -4,4) FROM DUAL;
SELECT SUBSTR('ORACLE', -1,1) FROM DUAL;
SELECT SUBSTR(123, -1, 1) FROM DUAL; --숫자 데이터도 적용됨.
-- EX. 9일에 입사한 사원의 모든 정보
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE,'DD'), -2,2)='09';
-- (4) LENGTH (STR) : STR의 글자수. LENGTHB(STR) : STR의 바이트수
SELECT LENGTH('ABC') FROM DUAL; -- 3
SELECT LENGTHB('ABC') FROM DUAL; -- 3
SELECT LENGTHB('오라클') FROM DUAL; -- 9

-- (5) LPAD (STR, 자리수, 채울문자) : STR 문자 출력..STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울 문자로 출력.
-- 만일 채울 문자가 없다면, 공백으로 채움. 
-- RPAD (STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고, 오른쪽 빈자리에 채울 문자로 출력
SELECT LPAD('ORACLE', 7, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '*') FROM DUAL;
SELECT ENAME, LPAD(SAL,4,'') FROM EMP;
DESC EMP;
SELECT RPAD (ENAME, 11, '-') ENAME, LPAD(SAL, 6, '*') SAL FROM EMP;
SELECT LPAD (ENAME, 11) ENAME, RPAD(SAL, 6) SAL FROM EMP ;
-- EX. 사번 이름 출력 (7369 S****, 7521 W**).. 앞글자 1개만 제외 *로 채우게 함. SUBSTR, LENGTH, RPAD 사용. 이름의 글자수를 가져오고, 길이만큼 * 출력
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME),'*') FROM EMP;
-- EX. 사번, 이름, 직책(9자리 확보) , 입사일 출력 (7369 Smith __공백___****K 80/12/**) : LPAD, 마지막글씨 (-1), HIREDATE(SUBSTR과 마지막글자), CONCAT
SELECT EMPNO, INITCAP(ENAME) ENAME, LPAD((LPAD(SUBSTR(JOB,-1,1),LENGTH(JOB),'*')),9,' ') LPAD, TO_CHAR(HIREDATE,'RR/MM/') || '**'  RPAD FROM EMP;

-- (6) INSTR(STR, 찾을문자) : STR에서 첫번째 문자부터 찾을 문자가 나오는 위치 (없으면 0)
-- INSTR(STR, 찾을문자, 시작위치) : STR에서 시작 위치부터 찾을 문자가 나오는 위치. 시작위치는 뒤부터 시작인 경우 -1
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- (2)
SELECT INSTR('ABCABC','B',3) FROM DUAL; --세번째 자리부터 B의 위치를 찾음. 단, 찾은 위치 값은 문자 처음부터 센 값. (5)
SELECT INSTR('ABCABC','B',-1) FROM DUAL; -- 뒤에서부터 '왼쪽으로' B의 위치를 찾음. 찾은 위치 값은 문자 처음부터 센 값. (5)
SELECT INSTR('ABCABC','B',-3) FROM DUAL; -- 뒤에서 세번째부터 '왼쪽으로' B의 위치를 찾음. 찾은 위치 값은 문자 처음부터 센 값. (2)
-- EX. 9월에 입사한 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE, 'RR-MM-DD'), '09', 4) = 4; -- 09라는 값이 네번째부터 찾아서 바로 온다는 조건. YY-MM-DD
-- EX. 9일에 입사한 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE, 'RR-MM-DD'), '09', 7) = 7; -- 09라는 값이 7번째부터 찾아서(1부터) 바로 온다는 조건.

-- (7) 여백제거 : TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT '    ORACLE     ' MSG FROM DUAL;
SELECT TRIM('    ORACLE     ') MSG FROM DUAL;
SELECT LTRIM('    ORACLE     ') MSG FROM DUAL;
SELECT RTRIM('    ORACLE     ') MSG FROM DUAL;
-- (8) REPLACE(STR, 바꿔야할문자, 바뀔문자)
SELECT ENAME, REPLACE(ENAME, 'A', 'XXX') RNAME FROM EMP ;
SELECT REPLACE(SAL, '0', 'X') FROM EMP;
SELECT REPLACE(TO_CHAR(HIREDATE,'RR-MM-DD'), '0', '*') FROM EMP ;

-- 3. 날짜 관련 함수 및 예약어
--(1) 현재시간입력 - SYSDATE 
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR-MM-DD HH24:MI:SS'; -- MM은 월 단위이므로 MI로 적어야함
ALTER SESSION SET NLS_DATE_FORMAT =  'RR-MM-DD';
SELECT * FROM EMP; -- HIREDATE에는 날짜만 입력하였으므로 시분초는 0시 0분으로 기록
--(2) 날짜계산 - 오라클 타입 (날짜, 숫자, 문자) 중 날짜와 숫자는 연산가능
SELECT SYSDATE-01 어제이시간, SYSDATE, SYSDATE+1 내일이시간 FROM DUAL; -- +1은 일에 +를 해줌
-- EX. 반납예정일
SELECT SYSDATE 오늘, SYSDATE +14 반납일 FROM DUAL;
SELECT TRUNC(SYSDATE-(TO_DATE('2023-06-26 09:30:00', 'RR-MM-DD HH24:MI:SS'))) FROM DUAL;
-- 날짜 계산시 소숫점이 매우 길어지므로 TRUNC를 통해 소숫점을 버리면 며칠이 지났는지 알 수 있음.
-- EX. 현재 ~ 수료시점까지 며칠 남았을까?
SELECT '수료까지 '||ABS(TRUNC(SYSDATE-(TO_DATE('2023-12-11 13:20:20', 'RR-MM-DD HH24:MI:SS'))))||'일' FROM DUAL;
-- EX. EMP에서 이름, 입사일, 근무일수
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-(TO_DATE(HIREDATE))) FROM EMP;
-- EX. EMP에서 이름, 입사일, 근무'주'수
SELECT ENAME, HIREDATE, 
TRUNC((SYSDATE-(TO_DATE(HIREDATE))) / 7) 근무일수,
TRUNC((SYSDATE-(TO_DATE(HIREDATE))) / 365.25 )  근무년수 FROM EMP; -- 2월은 4년마다 하루가 더 길기때문에 0.25를 추가함
-- (4) MONTH_BETWEEN(시점1, 시점2) 월은 월수에 따라 28일, 30일, 31일도 있으므로 함수를 따로 사용함. 
-- 계산은 시점1에서 시점2를 빼므로, 시점1을 나중으로 설정해야함.
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP;
-- EX. 이름, 입사한 이후 회사에서 받은 월급 및 사영금(월급은 한달에 한번, 상여금 1년 2번)
SELECT ENAME, SAL * TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) +
NVL (COMM,0 ) * 2 * TRUNC((SYSDATE - HIREDATE) / 365) COST -- 상여금은 1년에 두번이므로, 년으로 나누고 곱하기 2를 해주었음
FROM EMP;
-- 둘 사이에 몇개월이 지난 날짜를 계산 ADD_MONTHS (특정시점, 개월수) 계산
-- 이름, 입사일, 수습종료시점 (수습기간 3개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 3) 수습종료시점 FROM EMP;
SELECT ADD_MONTHS(TO_DATE('22.8.31', 'RR-MM-DD'),3) FROM DUAL;
-- 입사일이 22.11.30이면 수습기간은 23.2.28
SELECT * FROM EMP;
INSERT INTO EMP VALUES (8000, '홍길동', NULL, NULL, '22/11/30', NULL, NULL, 40);
ROLLBACK; -- INSERT를 취소함.
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE,3) FROM EMP;
-- (5) NEXT_DAY (특정시점, '토') : 특정 시점부터 처음 도래하는 토요일. 현재 오라클은 한글버전이므로 일월화수목금토로만 가능
SELECT NEXT_DAY(SYSDATE, '화') FROM DUAL;

-- (6) LAST_DAY (특정시점) : 특정 시점의 말일 (달에 맞춰서 28,29,30,31 자동계산)
SELECT LAST_DAY (SYSDATE) FROM DUAL;
-- 이름, 입사일, 첫 월급날 (월급날은 말일)
SELECT ENAME, HIREDATE, ADD_MONTHS (LAST_DAY(HIREDATE),1) SALARY FROM EMP;
SELECT ENAME, HIREDATE, LAST_DAY (ADD_MONTHS(HIREDATE, 1)) SALARY FROM EMP;
SELECT ENAME, HIREDATE, LAST_DAY (ADD_MONTHS(HIREDATE, 1)) +10 SALARY FROM EMP;

-- (7) ROUND (날짜, 'XX')  XX; YEAR, MONTH,DAY
--      TRUNC (날짜, 'XX')  XX: YEAR, MONTH,DAY
SELECT ROUND (34.5678,1) FROM DUAL;
SELECT TRUNC (34.5678,1) FROM DUAL;
SELECT ROUND(HIREDATE, 'MONTH') FROM EMP; --더 가까운 쪽으로 반올림됨. 16~31일이면 다음달 1일로...
SELECT ROUND (HIREDATE, 'YEAR') FROM EMP; -- 6월까지는 해당년 1월로. 7월부터는 다음해 1월로
SELECT ROUND (TO_DATE(SYSDATE,'RR-MM-DD')) FROM EMP; -- 아무것도 적지 않으면 가까운 0시 0분으로 이동함.
SELECT ROUND (SYSDATE, 'DAY' ) FROM DUAL; -- 결과는 가까운 일요일로 이동
SELECT TRUNC (SYSDATE, 'DAY') FROM DUAL; -- 결과는 무조건 지난번 일요일로 이동
SELECT TRUNC (SYSDATE, 'MONTH') FROM DUAL; -- 결과는 무조건 지난 1일로 이동.
SELECT TRUNC (SYSDATE, 'YEAR') FROM DUAL; -- 결과는 무조건 지난 1월1일로 이동.
-- 이름, 입사일, 첫 월급날 (10일) : 1~9일 입사면 이번달 10일 월급, 11일 이후 입사면 다음달 10일 월급
SELECT ENAME, HIREDATE, ROUND(HIREDATE+6, 'MONTH')+9 NEXTSAL FROM EMP; -- HIREDATE의 값에 6일을 더해서 9일이 15일로 계산되어 이번달에 월급
-- 이름, 입사일, 첫 월급날 (20일) : 1~19일 입사면 이번달 20일 월급, 20일 이후 입사면 다음달 20일 월급
SELECT ENAME, HIREDATE, (ROUND(HIREDATE -4, 'MONTH')+19) NEXTSAL FROM EMP;

-- 4 .형변환함수 (TO_CHAR 문자형변환 / TO_DATE 날짜형변환)
-- (1) TO_CHAR (날짜형, '출력형식')
-- 출력형식 : YYYY년도 4자리 / RR년도 2자리 / MM 월 / DD 일 / DY 요일 
-- HH24 / HH12 / AM이나 PM / MI는 분 / SS 초
-- 출력형식에 문자를 포함할 경우 " " 사용해야 함.
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY"년"-MM"월"-DD"일" DY"요일" HH24"시" MI"분" SS"초"') FROM EMP;
SELECT ENAME, TO_CHAR(HIREDATE, 'RR"년" MM"월" DD"일" DY"요일" AM HH12:MI:SS') FROM EMP;
-- (2) TO_CHAR (숫자형, '출력형식')
      -- 출력형식 0 : 자릿수. 출력형식의 자릿수가 숫자형 데이터보다 많으면 0으로 채움
      -- 출력형식 9 : 자릿수. 출력형식의 자릿수가 숫자형 데이터보다 많아도 숫자형 데이터 만큼만 출력함. 단, 자릿수보다는 더 많이 넣어야 함.
      -- 출력형식 , . : 
      -- 출력형식 L : 지역통화단위. (한국의 경우 원)
      SELECT TO_CHAR (12345, '000,000') FROM DUAL; -- 자릿수만큼 출력.
      SELECT TO_CHAR (12345, '999,999') FROM DUAL; -- 자릿수와 상관없이 해당 양식으로 출력됨.
      SELECT TO_CHAR (1004.76, '99,999.9') FROM DUAL; -- 소숫점으로도 가능.
      SELECT TO_CHAR (1200, 'L9,999') FROM DUAL; -- L에는 원, 뒤 자릿수는 9 양식으로 출력됨.
      SELECT TO_CHAR (1200, '$9,999') FROM DUAL;
      -- EX. 이름, 급여, 세자리마다 콤마가 추가된 $SAL
      SELECT ENAME, SAL, TO_CHAR(SAL, '$999,000') FROM EMP;
      
-- (3) TO_DATE (문자, '패턴') YYYY, MM, DD...
SELECT * FROM EMP
WHERE HIREDATE BETWEEN TO_DATE('81/05/01','RR-MM-DD') AND TO_DATE('83/05/01','RR-MM-DD');
SELECT * FROM EMP
WHERE TO_CHAR (HIREDATE, 'RR/MM/DD') BETWEEN '81/05/01' AND '83/05/01'; -- TO_CHAR() 이용
-- DD/MM/RR 등으로 순서를 바꿀 경우 BETWEEN - AND가 제대로 동작하지 않으니 주의
-- (4) TO_NUMBER ('문자', "패턴")
SELECT TO_CHAR(TO_NUMBER ('3,456', '9,999') +1 ,'9,999')  FROM DUAL;
SELECT '3456' + 1 FROM DUAL;

-- 5. NVL() (NULL일 수도 있는 데이터. NULL인 경우를 대신할 값을 집어넣음) 매개변수 2개의 타입은 일치해야 함.
-- 타입이 다른 경우엔 형변환을 이용해 두 개의 타입을 맞춰주어야 함.
-- EX. 사원이름, 직속상사이름(직속상사가 없으면 CEO라고 출력)
SELECT W.ENAME, NVL(M.ENAME, 'CEO') MANAGER
FROM EMP W, EMP M
WHERE W.MGR  = M.EMPNO(+);
-- EX. 사원이름, 상사의 사번 (상사의 사번이 없으면 CEO로 출력)
SELECT W.ENAME, NVL(TO_CHAR(M.EMPNO), 'CEO')
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+);

-- 6. 기타함수 (ETC)
-- (1) EXTRACT ; 날짜형 데이터에서 년도, 월, 일만 추출하고자 할 때 사용
SELECT HIREDATE, EXTRACT (YEAR FROM HIREDATE) CHUCHUL FROM EMP; -- 날짜를 숫자로 추출
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY') CHUCHUL FROM EMP;
SELECT HIREDATE, EXTRACT (MONTH FROM HIREDATE) CHUCHUL FROM EMP; -- 앞 0이 사라짐.
SELECT HIREDATE, TO_CHAR(HIREDATE, 'MM') CHUCHUL FROM EMP; -- 앞 0이 있음
SELECT HIREDATE, EXTRACT (DAY FROM HIREDATE) CHUCHUL FROM EMP; --일만 숫자로 추출함 0생략
SELECT HIREDATE, TO_CHAR(HIREDATE, 'DD') CHUCHUL FROM EMP; --  0포함

-- (2) LEVEL 계층별 출력 (계층구조를 명확하게 하기 위해서)
SELECT ENAME, SAL FROM EMP;
SELECT LEVEL, LPAD('└', LEVEL * 3) || ENAME ENAME, SAL FROM EMP
 START WITH MGR IS NULL -- 처음 시작하는 레벨의 조건.
 CONNECT BY PRIOR EMPNO = MGR; -- 이후 레벨의 조건

-- ★★ <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT TO_CHAR(SYSDATE, 'RR-MM-DD') "Current date" FROM DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL * 1.15 AS "New Salary", ((SAL * 1.15) - SAL) "Increase"  FROM  EMP;
--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE,6),'월') MONDAY FROM EMP;
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) GAEWOLSOO, 
SAL, SAL*TRUNC(MONTHS_BETWEEN(SYSDATE,HIREDATE)) GEUPYEOCHONGGYE
FROM EMP;
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL,5,'*') SAL FROM EMP;
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일"') YOIL FROM EMP;
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME) LENGTH, JOB FROM EMP WHERE LENGTH(ENAME) >=6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM,0) BONUS, SAL+NVL(COMM,0) NET FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME,2,3) ENAME FROM EMP;
--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 12;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, '    '||ENAME ENAME,  LPAD(SAL,10,'*') 급여 FROM EMP; -- 10자리 확보하고, 빈칸에는 *넣기 
-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME AS    ENAME, TO_CHAR(HIREDATE,'YYYY-MM-DD') 입사일 FROM EMP;
--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
DESC EMP;
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL,'$99,999') SAL FROM EMP WHERE DEPTNO = 20;
SELECT * FROM EMP;
INSERT INTO EMP VALUES (8000,'홍길동',NULL, NULL, SYSDATE, 90000, NULL, 40);