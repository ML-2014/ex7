/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : my_db

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2015-01-24 10:48:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gm`
-- ----------------------------
DROP TABLE IF EXISTS `gm`;
CREATE TABLE `gm` (
  `id` int(11) NOT NULL,
  `FirstName` varchar(25) DEFAULT NULL,
  `LastName` varchar(25) DEFAULT NULL,
  `code` int(11) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm
-- ----------------------------
INSERT INTO `gm` VALUES ('1', 'Zaxarias', 'Patelis', '1', 'Zax_pat', '1234');
INSERT INTO `gm` VALUES ('2', 'Zaxarias', 'Patelis', '1', 'Zaxpat', '1234');
INSERT INTO `gm` VALUES ('3', 'Lefos', 'Primos', '2', 'lefos', '1234');
INSERT INTO `gm` VALUES ('4', 'Tony', 'Kafs', '1', 'tony', '1234');

-- ----------------------------
-- Table structure for `logistics`
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `id` int(11) NOT NULL DEFAULT '0',
  `LastName` varchar(40) DEFAULT NULL,
  `FirstName` varchar(40) NOT NULL DEFAULT '',
  `Oxima` varchar(10) DEFAULT NULL,
  `Username` varchar(40) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL,
  `fortia1` int(11) DEFAULT NULL,
  `fortia2` int(11) DEFAULT NULL,
  PRIMARY KEY (`FirstName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES ('1', 'Primos', 'Lefos', 'ZZZ-1234', 'Lefos', 'Primos', '7', '5');
INSERT INTO `logistics` VALUES ('3', 'Kafs', 'Tony', 'KKK-1234', 'kafs', 'tony', '6', '0');
INSERT INTO `logistics` VALUES ('2', 'Pat', 'Zaxos', 'XXX-1234', 'pat', 'zax', '9', '0');

-- ----------------------------
-- Table structure for `odigoi`
-- ----------------------------
DROP TABLE IF EXISTS `odigoi`;
CREATE TABLE `odigoi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LastName` varchar(25) DEFAULT NULL,
  `FirstName` varchar(25) DEFAULT NULL,
  `Oxima` varchar(10) DEFAULT NULL,
  `Username` varchar(25) DEFAULT NULL,
  `Password` varchar(10) DEFAULT NULL,
  `fortia1` int(11) DEFAULT NULL,
  `fortia2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of odigoi
-- ----------------------------
INSERT INTO `odigoi` VALUES ('1', 'Primos', 'Lefos', 'IMB7889', 'Lefprim', '777a', '0', '1');
INSERT INTO `odigoi` VALUES ('2', 'Pat', 'Zax', 'IKA3878', 'Shadow', '777b', '0', '1');
INSERT INTO `odigoi` VALUES ('3', 'Kafs', 'Tony', 'XAN0000', 'TonyKafs', '777c', '0', '1');

-- ----------------------------
-- Table structure for `persons`
-- ----------------------------
DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persons
-- ----------------------------
INSERT INTO `persons` VALUES ('1', 'Tony', 'Kafs');
INSERT INTO `persons` VALUES ('2', 'Lefos', 'Primos');
INSERT INTO `persons` VALUES ('3', 'Zax', 'Pat');

-- ----------------------------
-- Table structure for `vehicle`
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` int(11) NOT NULL DEFAULT '0',
  `pinakida` varchar(10) DEFAULT NULL,
  `odigos` varchar(20) DEFAULT NULL,
  `katastasi` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `odigos` (`odigos`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`odigos`) REFERENCES `logistics` (`FirstName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
INSERT INTO `vehicle` VALUES ('1', 'XXX-1234', 'Zaxos', 'Έτοιμο');
INSERT INTO `vehicle` VALUES ('2', 'KKK-1234', 'Tony', 'Έτοιμο');
INSERT INTO `vehicle` VALUES ('3', 'ZZZ-1234', 'Lefos', 'Sunergeio');
INSERT INTO `vehicle` VALUES ('4', 'III-1234', 'Lefos', 'Έτοιμο');
INSERT INTO `vehicle` VALUES ('5', 'ZZZ-2314', 'Tony', 'Συνεργείο');
INSERT INTO `vehicle` VALUES ('6', 'III-1234', 'Tony', 'Συνεργείο');
