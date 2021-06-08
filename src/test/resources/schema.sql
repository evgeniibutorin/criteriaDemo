drop table if exists university;

create table university
(
    id int auto_increment primary key,
    university_name varchar(100),
    university_rating integer
);