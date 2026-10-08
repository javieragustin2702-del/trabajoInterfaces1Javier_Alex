## 7. Diccionario de datos
Elementos o columnas con las que cuentan las tablas(a excepción del id de cada tabla):
### Editorial
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `nombre` | `VARCHAR(45)` | Sí | Nombre de la editorial |
| `pais` | `VARCHAR(45)` | Sí | Pais de la sucursal de la editorial |
| `teléfono` | `VARCHAR(15)` | Sí | Teléfono de la editorial. Cuenta con más de 9 carácteres por los prefijos y números más largos |
---
### Libro
| Columna | Tipo | Obligatorio | Descripción |
|---|---|:---:|---|
| `ISBN` | `VARCHAR(13)` | Sí | Código de identificación y único de cada libro. Formato de 13 carácteres debido a que es un estándar |
| `ideditorial` | `INT` | Sí | Identificador correspondiente a la editorial que distribuye el libro |
| `titulo` | `VARCHAR(45)` | Sí | Título del libro |
| `publicado` | `YEAR` | Sí | Fecha de lanzamiento de la edición del libro |
| `páginas` | `INT` | Sí | Cantidad de páginas que tiene el libro |
| `precio` | `DECIMAL(5,2)` | Sí | Precio del libro, esperando que no haya ningún libro que haya que insertar que cuesta más de 1000€ |
| `tipo_autor` | `VARCHAR(45)` | Sí | Título del libro |

## 8. Decisiones de diseño

## 9. Datos de prueba

## 10. Consultas de prueba

## 11. Limitaciones y mejoras futuras