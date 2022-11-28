create table student
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
