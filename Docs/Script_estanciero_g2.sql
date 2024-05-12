create database BD_Estanciero
go
use BD_Estanciero
go
create table tablero(
id_tablero int identity(1,1)
constraint pk_tablero primary key(id_tablero)
)

create table provincias(
id_provincia int IDENTITY(1,1) not null,
descripcion varchar (100),
CONSTRAINT pk_provincia PRIMARY KEY (id_provincia)
)

create table zonas(
id_zona int IDENTITY(1,1) not null,
descripcion varchar (100),
id_provincia int,
CONSTRAINT pk_zonas PRIMARY KEY (id_zona),
constraint fk_provincias foreign key(id_provincia) references provincias(id_provincia)
)

create table casillas(
nro_casilla int identity(1,1) not null,
tipo int,
id_propiedad int,
id_tablero int,
constraint pk_casillas primary key (nro_casilla),
constraint fk_tablero_cas foreign key (id_tablero) references tablero(id_tablero)
)

create table propiedades(
id_propiedad int IDENTITY(1,1) not null,
id_provincia int,
id_propietario int,
nro_casilla int,
precio int,
precio_mejora int,
cont_chacras int,
precio_alquiler int,
id_casilla int,
CONSTRAINT pk_propiedades PRIMARY KEY (id_propiedad),
constraint fk_provincia foreign key (id_provincia) references provincias(id_provincia),
constraint fk_casillas foreign key (id_casilla) references casillas(nro_casilla))



create table modos_juego(
id_modo_juego int identity(1,1),
descripcion varchar(30),
id_tablero int,
constraint pk_modo_juego primary key (id_modo_juego) ,
constraint fk_tablero_mod foreign key (id_tablero) references tablero(id_tablero))

create table dificultad(
id_dificultad int identity(1,1),
descripcion varchar(30),
id_tablero int,
constraint pk_dificultad primary key(id_dificultad),
constraint fk_tablero_dif foreign key (id_tablero) references tablero(id_tablero)
)

create table tarjetas(
id_tarjeta int identity(1,1),
tipo int,
descripicon varchar(200),
id_tablero int,
constraint pk_tarjeta primary key (id_tarjeta),
constraint fk_tablero_tar foreign key (id_tablero) references tablero(id_tablero)
)

