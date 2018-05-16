/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : faydan

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 16/05/2018 15:58:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fay_menu
-- ----------------------------
DROP TABLE IF EXISTS `fay_menu`;
CREATE TABLE `fay_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '菜单url',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '访问菜单需要的权限',
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '1' COMMENT '菜单等级',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `is_menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '1' COMMENT '是否是菜单 1->是,0->否',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '1' COMMENT '菜单状态 1->启用,0->不启用',
  `is_open` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '1' COMMENT '是否打开 1->打开,0->不打开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fay_menu
-- ----------------------------
INSERT INTO `fay_menu` VALUES (1, '首页', NULL, '', 'edit', '1', 0, '1', '1', '1');
INSERT INTO `fay_menu` VALUES (2, '测试', NULL, NULL, 'query', '1', 0, '1', '1', '1');

-- ----------------------------
-- Table structure for fay_role
-- ----------------------------
DROP TABLE IF EXISTS `fay_role`;
CREATE TABLE `fay_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名称',
  `parent_id` int(11) DEFAULT 0 COMMENT '父级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fay_role
-- ----------------------------
INSERT INTO `fay_role` VALUES (1, 'admin', 0);
INSERT INTO `fay_role` VALUES (2, 'user', 0);

-- ----------------------------
-- Table structure for fay_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `fay_role_menu`;
CREATE TABLE `fay_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fay_role_menu
-- ----------------------------
INSERT INTO `fay_role_menu` VALUES (1, 1, 1);
INSERT INTO `fay_role_menu` VALUES (2, 2, 2);

-- ----------------------------
-- Table structure for fay_user
-- ----------------------------
DROP TABLE IF EXISTS `fay_user`;
CREATE TABLE `fay_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `birthday` datetime(0) DEFAULT NULL COMMENT '生日',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fay_user
-- ----------------------------
INSERT INTO `fay_user` VALUES (1, '1', 'admin', 'admin', 'admin', '小明', '2018-05-16 11:36:43', '1', '321457749@qq.com', '18888888888', NULL, '1', '2018-05-16 11:36:09', '2018-05-16 11:36:12');
INSERT INTO `fay_user` VALUES (2, '1', 'user', 'user', 'user', '小红', '2018-05-16 15:28:25', '1', '321457749@qq.com', '18888888888', NULL, '1', '2018-05-16 15:28:36', '2018-05-16 15:28:39');

-- ----------------------------
-- Table structure for fay_user_role
-- ----------------------------
DROP TABLE IF EXISTS `fay_user_role`;
CREATE TABLE `fay_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fay_user_role
-- ----------------------------
INSERT INTO `fay_user_role` VALUES (1, 1, 1);
INSERT INTO `fay_user_role` VALUES (2, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
