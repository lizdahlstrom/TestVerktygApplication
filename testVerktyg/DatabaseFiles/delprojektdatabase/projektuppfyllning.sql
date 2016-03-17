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
insert into user_test (testId,userId) values(1,2);



