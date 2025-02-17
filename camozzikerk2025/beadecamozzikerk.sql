-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: beadecamozzikerk
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Dumping data for table `camiones`
--

LOCK TABLES `camiones` WRITE;
/*!40000 ALTER TABLE `camiones` DISABLE KEYS */;
INSERT INTO `camiones` VALUES (2,'AB8510CP','Ford',1976,4),(3,'AB7540CO','Ford',1958,5),(4,'AB8810YT','Dodge',2012,2),(5,'AB7548OP','Chevrolet',2020,9);
/*!40000 ALTER TABLE `camiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (2,'Buenos Aires Capital',1000,1,0,0),(3,'La Plata',1900,2,0,0),(4,'Mar del Plata',7600,2,0,0),(5,'Bahía Blanca',8000,2,0,0),(6,'San Fernando del Valle de Catamarca',4700,3,0,0),(7,'Andalgalá',4707,3,0,0),(8,'Belén',4705,3,0,0),(9,'Resistencia',3500,4,0,0),(10,'Presidencia Roque Sáenz Peña',3700,4,0,0),(11,'Villa Ángela',3540,4,0,0),(12,'Rawson',9103,5,0,0),(13,'Comodoro Rivadavia',9000,5,0,0),(14,'Trelew',9100,5,0,0),(15,'Puerto Madryn',9200,5,0,0),(16,'Córdoba',5000,6,0,0),(17,'Villa María',5900,6,0,0),(18,'Río Cuarto',5800,6,0,0),(19,'Corrientes',3400,7,0,0),(20,'Goya',3450,7,0,0),(21,'Mercedes',3480,7,0,0),(22,'Paraná',3100,8,0,0),(23,'Concordia',3200,8,0,0),(24,'Gualeguaychú',3260,8,0,0),(25,'Formosa',3600,9,0,0),(26,'Clorinda',3610,9,0,0),(27,'San Salvador de Jujuy',4600,10,0,0),(28,'Palpalá',4606,10,0,0),(29,'Tilcara',4624,10,0,0),(30,'Santa Rosa',6300,11,0,0),(31,'General Pico',6360,11,0,0),(32,'La Rioja',5300,12,0,0),(33,'Chilecito',5360,12,0,0),(34,'Mendoza',5500,13,0,0),(35,'San Rafael',5584,13,0,0),(36,'Posadas',3300,14,0,0),(37,'Eldorado',3360,14,0,0),(38,'Neuquén',8300,15,0,0),(39,'San Martín de los Andes',8370,15,0,0),(40,'Viedma',8500,16,0,0),(41,'San Carlos de Bariloche',8400,16,0,0),(42,'Salta',4400,17,0,0),(43,'Orán',4530,17,0,0),(44,'San Juan',5400,18,0,0),(45,'Caucete',5460,18,0,0),(46,'San Luis',5700,19,0,0),(47,'Villa Mercedes',5730,19,0,0),(48,'Río Gallegos',9400,20,0,0),(49,'Caleta Olivia',9011,20,0,0),(50,'Santa Fe',3000,21,0,0),(51,'Rosario',2000,21,0,0),(52,'Santa Clara de Buena Vista',2258,21,0,0),(53,'López',2255,21,0,0),(54,'Esperanza',3080,21,0,0),(55,'Rafaela',2300,21,0,0),(56,'Santiago del Estero',4200,22,0,0),(57,'La Banda',4230,22,0,0),(58,'Ushuaia',9410,23,0,0),(59,'Río Grande',9420,23,0,0),(60,'San Miguel de Tucumán',4000,24,0,0),(61,'Concepción',4146,24,0,0);
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Kerk',12321312,'ssss','2sda@sdsa'),(2,'Guindon',38977934,'Caterina','guindoncaterina2@gmail.com'),(3,'Leiva',52871441,'Mauri','mauri@gmail.com'),(4,'Guindon',45641545,'Caterina','cate@gmail.com'),(5,'Tati',123456789,'Tati','tati@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `paquete`
--

LOCK TABLES `paquete` WRITE;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` VALUES (1,_binary '\0',213,2,11,3,1),(2,_binary '',300,4,6,2,2),(3,_binary '',800,2,14,4,4),(4,_binary '\0',1500,2,52,3,2),(5,_binary '',780,2,14,3,2),(6,_binary '\0',111111,1,12,3,2),(7,_binary '\0',780,2,15,3,2);
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Ciudad Autónoma de Buenos Aires'),(2,'Buenos Aires'),(3,'Catamarca'),(4,'Chaco'),(5,'Chubut'),(6,'Córdoba'),(7,'Corrientes'),(8,'Entre Ríos'),(9,'Formosa'),(10,'Jujuy'),(11,'La Pampa'),(12,'La Rioja'),(13,'Mendoza'),(14,'Misiones'),(15,'Neuquén'),(16,'Río Negro'),(17,'Salta'),(18,'San Juan'),(19,'San Luis'),(20,'Santa Cruz'),(21,'Santa Fe'),(22,'Santiago del Estero'),(23,'Tierra del Fuego, Antártida e Islas del Atlántico Sur'),(24,'Tucumán');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-16  1:31:51
