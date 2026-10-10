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

1. Cada libro se identifica por su ISBN, que tiene 13 cifras y no se repite. (§2)
2. Una editorial publica muchos libros; cada libro lo publica una sola editorial. (§2)
3. Un libro puede tener uno o varios autores y un autor puede tener varios libros; en cada libro, el autor consta como principal o como colaborador. (§2)
4. Para cada libro y cada tienda se guarda cuántas copias hay y cuándo se contaron por última vez, en una sola fila por cada pareja libro–tienda. (§3)
5. Si un libro no está en una tienda, no tiene fila en el inventario de esa tienda; si está pero no quedan copias, tiene una fila con 0 copias (agotado). (§3 y hoja de la §8)
6. El número de copias de un libro en una tienda no puede ser negativo. (§3)
7. Una tienda tiene varios empleados; cada empleado trabaja en una sola tienda y, si cambia, solo figura en la nueva. (§4)
8. El cargo de un empleado solo puede ser librero, cajero o encargado, y su DNI no se repite. (§4)
9. Todo cliente, sea socio o no, se registra con su nombre y su correo; el correo no se puede repetir y el teléfono es opcional. (§5)
10. Un cliente es socio si tiene fecha de alta; el que no es socio no la tiene. (§5)
11. Cada pedido se hace en una sola tienda, lo atiende un solo empleado y lo compra un solo cliente. (§6)
12. Todo pedido tiene fecha, una forma de pago (efectivo, tarjeta o bizum) y un estado (preparado, entregado o cancelado). (§6)
13. Un pedido incluye uno o varios libros distintos y, de cada uno, la cantidad pedida, que es como mínimo 1. (§6)
14. Cada línea de pedido guarda el precio que se cobró realmente por el libro; ese precio no cambia aunque después cambie el precio de catálogo y no puede ser negativo. (§6)
15. El total de un pedido no se guarda: se calcula sumando cantidad × precio cobrado de todas sus líneas. (§6)

## 4. Diagrama entidad-relación

## 5. Modelo lógico

## 6. Script SQL (schema.sql)

¡