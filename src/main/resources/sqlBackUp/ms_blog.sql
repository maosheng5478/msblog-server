/*
 Navicat MySQL Data Transfer

 Source Server         : conn
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : ms_blog

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 11/06/2021 09:53:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_article
-- ----------------------------
DROP TABLE IF EXISTS `ms_article`;
CREATE TABLE `ms_article`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `content_md` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `type` int NULL DEFAULT NULL,
  `writer_id` bigint NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '内容简介',
  `likes` int NULL DEFAULT NULL COMMENT '点赞',
  `version` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_article
-- ----------------------------
INSERT INTO `ms_article` VALUES (1, '11', '11', '11', 2, 1393130419668688898, NULL, NULL, '11', 0, 0);

-- ----------------------------
-- Table structure for ms_category
-- ----------------------------
DROP TABLE IF EXISTS `ms_category`;
CREATE TABLE `ms_category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_id` int NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_category
-- ----------------------------
INSERT INTO `ms_category` VALUES (1, 1, 'vue');
INSERT INTO `ms_category` VALUES (2, 2, 'spring');
INSERT INTO `ms_category` VALUES (3, 3, 'mysql');
INSERT INTO `ms_category` VALUES (4, 4, NULL);

-- ----------------------------
-- Table structure for ms_comment
-- ----------------------------
DROP TABLE IF EXISTS `ms_comment`;
CREATE TABLE `ms_comment`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `article_id` bigint NOT NULL,
  `commenter_id` bigint NULL DEFAULT NULL,
  `respondent_id` bigint NULL DEFAULT 0,
  `parent_id` bigint NULL DEFAULT 0,
  `likes` int NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_comment
-- ----------------------------
INSERT INTO `ms_comment` VALUES (1, 'text', 1, 1393130419668688898, 0, 0, 0, '2021-06-02 10:32:34');
INSERT INTO `ms_comment` VALUES (2, 'dddd', 1, 1, 1393130419668688898, 1, 0, '2021-06-02 10:33:05');
INSERT INTO `ms_comment` VALUES (3, '111', 1, 1, 0, 0, 1, '2021-06-02 10:33:50');
INSERT INTO `ms_comment` VALUES (5, '222', 1, 1393130419668688898, 1, 1, 0, '2021-06-02 14:06:30');

-- ----------------------------
-- Table structure for ms_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_menu`;
CREATE TABLE `ms_menu`  (
  `id` int NOT NULL,
  `path` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name_zh` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `component` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `parent_id` int NULL DEFAULT NULL,
  `deleted` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_menu
-- ----------------------------
INSERT INTO `ms_menu` VALUES (1, '/admin', 'AdminIndex', '首页', 'AdminIndex', 0, 0);
INSERT INTO `ms_menu` VALUES (2, '/admin', 'Context', '内容管理', 'AdminIndex', 0, 0);
INSERT INTO `ms_menu` VALUES (3, '/admin', 'User', '用户管理', 'AdminIndex', 0, 0);
INSERT INTO `ms_menu` VALUES (4, '/admin', 'Info', '个人信息', 'AdminIndex', 0, 0);
INSERT INTO `ms_menu` VALUES (5, '/admin', 'Security', '安全设置', 'AdminIndex', 0, 0);
INSERT INTO `ms_menu` VALUES (6, '/admin/user/profile', 'Profile', '用户信息', 'user/UserProfile', 3, 0);
INSERT INTO `ms_menu` VALUES (7, '/admin/user/role', 'RoleSetting', '角色配置', 'user/Role', 3, 0);
INSERT INTO `ms_menu` VALUES (9, '/admin/content/banner', 'BannerManagement', '广告管理', 'content/BannerManagement', 2, 0);
INSERT INTO `ms_menu` VALUES (10, '/admin/content/article', 'ArticleManagement', '文章管理', 'content/ArticleManagement', 2, 0);
INSERT INTO `ms_menu` VALUES (11, '/admin', 'leaveComments', '留言管理', 'AdminIndex', 0, 1);
INSERT INTO `ms_menu` VALUES (12, '/admin/content/log', 'Logout', '日志输出', 'log', 2, 0);
INSERT INTO `ms_menu` VALUES (13, '/admin', 'System', '系统管理', 'Adminlindex', 0, 0);

-- ----------------------------
-- Table structure for ms_permission
-- ----------------------------
DROP TABLE IF EXISTS `ms_permission`;
CREATE TABLE `ms_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `described` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_permission
-- ----------------------------
INSERT INTO `ms_permission` VALUES (1, 'users_management', '用户管理', '/api/admin/user');
INSERT INTO `ms_permission` VALUES (2, 'roles_management', '角色管理', '/api/admin/role');
INSERT INTO `ms_permission` VALUES (3, 'content_management', '内容管理', '/api/admin/content');

-- ----------------------------
-- Table structure for ms_permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `ms_permission_menu`;
CREATE TABLE `ms_permission_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pid` bigint NULL DEFAULT NULL COMMENT 'permission id',
  `mid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_permission_menu
-- ----------------------------
INSERT INTO `ms_permission_menu` VALUES (194, 1, 1);
INSERT INTO `ms_permission_menu` VALUES (195, 1, 2);
INSERT INTO `ms_permission_menu` VALUES (196, 1, 3);
INSERT INTO `ms_permission_menu` VALUES (197, 1, 10);
INSERT INTO `ms_permission_menu` VALUES (198, 1, 9);
INSERT INTO `ms_permission_menu` VALUES (199, 1, 6);
INSERT INTO `ms_permission_menu` VALUES (200, 1, 7);
INSERT INTO `ms_permission_menu` VALUES (204, 3, 4);
INSERT INTO `ms_permission_menu` VALUES (205, 3, 5);
INSERT INTO `ms_permission_menu` VALUES (206, 3, 11);

-- ----------------------------
-- Table structure for ms_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_role`;
CREATE TABLE `ms_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_role
-- ----------------------------
INSERT INTO `ms_role` VALUES (1, 'sysAdmin', '系统管理员', 1);
INSERT INTO `ms_role` VALUES (2, 'contentManager', '内容管理员', 1);
INSERT INTO `ms_role` VALUES (3, 'visitor', '访客', 1);

-- ----------------------------
-- Table structure for ms_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `ms_role_permission`;
CREATE TABLE `ms_role_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rid` bigint NULL DEFAULT NULL COMMENT 'role id',
  `pid` bigint NULL DEFAULT NULL COMMENT 'permission id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_role_permission
-- ----------------------------
INSERT INTO `ms_role_permission` VALUES (1, 1, 1);
INSERT INTO `ms_role_permission` VALUES (2, 1, 2);
INSERT INTO `ms_role_permission` VALUES (3, 1, 3);
INSERT INTO `ms_role_permission` VALUES (4, 3, 3);

-- ----------------------------
-- Table structure for ms_user
-- ----------------------------
DROP TABLE IF EXISTS `ms_user`;
CREATE TABLE `ms_user`  (
  `id` bigint NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '最后一次更新时间',
  `version` int NULL DEFAULT 1,
  `deleted` tinyint(1) NULL DEFAULT NULL COMMENT ' 是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_user
-- ----------------------------
INSERT INTO `ms_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'string', 'string', '2021-05-20 17:47:14', '2021-05-20 17:47:14', 14, 0);
INSERT INTO `ms_user` VALUES (4, '4', '4', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (5, '5', '5', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (6, '6', '6', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (7, '7', '7', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (12, 'text2', '2222', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (22, 'qeqwe', '213', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (33, '25', '53', NULL, NULL, NULL, NULL, 1, 0);
INSERT INTO `ms_user` VALUES (1392752115447533570, '11131', '131', '123@qq.com', '0', '2021-05-13 16:02:35', '2021-05-13 17:39:15', 3, 0);
INSERT INTO `ms_user` VALUES (1393106891279986689, 'text1', '133', NULL, '1000001', '2021-05-14 15:32:20', '2021-05-14 15:32:20', 0, 0);
INSERT INTO `ms_user` VALUES (1393111612233474050, '12312', '29852fd8f42d63ef579aa46d8cd15183', NULL, '312331', '2021-05-14 15:51:06', '2021-05-14 15:51:06', 0, 0);
INSERT INTO `ms_user` VALUES (1393130419668688898, 'ms', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, '2021-05-14 17:05:50', '2021-05-14 17:05:50', 0, 0);

-- ----------------------------
-- Table structure for ms_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ms_user_role`;
CREATE TABLE `ms_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint NULL DEFAULT NULL,
  `rid` bigint NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ms_user_role
-- ----------------------------
INSERT INTO `ms_user_role` VALUES (1, 1, 1);
INSERT INTO `ms_user_role` VALUES (4, 1393130419668688898, 3);

SET FOREIGN_KEY_CHECKS = 1;
