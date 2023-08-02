-- 주석은 오라클과 동일. DCL, DDL, DML 존재도 동일. 차이점은?
-- DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (FK 제약조건은 반드시 밑에, 시퀀스가 없음)
-- DML (OUTER JOIN, AND(&&), OR;(||)연결연산자 X, 일부 단일함수, 
-- SYSDATEX, ROWNUM X이므로 TOPN구문이 다름.
-- JAVA시간에 쓸 데이터 넣고 연습
show databases; -- DATABASE 리스트

-- MYSQL DCL
create user scott identified by 'tiger'; -- 계정 생성시 비밀번호에 따옴표넣는것이 다름.
grant all on *.* to scott; -- *.*는 모든 권한을 말함.
flush privileges; -- 완전권한부여
revoke all on *.* from scott; -- 권한박탈
drop user scott; -- cascade를 사용하지 않아도 가능.
-- 특정 데이터베이스로 들어감
show databases; -- db 리스트 봄.
use world; -- world라는 db영역으로 들어감.
select database();
show tables; -- 현재 db 테이블을 모두 출력
create database jangdb; -- 새로운 db 생성.
use jangdb;
select database();
show tables; -- 오라클의 select * from tab; 과 동일

-- ★ ★ ★ DDL 
create table emp (
empno numeric(4) primary key,
ename varchar(20) not null,
nickname varchar(2) unique,
sal numeric(7,2) check (sal>0),
comm numeric (7,2) default 0
);
desc emp;
drop table if exists emp; -- if exists는 생략해도 되나, 
-- 에러를 회피하려면 해당 테이블이 있을 때라는 조건을 넣어주면 됨. (에러 대신 경고)

create table emp (
empno numeric(4),
ename varchar(20) not null,
nickname varchar(20),
sal numeric(7,2),
comm numeric (7,2) default 0,
primary key (empno),
unique (nickname),
check (sal>0)
);

insert into emp values (1111,'홍길동','동에번쩍', 900, null);
insert into emp values (1112,'홍길동','동에번쩍', 900, null);
-- 에러. 닉네임이 unique이기 떄문
select * from emp;

1111	smith	manager	1001	1990-12-17	1000	\N	10
1112	ally	salesman	1116	1991-02-20	1600	500	30
1113	word	salesman	1116	1992-02-24	1450	300	30
1114	james	manager	1001	1990-04-12	3975	\N	20
1001	bill	president	\N	1989-01-10	7000	\N	10
1116	johnson	manager	1001	1991-05-01	3550	\N	30
1118	martin	analyst	1111	1991-09-09	3450	\N	10
1121	kim	clerk	1114	1990-12-08	4000	\N	20
1123	lee	salesman	1116	1991-09-23	1200	0	30
1226	park	analyst	1111	1990-01-03	2500	\N	10


insert into emp values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
