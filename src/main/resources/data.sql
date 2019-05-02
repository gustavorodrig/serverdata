DROP TABLE IF EXISTS server_data;

create table server_data
(
   id integer auto_increment not null,
   name varchar(50) not null,
   description varchar(255),
   primary key(id)
);