SELECT * FROM TAB; -- ���� ���̺� Ȯ��.. ���� ���� ���� �����Ƿ� �ƹ��͵� ����������
SELECT * FROM USER_TABLES; -- ���� ������ ������ ���̺�
SELECT * FROM ALL_TABLES; -- ��ų� ��...?
SELECT * FROM ALL_TABLES
WHERE TABLE_NAME = 'EMP'; -- �� ������ ��� ������ ���̺�
SELECT * FROM SCOTT.EMP; -- SCOTT�� EMP ������ �־����Ƿ� �̷��� ��������.
SELECT * FROM SCOTT.DEPT; -- DEPT�� ������ ���� �ʾ����Ƿ� �����Ұ�.
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D
WHERE E.DEPTNO = D.DEPTNO;
-- ���� ��Ż ��
SELECT * FROM SCOTT.DEPT;