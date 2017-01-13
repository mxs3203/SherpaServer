CREATE DATABASE  IF NOT EXISTS `sherpa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sherpa`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sherpa
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `achievement`
--

DROP TABLE IF EXISTS `achievement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `achievement` (
  `achievement_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image_url` varchar(256) NOT NULL,
  `description` varchar(128) NOT NULL,
  `requirement` decimal(7,2) NOT NULL,
  PRIMARY KEY (`achievement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement`
--

LOCK TABLES `achievement` WRITE;
/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
INSERT INTO `achievement` VALUES (1,'http://dummyimage.com/219x239.bmp/ff4444/ffffff','Puno evenata',10.00),(2,'http://dummyimage.com/162x182.png/dddddd/000000','Više od 10 ljudi',20.00);
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `achievement_user_cross`
--

DROP TABLE IF EXISTS `achievement_user_cross`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `achievement_user_cross` (
  `achievement_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `achievement_id` bigint(20) NOT NULL,
  PRIMARY KEY (`achievement_user_id`,`user_id`,`achievement_id`),
  KEY `achievement_achievementUser_FK_idx` (`achievement_id`),
  KEY `achievementUser_user_FK` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `achievement_user_cross`
--

LOCK TABLES `achievement_user_cross` WRITE;
/*!40000 ALTER TABLE `achievement_user_cross` DISABLE KEYS */;
INSERT INTO `achievement_user_cross` VALUES (3,50,1),(5,80,1),(1,20,2),(2,35,2),(4,65,2);
/*!40000 ALTER TABLE `achievement_user_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `currency_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `iso` varchar(3) NOT NULL,
  `name` varchar(64) NOT NULL,
  PRIMARY KEY (`currency_id`),
  UNIQUE KEY `iso_UNIQUE` (`iso`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'HRK','Croatian kuna'),(2,'USD','United States dollar');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `start_location_id` bigint(20) NOT NULL,
  `end_location_id` bigint(20) DEFAULT NULL,
  `name` varchar(128) NOT NULL,
  `description` varchar(512) NOT NULL,
  `price` decimal(19,4) DEFAULT NULL,
  `currency_id` bigint(20) DEFAULT NULL,
  `cumulative_rating` decimal(2,1) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `is_finished` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `end_location_event_fk_idx` (`end_location_id`),
  KEY `event_user_FK_idx` (`user_id`),
  KEY `event_location_start_FK_idx` (`start_location_id`),
  KEY `event_currency_FK_idx` (`currency_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,39,38,25,'coherent','Goldner Group',286.9200,2,0.6,'2018-06-29 02:08:45','2016-12-08 10:38:43','2016-10-29 16:03:39',0),(2,10,55,NULL,'protocol','Swift-Miller',52.0000,NULL,3.5,'2016-04-11 12:17:43','2018-02-06 08:57:00','2018-05-31 18:28:10',0),(3,102,39,53,'throughput','Kutch Group',380.3800,2,3.8,'2017-12-27 23:15:19','2017-11-22 05:08:25','2016-11-14 15:24:27',1),(4,86,27,63,'neutral','Lockman, Rutherford and Schumm',240.2000,1,1.5,'2016-07-10 03:45:48','2017-04-03 10:57:30','2018-10-09 20:29:25',1),(5,107,48,93,'needs-based','Lakin, Bernhard and Ledner',377.2800,1,3.1,'2016-08-13 18:26:01','2018-10-08 07:33:17','2018-06-17 04:51:27',1),(6,102,45,8,'methodology','Kunde, Towne and Ruecker',414.2500,2,1.2,'2018-07-27 18:00:51','2016-04-19 03:39:51','2018-02-26 22:19:42',1),(7,69,50,98,'Self-enabling','Pouros, Altenwerth and Bahringer',427.6900,1,1.7,'2017-09-03 22:56:33','2018-08-08 20:38:36','2018-03-09 17:57:36',0),(8,51,64,98,'Secured','Ryan-Bosco',64.3500,1,1.8,'2016-07-10 01:41:18','2017-05-05 15:43:30','2018-02-15 09:21:39',1),(9,103,18,25,'clear-thinking','Little, Gottlieb and Koss',238.0100,2,4.5,'2018-01-21 13:12:21','2017-06-26 23:43:58','2016-07-25 05:05:06',0),(10,115,51,14,'encryption','Pollich, Nader and Gislason',89.5000,1,1.5,'2018-10-07 08:48:40','2017-03-08 11:54:38','2016-04-21 09:29:20',0),(11,81,48,17,'mission-critical','Baumbach, Feest and Carroll',194.5800,1,3.1,'2016-03-12 01:21:38','2017-09-13 21:24:38','2017-06-09 00:48:47',1),(12,110,83,38,'methodical','Gaylord, Denesik and Bergstrom',469.7200,2,4.7,'2018-11-09 05:01:01','2018-01-05 04:37:34','2018-02-20 14:50:35',1),(13,146,105,4,'Realigned','Dibbert, Johnston and Ullrich',318.7000,2,2.4,'2015-12-05 23:34:10','2017-02-06 00:08:46','2017-03-22 14:33:52',1),(14,64,102,87,'coherent','West, Leffler and Conn',46.5600,2,3.4,'2018-09-17 06:13:48','2017-02-23 06:13:16','2018-09-25 09:28:54',0),(15,72,106,29,'Street art grafitti','Grafitti art',100.0000,2,3.2,'2017-08-17 02:18:54','2016-07-05 21:47:24','2017-02-11 09:32:42',0),(16,36,33,21,'Profit-focused','Bednar-Gutkowski',40.0000,2,3.1,'2018-06-16 12:01:01','2017-11-28 15:25:34','2016-01-03 08:18:06',0),(17,96,108,63,'Museums of Zagreb','Mimara, Broken relationships',40.0000,1,1.9,'2016-04-17 20:27:47','2017-07-19 16:15:09','2016-09-27 03:23:42',0),(18,151,71,63,'multi-state','Kshlerin, Cassin and Bode',445.6800,1,3.0,'2017-11-30 04:05:07','2018-04-21 18:42:03','2018-03-07 13:54:34',0),(19,90,72,29,'Polarised','Little-Dare',174.6700,1,1.7,'2016-03-27 22:56:05','2018-08-17 17:59:08','2016-05-31 08:58:59',1),(20,21,51,66,'asymmetric','Vandervort-Casper',264.4400,2,3.8,'2015-11-20 03:03:53','2017-07-26 03:54:24','2018-07-30 11:21:51',1),(21,39,1,23,'Test','Testis',100000.0000,1,4.3,'2015-11-20 03:03:53','2017-07-26 03:54:24','2018-07-30 11:21:51',1),(22,96,109,105,'RIT tour','RIT tour through classes.',0.0000,1,4.1,'2016-11-30 01:00:00','2016-11-30 07:00:00','2018-01-15 10:00:00',0),(23,72,110,105,'Bundek tour','Bundek lookup',5.0000,1,4.0,'2016-11-30 01:00:00','2016-11-30 07:00:00','2018-01-15 10:00:00',0),(24,96,111,105,'Caffe bar kos','Kos caffe happy hour.',1.0000,1,2.5,'2016-11-30 01:00:00','2016-11-30 07:00:00','2018-01-15 10:00:00',0),(27,160,116,105,'USERname','ds',2.0000,1,0.0,'2016-12-04 19:52:53','2016-12-04 19:52:53','2016-12-04 19:52:53',0),(30,160,120,105,'USERname','Fghvbjb',55.0000,1,0.0,'2016-12-06 23:12:10','2016-12-06 23:12:10','2016-12-06 23:12:10',0),(32,160,122,123,'USERname','Pick a ',2.0000,1,0.0,'2016-12-06 23:24:53','2016-12-06 23:24:53','2016-12-06 23:24:53',0),(33,160,123,123,'USERname','Testtt',3.0000,1,0.0,'2016-12-06 23:27:38','2016-12-06 23:27:38','2016-12-06 23:27:38',0),(34,160,124,124,'USERname','',3.0000,1,0.0,'2016-12-06 23:29:48','2016-12-06 23:29:48','2016-12-06 23:29:48',0),(36,160,126,126,'USERname','',22.0000,1,0.0,'2016-12-06 23:37:04','2016-12-06 23:37:04','2016-12-06 23:37:04',0),(37,160,127,104,'USERname','',22.0000,1,0.0,'2016-12-06 23:38:17','2016-12-06 23:38:17','2016-12-06 23:38:17',0);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_tag_cross`
--

DROP TABLE IF EXISTS `event_tag_cross`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_tag_cross` (
  `event_tag_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`event_tag_id`,`event_id`,`tag_id`),
  KEY `tag_event_FK_idx` (`event_id`),
  KEY `event_tag_FK_idx` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_tag_cross`
--

LOCK TABLES `event_tag_cross` WRITE;
/*!40000 ALTER TABLE `event_tag_cross` DISABLE KEYS */;
INSERT INTO `event_tag_cross` VALUES (1,4,4),(2,4,5),(3,15,1),(4,15,2),(5,15,3),(6,30,2),(7,30,3),(8,32,2),(9,33,3),(10,33,4),(11,34,1),(12,34,4),(13,36,5),(14,37,5);
/*!40000 ALTER TABLE `event_tag_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_user_cross`
--

DROP TABLE IF EXISTS `event_user_cross`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_user_cross` (
  `event_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `event_id` bigint(20) NOT NULL,
  PRIMARY KEY (`event_user_id`,`user_id`,`event_id`),
  KEY `event_user_FK_idx` (`event_id`),
  KEY `user_event_FK_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_user_cross`
--

LOCK TABLES `event_user_cross` WRITE;
/*!40000 ALTER TABLE `event_user_cross` DISABLE KEYS */;
INSERT INTO `event_user_cross` VALUES (1,10,4),(2,11,4),(3,12,4),(4,13,4),(5,14,4),(6,15,4),(7,40,17),(8,41,17),(9,129,20),(10,130,20);
/*!40000 ALTER TABLE `event_user_cross` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `experience_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `experience` int(11) NOT NULL DEFAULT '0',
  `cumulative_rating` decimal(2,1) NOT NULL DEFAULT '0.0',
  PRIMARY KEY (`experience_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (1,20,2,4.4);
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_id` bigint(20) NOT NULL,
  `image_url` varchar(256) NOT NULL,
  PRIMARY KEY (`image_id`),
  KEY `image_event_FK_idx` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,17,'http://dummyimage.com/162x182.png/dddddd/000000'),(2,17,'http://dummyimage.com/162x182.png/dddddd/000000'),(3,17,'http://dummyimage.com/162x182.png/dddddd/000000'),(4,15,'http://dummyimage.com/162x182.png/dddddd/000000'),(5,15,'http://dummyimage.com/162x182.png/dddddd/000000'),(6,17,'https://s.moj-posao.org/data/images/preview/user/53/013ec035-crop-160x160x100.jpg'),(7,15,'https://s.moj-posao.org/data/images/preview/user/53/013ec035-crop-160x160x100.jpg'),(8,17,'https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAjRAAAAJDc2NTFlNzU5LTNkOWItNDMzYS04NTMxLTM1ZWY4ZGE3YWU0Nw.jpg'),(9,15,'https://people.rit.edu/~mxs3203/240/slika.jpg'),(10,15,'http://mediad.publicbroadcasting.net/p/kwmu/files/styles/x_large/public/201601/3980630374_bb3efbf201_o__1_.jpg'),(11,17,'http://www.meetinzagreb.hr/media/places/4911470560-a80d7fe0c6-o-559cd2808db55.jpg'),(12,22,'http://www.vecernji.hr/media/cache/25/51/2551ed645ba0dba9124be6c4fb202d92.jpg'),(13,23,'http://www.zkahlina.ca/wp-content/uploads/2009/06/bundek2.jpg'),(14,24,'http://ywcanb.org/wp-content/uploads/2016/03/BasketballStockImage.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `latitude` decimal(9,6) NOT NULL,
  `longitude` decimal(9,6) NOT NULL,
  `region` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,1.100000,1.100000,'Mexico'),(3,1.100000,1.100000,'Mexico'),(4,2.123456,2.133700,'Croatia'),(5,-65.349940,-92.701570,'PUG'),(6,-27.967650,-2.021210,'Hertfordshire'),(7,-39.800460,20.300470,'A'),(8,-0.627730,-81.691650,'WB'),(9,11.205330,162.693230,'NI'),(10,-11.410080,-152.875660,'RJ'),(11,82.341620,33.780580,'Saarland'),(12,58.952460,19.980930,'LAZ'),(13,23.847650,-173.332220,'VIC'),(14,52.235770,-154.755790,'Luxemburg'),(15,78.353030,-46.437450,'Araucanía'),(16,-82.064390,-66.477780,'łódzkie'),(17,18.503540,38.057460,'U'),(18,-18.002660,-35.090120,'PR'),(19,-28.558560,41.709510,'Western Australia'),(20,57.678540,-139.881300,'VI'),(21,-60.659540,-129.635580,'AL'),(22,35.186230,152.939800,'DE'),(23,-0.989350,58.152750,'Veneto'),(24,-73.869790,96.686950,'South Island'),(25,-53.090480,-112.282090,'Île-de-France'),(26,26.980520,-32.105010,'ON'),(27,-60.184000,25.143210,'Berlin'),(28,-16.414640,159.043870,'CO'),(29,-14.715220,41.641770,'NI'),(30,-54.097180,160.613910,'Rio de Janeiro'),(31,77.708140,161.256060,'ON'),(32,66.704990,-89.829320,'OV'),(33,74.276190,121.424730,'Vermont'),(34,-72.120760,25.487380,'Maharastra'),(35,79.809590,14.922900,'DL'),(36,75.227940,-147.055360,'Nord-Pas-de-Calais'),(37,-70.906960,-102.138430,'Östergötlands län'),(38,9.425800,28.459090,'BA'),(39,87.035920,-169.084950,'South Island'),(40,-57.742180,69.661840,'Connecticut'),(41,-48.154300,-79.646530,'WY'),(42,2.244350,-79.029510,'Konya'),(43,-80.252010,-156.746120,'Leinster'),(44,65.047390,-70.604610,'RM'),(45,-71.150750,-137.992160,'CN'),(46,-10.813760,143.190830,'Västra Götalands län'),(47,79.067540,133.112670,'L'),(48,-23.853640,94.348270,'Sląskie'),(49,71.859800,-38.026490,'HH'),(50,-54.362150,-168.049870,'Hamburg'),(51,30.092500,26.507500,'Ontario'),(52,18.699600,139.824170,'KE'),(53,55.550200,79.091400,'BA'),(54,78.380870,26.795530,'BE'),(55,29.068260,119.796840,'Ist'),(56,75.185580,-167.698410,'NI'),(57,-18.050520,-24.078360,'Montana'),(58,76.454190,18.406840,'Ist'),(59,-27.242760,23.433460,'Jönköpings län'),(60,-34.807300,150.035400,'L'),(61,10.683870,33.032750,'Bihar'),(62,-84.723390,23.783320,'Mazowieckie'),(63,-52.493080,112.750040,'V'),(64,-40.938830,-0.580730,'FL'),(65,-52.793020,129.320640,'AB'),(66,67.526280,-96.727940,'Antofagasta'),(67,86.492320,162.484820,'CAM'),(68,88.012540,-70.638600,'Ontario'),(69,-88.482500,-7.493340,'Ulster'),(70,53.538480,-128.868520,'ON'),(71,-79.814490,149.249920,'Idaho'),(72,20.714320,-174.724960,'WY'),(73,-15.930690,-119.417110,'Newfoundland and Labrador'),(74,12.870920,-145.477880,'SP'),(75,-10.700830,-84.800230,'C'),(76,67.941730,154.047100,'Vlaams-Brabant'),(77,-71.906810,158.830790,'NI'),(78,25.303070,-145.229820,'CA'),(79,77.900600,-169.644080,'IL'),(80,-17.063980,-60.950510,'Metropolitana de Santiago'),(81,-68.450440,153.637160,'Ontario'),(82,31.827640,100.573700,'NW'),(83,-40.874320,92.271000,'CL'),(84,-22.506730,162.112010,'PE'),(85,81.545440,-56.704720,'VIC'),(86,52.013330,-118.521940,'Şan'),(87,-55.703230,-50.764090,'WM'),(88,76.946350,171.525000,'Styria'),(89,-48.183110,-137.166420,'PD'),(90,-43.810250,131.785740,'DS'),(91,39.410140,176.406260,'Bremen'),(92,31.065160,58.573280,'Antofagasta'),(93,-81.984710,-93.374930,'Madrid'),(94,-81.950150,-17.767410,'NE'),(95,1.121650,10.479500,'LD'),(96,-87.163100,-19.625340,'Hat'),(97,-26.525740,-35.294590,'MT'),(98,-23.995930,112.539940,'Illinois'),(99,80.611050,-39.635370,'VII'),(100,-23.062380,-135.843960,'Friesland'),(101,-46.731800,-171.792940,'VIC'),(102,20.551360,10.226880,'Catalunya'),(103,-2.492800,107.197290,'San José'),(104,84.600640,-135.480380,'Bremen'),(105,45.841014,16.051229,'10000, Zagreb'),(106,45.861017,16.061229,'10000, Zagreb'),(107,0.000000,0.000000,''),(108,45.831010,16.041228,'10000, Zagreb'),(109,45.782505,15.981045,'10000, Zagreb'),(110,45.784405,15.988759,'10000, Zagreb'),(111,45.780120,15.986461,'10000, Zagreb'),(116,45.828484,16.022646,'10000, Zagreb'),(117,45.794378,15.875384,'10000, Zagreb'),(120,45.795883,15.913285,'10000, Zagreb'),(122,45.787992,15.844428,'10000, Zagreb'),(123,45.809325,15.895156,'10000, Zagreb'),(124,45.793500,15.858028,'10000, Zagreb'),(126,45.810672,15.948522,'10000, Zagreb'),(127,45.782533,15.891235,'10000, Zagreb');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `rating_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `comment` varchar(512) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `event_rating_FK_idx` (`event_id`),
  KEY `user_rating_FK_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,30,160,'2017-10-01 03:08:30','Odlicno',5),(2,32,161,'2017-12-01 00:00:00','Vrlo Dobro',4),(3,32,163,'2017-09-11 00:00:00','Dobro',3),(4,37,163,'2017-08-01 00:00:00','Lose',2);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `report_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `sherpa_id` bigint(20) NOT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `date` datetime NOT NULL,
  `comment` varchar(512) NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `report_userSherpa_FK_idx` (`sherpa_id`),
  KEY `report_userUser_FK` (`user_id`),
  KEY `report_event_FK_idx` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward`
--

DROP TABLE IF EXISTS `reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reward` (
  `reward_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `type` int(11) NOT NULL,
  `description` varchar(256) NOT NULL,
  `image_url` varchar(256) NOT NULL,
  PRIMARY KEY (`reward_id`),
  KEY `user_reward_FK_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward`
--

LOCK TABLES `reward` WRITE;
/*!40000 ALTER TABLE `reward` DISABLE KEYS */;
INSERT INTO `reward` VALUES (1,20,2,'Poklon bon','https://dummyimage.com/600x400/000/fff');
/*!40000 ALTER TABLE `reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `tag_id` bigint(20) NOT NULL,
  `tag_name` varchar(64) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'nightlife'),(2,'music'),(3,'fooddrink'),(4,'artsculture'),(5,'shopping'),(6,'other'),(7,'Extreme');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location_id` bigint(20) DEFAULT NULL,
  `email` varchar(320) NOT NULL,
  `password` varchar(32) NOT NULL,
  `full_name` varchar(64) NOT NULL,
  `gender` int(11) NOT NULL,
  `profile_image_url` varchar(256) NOT NULL,
  `background_image_url` varchar(256) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `country` varchar(128) DEFAULT NULL,
  `hometown` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `telephone` varchar(64) DEFAULT NULL,
  `is_sherpa` tinyint(1) DEFAULT NULL,
  `is_reported` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_location_FK_idx` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,37,'chudson0@ox.ac.uk','M6nmoWR6','Chris Hudson',1,'http://dummyimage.com/105x153.bmp/ff4444/ffffff','http://dummyimage.com/355x335.jpg/dddddd/000000','Pellentesque eget nunc.','China','Liqiao','8803 Cambridge Terrace','86-(970)789-6304',1,1),(11,86,'rjacobs1@a8.net','ukKLcmPrKEjX','Robin Jacobs',1,'http://dummyimage.com/219x239.bmp/ff4444/ffffff','http://dummyimage.com/284x428.png/dddddd/000000','Nam tristique tortor eu pede.','Thailand','Mae Charim','25263 Graceland Court','66-(162)615-8149',1,1),(12,41,'dramirez2@google.com.au','rMQmDXow','Donna Ramirez',1,'http://dummyimage.com/162x182.png/dddddd/000000','http://dummyimage.com/471x246.png/ff4444/ffffff','Integer a nibh.','United States','Gatesville','15 Armistice Park','1-(254)707-4005',1,1),(13,NULL,'rallen3@hexun.com','5E4eNsP','Raymond Allen',0,'http://dummyimage.com/207x174.bmp/5fa2dd/ffffff','http://dummyimage.com/326x370.bmp/cc0000/ffffff','Nam nulla.','Thailand','Khao Yoi','8 Ramsey Way','66-(430)920-1442',1,0),(14,37,'hlopez4@wix.com','Fud8TY2Fp','Harry Lopez',0,'http://dummyimage.com/206x208.png/cc0000/ffffff','http://dummyimage.com/472x246.jpg/dddddd/000000','Duis mattis egestas metus.','China','Tengjia','4961 High Crossing Road','86-(276)702-9002',1,1),(15,66,'vpayne5@wordpress.com','2TCPsB1y','Victor Payne',1,'http://dummyimage.com/198x250.png/ff4444/ffffff','http://dummyimage.com/361x309.png/dddddd/000000','Fusce posuere felis sed lacus.','Poland','Gozdowo','9 Lakewood Lane','48-(308)905-6499',0,1),(16,21,'jjacobs6@live.com','q7P6kf3','Judith Jacobs',0,'http://dummyimage.com/214x209.bmp/5fa2dd/ffffff','http://dummyimage.com/348x225.png/cc0000/ffffff','Praesent blandit lacinia erat.','China','Baoshan','2 Grayhawk Hill','86-(247)697-8286',0,1),(17,72,'lgomez7@bing.com','jTUkmg6QXk5N','Laura Gomez',0,'http://dummyimage.com/214x138.bmp/dddddd/000000','http://dummyimage.com/278x266.jpg/5fa2dd/ffffff','Cras pellentesque volutpat dui.','Luxembourg','Hobscheid','6978 West Junction','352-(854)826-3854',0,1),(18,79,'rfreeman8@fotki.com','3wGZUTcF','Rose Freeman',0,'http://dummyimage.com/194x208.bmp/ff4444/ffffff','http://dummyimage.com/246x240.png/cc0000/ffffff','Donec ut dolor.','Iraq','Rāwandūz','527 Corben Drive','964-(848)371-1481',0,0),(19,85,'nfoster9@so-net.ne.jp','huOQL0','Nancy Foster',0,'http://dummyimage.com/209x205.png/dddddd/000000','http://dummyimage.com/382x327.bmp/5fa2dd/ffffff','Duis consequat dui nec nisi volutpat eleifend.','Philippines','La Paz','219 Center Crossing','63-(123)409-0848',1,0),(20,74,'dforda@ameblo.jp','7klHUE0QzsN7','Diana Ford',0,'http://dummyimage.com/186x228.png/cc0000/ffffff','http://dummyimage.com/309x468.png/ff4444/ffffff','Suspendisse potenti.','Indonesia','Rancaseneng','39 Arrowood Plaza','62-(145)870-4715',0,0),(21,98,'lharperb@wikimedia.org','2Qkog7fRlt','Laura Harper',1,'http://dummyimage.com/223x213.png/dddddd/000000','http://dummyimage.com/388x464.bmp/5fa2dd/ffffff','Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.','Indonesia','Sebewe','9 Mallard Lane','62-(402)922-0592',0,0),(22,19,'asullivanc@slashdot.org','EBzPUw','Amanda Sullivan',1,'http://dummyimage.com/160x117.bmp/dddddd/000000','http://dummyimage.com/288x417.png/cc0000/ffffff','Integer non velit.','Vietnam','Lào Cai','6 Longview Place','84-(550)330-8401',0,1),(23,10,'jgordond@mozilla.org','PmNeByrs6','Janet Gordon',0,'http://dummyimage.com/223x225.jpg/5fa2dd/ffffff','http://dummyimage.com/375x241.jpg/5fa2dd/ffffff','In eleifend quam a odio.','Kyrgyzstan','Kant','8 Carey Parkway','996-(895)422-7164',1,1),(24,43,'kwagnere@creativecommons.org','kWlOECpl0Qcm','Kathleen Wagner',0,'http://dummyimage.com/192x147.bmp/cc0000/ffffff','http://dummyimage.com/406x408.jpg/cc0000/ffffff','Vestibulum rutrum rutrum neque.','Morocco','Galaz','95 Lyons Hill','212-(826)910-0206',0,0),(25,67,'pmitchellf@squarespace.com','6PXWv33U','Paula Mitchell',1,'http://dummyimage.com/206x201.png/dddddd/000000','http://dummyimage.com/413x286.png/cc0000/ffffff','Integer a nibh.','China','Songhu','12 Caliangt Junction','86-(791)687-7975',1,1),(26,75,'hmillerg@amazon.com','2qJMMZ','Helen Miller',0,'http://dummyimage.com/111x174.bmp/dddddd/000000','http://dummyimage.com/474x338.jpg/dddddd/000000','Morbi vel lectus in quam fringilla rhoncus.','China','Xianan','4 Stang Street','86-(246)477-5980',1,1),(27,42,'smurrayh@cisco.com','EuLu2Zq3','Stephanie Murray',0,'http://dummyimage.com/115x164.jpg/cc0000/ffffff','http://dummyimage.com/436x460.bmp/cc0000/ffffff','Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.','Poland','Wiśniewo','795 Russell Hill','48-(608)317-9650',1,1),(28,57,'dgreenei@epa.gov','oFmjjPoNV','Diane Greene',1,'http://dummyimage.com/173x235.bmp/dddddd/000000','http://dummyimage.com/405x452.jpg/dddddd/000000','Donec semper sapien a libero.','Greece','Ayía Triás','9 Buena Vista Plaza','30-(449)383-9417',0,0),(29,81,'sreyesj@trellian.com','erd3nj8','Stephen Reyes',1,'http://dummyimage.com/161x239.bmp/5fa2dd/ffffff','http://dummyimage.com/281x446.jpg/dddddd/000000','Curabitur in libero ut massa volutpat convallis.','France','Brignoles','2 Tony Trail','33-(882)767-7331',1,1),(30,26,'jdeank@imageshack.us','bD75djAISrTd','Joyce Dean',1,'http://dummyimage.com/156x127.jpg/5fa2dd/ffffff','http://dummyimage.com/291x245.jpg/cc0000/ffffff','Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.','China','Gaoxiang','127 Autumn Leaf Junction','86-(829)634-4708',0,0),(31,95,'hmoralesl@gizmodo.com','WS0hKXRi0vu','Helen Morales',1,'http://dummyimage.com/193x136.jpg/ff4444/ffffff','http://dummyimage.com/415x321.jpg/cc0000/ffffff','Aenean sit amet justo.','China','Caohezhang','7 Mayer Place','86-(734)568-2503',0,1),(32,12,'lwatkinsm@amazonaws.com','bZS2hUxvBt8z','Louis Watkins',1,'http://dummyimage.com/182x247.bmp/dddddd/000000','http://dummyimage.com/226x491.png/ff4444/ffffff','Sed accumsan felis.','Japan','Miharu','724 Sheridan Drive','81-(356)830-3375',0,1),(33,83,'amitchelln@squidoo.com','E9xigNHmy','Amy Mitchell',0,'http://dummyimage.com/175x196.bmp/ff4444/ffffff','http://dummyimage.com/376x328.png/cc0000/ffffff','Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.','China','Yangyu','6101 Pepper Wood Crossing','86-(432)711-0172',1,0),(34,41,'agomezo@typepad.com','ZcQUmlPcbOo','Alan Gomez',0,'http://dummyimage.com/176x162.png/cc0000/ffffff','http://dummyimage.com/256x320.jpg/cc0000/ffffff','Sed vel enim sit amet nunc viverra dapibus.','Colombia','Pueblo Nuevo','53735 Monterey Circle','57-(838)537-1906',0,1),(35,27,'hcolep@moonfruit.com','arucGsxXCWQ','Henry Cole',0,'http://dummyimage.com/130x169.png/ff4444/ffffff','http://dummyimage.com/276x221.png/ff4444/ffffff','Donec ut dolor.','Argentina','San Roque','609 Tennessee Terrace','54-(846)431-7012',1,0),(36,84,'sbrooksq@blinklist.com','f0juUku8','Shawn Brooks',0,'http://dummyimage.com/142x218.bmp/cc0000/ffffff','http://dummyimage.com/381x433.jpg/dddddd/000000','Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.','Czech Republic','Černožice','1 Hallows Drive','420-(892)903-6685',1,0),(37,33,'baustinr@dot.gov','3PGN1zJjUirs','Beverly Austin',0,'http://dummyimage.com/147x222.jpg/dddddd/000000','http://dummyimage.com/382x325.bmp/dddddd/000000','Aenean auctor gravida sem.','Philippines','Bilaran','21 Warner Terrace','63-(746)367-6341',1,0),(38,56,'rreeds@freewebs.com','gXStNNdgr','Ryan Reed',1,'http://dummyimage.com/116x104.jpg/5fa2dd/ffffff','http://dummyimage.com/453x212.png/5fa2dd/ffffff','Nulla facilisi.','Ecuador','La Troncal','6266 Pleasure Point','593-(545)974-1052',0,1),(39,97,'wperkinst@imgur.com','pJornJ3hYR','Wayne Perkins',1,'http://dummyimage.com/116x131.bmp/ff4444/ffffff','http://dummyimage.com/324x361.bmp/ff4444/ffffff','Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.','Greece','Genisséa','598 School Trail','30-(446)201-8986',1,1),(40,74,'clewisu@springer.com','pYWFvrkQ3','Carolyn Lewis',1,'http://dummyimage.com/151x157.png/cc0000/ffffff','http://dummyimage.com/267x461.jpg/ff4444/ffffff','Vestibulum ac est lacinia nisi venenatis tristique.','Argentina','Famaillá','79011 Pepper Wood Park','54-(404)367-0443',0,0),(41,14,'jboydv@sciencedirect.com','HCspSr8Zj9CB','John Boyd',1,'http://dummyimage.com/101x246.bmp/dddddd/000000','http://dummyimage.com/400x332.bmp/dddddd/000000','Duis at velit eu est congue elementum.','China','Xiawuqi','6 Grayhawk Hill','86-(897)523-7962',0,0),(42,94,'challw@unblog.fr','dSd393','Christina Hall',0,'http://dummyimage.com/138x183.png/cc0000/ffffff','http://dummyimage.com/414x498.png/dddddd/000000','Duis at velit eu est congue elementum.','Bolivia','Oruro','0812 La Follette Plaza','591-(463)732-7468',0,1),(43,96,'jfullerx@seattletimes.com','Sd9w0KdN','Jane Fuller',0,'http://dummyimage.com/140x210.png/5fa2dd/ffffff','http://dummyimage.com/339x353.jpg/dddddd/000000','Ut tellus.','Kyrgyzstan','Isfana','6 Warbler Hill','996-(171)335-7969',0,1),(44,92,'akennedyy@yellowbook.com','ouYDBLhiz','Angela Kennedy',1,'http://dummyimage.com/246x226.png/ff4444/ffffff','http://dummyimage.com/269x420.bmp/cc0000/ffffff','Donec posuere metus vitae ipsum.','China','Muyi','8 Artisan Drive','86-(793)280-5308',0,1),(45,51,'jpalmerz@gnu.org','trskQheDvMC','Jeffrey Palmer',1,'http://dummyimage.com/187x131.jpg/5fa2dd/ffffff','http://dummyimage.com/303x268.jpg/ff4444/ffffff','Cras in purus eu magna vulputate luctus.','Yemen','Al Tuḩaytā’','303 Steensland Point','967-(305)831-4968',1,0),(46,17,'thenry10@go.com','Kfh0MBpb1','Thomas Henry',0,'http://dummyimage.com/234x205.jpg/dddddd/000000','http://dummyimage.com/280x312.jpg/cc0000/ffffff','Lorem ipsum dolor sit amet, consectetuer adipiscing elit.','China','Qintang','1 La Follette Way','86-(871)652-1364',1,0),(47,15,'fford11@craigslist.org','IBZ7gcdzm6g','Fred Ford',1,'http://dummyimage.com/169x142.bmp/dddddd/000000','http://dummyimage.com/261x318.jpg/dddddd/000000','Nunc purus.','Portugal','Vale da Bajouca','00 Northridge Junction','351-(336)168-0681',0,1),(48,52,'rchavez12@columbia.edu','8IjzQRJNViQ','Randy Chavez',0,'http://dummyimage.com/126x170.png/dddddd/000000','http://dummyimage.com/257x401.bmp/ff4444/ffffff','Curabitur gravida nisi at nibh.','Mali','Kolokani','9 Steensland Street','223-(359)412-8573',1,0),(49,40,'mfernandez13@ebay.com','2COvlNR','Melissa Fernandez',0,'http://dummyimage.com/207x131.png/5fa2dd/ffffff','http://dummyimage.com/481x208.png/5fa2dd/ffffff','Nulla mollis molestie lorem.','Greece','Dístomo','544 Luster Circle','30-(905)229-9138',0,0),(50,100,'kcarpenter14@miibeian.gov.cn','Mtjo4aMo0jY','Katherine Carpenter',1,'http://dummyimage.com/138x181.jpg/cc0000/ffffff','http://dummyimage.com/455x495.bmp/dddddd/000000','Praesent lectus.','United States','Pensacola','705 Corry Park','1-(850)772-1769',1,0),(51,52,'jbrown15@blog.com','Jz39IaG2uc','Janice Brown',1,'http://dummyimage.com/159x198.bmp/cc0000/ffffff','http://dummyimage.com/367x330.jpg/cc0000/ffffff','Suspendisse potenti.','Thailand','Saraburi','03866 Northview Road','66-(173)962-1222',1,1),(52,100,'bbell16@arizona.edu','cOFlAf','Beverly Bell',1,'http://dummyimage.com/151x230.jpg/5fa2dd/ffffff','http://dummyimage.com/378x472.png/cc0000/ffffff','Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.','Syria','Jablah','37 Waxwing Circle','963-(898)650-4511',1,1),(53,22,'mwhite17@amazon.co.uk','dZFYXWEKqlw','Marilyn White',0,'http://dummyimage.com/136x104.jpg/dddddd/000000','http://dummyimage.com/235x456.bmp/ff4444/ffffff','Nulla justo.','Poland','Czernikowo','37446 Schlimgen Junction','48-(456)855-0416',0,1),(54,59,'rmurphy18@lycos.com','Pts8RARf','Robert Murphy',0,'http://dummyimage.com/175x146.jpg/ff4444/ffffff','http://dummyimage.com/405x350.png/ff4444/ffffff','Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.','China','Zhongshan','1588 Anderson Road','86-(673)317-8762',0,0),(55,71,'phawkins19@eepurl.com','3cSCDu','Patrick Hawkins',0,'http://dummyimage.com/202x187.bmp/dddddd/000000','http://dummyimage.com/314x360.bmp/ff4444/ffffff','Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.','Portugal','Cruz','03942 Porter Drive','351-(792)911-2539',0,1),(56,50,'mnelson1a@who.int','jaQUfn','Mark Nelson',0,'http://dummyimage.com/229x237.bmp/5fa2dd/ffffff','http://dummyimage.com/469x401.jpg/ff4444/ffffff','Curabitur gravida nisi at nibh.','Yemen','Al Khirāb','14 Straubel Lane','967-(789)565-5723',0,1),(57,18,'rduncan1b@squidoo.com','Ds8iBZp','Robert Duncan',1,'http://dummyimage.com/150x117.jpg/dddddd/000000','http://dummyimage.com/492x430.jpg/5fa2dd/ffffff','Aliquam sit amet diam in magna bibendum imperdiet.','Poland','Celestynów','825 Dottie Road','48-(162)678-4192',0,0),(58,56,'istephens1c@whitehouse.gov','Jfxc4o','Irene Stephens',0,'http://dummyimage.com/123x227.png/dddddd/000000','http://dummyimage.com/397x266.png/dddddd/000000','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.','Portugal','Avelar','0992 Golf View Park','351-(546)854-1264',0,0),(59,93,'creed1d@mayoclinic.com','PLYIc2GecEQx','Charles Reed',1,'http://dummyimage.com/215x181.bmp/dddddd/000000','http://dummyimage.com/435x478.jpg/cc0000/ffffff','Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.','Bulgaria','Blagoevgrad','7181 Di Loreto Place','359-(677)255-3415',1,0),(60,47,'kmorgan1e@parallels.com','TH3zOjAPtgpz','Kathryn Morgan',0,'http://dummyimage.com/250x136.jpg/dddddd/000000','http://dummyimage.com/491x286.png/dddddd/000000','Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.','China','Longwei','69 Arapahoe Place','86-(335)926-3579',0,1),(61,16,'cbennett1f@skyrock.com','FaRuwBzOdGK','Cynthia Bennett',1,'http://dummyimage.com/116x200.jpg/ff4444/ffffff','http://dummyimage.com/480x465.png/ff4444/ffffff','Etiam justo.','Tanzania','Malya','9 Meadow Valley Court','255-(513)922-0317',1,0),(62,95,'jdavis1g@hao123.com','VgNdePb','James Davis',1,'http://dummyimage.com/220x192.jpg/ff4444/ffffff','http://dummyimage.com/305x446.jpg/dddddd/000000','In hac habitasse platea dictumst.','Philippines','Toledo','0 Swallow Pass','63-(200)212-6600',1,1),(63,95,'jhoward1h@dagondesign.com','S7Z75WN5kf','Johnny Howard',1,'http://dummyimage.com/118x102.jpg/5fa2dd/ffffff','http://dummyimage.com/279x225.jpg/dddddd/000000','Duis bibendum.','Chile','Salamanca','2 American Ash Plaza','56-(813)691-0992',1,0),(64,15,'shart1i@cargocollective.com','ILuoDlJ1','Sharon Hart',0,'http://dummyimage.com/123x153.jpg/cc0000/ffffff','http://dummyimage.com/207x476.png/5fa2dd/ffffff','Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.','China','Baiyanghe','0029 Manitowish Parkway','86-(423)587-4977',1,0),(65,30,'galexander1j@purevolume.com','ufW3T9OQ3g','Gerald Alexander',1,'http://dummyimage.com/113x121.jpg/ff4444/ffffff','http://dummyimage.com/389x453.png/dddddd/000000','Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.','Indonesia','Cabean','3 Boyd Junction','62-(788)310-7845',1,1),(66,64,'rromero1k@barnesandnoble.com','HCDORyx8oyT6','Randy Romero',1,'http://dummyimage.com/126x114.jpg/5fa2dd/ffffff','http://dummyimage.com/205x442.bmp/ff4444/ffffff','In eleifend quam a odio.','Thailand','Chang Klang','281 Darwin Parkway','66-(558)529-7160',1,0),(67,24,'dflores1l@t.co','KFbpBkNGBK','Deborah Flores',1,'http://dummyimage.com/237x223.bmp/5fa2dd/ffffff','http://dummyimage.com/300x241.png/5fa2dd/ffffff','Etiam vel augue.','Indonesia','Citalahab','9854 Longview Place','62-(481)351-0228',1,1),(68,49,'nmontgomery1m@epa.gov','08vDeR','Nicole Montgomery',0,'http://dummyimage.com/114x212.jpg/dddddd/000000','http://dummyimage.com/321x399.bmp/ff4444/ffffff','Nulla ac enim.','Greece','Dióni','13818 Starling Park','30-(970)991-3118',1,1),(69,94,'hwright1n@howstuffworks.com','UBp66vABTVW','Howard Wright',1,'http://dummyimage.com/228x153.png/ff4444/ffffff','http://dummyimage.com/345x328.bmp/5fa2dd/ffffff','Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.','Russia','Nesterovskaya','874 Clarendon Alley','7-(760)914-6380',1,1),(70,22,'vwashington1o@unesco.org','3VRaz5s8t','Virginia Washington',0,'http://dummyimage.com/147x165.jpg/ff4444/ffffff','http://dummyimage.com/256x259.jpg/cc0000/ffffff','Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.','Poland','Krasnystaw','4 Northwestern Alley','48-(626)382-9432',1,0),(71,12,'preed1p@so-net.ne.jp','9LbWnB','Patrick Reed',1,'http://dummyimage.com/108x156.png/cc0000/ffffff','http://dummyimage.com/233x434.jpg/dddddd/000000','Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.','France','Neuilly-sur-Seine','82607 Moulton Court','33-(428)735-2350',0,0),(72,110,'mxs2222@rit.edu','sherpa4life','Mali Mateo',0,'https://s-media-cache-ak0.pinimg.com/originals/0e/5a/50/0e5a50ba566b1e06a326567b0f46a3d1.png','http://www.index.hr/images3/0acf2b16-5d8d-4cb2-8366-7c7d4fdeb63b.jpg','Senior student at RIT','Croatia','Zagreb','27 Bleiweisova','62-(475)409-5772',1,0),(73,53,'jlittle1r@stumbleupon.com','AK2DWDE8dY','Jesse Little',1,'http://dummyimage.com/136x242.jpg/cc0000/ffffff','http://dummyimage.com/246x364.bmp/5fa2dd/ffffff','Morbi porttitor lorem id ligula.','China','Songbo','3512 Gale Circle','86-(839)366-6530',0,0),(74,75,'cnguyen1s@smugmug.com','VRjjuUv','Carol Nguyen',1,'http://dummyimage.com/181x247.png/dddddd/000000','http://dummyimage.com/433x305.png/dddddd/000000','In sagittis dui vel nisl.','France','Thiais','22 Donald Road','33-(798)741-5925',0,1),(75,70,'dberry1t@engadget.com','Ei2UWukPMR','Donald Berry',1,'http://dummyimage.com/152x199.bmp/cc0000/ffffff','http://dummyimage.com/465x494.jpg/5fa2dd/ffffff','In eleifend quam a odio.','United Kingdom','London','08012 Twin Pines Way','44-(879)240-2495',1,0),(76,23,'rbryant1u@blinklist.com','Je725D2augOS','Robert Bryant',1,'http://dummyimage.com/181x140.jpg/ff4444/ffffff','http://dummyimage.com/340x287.png/dddddd/000000','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.','Pakistan','Mithi','9 Stang Street','92-(650)222-3243',1,0),(77,25,'ngarcia1v@nytimes.com','XIZpVw','Nicholas Garcia',1,'http://dummyimage.com/115x221.jpg/5fa2dd/ffffff','http://dummyimage.com/273x360.bmp/5fa2dd/ffffff','Phasellus in felis.','China','Xinlong','6275 Moose Avenue','86-(291)952-7520',0,1),(78,30,'rfisher1w@cnet.com','B4UGOByQyeq','Roger Fisher',1,'http://dummyimage.com/239x220.bmp/cc0000/ffffff','http://dummyimage.com/426x332.bmp/5fa2dd/ffffff','In hac habitasse platea dictumst.','Philippines','Cassanayan','7 Carpenter Plaza','63-(808)911-4401',1,1),(79,47,'krodriguez1x@livejournal.com','FomzZx','Kathy Rodriguez',0,'http://dummyimage.com/134x223.png/ff4444/ffffff','http://dummyimage.com/331x306.jpg/dddddd/000000','Mauris ullamcorper purus sit amet nulla.','Mauritius','Olivia','92345 Messerschmidt Park','230-(389)154-9615',0,0),(80,78,'kwashington1y@pinterest.com','LVuT9YGhs','Kevin Washington',0,'http://dummyimage.com/195x247.jpg/dddddd/000000','http://dummyimage.com/251x350.png/cc0000/ffffff','Fusce posuere felis sed lacus.','Brazil','Jaru','6 Warbler Point','55-(768)802-7059',0,0),(81,11,'hwells1z@forbes.com','dZKdDTQ1ojhV','Henry Wells',1,'http://dummyimage.com/153x233.png/cc0000/ffffff','http://dummyimage.com/496x228.bmp/5fa2dd/ffffff','Nullam sit amet turpis elementum ligula vehicula consequat.','China','Heishan','0663 7th Circle','86-(223)574-3068',1,0),(82,89,'wwilson20@smh.com.au','XKrravkqS','Wayne Wilson',0,'http://dummyimage.com/239x201.jpg/ff4444/ffffff','http://dummyimage.com/496x468.png/ff4444/ffffff','Suspendisse potenti.','Sweden','Lidköping','554 Dovetail Lane','46-(742)543-8302',0,1),(83,48,'rhall21@icio.us','ERFWPG7m6','Roy Hall',0,'http://dummyimage.com/182x236.jpg/cc0000/ffffff','http://dummyimage.com/411x432.png/ff4444/ffffff','Nulla tempus.','Ukraine','Horodnya','10477 Coleman Parkway','380-(861)989-2754',1,1),(84,14,'malvarez22@va.gov','hNlpXUrb','Matthew Alvarez',0,'http://dummyimage.com/146x141.bmp/ff4444/ffffff','http://dummyimage.com/225x423.bmp/dddddd/000000','Duis bibendum.','China','Degan','523 Monica Avenue','86-(512)425-8112',1,0),(85,97,'lkim23@sohu.com','LPjQ294','Louise Kim',0,'http://dummyimage.com/117x152.bmp/dddddd/000000','http://dummyimage.com/500x204.jpg/ff4444/ffffff','Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.','Italy','Verona','0875 Jenifer Court','39-(508)284-8418',1,0),(86,20,'jharper24@dagondesign.com','vzJUEprh7','Jean Harper',0,'http://dummyimage.com/140x145.png/cc0000/ffffff','http://dummyimage.com/465x221.jpg/dddddd/000000','Mauris sit amet eros.','Sweden','Motala','171 Armistice Center','46-(282)751-8881',0,1),(87,16,'jsims25@utexas.edu','N2UPHQe3x','Joan Sims',0,'http://dummyimage.com/139x157.png/dddddd/000000','http://dummyimage.com/285x498.png/ff4444/ffffff','Integer non velit.','France','Bry-sur-Marne','60 Hollow Ridge Crossing','33-(503)135-9125',0,1),(88,72,'rcarter26@youku.com','DlGR5G','Ronald Carter',1,'http://dummyimage.com/160x222.jpg/cc0000/ffffff','http://dummyimage.com/323x493.bmp/ff4444/ffffff','Quisque ut erat.','Philippines','Hanggan','2 Upham Drive','63-(519)364-5812',0,1),(89,100,'sdixon27@china.com.cn','XnlQJVPA7','Steven Dixon',1,'http://dummyimage.com/166x178.png/5fa2dd/ffffff','http://dummyimage.com/483x444.png/dddddd/000000','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.','Indonesia','Ciseda','75335 East Terrace','62-(322)601-9693',0,0),(90,66,'awoods28@wikia.com','y7fkn0rIsZ','Antonio Woods',1,'http://dummyimage.com/165x246.bmp/5fa2dd/ffffff','http://dummyimage.com/354x352.bmp/cc0000/ffffff','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.','Panama','El Rincón','921 Buell Court','507-(975)648-8566',0,0),(91,90,'krobinson29@cnn.com','lRrF7E','Kathryn Robinson',1,'http://dummyimage.com/159x200.png/ff4444/ffffff','http://dummyimage.com/332x498.png/cc0000/ffffff','Duis aliquam convallis nunc.','Peru','Sibayo','0568 Acker Pass','51-(750)686-3871',1,0),(92,88,'amurphy2a@nih.gov','rwLNchGDsb','Anthony Murphy',0,'http://dummyimage.com/108x221.jpg/ff4444/ffffff','http://dummyimage.com/485x458.bmp/dddddd/000000','Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.','Russia','Ursk','177 Ridge Oak Point','7-(808)287-3168',0,0),(93,25,'bwelch2b@instagram.com','F38hC00dB3b','Brian Welch',0,'http://dummyimage.com/150x174.jpg/cc0000/ffffff','http://dummyimage.com/317x357.png/5fa2dd/ffffff','Fusce consequat.','Czech Republic','Rokytnice','4127 Eggendart Parkway','420-(507)211-9734',1,1),(94,87,'nbennett2c@cam.ac.uk','f3FoVARrKfu','Norma Bennett',1,'http://dummyimage.com/176x131.png/dddddd/000000','http://dummyimage.com/451x378.bmp/cc0000/ffffff','Proin at turpis a pede posuere nonummy.','Kazakhstan','Semey','00 Reindahl Terrace','7-(197)279-4776',0,1),(95,34,'vford2d@answers.com','bLLkqkr','Victor Ford',1,'http://dummyimage.com/153x119.png/ff4444/ffffff','http://dummyimage.com/319x461.jpg/cc0000/ffffff','Nam tristique tortor eu pede.','Iran','‘Abbāsābād','4 Golden Leaf Lane','98-(428)932-4008',1,0),(96,111,'cobus@rit.edu','znamHrvatski','Cobus Van der Walt',0,'http://st.depositphotos.com/1007566/2604/v/950/depositphotos_26046029-stock-illustration-human-profile.jpg','https://www.cia.gov/library/publications/the-world-factbook/graphics/flags/large/sf-lgflag.gif','Maglinator.','South Africa','Pretoria','1103 Gulseth Drive','51-(284)692-7274',1,0),(97,83,'ajohnson2f@newyorker.com','Gfc4fXZKkwjK','Andrew Johnson',1,'http://dummyimage.com/191x228.bmp/ff4444/ffffff','http://dummyimage.com/246x307.jpg/cc0000/ffffff','Vestibulum sed magna at nunc commodo placerat.','Croatia','Krapina','5658 Brentwood Park','385-(904)443-6264',0,0),(98,50,'rporter2g@paginegialle.it','9xZkD9lwiY','Roy Porter',1,'http://dummyimage.com/115x151.jpg/dddddd/000000','http://dummyimage.com/309x304.png/dddddd/000000','Phasellus in felis.','China','Banqiao','74605 Ramsey Drive','86-(627)639-6575',0,0),(99,46,'jharvey2h@google.cn','RU86Itz','Joseph Harvey',1,'http://dummyimage.com/183x147.png/5fa2dd/ffffff','http://dummyimage.com/460x296.bmp/dddddd/000000','Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.','Cuba','Jimaguayú','58695 Manley Plaza','53-(603)838-9202',1,1),(100,47,'sandrews2i@hibu.com','3Rf5GRN5','Stephen Andrews',1,'http://dummyimage.com/188x171.bmp/ff4444/ffffff','http://dummyimage.com/215x213.png/cc0000/ffffff','Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.','China','Jiuzhou','78 Dakota Plaza','86-(838)581-0617',1,1),(101,17,'nhansen2j@virginia.edu','C450v494ew','Norma Hansen',0,'http://dummyimage.com/162x227.jpg/dddddd/000000','http://dummyimage.com/496x320.jpg/5fa2dd/ffffff','Nam dui.','France','Abbeville','1237 Kennedy Trail','33-(811)132-0439',0,1),(102,63,'cchavez2k@tinyurl.com','1u5Uv5','Chris Chavez',1,'http://dummyimage.com/230x138.bmp/cc0000/ffffff','http://dummyimage.com/330x378.png/dddddd/000000','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.','Indonesia','Senggreng','1684 Fuller Plaza','62-(646)973-1817',1,1),(103,15,'jrose2l@cnbc.com','rhjrWI7Nue2','Jerry Rose',0,'http://dummyimage.com/175x211.bmp/ff4444/ffffff','http://dummyimage.com/465x324.jpg/dddddd/000000','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.','Colombia','Mompós','44132 Talmadge Trail','57-(629)978-3238',1,1),(104,93,'bjacobs2m@tinyurl.com','emYWfOXNkh','Benjamin Jacobs',0,'http://dummyimage.com/114x104.jpg/cc0000/ffffff','http://dummyimage.com/368x382.png/dddddd/000000','Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.','Indonesia','Cibeureum Satu','56791 Sundown Hill','62-(504)726-9953',1,0),(105,93,'rwilson2n@phoca.cz','D9f4k4TlesV','Ronald Wilson',1,'http://dummyimage.com/247x101.png/dddddd/000000','http://dummyimage.com/276x275.png/ff4444/ffffff','In congue.','Argentina','Rawson','18656 Artisan Avenue','54-(177)290-0677',1,0),(106,49,'tparker2o@biblegateway.com','huvvK9LjT','Tammy Parker',1,'http://dummyimage.com/132x116.png/5fa2dd/ffffff','http://dummyimage.com/402x276.png/5fa2dd/ffffff','Etiam faucibus cursus urna.','Portugal','Coutada','23553 New Castle Point','351-(996)611-7269',1,0),(107,98,'treyes2p@foxnews.com','IGo2Ilxf5d','Tina Reyes',0,'http://dummyimage.com/149x175.bmp/dddddd/000000','http://dummyimage.com/423x242.png/cc0000/ffffff','Nam dui.','France','Reims','30 Londonderry Court','33-(108)287-2282',0,0),(108,89,'redwards2q@hibu.com','KXYGPERtdbLx','Randy Edwards',0,'http://dummyimage.com/135x216.bmp/dddddd/000000','http://dummyimage.com/302x496.bmp/cc0000/ffffff','Morbi non lectus.','Cameroon','Bertoua','05875 Crownhardt Point','237-(404)756-8190',1,1),(109,80,'rwheeler2r@oakley.com','ZiqrzgMRLGH','Ronald Wheeler',1,'http://dummyimage.com/221x170.jpg/cc0000/ffffff','http://dummyimage.com/481x315.jpg/cc0000/ffffff','Cras in purus eu magna vulputate luctus.','Italy','Villanova','2 Manufacturers Hill','39-(474)149-2611',1,0),(110,63,'hjames2s@liveinternet.ru','v8paruXlC8J','Helen James',1,'http://dummyimage.com/156x168.png/dddddd/000000','http://dummyimage.com/236x375.jpg/cc0000/ffffff','Ut at dolor quis odio consequat varius.','Brazil','Guará','70473 Oneill Avenue','55-(784)741-4692',1,1),(111,90,'ssmith2t@freewebs.com','eBfB4vM','Scott Smith',0,'http://dummyimage.com/224x188.bmp/ff4444/ffffff','http://dummyimage.com/386x476.png/dddddd/000000','Proin eu mi.','Russia','Votkinsk','9400 Heath Center','7-(470)242-8045',0,0),(112,28,'chawkins2u@aol.com','7kbYLQczjN','Chris Hawkins',0,'http://dummyimage.com/166x159.png/cc0000/ffffff','http://dummyimage.com/340x317.jpg/ff4444/ffffff','Praesent blandit.','Kazakhstan','Kokshetau','762 Shopko Plaza','7-(238)105-4432',1,1),(113,95,'kjenkins2v@usda.gov','EtHa6jHdiQl','Kathryn Jenkins',0,'http://dummyimage.com/162x234.bmp/cc0000/ffffff','http://dummyimage.com/279x296.jpg/cc0000/ffffff','Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.','Indonesia','Karangora','22037 Portage Terrace','62-(241)972-3867',1,0),(114,49,'prichards2w@free.fr','Zt2XA8zcltzb','Peter Richards',0,'http://dummyimage.com/117x141.png/dddddd/000000','http://dummyimage.com/303x300.jpg/ff4444/ffffff','Phasellus in felis.','Tunisia','Oued Lill','2 Ohio Place','216-(529)401-5059',1,1),(115,86,'mstone2x@ask.com','XN4rKHLu','Margaret Stone',0,'http://dummyimage.com/129x159.jpg/cc0000/ffffff','http://dummyimage.com/355x426.bmp/cc0000/ffffff','Donec posuere metus vitae ipsum.','Russia','Zarechnyy','11 Carey Park','7-(236)136-7869',0,1),(116,37,'mferguson2y@boston.com','kd0LyJF','Michael Ferguson',0,'http://dummyimage.com/229x134.bmp/cc0000/ffffff','http://dummyimage.com/389x304.bmp/5fa2dd/ffffff','Maecenas ut massa quis augue luctus tincidunt.','France','Libourne','4 Donald Parkway','33-(284)542-7540',1,1),(117,59,'wrobinson2z@shinystat.com','uVh6NyQjoIL','Walter Robinson',1,'http://dummyimage.com/233x217.png/5fa2dd/ffffff','http://dummyimage.com/462x295.png/5fa2dd/ffffff','In blandit ultrices enim.','Thailand','Si Sa Ket','55875 Spenser Avenue','66-(653)148-8701',0,1),(118,57,'sanderson30@springer.com','MZxcJtwSijni','Sharon Anderson',0,'http://dummyimage.com/109x168.bmp/ff4444/ffffff','http://dummyimage.com/400x296.bmp/5fa2dd/ffffff','Integer tincidunt ante vel ipsum.','China','Yayao','1280 Ronald Regan Crossing','86-(529)789-7246',0,1),(119,81,'cford31@123-reg.co.uk','zlmsfU1qD','Carol Ford',0,'http://dummyimage.com/235x136.jpg/cc0000/ffffff','http://dummyimage.com/334x259.png/ff4444/ffffff','In quis justo.','Greece','Káto Dhiminió','5940 Anderson Drive','30-(890)133-6060',1,1),(120,55,'jjackson32@nps.gov','L8Zocwlid','Johnny Jackson',1,'http://dummyimage.com/123x243.bmp/dddddd/000000','http://dummyimage.com/321x295.png/ff4444/ffffff','Nunc purus.','China','Nanpu','4180 Mccormick Way','86-(698)556-5738',1,0),(121,12,'rgibson33@utexas.edu','qP941yue','Robin Gibson',1,'http://dummyimage.com/118x233.bmp/ff4444/ffffff','http://dummyimage.com/412x431.bmp/ff4444/ffffff','Suspendisse potenti.','China','Xihe','652 Fordem Avenue','86-(298)689-6414',0,0),(122,70,'lwright34@mayoclinic.com','BZ936Chg','Louis Wright',0,'http://dummyimage.com/213x235.jpg/dddddd/000000','http://dummyimage.com/411x339.jpg/ff4444/ffffff','Curabitur gravida nisi at nibh.','Indonesia','Gareba','97 Pennsylvania Drive','62-(709)623-1705',1,0),(123,29,'wmartinez35@shareasale.com','BIap89wl','Wanda Martinez',0,'http://dummyimage.com/106x249.png/ff4444/ffffff','http://dummyimage.com/316x295.png/cc0000/ffffff','Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.','China','Weixin','64 Vermont Junction','86-(510)146-0506',1,0),(124,80,'cpeterson36@people.com.cn','lgkKWdilI','Carol Peterson',0,'http://dummyimage.com/104x191.jpg/ff4444/ffffff','http://dummyimage.com/480x453.bmp/cc0000/ffffff','Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.','Indonesia','Sumbersih','45728 Redwing Street','62-(963)985-0720',1,0),(125,97,'ballen37@uiuc.edu','xWWfDk','Brenda Allen',0,'http://dummyimage.com/163x210.png/5fa2dd/ffffff','http://dummyimage.com/473x448.png/cc0000/ffffff','Duis bibendum.','Honduras','San Marcos','2708 Fairfield Lane','504-(834)977-0183',0,0),(126,80,'hcastillo38@purevolume.com','qsj9byxn','Howard Castillo',1,'http://dummyimage.com/238x206.bmp/ff4444/ffffff','http://dummyimage.com/337x351.jpg/5fa2dd/ffffff','Nam dui.','Brazil','Curitiba','77206 Randy Circle','55-(619)177-4473',1,0),(127,87,'cvasquez39@opera.com','iBKepim9','Carolyn Vasquez',1,'http://dummyimage.com/207x109.bmp/dddddd/000000','http://dummyimage.com/253x387.bmp/dddddd/000000','Etiam pretium iaculis justo.','Brazil','Rio Grande da Serra','37356 Knutson Parkway','55-(457)522-4867',1,1),(128,58,'dbell3a@buzzfeed.com','iEP2gr1x','Dorothy Bell',0,'http://dummyimage.com/119x141.png/cc0000/ffffff','http://dummyimage.com/436x379.bmp/ff4444/ffffff','Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.','Russia','Lebedyan’','9 Lotheville Hill','7-(986)932-7742',0,1),(129,41,'thall3b@nydailynews.com','9HnNrW','Todd Hall',0,'http://dummyimage.com/233x139.png/ff4444/ffffff','http://dummyimage.com/364x329.jpg/ff4444/ffffff','In quis justo.','Indonesia','Padurung','451 Hauk Parkway','62-(477)383-4157',1,0),(130,64,'sedwards3c@fc2.com','9Bc1Oi','Shawn Edwards',1,'http://dummyimage.com/228x123.png/dddddd/000000','http://dummyimage.com/444x403.bmp/5fa2dd/ffffff','Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.','Poland','Wieczfnia Kościelna','71 Tennyson Crossing','48-(505)742-9423',0,0),(131,68,'hwallace3d@sogou.com','PMSmbCoB','Helen Wallace',0,'http://dummyimage.com/185x113.png/dddddd/000000','http://dummyimage.com/271x297.bmp/5fa2dd/ffffff','Mauris ullamcorper purus sit amet nulla.','France','Rennes','74743 Grover Pass','33-(303)170-4631',1,1),(132,10,'dblack3e@ucla.edu','1PS8aWG7ItBg','Dorothy Black',0,'http://dummyimage.com/137x247.png/cc0000/ffffff','http://dummyimage.com/369x231.jpg/ff4444/ffffff','In hac habitasse platea dictumst.','Indonesia','Sangiang','25 Knutson Junction','62-(858)580-5637',0,1),(133,49,'hrice3f@bloglines.com','Udob4vNA','Heather Rice',0,'http://dummyimage.com/183x245.jpg/5fa2dd/ffffff','http://dummyimage.com/368x412.png/cc0000/ffffff','Vivamus vestibulum sagittis sapien.','Philippines','Estancia','1 Barby Hill','63-(162)842-3861',0,1),(134,75,'caustin3g@slideshare.net','CgsyOouv8xQ','Christina Austin',1,'http://dummyimage.com/171x177.png/cc0000/ffffff','http://dummyimage.com/250x443.bmp/cc0000/ffffff','Pellentesque viverra pede ac diam.','China','Jingouhe','74371 Schmedeman Crossing','86-(492)363-5815',1,1),(135,98,'rsimmons3h@cocolog-nifty.com','onHGWyCVZ','Ruth Simmons',0,'http://dummyimage.com/204x127.jpg/5fa2dd/ffffff','http://dummyimage.com/404x271.png/ff4444/ffffff','Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.','Bangladesh','Saidpur','579 International Pass','880-(217)327-6937',0,1),(136,77,'kjacobs3i@flavors.me','Lo7G6hKV','Kathryn Jacobs',1,'http://dummyimage.com/229x172.bmp/dddddd/000000','http://dummyimage.com/310x340.png/dddddd/000000','Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.','Portugal','Lousa','8554 Kenwood Parkway','351-(987)271-2863',0,1),(137,65,'jfuller3j@msn.com','n7XDR6oDMsa','Jack Fuller',1,'http://dummyimage.com/206x101.png/dddddd/000000','http://dummyimage.com/369x378.jpg/dddddd/000000','Duis at velit eu est congue elementum.','Indonesia','Caringin','2326 Meadow Vale Center','62-(375)123-4391',1,0),(138,31,'jchavez3k@accuweather.com','RpKPboli','Jennifer Chavez',0,'http://dummyimage.com/232x164.png/cc0000/ffffff','http://dummyimage.com/345x303.bmp/ff4444/ffffff','Nunc nisl.','Indonesia','Nguken','6 Mockingbird Junction','62-(265)360-5304',1,0),(139,28,'tcrawford3l@livejournal.com','TNdo7s5Z','Teresa Crawford',1,'http://dummyimage.com/152x187.bmp/cc0000/ffffff','http://dummyimage.com/252x470.jpg/5fa2dd/ffffff','Pellentesque eget nunc.','China','Chenzhouzhai','52900 Dixon Point','86-(341)102-4888',0,0),(140,100,'kreyes3m@disqus.com','UhMwMZzMKP','Kathy Reyes',1,'http://dummyimage.com/164x173.jpg/ff4444/ffffff','http://dummyimage.com/363x355.png/cc0000/ffffff','Pellentesque ultrices mattis odio.','Ukraine','Pryluky','19 Prairieview Street','380-(665)846-2915',1,0),(141,49,'dbowman3n@webs.com','wNR44EnX','Donna Bowman',0,'http://dummyimage.com/235x205.png/5fa2dd/ffffff','http://dummyimage.com/443x277.jpg/ff4444/ffffff','Nulla ac enim.','China','Hedong','6812 Schlimgen Junction','86-(242)111-0596',0,1),(142,88,'awhite3o@pen.io','jcbcVwE6Z','Anthony White',1,'http://dummyimage.com/118x236.bmp/ff4444/ffffff','http://dummyimage.com/216x365.jpg/ff4444/ffffff','Donec semper sapien a libero.','Mali','Markala','89 Bartillon Drive','223-(698)403-6046',0,1),(143,86,'cgutierrez3p@freewebs.com','W79wtp','Craig Gutierrez',1,'http://dummyimage.com/153x161.bmp/cc0000/ffffff','http://dummyimage.com/372x342.png/ff4444/ffffff','Etiam pretium iaculis justo.','Russia','Berëzovka','302 Alpine Place','7-(625)250-7653',1,1),(144,65,'jaustin3q@phoca.cz','ohvr0uA7','Juan Austin',0,'http://dummyimage.com/184x190.png/dddddd/000000','http://dummyimage.com/357x491.png/ff4444/ffffff','Pellentesque viverra pede ac diam.','Argentina','Daireaux','1 Weeping Birch Way','54-(325)578-2005',1,1),(145,93,'lwatkins3r@ustream.tv','iXnqx9ZmRSXp','Lillian Watkins',0,'http://dummyimage.com/134x215.jpg/5fa2dd/ffffff','http://dummyimage.com/421x496.bmp/cc0000/ffffff','Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.','Indonesia','Babakanloa','07073 Gina Avenue','62-(879)171-3232',0,1),(146,30,'alopez3s@mediafire.com','uzEd5CtX4Pk','Annie Lopez',0,'http://dummyimage.com/120x116.png/ff4444/ffffff','http://dummyimage.com/392x366.png/ff4444/ffffff','Quisque ut erat.','Brazil','Cururupu','46809 Ilene Court','55-(447)732-5193',1,0),(147,78,'cmorris3t@phoca.cz','wcBYzVm','Catherine Morris',1,'http://dummyimage.com/111x160.png/5fa2dd/ffffff','http://dummyimage.com/276x405.png/cc0000/ffffff','Sed accumsan felis.','France','Rouen','9 4th Plaza','33-(962)714-6037',0,1),(148,13,'fkelley3u@independent.co.uk','S6OICVY','Fred Kelley',0,'http://dummyimage.com/177x100.png/5fa2dd/ffffff','http://dummyimage.com/291x215.bmp/dddddd/000000','Aenean lectus.','China','Altunemil','18 Bashford Terrace','86-(732)231-0537',0,0),(149,81,'sperry3v@nps.gov','ZjZO4Tp','Shawn Perry',1,'http://dummyimage.com/134x198.jpg/5fa2dd/ffffff','http://dummyimage.com/422x304.png/5fa2dd/ffffff','Suspendisse accumsan tortor quis turpis.','France','Belfort','91 Fairview Place','33-(771)603-3563',1,1),(150,27,'dwatson3w@huffingtonpost.com','lsNKkWFu74','Donald Watson',0,'http://dummyimage.com/244x213.bmp/ff4444/ffffff','http://dummyimage.com/231x327.bmp/5fa2dd/ffffff','In quis justo.','Russia','Engel’s','36244 Stuart Trail','7-(993)881-5943',1,1),(151,86,'bcarter3x@odnoklassniki.ru','UXymLL1WP3','Bobby Carter',1,'http://dummyimage.com/173x124.jpg/dddddd/000000','http://dummyimage.com/387x492.png/5fa2dd/ffffff','Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.','Russia','Yazykovo','7876 Ohio Alley','7-(805)853-5037',0,0),(152,22,'cowens3y@nhs.uk','eEEv1vr','Cynthia Owens',1,'http://dummyimage.com/105x147.png/5fa2dd/ffffff','http://dummyimage.com/392x229.jpg/cc0000/ffffff','Praesent id massa id nisl venenatis lacinia.','Poland','Polańczyk','40805 Washington Way','48-(160)728-2683',0,0),(153,80,'blee3z@weather.com','yT5qJgVvy','Benjamin Lee',1,'http://dummyimage.com/140x209.bmp/ff4444/ffffff','http://dummyimage.com/211x338.png/ff4444/ffffff','Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.','Indonesia','Lewolen','3007 Hallows Park','62-(870)768-8917',0,1),(154,14,'dsims40@harvard.edu','xTTgW9AoI','Diane Sims',0,'http://dummyimage.com/250x172.bmp/ff4444/ffffff','http://dummyimage.com/443x400.png/dddddd/000000','Nulla tempus.','Vietnam','Tiên Lãng','77 Fulton Park','84-(100)938-0589',1,1),(155,88,'fmurray41@i2i.jp','yKFVw7ZN8','Frances Murray',1,'http://dummyimage.com/191x240.bmp/dddddd/000000','http://dummyimage.com/450x275.bmp/cc0000/ffffff','Etiam vel augue.','Malaysia','Seremban','5034 Hagan Hill','60-(276)506-6820',0,1),(156,50,'iperkins42@berkeley.edu','e2UoS4P','Irene Perkins',1,'http://dummyimage.com/148x199.png/5fa2dd/ffffff','http://dummyimage.com/260x266.bmp/dddddd/000000','Donec ut mauris eget massa tempor convallis.','Indonesia','Nangkasari','1 Cambridge Place','62-(395)356-8897',1,1),(157,17,'rmorrison43@wired.com','iDgbqc','Richard Morrison',1,'http://dummyimage.com/103x194.png/cc0000/ffffff','http://dummyimage.com/206x405.bmp/ff4444/ffffff','Pellentesque eget nunc.','Sweden','Haninge','86 Fuller Trail','46-(796)629-2485',0,1),(158,93,'kwilliams44@barnesandnoble.com','GNRS2tzK3','Kathy Williams',1,'http://dummyimage.com/180x236.jpg/cc0000/ffffff','http://dummyimage.com/296x375.bmp/ff4444/ffffff','In hac habitasse platea dictumst.','Peru','Cochabamba','577 International Street','51-(153)557-7651',0,0),(159,62,'cray45@photobucket.com','XNwe5yla','Clarence Ray',1,'http://dummyimage.com/138x212.bmp/dddddd/000000','http://dummyimage.com/367x424.bmp/dddddd/000000','Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.','Russia','Ust’-Donetskiy','1171 Barnett Way','7-(653)867-7479',0,1),(160,NULL,'user@sherpa.com','user','USER',0,'http://dummyimage.com/138x212.bmp/dddddd/000000','http://dummyimage.com/138x212.bmp/dddddd/000000','TEST USER','Croatia','Zagreb','Ilica 1','+3859890000',1,1),(161,106,'gjuro@gej_society.gej','gjuro','Gjuro Gej',0,'http://dummyimage.com/138x212.bmp/dddddd/000000','http://dummyimage.com/138x212.bmp/dddddd/000000',NULL,NULL,'10000, Zagreb',NULL,NULL,0,0),(163,108,'gjuro2@gej_society.gej','gjuro','Gjuro Gej',0,'http://dummyimage.com/138x212.bmp/dddddd/000000','http://dummyimage.com/138x212.bmp/dddddd/000000',NULL,NULL,'10000, Zagreb',NULL,NULL,1,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-13 16:00:59
