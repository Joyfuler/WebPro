-- [III] JOIN ; 테이블을 2개 이상 연결해 데이터를 검색하는 방법
-- SCOTT의 모든 데이터를 알고 싶다면?
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT;
-- CROSS JOIN (FROM 절에 테이블을 2개 이상 붙일 때)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT'; -- 두개를 합치는 과정에서 SCOTT의 값이 1개에서 4개로 불어남.
-- 의미있는 자료를 만들기 위해서는 필드의 값이 같은 것들을 통일해주어야함.
-- 1.★ ★ ★ EQUI JOIN (동등 조인) - 공통필드(DEPTNO)의 값이 일치되는 조건만 JOIN하고자 할 때
SELECT * FROM EMP, DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO AND ENAME = 'SCOTT';
-- 크로스 조건은 WHERE 뒤에 두고, WHERE 중에서는 가장 앞에 둘 것. ex) WHERE ~ ~ AND 다른조건
SELECT * FROM EMP, DEPT 
WHERE EMP.DEPTNO = DEPT.DEPTNO;
-- 그러나 DEPTNO와 DEPTNO_1로 불필요한 필드가 2개가 연속으로 나오고 있음.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO AS EMP부서명, DNAME, LOC 
FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;
-- 서로 다른 테이블에 같은 이름의 필드가 있는 경우, EMP.DEPTNO 등으로 어떤 테이블에 있는 필드인지를 정의해 주어야함.
-- 필드명 이외에, 필드명도 별칭을 줄 수 있음.
SELECT EMPNO NO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC
FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO; 
-- 테이블의 별칭이 있을 경우, 원 테이블 명을 사용할 수 없고 별칭을 사용해야 함. (필드와다름)
-- EX. 급여가 2000 이상인 직원만 이름, 직책, 급여, 부서명, 근무지, 부서번호 출력
SELECT ENAME, JOB, SAL, DNAME, LOC, E.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000;
-- EX. 20번 부서의 직원만 이름, 부서번호, 근무지 출력
SELECT ENAME, E.DEPTNO, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND D.DEPTNO = 20;
-- EX. 근무지 (LOC) 가 CHICAGO인 사람의 이름, 업무, 급여, 부서번호를 출력
SELECT ENAME, JOB, SAL, D.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC='CHICAGO';
-- EX. 부서번호가 10이거나 20인 사원의 이름, 업무, 근무지 (급여순) 출력
SELECT ENAME, JOB, LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN (10,20) ORDER BY SAL;
-- EX. JOB이 SALESMAN이거나 MANAGER인 사원의 이름, 급여, 상여, 연봉(SAL+COMM) * 12, 부서명, 근무지(연봉이 큰 순) 출력
SELECT ENAME, JOB, SAL, COMM, (SAL+NVL(COMM,0)) * 12 AS YEONBONG, DNAME, D.LOC
FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND JOB IN ('SALESMAN','MANAGER') ORDER BY YEONBONG DESC;
-- EX. COMM이 NULL이고 SAL이 1200이상인 사원의 이름, 급여, 입사일, 부서번호, 부서명 (부서명순, 급여 큰 순 정렬)
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND COMM IS NULL AND SAL >= 1200 ORDER BY DNAME, SAL DESC;
--? 탄탄 다지기
--­	뉴욕에서 근무하는 사원의 이름과 급여를 출력하시오
SELECT ENAME, SAL 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND D.LOC = 'NEW YORK';
--­	ACCOUNTING 부서 소속 사원의 이름과 입사일을 출력하시오
SELECT ENAME, HIREDATE 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND DNAME='ACCOUNTING';
--­	직급이 MANAGER인 사원의 이름, 부서명을 출력하시오
SELECT ENAME, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND JOB='MANAGER';
--­	Comm이 null이 아닌 사원의 이름, 급여, 부서코드, 근무지를 출력하시오.
SELECT ENAME, SAL, E.DEPTNO, LOC 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;

