create table if not exists student
(
    id      integer      not null
        constraint student_pk
            primary key,
    name    varchar(30)  not null,
    surname varchar(30)  not null,
    email   varchar(100) not null
);

alter table student
    owner to ith;

create sequence student_id_seq
    as integer;

alter table student alter column id set default nextval('public.student_id_seq'::regclass);

alter sequence student_id_seq owned by student.id;

create table if not exists "group"
(
    id serial
        constraint group_pk
            primary key,
    name varchar(50) not null
);

create unique index group_name_uindex
    on "group" (name);

create table if not exists student_group
(
    id serial
        constraint student_group_pk
            primary key,
    student_id int not null
        constraint student_group_student_id_fk
            references student,
    group_id int not null
        constraint student_group_group_id_fk
            references "group"
);


