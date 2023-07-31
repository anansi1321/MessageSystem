-- EX02. 테이블 생성하기
create table msg_member
(
    email varchar2(50),
    pw varchar2(50) not null,
    tel varchar2(50) not null,
    address varchar2(100) not null,
    constraint msg_email_pk primary key(email)
);

-- Ex08. Board 테이블 생성하기
create sequence msg_board_seq
    increment by 1
    start with 1
    maxvalue 999999
    nocycle
    nocache;
    
create table MSG_BOARD
(
    idx number,
    title varchar2(50) not null,
    writer varchar2(50) not null,
    content varchar2(1000) not null,
    img varchar2(100),
    indate date default sysdate,
    count number default 0,
    
    constraint board_idx_pk primary key(idx),
    constraint board_writer_fk foreign key(writer) 
    references MSG_MEMBER(email)
);