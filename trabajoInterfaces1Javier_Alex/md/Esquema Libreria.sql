CREATE DATABASE  IF NOT EXISTS `libreria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `libreria`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: libreria
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idautor` int NOT NULL AUTO_INCREMENT,
  `idlibro` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `nacimiento` date NOT NULL,
  PRIMARY KEY (`idautor`),
  KEY `fk_autor_idlibro_idx` (`idlibro`),
  CONSTRAINT `fk_autor_idlibro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idcliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editorial` (
  `ideditorial` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `teléfono` varchar(15) NOT NULL,
  PRIMARY KEY (`ideditorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idempleado` int NOT NULL AUTO_INCREMENT,
  `idlibreria` int NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `cargo` enum('librero','cajero','encargado') NOT NULL,
  `fecha_contrato` date NOT NULL,
  `correo` varchar(100) NOT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `fk_empleado_idlibreria_idx` (`idlibreria`),
  CONSTRAINT `fk_empleado_idlibreria` FOREIGN KEY (`idlibreria`) REFERENCES `libreria` (`idlibreria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idfactura` int NOT NULL AUTO_INCREMENT,
  `idlibreria` int NOT NULL,
  `idempleado` int NOT NULL,
  `idcliente` int NOT NULL,
  `fecha` date NOT NULL,
  `tipo_pago` enum('efectivo','tarjeta','bizum') NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` enum('preparado','entregado','cancelado') NOT NULL,
  `detalles_factura` varchar(5000) NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `fk_factura_idlibreria_idx` (`idlibreria`),
  KEY `fk_factura_idempleado_idx` (`idempleado`),
  KEY `fk_factura_idcliente_idx` (`idcliente`),
  CONSTRAINT `fk_factura_idcliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_factura_idempleado` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`),
  CONSTRAINT `fk_factura_idlibreria` FOREIGN KEY (`idlibreria`) REFERENCES `libreria` (`idlibreria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `idinventario` int NOT NULL AUTO_INCREMENT,
  `idlibro` int NOT NULL,
  `idlibreria` int NOT NULL,
  `stock` int NOT NULL,
  `ultimo_conteo` date NOT NULL,
  PRIMARY KEY (`idinventario`),
  KEY `fk_inventario_idlibreria_idx` (`idlibreria`),
  KEY `fk_inventario_idlibro_idx` (`idlibro`),
  CONSTRAINT `fk_inventario_idlibreria` FOREIGN KEY (`idlibreria`) REFERENCES `libreria` (`idlibreria`),
  CONSTRAINT `fk_inventario_idlibro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libreria`
--

DROP TABLE IF EXISTS `libreria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libreria` (
  `idlibreria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY (`idlibreria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libreria`
--

LOCK TABLES `libreria` WRITE;
/*!40000 ALTER TABLE `libreria` DISABLE KEYS */;
/*!40000 ALTER TABLE `libreria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idlibro` int NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(13) NOT NULL,
  `ideditorial` int NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `publicado` year NOT NULL,
  `paginas` int NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `tipo_autor` enum('Principal','colaborador') NOT NULL,
  PRIMARY KEY (`idlibro`),
  UNIQUE KEY `ISBN_UNIQUE` (`ISBN`),
  KEY `fk_libro_ideditorial_idx` (`ideditorial`),
  CONSTRAINT `fk_libro_ideditorial` FOREIGN KEY (`ideditorial`) REFERENCES `editorial` (`ideditorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socio` (
  `idsocio` int NOT NULL AUTO_INCREMENT,
  `idcliente` int NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha_alta` date NOT NULL,
  PRIMARY KEY (`idsocio`),
  KEY `fk_socio_idcliente_idx` (`idcliente`),
  CONSTRAINT `fk_socio_idcliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

insert editorial(nombre,pais,teléfono)
values('editorial pepe','España','976583746'),
('éditions Baguette','Francia','976583746'),
('editora El Bicho','Portugal','215837462');

insert libro(isbn,ideditorial,titulo,publicado,paginas,precio,tipo_autor)
values('9788416345276',1,'Rayuela',2014,200,10.34,'principal'),
('9783161484100',3,'Ficciones',2020,200,11.99,'principal'),
('9780143127741',1,'Cuentos de Eva Luna',2000,200,8,'principal'),
('9788437604947',2,'Antología del cuento',2011,200,13.82,'Colaborador'),
('9782070360024',1,'La casa de los espíritus',2007,200,15.80,'principal');

insert autor(idlibro,nombre,apellidos,nacionalidad,nacimiento)
values(1,'Julio','Cortázar','Francesa','19140826'),
(2,'Jorge Luis','Borges','Argentina','18990824'),
(3,'Isabel','Allende','Chilena','19420802'),
(4,'Julio','Cortázar','Francesa','19140826'),
(4,'Jorge Luis','Borges','Argentina','18990824'),
(5,'Isabel','Allende','Chilena','19420802');

insert libreria(nombre,direccion,telefono,ciudad)
values('libreria centro','calle mayor 2','976123456','zaragoza'),
('libreria ribera','calle alta 14','976123456','zaragoza'),
('libreria universidad','calle baja 5','976123456','zaragoza');

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

insert cliente(nombre,apellidos,correo)
values('Andrea','Sánchez Romero','andrea.sanchez38@gmail.com'),
('Javier','Morales Castillo','javier.morales72@hotmail.com'),
('Andrea','Sánchez Romero','andrea.sanchez38@gmail.com');

insert socio(idcliente,telefono,fecha_alta)
values(1,'617111111','20250520'),
(2,null,'20260706');

insert factura(idlibreria,idempleado,idcliente,fecha,tipo_pago,total,estado,detalles_factura)
values(1,2,1,'20261010','efectivo',15.80,'entregado','x1 La casa de los espíritus 15,80'),
(1,2,2,'20260830','tarjeta',20.68,'cancelado','x2 La rayuela 20.68'),
(3,8,3,'20260910','bizum',18.34,'preparado','x1 Cuentos de Eva Luna 8, x1 rayuela 10.34'),
(1,2,2,'20261009','efectivo',13.82,'entregado','x1 Antología del cuento 13.82'),
(3,8,1,'20261010','efectivo',10.34,'entregado','x1 Rayuela 10.34');