# bookManagement
sql 쿼리문

create table VIDEO(
no number not null,
name varchar2(24) not null,
type varchar2(24) not null,
constraint video_pk primary key(no)
);
create sequence video_seq
start with 1
increment by 1;

create table member(
no number not null,
id varchar2(20) not null,
passwd varchar2(20) not null,
name varchar2(30) not null,
phone varchar2(30) not null,
constraint member_id_pk primary key(id),
constraint member_no_uk unique(no)
);
create sequence member_seq
start with 1
increment by 1;

create table rental(
no number not null,
id varchar2(20) not null,
video_no number not null,
rent_date date,
return_date date,
constraint rental_pk primary key(no),
constraint rental_id_fk foreign key(id) references member(id),
constraint rental_videono_fk foreign key(video_no) references VIDEO(no)
);
create sequence rental_seq
start with 1
increment by 1;
INSERT INTO video VALUES (video_seq.nextval, '스파이더맨', 'sf/액션');
INSERT INTO video VALUES (video_seq.nextval, '나홀로집에', '코미디');
INSERT INTO video VALUES (video_seq.nextval, '매트릭스', 'sf/액션');
INSERT INTO video VALUES (video_seq.nextval, '쥬라기공원', 'sf/어드벤처');
select * from video;
select * from rental;
commit;
