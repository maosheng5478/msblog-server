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

 Date: 26/05/2021 16:14:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_admin_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `ms_admin_role_permission`;
CREATE TABLE `ms_admin_role_permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rid` int NULL DEFAULT NULL,
  `mid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 206 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_admin_role_permission
-- ----------------------------
INSERT INTO `ms_admin_role_permission` VALUES (194, 1, 2);
INSERT INTO `ms_admin_role_permission` VALUES (195, 1, 1);
INSERT INTO `ms_admin_role_permission` VALUES (196, 1, 3);
INSERT INTO `ms_admin_role_permission` VALUES (197, 1, 4);
INSERT INTO `ms_admin_role_permission` VALUES (198, 1, 5);
INSERT INTO `ms_admin_role_permission` VALUES (199, 1, 6);
INSERT INTO `ms_admin_role_permission` VALUES (200, 1, 7);
INSERT INTO `ms_admin_role_permission` VALUES (201, 1, 8);
INSERT INTO `ms_admin_role_permission` VALUES (202, 1, 9);
INSERT INTO `ms_admin_role_permission` VALUES (203, 1, 10);
INSERT INTO `ms_admin_role_permission` VALUES (204, 3, 4);
INSERT INTO `ms_admin_role_permission` VALUES (205, 3, 5);
INSERT INTO `ms_admin_role_permission` VALUES (206, 3, 11);

SET FOREIGN_KEY_CHECKS = 1;
