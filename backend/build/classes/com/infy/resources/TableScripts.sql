DROP table fabfit;
DROP table requests;
drop table fabfit cascade constraints;
drop table addtrainerprofile cascade constraints;
drop sequence hibernate_sequence;
--drop table profile;
drop table BMI;
drop table fabtrainer;
drop table addtrainerprofile;
drop table Admin_Details cascade constraints;
drop table Admin_Details; 

create sequence hibernate_sequence start with 6660 increment by 1;

create table fabfit(
email varchar2(30) PRIMARY KEY,
name varchar2(30) not null,
gender varchar2(30),
password varchar2(50) not null,
height number, 	
weight number,
contact number,
trainerid varchar2(30),
suggestions varchar2(50)
);

create table BMI(
bmid number(4) PRIMARY KEY,
height number NOT NULL,
weight number NOT NULL,
dob DATE NOT NULL
);

create table addtrainerprofile(
temail varchar2(30) PRIMARY KEY,
name varchar2(30) not null,
gender varchar2(30) not null,
specialization varchar2(30) not null,
contact number NOT NULL,
password varchar2(30)
);

CREATE TABLE Admin_Details(
    adminId VARCHAR2(30) PRIMARY KEY,
    password VARCHAR2(30) NOT NULL
);

CREATE TABLE fabtrainer (
temail varchar2(30) REFERENCES addtrainerprofile(temail),
email varchar2(30) REFERENCES fabfit(email) UNIQUE
);

CREATE TABLE requests (
reqId number(10) primary key,
name varchar(30),
email varchar(30),
specialization varchar(30),
gender varchar(10),
contact varchar(15),
password varchar(20),
status varchar(20)
);

create table diet(
dietid number PRIMARY KEY,
calories number,
fruits varchar2(500),
vegetables varchar2(500),
grains varchar2(500) ,
protein varchar2(500) ,
dairy varchar2(500) ,
breakfast varchar2(500) ,
midMsnack varchar2(500) ,
lunch varchar2(500) ,
midEsnack varchar2(500) , 
dinner varchar2(500) ,
gender varchar(15) ,
goals varchar(20),
level1 varchar(20)
);

create table fitness(
fitnessid number primary key,
day1 varchar2(500),
day2 varchar2(500),
day3 varchar2(500),
day4 varchar2(500),
day5 varchar2(500),
day6 varchar2(500),
day7 varchar2(500),
gender varchar(15) ,
goals varchar(20),
level1 varchar(20)
);

drop table diet;

INSERT INTO diet values(111,null,null,null,null,null,null,null,null,null,null,null,'Male','Burn Fat','Beginner');
INSERT INTO diet values(112,null,null,null,null,null,null,null,null,null,null,null,'Male','Burn Fat','Intermediate');
INSERT INTO diet values(113,null,null,null,null,null,null,null,null,null,null,null,'Male','Burn Fat','Professional');
INSERT INTO diet values(121,null,null,null,null,null,null,null,null,null,null,null,'Male','Gain Muscle','Beginner');
INSERT INTO diet values(122,null,null,null,null,null,null,null,null,null,null,null,'Male','Gain Muscle','Intermediate');
INSERT INTO diet values(123,null,null,null,null,null,null,null,null,null,null,null,'Male','Gain Muscle','Professional');
INSERT INTO diet values(131,null,null,null,null,null,null,null,null,null,null,null,'Male','Regular Workout','Beginner');
INSERT INTO diet values(132,null,null,null,null,null,null,null,null,null,null,null,'Male','Regular Workout','Intermediate');
INSERT INTO diet values(133,null,null,null,null,null,null,null,null,null,null,null,'Male','Regular Workout','Professional');

