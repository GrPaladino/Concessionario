CREATE DATABASE  IF NOT EXISTS `concessionario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `concessionario`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: concessionario
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `accessori`
--

DROP TABLE IF EXISTS `accessori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessori` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessori`
--

LOCK TABLES `accessori` WRITE;
/*!40000 ALTER TABLE `accessori` DISABLE KEYS */;
INSERT INTO `accessori` VALUES (1,'abs'),(2,'adas'),(3,'aria condizionata'),(4,'antifurto'),(5,'sensori di parcheggio'),(6,'retrocamera'),(7,'navigatore'),(8,'cruise control adattivo'),(9,'cruise control'),(10,'park assist'),(11,'monitoraggio angolo cieco'),(12,'ruota di scorta'),(13,'fari a led'),(14,'infotainment'),(15,'sedili riscaldati'),(16,'volante riscaldato'),(17,'interni in pelle'),(18,'sedili ventilati'),(19,'mantenitore di corsia'),(20,'frenata automatica di emergenza'),(21,'head-up display'),(22,'sistema keyless'),(23,'start&stop'),(24,'rear cross traffic alert'),(25,'vetri oscurati'),(26,'sospensioni adattive'),(27,'sensore pioggia'),(28,'volante multifunzione'),(29,'bracciolo centrale'),(30,'usb/bluetooth'),(31,'apple carplay'),(32,'android auto'),(33,'gomme invernali');
/*!40000 ALTER TABLE `accessori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accessorio_automobile`
--

DROP TABLE IF EXISTS `accessorio_automobile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accessorio_automobile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `automobile_id` int NOT NULL,
  `accessorio_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accessorio_automobile_ibfk_2` (`accessorio_id`),
  KEY `accessorio_automobile_ibfk_1` (`automobile_id`),
  CONSTRAINT `accessorio_automobile_ibfk_1` FOREIGN KEY (`automobile_id`) REFERENCES `automobili` (`id`),
  CONSTRAINT `accessorio_automobile_ibfk_2` FOREIGN KEY (`accessorio_id`) REFERENCES `accessori` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=520 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessorio_automobile`
--

LOCK TABLES `accessorio_automobile` WRITE;
/*!40000 ALTER TABLE `accessorio_automobile` DISABLE KEYS */;
INSERT INTO `accessorio_automobile` VALUES (20,2,1),(21,2,8),(22,2,9),(23,2,10),(24,2,11),(25,2,12),(26,2,13),(27,2,14),(28,2,15),(29,2,16),(30,2,17),(31,2,18),(32,2,19),(33,2,20),(34,2,21),(35,2,25),(36,2,26),(37,2,27),(38,2,28),(39,2,29),(40,2,30),(41,2,31),(42,2,32),(43,3,1),(44,3,2),(45,3,3),(46,3,4),(47,3,5),(48,3,6),(49,3,7),(50,3,8),(51,3,9),(52,3,10),(53,3,11),(54,3,12),(55,3,13),(56,3,30),(57,3,31),(58,3,32),(59,4,1),(60,4,2),(61,4,3),(62,4,4),(63,4,5),(64,4,6),(65,4,7),(66,4,8),(67,4,9),(68,4,10),(69,4,11),(70,4,12),(71,4,13),(72,4,16),(73,4,17),(74,4,18),(75,4,19),(76,4,20),(77,4,21),(78,4,22),(79,4,23),(80,4,24),(81,4,25),(82,4,26),(83,4,27),(84,4,28),(85,4,32),(86,5,1),(87,5,2),(88,5,5),(89,5,6),(90,5,7),(91,5,8),(92,5,9),(93,5,10),(94,5,11),(95,5,12),(96,5,13),(97,5,14),(98,5,15),(99,5,16),(100,5,17),(101,5,22),(102,5,23),(103,5,24),(104,5,25),(105,5,26),(106,5,27),(107,5,28),(108,5,29),(109,5,30),(110,5,31),(111,5,32),(112,6,1),(113,6,2),(114,6,3),(115,6,4),(116,6,5),(117,6,6),(118,6,7),(119,6,8),(120,6,9),(121,6,10),(122,6,11),(123,6,12),(124,6,16),(125,6,17),(126,6,18),(127,6,19),(128,6,20),(129,6,21),(130,6,22),(131,6,23),(132,6,27),(133,6,28),(134,6,29),(135,6,30),(136,6,31),(137,6,32),(138,7,1),(139,7,2),(140,7,3),(141,7,4),(142,7,5),(143,7,6),(144,7,7),(145,7,8),(146,7,9),(147,7,10),(148,7,11),(149,7,12),(150,7,13),(151,7,14),(152,7,15),(153,7,16),(154,7,17),(155,7,18),(156,7,19),(157,7,20),(158,7,21),(159,7,22),(160,7,23),(161,7,24),(162,7,25),(163,7,26),(164,7,27),(165,7,28),(166,7,29),(167,7,30),(168,7,31),(169,7,32),(170,8,1),(171,8,2),(172,8,3),(173,8,4),(174,8,5),(175,8,6),(176,8,7),(177,8,8),(178,8,25),(179,8,26),(180,8,27),(181,8,28),(182,8,29),(183,8,30),(184,8,31),(185,8,32),(186,9,1),(187,9,2),(188,9,3),(189,9,4),(190,9,5),(191,9,6),(192,9,7),(193,9,8),(194,9,9),(195,9,14),(196,9,15),(197,9,16),(198,9,17),(199,9,18),(200,9,19),(201,9,20),(202,9,21),(203,9,22),(204,9,23),(205,9,24),(206,9,25),(207,9,26),(208,9,27),(209,9,28),(210,9,29),(211,10,1),(212,10,2),(213,10,3),(214,10,4),(215,10,5),(216,10,6),(217,10,7),(218,10,8),(219,10,9),(220,10,10),(221,10,11),(222,10,12),(223,10,13),(224,10,30),(225,10,31),(226,10,32),(227,11,1),(228,11,8),(229,11,9),(230,11,10),(231,11,11),(232,11,12),(233,11,13),(234,11,14),(235,11,15),(236,11,16),(237,11,17),(238,11,18),(239,11,19),(240,11,20),(241,11,21),(242,11,25),(243,11,26),(244,11,27),(245,11,28),(246,11,29),(247,11,30),(248,11,31),(249,11,32),(250,12,1),(251,12,2),(252,12,3),(253,12,4),(254,12,5),(255,12,6),(256,12,7),(257,12,8),(258,12,9),(259,12,10),(260,12,11),(261,12,12),(262,12,13),(263,12,30),(264,12,31),(265,12,32),(266,13,1),(267,13,2),(268,13,3),(269,13,4),(270,13,5),(271,13,6),(272,13,7),(273,13,8),(274,13,9),(275,13,10),(276,13,11),(277,13,12),(278,13,13),(279,13,30),(280,13,31),(281,13,32),(282,14,1),(283,14,2),(284,14,3),(285,14,4),(286,14,5),(287,14,6),(288,14,7),(289,14,8),(290,14,9),(291,14,10),(292,14,11),(293,14,12),(294,14,13),(295,14,16),(296,14,17),(297,14,18),(298,14,19),(299,14,20),(300,14,21),(301,14,22),(302,14,23),(303,14,24),(304,14,25),(305,14,26),(306,14,27),(307,14,28),(308,14,32),(309,15,1),(310,15,2),(311,15,5),(312,15,6),(313,15,7),(314,15,8),(315,15,9),(316,15,10),(317,15,11),(318,15,12),(319,15,13),(320,15,14),(321,15,15),(322,15,16),(323,15,17),(324,15,22),(325,15,23),(326,15,24),(327,15,25),(328,15,26),(329,15,27),(330,15,28),(331,15,29),(332,15,30),(333,15,31),(334,15,32),(335,16,1),(336,16,2),(337,16,3),(338,16,4),(339,16,5),(340,16,6),(341,16,7),(342,16,8),(343,16,9),(344,16,10),(345,16,11),(346,16,12),(347,16,16),(348,16,17),(349,16,18),(350,16,19),(351,16,20),(352,16,21),(353,16,22),(354,16,23),(355,16,27),(356,16,28),(357,16,29),(358,16,30),(359,16,31),(360,16,32),(361,17,1),(362,17,2),(363,17,3),(364,17,4),(365,17,5),(366,17,6),(367,17,7),(368,17,8),(369,17,9),(370,17,10),(371,17,11),(372,17,12),(373,17,13),(374,17,14),(375,17,15),(376,17,16),(377,17,17),(378,17,18),(379,17,19),(380,17,20),(381,17,21),(382,17,22),(383,17,23),(384,17,24),(385,17,25),(386,17,26),(387,17,27),(388,17,28),(389,17,29),(390,17,30),(391,17,31),(392,17,32),(393,18,1),(394,18,2),(395,18,3),(396,18,4),(397,18,5),(398,18,6),(399,18,7),(400,18,8),(401,18,25),(402,18,26),(403,18,27),(404,18,28),(405,18,29),(406,18,30),(407,18,31),(408,18,32),(409,19,1),(410,19,2),(411,19,3),(412,19,4),(413,19,5),(414,19,6),(415,19,7),(416,19,8),(417,19,9),(418,19,14),(419,19,15),(420,19,16),(421,19,17),(422,19,18),(423,19,19),(424,19,20),(425,19,21),(426,19,22),(427,19,23),(428,19,24),(429,19,25),(430,19,26),(431,19,27),(432,19,28),(433,19,29),(434,20,1),(435,20,2),(436,20,3),(437,20,4),(438,20,5),(439,20,6),(440,20,7),(441,20,8),(442,20,9),(443,20,14),(444,20,15),(445,20,16),(446,20,17),(447,20,18),(448,20,19),(449,20,20),(450,20,21),(451,20,22),(452,20,23),(453,20,24),(454,20,25),(455,20,26),(456,20,27),(457,20,28),(458,20,29),(481,1,1),(482,1,2),(483,1,3),(484,1,4),(485,1,5),(486,1,6),(487,1,7),(488,1,8),(489,1,9),(490,1,10),(491,1,11),(492,1,12),(493,1,13),(495,21,1),(496,21,2),(497,21,3),(498,21,4),(499,21,5),(500,21,6),(501,21,7),(502,21,8),(503,21,9),(504,21,10),(505,21,11),(506,21,12),(507,21,13);
/*!40000 ALTER TABLE `accessorio_automobile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `automobile_motore`
--

DROP TABLE IF EXISTS `automobile_motore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automobile_motore` (
  `id` int NOT NULL AUTO_INCREMENT,
  `automobile_id` int NOT NULL,
  `motore_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `automobile_motore_ibfk_2` (`motore_id`),
  KEY `automobile_motore_ibfk_1` (`automobile_id`),
  CONSTRAINT `automobile_motore_ibfk_1` FOREIGN KEY (`automobile_id`) REFERENCES `automobili` (`id`),
  CONSTRAINT `automobile_motore_ibfk_2` FOREIGN KEY (`motore_id`) REFERENCES `motori` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=585 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobile_motore`
--

LOCK TABLES `automobile_motore` WRITE;
/*!40000 ALTER TABLE `automobile_motore` DISABLE KEYS */;
INSERT INTO `automobile_motore` VALUES (44,1,8),(45,1,9),(46,2,1),(47,2,5),(48,2,6),(49,3,3),(50,3,6),(51,4,2),(52,4,3),(53,5,4),(54,5,9),(55,6,8),(56,6,9),(57,7,2),(58,7,3),(59,7,7),(60,8,3),(61,8,6),(62,8,7),(63,9,2),(64,9,4),(65,9,9),(66,10,6),(67,10,7),(85,18,2),(86,18,7),(87,18,9),(88,19,1),(89,19,5),(90,19,6),(91,20,4),(92,20,7),(95,1,8),(96,1,9),(97,2,1),(98,2,5),(99,2,6),(100,3,3),(101,3,6),(102,4,2),(103,4,3),(104,5,4),(105,5,9),(106,6,8),(107,6,9),(108,7,2),(109,7,3),(110,7,7),(111,8,3),(112,8,6),(113,8,7),(114,9,2),(115,9,4),(116,9,9),(117,10,6),(118,10,7),(119,11,2),(120,11,4),(121,11,7),(122,12,1),(123,12,3),(124,13,1),(125,13,5),(126,13,9),(127,14,5),(128,14,6),(129,15,1),(130,15,5),(131,15,6),(132,16,2),(133,16,6),(134,17,2),(135,17,4),(136,18,2),(137,18,7),(138,18,9),(139,19,1),(140,19,5),(141,19,6),(142,20,4),(143,20,7),(144,1,8),(145,1,9),(146,2,1),(147,2,5),(148,2,6),(149,3,3),(150,3,6),(151,4,2),(152,4,3),(153,5,4),(154,5,9),(155,6,8),(156,6,9),(157,7,2),(158,7,3),(159,7,7),(160,8,3),(161,8,6),(162,8,7),(163,9,2),(164,9,4),(165,9,9),(166,10,6),(167,10,7),(168,11,2),(169,11,4),(170,11,7),(171,12,1),(172,12,3),(173,13,1),(174,13,5),(175,13,9),(176,14,5),(177,14,6),(178,15,1),(179,15,5),(180,15,6),(181,16,2),(182,16,6),(183,17,2),(184,17,4),(185,18,2),(186,18,7),(187,18,9),(188,19,1),(189,19,5),(190,19,6),(191,20,4),(192,20,7),(193,1,8),(194,1,9),(195,2,1),(196,2,5),(197,2,6),(198,3,3),(199,3,6),(200,4,2),(201,4,3),(202,5,4),(203,5,9),(204,6,8),(205,6,9),(206,7,2),(207,7,3),(208,7,7),(209,8,3),(210,8,6),(211,8,7),(212,9,2),(213,9,4),(214,9,9),(215,10,6),(216,10,7),(217,11,2),(218,11,4),(219,11,7),(220,12,1),(221,12,3),(222,13,1),(223,13,5),(224,13,9),(225,14,5),(226,14,6),(227,15,1),(228,15,5),(229,15,6),(230,16,2),(231,16,6),(232,17,2),(233,17,4),(234,18,2),(235,18,7),(236,18,9),(237,19,1),(238,19,5),(239,19,6),(240,20,4),(241,20,7),(242,1,8),(243,1,9),(244,2,1),(245,2,5),(246,2,6),(247,3,3),(248,3,6),(249,4,2),(250,4,3),(251,5,4),(252,5,9),(253,6,8),(254,6,9),(255,7,2),(256,7,3),(257,7,7),(258,8,3),(259,8,6),(260,8,7),(261,9,2),(262,9,4),(263,9,9),(264,10,6),(265,10,7),(266,11,2),(267,11,4),(268,11,7),(269,12,1),(270,12,3),(271,13,1),(272,13,5),(273,13,9),(274,14,5),(275,14,6),(276,15,1),(277,15,5),(278,15,6),(279,16,2),(280,16,6),(281,17,2),(282,17,4),(283,18,2),(284,18,7),(285,18,9),(286,19,1),(287,19,5),(288,19,6),(289,20,4),(290,20,7),(291,1,8),(292,1,9),(293,2,1),(294,2,5),(295,2,6),(296,3,3),(297,3,6),(298,4,2),(299,4,3),(300,5,4),(301,5,9),(302,6,8),(303,6,9),(304,7,2),(305,7,3),(306,7,7),(307,8,3),(308,8,6),(309,8,7),(310,9,2),(311,9,4),(312,9,9),(313,10,6),(314,10,7),(315,11,2),(316,11,4),(317,11,7),(318,12,1),(319,12,3),(320,13,1),(321,13,5),(322,13,9),(323,14,5),(324,14,6),(325,15,1),(326,15,5),(327,15,6),(328,16,2),(329,16,6),(330,17,2),(331,17,4),(332,18,2),(333,18,7),(334,18,9),(335,19,1),(336,19,5),(337,19,6),(338,20,4),(339,20,7),(340,1,8),(341,1,9),(342,2,1),(343,2,5),(344,2,6),(345,3,3),(346,3,6),(347,4,2),(348,4,3),(349,5,4),(350,5,9),(351,6,8),(352,6,9),(353,7,2),(354,7,3),(355,7,7),(356,8,3),(357,8,6),(358,8,7),(359,9,2),(360,9,4),(361,9,9),(362,10,6),(363,10,7),(364,11,2),(365,11,4),(366,11,7),(367,12,1),(368,12,3),(369,13,1),(370,13,5),(371,13,9),(372,14,5),(373,14,6),(374,15,1),(375,15,5),(376,15,6),(377,16,2),(378,16,6),(379,17,2),(380,17,4),(381,18,2),(382,18,7),(383,18,9),(384,19,1),(385,19,5),(386,19,6),(387,20,4),(388,20,7),(389,1,8),(390,1,9),(391,2,1),(392,2,5),(393,2,6),(394,3,3),(395,3,6),(396,4,2),(397,4,3),(398,5,4),(399,5,9),(400,6,8),(401,6,9),(402,7,2),(403,7,3),(404,7,7),(405,8,3),(406,8,6),(407,8,7),(408,9,2),(409,9,4),(410,9,9),(411,10,6),(412,10,7),(413,11,2),(414,11,4),(415,11,7),(416,12,1),(417,12,3),(418,13,1),(419,13,5),(420,13,9),(421,14,5),(422,14,6),(423,15,1),(424,15,5),(425,15,6),(426,16,2),(427,16,6),(428,17,2),(429,17,4),(430,18,2),(431,18,7),(432,18,9),(433,19,1),(434,19,5),(435,19,6),(436,20,4),(437,20,7),(438,1,8),(439,1,9),(440,2,1),(441,2,5),(442,2,6),(443,3,3),(444,3,6),(445,4,2),(446,4,3),(447,5,4),(448,5,9),(449,6,8),(450,6,9),(451,7,2),(452,7,3),(453,7,7),(454,8,3),(455,8,6),(456,8,7),(457,9,2),(458,9,4),(459,9,9),(460,10,6),(461,10,7),(462,11,2),(463,11,4),(464,11,7),(465,12,1),(466,12,3),(467,13,1),(468,13,5),(469,13,9),(470,14,5),(471,14,6),(472,15,1),(473,15,5),(474,15,6),(475,16,2),(476,16,6),(477,17,2),(478,17,4),(479,18,2),(480,18,7),(481,18,9),(482,19,1),(483,19,5),(484,19,6),(485,20,4),(486,20,7),(487,1,8),(488,1,9),(489,2,1),(490,2,5),(491,2,6),(492,3,3),(493,3,6),(494,4,2),(495,4,3),(496,5,4),(497,5,9),(498,6,8),(499,6,9),(500,7,2),(501,7,3),(502,7,7),(503,8,3),(504,8,6),(505,8,7),(506,9,2),(507,9,4),(508,9,9),(509,10,6),(510,10,7),(511,11,2),(512,11,4),(513,11,7),(514,12,1),(515,12,3),(516,13,1),(517,13,5),(518,13,9),(519,14,5),(520,14,6),(521,15,1),(522,15,5),(523,15,6),(524,16,2),(525,16,6),(526,17,2),(527,17,4),(528,18,2),(529,18,7),(530,18,9),(531,19,1),(532,19,5),(533,19,6),(534,20,4),(535,20,7),(536,1,8),(537,1,9),(538,2,1),(539,2,5),(540,2,6),(541,3,3),(542,3,6),(543,4,2),(544,4,3),(545,5,4),(546,5,9),(547,6,8),(548,6,9),(549,7,2),(550,7,3),(551,7,7),(552,8,3),(553,8,6),(554,8,7),(555,9,2),(556,9,4),(557,9,9),(558,10,6),(559,10,7),(560,11,2),(561,11,4),(562,11,7),(563,12,1),(564,12,3),(565,13,1),(566,13,5),(567,13,9),(568,14,5),(569,14,6),(570,15,1),(571,15,5),(572,15,6),(573,16,2),(574,16,6),(575,17,2),(576,17,4),(577,18,2),(578,18,7),(579,18,9),(580,19,1),(581,19,5),(582,19,6),(583,20,4),(584,20,7);
/*!40000 ALTER TABLE `automobile_motore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `automobili`
--

DROP TABLE IF EXISTS `automobili`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automobili` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(50) NOT NULL,
  `modello` varchar(50) NOT NULL,
  `colore` varchar(20) DEFAULT NULL,
  `stato` varchar(20) DEFAULT 'nuova',
  `carrozzeria` varchar(20) DEFAULT NULL,
  `venduta` tinyint(1) DEFAULT '0',
  `concessionario_id` int DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `auto_conc` (`concessionario_id`),
  CONSTRAINT `auto_conc` FOREIGN KEY (`concessionario_id`) REFERENCES `concessionari` (`id`),
  CONSTRAINT `automobili_ibfk_2` FOREIGN KEY (`cliente_id`) REFERENCES `clienti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobili`
--

LOCK TABLES `automobili` WRITE;
/*!40000 ALTER TABLE `automobili` DISABLE KEYS */;
INSERT INTO `automobili` VALUES (1,'porche','macan','nero',NULL,'suv',NULL,1,NULL),(2,'fiat','panda','rosso','nuova','utilitaria',0,1,NULL),(3,'fiat','punto','verde','nuova','utilitaria',0,1,NULL),(4,'renault','scenic','nero','nuova','berlina',0,1,NULL),(5,'bmw','X5','grigio','nuova','suv',0,1,NULL),(6,'mercedes','s35','nero','nuova','berlina',0,1,NULL),(7,'nissan','quasqai','grigio','nuova','suv',0,1,NULL),(8,'jeep','compass','verde','nuova','crossover',0,1,NULL),(9,'jeep','wrangler','bianco','nuova','suv',0,1,NULL),(10,'seat','ibiza','nero','nuova','utilitaria',1,1,4),(11,'toyota','corolla','blu','nuova','berlina',0,1,NULL),(12,'dacia','sandero','nero','nuova','suv',0,1,NULL),(13,'lancia','y','bianco','nuova','utilitaria',0,1,NULL),(14,'citroen','c3','rosa','nuova','utilitaria',0,1,NULL),(15,'fiat','500','rosso','nuova','utilitaria',1,1,8),(16,'ford','puma','grigio','nuova','crossover',0,1,NULL),(17,'volkswagwn','t-rock','bianco','nuova','crossover',0,1,NULL),(18,'volkswagen','golf','nero','nuova','berlina',1,1,1),(19,'opel','corsa','bianco','nuova','utilitaria',0,1,NULL),(20,'suzuki','jimni','verde','nuova','suv',0,1,NULL),(21,'porche','macan','nero',NULL,'suv',NULL,1,NULL),(23,'porchezz','macan','nero',NULL,'suv',NULL,1,NULL);
/*!40000 ALTER TABLE `automobili` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `cognome` varchar(30) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `concessionario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `cli_conc` (`concessionario_id`),
  CONSTRAINT `cli_conc` FOREIGN KEY (`concessionario_id`) REFERENCES `concessionari` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'giovanni','ferrari','giovanni@mail.it','2436472572',1),(2,'laura','esposito','laura@mail.it','7835687161',1),(3,'carlo','bruno','carlo@mail.it','9897978969',1),(4,'Mario','Rossi','mario.rossi@example.com','87014897561',1),(5,'Luca','Bianchi','luca.bianchi@example.com','6325481326542',1),(6,'Sara','Verdi','sara.verdi@example.com','32644322763',1),(7,'Anna','Neri','anna.neri@example.com','276347861',1),(8,'Paolo','Gialli','paolo.gialli@example.com','31265443252',1),(9,'giovanna','ferrari','giovanna@mail.it','2436472572',1);
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concessionari`
--

DROP TABLE IF EXISTS `concessionari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concessionari` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `indirizzo` varchar(200) DEFAULT NULL,
  `p_iva` char(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `p_iva` (`p_iva`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concessionari`
--

LOCK TABLES `concessionari` WRITE;
/*!40000 ALTER TABLE `concessionari` DISABLE KEYS */;
INSERT INTO `concessionari` VALUES (1,'Autoland','Via degli abeti 21, 70100 BARI','D723568AK31');
/*!40000 ALTER TABLE `concessionari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motori`
--

DROP TABLE IF EXISTS `motori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motori` (
  `id` int NOT NULL AUTO_INCREMENT,
  `potenza` smallint NOT NULL,
  `cilindrata` double unsigned NOT NULL,
  `carburante` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motori`
--

LOCK TABLES `motori` WRITE;
/*!40000 ALTER TABLE `motori` DISABLE KEYS */;
INSERT INTO `motori` VALUES (1,70,1,'metanolo'),(2,140,2,'diesel'),(3,136,2.2,'benzina'),(4,250,2.5,'ibrido'),(5,50,1,'gpl'),(6,90,1.2,'metano'),(7,170,2,'diesiel'),(8,400,3,'benzina'),(9,240,3.2,'benzina');
/*!40000 ALTER TABLE `motori` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-07 17:42:57
