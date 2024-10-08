CREATE DATABASE  IF NOT EXISTS `concessionario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `concessionario`;
-- MySQL dump 10.13  Distrib 8.0.38, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: concessionario
-- ------------------------------------------------------
-- Server version	9.0.1

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=494 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accessorio_automobile`
--

LOCK TABLES `accessorio_automobile` WRITE;
/*!40000 ALTER TABLE `accessorio_automobile` DISABLE KEYS */;
INSERT INTO `accessorio_automobile` VALUES (20,2,1),(21,2,8),(22,2,9),(23,2,10),(24,2,11),(25,2,12),(26,2,13),(27,2,14),(28,2,15),(29,2,16),(30,2,17),(31,2,18),(32,2,19),(33,2,20),(34,2,21),(35,2,25),(36,2,26),(37,2,27),(38,2,28),(39,2,29),(40,2,30),(41,2,31),(42,2,32),(43,3,1),(44,3,2),(45,3,3),(46,3,4),(47,3,5),(48,3,6),(49,3,7),(50,3,8),(51,3,9),(52,3,10),(53,3,11),(54,3,12),(55,3,13),(56,3,30),(57,3,31),(58,3,32),(59,4,1),(60,4,2),(61,4,3),(62,4,4),(63,4,5),(64,4,6),(65,4,7),(66,4,8),(67,4,9),(68,4,10),(69,4,11),(70,4,12),(71,4,13),(72,4,16),(73,4,17),(74,4,18),(75,4,19),(76,4,20),(77,4,21),(78,4,22),(79,4,23),(80,4,24),(81,4,25),(82,4,26),(83,4,27),(84,4,28),(85,4,32),(86,5,1),(87,5,2),(88,5,5),(89,5,6),(90,5,7),(91,5,8),(92,5,9),(93,5,10),(94,5,11),(95,5,12),(96,5,13),(97,5,14),(98,5,15),(99,5,16),(100,5,17),(101,5,22),(102,5,23),(103,5,24),(104,5,25),(105,5,26),(106,5,27),(107,5,28),(108,5,29),(109,5,30),(110,5,31),(111,5,32),(112,6,1),(113,6,2),(114,6,3),(115,6,4),(116,6,5),(117,6,6),(118,6,7),(119,6,8),(120,6,9),(121,6,10),(122,6,11),(123,6,12),(124,6,16),(125,6,17),(126,6,18),(127,6,19),(128,6,20),(129,6,21),(130,6,22),(131,6,23),(132,6,27),(133,6,28),(134,6,29),(135,6,30),(136,6,31),(137,6,32),(138,7,1),(139,7,2),(140,7,3),(141,7,4),(142,7,5),(143,7,6),(144,7,7),(145,7,8),(146,7,9),(147,7,10),(148,7,11),(149,7,12),(150,7,13),(151,7,14),(152,7,15),(153,7,16),(154,7,17),(155,7,18),(156,7,19),(157,7,20),(158,7,21),(159,7,22),(160,7,23),(161,7,24),(162,7,25),(163,7,26),(164,7,27),(165,7,28),(166,7,29),(167,7,30),(168,7,31),(169,7,32),(170,8,1),(171,8,2),(172,8,3),(173,8,4),(174,8,5),(175,8,6),(176,8,7),(177,8,8),(178,8,25),(179,8,26),(180,8,27),(181,8,28),(182,8,29),(183,8,30),(184,8,31),(185,8,32),(186,9,1),(187,9,2),(188,9,3),(189,9,4),(190,9,5),(191,9,6),(192,9,7),(193,9,8),(194,9,9),(195,9,14),(196,9,15),(197,9,16),(198,9,17),(199,9,18),(200,9,19),(201,9,20),(202,9,21),(203,9,22),(204,9,23),(205,9,24),(206,9,25),(207,9,26),(208,9,27),(209,9,28),(210,9,29),(211,10,1),(212,10,2),(213,10,3),(214,10,4),(215,10,5),(216,10,6),(217,10,7),(218,10,8),(219,10,9),(220,10,10),(221,10,11),(222,10,12),(223,10,13),(224,10,30),(225,10,31),(226,10,32),(227,11,1),(228,11,8),(229,11,9),(230,11,10),(231,11,11),(232,11,12),(233,11,13),(234,11,14),(235,11,15),(236,11,16),(237,11,17),(238,11,18),(239,11,19),(240,11,20),(241,11,21),(242,11,25),(243,11,26),(244,11,27),(245,11,28),(246,11,29),(247,11,30),(248,11,31),(249,11,32),(250,12,1),(251,12,2),(252,12,3),(253,12,4),(254,12,5),(255,12,6),(256,12,7),(257,12,8),(258,12,9),(259,12,10),(260,12,11),(261,12,12),(262,12,13),(263,12,30),(264,12,31),(265,12,32),(266,13,1),(267,13,2),(268,13,3),(269,13,4),(270,13,5),(271,13,6),(272,13,7),(273,13,8),(274,13,9),(275,13,10),(276,13,11),(277,13,12),(278,13,13),(279,13,30),(280,13,31),(281,13,32),(282,14,1),(283,14,2),(284,14,3),(285,14,4),(286,14,5),(287,14,6),(288,14,7),(289,14,8),(290,14,9),(291,14,10),(292,14,11),(293,14,12),(294,14,13),(295,14,16),(296,14,17),(297,14,18),(298,14,19),(299,14,20),(300,14,21),(301,14,22),(302,14,23),(303,14,24),(304,14,25),(305,14,26),(306,14,27),(307,14,28),(308,14,32),(309,15,1),(310,15,2),(311,15,5),(312,15,6),(313,15,7),(314,15,8),(315,15,9),(316,15,10),(317,15,11),(318,15,12),(319,15,13),(320,15,14),(321,15,15),(322,15,16),(323,15,17),(324,15,22),(325,15,23),(326,15,24),(327,15,25),(328,15,26),(329,15,27),(330,15,28),(331,15,29),(332,15,30),(333,15,31),(334,15,32),(335,16,1),(336,16,2),(337,16,3),(338,16,4),(339,16,5),(340,16,6),(341,16,7),(342,16,8),(343,16,9),(344,16,10),(345,16,11),(346,16,12),(347,16,16),(348,16,17),(349,16,18),(350,16,19),(351,16,20),(352,16,21),(353,16,22),(354,16,23),(355,16,27),(356,16,28),(357,16,29),(358,16,30),(359,16,31),(360,16,32),(361,17,1),(362,17,2),(363,17,3),(364,17,4),(365,17,5),(366,17,6),(367,17,7),(368,17,8),(369,17,9),(370,17,10),(371,17,11),(372,17,12),(373,17,13),(374,17,14),(375,17,15),(376,17,16),(377,17,17),(378,17,18),(379,17,19),(380,17,20),(381,17,21),(382,17,22),(383,17,23),(384,17,24),(385,17,25),(386,17,26),(387,17,27),(388,17,28),(389,17,29),(390,17,30),(391,17,31),(392,17,32),(393,18,1),(394,18,2),(395,18,3),(396,18,4),(397,18,5),(398,18,6),(399,18,7),(400,18,8),(401,18,25),(402,18,26),(403,18,27),(404,18,28),(405,18,29),(406,18,30),(407,18,31),(408,18,32),(409,19,1),(410,19,2),(411,19,3),(412,19,4),(413,19,5),(414,19,6),(415,19,7),(416,19,8),(417,19,9),(418,19,14),(419,19,15),(420,19,16),(421,19,17),(422,19,18),(423,19,19),(424,19,20),(425,19,21),(426,19,22),(427,19,23),(428,19,24),(429,19,25),(430,19,26),(431,19,27),(432,19,28),(433,19,29),(434,20,1),(435,20,2),(436,20,3),(437,20,4),(438,20,5),(439,20,6),(440,20,7),(441,20,8),(442,20,9),(443,20,14),(444,20,15),(445,20,16),(446,20,17),(447,20,18),(448,20,19),(449,20,20),(450,20,21),(451,20,22),(452,20,23),(453,20,24),(454,20,25),(455,20,26),(456,20,27),(457,20,28),(458,20,29),(481,1,1),(482,1,2),(483,1,3),(484,1,4),(485,1,5),(486,1,6),(487,1,7),(488,1,8),(489,1,9),(490,1,10),(491,1,11),(492,1,12),(493,1,13);
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
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobile_motore`
--

LOCK TABLES `automobile_motore` WRITE;
/*!40000 ALTER TABLE `automobile_motore` DISABLE KEYS */;
INSERT INTO `automobile_motore` VALUES (93,1,8),(94,1,9),(95,2,1),(96,2,5),(97,2,6),(98,3,3),(99,3,6),(100,4,2),(101,4,3),(102,5,4),(103,5,9),(104,6,8),(105,6,9),(106,7,2),(107,7,3),(108,7,7),(109,8,3),(110,8,6),(111,8,7),(112,9,2),(113,9,4),(114,9,9),(115,10,6),(116,10,7),(117,11,2),(118,11,4),(119,11,7),(120,12,1),(121,12,3),(122,13,1),(123,13,5),(124,13,9),(125,14,5),(126,14,6),(127,15,1),(128,15,5),(129,15,6),(130,16,2),(131,16,6),(132,17,2),(133,17,4),(134,18,2),(135,18,7),(136,18,9),(137,19,1),(138,19,5),(139,19,6),(140,20,4),(141,20,7);
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automobili`
--

