CREATE TABLE persona(
	persona_id integer NOT NULL AUTO_INCREMENT,
	nombres varchar(255),
    apellidos varchar(255),
	dni varchar(255),
    direccion varchar(255),
    edad int,
	PRIMARY KEY (persona_id)
);
CREATE TABLE Producto(
	producto_id integer NOT NULL AUTO_INCREMENT,
	codigo varchar(255),
    descripcion varchar(255),
	unidad varchar(255),
    precio decimal,
    peso decimal,
    volumen decimal,
	PRIMARY KEY (producto_id)
);