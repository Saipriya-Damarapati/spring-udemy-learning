INSERT INTO users_table (id, name, birth_date)
VALUES (10001, 'Divya', CURRENT_DATE());

INSERT INTO users_table (id, name, birth_date)
VALUES (10002, 'Priya', CURRENT_DATE());

INSERT INTO users_table (id, name, birth_date)
VALUES (10003, 'Kavya', CURRENT_DATE());

INSERT INTO posts_table (id, description, user_id)
VALUES (20001, 'Welcome to Divya first post', 10001);

INSERT INTO posts_table (id, description, user_id)
VALUES (20002, 'Welcome to Divya second post', 10001);

INSERT INTO posts_table (id, description, user_id)
VALUES (20003, 'Welcome to Kavya first post', 10003);

INSERT INTO posts_table (id, description, user_id)
VALUES (20004, 'Welcome to Priya first post', 10002);

INSERT INTO posts_table (id, description, user_id)
VALUES (20005, 'Welcome to Kavya second post', 10003);