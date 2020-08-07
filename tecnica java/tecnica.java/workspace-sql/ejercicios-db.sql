


----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
select tipodoc, documento, nombre, apellido, legajo from alumno a left join persona p on a.idpersona=p.identificador;

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente
select a.legajo, p.nombre, p.apellido, c.nombre, ic.fechainscripcion
from inscripciones_carrera ic 
inner join carrera c
on ic.idcarrera=c.identificador
inner join alumno a 
on ic.idalumno=a.identificador
inner join persona p 
on a.idpersona=p.identificador
order by a.legajo desc;

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso
select ca.nombre, c.nombre, count(ic.idcurso) as cantidad_inscriptos, c.cupomaximo  from curso c 
inner join inscripciones_curso ic 
on c.identificador = ic.idcurso 
inner join carrera ca 
on ca.identificador = c.idcarrera
group by c.identificador,ca.nombre;

--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
select ca.nombre, c.nombre, count(ic.idcurso) as cantidad_inscriptos, c.cupomaximo  from curso c 
inner join inscripciones_curso ic 
on c.identificador = ic.idcurso 
inner join carrera ca 
on ca.identificador = c.idcarrera
group by c.identificador,ca.nombre
having count(ic.idcurso)>c.cupomaximo;

--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.

update curso set cupomaximo=10 where anio=2018 and cupomaximo<5;

--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual
update curso set fechainscripcion=current_date
where (
select * from inscripciones_curso cu inner join curso c


----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
select tipodoc, documento, nombre, apellido, legajo from alumno a left join persona p on a.idpersona=p.identificador;

--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente
select a.legajo, p.nombre, p.apellido, c.nombre, ic.fechainscripcion
from inscripciones_carrera ic 
inner join carrera c
on ic.idcarrera=c.identificador
inner join alumno a 
on ic.idalumno=a.identificador
inner join persona p 
on a.idpersona=p.identificador
order by a.legajo desc;

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso
select ca.nombre, c.nombre, count(ic.idcurso) as cantidad_inscriptos, c.cupomaximo  from curso c 
inner join inscripciones_curso ic 
on c.identificador = ic.idcurso 
inner join carrera ca 
on ca.identificador = c.idcarrera
group by c.identificador,ca.nombre;

--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
select ca.nombre, c.nombre, count(ic.idcurso) as cantidad_inscriptos, c.cupomaximo  from curso c 
inner join inscripciones_curso ic 
on c.identificador = ic.idcurso 
inner join carrera ca 
on ca.identificador = c.idcarrera
group by c.identificador,ca.nombre
having count(ic.idcurso)>c.cupomaximo;

--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.

update curso set cupomaximo=10 where anio=2018 and cupomaximo<5;

--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual
	
update inscripciones_curso cu 
set fechainscripcion=current_date
from curso c
left join inscripciones_carrera ca on c.idcarrera = ca.idcarrera
where cu.fechainscripcion<ca.fechainscripcion and cu.idcurso=c.identificador  and cu.idalumno = ca.idalumno;
	
-- nota: existen inscripciones de alumnos a cursos de una carrera a la que no estan inscriptos --  

--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)
	
insert into persona values(6, 'DNI',37815875,'Julieta', 'Chaparro', '1994-09-03');
insert into alumno values(6,6,41370);
	
--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.

/*Sería conveniente hacerlo en la tabla persona, que es donde se encuentran los datos personales.*/
ALTER TABLE persona 
ADD COLUMN direccion VARCHAR(200);	
	
