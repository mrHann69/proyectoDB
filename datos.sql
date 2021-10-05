insert into paciente values 
						(123456,'Pacienteuno','Apellidouno','1980/01/01','EPS1',312654987,310456789,'algo1@pacientes.com'),
						(789456,'Pacientedos','Apellidodos','1990/02/17',null,312654987,310456789,'algo2@pacientes.com'), -- > null
						(123789,'Pacientetres','Apellidotres','1970/05/11',null,31245132,310456789,'algo3@pacientes.com'), -- > null
						(741258,'Pacientecuatro','Apellidocuatro','1990/04/28','EPS2',312328541,310456789,'algo4@pacientes.com'),
						(963258,'Pacientecinco','Apellidocinco','1960/08/26','EPS3',312698574,310456789,'alg5@pacientes.com'),
						(753689,'Pacienteseis','Apellidoseis','1980/02/12','EPS1',312654987,310456789,'algo6@pacientes.com'),
						(753214,'Pacientesiete','Apellidosiete','2002/04/30',null,312654987,310456789,'algo7@pacientes.com'), -- > null
						(147896,'Pacienteocho','Apellidoocho','1999/07/29','EPS3',312654987,310456789,'algo8@pacientes.com'),
						(365214,'Pacientenueve','Apellidonueve','2000/02/01','EPS1',312654987,310456789,'algo9@pacientes.com');						  
												
insert into contactoPaciente values 
								(123456,'Pacienteuno','Apellido',312654987),
								(789456,'Pacientedos','Apellido',312654987),
								(123789,'Pacientetres','Apellido',312451327),
								(741258,'Pacientecuatro','Apellido',312328541),
								(963258,'Pacientecinco','Apellido',312698574),
								(753689,'Pacienteseis','Apellido',312654987),
								(753214,'Pacientesiete','Apellido',312654987),
								(147896,'Pacienteocho','Apellido',312654987),
								(365214,'Pacientenueve','Apellido',312654987);
select * from medico;
insert into medico values
						(7895,'Medicouno','Apellido',852369,'direccion1','especialidad1'), --01
						(9584,'Medicodos','Apellido',852745,'direccion2','especialidad2'), --02
						(7513,'Medicotres','Apellido',852251,'direccion3','especialidad3'), --03
						(1258,'Medicocuatro','Apellido',852982,'direccion4','especialidad1'),
						(3549,'Medicocinco','Apellido',852376,'direccion5','especialidad2'),
						(7863,'Medicoseis','Apellido',852168,'direccion6','especialidad3');
select * from orden;						
insert into orden values
						('000001',123456,'2021/01/12','2021/02/12', 7895,'100001'),
						('000002',789456,'2021/02/13','2021/03/13', 9584,'100002'),
						('000003',123789,'2021/03/01','2021/04/01', 7513,'100003'),
						('000004',741258,'2021/03/02','2021/04/02', 7513,'100004'),
						('000005',963258,'2021/01/24','2021/02/24', 7895,'100005'),
						('000006',753689,'2021/02/27','2021/03/27', 9584,'100006'),
						('000007',753214,'2021/01/05','2021/02/05', 7895,'100007'),
						('000008',147896,'2021/02/08','2021/03/08', 9584,'100008'),
						('000009',365214,'2021/01/22','2021/02/22', 7895,'100009');
				
insert into examen values
						('trigliceridos',15000),
						('hemograma sencillo', 10000),
						('prostata sencillo', 20000),
						('prostata completo', 50000),
						('prostata plus', 70000),
						('colesterol', 32000),
						('conteo esperma', 45000),
						('examen1', 25000),
						('examen2', 30000),
						('examen3', 50000),
						('examen4', 15000);
select * from ordenexamen ;							
insert into ordenExamen values
							('000001','trigliceridos', '2021/02/15','2021/02/15'),
							('000001','examen1', '2021/02/15','2021/02/15'),
							('000002','hemograma sencillo', '2021/03/17','2021/03/17'),
							('000002','examen1', '2021/03/18','2021/03/18'),
							('000003','trigliceridos', '2021/04/08','2021/04/08'),
							('000003','examen2', '2021/04/08','2021/04/08'),
							('000004','prostata plus', '2021/04/09','2021/04/09'),
							('000004','conteo esperma', '2021/04/09','2021/04/09'),
							('000005','examen4', '2021/03/29','2021/03/29'),
							('000005','examen2', '2021/03/29','2021/03/29'),
							('000006','conteo esperma', '2021/03/30','2021/03/30'),
							('000007','colesterol', '2021/02/10','2021/02/10'),
							('000008','hemograma sencillo', '2021/02/16','2021/02/06'),
							('000009','examen3', '2021/02/28','2021/02/28');
												
insert into observaExamen values 
							('000001','trigliceridos', 'Observacion 1'),
							('000001','examen1', 'Observacion 2'),
							('000002','hemograma sencillo', 'Observacion 3'),
							('000002','examen1', 'Observacion 4'),
							('000003','trigliceridos', 'Observacion 5'),
							('000003','examen2', 'Observacion 6'),
							('000004','prostata plus', 'Observacion 7'),
							('000004','conteo esperma', 'Observacion 8'),
							('000005','examen4', 'Observacion 9'),
							('000005','examen2', 'Observacion 10'),
							('000006','conteo esperma', 'Observacion 11'),
							('000007','colesterol', 'Observacion 12'),
							('000008','hemograma sencillo', 'Observacion 13'),
							('000009','examen3', 'Observacion 14');
													
insert into factura values 
						('90101', '000002','2021/03/13',35000,'pendiente'),
						('90102', '000003','2021/04/01',45000,'pendiente'),
						('90103', '000007','2021/02/05',32000,'pendiente');


insert into trabajadores values
				('102030','pass1'),
				('admin','admin');

										
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

