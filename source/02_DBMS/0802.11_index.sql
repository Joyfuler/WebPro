-- [XI] �ε���: ���� ��ȸ�� ���� �����. (PK�� �������θ� ����� ���̶�� ũ�� ����� �ʿ�� ������, ���� �� �ٸ� ������ �˻��ϰ� ���� �� ����)
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP'; -- �ε����� ���� ���� ������ PK�� �ִ� ��� �ڵ����� ������.
-- �����ͺ��̽��� ���� ��û���� ���ٸ�, ã�� �� �ð��� �ɸ��Ƿ� B-TREE�� ����Ͽ� �˻� �ܰ踦 �����Ŵ.
-- ã�� ���� �ش� Ű�� �� ū��, �� �������� ���ϰ�, ���ǿ� �´� ���� ���� �������� ��.
SELECT * FROM EMP01;
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP�� ������ ������ EMP01����, ��, ��������X
DESC EMP01; -- ���������� ����
SELECT * FROM EMP01; -- �� 14��... 100���� �������� ��Ƣ�⸦ �Ϸ���?
INSERT INTO EMP01 SELECT * FROM EMP01; -- EMP01�� ���� �״�� �ٽ� �߰�. X2�� ������
SELECT TO_CHAR(COUNT(*), '999,999,999') COUNT FROM EMP01;
INSERT INTO EMP01 SELECT * FROM EMP01; --11�� �����غ���.

INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111,'ȫ',40);
-- �� �ε��� ���� �˻��� �� �ɸ��� �ð� ���� (91����)
SELECT * FROM EMP01 WHERE ENAME = 'ȫ';

-- �ε����� �����غ���! ������ �Ϲ������� 'IDX_���̺��_�ʵ��'���� ����.  ON ���̺�� (�ʵ��)
CREATE INDEX IDX_EMP01_ENAME ON EMP01 (ENAME);
SELECT * FROM EMP01 WHERE ENAME = 'ȫ'; -- �ε��� ���� �Ŀ��� ������ ���� �˻� �ӵ��� �ſ� ������. �׷��� INSERT, UPDATE���� �� ������ B-TREE�� �ٽ� �����ĵǴ� �����߻�
COMMIT;
INSERT INTO EMP01 SELECT * FROM EMP01; --�ε��� ���� �� 91������ �ִ´ٸ� ���� + BƮ�� �����ķ� ���� �ð��� �����ɸ��� ��.
-- ���� INSERT, UPDATE, DELETE�� ���̺� ���� ���ϴ� ���� ���� �Ͼ�ٸ� �ε����� �������� ����.
ROLLBACK; --�ѹ� ���� BƮ�� �����ķ� ���ؼ� ���� �ð��� �ɸ�.
DROP INDEX IDX_EMP01_ENAME; --�ε��� ����. BƮ�� �������� ���� �ʰ� ��.
INSERT INTO EMP01 SELECT * FROM EMP01;
DROP TABLE EMP01; -- ���̺� ���Ž� �����ִ� �ε����� �ڵ����ŵ�.
