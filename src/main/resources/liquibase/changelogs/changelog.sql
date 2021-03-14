--liquibase formatted sql

--changeset lbibera:00000_initial_db
--comment: initial database for ping entity
create table ping_entity
(
    id bigserial not null constraint ping_entity_pk primary key,
    created_by varchar(255),
    created_on timestamp,
    modified_on timestamp,
    modified_by varchar(255),
    version integer,
    authority varchar(255),
    scopes jsonb
);