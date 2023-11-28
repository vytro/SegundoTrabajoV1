INSERT INTO "user" (id, username, password, email, created_at) VALUES
    (1, 'jonny', '24532f', 'jhon@example.com', current_timestamp),
    (2, 'janny', 'janyL', 'jane@example.com', current_timestamp);

INSERT INTO user_detail (id, first_name, last_name, age, birth_day, user_id) VALUES
    (1, 'John', 'Smith', 30, '1992-01-01', 1),
    (2, 'Jane', 'Doe', 28, '1994-02-02', 2);

INSERT INTO role (id, name) VALUES
     (1, 'Administrator'),
     (2, 'User');

INSERT INTO user_role (id, active, created_at, user_id, rol_id) VALUES
    (1, TRUE, current_timestamp, 1, 1),
    (2, TRUE, current_timestamp, 2, 2);
