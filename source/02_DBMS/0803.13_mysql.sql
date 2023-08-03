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
drop table emp;
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
use world;
use jangdb;
select database();
insert into emp values (1111,'홍길동','동에번쩍', 900, null);
insert into emp values (1112,'홍길동','동에번쩍', 900, null);
-- 에러. 닉네임이 unique이기 떄문
select * from emp;

-- major 테이블 : mcode-primarykey 학과번호(순차번호)
-- mname 학과이름 varchar moffice 학과사무실 varchar
-- student 테이블 : sno-pk학번,  sname 이름 score 성적 mcode-foreignkey 학번

drop table major;
create table major (
mcode int auto_increment primary key, -- auto_increment 필드인 경우 int타입
mname varchar(30) unique,
moffice varchar(30) not null
);

insert into major (mname, moffice) values ('컴퓨터공학과','202호');
insert into major (mname, moffice) values ('빅데이터', '203호');
insert into major (mname, moffice) values ('중국어', '402호');
select * from major;

drop table student;
create table student (
sno numeric(4) primary key,
sname varchar(30),
score numeric(3) check (score >=0 and score <=100),
mcode int,
foreign key (mcode) references major (mcode)
);

insert into student values (1000, '홍길동', 100, 1);
insert into student values (1001,'신길동',90,3);
insert into student values (1002,'김길동',80,2);
select * from student;

-- 학번, 이름, 학과번호, 학과명, 학과 사무실 (equi조인은 오라클과 완전동일)
select sno, sname, student.mcode, mname, moffice
from student right outer join major
on student.mcode =major.mcode;

select ifnull(sno,'-') sno, ifnull (sname, '읎당') sname , ifnull(score,'-') score ,
m.mcode,mname,moffice
from major m left outer join student
on m.mcode=student.mcode;

drop table if exists personal;
drop table if exists division;

-- ★★★★★ 자바 (JAVA DATABASE CONNECT) 수업에 쓸 테이블 데이터

-- 1111	smith	manager	1001	1990-12-17	1000	\N	10
-- 1112	ally	salesman	1116	1991-02-20	1600	500	30
-- 1113	word	salesman	1116	1992-02-24	1450	300	30
-- 1114	james	manager	1001	1990-04-12	3975	\N	20
-- 1001	bill	president	\N	1989-01-10	7000	\N	10
-- 1116	johnson	manager	1001	1991-05-01	3550	\N	30
-- 1118	martin	analyst	1111	1991-09-09	3450	\N	10
-- 1121	kim	clerk	1114	1990-12-08	4000	\N	20
-- 1123	lee	salesman	1116	1991-09-23	1200	0	30
-- 1226	park	analyst	1111	1990-01-03	2500	\N	10

create table division (
dno int,
dname varchar(20) not null,
phone varchar(20) unique,
position varchar(20), 
primary key (dno)
);

create table personal(
pno int,
pname varchar(20) not null,
job varchar(20) not null,
manager int,
startdate date,
pay int,
bonus int,
dno int,
foreign key(dno) references division (dno)
);
select * from division;
select * from personal;

insert into division values (10,'finance','02-393-4321','서대문');
insert into division values (20,'research','02-555-5555','강남');
insert into division values (30, 'sales', '02-717-5555','마포');
insert into division values (40, 'cs', '031-444-4444-','안양');

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);

select * from division;
select * from personal;
select count(*) cnt from personal;

-- ★★★ dml ★★★ (outer join, and &&, or ||, 단일행함수)
use jangdb;
select database();

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay 
from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal 
where pay >= 2000 and pay <=5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno 
from personal
where dno in (10,20);
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
from personal
where bonus is null order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
from personal
order by dno, pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname
from personal, division
where personal.dno=division.dno;

-- 7. 사번, 이름, 상사이름
select a.pno, a.pname, b.pname
from personal a, personal b
where a.manager = b.pno;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력하되 상사가 없는 경우 ★CEO★로 출력) – 우선
desc personal;
desc division;
select w.pno, w.pname, ifnull(m.pname,'★CEO★') manager
from personal w left outer join personal m
on w.manager=m.pno;

