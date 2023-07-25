-- [V] 그룹함수 (집계함수) : SUM, AVG, MAX, MIN, COUNT, STDDEV(표준편차), VARIANCE(분산)
SELECT MAX(SAL) FROM EMP; --SAL 중 최고를 뿌림
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; 
-- DEPTNO별 최대 월급을 구하고 싶다면, 반드시 GROUP BY를 추가하고 똑같이 넣어야 함.
-- 최대 월급을 받는 1명과 그 급여를 출력하고 싶다면?
SELECT ENAME, MAX(SAL) FROM EMP GROUP BY ENAME; -- X..서브쿼리 필요
SELECT ENAME, SAL FROM EMP WHERE SAL= (SELECT MAX(SAL) FROM EMP); -- 2중쿼리. SELECT가 두개 들어감
-- 1. 그룹함수들 실습
SELECT ROUND(AVG(SAL),2) FROM EMP;
SELECT AVG(SAL), SUM(SAL) / COUNT(SAL) FROM EMP; -- AVG는 SUM에서 COUNT를 나눈 것.. 같은값
SELECT SUM(COMM) FROM EMP; -- 상여금의총합 2200
SELECT COMM/14 FROM EMP; -- 상여금의 평균은 2200명에서 14를 나눈 값...? 아니면 상여금을 받은 사람만을 추린 평균값?
SELECT SUM(COMM) / COUNT(COMM) FROM EMP;  -- 오라클은 NULL을 제외하고 받은 사람만의 평균을 구함. (2200/4 = 550)
-- 평균뿐 아니라 모든 그룹함수가 NULL을 제외하고 연산함.
SELECT COUNT(*) FROM EMP; -- EMP 테이블의 총 행 수는 14개.
-- EX. SAL의 평균, 합, 최소값, 최대값, 분산, 표준편차, 갯수 (소숫점 한자리에서 반올림)
SELECT ROUND(AVG(SAL),1), SUM(SAL), MAX(SAL), MIN(SAL), 
ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL),1), COUNT(SAL) 
FROM EMP;
-- 그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두 가능
SELECT MIN(ENAME), MIN(HIREDATE) FROM EMP;
-- 탄탄ex1. 입사한지 가장 오래된 사원의 입사일과 가장 최근에 입사한 사원의 입사일을 출력. 
SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE= (SELECT MAX(HIREDATE) FROM EMP);
-- 탄탄ex2. (결과) 80/12/17:155590일째 83/01/12:14803일째
	--  (hint : TRUNC, MIN, ||)
    
SELECT MAX(HIREDATE) ||': '|| TRUNC(SYSDATE-MAX(HIREDATE)) ||'일째',  
MIN(HIREDATE) || ': ' ||TRUNC(SYSDATE-MIN(HIREDATE)) || '일째' FROM EMP;
-- 탄탄ex3.  (결과) 80년12월17일 최초입사:15,558일째 83년01월12일 최근입사 :14,803일째
   --  (hint :TRUNC, MIN, ||, TO_CHAR)
SELECT TO_CHAR(MIN(HIREDATE), 'RR"년"MM"월"DD"일 최초입사: "')|| TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'999,999')) || '일째' FIRST FROM EMP;
SELECT TO_CHAR(MAX(HIREDATE), 'RR"년"MM"월"DD"일 최초입사: "') || TRIM(TO_CHAR(TRUNC(SYSDATE-MAX(HIREDATE)),'999,999')) || '일째' LAST FROM EMP;
   
-- 탄탄ex4. 10번 부서 소속의 사원 중에서 커미션을 받는 사원의 수를 구해 보시오.
SELECT COUNT(COMM)||'명' FROM EMP WHERE COMM IS NOT NULL AND DEPTNO=10;

-- ★ 2. GROUP BY 절
-- EX. 부서번호별 최대급여, 평균급여 (부서번호 순 정렬)
SELECT DEPTNO, MAX(SAL), TRUNC(AVG(SAL),1) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO; -- GROUP BY를 할때는 DEPTNO를 그대로 써줄것
-- GROUP BY 절에서는 필드의 별칭을 사용할 수 없음. 단, ORDER BY 절에서는 사용 가능.
SELECT DEPTNO 부서, MAX(SAL) MAX, TRUNC(AVG(SAL)) AVG
FROM EMP GROUP BY DEPTNO ORDER BY MAX; -- GROUP BY는 먼저 해석되므로, AS를 사용할 수 없다. 처음에 정의된 대로 사용해야 함.
-- 반면 ORDER BY는 마지막에 해석되므로 부서를 넣어도 실행됨.
-- 현재까지 GROUP BY는 특정 값에 대해서만 그룹화를 진행한다는 것이 특징.
-- EX. 부서명별 최대급여, 평균급여 (부서명순으로 정렬)
SELECT DNAME, MAX(SAL) MAXSAL, TRUNC(AVG(SAL)) AVGSAL 
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO GROUP BY DNAME ORDER BY DNAME;
-- EX. SAL이 5천 미만인 사원에 대해서만 부서번호별, 사원수, 최대급여, 최소급여, 평균급여 (부서번호 순 정렬
SELECT D.DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL) 
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND E.SAL < 5000 GROUP BY D.DEPTNO ORDER BY D.DEPTNO;

