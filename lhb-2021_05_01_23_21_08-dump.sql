-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: personnel
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance_inf`
--

DROP TABLE IF EXISTS `attendance_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance_inf` (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `day` varchar(20) DEFAULT NULL,
  `record1` varchar(20) DEFAULT NULL COMMENT '上午上班时间',
  `record2` varchar(20) DEFAULT NULL COMMENT '上午下班时间',
  `record3` varchar(20) DEFAULT NULL COMMENT '下午上班时间',
  `record4` varchar(20) DEFAULT NULL COMMENT '下午下班时间',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`attendance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='考勤表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance_inf`
--

LOCK TABLES `attendance_inf` WRITE;
/*!40000 ALTER TABLE `attendance_inf` DISABLE KEYS */;
INSERT INTO `attendance_inf` VALUES (1,5,'李厚波','2021-04-22','2021-04-22 08:20:48','2021-04-22 12:21:30','2021-04-22 14:21:34','2021-04-22 18:21:49','2021-04-22 08:21:58'),(2,1,'张三','2021-04-25','2021-04-25 08:44:40','2021-04-25 12:44:53','2021-04-25 14:45:02','2021-04-25 18:45:11','2021-04-25 14:45:20'),(3,3,'赵强','2021-04-23','2021-04-23 08:45:55','2021-04-23 12:46:07','2021-04-23 22:46:16','2021-04-23 18:46:28','2021-04-25 14:46:52'),(4,5,'李厚波','2021-05-01','16:54:04',NULL,NULL,NULL,'2021-05-01 08:54:04');
/*!40000 ALTER TABLE `attendance_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept_inf`
--

DROP TABLE IF EXISTS `dept_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept_inf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept_inf`
--

LOCK TABLES `dept_inf` WRITE;
/*!40000 ALTER TABLE `dept_inf` DISABLE KEYS */;
INSERT INTO `dept_inf` VALUES (1,'技术部','负责产品的设计和开发'),(3,'财务部','费用收支、预决算、工商税务等'),(5,'办公室','负责全公司协调，包括制度、接待、会议等，属于公司中心决策部门'),(32,'人资部','公司人事、培训、劳资、考勤、保险、职称等');
/*!40000 ALTER TABLE `dept_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_inf`
--

DROP TABLE IF EXISTS `employee_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_inf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dept_id` int DEFAULT NULL,
  `job_id` int DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `card_id` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` int DEFAULT NULL,
  `education` varchar(10) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `login_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_inf`
--

LOCK TABLES `employee_inf` WRITE;
/*!40000 ALTER TABLE `employee_inf` DISABLE KEYS */;
INSERT INTO `employee_inf` VALUES (1,1,3,'张三','422781197082688191','湖北武汉','15826286171','66186311@qq.com',1,'本科','2021-04-19','','123'),(2,1,6,'吴兰','276616199007151614','深圳','16928172111','233123431@qq.com',2,'本科','2021-04-19','','123'),(3,1,4,'赵强','342131197211021623','北京','13424231311','524111@qq.com',1,'硕士','2021-04-19','','123'),(4,3,7,'刘悦','267161198012010176','四川成都','15728782212','9819819@qq.com',2,'本科','2021-04-19','','123'),(5,5,8,'李厚波','422801199807061615','湖北恩施','15927523137','2549523956@qq.com',1,'本科','2021-04-19','lhb','123'),(6,32,1,'李峰','421762198610276716','广西','15727191718','1334410@qq.com',1,'博士','2021-04-19','','123'),(7,32,2,'胡天','426152197609051617','西藏','17978776513','2313141@qq.com',1,'本科','2021-04-19','','123'),(8,1,5,'刘鑫','367788197619781011','上海','16826876251','234131114@qq.com',1,'本科','2021-04-19','','123');
/*!40000 ALTER TABLE `employee_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_inf`
--

DROP TABLE IF EXISTS `job_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_inf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_inf`
--

LOCK TABLES `job_inf` WRITE;
/*!40000 ALTER TABLE `job_inf` DISABLE KEYS */;
INSERT INTO `job_inf` VALUES (1,'部门经理','掌管整个部门'),(2,'小组长','团队领导人'),(3,'JAVA后端工程师','负责后端Java开发'),(4,'web前端工程师','负责前端页面的开发'),(5,'测试工程师','负责产品的测试'),(6,'开发工程师助理','帮助工程师完成开发'),(7,'会计','负责财务审计'),(8,'总经理','公司boss');
/*!40000 ALTER TABLE `job_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_inf`
--

DROP TABLE IF EXISTS `leave_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_inf` (
  `leave_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `leave_date` varchar(20) NOT NULL,
  `reason` text NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_inf`
--

LOCK TABLES `leave_inf` WRITE;
/*!40000 ALTER TABLE `leave_inf` DISABLE KEYS */;
INSERT INTO `leave_inf` VALUES (7,1,'李厚波','2021-04-30','五一放假，需要回家',1,'2021-04-28 11:32:30'),(8,1,'李厚波','2021-05-07','家中有事，需要处理',1,'2021-04-28 11:32:52'),(9,1,'李厚波','2021-06-01','家长会，陪孩子',0,'2021-04-28 12:22:47');
/*!40000 ALTER TABLE `leave_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice_inf`
--

DROP TABLE IF EXISTS `notice_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice_inf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_inf`
--

LOCK TABLES `notice_inf` WRITE;
/*!40000 ALTER TABLE `notice_inf` DISABLE KEYS */;
INSERT INTO `notice_inf` VALUES (3,'4.19 公司成立十周年','今日工资十倍，免费三餐','2021-04-22 10:14:43',1,'李厚波'),(4,'放假通知','五一放假五天','2021-04-27 11:02:56',1,'李厚波');
/*!40000 ALTER TABLE `notice_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overtime_inf`
--

DROP TABLE IF EXISTS `overtime_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overtime_inf` (
  `overtime_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `record1` datetime DEFAULT NULL COMMENT '加班上班打卡',
  `record2` datetime DEFAULT NULL COMMENT '加班下班打卡',
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`overtime_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='加班表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overtime_inf`
--

LOCK TABLES `overtime_inf` WRITE;
/*!40000 ALTER TABLE `overtime_inf` DISABLE KEYS */;
INSERT INTO `overtime_inf` VALUES (1,5,'李厚波','2021-04-22 20:00:00','2021-04-22 22:00:33','2021-04-22 18:14:43'),(2,1,'张三','2021-04-25 19:14:22','2021-04-25 22:14:26','2021-04-25 22:14:30'),(3,8,'刘鑫','2021-04-15 19:15:10','2021-04-15 22:15:18','2021-04-15 22:15:30');
/*!40000 ALTER TABLE `overtime_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_inf`
--

DROP TABLE IF EXISTS `salary_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_inf` (
  `salary_id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `month` int NOT NULL,
  `base_salary` int NOT NULL,
  `overtime_salary` int NOT NULL,
  `bonus` int DEFAULT NULL COMMENT '奖金',
  `total` int NOT NULL,
  PRIMARY KEY (`salary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_inf`
--

LOCK TABLES `salary_inf` WRITE;
/*!40000 ALTER TABLE `salary_inf` DISABLE KEYS */;
INSERT INTO `salary_inf` VALUES (1,5,'李厚波',2,12000,3000,3000,18000),(2,5,'李厚波',3,10000,4000,2000,16000),(3,1,'张三',1,15000,3000,1000,19000);
/*!40000 ALTER TABLE `salary_inf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_inf`
--

DROP TABLE IF EXISTS `user_inf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_inf` (
  `id` int NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `createdate` char(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_inf`
--

LOCK TABLES `user_inf` WRITE;
/*!40000 ALTER TABLE `user_inf` DISABLE KEYS */;
INSERT INTO `user_inf` VALUES (1,'lhb','123',2,'2016-03-12 09:34:28','李厚波');
/*!40000 ALTER TABLE `user_inf` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-01 23:21:09
