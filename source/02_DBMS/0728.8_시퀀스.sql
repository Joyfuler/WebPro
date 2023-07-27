-- [VIII] - Sequence : 순차번호 생성기. 대부분 인위적인 PK 사용 용도
DROP SEQUENCE FRIEND_SEQ; -- 시퀀스의 이름은 테이블명_SEQ로 만드는 경우가 많음.
CREATE SEQUENCE FRIEND_SEQ
START WITH 1 -- 1부터 시작하는 시퀀스. 안 써도 1부터 시작 (디폴트)
INCREMENT BY 1 -- 1씩 증가. 감소 원하면 -1
MAXVALUE 9999 -- 꼭 설정.
MINVALUE 1 -- 보통 1이지만, INCREMENT가 마이너스일 경우의 최소값을 지정해 주는 것.
NOCACHE -- 컴퓨터가 자동으로 확보하는 값. 시퀀스가 중간에 빠질 수 있으므로, NOCACHE는 꼭 기입할 것.
NOCYCLE; -- 순환X. 9999 다음을 1로 만들지 않음. (중복방지). MAXVALUE, NOCACHE, NOCYCLE은 꼭 기입하자.

CREATE SEQUENCE FRIEND_SEQ
MAXVALUE 9999
MINVALUE 1
NOCACHE
NOCYCLE;