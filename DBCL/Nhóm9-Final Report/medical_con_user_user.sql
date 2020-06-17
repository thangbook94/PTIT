-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medical_con_user
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `cmt` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `hoten` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `region` int DEFAULT NULL,
  `salary` decimal(18,0) DEFAULT NULL,
  `allowance` decimal(18,0) DEFAULT NULL,
  `train` varchar(5) DEFAULT NULL,
  `warning` varchar(5) DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `money` decimal(18,0) DEFAULT NULL,
  `statuscal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cmt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('111111111','3ec07f0c27cc6488f41524f3b912ea13381d4cea','tientt@gmail.com','Tran The Tien','19/05/1998','yes',1,4950400,1469211,'yes','yes','bat buoc',674059,'yes'),('222222222','3ec07f0c27cc6488f41524f3b912ea13381d4cea','thaotd@gmail.com','Tran Dinh Thao','22/02/1998','yes',2,23132321,44433060,'no','yes','tu nguyen',14864384,'yes'),('333333333','f1ce550de341d7f6d34babc02d2fce8039e813f1','thunt@gmail.com','Nguyen Thi Thu','21/12/1998','yes',3,29800000,188679814,'yes','no','bat buoc',22940380,'yes');
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

-- Dump completed on 2020-06-13 10:01:30
