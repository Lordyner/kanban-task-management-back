CREATE DATABASE  IF NOT EXISTS `kanban-task-manager-database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `kanban-task-manager-database`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: kanban-task-manager-database
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'Platform Launch'),(2,'Marketing Plan'),(3,'Roadmap');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boardcolumn`
--

DROP TABLE IF EXISTS `boardcolumn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `boardcolumn` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `id_board` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_BOARD_ID_idx` (`id_board`),
  CONSTRAINT `FK_BOARD_ID` FOREIGN KEY (`id_board`) REFERENCES `board` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boardcolumn`
--

LOCK TABLES `boardcolumn` WRITE;
/*!40000 ALTER TABLE `boardcolumn` DISABLE KEYS */;
INSERT INTO `boardcolumn` VALUES (1,'Todo',1),(2,'Doing',1),(3,'Done',1),(4,'Todo',2),(5,'Doing',2),(6,'Done',2),(7,'Now',3),(8,'Next',3),(9,'Later',3);
/*!40000 ALTER TABLE `boardcolumn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subtask`
--

DROP TABLE IF EXISTS `subtask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subtask` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` mediumtext NOT NULL,
  `isCompleted` tinyint NOT NULL,
  `id_task` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_TASK_ID_idx` (`id_task`),
  CONSTRAINT `FK_TASK_ID` FOREIGN KEY (`id_task`) REFERENCES `task` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subtask`
--

LOCK TABLES `subtask` WRITE;
/*!40000 ALTER TABLE `subtask` DISABLE KEYS */;
INSERT INTO `subtask` VALUES (4,'Sign up page',1,1),(5,'Sign in page',1,1),(6,'Welcome page',1,1),(7,'Search page',1,2),(8,'Account page',0,3),(9,'Billing page',0,3),(10,'Internal testing',0,4),(11,'External testing',0,4),(12,'Settings - Account page',1,5),(13,'Settings - Billing page',1,5),(14,'Search page',0,5),(15,'Upgrade plan',1,6),(16,'Cancel plan',1,6),(17,'Update payment method',0,6),(18,'Sign up page',1,7),(19,'Sign in page',0,7),(20,'Welcome page',0,7),(21,'Add search endpoint',1,8),(22,'Define search filters',0,8),(23,'Define user model',1,9),(24,'Add auth endpoints',0,9),(25,'Research competitor pricing and business models',1,10),(26,'Outline a business model that works for our solution',1,10),(27,'Talk to potential customers about our proposed solution and ask for fair price expectancy',1,10),(28,'Complete 5 wireframe prototype tests',1,11),(29,'Create clickable wireframe prototype in Balsamiq',1,12),(30,'Meet to review notes from previous tests and plan changes',1,13),(31,'Make changes to paper prototypes',1,13),(32,'Conduct 5 usability tests',1,13),(33,'Create paper prototypes for version one',1,14),(34,'Complete 10 usability tests',1,14),(35,'Interview 10 prospective customers',1,15),(36,'Find direct and indirect competitors',1,16),(37,'SWOT analysis for each competitor',1,16),(38,'Write up research analysis',1,17),(39,'Calculate TAM',1,17),(40,'Find hunter',0,18),(41,'Gather assets',0,18),(42,'Draft product page',0,18),(43,'Notify customers',0,18),(44,'Notify network',0,18),(45,'Launch!',0,18),(46,'Draft out HN post',0,19),(47,'Get feedback and refine',0,19),(48,'Publish post',0,19),(49,'Write article',0,20),(50,'Publish on LinkedIn',0,20),(51,'Publish on Inndie Hackers',0,20),(52,'Publish on Medium',0,20),(53,'Launch privately to our waitlist',0,21),(54,'Launch publicly on PH, HN, etc.',0,21),(55,'Interview 10 customers',0,22),(56,'Review common customer pain points and suggestions',0,22),(57,'Outline next steps for our roadmap',0,22);
/*!40000 ALTER TABLE `subtask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_column` int DEFAULT NULL,
  `title` mediumtext NOT NULL,
  `description` longtext,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_COLUMN_ID_idx` (`id_column`),
  CONSTRAINT `FK_COLUMN_ID` FOREIGN KEY (`id_column`) REFERENCES `boardcolumn` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,2,'Build UI for onboarding flow','','Doing'),(2,3,'Build UI for search','','Done'),(3,1,'Build settings UI','','Todo'),(4,1,'QA and test all major user journeys','Once we feel version one is ready, we need to rigorously test it both internally and externally to identify any major gaps.','Todo'),(5,5,'Design settings and search pages','','Doing'),(6,6,'Add account management endpoints','','Doing'),(7,7,'Design onboarding flow','','Doing'),(8,8,'Add search enpoints','','Doing'),(9,9,'Add authentication endpoints','','Doing'),(10,1,'Research pricing points of various competitors and trial different business models','We know what we\'re planning to build for version one. Now we need to finalise the first pricing model we\'ll use. Keep iterating the subtasks until we have a coherent proposition.','Todo'),(11,3,'Conduct 5 wireframe tests','Ensure the layout continues to make sense and we have strong buy-in from potential users.','Done'),(12,3,'Create wireframe prototype','Create a greyscale clickable wireframe prototype to test our asssumptions so far.','Done'),(13,3,'Review results of usability tests and iterate','Keep iterating through the subtasks until we\'re clear on the core concepts for the app.','Done'),(14,3,'Create paper prototypes and conduct 10 usability tests with potential customers','','Done'),(15,3,'Market discovery','We need to define and refine our core product. Interviews will help us learn common pain points and help us define the strongest MVP.','Done'),(16,3,'Competitor analysis','','Done'),(17,3,'Research the market','We need to get a solid overview of the market to ensure we have up-to-date estimates of market size and demand.','Done'),(18,4,'Plan Product Hunt launch','','Todo'),(19,4,'Share on Show HN','','Todo'),(20,4,'Write launch article to publish on multiple channels','','Todo'),(21,7,'Launch version one','','Now'),(22,7,'Review early feedback and plan next steps for roadmap','Beyond the initial launch, we\'re keeping the initial roadmap completely empty. This meeting will help us plan out our next steps based on actual customer feedback.','Now'),(23,8,'Add search enpoints','','Doing'),(24,6,'Add account management endpoints','','Doing'),(25,6,'Add account management endpoints','','Doing'),(26,7,'Design onboarding flow','','Doing');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-11 18:04:31
