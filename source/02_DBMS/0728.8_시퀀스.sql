-- [VIII] - Sequence : ������ȣ ������. ��κ� �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ; -- �������� �̸��� ���̺��_SEQ�� ����� ��찡 ����.
CREATE SEQUENCE FRIEND_SEQ
START WITH 1 -- 1���� �����ϴ� ������. �� �ᵵ 1���� ���� (����Ʈ)
INCREMENT BY 1 -- 1�� ����. ���� ���ϸ� -1
MAXVALUE 9999 -- �� ����.
MINVALUE 1 -- ���� 1������, INCREMENT�� ���̳ʽ��� ����� �ּҰ��� ������ �ִ� ��.
NOCACHE -- ��ǻ�Ͱ� �ڵ����� Ȯ���ϴ� ��. �������� �߰��� ���� �� �����Ƿ�, NOCACHE�� �� ������ ��.
NOCYCLE; -- ��ȯX. 9999 ������ 1�� ������ ����. (�ߺ�����). MAXVALUE, NOCACHE, NOCYCLE�� �� ��������.

CREATE SEQUENCE FRIEND_SEQ
MAXVALUE 9999
MINVALUE 1
NOCACHE
NOCYCLE;

SELECT FRIEND_SEQ.NEXTVAL FROM DUAL;
SELECT FRIEND_SEQ.CURRVAL FROM DUAL; --�Խ��� ���鶧 �Ѵ� �ʿ�...
DROP SEQUENCE FRIEND_NO_SEQ;

CREATE SEQUENCE FRIEND_SEQ INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 99999 NOCACHE NOCYCLE;
 -- NO�� �� �������� ����.
 DROP TABLE FRIEND;
 CREATE TABLE FRIEND (
 NO NUMBER(5) PRIMARY KEY, -- �������� ���� ��. MAXVALUE�� 99999�̹Ƿ� NUMBER�� 5��.
 NAME VARCHAR2 (30) NOT NULL,
 TEL VARCHAR2 (20) UNIQUE, -- NULL�� ����ϳ�, NULL�� �ƴ� ���� ������ ���̾�� ��
 ADDRESS VARCHAR2 (255),
LAST_MODIFY DATE DEFAULT SYSDATE 
 );
 
 INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS) 
 VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', NULL, '���� ���빮');
 -- ���� NO�� ���� 1 ������ �Է��ϸ� 1ȸ ���� ������ �Ұ�. �׷��� NEXTVAL�� ����ϸ� ������ �� �ڵ����� ���� ��ȣ�� �Էµ�.
 SELECT * FROM FRIEND;
 INSERT INTO FRIEND (NO, NAME, TEL, ADDRESS)
 VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', '010-9999-9998', '���� ����');
 SELECT * FROM FRIEND;
  
 -- EX. �ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� TEST_SEQ �������� �����ϰ� �������� ����Ͻÿ�
DROP SEQUENCE TEST_SEQ;
CREATE SEQUENCE TEST_SEQ INCREMENT BY 1 START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL; -- �ѹ��� ����ϱ� ������ ���� ������ �� ����
SELECT TEST_SEQ.NEXTVAL FROM DUAL;

-- EX. ������ NO_SEQ �ʱⰪ 1���� 999���� 
-- SYSDATE�� ���� 'RRMMDD'�� �����ϰ� �ڿ� 001 ~ 999
DROP SEQUENCE NO_SEQ;
CREATE SEQUENCE NO_SEQ INCREMENT BY 1 START WITH 1 MAXVALUE 999 NOCACHE NOCYCLE;
SELECT CONCAT(TO_CHAR(SYSDATE,'RRMMDD'),TRIM(TO_CHAR(NO_SEQ.NEXTVAL,'000'))) NO FROM DUAL; 
-- ���� �߻�. TO_CHAR�� TO_CHAR�� ������ ���� TO_CHAR�� �����̽��� ����Ƿ�, TRIM�� ����ؼ� �����־�� ��.
-- TRIM�� ���� ���̿� �ִ� ���Ⱑ �ƴ� ���� �ٱ��� �ִ� ���⸦ ���ֹǷ� ��ü�� ���μ� �� ��.

