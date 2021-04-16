----------------------------------------------------------------------------------------------
--JAVA - LAB 8
--@author: Andra C. 2A4
----------------------------------------------------------------------------------------------

drop table film;
drop table movies;
drop table genres;

create table movies
(
    id_movie     number(4) primary key,
    title        varchar2(50) not null,
    release_date date         not null,
    duration     number(5)    not null,
    score        number(3, 2) not null,
    check (duration > 0)
);

create table genres
(
    id_genre number(4) primary key,
    nume     varchar2(15) not null
);

create table film
(
    id_movie number(4) references movies (id_movie),
    id_genre number(4) references genres (id_genre)
);

----------------------------------------------------------------------------------------------
insert into movies values (1, 'The Shawshank Redemption', to_date('1994', 'YYYY'), 142, 9.3);
insert into movies values (2, 'The Godfather', to_date('1972', 'YYYY'), 175, 9.2);
insert into movies values (3, 'The Dark Knight', to_date('2008', 'YYYY'), 152, 9.0);

insert into genres values (1, 'Drama');
insert into genres values (2, 'Crime');
insert into genres values (3, 'Action');

insert into film values (1, 1);
insert into film values (2, 1);
insert into film values (2, 2);
insert into film values (3, 1);
insert into film values (3, 2);
insert into film values (3, 3);

----------------------------------------------------------------------------------------------
