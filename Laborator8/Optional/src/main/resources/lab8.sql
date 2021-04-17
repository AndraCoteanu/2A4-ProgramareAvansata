----------------------------------------------------------------------------------------------
--JAVA - LAB 8
--@author: Andra C. 2A4
----------------------------------------------------------------------------------------------

drop table film;
drop table actors;
drop table directors;
drop table movies;
drop table genres;
drop table person;

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

create table person
(
    id_pers number(4) primary key,
    nume varchar2(20) not null,
    prenume varchar2(30) not null,
    gender varchar2(3) not null,
    check (gender in ('M','F','N/A'))
);

create table actors
(
    id_pers number(4) references person(id_pers),
    id_movie number(4) references movies(id_movie)
);

create table directors
(
    id_pers number(4) references person(id_pers),
    id_movie number(4) references movies(id_movie)
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

insert into person values (1, 'Darabont', 'Frank', 'M');
insert into person values (2, 'Robbins', 'Tim', 'M');
insert into person values (3, 'Freeman', 'Morgan', 'M');
insert into person values (4, 'Gunton', 'Bob', 'M');
insert into person values (5, 'Coppola', 'Francis Ford', 'M');
insert into person values (6, 'Brando', 'Marlon', 'M');
insert into person values (7, 'Pacino', 'Al', 'M');
insert into person values (8, 'Nolan', 'Christopher', 'M');
insert into person values (9, 'Bale', 'Christian', 'M');
insert into person values (10, 'Ledger', 'Heath', 'M');

insert into directors values (1, 1);
insert into directors values (5, 2);
insert into directors values (8, 3);

insert into actors values (2, 1);
insert into actors values (3, 1);
insert into actors values (4, 1);
insert into actors values (6, 2);
insert into actors values (7, 2);
insert into actors values (9, 3);
insert into actors values (10, 3);
----------------------------------------------------------------------------------------------
