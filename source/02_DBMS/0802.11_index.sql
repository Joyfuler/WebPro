-- [XI] 인덱스: 빠른 조회를 위해 사용함. (PK및 시퀀스로만 사용할 것이라면 크게 사용할 필요는 없지만, 성함 등 다른 것으로 검색하고 싶을 때 유용)
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP'; -- 인덱스는 만든 적이 없더라도 PK가 있는 경우 자동으로 생성됨.
-- 데이터베이스의 양이 엄청나게 많다면, 찾는 데 시간이 걸리므로 B-TREE를 사용하여 검색 단계를 단축시킴.
-- 찾는 값과 해당 키가 더 큰지, 더 작은지를 비교하고, 조건에 맞는 다음 노드로 내려가는 식.
SELECT * FROM EMP01;
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP와 동일한 내용의 EMP01생성, 단, 제약조건X
DESC EMP01; -- 제약조건이 없음
SELECT * FROM EMP01; -- 총 14행... 100만개 단위까지 뻥튀기를 하려면?
INSERT INTO EMP01 SELECT * FROM EMP01; -- EMP01의 값을 그대로 다시 추가. X2씩 증가함
SELECT TO_CHAR(COUNT(*), '999,999,999') COUNT FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; --11번 실행해보자.

INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111,'홍',40);
-- ★ 인덱스 없이 검색할 때 걸리는 시간 측정 (91만개)
SELECT * FROM EMP01 WHERE ENAME = '홍';

-- 인덱스를 생성해보자! 형식은 일반적으로 'IDX_테이블명_필드명'으로 만듬.  ON 테이블명 (필드명)
CREATE INDEX IDX_EMP01_ENAME ON EMP01 (ENAME);
SELECT * FROM EMP01 WHERE ENAME = '홍'; -- 인덱스 생성 후에는 다음과 같이 검색 속도가 매우 빨라짐. 그러나 INSERT, UPDATE등을 할 때마다 B-TREE가 다시 재정렬되는 문제발생
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01; --인덱스 생성 후 91만개를 넣는다면 생성 + B트리 재정렬로 더욱 시간이 오래걸리게 됨.
-- 따라서 INSERT, UPDATE, DELETE등 테이블 값이 변하는 일이 자주 일어난다면 인덱스를 생성하지 말자.
ROLLBACK; --롤백 역시 B트리 재정렬로 인해서 많은 시간이 걸림.
DROP INDEX IDX_EMP01_ENAME; --인덱스 삭제. B트리 재조정도 하지 않게 됨.
INSERT INTO EMP01 SELECT * FROM EMP01;
DROP TABLE EMP01; -- 테이블 제거시 딸려있는 인덱스도 자동제거됨.
