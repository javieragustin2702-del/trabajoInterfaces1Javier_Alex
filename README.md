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