-- LYH - sequence

drop sequence ymv_seq;
create sequence ymv_seq;


-- LYH - member

drop table member

create table member(
   member_no number primary key,
   id varchar2(50) unique,
   password varchar2(50) not null,
   name varchar2(50) not null,
   address varchar2(50) not null,
   identity_no varchar2(50) not null,
   mail_address varchar2(50) not null,
   member_type varchar2(10) not null,
   file_path varchar(200)
)
alter table member modify mail_address varchar2(200) 

select * from member


-- LYH - board

drop table board

create table board(
   board_no number primary key,
   board_type varchar2(50) not null,
   title varchar2(100) not null,
   writer varchar2(50) not null,
   content clob not null,
   member_no number not null
   constraint fk_member_no_1 references member(member_no),
   time_posted date not null,
   hit number default 0
)

select * from board


-- LYH - statistics

drop table statistics

create table statistics(
   age number,
   field varchar(50),
   applicate_count number not null,
   primary key(age,field)
)

select * from statistics


-- LYH - recruit

drop table recruit cascade constraints;

create table recruit(
   recruit_no number primary key,
   title varchar2(100) not null,
   field varchar2(100) not null,
   location varchar2(100) not null,
   age varchar2(100) not null,
   start_date date not null,
   end_date date not null,
   content clob not null,
   member_no number constraint fk_member_no_2 references member(member_no),
   time_posted date not null,
   hit number default 0
)

alter table recruit modify start_time varchar2(10)
alter table recruit modify end_time varchar2(10)
select * from recruit


-- LYH - scheduler

drop table scheduler

create table scheduler(
member_no number primary key constraint fk_member_no_3 references member(member_no),
field varchar(50),
location varchar(50),
start_date varchar(50),
end_date varchar(50)
)

select * from scheduler


-- LYH - voluntary_service_applicate

drop table voluntary_service_applicate

create table voluntary_service_applicate(
   recruit_no number not null,
   member_no number not null, 
   constraint fk_recruit_no_1 foreign key(recruit_no) references recruit,
   constraint fk_member_no_4 foreign key(member_no) references member,
   motivate varchar(3000),
   constraint pk_voluntary_service_applicate primary key(recruit_no,member_no)
)

select * from voluntary_service_applicate


-- LYH - QnA_board

drop table QnA_board

create table QnA_board(
   qna_no number primary key,
   title varchar2(100) not null,
   writer varchar2(50) not null,
   content clob not null,
   ref varchar2(50) not null,
   restep varchar2(50) not null,
   relevel varchar2(50) not null,
   member_no number not null
   constraint fk_member_no_5 references member(member_no),
   time_posted date not null,
   hit number default 0
)

select * from QnA_board


-- LYH - comment

drop table ymv_comment

create table ymv_comment(
   comment_no number primary key,
   writer varchar2(50) not null,
   content varchar2(1000) not null,
   time_posted date not null,
   board_no number not null
   constraint fk_board_no_1 references board(board_no)
)

select * from ymv_comment


-- LYH - picture

drop table picture

create table picture(
   picture_no number primary key,
   file_path varchar(200) not null
)

select * from picture


-- LYH -  voluntary_applicant_ok

drop table voluntary_applicant_ok

create table voluntary_applicant_ok(
   recruit_no number not null,
   member_no number not null,
   constraint fk_recruit_no_2 foreign key(recruit_no) references recruit,
   constraint fk_member_no_6 foreign key(member_no) references member,
   primary key(recruit_no,member_no)
)

select * from voluntary_applicant_ok


-- LYH - confirm_board

drop table confirm_board

create table confirm_board(
   board_no number primary key,
   title varchar2(100) not null,
   field varchar2(100) not null,
   location varchar2(100) not null,
   age varchar2(100) not null,
   start_date date not null,
   end_date date not null,
   content clob not null,
   member_no number constraint fk_member_no_7 references member(member_no),
   time_posted date not null,
   hit number default 0
)

select * from confirm_board


-- LYH - confirm

drop table confirm

create table confirm(
   board_no number not null,
   member_no number not null,
   constraint fk_board_no_2 foreign key(board_no) references confirm_board,
   constraint fk_member_no_8 foreign key(member_no) references member,
   primary key(board_no,member_no)
)

select * from confirm


-- LYH - field

drop table field

create table field(
   field varchar2(100) not null
)

select * from field


-- LYH - location

drop table location

create table location(
   location varchar2(100) not null
)

select * from location


-- LYH - sponsor

drop table sponsor

create table sponsor(
   board_no number primary key,
   title varchar2(100) not null,
   content clob not null,
   target_price number not null,
   current_price number default 0,
   start_date date not null,
   end_date date not null
)

select * from sponsor


-- LYH - select 

select * from member
select * from board
select * from statistics
select * from recruit
select * from scheduler
select * from voluntary_service_applicate
select * from QnA_board
select * from ymv_comment
select * from picture
select * from voluntary_applicant_ok
select * from confirm_board
select * from confirm
select * from field
select * from location
select * from sponsor

-- LYH - delete 

delete from member
delete from board
delete from statistics
delete from recruit
delete from scheduler
delete from voluntary_service_applicate
delete from QnA_board
delete from ymv_comment
delete from picture
delete from voluntary_applicant_ok
delete from confirm_board
delete from confirm
delete from field
delete from location
delete from sponsor

-- LYH - insert

-- 시퀀스 ymv_seq.nextval

-- LYH - insert member

