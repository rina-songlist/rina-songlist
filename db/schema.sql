/*
 Navicat Premium Data Transfer

 Source Server         : dell 5.7
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 192.168.0.9:3306
 Source Schema         : rina

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 06/02/2022 15:54:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for song_list
-- ----------------------------
DROP TABLE IF EXISTS `song_list`;
CREATE TABLE `song_list` (
  `song_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '歌曲ID',
  `song_name` varchar(100) NOT NULL COMMENT '歌名',
  `song_artist` varchar(20) DEFAULT NULL COMMENT '歌手',
  `song_language` varchar(5) NOT NULL COMMENT '语言',
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8mb4 COMMENT='歌曲清单';
