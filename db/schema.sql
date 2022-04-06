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

 Date: 06/04/2022 15:19:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名',
  `menu_icon` varchar(100) NOT NULL COMMENT '菜单对应图标',
  `menu_url` varchar(100) DEFAULT NULL COMMENT '菜单功能对应地址',
  `menu_parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID，为null时为第一层级',
  `menu_order_value` bigint(10) NOT NULL COMMENT '当前层级的排序顺序',
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT 'admin' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `role_name` varchar(20) NOT NULL COMMENT '权限名（唯一）',
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT 'admin' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE KEY `role_name` (`role_name`) USING BTREE COMMENT '权限名唯一'
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='权限清单';

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '权限ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT 'admin' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限与菜单的关联表';

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `role_id` bigint(20) NOT NULL COMMENT '权限ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT 'admin' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与权限的关联表';

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
  `update_by` varchar(20) DEFAULT 'admin' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8mb4 COMMENT='歌曲清单';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(60) NOT NULL COMMENT '密码(bcrypt加密后的)',
  `status` tinyint(1) NOT NULL COMMENT '帐号状态（1正常 0停用）',
  `create_by` varchar(20) NOT NULL DEFAULT 'admin' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT 'admin' COMMENT '更新者',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='用户清单';

SET FOREIGN_KEY_CHECKS = 1;
