-- create user TABLE
CREATE TABLE "user" (
    id BIGINT PRIMARY KEY,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

-- create a sequence for user id
CREATE SEQUENCE user_id_seq AS BIGINT INCREMENT BY 1;



-- create user_detail TABLE
CREATE TABLE user_detail (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INTEGER,
    birth_day DATE,
    user_id BIGINT NOT NULL REFERENCES "user"(id)
);

-- create a sequence for user_detail id
CREATE SEQUENCE user_detail_id_seq AS BIGINT INCREMENT BY 1;

ALTER TABLE user_detail ADD CONSTRAINT fk_user_detail_user FOREIGN KEY (user_id)
    REFERENCES "user" (id) ON DELETE CASCADE ON UPDATE CASCADE;



-- create role TABLE
CREATE TABLE role (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- create a sequence for role id
CREATE SEQUENCE role_id_seq AS BIGINT INCREMENT BY 1;




-- create user_role TABLE
CREATE TABLE user_role (
    id BIGINT PRIMARY KEY,
    active BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT NOT NULL REFERENCES "user"(id),
    rol_id BIGINT NOT NULL REFERENCES role(id)
);

-- create a sequence for user_role id
CREATE SEQUENCE user_role_id_seq AS BIGINT INCREMENT BY 1;

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_user FOREIGN KEY (user_id)
    REFERENCES "user" (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_role FOREIGN KEY (rol_id)
    REFERENCES role (id) ON DELETE CASCADE ON UPDATE CASCADE;



