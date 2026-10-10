## 7. Diccionario de datos

Elementos o columnas con las que cuentan las tablas(a excepción del id que hace de clave primaria de cada tabla):

### Editorial
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `nombre` | `VARCHAR(45)` | Sí | Nombre de la editorial |
| `pais` | `VARCHAR(45)` | Sí | Pais de la sucursal de la editorial |
| `teléfono` | `VARCHAR(15)` | Sí | Teléfono de la editorial |
---
### Libro
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `ISBN` | `VARCHAR(13)` | Sí | Código de identificación único de cada libro. Formato de 13 carácteres debido a que es un estándar |
| `ideditorial` | `INT` | Sí | Identificador correspondiente a la editorial que distribuye el libro |
| `titulo` | `VARCHAR(45)` | Sí | Título del libro |
| `publicado` | `YEAR` | Sí | Fecha de lanzamiento de la edición del libro |
| `páginas` | `INT` | Sí | Cantidad de páginas que tiene el libro |
| `precio` | `DECIMAL(5,2)` | Sí | Precio del libro, esperando que no haya ningún libro que haya que insertar que cuesta más de 1000€ |
| `tipo_autor` | `ENUM('principal','colaborador')` | Sí | Típo de autor que escribe según si escribe todo el libro o se encarga de alguna parte solamente |
---
### Autor
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `idlibro` | `INT` | Sí | Identificador del libro escrito por el autor |
| `nombre` | `VARCHAR(45)` | Sí | Nombre del autor |
| `apellidos` | `VARCHAR(45)` | Sí | Apellidos del autor |
| `nacionalidad` | `VARCHAR(45)` | Si | Nacionalidad del autor |
| `nacimiento` | `DATE` | Si | Fecha de nacimiento del autor |
---
### Librería
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `nombre` | `VARCHAR(45)` | Sí | Nombre de la librería |
| `dirección` | `VARCHAR(45)` | Sí | Direccíon  de la librería para poder localizarla |
| `teléfono` | `VARCHAR(15)` | Sí | Teléfono de la librería |
| `ciudad` | `VARCHAR(45)` | Si | Ciudad donde se ubica la librería |
---
### Inventario
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `idlibro` | `INT` | Sí | Identificador del libro que queremos llevar el conteo |
| `idlibreria` | `INT` | Sí | Identificador de la librería al que pertenece el inventario |
| `stock` | `INT` | Sí | Cantidad de copias de un libro que hay en el inventario |
| `ultimo_conteo` | `DATE` | Si | Última vez que se revisó el inventario |
---
### Empleado
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `idlibreria` | `INT` | Sí | Identificador de la librería en la que trabaja el empleado |
| `DNI` | `VARCHAR(9)` | Sí | Código de identificación del documento nacional de identidad |
| `nombre` | `VARCHAR(45)` | Sí | Nombre del empleado |
| `apellidos` | `VARCHAR(45)` | Sí | apellidos del empleado |
| `cargo` | `ENUM('librero','cajero','encargado)` | Sí | Puesto de trabajo entre los 3 indicados que ocupa el empleado |
| `fecha_contrato` | `DATE` | Sí | Fecha en la que se realizó el contrato del empleado |
| `correo` | `VARCHAR(50)` | Sí | Correo del empleado al que se le envían las notificaciones del trabajo |
---
### Cliente
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `nombre` | `VARCHAR(45)` | Sí | Nombre del cliente atendido |
| `apellidos` | `VARCHAR(45)` | Sí | apellidos del cliente atendido |
| `correo` | `VARCHAR(100)` | Sí | Correo del cliente al que se le envían  |
---
### Socio
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `idcliente` | `VARCHAR(45)` | Sí | Identificador correspondiente a un cliente |
| `teléfono` | `VARCHAR(15)` | No | Número de teléfono no obligatorio de los socios |
| `fecha_alta` | `DATE` | Sí | Fecha en la que el cliente se hizo socio |
---
### Factura
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `idlibreria` | `INT` | Sí | Identificador correspondiente a la libreria donde se realiza la factura |
| `idempleado` | `INT` | Sí | Identificador correspondiente al empleado que realiza la factura |
| `idcliente` | `INT` | Sí | Identificador correspondiente al cliente que recibe la factura |
| `fecha` | `DATE` | Sí | Fecha en la que se realizó la factura |
| `tipo_pago` | `ENUM('efectivo','tarjeta','bizum)` | Sí | Método de pago que uso el cliente |
| `total` | `DECIMAL(10,2)` | Sí | Coste de todos los artículos más el IVA |
| `estado` | `ENUM('preparado','entregado','cancelado)` | Sí | Estado en el que se encuentra lo comprado por el cliente |
| `detalles_factura` | VARCHAR(5000) | Si | Los diferentes artículos comprados por el cliente |
---
## 8. Decisiones de diseño

