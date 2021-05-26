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

 Date: 26/05/2021 16:14:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_admin_menu`;
CREATE TABLE `ms_admin_menu`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name_zh` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_admin_menu
-- ----------------------------
INSERT INTO `ms_admin_menu` VALUES (1, '/admin', 'AdminIndex', '首页', 'AdminIndex', 0);
INSERT INTO `ms_admin_menu` VALUES (2, '/admin', 'Context', '内容管理', 'AdminIndex', 0);
INSERT INTO `ms_admin_menu` VALUES (3, '/admin', 'User', '用户管理', 'AdminIndex', 0);
INSERT INTO `ms_admin_menu` VALUES (4, '/admin', 'Info', '个人信息', 'AdminIndex', 0);
INSERT INTO `ms_admin_menu` VALUES (5, '/admin', 'Security', '安全设置', 'AdminIndex', 0);
INSERT INTO `ms_admin_menu` VALUES (6, '/admin/user/profile', 'Profile', '用户信息', 'user/UserProfile', 3);
INSERT INTO `ms_admin_menu` VALUES (7, '/admin/user/role', 'Role', '角色配置', 'user/Role', 3);
INSERT INTO `ms_admin_menu` VALUES (9, '/admin/content/banner', 'BannerManagement', '广告管理', 'content/BannerManagement', 2);
INSERT INTO `ms_admin_menu` VALUES (10, '/admin/content/article', 'ArticleManagement', '文章管理', 'content/ArticleManagement', 2);
INSERT INTO `ms_admin_menu` VALUES (11, '/admin', 'leaveComments', '留言管理', 'AdminIndex', 0);

SET FOREIGN_KEY_CHECKS = 1;
