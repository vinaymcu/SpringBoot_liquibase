/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.7.22-log : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `articles` */

DROP TABLE IF EXISTS `articles`;

CREATE TABLE `articles` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `articles` */

insert  into `articles`(`article_id`,`title`,`category`) values 
(1,'Postman title','Postman category'),
(2,'Postman title1','Postman category1'),
(4,'Postman title3','Postman category3'),
(5,'Postman title3','Postman category3'),
(6,'Postman title3','Postman category3'),
(7,'test in java','Developer'),
(8,'test in rrrr','Developer'),
(9,'test in ui','Developer'),
(10,'test in ui111','Developer'),
(11,'test in rrrr','Developer');

/*Table structure for table `customer_profile` */

DROP TABLE IF EXISTS `customer_profile`;

CREATE TABLE `customer_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `cust_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_cust_` (`cust_id`),
  CONSTRAINT `FK_cust_` FOREIGN KEY (`cust_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `customer_profile` */

insert  into `customer_profile`(`id`,`city`,`gender`,`pin`,`dob`,`cust_id`) values 
(1,'bang','male',12345,'2005-02-08',1);

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customers` */

insert  into `customers`(`id`,`first_name`,`last_name`) values 
(1,'vinay','gupta');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
