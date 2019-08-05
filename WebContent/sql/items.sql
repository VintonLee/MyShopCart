/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : shopping

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 05/08/2019 16:23:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `picture` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES (1, '华为Mate20', '深圳', 6199, 500, '001.jpg');
INSERT INTO `items` VALUES (2, '小米9', '北京', 2999, 800, '002.jpg');
INSERT INTO `items` VALUES (3, 'OPPO Reno', '深圳', 2998, 1000, '003.jpg');
INSERT INTO `items` VALUES (4, 'vivo IQOO', '深圳', 2699, 600, '004.jpg');
INSERT INTO `items` VALUES (5, '戴尔笔记本', '北京', 3999, 900, '005.jpg');
INSERT INTO `items` VALUES (6, '联想笔记本', '北京', 4999, 3000, '006.jpg');
INSERT INTO `items` VALUES (7, '华硕笔记本', '北京', 4599, 1000, '007.jpg');
INSERT INTO `items` VALUES (8, '惠普笔记本', '北京', 4699, 500, '008.jpg');
INSERT INTO `items` VALUES (9, 'T恤', '杭州', 69, 500, '009.jpg');
INSERT INTO `items` VALUES (10, '短裤', '温州', 99, 500, '010.jpg');
INSERT INTO `items` VALUES (11, '耐克运动鞋', '保定', 369, 500, '011.jpg');
INSERT INTO `items` VALUES (12, '夏季运动鞋', '衡水', 169, 500, '012.jpg');

SET FOREIGN_KEY_CHECKS = 1;
