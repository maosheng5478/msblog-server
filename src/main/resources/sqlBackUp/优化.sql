/*
MySQL Backup
Database: ms_blog
Backup Time: 2021-05-31 17:26:01
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `ms_blog`.`ms_menu`;
DROP TABLE IF EXISTS `ms_blog`.`ms_permission`;
DROP TABLE IF EXISTS `ms_blog`.`ms_permission_menu`;
DROP TABLE IF EXISTS `ms_blog`.`ms_role`;
DROP TABLE IF EXISTS `ms_blog`.`ms_role_permission`;
DROP TABLE IF EXISTS `ms_blog`.`ms_user`;
DROP TABLE IF EXISTS `ms_blog`.`ms_user_role`;
CREATE TABLE `ms_menu` (
  `id` int NOT NULL,
  `path` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `name_zh` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ms_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `ms_permission_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pid` bigint DEFAULT NULL COMMENT 'permission id',
  `mid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`),
  KEY `mid` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ms_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name_zh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `ms_role_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rid` bigint DEFAULT NULL COMMENT 'role id',
  `pid` bigint DEFAULT NULL COMMENT 'permission id',
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ms_user` (
  `id` bigint NOT NULL COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '?????????',
  `pwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '??????',
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '??????',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '????????????',
  `update_time` datetime DEFAULT NULL COMMENT '????????????????????????',
  `version` int DEFAULT '1',
  `deleted` tinyint(1) DEFAULT NULL COMMENT ' ????????????',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
CREATE TABLE `ms_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint DEFAULT NULL,
  `rid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `rid` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
BEGIN;
LOCK TABLES `ms_blog`.`ms_menu` WRITE;
DELETE FROM `ms_blog`.`ms_menu`;
INSERT INTO `ms_blog`.`ms_menu` (`id`,`path`,`name`,`name_zh`,`component`,`parent_id`) VALUES (1, '/admin', 'AdminIndex', '??????', 'AdminIndex', 0),(2, '/admin', 'Context', '????????????', 'AdminIndex', 0),(3, '/admin', 'User', '????????????', 'AdminIndex', 0),(4, '/admin', 'Info', '????????????', 'AdminIndex', 0),(5, '/admin', 'Security', '????????????', 'AdminIndex', 0),(6, '/admin/user/profile', 'Profile', '????????????', 'user/UserProfile', 3),(7, '/admin/user/role', 'RoleSetting', '????????????', 'user/Role', 3),(9, '/admin/content/banner', 'BannerManagement', '????????????', 'content/BannerManagement', 2),(10, '/admin/content/article', 'ArticleManagement', '????????????', 'content/ArticleManagement', 2),(11, '/admin', 'leaveComments', '????????????', 'AdminIndex', 0);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `ms_blog`.`ms_permission` WRITE;
DELETE FROM `ms_blog`.`ms_permission`;
INSERT INTO `ms_blog`.`ms_permission` (`id`,`name`,`desc`,`url`) VALUES (1, 'users_management', '????????????', '/api/admin/user'),(2, 'roles_management', '????????????', '/api/admin/role'),(3, 'content_management', '????????????', '/api/admin/content');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `ms_blog`.`ms_permission_menu` WRITE;
DELETE FROM `ms_blog`.`ms_permission_menu`;
INSERT INTO `ms_blog`.`ms_permission_menu` (`id`,`pid`,`mid`) VALUES (194, 1, 1),(195, 1, 2),(196, 1, 3),(197, 1, 10),(198, 1, 9),(199, 1, 6),(200, 1, 7),(204, 3, 4),(205, 3, 5),(206, 3, 11);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `ms_blog`.`ms_role` WRITE;
DELETE FROM `ms_blog`.`ms_role`;
INSERT INTO `ms_blog`.`ms_role` (`id`,`name`,`name_zh`,`enabled`) VALUES (1, 'sysAdmin', '???????????????', 1),(2, 'contentManager', '???????????????', 1),(3, 'visitor', '??????', 1);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `ms_blog`.`ms_role_permission` WRITE;
DELETE FROM `ms_blog`.`ms_role_permission`;
INSERT INTO `ms_blog`.`ms_role_permission` (`id`,`rid`,`pid`) VALUES (1, 1, 1),(2, 1, 2),(3, 1, 3),(4, 3, 3);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `ms_blog`.`ms_user` WRITE;
DELETE FROM `ms_blog`.`ms_user`;
INSERT INTO `ms_blog`.`ms_user` (`id`,`username`,`pwd`,`email`,`phone`,`create_time`,`update_time`,`version`,`deleted`) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '361193645@qq.com', '17759309269', '2021-05-20 17:47:14', '2021-05-20 17:47:14', 13, 0),(2, 'admin', 'admin', NULL, NULL, NULL, NULL, 1, NULL),(12, 'text2', '2222', NULL, NULL, NULL, NULL, 1, NULL),(1392752115447533570, '11131', '131', '123@qq.com', '0', '2021-05-13 16:02:35', '2021-05-13 17:39:15', 3, 0),(1393106891279986689, 'text1', '133', NULL, '1000001', '2021-05-14 15:32:20', '2021-05-14 15:32:20', 0, 0),(1393111612233474050, '12312', '29852fd8f42d63ef579aa46d8cd15183', NULL, '312331', '2021-05-14 15:51:06', '2021-05-14 15:51:06', 0, 0),(1393130419668688898, 'ms', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, '2021-05-14 17:05:50', '2021-05-14 17:05:50', 0, 0);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `ms_blog`.`ms_user_role` WRITE;
DELETE FROM `ms_blog`.`ms_user_role`;
INSERT INTO `ms_blog`.`ms_user_role` (`id`,`uid`,`rid`) VALUES (1, 1, 1),(4, 1393130419668688898, 3);
UNLOCK TABLES;
COMMIT;