INSERT INTO diet values(211,null,null,null,null,null,null,null,null,null,null,null,'Female','Burn Fat','Beginner');
INSERT INTO diet values(212,null,null,null,null,null,null,null,null,null,null,null,'Female','Burn Fat','Intermediate');
INSERT INTO diet values(213,null,null,null,null,null,null,null,null,null,null,null,'Female','Burn Fat','Professional');
INSERT INTO diet values(221,null,null,null,null,null,null,null,null,null,null,null,'Female','Gain Muscle','Beginner');
INSERT INTO diet values(222,null,null,null,null,null,null,null,null,null,null,null,'Female','Gain Muscle','Intermediate');
INSERT INTO diet values(223,null,null,null,null,null,null,null,null,null,null,null,'Female','Gain Muscle','Professional');
INSERT INTO diet values(231,null,null,null,null,null,null,null,null,null,null,null,'Female','Regular Workout','Beginner');
INSERT INTO diet values(232,null,null,null,null,null,null,null,null,null,null,null,'Female','Regular Workout','Intermediate');
INSERT INTO diet values(233,null,null,null,null,null,null,null,null,null,null,null,'Female','Regular Workout','Professional');


INSERT INTO fitness values(111,'A','A','A','A','A','A','A','Male','Burn Fat','Beginner');

INSERT INTO fitness values(111,null,null,null,null,null,null,null,'Male','Burn Fat','Beginner');
INSERT INTO fitness values(112,null,null,null,null,null,null,null,'Male','Burn Fat','Intermediate');
INSERT INTO fitness values(113,null,null,null,null,null,null,null,'Male','Burn Fat','Professional');
INSERT INTO fitness values(121,null,null,null,null,null,null,null,'Male','Gain Muscle','Beginner');
INSERT INTO fitness values(122,null,null,null,null,null,null,null,'Male','Gain Muscle','Intermediate');
INSERT INTO fitness values(123,null,null,null,null,null,null,null,'Male','Gain Muscle','Professional');
INSERT INTO fitness values(131,null,null,null,null,null,null,null,'Male','Regular Workout','Beginner');
INSERT INTO fitness values(132,null,null,null,null,null,null,null,'Male','Regular Workout','Intermediate');
INSERT INTO fitness values(133,null,null,null,null,null,null,null,'Male','Regular Workout','Professional');

INSERT INTO fitness values(211,null,null,null,null,null,null,null,'Female','Burn Fat','Beginner');
INSERT INTO fitness values(212,null,null,null,null,null,null,null,'Female','Burn Fat','Intermediate');
INSERT INTO fitness values(213,null,null,null,null,null,null,null,'Female','Burn Fat','Professional');
INSERT INTO fitness values(221,null,null,null,null,null,null,null,'Female','Gain Muscle','Beginner');
INSERT INTO fitness values(222,null,null,null,null,null,null,null,'Female','Gain Muscle','Intermediate');
INSERT INTO fitness values(223,null,null,null,null,null,null,null,'Female','Gain Muscle','Professional');
INSERT INTO fitness values(231,null,null,null,null,null,null,null,'Female','Regular Workout','Beginner');
INSERT INTO fitness values(232,null,null,null,null,null,null,null,'Female','Regular Workout','Intermediate');
INSERT INTO fitness values(233,null,null,null,null,null,null,null,'Female','Regular Workout','Professional');

INSERT INTO addtrainerprofile VALUES('abhishe2k@gmail.com','Abhishek','Male','Abcbsdhd',97,'abhis');
INSERT INTO addtrainerprofile VALUES('abhishe3k@gmail.com','AbhishekRaj','Male','Abcbsdhd',9790757238,'abhis');

insert into Admin_Details values ('admin', 'admin');

INSERT INTO BMI values(102,56,25,'17/july/2015');
INSERT INTO fabfit VALUES('abhishe1k@gmail.com','Abhishek','Male','abhis1234',null,null,null,null,'hii');
INSERT INTO fabfit VALUES('abhi@gmail.com','Abhishek','Male','abhis1234',null,null,null,'abhishe1k@gmail.com',null);
INSERT INTO fabfit VALUES('kiran@gmail.com','Abhishek','Male','abhis1234',null,null,null,null,null);

drop table Admin_Details;
select * from fabfit;
select * from diet;
select * from fitness;
select * from BMI;
select * from Admin_Details;
select * from addtrainerprofile;
select * from fabtrainer;
select * from requests;
delete from requests where reqId=1;