-- 9. 이름이 s로 시작하는 사원 이름 (like 이용, substr함수이용, instr함수 이용등 다양하게 사용 가능)
select * from personal where lower(pname) like ('s%');
select * from personal where substr(pname,1,1) = 's';
select * from personal where instr(pname, 's') = 1;

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select a.pno, a.pname, a.pay, dname, b.pname
from personal a, personal b, division
where a.dno=division.dno and a.manager=b.pno;
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
from personal group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, round(avg(pay),1) geupyeopyeonggyun, count(*) inwonsoo
from personal, division
where personal.dno=division.dno group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*) inwonsoo
from personal group by dno having count(*)>=4 ;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select dno, pname, pay 
from personal
where pay >= (select max(pay) from personal); 
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, pno
from personal
where pay > (select avg(pay) from personal);
-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
from personal, division
where personal.dno=division.dno and
pay > (select avg(pay) from personal) order by dname, pay desc;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균 (where절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, dno, round(avgpay) haedangbuseopyeonggyun
from personal a, (select avg(pay) avgpay from personal group by dno) b
where pay > avgpay group by dno;

select pname, pay, pno, (select avg(pay) from personal where dno=a.dno)
from personal a
where pay > (select avg(pay) from personal where dno=a.dno);

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, personal.dno
 from personal, division
 where personal.dno=division.dno
 and startdate <= all (select startdate from personal);
-- 19. 이름, 급여, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, (select avg(pay) from personal where dno=a.dno group by dno) buseopyeonggyun
from personal a;
-- 인라인뷰를 사용시 from절에는 되도록이면 alias를 사용할 것. 그래야 where에서 dno=a.dno를 통해 불러들이는 번호를 바꿀 수 있기 때문

select pname, pay, avgpay buseopyeonggyun
from personal a, (select dno, avg(pay) avgpay from personal group by dno) b
where a.dno=b.dno;

-- 20. 이름, 급여, 부서명, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)
select pname, pay, (select avg(pay) from personal where dno=p.dno group by dno)
buseopyeonggyun, dname
from personal p, division
where p.dno=division.dno;

select pname, pay, avgpay haedangbuseopyeonggyun, dname
from personal a, 
(select dno, avg(pay) avgpay from personal group by dno) b,
division d
where a.dno=b.dno and a.dno=d.dno;

-- ★ mysql의 단일행함수 (oracle과 다른 부분)
select sysdate(); -- oracle의 경우 select sysdate from dual;을 쓰나, dual이 없고 함수처럼 사용함.
select curdate(); -- currentdate (현재의 날짜)
select * from personal;
-- 날짜 + 시간까지 출력하고 싶다면, date타입 대신 datetime 타입을 사용해야 함.
insert into personal values (1000,'홍길동','manager',1001,curdate(),null,null,40);
set sql_safe_updates=0;

-- ex. '이름은 job이다'
select concat(concat(pname,'은 '),concat(job,'이다')) from personal; -- ㄴㄴ
select concat(pname, '은 ', job, '이다.') sogae from personal; -- 연결 연산자를 쓰지 않아도 가능.

select round(35.5678,2); -- from dual을 사용하지 않아도 가능함.

-- 시스템으로부터 현재 시점(datetime), 현재 날짜(date), 현재시간(time)
select sysdate(), now(); -- 현재 시점을 표시 (날짜 + 시간)
select curdate(); select current_date(); -- 두개 기능 동일. 현재 날짜
select curtime(); select current_time(); -- 두개 기능 동일. 현재 시간
-- 날짜를 입맛에 맞는 형식으로 변경하고 싶다면? oracle에서는 to_char(date, '~~') 등으로 활용했음.
-- extract 대신 year(시간) 으로 년도만 뽑기가 가능.
select year(sysdate()) "year", month(now()) "month", day (now()) "day";
select hour (now()), minute (now()) minute, second(now()) second;
select monthname(now()); -- january, february...
select dayname(startdate) from personal;
select case weekday(now()) -- 월요일 0 화요일 1 수요일 2 목요일 3 금요일 4 토요일 5 일요일 6
when '0' then '월요일'
when '1' then '화요일'
when '2' then '수요일'
when '3' then '목요일'
when '4' then '금요일'
when '5' then '토요일' 
when '6' then '일요일' end dayofweek;
-- 미친듯한불편함... to_char같은 것은 없는지
-- to_char(날짜,포맷) or to_date(문자,포맷) 
select date_format(sysdate(), '%Y년%m월%d일');
select date_format('2023-07-31', '%y%m%d');
-- 포맷: %Y (년도 4자리) %y(년도 2자리)
-- %m (01~12) %c (1,2,3....) %M(january, february...)
-- %d (01,02...) %e (1,2,3,4....)
-- %H (24시간), %h (12시간), %i (분) %s (초)
select date_format(sysdate(), '%y년 %c월 %d일 %h시 %i분 %s초');
select date_format(now(), '%Y년 %c월 %e일 %p %h시 %i분') now;

-- oracle에서 첫자리마다 , 찍으려면 to_char(숫자,'99,999') 등 이용했었는데, mysql은?
-- format (숫자데이터, 소숫점 자리수) : 소수점자리수까지 소수점이 출력되고, 세자리마다 쉼표가 찍힘.
select pname, format(pay,0) from personal;

-- 이름, 급여, 급여가 3000 이상인지 여부
select pname, pay, if (pay>=3000, '3000이상','3000이하') from personal;
-- ★ ★ ★ ★ ★ Top-N 구문 ★ ★ ★ ★ ★
-- limit n (1등~n등)
-- limit n1, n2 (n1등 ~ n2등, 단 첫번째는 0번째)
select pname, pay from personal
order by pay desc;

select pname, pay from personal
order by pay desc limit 4,5; -- 5번째부터 5개

select pname, pay from personal
order by pay desc limit 3;

select pname, pay from personal
order by pay desc limit 3,3; -- 4~6

select pname, pay from personal
order by pay desc limit 6,3; -- 7~9
