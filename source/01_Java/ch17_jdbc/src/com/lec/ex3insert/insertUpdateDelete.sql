select * from dept;
commit; -- commit���� �ʴ� ��� �����ص� �ƹ��͵� ���� �ʰ� ��ٸ�.

-- ex2. �μ���ȣ �ߺ�üũ insert (����2��)
select * from dept where deptno = '����ڹ�ȣ';  -- ���� rs.next()�ؼ� �������� ������ �ߺ�.
select count(*) cnt from dept where deptno = 60; --> rs,next() �� �ش� ���� 0�̸� �ߺ�x, ���� 1�̸� �ߺ�.
insert into dept values (60, 'it', 'seoul');
select * from dept;

-- ex3. update
UPDATE DEPT SET DNAME = 'CS', LOC = 'INCHEON' WHERE DEPTNO=70;
SELECT * FROM DEPT;
ROLLBACK;

-- �μ���ȣ ���� Ȯ�� �� UPDATE
SELECT * FROM DEPT WHERE DEPTNO = 60;
--> RS.NEXT�� ������ �ش�μ� ����. ������ �ش�μ� ����.
commit;

-- ex4. delete
DELETE FROM DEPT WHERE DEPTNO = 90; -- ���� ��ȣ �Է½� 0�� �����ǹǷ� 0 ��ȯ. �ִ� ��ȣ �Է½� 1�� �����ǹǷ� 1 ��ȯ.
-- ���� 0�� ��ȯ�Ǹ� ���� �ȵƽ��ϴٸ� ����ؾ���.


