select * from dept;
commit; -- commit하지 않는 경우 실행해도 아무것도 하지 않고 기다림.

-- ex2. 부서번호 중복체크 insert (쿼리2개)
select * from dept where deptno = '사용자번호';  -- 이후 rs.next()해서 다음값이 있으면 중복.
select count(*) cnt from dept where deptno = 60; --> rs,next() 후 해당 값이 0이면 중복x, 값이 1이면 중복.
insert into dept values (60, 'it', 'seoul');
select * from dept;

-- ex3. update
UPDATE DEPT SET DNAME = 'CS', LOC = 'INCHEON' WHERE DEPTNO=70;
SELECT * FROM DEPT;
ROLLBACK;

-- 부서번호 유무 확인 후 UPDATE
SELECT * FROM DEPT WHERE DEPTNO = 60;
--> RS.NEXT가 있으면 해당부서 있음. 없으면 해당부서 없음.
commit;

-- ex4. delete
DELETE FROM DEPT WHERE DEPTNO = 90; -- 없는 번호 입력시 0행 삭제되므로 0 반환. 있는 번호 입력시 1행 삭제되므로 1 반환.
-- 따라서 0이 반환되면 삭제 안됐습니다를 출력해야함.


