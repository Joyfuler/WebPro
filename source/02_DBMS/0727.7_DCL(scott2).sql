SELECT * FROM TAB; -- 가진 테이블 확인.. 아직 만든 것이 없으므로 아무것도 나오지않음
SELECT * FROM USER_TABLES; -- 현재 계정이 소유한 테이블
SELECT * FROM ALL_TABLES; -- 딕셔널 뷰...?
SELECT * FROM ALL_TABLES
WHERE TABLE_NAME = 'EMP'; -- 현 계정이 사용 가능한 테이블
SELECT * FROM SCOTT.EMP; -- SCOTT이 EMP 권한을 주었으므로 이렇게 열람가능.
SELECT * FROM SCOTT.DEPT; -- DEPT는 권한을 받지 않았으므로 열람불가.
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D
WHERE E.DEPTNO = D.DEPTNO;
-- 권한 박탈 후
SELECT * FROM SCOTT.DEPT;