LOCK TABLES `automobili` WRITE;
/*!40000 ALTER TABLE `automobili` DISABLE KEYS */;
INSERT INTO `automobili` VALUES (1,'porche','macan','nero',NULL,'suv',NULL,1,NULL),(2,'fiat','panda','rosso','nuova','utilitaria',0,1,NULL),(3,'fiat','punto','verde','nuova','utilitaria',0,1,NULL),(4,'renault','scenic','nero','nuova','berlina',0,1,NULL),(5,'bmw','X5','grigio','nuova','suv',0,1,NULL),(6,'mercedes','s35','nero','nuova','berlina',0,1,NULL),(7,'nissan','quasqai','grigio','nuova','suv',0,1,NULL),(8,'jeep','compass','verde','nuova','crossover',0,1,NULL),(9,'jeep','wrangler','bianco','nuova','suv',0,1,NULL),(10,'seat','ibiza','nero','nuova','utilitaria',1,1,4),(11,'toyota','corolla','blu','nuova','berlina',0,1,NULL),(12,'dacia','sandero','nero','nuova','suv',0,1,NULL),(13,'lancia','y','bianco','nuova','utilitaria',0,1,NULL),(14,'citroen','c3','rosa','nuova','utilitaria',0,1,NULL),(15,'fiat','500','rosso','nuova','utilitaria',1,1,8),(16,'ford','puma','grigio','nuova','crossover',0,1,NULL),(17,'volkswagwn','t-rock','bianco','nuova','crossover',0,1,NULL),(18,'volkswagen','golf','nero','nuova','berlina',1,1,1),(19,'opel','corsa','bianco','nuova','utilitaria',0,1,NULL),(20,'suzuki','jimni','verde','nuova','suv',0,1,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2024-10-08 12:38:39
