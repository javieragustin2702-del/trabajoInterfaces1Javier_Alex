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
### Librería
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `nombre` | `VARCHAR(45)` | Sí | Nombre de la librería |
| `dirección` | `VARCHAR(45)` | Sí | Direccíon  de la librería para poder localizarla |
| `teléfono` | `VARCHAR(15)` | Sí | Teléfono de la librería. Cuenta con más de 9 carácteres por los prefijos y números más largos |
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
| `estado` | `ENUM('preparado','entregado','cancelado)` | Sí | Estado en el que se encuentra lo comprado por el cliente |
| `detalles_factura` | VARCHAR(5000) | Si | Los diferentes artículos comprados por el cliente |
---
## 8. Decisiones de diseño

## 9. Datos de prueba

## 10. Consultas de prueba

## 11. Limitaciones y mejoras futuras