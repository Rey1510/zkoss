INSERT INTO ROLE (id, name) VALUES (1, 'ROLE_USER')
INSERT INTO ROLE (id, name) VALUES (2, 'ROLE_ADMIN')

INSERT INTO user (id, username, password) VALUES (1,'admin', '$2a$10$TvNWvjjtGfG1H2bbP7CTieilW/J/v63Wj3rD1PlJaxJqrAfYw/SAm' )
INSERT INTO user (id, username, password) VALUES (2,'user', '$2a$10$xUN8VmHRQZvpcISU7TmtbOoY0AH8N4mzSoSA2e3iZrEIXl5x3d2CG' )

INSERT INTO user_roles (user_id, role_id) VALUES (1,1);
INSERT INTO user_roles (user_id, role_id) VALUES (1,2);
INSERT INTO user_roles (user_id, role_id) VALUES (2,1);

INSERT INTO PERSON VALUES(1,32,'1992-02-02 00:00:00.000000','jane@example.com','Female','Bogor','password456','jane_smith')
INSERT INTO PERSON VALUES(2,32,'1992-02-02 00:00:00.000000','jane@example.com','Female','Bogor','password456','jane_smith')
INSERT INTO PERSON VALUES(3,36,'1988-03-03 00:00:00.000000','mike@example.com','Male','Depok','password789','mike_johnson')
INSERT INTO PERSON VALUES(4,29,'1995-04-04 00:00:00.000000','sara@example.com','Female','Tangerang','password000','sara_connor')
INSERT INTO PERSON VALUES(5,31,'1993-05-05 00:00:00.000000','alex@example.com','Non-binary','Bekasi','password111','alex_brown')
INSERT INTO PERSON VALUES(6,39,'1985-06-06 00:00:00.000000','lisa@example.com','Female','Jakarta','password222','lisa_wilson')
INSERT INTO PERSON VALUES(7,33,'1991-07-07 00:00:00.000000','kevin@example.com','Male','Bogor','password333','kevin_white')
INSERT INTO PERSON VALUES(8,37,'1987-08-08 00:00:00.000000','nina@example.com','Female','Depok','password444','nina_green')
INSERT INTO PERSON VALUES(9,30,'1994-09-09 00:00:00.000000','chris@example.com','Male','Tangerang','password555','chris_black')
INSERT INTO PERSON VALUES(10,28,'1996-10-10 00:00:00.000000','diana@example.com','Female','Bekasi','password666','diana_red')
INSERT INTO PERSON VALUES(11,43,'1980-11-11 00:00:00.000000','tom@example.com','Male','Jakarta','password777','tom_hanks')
INSERT INTO PERSON VALUES(12,30,'1993-12-12 00:00:00.000000','cathy@example.com','Female','Bogor','password888','cathy_james')