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