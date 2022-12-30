-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: productos
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproducto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Media Bob Sponja',1200,12,'Medias con la imagen de Bob Sponja','./img/mediasBobSponja.webp'),(2,'Media El Padrino',1200,8,'Medias con la imagen de El Padrino','./img/mediasElPadrino.webp'),(5,'Medias Scooby Doo',1200,30,'Medias con la imagen de Scooby Doo','./img/mediasScoobyDoo.webp'),(9,'Medias Venom',1200,11,'Medias con la imagen de Venom','./img/mediasVenom.webp'),(10,'Medias Batman',1200,22,'Medias con la imagen de Batman','./img/mediasBatman.webp'),(11,'Medias Astronautas',1200,4,'Medias con la imagen de astronautas','./img/mediasAstronautas.webp'),(12,'Medias Dinosaurios',1200,15,'Medias con la imagen de Dinosaurios','./img/mediasDinosaurios.webp'),(13,'Medias Pizza',1200,2,'Medias con la imagen de Pizzas','./img/mediasPizza.webp'),(14,'Medias Cerveza',1200,13,'Medias con imagen de Cerveza','./img/mediasCerveza.webp'),(15,'Medias Gatos',1200,24,'Medias con imagen de Gatos','./img/mediasGatos.webp'),(19,'Media de Star Wars',1200,9,'Medias con imagen de Star Wars','./img/mediasStarWars.webp'),(20,'Media de Rick And Morty',1200,7,'Medias con imagen de Rick And Morty','./img/mediasRickAndMorty.webp');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-30 19:05:27
