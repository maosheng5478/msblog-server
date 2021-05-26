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

 Date: 26/05/2021 16:15:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ms_user
-- ----------------------------
DROP TABLE IF EXISTS `ms_user`;
CREATE TABLE `ms_user`  (
  `id` bigint NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` bigint NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '最后一次更新时间',
  `version` int NULL DEFAULT 1,
  `deleted` tinyint(1) NULL DEFAULT NULL COMMENT ' 是否删除',
  `role_id` int NULL DEFAULT 3 COMMENT '用户角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ms_user
-- ----------------------------
INSERT INTO `ms_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', NULL, 1775309269, '2021-05-20 17:47:14', '2021-05-20 17:47:14', 0, 0, 1);
INSERT INTO `ms_user` VALUES (2, 'admin', 'admin', NULL, NULL, NULL, NULL, 1, NULL, 1);
INSERT INTO `ms_user` VALUES (12, 'text2', '2222', NULL, NULL, NULL, NULL, 1, NULL, 3);
INSERT INTO `ms_user` VALUES (1392752115447533570, '11131', '131', '123@qq.com', 0, '2021-05-13 16:02:35', '2021-05-13 17:39:15', 3, 0, 3);
INSERT INTO `ms_user` VALUES (1393106891279986689, 'text1', '133', NULL, 1000001, '2021-05-14 15:32:20', '2021-05-14 15:32:20', 0, 0, 3);
INSERT INTO `ms_user` VALUES (1393111612233474050, '12312', '29852fd8f42d63ef579aa46d8cd15183', NULL, 312331, '2021-05-14 15:51:06', '2021-05-14 15:51:06', 0, 0, 3);
INSERT INTO `ms_user` VALUES (1393130419668688898, 'ms', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, '2021-05-14 17:05:50', '2021-05-14 17:05:50', 0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
