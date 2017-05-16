-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: kyrsach
-- ------------------------------------------------------
-- Server version	5.1.53-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dogovor`
--

DROP TABLE IF EXISTS `dogovor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dogovor` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `data_zakl_dog` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `period_dog` varchar(10) NOT NULL DEFAULT '',
  `idUslugi` int(10) unsigned NOT NULL DEFAULT '0',
  `idClient` int(10) unsigned NOT NULL DEFAULT '0',
  `idAgent` int(10) unsigned NOT NULL DEFAULT '0',
  `stoimost_dog` float NOT NULL DEFAULT '0',
  `nomer` int(10) unsigned NOT NULL DEFAULT '0',
  `id_zayvka` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_dogovor_1` (`id_zayvka`),
  CONSTRAINT `FK_dogovor_1` FOREIGN KEY (`id_zayvka`) REFERENCES `zayvka` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogovor`
--

LOCK TABLES `dogovor` WRITE;
/*!40000 ALTER TABLE `dogovor` DISABLE KEYS */;
INSERT INTO `dogovor` VALUES (2,'2016-12-20 00:00:00','1 god',1,3,2,500,21,1),(3,'2016-11-15 00:00:00','10 let',2,4,6,10000,13,2),(4,'2016-12-12 00:00:00','5 let',3,5,7,7500,14,3),(5,'2016-11-05 00:00:00','3 goda',2,4,2,3000,25,4),(6,'2016-08-25 00:00:00','1 god',4,5,6,2000,28,5),(7,'2017-01-30 00:00:00','2 goda',1,3,3,1000,1,6);
/*!40000 ALTER TABLE `dogovor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25  1:04:48
