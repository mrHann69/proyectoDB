/*PROYECTO - LABORATORIO CLINICO - BASE DE DATOS*/
drop type estado;
create type estado as enum ('pendiente','cancelado');

create table Contacto(
	cedulaContacto varchar(10),
	nombreContacto varchar(20),
	telefonoContacto varchar(10),
		primary key (cedulaContacto)
);
create table Paciente(
	cedula varchar(10),
	fechaNacimiento date,
	POS varchar(5),
	telefonoContacto varchar(10),
	cedulaContacto varchar(10),
		primary key (cedula),
			foreign key (cedulaContacto) references Contacto(cedulaContacto)
);
create table Medico(
	cedula varchar(10),
	nombre varchar(20),
	apellido varchar(20),
	telefono varchar(12),
	direcicon varchar(40),
	especialidad varchar(10),
		primary key (cedula)
);
create table ordenMedica(
	consecutivo int,
	fechaIngreso date default now(),
	medicoTratante varchar(10),
	numeroOrden int,
	fechaSolicitud date,
		primary key (numeroOrden),
		foreign key (medicoTratante) references Medico(cedula)
);
create table Factura(
	numFactura int,
	valor float,
	fechaRealizacion date,
	numOrden int,
	estadoFactura estado,
		foreign key (numOrden) references ordenMedica(numeroOrden)
);
create table Medico(
	cedula varchar(10),
	nombre varchar(20),
	apellido varchar(20),
	telefono varchar(12),
	direcicon varchar(40),
	especialidad varchar(10),
		primary key (cedula)
);
create table ordenMedica(
	consecutivo int,
	fechaIngreso date default now(),
	medicoTratante varchar(10),
	numeroOrden int,
	fechaSolicitud date,
		primary key (numeroOrden),
		foreign key (medicoTratante) references Medico(cedula)
);
create table pacienteOrden(
	cedula varchar(10),
	numeroOrden int,
		foreign key (cedula) references Paciente(cedula),
		foreign key (numeroOrden) references ordenMedica(numeroOrden)
);
create table examenMedico(
	tipoExamen varchar(40),
	fechaCita date,
	fechaRealizacion date,
	numeroOrden int,
		primary key (tipoExamen),
			foreign key (numeroOrden) references ordenMedica(numeroOrden)
);
create table valorExamen(
	tipoExamen varchar(40),
	valor float,
		unique(tipoExamen),
		foreign key (tipoExamen) references examenMedico(tipoExamen)
);
create table Observaciones(
	tipoExamen varchar(40),
	observacion varchar(256),
		foreign key (tipoExamen) references examenMedico(tipoExamen)
);

/*orden de creacion de las tablas
 * Contacto
 * Paciente
 * tipo estado
 * Factura
 * Medico
 * OrdenMedica
 * PacienteOrden
 * ExamenMedico
 * ValorExamen
 * Observaciones
*/

/*CONSULTAS*/
--A fin de mes, se debe generar una factura, 
--relacionada con las diferentes órdenes de la entidad prestadora 
--que va a pagar los exámenes. 

--Es posible consultar por número de factura, el encabezado de la factura con el detalle de los exámenes que se realizaron en ese mes 
--(tipo de examen, número de orden, cédula del paciente) y el valor total de la factura.

--A fin de mes interesa conocer el médico tratante que más pacientes remitió.   

--Un consolidado de ingresos por tipo de paciente (particular o por entidad de salud), ordenados de mayor a menor. 

--También se requiere tener información de un paciente en particular (por número de cédula), qué exámenes se realizó y con fecha de realización.

--Para una fecha particular se necesita saber 
--los exámenes que hay pendientes con datos del paciente.

/*
 * Medico
 * orden medica
 * paciente
 * contacto
 * */
