DROP DATABASE IF EXISTS "event-store";
CREATE DATABASE "event-store";

\connect "event-store"

-- DROP TABLE IF EXISTS "command" CASCADE;
-- CREATE TABLE "command"
-- (
--     "request_id" uuid NOT NULL,
--     "command_type" varchar(255) NOT NULL,
--     "command_data" varchar(255) NOT NULL,
--     PRIMARY KEY("request_id", "command_type")
-- );
--
-- DROP TABLE IF EXISTS "event" CASCADE;
-- CREATE TABLE "event"
-- (
--     "aggregate_id" uuid NOT NULL,
--     "version" integer NOT NULL,
--     PRIMARY KEY("aggregate_id", "version")
-- );

DROP TABLE IF EXISTS "account" CASCADE;
CREATE TABLE "account"
(
    "id" uuid NOT NULL,
    "email" varchar(255) NOT NULL,
    PRIMARY KEY("id"),
    UNIQUE("email")
);

DROP TABLE IF EXISTS "role" CASCADE;
CREATE TABLE "role"
(
    "id" uuid NOT NULL,
    "name" varchar(255) NOT NULL,
    PRIMARY KEY("id")
);

DROP TABLE IF EXISTS "crew" CASCADE;
CREATE TABLE "crew"
(
    "id" uuid NOT NULL,
    "name" varchar(255) NOT NULL,
    "account_id" uuid NOT NULL,
    PRIMARY KEY("id")
);

ALTER TABLE "crew"
    ADD FOREIGN KEY("account_id") REFERENCES "account" ON DELETE CASCADE;