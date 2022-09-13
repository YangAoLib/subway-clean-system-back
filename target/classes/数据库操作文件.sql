-- MariaDB dump 10.19  Distrib 10.6.4-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: subway_clean
-- ------------------------------------------------------
-- Server version	10.6.4-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file_info`
--

DROP TABLE IF EXISTS `file_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `description` varchar(50) DEFAULT NULL COMMENT '文件描述',
  `origin_name` varchar(255) DEFAULT NULL COMMENT '文件原名',
  `current_name` varchar(255) DEFAULT NULL COMMENT '文件生成名',
  `file_type` int(1) DEFAULT NULL COMMENT '文件类型(0-点云、1-图片、2-其他模型文件)',
  `file_address` varchar(255) DEFAULT NULL COMMENT '文件存储路径',
  `obj_id` int(11) DEFAULT NULL COMMENT '所属对象id',
  `obj_type` int(1) DEFAULT NULL COMMENT '所属对象类型(0-车辆信息、1-车厢信息,2-零件信息)',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `deleted` int(1) DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COMMENT='文件存储信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_info`
--

LOCK TABLES `file_info` WRITE;
/*!40000 ALTER TABLE `file_info` DISABLE KEYS */;
INSERT INTO `file_info` VALUES (1,'一个测试文件','原名1','生成名1',0,'文件地址1',1,1,'2022-08-24 11:00:20',NULL,0),(2,'一个测试文件','原名2','生成名2',1,'文件地址2',1,1,'2022-08-24 11:01:23',NULL,0),(3,'一个测试文件','原名3','生成名3',2,'文件地址3',1,1,'2022-08-24 11:01:23',NULL,0),(4,'一个测试文件','原名4','生成名4',0,'文件地址4',2,1,'2022-08-24 11:02:04',NULL,0),(5,'一个测试文件','原名5','生成名5',1,'文件地址5',2,1,'2022-08-24 11:02:46','2022-08-24 11:03:16',0),(6,'一个测试文件','原名6','生成名6',2,'文件地址6',2,1,'2022-08-24 11:02:46','2022-08-24 11:03:16',0),(7,'一个测试文件','原名7','生成名7',0,'文件地址7',3,1,'2022-08-24 11:03:16',NULL,0),(8,'一个测试文件','原名8','生成名8',1,'文件地址8',3,1,'2022-08-24 11:04:39',NULL,0),(9,'一个测试文件','原名9','生成名9',2,'文件地址9',3,1,'2022-08-24 11:04:39',NULL,0),(10,'测试描述','测试原名','测试生成名',0,'测试地址',1,2,'2022-08-25 11:33:35',NULL,0),(11,'测试描述','测试原名','测试生成名',1,'测试地址',1,2,'2022-08-25 11:33:37',NULL,0),(12,'测试描述','测试原名','测试生成名',2,'测试地址',1,2,'2022-08-25 11:33:37',NULL,0),(13,'测试描述','测试原名','测试生成名',0,'测试地址',2,2,'2022-08-25 11:33:37',NULL,0),(14,'测试描述','测试原名','测试生成名',1,'测试地址',2,2,'2022-08-25 11:33:37',NULL,0),(15,'测试描述','测试原名','测试生成名',2,'测试地址',2,2,'2022-08-25 11:33:37',NULL,0),(16,'测试描述','测试原名','测试生成名',0,'测试地址',3,2,'2022-08-25 11:33:37',NULL,0),(17,'测试描述','测试原名','测试生成名',1,'测试地址',3,2,'2022-08-25 11:33:37',NULL,0),(18,'测试描述','测试原名','测试生成名',2,'测试地址',3,2,'2022-08-25 11:33:37',NULL,0),(19,'测试描述','测试原名','测试生成名',0,'测试地址',4,2,'2022-08-25 11:33:37',NULL,0),(20,'测试描述','测试原名','测试生成名',1,'测试地址',4,2,'2022-08-25 11:33:37',NULL,0),(21,'测试描述','测试原名','测试生成名',2,'测试地址',4,2,'2022-08-25 11:33:37',NULL,0),(22,'测试描述','测试原名','测试生成名',0,'测试地址',5,2,'2022-08-25 11:33:37',NULL,0),(23,'测试描述','测试原名','测试生成名',1,'测试地址',5,2,'2022-08-25 11:33:37',NULL,0),(24,'测试描述','测试原名','测试生成名',2,'测试地址',5,2,'2022-08-25 11:33:37',NULL,0),(25,'测试描述','测试原名','测试生成名',0,'测试地址',6,2,'2022-08-25 11:33:37',NULL,0),(26,'测试描述','测试原名','测试生成名',1,'测试地址',6,2,'2022-08-25 11:33:37',NULL,0),(27,'测试描述','测试原名','测试生成名',2,'测试地址',6,2,'2022-08-25 11:33:37',NULL,0),(28,'测试描述','测试原名','测试生成名',0,'测试地址',7,2,'2022-08-25 11:33:37',NULL,0),(29,'测试描述','测试原名','测试生成名',1,'测试地址',7,2,'2022-08-25 11:33:37',NULL,0),(30,'测试描述','测试原名','测试生成名',2,'测试地址',7,2,'2022-08-25 11:33:37',NULL,0),(31,'测试描述','测试原名','测试生成名',0,'测试地址',8,2,'2022-08-25 11:33:37',NULL,0),(32,'测试描述','测试原名','测试生成名',1,'测试地址',8,2,'2022-08-25 11:33:37',NULL,0),(33,'测试描述','测试原名','测试生成名',2,'测试地址',8,2,'2022-08-25 11:33:37',NULL,0),(34,'测试描述','测试原名','测试生成名',0,'测试地址',9,2,'2022-08-25 11:33:37',NULL,0),(35,'测试描述','测试原名','测试生成名',1,'测试地址',9,2,'2022-08-25 11:33:37',NULL,0),(36,'测试描述','测试原名','测试生成名',2,'测试地址',9,2,'2022-08-25 11:33:37',NULL,0),(37,'测试描述','测试原名','测试生成名',0,'测试地址',10,2,'2022-08-25 11:33:37',NULL,0),(38,'测试描述','测试原名','测试生成名',1,'测试地址',10,2,'2022-08-25 11:33:37',NULL,0),(39,'测试描述','测试原名','测试生成名',2,'测试地址',10,2,'2022-08-25 11:33:37',NULL,0);
/*!40000 ALTER TABLE `file_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '零件id',
  `name` varchar(20) DEFAULT NULL COMMENT '零件名称',
  `side` int(1) DEFAULT NULL COMMENT '零件所属面(0-右侧, 1-左侧, 2-底部)——零件是哪个面的',
  `position` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '坐标(x:0, y:0)' CHECK (json_valid(`position`)),
  `three_position` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '三维坐标(x: 0, y:0, z:0)' CHECK (json_valid(`three_position`)),
  `description` varchar(60) DEFAULT NULL COMMENT '具体描述(车型+车厢+零件名)',
  `subway_carriage_id` int(11) DEFAULT NULL COMMENT '车厢id',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `deleted` int(1) DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COMMENT='零件信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": \"50\", \"y\": \"30\", \"z\": \"30\"}','一车型|二车厢|测试零件',2,'2022-08-23 11:49:42',NULL,0),(2,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": \"50\", \"y\": \"30\", \"z\": \"30\"}','一车型|二车厢|测试零件',2,'2022-08-23 14:17:55','2022-08-25 09:41:13',0),(3,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:33','2022-09-04 13:41:08',0),(4,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(5,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(6,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(7,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(8,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(9,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(10,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(11,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(12,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:09',0),(13,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:09',0),(14,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(15,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(16,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(17,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(18,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(19,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(20,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(21,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(22,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(23,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(24,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:09',0),(25,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:09',0),(26,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(27,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(28,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(29,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(30,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:09',0),(31,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:09',0),(32,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:41:35','2022-09-04 13:41:08',0),(33,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:43',NULL,0),(34,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(35,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(36,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(37,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(38,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(39,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(40,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(41,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(42,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(43,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(44,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(45,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(46,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(47,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(48,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(49,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(50,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(51,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(52,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(53,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(54,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(55,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(56,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(57,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(58,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(59,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(60,'测试零件',0,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(61,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(62,'测试零件',2,'{\"x\": 50, \"y\": 50}','{\"x\": 50, \"y\": 50, \"z\": 50}','测试零件',1,'2022-08-25 11:45:45',NULL,0),(63,'测试零件',1,'{\"x\": 50, \"y\": 50}','{\"x\": \"50\", \"y\": \"30\", \"z\": \"30\"}','一车型|二车厢|测试零件',2,'2022-08-25 15:36:28',NULL,0);
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part_clean_history`
--

DROP TABLE IF EXISTS `part_clean_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part_clean_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '零件清理记录id',
  `part_id` int(11) DEFAULT NULL COMMENT '被清理的零件id',
  `status` int(1) DEFAULT NULL COMMENT '清理状态(0-未开始(默认)、1-完成、2-终止)',
  `clean_history_id` int(11) DEFAULT NULL COMMENT '地铁清理历史记录id',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '清理开始的时间',
  `end_time` datetime DEFAULT NULL COMMENT '清理结束时间',
  `deleted` int(1) DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='零件清理历史记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_clean_history`
--

LOCK TABLES `part_clean_history` WRITE;
/*!40000 ALTER TABLE `part_clean_history` DISABLE KEYS */;
INSERT INTO `part_clean_history` VALUES (1,1,0,1,'2022-08-25 16:03:03',NULL,0),(2,2,0,1,'2022-08-25 16:03:03',NULL,0),(3,3,0,1,'2022-08-25 16:03:03',NULL,0),(4,1,0,2,'2022-08-25 16:09:42',NULL,0),(5,2,0,2,'2022-08-25 16:09:42',NULL,0),(6,3,0,2,'2022-08-25 16:09:42',NULL,0);
/*!40000 ALTER TABLE `part_clean_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subway`
--

DROP TABLE IF EXISTS `subway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subway` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地铁id',
  `name` varchar(8) DEFAULT NULL COMMENT '地铁名',
  `subway_type_id` int(11) DEFAULT NULL COMMENT '地铁型号id',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `deleted` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='地铁信息数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subway`
--

LOCK TABLES `subway` WRITE;
/*!40000 ALTER TABLE `subway` DISABLE KEYS */;
INSERT INTO `subway` VALUES (1,'测试地铁1',1,'2022-08-24 10:48:57',NULL,0);
/*!40000 ALTER TABLE `subway` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subway_carriage`
--

DROP TABLE IF EXISTS `subway_carriage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subway_carriage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地铁车厢id',
  `name` varchar(50) DEFAULT NULL COMMENT '地铁车厢名称',
  `num` int(11) DEFAULT NULL COMMENT '车厢编号(第几节车厢)',
  `subway_type_id` int(11) DEFAULT NULL COMMENT '所属地铁型号id',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `deleted` int(1) DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='地铁车厢数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subway_carriage`
--

LOCK TABLES `subway_carriage` WRITE;
/*!40000 ALTER TABLE `subway_carriage` DISABLE KEYS */;
INSERT INTO `subway_carriage` VALUES (1,'车型1 车厢1',1,1,'2022-08-24 10:49:55','2022-08-24 11:07:04',0),(2,'车型1 车厢2',2,1,'2022-08-24 10:54:44',NULL,0),(3,'车型1 车厢3',3,1,'2022-08-24 10:54:44',NULL,0),(4,'车型2 车厢1',1,2,'2022-08-24 11:09:28',NULL,0);
/*!40000 ALTER TABLE `subway_carriage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subway_clean_history`
--

DROP TABLE IF EXISTS `subway_clean_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subway_clean_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地铁清理记录id',
  `subway_id` int(11) DEFAULT NULL COMMENT '清理的地铁id',
  `pattern` int(1) DEFAULT NULL COMMENT '清理模式(0-简易清理、深度清理)',
  `status` int(1) DEFAULT 0 COMMENT '清理状态(0-进行中(默认)、1-完成、2-终止)',
  `clean_progress` int(3) DEFAULT NULL COMMENT '清理进度',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '清理开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '清理结束时间',
  `deleted` int(1) DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  `handler` varchar(20) DEFAULT NULL COMMENT '处理人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='地铁清理历史记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subway_clean_history`
--

LOCK TABLES `subway_clean_history` WRITE;
/*!40000 ALTER TABLE `subway_clean_history` DISABLE KEYS */;
INSERT INTO `subway_clean_history` VALUES (1,1,NULL,0,0,'2022-08-25 16:03:02',NULL,0,NULL),(2,1,0,0,0,'2022-08-25 16:09:42',NULL,0,NULL);
/*!40000 ALTER TABLE `subway_clean_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subway_type`
--

DROP TABLE IF EXISTS `subway_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subway_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地铁型号id',
  `name` varchar(11) DEFAULT NULL COMMENT '地铁型号名称',
  `create_time` datetime DEFAULT current_timestamp() COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE current_timestamp() COMMENT '更新时间',
  `deleted` int(1) DEFAULT 0 COMMENT '逻辑删除位: 0-未删除, 1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='地铁类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subway_type`
--

LOCK TABLES `subway_type` WRITE;
/*!40000 ALTER TABLE `subway_type` DISABLE KEYS */;
INSERT INTO `subway_type` VALUES (1,'车型1','2022-08-24 10:49:23','2022-09-04 13:15:23',0);
/*!40000 ALTER TABLE `subway_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'subway_clean'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-06 14:18:31