Decisiones tomadas sobre diferentes elementos de la base de datos

> **Decisión:** Se decidio que era el inventario era quien tenía el id del libro.
> **Por qué:** La idea del inventario es que se sepa cuantas copias hay de cada libro por tienda por lo que lo que importa del inventario no es el id del inventario sino que importa el id del libro + el id de la tienda.
> **Decisión descartada:** Guardar el id del inventario en el libro
---
> **Decisión:** Los detalles de la factura que son los diferentes artículos comprados se guardan en la propia factura.
> **Por qué:** Simplifica la base de datos y junta todos los elementos de la factura en vez de tenerlos por separado.
> **Decisión descartada:** Realizar una 9ª tabla que fuese los detalles de la factura.
---
> **Decisión:** Los números de teléfono de las diferentes tablas cuentan con más carácteres de los necesarios.
> **Por qué:** La norma en España es que un número sea de 9 carácteres o de 12 si contamos el prefijo pero si contamos con números de otros paises, ni los prefijos ni la longitud de los números es la misma.
> **Decisión descartada:** números de teléfono en las tablas de 9 o 12 carácteres.
---
> **Decisión:** Número del ISBN guardado con una longitud de 13 carácteres.
> **Por qué:** Impide que se inserten espacios o guiones para separar puesto que no entraría el ISBN entero sino.
> **Decisión descartada:** ISBN de 17 a 20 carácteres.
## 9. Datos de prueba

Ejemplo de orden a la hora de meter los datos:

### Editorial

Editorial no depende de nada

```sql
insert editorial(nombre,pais,teléfono)
values('editorial pepe','España','976583746'),
('éditions Baguette','Francia','976583746'),
('editora El Bicho','Portugal','215837462');
```
---
### Libro

Libro depende de editorial

```sql
insert libro(isbn,ideditorial,titulo,publicado,paginas,precio,tipo_autor)
values('9788416345276',1,'Rayuela',2014,200,10.34,'principal'),
('9783161484100',3,'Ficciones',2020,200,11.99,'principal'),
('9780143127741',1,'Cuentos de Eva Luna',2000,200,8,'principal'),
('9788437604947',2,'Antología del cuento',2011,200,13.82,'Colaborador'),
('9782070360024',1,'La casa de los espíritus',2007,200,15.80,'principal');
```
---
### Autor

Autor depende de libro

```sql
insert autor(idlibro,nombre,apellidos,nacionalidad,nacimiento)
values(1,'Julio','Cortázar','Francesa','19140826'),
(2,'Jorge Luis','Borges','Argentina','18990824'),
(3,'Isabel','Allende','Chilena','19420802'),
(4,'Julio','Cortázar','Francesa','19140826'),
(4,'Jorge Luis','Borges','Argentina','18990824'),
(5,'Isabel','Allende','Chilena','19420802');
```
---
### Libreria

Librería no depende de nada

```sql
insert libreria(nombre,direccion,telefono,ciudad)
values('libreria centro','calle mayor 2','976123456','zaragoza'),
('libreria ribera','calle alta 14','976123456','zaragoza'),
('libreria universidad','calle baja 5','976123456','zaragoza');
```
---
### Inventario

Inventario depende de libro y de libreria

```sql
insert inventario(idlibro,idlibreria,stock,ultimo_conteo)
values(1,1,8,'20260720'),
(2,1,2,'20260720'),
(3,1,0,'20260720'),
(4,1,4,'20260720'),
(5,1,10,'20260720'),
(1,2,1,'20260720'),
(2,2,5,'20260720'),
(3,2,3,'20260720'),
(4,2,0,'20260720'),
(5,2,9,'20260720'),
(1,3,8,'20260720'),
(2,3,1,'20260720'),
(3,3,6,'20260720'),
(4,3,10,'20260720'),
(5,3,0,'20260720');
```
---
### Empleado

Empleado depende de libreria

```sql
insert empleado(idlibreria,DNI,nombre,apellidos,cargo,fecha_contrato,correo)
values(1,'48372615Z','Laura','Martín Sánchez','librero','20251010','laura.martin92@gmail.com'),
(1,'52719483M','Daniel','Romero López','cajero','20241010','daniel.romero87@hotmail.com'),
(1,'39461827R','Sofía','Navarro Torres','encargado','20220102','sofia.navarro24@gmail.com'),
(2,'71625384T','Alejandro','Ruiz Moreno','librero','20260630','alejandro.ruiz56@hotmail.com'),
(2,'26843591P','Carla','Fernández Vega','cajero','20251119','carla.fernandez31@gmail.com'),
(2,'60517294L','Pablo','Jiménez Castro','encargado','20200303','pablo.jimenez78@hotmail.com'),
(3,'45281936C','Elena','García Molina','librero','20210821','elena.garcia45@gmail.com'),
(3,'18374625H','Marcos','Díaz Herrera','cajero','20260901','marcos.diaz19@hotmail.com'),
(3,'83926147K','Lucía','Ortega Vidal','encargado','20240202','lucia.ortega63@gmail.com');
```
---
### Cliente

