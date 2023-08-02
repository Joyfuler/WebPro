-- [XII] Ʈ������ ��ɾ� : COMMIT(Ʈ������ �ݿ�), ROLLBACK(Ʈ������ ���), SAVEPOINT (Ʈ������ ����)
SELECT * FROM DEPT01;
DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS SELECT * FROM DEPT;
DELETE FROM DEPT01 WHERE DEPTNO=20;
DELETE FROM DEPT01 WHERE DEPTNO=30;
ROLLBACK;

---- ���ο� Ʈ�������� ����.
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT;
---- ���ο� Ʈ������ ����.
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO = 30;
SAVEPOINT C1; -- DEPTNO30�� �����ϰ� 10,20�� ���� ���輱
DELETE FROM DEPT01 WHERE DEPTNO = 20;
SAVEPOINT C2; -- DEPTNO�� 10�� ���� ���輱
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK TO C2;
ROLLBACK TO C1;
-- SAVEPOINT�� ROLLBACK�ϸ� �� �Ʒ��� �ִ� ��ɾ ��� ������.
-- ���� C1�������� ROLLBACK�ϴ� ��� �� �Ʒ��� �ִ� C2������ ��ɾ���� ��� �����Ǹ� ROLLBACK TO C2�� �Ұ�������.
-- �Ʒ����� �������� �ѹ��� ������ �ݴ�� �ȵȴܴ�
-- ���� �����͸� ������ �� ������ �Ϸ��� �� COMMIT�� �϶�� ��!