insert into member values(ymv_seq.nextval,'ymv','1234','관리자','판교','0000','qhackp@gmail.com','admin');
insert into member values(ymv_seq.nextval,'java','1234','임영학','판교','890716','qhackp@gmail.com','normal');
insert into member values(ymv_seq.nextval,'java1','1234','백지영','판교','960102','ningoop71@gmail.com','normal');
insert into member values(ymv_seq.nextval,'javac','1234','장지윤','수원','931004','quartzjiyun@gmail.com','company');
insert into member values(ymv_seq.nextval,'kosta','1234','박병준','서울','900227','qudwns741@gmail.com','company');
insert into member values(ymv_seq.nextval,'javaa','1234','정혜선','판교','910920','jhsjhs920@gmail.com','normal');

-- LYH - insert board

insert into BOARD(board_no,board_type,title,writer,content,member_no,time_posted) 
	values(ymv_seq.nextval,'notice','테스트','임영학','가나다라','1',sysdate,0);
insert into BOARD(board_no,board_type,title,writer,content,member_no,time_posted) 
	values(ymv_seq.nextval,'notice','테스트','임영학','가나다라','1',sysdate,0);
insert into BOARD(board_no,board_type,title,writer,content,member_no,time_posted) 
	values(ymv_seq.nextval,'notice','테스트','임영학','가나다라','1',sysdate,0);
insert into BOARD(board_no,board_type,title,writer,content,member_no,time_posted) 
	values(ymv_seq.nextval,'notice','테스트','임영학','가나다라','1',sysdate,0);

	
-- LYH - insert statistics 

insert into statistics(age, field, applicate_count) values(20,'환경보호',1);
insert into statistics(age, field, applicate_count) values(20,'교육',1);
insert into statistics(age, field, applicate_count) values(20,'보건/의료',1);
insert into statistics(age, field, applicate_count) values(20,'행정지원',1);


-- LYH - insert recruit

insert into recruit(recruit_no,title,field,location,age,start_date,end_date,content,member_no,time_posted,hit) 
	values(ymv_seq.nextval,'제목','환경보호','서울특별시','전체',to_date('2015-06-29 08:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-29 15:00','YYYY-MM-DD HH24:MI'),#{content},#{memberNo}, sysdate ,0);
insert into recruit(recruit_no,title,field,location,age,start_date,end_date,content,member_no,time_posted,hit) 
	values(ymv_seq.nextval,'제목2','생활편의지원','서울특별시','성인',to_date('2015-06-29 08:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-29 15:00','YYYY-MM-DD HH24:MI'),#{content},#{memberNo}, sysdate ,0);
insert into recruit(recruit_no,title,field,location,age,start_date,end_date,content,member_no,time_posted,hit) 
	values(ymv_seq.nextval,'제목3','생활편의지원','서울특별시','전체',to_date('2015-06-29 08:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-29 15:00','YYYY-MM-DD HH24:MI'),#{content},#{memberNo}, sysdate ,0);
insert into recruit(recruit_no,title,field,location,age,start_date,end_date,content,member_no,time_posted,hit) 
	values(ymv_seq.nextval,'제목4','재난/재해/응급','서울특별시','학생',to_date('2015-06-29 08:00','YYYY-MM-DD HH24:MI'),to_date('2015-06-29 15:00','YYYY-MM-DD HH24:MI'),#{content},#{memberNo}, sysdate ,0);

	
-- LYH - insert scheduler

	-- 웹에서 스케줄러 등록

-- LYH - insert voluntary_service_applicate
	
	-- 웹에서 봉사활동 신청
	
-- LYH - insert QnA_board

	-- 웹에서 큐앤에이 글 등록

-- LYH - insert ymv_comment

	-- 웹에서 후기게시판에 댓글등록

-- LYH - insert picture

	-- 웹에서 사진등록 프로필, 공지사항, 후기게시판, 후원게시판

-- LYH - insert voluntary_applicate_ok

	-- 웹에서 선정자등록

-- LYH - insert confirm_board

	-- 웹에서 선정자 중에 확인증 게시글 등록

-- LYH - insert confirm

	-- 웹에서 선정자 중에서 확인증 발급인원 등록

-- LYH - insert field

insert into field values('생활편의지원');
insert into field values('주거환경');
insert into field values('안전/방범');
insert into field values('교육');
insert into field values('보건/의료');
insert into field values('국제협력/해외봉사');
insert into field values('문화/행사');
insert into field values('환경보호');
insert into field values('행정지원');
insert into field values('상담');
insert into field values('인권/공익');
insert into field values('재난/재해/응급');
insert into field values('농어촌봉사');

-- LYH - insert location

insert into location values('서울특별시');
insert into location values('부산광역시');
insert into location values('강원도');
insert into location values('경기도');
insert into location values('충청도');
insert into location values('경상도');
insert into location values('전라도');
insert into location values('제주도');

-- LYH - insert sponsor

-- 웹에서 후원글 등록

drop table Auction_board
delete table Auction_board
create table Auction_board(
   board_no number primary key,
   title varchar2(100) not null,   
   content clob not null,
   article varchar2(100) not null,
   time_posted date not null,
   first_price number not null,
   current_price number default 0,
   end_date varchar(50),
   hit number default 0
)

select * from Auction_board

-- 테이블에 컬럼 추가
ALTER TABLE table_name ADD column_name datatype 
-- 테이블에 컬럼 수정
ALTER TABLE table_name MODIFY column_name datatype
-- 테이블의 컬럼 삭제
ALTER TABLE Persons DROP COLUMN DateOfBirth

commit 테스트