Cliente no depende de nada

```sql
insert cliente(nombre,apellidos,correo)
values('Andrea','Sánchez Romero','andrea.sanchez38@gmail.com'),
('Javier','Morales Castillo','javier.morales72@hotmail.com'),
('Andrea','Sánchez Romero','andrea.sanchez38@gmail.com');
```
---
### Socio

Socio depende de cliente

```sql
insert socio(idcliente,telefono,fecha_alta)
values(1,'617111111','20250520'),
(2,null,'20260706');
```
---
### Factura

Factura depende de librería,empleado y cliente

```sql
insert factura(idlibreria,idempleado,idcliente,fecha,tipo_pago,total,estado,detalles_factura)
values(1,2,1,'20261010','efectivo',15.80,'entregado','x1 La casa de los espíritus 15,80'),
(2,5,2,'20260830','tarjeta',20.68,'cancelado','x2 La rayuela 20.68'),
(3,8,3,'20260910','bizum',18.34,'preparado','x1 Cuentos de Eva Luna 8, x1 rayuela 10.34'),
(2,5,1,'20261009','efectivo',13.82,'entregado','x1 Antología del cuento 13.82'),
(3,8,1,'20261010','efectivo',10.34,'entregado','x1 Rayuela 10.34');
```
---

## 10. Consultas de prueba

¿Qué libros tiene la tienda Centro y cuántas copias quedan?

```sql
select t3.titulo, t2.stock from libreria t1 join inventario t2 on t1.idlibreria = t2.idlibreria join libro t3 on t2.idlibro = t3.idlibro where t1.nombre = 'libreria centro';
```
| Titulo | Stock |
|---|---|
| Rayuela | 8 |
| Ficciones | 2 |
| Cuentos de Eva Luna | 0 |
| Antología del cuento | 4 |
| La casa de los espíritus | 10 |

¿Cuánto ha facturado cada tienda este año?


```sql
select t3.titulo, t2.stock from libreria t1 join inventario t2 on t1.idlibreria = t2.idlibreria join libro t3 on t2.idlibro = t3.idlibro where t1.nombre = 'libreria centro';
```
| nombre | total_facturado |
|---|---|
| libreria centro | 15.80 |
| libreria ribera | 34.50 |
| libreria universidad | 28.68 |


¿Qué clientes han hecho más de dos pedidos?

```sql
select t1.nombre, t1.apellidos from cliente t1 join factura t2 on t1.idcliente = t2.idcliente group by t1.idcliente having count(t2.idcliente) > 2;
```
| nombre | apellidos |
|---|---|
| Andrea | Sánchez Romero |

¿Qué libros están agotados en una tienda pero disponibles en otra?

```sql
select t3.titulo from libreria t1 join inventario t2 on t1.idlibreria = t2.idlibreria join libro t3 on t2.idlibro = t3.idlibro where t2.stock = 0 and 
(select s2.stock from libreria s1 join inventario s2 on s1.idlibreria = s2.idlibreria join libro s3 on s2.idlibro = s3.idlibro where s2.idlibro = t2.idlibro and t1.idlibreria != s1.idlibreria limit 1) > 0;
```
| nombre |
|---|
| Cuentos de Eva Luna |
| Antología del cuento |
| AndreLa casa de los espíritusa |


¿Qué empleado ha atendido más pedidos?

```sql
select t1.nombre, t1.apellidos from cliente t1 join factura t2 on t1.idcliente = t2.idcliente group by t1.idcliente having count(t2.idcliente) > 2;
```
| nombre | apellidos |
|---|---|
| Marcos | Díaz Herrera |

¿Qué autores tienen libros en más de una editorial?

```sql
select t3.nombre, t3.apellidos from editorial t1 join libro t2 on t1.ideditorial = t2.ideditorial join autor t3 on t2.idlibro = t3.idlibro group by t3.nombre, t3.apellidos having count(distinct t1.ideditorial) > 1;
```
| nombre | apellidos |
|---|---|
| Jorge Luis | Borges |
| Julio | Cortázar |
## 11. Limitaciones y mejoras futuras