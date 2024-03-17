create domain year_range as smallint
check(value>=0 and value<3000);

create table netflix_title (
    id serial,
    show_id varchar(6),
    type varchar(2) not null,
    title varchar(255) not null,
    director varchar(255),
    title_cast TEXT,
    country varchar(255),
    date_added date not null,
    release_year year_range not null,
    duration varchar(10) not null,
    listed_in varchar(255),
    description text,
    constraint car_pk primary key (id),
    constraint show_id unique (show_id)
);

create index idx_type_country on netflix_title (type, country, listed_in);
