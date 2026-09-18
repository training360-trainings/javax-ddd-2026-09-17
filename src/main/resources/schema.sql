create table if not exists employee_entity (
    id serial primary key,
    name varchar(255) not null
);

create table if not exists course_entity (
    code varchar(255) primary key,
    title varchar(255) not null,
    enroll_limit integer
);

create table if not exists enrollment_entity
(
    id serial primary key,
    employee_id bigint references employee_entity(id),
    course_code varchar(255) references course_entity(code)
);