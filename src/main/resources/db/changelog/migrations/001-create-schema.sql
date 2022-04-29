DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id           BIGSERIAL PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    middle_name  VARCHAR(255),
    last_name    VARCHAR(255),
    email        VARCHAR(255) NOT NULL,
    phone_number VARCHAR(16)  NOT NULL,
    car_number   VARCHAR(16)  NOT NULL UNIQUE,
    car_model    VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS parking_places;
CREATE TABLE IF NOT EXISTS parking_places
(
    id     BIGSERIAL PRIMARY KEY,
    number VARCHAR(8)  NOT NULL UNIQUE,
    status VARCHAR(16) NOT NULL,
    price  FLOAT       NOT NULL
);

DROP TABLE IF EXISTS parking_tickets;
CREATE TABLE IF NOT EXISTS parking_tickets
(
    id               BIGSERIAL PRIMARY KEY,
    place_id         BIGINT      NOT NULL REFERENCES parking_places (id),
    user_id          BIGINT      NOT NULL REFERENCES users (id),
    start_time       TIMESTAMPTZ NOT NULL default now(),
    duration_minutes INT         NOT NULL default 30,
    prepaid          BOOLEAN     NOT NULL default 'FALSE'
);
