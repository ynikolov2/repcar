-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: repcar
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `company_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `company_address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Repcar','Pernik','2016-11-25 10:20:09');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_access_token`
--

DROP TABLE IF EXISTS `oauth_access_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `token` blob,
  `authentication_id` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_id` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`token_id`),
  UNIQUE KEY `authentication_id` (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(256) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_client_details`
--

LOCK TABLES `oauth_client_details` WRITE;
/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` VALUES ('category',NULL,'category-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('cmx',NULL,'cmx-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('company',NULL,'company-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('idmap',NULL,'idmap-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('integration-tests',NULL,'integration-tests-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',666666,NULL,NULL,NULL),('meeting',NULL,'meeting-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('notification','','notification-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('product',NULL,'product-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('ui',NULL,'ui-secret','read,write','password,client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL),('user-data',NULL,'user-data-secret','read,write','client_credentials',NULL,'ROLE_CLIENT',604800,NULL,NULL,NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_refresh_token`
--

DROP TABLE IF EXISTS `oauth_refresh_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `token` blob NOT NULL,
  `authentication` blob NOT NULL,
  PRIMARY KEY (`token_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_refresh_token`
--

LOCK TABLES `oauth_refresh_token` WRITE;
/*!40000 ALTER TABLE `oauth_refresh_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_refresh_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_email` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_password` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `creation_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_first_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_last_name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_image` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_role` enum('ROLE_USER','ROLE_ADMIN','ROLE_ANONYMOUS','ROLE_OPERATOR') COLLATE utf8_unicode_ci DEFAULT 'ROLE_ANONYMOUS',
  `company_id` int(11) unsigned DEFAULT NULL,
  `user_attributes` varchar(4555) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_company_id` (`user_name`,`company_id`),
  UNIQUE KEY `user_email_company_id` (`user_email`,`company_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `FK_COMPANY` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=448 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin@test.com','66663c907ebef54e4d2da53df29196f3069190ed0679fc162bd17903c471c40e','2016-11-25 14:01:32','test','test','admin.png','ROLE_ADMIN',1,NULL),(2,'luci','lsmith@test.com','b451f497813469fab82ded162e7456e06ffc5552fbdc6c5a03cdc322c506a784','2016-11-25 14:01:32','Lucas','Smith','operator.png','ROLE_OPERATOR',1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_setting`
--

DROP TABLE IF EXISTS `user_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_setting` (
  `user_setting_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_nfc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_setting_id`),
  UNIQUE KEY `user_nfc` (`user_nfc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_setting`
--

LOCK TABLES `user_setting` WRITE;
/*!40000 ALTER TABLE `user_setting` DISABLE KEYS */;
INSERT INTO `user_setting` VALUES (1,'123456789',61),(2,'123456789a',1);
/*!40000 ALTER TABLE `user_setting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-26 14:42:26
