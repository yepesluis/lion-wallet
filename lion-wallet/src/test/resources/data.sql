INSERT INTO "category"("id","name") VALUES (11111,'food');
INSERT INTO "category"("id","name") VALUES (22222,'transportation');

INSERT INTO "movement" ("date","category_id","id","value","movement_type","title")
VALUES('2024-09-01',11111,NEXTVAL('movement_seq'),20,'outflow','breakfast');
INSERT INTO "movement" ("date","category_id","id","value","movement_type","title")
VALUES('2024-09-02',11111,NEXTVAL('movement_seq'),20,'outflow','diner');
INSERT INTO "movement" ("date","category_id","id","value","movement_type","title")
VALUES('2024-09-03',11111,NEXTVAL('movement_seq'),10,'outflow','lunch');
INSERT INTO "movement" ("date","category_id","id","value","movement_type","title")
VALUES('2024-10-04',22222,NEXTVAL('movement_seq'),10,'outflow','taxi');