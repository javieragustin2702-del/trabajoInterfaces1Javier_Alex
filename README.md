# Manual de despliegue

## Objetivo

El manual enseña como instalar el programa asi como a configurarlo y mantenerlo

## Que se necesita

| Software | Versión | Función |
|---|---|---|
| Windows 10 | 10 Home 22H2 | Sistema operativo |
| JDK | 21.0.11 | Compila y ejecuta |
| Eclipse | 2026-09 | Abre y compila el pproyecto |
| MYSQL | 8.0.46 | Una de las bases de datos |
| Git | 2.56.0 | Clona el repositorio |

## Instalaciones necesarias

1. Descargamos el **Eclipse IDE for Java Developers** y descomprime el archivo descargado. Luego crea una carpeta que sirva de espacio de trabajo para el eclipse
2. Descarga e istala el JDK 21.0.11
3. Descarga MYSQL, elige la instalación **Custom**. En la instalación custom elige el server 8.0.46 y el workbench 8.0.47, usa las contraseñas de legado y pon una contraseña y guardala para el **.env** de después
4. Descarga e instala Git.
5. comprueba que todo puede ser gestionado con el powershell haciendo **-java version**,**--sql version**,**--git version**. Si no funciona alguno ves a la variables de entorno y añade a la variable **Path** la ruta del archivo **bin** del programa

## Estructura del proyecto


## Obtención del código

Ves a **Code**,copia el enlace que sale,ves a la carpeta del espacio de trabajo para el eclipse,escribe **powershell** en la ruta del archivo y escribe **git clone**. Abre el eclipse e importa el proyecto como un proyecto ya existente en el ordenador

## Librerías

Hay 2 que son el dotenv-java-3.2.0 para leer y manejar el **.env**  y el mysql-connector-j.26.7.0 que conecta java con MYSQL y permite la gestión de la base de datos. No hay que configurar las rutas de la librerias ya que usa la ruta dentro del proyecto

## Inicialización de la base de datos

En este apartado usaremos el script de sql “Esquema Libreria.sql” ubicado en trabajoInterfaces1Javier_Alex\trabajoInterfaces1Javier_Alex\md (es la ruta relativa del proyecto) y lo insertaremos a la base de datos desde MySQL Workbench.

## Configuración con .env

| Nombre | Funcion |
|---|---|
| DB_URL | Donde se ubique la base de datos |
| DB_USER | El usuario usado |
| DB_PASS | La contraseña |

## Arranque de la aplicación

Usaremos eclipse en vez de Netbeans por que es el que hemos usado en todo el proyecto. Usaremos Project → Clean, es importante que Build Automatically este importante.
Con esto ya funcionara

## Comprobación del despliegue

Comprobaremos que el programa funciona perfectamente

## Administración

Crearemos una carpeta que se llame backups
Para crear un backup usaremos --> mysqldump -u root -p --result-file=C:\backups\libreria_corta2026-10-25.sql libreria_corta 

Para restaurar el backup usaremos --> mysql -u root -p < C:\backups\libreria_corta2026-10-25.sql libreria_corta

Volveremos a los datos iniciales --> mysql -u root -p < "trabajoInterfaces1Javier_Alex\esquema libreria tarea 1.sql"

Abriremos el directorio desde la cmd y usaremos el comando copy luego con dir comprobaremos que se haya copiado bien

Ejecutaremos el programa y el daremos a la opcion 8.

## Posibles errores y soluciones

| Error | Causa | Solución |
|---|---|---|
| io.github.cdimascio.dotenv.DotenvException: | No existe o no encuentra el .env | Abrir la carpeta de la raíz del archivo y comprobar o crear el “.env”. |
| java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES) | Error en la contraseña del .env | Poner la contraseña correcta. |
| java.sql.SQLSyntaxErrorException: Unknown database | No encuentra la base de datos | Pasar el Script de la base de datos |
| No suitable driver found for jdbc:mysql://localhost:3306/interfaces1 | Se eliminó del proyecto la librería que permitía la conexión con la base de datos | Poner el el buildpath la librería otra vez o volver a clonar el repositorio |
| mysql no se reconoce como comando en powershell | No se añadió su variable de entorno al path | Añadir al path la ruta del bin |
| java.lang.NumberFormatException | Se puso por consola algo que no era un número cuando pedían un número | Poner un número en vez de otra cosa |
| mysqldump: Can't create/write to file 'C:\libreria_corta_2026-10-25' (OS errno 13 - Permission denied) | Se intenta crear fuera del usuario y windows no acepta la creación de la carpeta fuera del usuario | Crear la copia de seguridad dentro del usuario |
| The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server. (Error que sale en el Eclipse a la hora de pedirle una conexión a mysql) | El MYSQL80 no está ejecutándose | Ir a servicios e iniciar el servicio |
