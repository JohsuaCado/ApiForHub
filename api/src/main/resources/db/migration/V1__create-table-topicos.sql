create table topicos(

id bigint not null auto_increment unique,
fecha_creacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
titulo varchar(100) not null unique,
mensaje varchar(1000)not null,
curso varchar(100) not null,

primary key(id)

);