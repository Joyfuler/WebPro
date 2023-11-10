-- Dept.xml에 들어갈 Query (id = deptList)
SELECT * FROM DEPT;
-- Emp.xml에 들어갈 Query (id = empList)
SELECT * FROM EMP;
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%';
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'M'||'%';
SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%' AND JOB LIKE '%'||'M'||'%' AND DEPTNO = 10;