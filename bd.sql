/*PROYECTO - LABORATORIO CLINICO - BASE DE DATOS*/

-- Esquema Relacional
/*
Paciente( PK(Cedula),fechaNacimiento,POS,telefonoContacto, FK(cedulaContacto))
		foreign key cedulaContacto REFERENCIA A cedulaContacto en Contacto
	
Contacto( PK(cedulaContacto),nombreContacto,telefonoContacto)

pacienteOrden(FK(cedula),FK(consecutivoOrden))
		foreign key cedula referencia a cedula en Paciente
		foreign key consecutivoOrden referencia a consecutivo en OrdenMedica
		
Factura( PK(numFactura),valor,fechaRealizacion, FK(cedulaPaciente))
		foreign key cedulaPaciente referencia a cedula en Paciente
	
OrdenMedica( PK(consecutivo),fechaingreso, FK(medicoTratante), numeroOrden, fechaSolicitud)
		foreign key medicoTratante referencia a cedula en Medico
		
Medico( PK(cedula),nombre,apellido,telefono,direccion,especialidad)

ExamenMedico( PK(tipoExamen),fechaCita,fechaRealizacion, FK(consecutivoOrden))
		foreign key consecutivoOrden referencia a consecutivo en OrdenMedica

ValorExamen( FK(tipoExamen),valor)
		foreign key tipoExamen referencia a tipoExamen en ExamenMedico
	
Observaciones( FK(tipoExamen),observacion)
		foreing key tipoExamen referencia a tipoExamen en ExamenMedico
*/




















/*CONSULTAS*/
--A fin de mes, se debe generar una factura, relacionada con las diferentes órdenes de la entidad prestadora que va a pagar los exámenes. 

--Es posible consultar por número de factura, el encabezado de la factura con el detalle de los exámenes que se realizaron en ese mes 
--(tipo de examen, número de orden, cédula del paciente) y el valor total de la factura.

--A fin de mes interesa conocer el médico tratante que más pacientes remitió.   

--Un consolidado de ingresos por tipo de paciente (particular o por entidad de salud), ordenados de mayor a menor. 

--También se requiere tener información de un paciente en particular (por número de cédula), qué exámenes se realizó y con fecha de realización.

--Para una fecha particular se necesita saber los exámenes que hay pendientes con datos del paciente.







































