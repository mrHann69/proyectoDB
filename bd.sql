create domain name_domain varchar(20) check ( value ~ '^[A-Z][a-z]*$' and not null);
create type estado as enum ('pendiente','cancelado');

create table paciente (
    cedulaPaciente bigint,
    nombrePaciente name_domain,
    apellidoPaciente name_domain,
    fechaNacimiento date,
    pos varchar(15) not null default 'Particular',
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


   --tabla para login de usuarios
drop table  if exists trabajadores ;
create table trabajadores(
	cedula varchar(12) not null unique,
	pass varchar(20) not null
);
alter table trabajadores
	add constraint pk_workers primary key (cedula,pass);


-- Un consolidado de ingresos por tipo de paciente (particular o por entidad de salud), ordenados de mayor a menor.
select pos, count(pos) as type_paciente from paciente
    group by (pos)
    order by (type_paciente) desc ;

-- A fin de mes interesa conocer el médico tratante que más pacientes remitió.
create view count_med as select cedulaMedico, count(*) juju from orden group by (cedulaMedico);
select max(juju) as re from count_med as result;

select medico.cedulaMedico, nombreMedico, apellidoMedico from count_med
    join (select max(juju) as re from count_med) as result
            on count_med.juju = re
    join medico
            on medico.cedulaMedico = count_med.cedulaMedico;

-- Para una fecha particular se necesita saber los exámenes que hay pendientes con datos del paciente


create or replace function pending_exams(fecha date)
    returns table (cedulaPaciente bigint, nombrePaciente name_domain, apellidoPaciente name_domain
                  , consecutivo varchar, examen varchar, fechaCita date)
    language plpgsql
    as
    $$
    begin
        return query
            select pa.cedulaPaciente, pa.nombrePaciente, pa.apellidoPaciente, orEx.consecutivo, orEx.examen, orEx.fechaCita from paciente as pa
                join orden
                    on orden.cedulaPaciente = pa.cedulaPaciente
                join ordenExamen as orEx
                    on orEx.consecutivo = orden.consecutivo
                where orEx.fechaCita > date('2021/03/17');
    end;
    $$;

select * from pending_exams2(date('2021/03/17'));
select * from paciente;


-- También se requiere tener información de un paciente en particular (por número de cédula), qué exámenes se realizó con fecha de realización.
create or replace function information_exams(cedula bigint)
    returns table (consecutivo varchar, exams varchar, fechaCita date, fechaRealizacion date)
    language plpgsql
    as
    $$
    begin
        return query
            select * from ordenExamen as orEx
                where orEx.consecutivo in (select ord.consecutivo from orden as ord
                    where ord.cedulaPaciente in (select pc.cedulaPaciente from paciente as pc
                        where pc.cedulaPaciente = cedula and
                            orEx.fechaRealizacion <= date(now())));
    end;
    $$;

select * from information_exams(741258);