-- 2. NON EQUI JOIN : 같은 것을 물어보지 않음. 같은 것이 X일 때...
SELECT * FROM EMP WHERE ENAME = 'SCOTT' ; -- SALL이 3천.. 급여등급은 몇등급인지?
SELECT * FROM SALGRADE; -- SALGRADE를 확인한 결과 2001~3000 사이에 있는 4등급임.
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; -- CROSS JOIN (EMP의 1행 * SALGRADE의 5행이 곱해져 5줄이나 출력...)
SELECT * FROM EMP, SALGRADE WHERE SAL BETWEEN LOSAL AND HISAL AND ENAME = 'SCOTT';   -- 낮은순~높은순 주의
-- SAL이라는 값이 LOSAL과 HISAL 사이에 있을 때 출력.
-- EX. 모든 사원의 사번, 이름, 직책, 상사사번, 급여, 급여등급(1등급,2등급, ...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE||'급' AS GRADE 
FROM EMP, SALGRADE 
WHERE SAL BETWEEN LOSAL AND HISAL;
-- 혹은 SAL >= LOSAL AND SAL <=HISAL;
--	Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지를 출력하시오.
SELECT ENAME, SAL, GRADE, EMP.DEPTNO, DNAME, LOC 
FROM EMP, DEPT, SALGRADE 
WHERE EMP.DEPTNO=DEPT.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;


-- 3.

-- 4. 

--  PART2
--1. 모든 사원에 대한 이름, 부서번호, 부서명을 출력하는 SELECT 문장을 작성하여라.
SELECT ENAME, E.DEPTNO, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO;
--2. NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력
SELECT ENAME, JOB, SAL, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND LOC= 'NEW YORK';
--3. 보너스를 받는 사원에 대하여 이름,부서명,위치를 출력
SELECT ENAME, DNAME, LOC
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND COMM > 0;
-- 보너스를 받으므로, COMM은 0보다 커야함.
--4. 이름 중 L자가 있는 사원에 대하여 이름,업무,부서명,위치를 출력
SELECT ENAME, JOB, DNAME, LOC 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND ENAME LIKE ('%L%');
--5. 사번, 사원명, 부서코드, 부서명을 검색하라. 사원명기준으로 오름차순정열
SELECT EMPNO, ENAME, E.DEPTNO, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO ORDER BY ENAME;
--6. 사번, 사원명, 급여, 부서명을 검색하라. 
    --단 급여가 2000이상인 사원에 대하여 급여를 기준으로 내림차순으로 정열하시오
SELECT EMPNO, ENAME, SAL, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND SAL >=2000 ORDER BY SAL DESC;
--7. 사번, 사원명, 업무, 급여, 부서명을 검색하시오. 단 업무가 MANAGER이며 급여가 2500이상인
-- 사원에 대하여 사번을 기준으로 오름차순으로 정열하시오.
SELECT EMPNO, ENAME, JOB, SAL, DNAME 
FROM EMP E, DEPT D 
WHERE E.DEPTNO=D.DEPTNO AND ( JOB = 'MANAGER' AND SAL>=2500) ORDER BY EMPNO;
--8. 사번, 사원명, 업무, 급여, 등급을 검색하시오. 단, 급여기준 내림차순으로 정렬하시오
SELECT EMPNO, ENAME, JOB, SAL, S.GRADE
FROM EMP E, SALGRADE S WHERE SAL BETWEEN LOSAL AND HISAL ORDER BY SAL DESC;
--9. 사원테이블에서 사원명, 사원의 상사를 검색하시오(상사가 없는 직원까지 전체)
SELECT M.ENAME, W.ENAME  FROM EMP W, EMP M WHERE W.ENAME!=M.ENAME;
--10. 사원명, 상사명, 상사의 상사명을 검색하시오

--11. 위의 결과에서 상위 상사가 없는 모든 직원의 이름도 출력되도록 수정하시오
