/*
 Navicat Premium Data Transfer

 Source Server         : conn
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : ms_blog

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 26/05/2021 16:14:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_admin_role`;
CREATE TABLE `ms_admin_role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_admin_role
-- ----------------------------
INSERT INTO `ms_admin_role` VALUES (1, 'sysAdmin', '系统管理员', 1);
INSERT INTO `ms_admin_role` VALUES (2, 'contentManager', '内容管理员', 1);
INSERT INTO `ms_admin_role` VALUES (3, 'visitor', '访客', 1);

SET FOREIGN_KEY_CHECKS = 1;
