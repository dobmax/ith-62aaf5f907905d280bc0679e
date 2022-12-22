create table city
(
    id serial
        constraint city_pk
            primary key,
    name varchar(50) not null,
    population int,
    country_id int not null
        constraint city_country_id_fk
        references country
);

create index city_country_id_index
    on city (country_id);

create unique index city_name_uindex
    on city (name);

create table country
(
    id serial
        constraint country_pk
            primary key,
    name varchar(60) not null,
    mainland_id int not null
        constraint country_mainland_id_fk
        references mainland
);

create index country_mainland_id_index
    on country (mainland_id);

create unique index country_name_uindex
    on country (name);

create table mainland
(
    id serial
        constraint mainland_pk
            primary key,
    name varchar(50)
);

create unique index mainland_name_uindex
    on mainland (name);

-- Altering

alter table mainland add column existing boolean default false;

alter table city add constraint chk_population check (population >= 0);

-- when table exists already
-- alter table country add constraint country_mainland_id_fk references mainland

