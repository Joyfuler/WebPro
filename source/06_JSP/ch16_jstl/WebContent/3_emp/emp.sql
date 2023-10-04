--EmpDao에 들어갈 query
-- 전체 리스트
SELECT * FROM EMP;
SELECT TO_CHAR(HIREDATE, 'YYMMDD HH:MI:SS') FROM EMP;
INSERT INTO EMP VALUES (9000, 'HONG', 'CLERK', 7902, SYSDATE, 9000, 1000, 40);
COMMIT;

-- 전체 리스트: public ArrayList<EmpDto> getListEmp()

-- 검색어 들어가는 쿼리 public ArrayList<EmpDto> getSearchEmp(String schName, String schJob) 매개변수2개
SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER(TRIM(' H '))||'%' AND JOB LIKE '%'||TRIM(UPPER( ' C ' ))||'%';