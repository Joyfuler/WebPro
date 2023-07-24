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
SELECT ROUND(AVG(SAL),1), SUM(SAL), MAX(SAL), MIN(SAL), ROUND(VARIANCE(SAL),1), ROUND(STDDEV(SAL),1), COUNT(SAL) FROM EMP;
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
SELECT TO_CHAR(MIN(HIREDATE), 'RR"년"MM"월"DD"일 최초입사: "')||  TRIM(TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)),'999,999')) || '일째' FIRST FROM EMP;
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