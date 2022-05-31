/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : ssm_demo

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2018-12-30 17:38:23
*/
CREATE DATABASE IF NOT EXISTS usrmnge;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------

use usrmnge;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,

  `lastLoginTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Default', 'Default', '1', '1111111111\@qq.com', '2000-1-1 00:00:00');
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `owner` varchar(255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `url`  varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ;
INSERT INTO `tags` VALUES ('1','Default','百度一下，也不知道','https://www.baidu.com');
DROP TABLE IF EXISTS `His`;
CREATE TABLE `His` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `owner` varchar(255) NOT NULL,
                        `content` varchar(255) NOT NULL,
                        `times` int(11) NOT NULL ,
                        PRIMARY KEY (`id`)
) ;