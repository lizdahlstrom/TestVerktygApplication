insert into tests (TESTTITLE,uId)values ('Nätverksteknik',2);
insert into tests (TESTTITLE,uId)values ('Java EE',2);
insert into tests (TESTTITLE,uId)values ('JPA',2);
insert into questions (QUESTION,testId)values ('Vad heter Sveriges huvustad?',1);
insert into questions (QUESTION,testId)values ('Vad heter Norrlands största stad?',1);
insert into questions (QUESTION,testId)values ('Vad heter Skånes minsta stad?',1);
insert into questions (QUESTION,testId)values ('Vad heter Sveriges största sjö?',1);
insert into choices (CHOICE,ISTRUE,questionId) values ('Stockholm',1,1);
insert into choices (CHOICE,ISTRUE,questionId) values ('Göteborg',0,1);
insert into choices (CHOICE,ISTRUE,questionId) values ('Malmö',0,1);
insert into choices (CHOICE,ISTRUE,questionId) values ('Umeå',1,2);
insert into choices (CHOICE,ISTRUE,questionId) values ('Luleå',0,2);
insert into choices (CHOICE,ISTRUE,questionId) values ('Norrköping',0,2);
insert into choices (CHOICE,ISTRUE,questionId) values ('Malmö',0,3);
insert into choices (CHOICE,ISTRUE,questionId) values ('Lund',0,3);
insert into choices (CHOICE,ISTRUE,questionId) values ('Bjuv',1,3);
insert into choices (CHOICE,ISTRUE,questionId) values ('Vänern',1,4);
insert into choices (CHOICE,ISTRUE,questionId) values ('Vättern',0,4);
insert into choices (CHOICE,ISTRUE,questionId) values ('Delsjön',0,4);
insert into user_test (testId,userId) values(0,2);
insert into user_test (testId,userId) values(1,2);
insert into user_test (testId,userId) values(2,2);

create table choices (
 CHOICEID int not null auto_increment,
 CHOICE varchar(50),
 isTrue bit(1),
 questionId int, 
primary key (CHOICEID),
foreign key (questionId) references questions(QUESTID)
);

create table questions (
QUESTID int not null auto_increment,
QUESTION varchar(50),
testId int,
primary key (QUESTID),
foreign key (testId) references tests(TESTID)

);

create table tests (
TESTID int not null auto_increment,
TESTTITLE varchar(50),
uid int,
primary key (TESTID),
foreign key (uid) references users(uId)

);

create table user_test (
id int not null auto_increment,
testId int,
userId int,
primary key (id),
foreign key (testId) references tests(TESTID),
foreign key (userId) references users(uId)

);




