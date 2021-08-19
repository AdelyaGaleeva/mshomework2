--liquibase formatted sql
--changeset adelya.galeeva:1.0.0-1
CREATE TABLE otus_user
(
    id             SERIAL,
    username       text         CONSTRAINT usernamechk CHECK (char_length(username) <= 256) NOT NULL UNIQUE,
    first_name     text         NOT NULL,
    last_name      text         NOT NULL,
    email          text         UNIQUE,
    phone          text         UNIQUE,

    CONSTRAINT  users_pkey PRIMARY KEY (id)
);

insert into otus_user(username, first_name, last_name, email, phone) values ('adi','adi', 'adi','adi@gmail.com','67876543567')