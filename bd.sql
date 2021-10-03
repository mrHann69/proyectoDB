/*PROYECTO - LABORATORIO CLINICO - BASE DE DATOS*/
/*
 * crear datos y realizar consultas
 * DAO clases y solo metodo insert
 * */
create domain name_domain varchar(20) check ( value ~ '^[A-Z][a-z]*$' and not null);
--create type estado as enum ('pendiente','cancelado');

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
    fechaRealizacion date not null -- <-es lo mismo que la fecha cita
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


/*CONTEXTO
 * Al laboratorio clínico PRUEBAS, le interesa registrar los exámenes de laboratorio que realiza a los pacientes.  Los pacientes pueden pertenecer a alguna entidad de salud que le cubre los exámenes o ser particulares.  En todos los casos de los pacientes interesa saber cédula, fecha de nacimiento, POS, teléfonos de contacto, celular, correo electrónico, nombre de otra persona para contacto y teléfono de contacto.
Cuando llega un paciente solicitando la realización de exámenes, si no está registrado se le piden todos los datos y se registra en el sistema, y con la orden que mandó el médico se registran los exámenes.  Se debe crear una orden en el sistema,  esta orden debe tener un consecutivo, fecha de solicitud, fecha de ingreso en el sistema(now), médico tratante y número de la orden que entregó el médico.  Y se prosigue a ingresar los exámenes que pidió el médico: tipo de examen, fecha cita, fecha de realización y observaciones (pueden ser varias).
Del médico se maneja la siguiente información: cédula, nombres y apellidos, teléfonos de contacto, dirección, especialidad.
Sólo para los pacientes particulares se debe crear una factura por cada orden de exámenes que realice, debe tener número de la factura, valor a pagar, la información del paciente (cédula, nombre, dirección, teléfono), fecha de realización.  Cada tipo de examen tiene un valor distinto, por ejemplo, el valor de un examen de triglicéridos es de 15.000, un hemograma sencillo de 10.000, etc. 
*/
/*CONSULTAS*/
--A fin de mes, se debe generar una factura, 
--relacionada con las diferentes órdenes de la entidad prestadora 
--que va a pagar los exámenes. 

--Es posible consultar por número de factura, el encabezado de la factura con el detalle 
--de los exámenes que se realizaron en ese mes (tipo de examen, número de orden, cédula del paciente) 
--y el valor total de la factura.

--A fin de mes interesa conocer el médico tratante que más pacientes remitió.   

--Un consolidado de ingresos por tipo de paciente (particular o por entidad de salud), ordenados de mayor a menor. 

--También se requiere tener información de un paciente en particular (por número de cédula), qué exámenes se realizó y con fecha de realización.

--Para una fecha particular se necesita saber 
--los exámenes que hay pendientes con datos del paciente.

