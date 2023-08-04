-- Ex1. 사용자로부터 부서번호 받아 부서정보 출력
SELECT * FROM DEPT WHERE DEPTNO = 40;

-- Ex2. 사용자로부터 부서번호 받아서 부서정보 + 사원정보 출력
SELECT * FROM DEPT WHERE DEPTNO = 40;
SELECT W.EMPNO, W.ENAME, W.SAL, NVL(M.ENAME, ' ') MANAGER
FROM EMP W, EMP M
WHERE W.MGR = M.EMPNO(+) AND W.DEPTNO = 20;

-- Ex3. 사용자로부터 부서명을 받아 부서정보 출력
SELECT * FROM DEPT WHERE DNAME = UPPER('ACCOUNTING');