-- ★ 3. HAVING절
    -- EX. 부서번호별 평균급여 (평균급여가 2000 이상인 부서만 출력)
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO HAVING AVG(SAL) >= 2000; 
-- 해석하는 순서는 (1) FROM, (2) WHERE, (3) SELECT 이므로, SELECT 절에 있는 AVG(SAL)의 값을 아직 알 수 없음. 따라서  WHERE를 사용할 수 없음.
-- 필드의 조건을 사용하여 결과 제한 시에는 WHERE을 사용했지만,  그룹함수를 가지고 조건 비교를 위해서는 HAVING을 사용해야 함.
-- 위치는 GROUP BY 뒤에 일반적으로 사용함. (문법적으로는 앞에 써도 무관하지만 주의)
-- EX. SAL 이 5000 미만인 사원에 대해 부서명별 최소급여, 평균급여, 최대급여(단, 평균급여가 1800이상인 부서만 출력)
SELECT DNAME, MIN(SAL), ROUND(AVG(SAL),2), MAX(SAL) 
FROM EMP, DEPT WHERE EMP.DEPTNO=DEPT.DEPTNO AND SAL <5000 
GROUP BY DNAME
HAVING AVG(SAL)>=1800
ORDER BY AVG(SAL) DESC;

-- ★ 4. 그룹함수 결과의 집계값 - ROLLUP * 그룹함수: SUM(SAL), MAX(SAL) 등등...
SELECT NVL(TO_CHAR(DEPTNO),'없음'), SUM(SAL) 
FROM EMP GROUP BY ROLLUP(DEPTNO);
-- GROUP BY가 되는 DEPTNO에 ROLLUP을 추가하여 전체합이 출력되게 할 수 있음.
-- NVL 쓰기 위해서는 앞과 뒤의 타입을 통일해야 하므로, NULL이 들어갈 수 있는 DEPTNO에 NVL을 씌워준 뒤, 형태를 맞추기 위해 TO_CHAR을 사용하였음.
SELECT DEPTNO, JOB, AVG(SAL) 
FROM EMP GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO, JOB;
SELECT DEPTNO, NVL(JOB,'합개'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);
-- DEPTNO별로 ROLLUP되어 출력이 가능함. (NULL값..)
-- ★<총 연습문제>

-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*) INWONSOO, MAX(SAL) MAXSAL, MIN(SAL) MINSAL, SUM(SAL) SUMSAL 
FROM EMP;
-- 2. 업무별 인원수를 구하여 출력
SELECT JOB, COUNT(JOB) INWONSOO 
FROM EMP 
GROUP BY JOB;
--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL) - MIN(SAL) CHAYI 
FROM EMP;
-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DNAME, COUNT(DNAME) INWONSOO, 
ROUND(AVG(SAL),1) AVG, MIN(SAL) MINSAL, 
MAX(SAL) MAXSAL, SUM(SAL) SUMSAL
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
GROUP BY DNAME ORDER BY SUM(SAL) DESC;
-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*) COUNT, 
ROUND(AVG(SAL),1) AVG, SUM(SAL) SUMSAL
FROM EMP
GROUP BY DEPTNO, JOB ORDER BY DEPTNO, JOB;
-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(*) COUNT, 
AVG(SAL) AVGSAL, SUM(SAL) SUMSAL
FROM EMP
GROUP BY JOB, DEPTNO ORDER BY JOB, DEPTNO;
--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(ENAME) SAWONSOO
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(ENAME) >= 5;
-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(ENAME) SAWONSOO
FROM EMP, DEPT
WHERE DEPT.DEPTNO = EMP.DEPTNO
GROUP BY DNAME
HAVING COUNT(ENAME) >=5;
--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, ROUND(AVG(SAL),1) AVG, SUM(SAL) SUMSAL
FROM EMP
GROUP BY JOB
HAVING AVG(SAL) >= 3000;
--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL) SUMSAL
FROM EMP
GROUP BY JOB
HAVING SUM(SAL) > 5000 
ORDER BY SUM(SAL) DESC;
--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DNAME, ROUND(AVG(SAL),1) AVG, SUM(SAL) SUMSAL, MIN(SAL) MINSAL
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
GROUP BY DNAME;
--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT MAX(ROUND(AVG(SAL),1)) AVG, MAX(SUM(SAL)) SUMSAL, MAX(MIN(SAL)) MINSAL
FROM EMP
GROUP BY DEPTNO;

--13. 사원 테이블에서 아래의 결과를 출력
--   YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--     80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE,'RR') YEAR, COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
FROM EMP
WHERE TO_CHAR(HIREDATE, 'RR') BETWEEN 80 AND 83
GROUP BY TO_CHAR(HIREDATE,'RR') ORDER BY YEAR;


-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'RRRR'),'total') YEAR , COUNT(*) COUNT
FROM EMP
GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'RRRR'));
--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL) MAXSAL, MIN(SAL) MINSAL, SUM(SAL) SUMSAL, ROUND(AVG(SAL),1) AVG
FROM EMP;
--16. 부서별 인원수 출력
SELECT DNAME, COUNT(EMPNO)
FROM EMP, DEPT
WHERE EMP.DEPTNO(+) = DEPT.DEPTNO -- EMP에서 DEPTNO가 NULL인 경우가 있으므로 이쪽에 (+)를 해줘야 성립이 가능함
GROUP BY DNAME;
--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(DEPTNO) >=6;

SELECT DNAME,  COUNT(*) FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
GROUP BY DNAME
HAVING COUNT(*) >= 6;