CREATE ALIAS MD5 FOR "org.hsqldb.lib.MD5.encodeString";
INSERT INTO MYWMS_CLIENT VALUES(0,'2010-11-30 13:59:22.553000000','2010-11-30 14:32:03.232000000','This is a system used entity. DO NOT REMOVE, LOCK OR RENAME IT! Some processes may use it.',0,1,'01',NULL,NULL,'System-Client','System',NULL);
INSERT INTO MYWMS_ROLE VALUES(0,'2010-11-30 13:59:51.888000000','2010-11-30 13:59:51.888000000','This is a system used entity. DO NOT REMOVE, LOCK OR RENAME IT! Some processes may use it.',0,0,'Admin','System Administrator');
INSERT INTO MYWMS_ROLE VALUES(600,'2010-11-30 14:32:03.228000000','2010-11-30 14:32:03.229000000',NULL,0,0,'Operator','');
INSERT INTO MYWMS_ROLE VALUES(601,'2010-11-30 14:32:03.242000000','2010-11-30 14:32:03.246000000',NULL,0,0,'Foreman','');
INSERT INTO MYWMS_ROLE VALUES(602,'2010-11-30 14:32:03.248000000','2010-11-30 14:32:03.248000000',NULL,0,0,'Inventory','');
INSERT INTO MYWMS_USER VALUES(0,'2010-11-30 13:59:51.916000000','2010-11-30 13:59:51.916000000','This is a system used entity. DO NOT REMOVE OR LOCK IT! Some processes may use it. But feel free to choose a suitable name and password.',0,0,NULL,NULL,NULL,NULL,'admin','en','21232f297a57a5a743894a0e4a801fc3',0);
INSERT INTO MYWMS_USER VALUES(1,'2010-11-30 13:59:51.922000000','2010-11-30 14:32:03.267000000',0,1,NULL,NULL,NULL,NULL,'Deutsch','deutsch','de','09c438e63455e3e1b3deabe65fdbc087',0);
INSERT INTO MYWMS_USER VALUES(2,'2010-11-30 13:59:51.925000000','2010-11-30 14:32:03.275000000',0,1,NULL,NULL,NULL,NULL,'English','english','en','ba0a6ddd94c73698a3658f92ac222f8a',0);
INSERT INTO MYWMS_USER_MYWMS_ROLE VALUES(0,0);
INSERT INTO MYWMS_USER_MYWMS_ROLE VALUES(1,0);
INSERT INTO MYWMS_USER_MYWMS_ROLE VALUES(2,0);