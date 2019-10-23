/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : db0722

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 23/10/2019 17:24:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'JAVA');
INSERT INTO `course` VALUES (2, 'HTML');
INSERT INTO `course` VALUES (3, 'DATABASE');

-- ----------------------------
-- Table structure for husband
-- ----------------------------
DROP TABLE IF EXISTS `husband`;
CREATE TABLE `husband`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of husband
-- ----------------------------
INSERT INTO `husband` VALUES (1, '杨过');
INSERT INTO `husband` VALUES (2, '郭靖');
INSERT INTO `husband` VALUES (3, '武大即');
INSERT INTO `husband` VALUES (4, '梁山伯');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `oname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  INDEX `op`(`pid`) USING BTREE,
  CONSTRAINT `op` FOREIGN KEY (`pid`) REFERENCES `person` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '荣耀MagicBook 2019 14英寸轻薄窄边框', 2);
INSERT INTO `order` VALUES (2, '小米 (MI)Ruby 2019款 15.6英寸金属轻薄', 1);
INSERT INTO `order` VALUES (3, '戴尔灵越14 燃 14英寸英特尔酷睿i5轻薄窄边框', 3);
INSERT INTO `order` VALUES (4, '联想(Lenovo)小新14英寸 锐龙版R5', 4);
INSERT INTO `order` VALUES (5, '红辣椒7X 4+64GB 学生智能手机', 5);
INSERT INTO `order` VALUES (6, '荣耀10青春版 幻彩渐变', 1);
INSERT INTO `order` VALUES (7, 'OPPO K1 全面屏手机', 2);
INSERT INTO `order` VALUES (8, '卡梵蒂GAVADI 鳄鱼皮钱包', 5);
INSERT INTO `order` VALUES (9, '七匹狼钱包', 2);
INSERT INTO `order` VALUES (10, '金利来（Goldlion）男士钱包', 1);

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Bir` date NULL DEFAULT NULL,
  `Address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, '梦琪', '2019-05-08', '北京市', 1);
INSERT INTO `person` VALUES (2, '忆柳', '2019-05-14', '天津市', 1);
INSERT INTO `person` VALUES (3, '慕青', '2018-10-17', '上海市', 1);
INSERT INTO `person` VALUES (4, '初夏', '2017-04-13', '重庆市', 1);
INSERT INTO `person` VALUES (5, '新柔', '2018-12-29', '广州市', 1);
INSERT INTO `person` VALUES (9, '李小气', '2019-05-08', '北京市', 1);
INSERT INTO `person` VALUES (10, '李小气', NULL, NULL, 1);
INSERT INTO `person` VALUES (11, '梦琪23', '2019-05-08', '北京市', 1);
INSERT INTO `person` VALUES (12, '梦琪33', '2019-05-08', '北京市', 1);
INSERT INTO `person` VALUES (13, '梦琪43', '2019-05-08', '北京市', 1);
INSERT INTO `person` VALUES (15, 'koko', '2019-10-17', 'hf', 22);

-- ----------------------------
-- Table structure for stu_cou
-- ----------------------------
DROP TABLE IF EXISTS `stu_cou`;
CREATE TABLE `stu_cou`  (
  `scid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`scid`) USING BTREE,
  INDEX `scs`(`sid`) USING BTREE,
  INDEX `scc`(`cid`) USING BTREE,
  CONSTRAINT `scc` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scs` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stu_cou
-- ----------------------------
INSERT INTO `stu_cou` VALUES (1, 1, 1);
INSERT INTO `stu_cou` VALUES (2, 1, 2);
INSERT INTO `stu_cou` VALUES (3, 1, 3);
INSERT INTO `stu_cou` VALUES (4, 2, 1);
INSERT INTO `stu_cou` VALUES (5, 2, 2);
INSERT INTO `stu_cou` VALUES (6, 2, 3);
INSERT INTO `stu_cou` VALUES (7, 3, 1);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '梦琪', NULL);
INSERT INTO `student` VALUES (2, '初夏', NULL);
INSERT INTO `student` VALUES (3, '忆柳', NULL);

-- ----------------------------
-- Table structure for wife
-- ----------------------------
DROP TABLE IF EXISTS `wife`;
CREATE TABLE `wife`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wife
-- ----------------------------
INSERT INTO `wife` VALUES (1, '小龙女');
INSERT INTO `wife` VALUES (2, '黄容');
INSERT INTO `wife` VALUES (3, '潘金莲');
INSERT INTO `wife` VALUES (4, '祝英台');

SET FOREIGN_KEY_CHECKS = 1;
