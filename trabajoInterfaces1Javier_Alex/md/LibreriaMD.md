# Base de datos de Páginas de Villa Serena

## 1. Resumen del caso
Páginas de Villa Serena es una librería que abrió hace veinte años como una pequeña tienda de barrio y que hoy tiene tres tiendas: Centro, Ribera y Universidad. Su dueña, Elena Ruiz, nos ha encargado una base de datos para llevar el negocio de forma ordenada.

Ahora mismo cada tienda lleva su propia hoja de cálculo y la información no coincide con la realidad. Por ejemplo, un cliente quiso Cien años de soledad, la hoja decía que había tres copias y en la estantería no había ninguna, porque estaban todas en otra tienda. Además, cuando Elena sube el precio de un libro, los pedidos antiguos pasan a mostrar el precio nuevo y las facturas dejan de cuadrar.


### 2.1 Entidades y atributos

| Entidad | Atributos | Dónde sale |
| :---- | :---- | :---- |
| Tienda | nombre, dirección, teléfono, ciudad | §1 |
| Editorial | nombre, país, teléfono | §2 |
| Libro | ISBN, título, año de publicación, páginas, precio de catálogo | §2 |
| Autor | nombre, nacionalidad, año de nacimiento | §2 |
| Autoría (autor–libro) | rol (principal o colaborador) | §2 |
| Inventario (tienda–libro) | copias, fecha del último conteo | §3 |
| Empleado | DNI, nombre, apellidos, cargo, fecha de contratación, correo | §4 |
| Cliente | nombre, correo, teléfono (opcional), fecha de alta (solo socios) | §5 |
| Pedido | número, fecha, forma de pago, estado | §6 |
| Línea de pedido (pedido–libro) | cantidad, precio cobrado | §6 |

### 2.2 Relaciones

| Relación | Cardinalidad | Razonamiento |
| :---- | :---- | :---- |
| Editorial – Libro | 1:N | Una editorial publica muchos libros; cada libro, una sola editorial (§2). |
| Autor – Libro | N:M | Un libro puede tener varios autores y un autor varios libros. Se resuelve con Autoría (§2). |
| Tienda – Libro | N:M | Un libro puede estar en varias tiendas y una tienda tiene muchos libros. Se resuelve con Inventario (§3). |
| Tienda – Empleado | 1:N | Una tienda tiene varios empleados; cada empleado trabaja en una sola (§4). |
| Tienda – Pedido | 1:N | Un pedido se hace en una sola tienda; una tienda tiene muchos pedidos (§6). |
| Empleado – Pedido | 1:N | Un empleado atiende muchos pedidos; cada pedido lo atiende uno (§6). |
| Cliente – Pedido | 1:N | Un cliente hace muchos pedidos; cada pedido es de un cliente (§6). |
| Pedido – Libro | N:M | Un pedido lleva varios libros y un libro está en muchos pedidos. Se resuelve con Línea de pedido (§6). |

### 2.3 Datos descartados

| Dato | Motivo |
| :---- | :---- |
| Total del pedido y subtotales del ticket | Se calculan: cantidad × precio cobrado. |
| Nombre de la tienda, del empleado y del cliente en el ticket | Ya están en sus propias tablas. |
| «Stock» dentro del libro | Depende de la tienda, así que se guarda en Inventario. |
| «Cortázar / Borges» en una sola celda | Se guarda un autor por fila, unido al libro con Autoría. |
| Editorial repetida en cada fila de la hoja | Se guarda una vez y los libros apuntan a ella. |
| Historial de empleados | Elena solo quiere que figure en la tienda nueva (§4). |

## 3. Reglas de negocio



## 4. Diagrama entidad-relación

## 5. Modelo lógico

## 6. Script SQL (schema.sql)

¡