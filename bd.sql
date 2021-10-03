/*PROYECTO - LABORATORIO CLINICO - BASE DE DATOS*/

create domain name_domain varchar(20) check ( value ~ '^[A-Z][a-z]*$' and not null);
create type estado as enum ('pendiente','terminado','cancelado');

create table paciente (
    cedulaPaciente bigint,
    nombrePaciente name_domain,
    apellidoPaciente name_domain,
    fechaNacimiento date,
    pos varchar(15), -- Editar para not null
    telefonoContacto integer default 0,
    numeroCelular integer,
    correoElectronico varchar(50)
);

alter table paciente
    add constraint pk_paciente primary key (cedulaPaciente);

create table contactoPaciente (
    cedulaPaciente bigint,
    nombreContacto name_domain,
    apellidoContacto name_domain,
    telefonoDeContacto integer not null
);

alter table contactoPaciente
    add constraint unique_contPaciente unique (cedulaPaciente),
    add constraint fk_contPaciente foreign key (cedulaPaciente) references paciente(cedulaPaciente);

create table medico (
    cedulaMedico bigint,
    nombreMedico name_domain,
    apellidoMedico name_domain,
    telefono integer not null ,
    direccion varchar(20),
    especialidad varchar(20) not null
);

alter table medico
    add constraint pk_medico primary key (cedulaMedico);

create table orden (
    consecutivo varchar(20),
    cedulaPaciente bigint,
    fechaSolicitud date not null ,
    fechaIngreso date not null,
    cedulaMedico bigint,
    numOrdenMed varchar(20) not null
);

alter table orden
    add constraint pk_orden primary key (consecutivo),
    add constraint fk_cedPaciente foreign key (cedulaPaciente) references paciente(cedulaPaciente),
    add constraint fk_cedMed foreign key (cedulaMedico) references medico(cedulaMedico);

create table examen (
    tipoExamen varchar(30),
    precio numeric(15, 2) default 0.00
);

alter table examen
    add constraint pk_examen primary key (tipoExamen);

create table ordenExamen (
    consecutivo varchar(20),
    examen varchar(30),
    fechaCita date,
    fechaRealizacion date not null
);

alter table ordenExamen
    add constraint pk_ordExamen primary key (consecutivo, examen, fechaCita),
    add constraint unq_ordExamen unique (consecutivo, examen),
    add constraint fk_consecutivo foreign key (consecutivo) references orden(consecutivo),
    add constraint fk_examen foreign key (examen) references examen(tipoExamen);

create table observaExamen (
    consecutivo varchar(20),
    tipoExamen varchar(30),
    observacion text not null
);

alter table observaExamen
    add constraint fk_obserExam
        foreign key (consecutivo, tipoExamen) references ordenExamen(consecutivo, examen);

create table factura (
    numFactura varchar(20),
    conseOrden varchar(20),
    fechaRealizacion date default now(),
    valorPago numeric(15, 2) default 0.00,
    estadoFactura estado default 'pendiente'
);

alter table factura
    add constraint pk_factura primary key (numFactura),
    add constraint fk_factura foreign key (conseOrden) references orden(consecutivo);



/*
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
*/

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
