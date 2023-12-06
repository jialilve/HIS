/*
 Navicat Premium Data Transfer

 Source Server         : ssl
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-bp107d20306799ttwmo.mysql.rds.aliyuncs.com:3306
 Source Schema         : ks

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 22/06/2022 18:32:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for booking_form
-- ----------------------------
DROP TABLE IF EXISTS `booking_form`;
CREATE TABLE `booking_form`  (
  `Bookid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Booktime` date NULL DEFAULT NULL,
  `Doid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Pid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Bookid`) USING BTREE,
  INDEX `1`(`Doid`) USING BTREE,
  INDEX `2`(`Pid`) USING BTREE,
  CONSTRAINT `1` FOREIGN KEY (`Doid`) REFERENCES `doctor` (`Doid`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `2` FOREIGN KEY (`Pid`) REFERENCES `patient` (`Pid`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of booking_form
-- ----------------------------
INSERT INTO `booking_form` VALUES ('1', '2021-05-03', '1', '1');
INSERT INTO `booking_form` VALUES ('2', '2021-05-04', '2', '2');
INSERT INTO `booking_form` VALUES ('3', '2021-05-06', '1', '3');
INSERT INTO `booking_form` VALUES ('4', '2021-05-04', '2', '4');
INSERT INTO `booking_form` VALUES ('5', '2022-05-04', '3', '2');
INSERT INTO `booking_form` VALUES ('6', '2022-06-15', '16', '1');
INSERT INTO `booking_form` VALUES ('7', '2022-05-17', '10', '1');

-- ----------------------------
-- Table structure for deliver
-- ----------------------------
DROP TABLE IF EXISTS `deliver`;
CREATE TABLE `deliver`  (
  `Waid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Meid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Dnumber` int(10) NULL DEFAULT NULL,
  `deliver_id` int(10) NOT NULL,
  PRIMARY KEY (`deliver_id`) USING BTREE,
  INDEX `33`(`Waid`) USING BTREE,
  INDEX `44`(`Meid`) USING BTREE,
  CONSTRAINT `33` FOREIGN KEY (`Waid`) REFERENCES `warehouse` (`Waid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `44` FOREIGN KEY (`Meid`) REFERENCES `medicine` (`Meid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliver
-- ----------------------------
INSERT INTO `deliver` VALUES ('1', '1', 2, 1);
INSERT INTO `deliver` VALUES ('2', '2', 100, 2);
INSERT INTO `deliver` VALUES ('3', '7', 2, 3);
INSERT INTO `deliver` VALUES ('1', '1', 100, 4);
INSERT INTO `deliver` VALUES ('1', '1', 100, 5);
INSERT INTO `deliver` VALUES ('1', '1', 200, 6);
INSERT INTO `deliver` VALUES ('3', '7', 100, 7);
INSERT INTO `deliver` VALUES ('2', '2', 15, 8);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `Deid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Dename` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Dsum` int(10) NULL DEFAULT NULL,
  `Dtext` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Deid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '内科', 4, '训练有素的内科团队为你保驾护航');
INSERT INTO `department` VALUES ('2', '外科', 4, '有备而来的外科精英为您医治病痛');
INSERT INTO `department` VALUES ('3', '妇产科', 4, '轻车熟路的白衣天使为你排忧解难');
INSERT INTO `department` VALUES ('4', '儿科', 3, '这个科室很懒，什么也没有填...');
INSERT INTO `department` VALUES ('5', '神经科', 2, '这个科室很懒，什么也没有填...');
INSERT INTO `department` VALUES ('6', '骨科', 3, '专业骨科为您竭诚服务');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `Doid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Doname` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Dosex` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Doage` int(3) NULL DEFAULT NULL,
  `Dlevel` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Dcall` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Deid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Doid`) USING BTREE,
  INDEX `5`(`Deid`) USING BTREE,
  CONSTRAINT `5` FOREIGN KEY (`Deid`) REFERENCES `department` (`Deid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '扁鹊', '男', 41, '主任医师', '3301111', '1');
INSERT INTO `doctor` VALUES ('10', '罗有明', '男', 50, '主任医师', '3301120', '6');
INSERT INTO `doctor` VALUES ('11', '高云峰', '男', 51, '副主任医师', '3301121', '6');
INSERT INTO `doctor` VALUES ('12', '蒋大介', '男', 51, '主任医师', '3301122', '5');
INSERT INTO `doctor` VALUES ('13', '赵一成', '男', 50, '副主任医师', '3301123', '5');
INSERT INTO `doctor` VALUES ('14', '张春萍', '女', 50, '副主任医师', '3301124', '4');
INSERT INTO `doctor` VALUES ('15', '孙思邈', '男', 61, '副主任医师', '3301125', '1');
INSERT INTO `doctor` VALUES ('16', '万全', '男', 42, '主治医师', '3301126', '1');
INSERT INTO `doctor` VALUES ('17', '刘纯泉', '男', 43, '主任医师', '3301127', '2');
INSERT INTO `doctor` VALUES ('18', '徐春普', '男', 41, '主治医师', '3301128', '4');
INSERT INTO `doctor` VALUES ('19', '陈永红', '女', 41, '主治医师', '3301129', '3');
INSERT INTO `doctor` VALUES ('2', '华佗', '男', 41, '主任医师', '3301112', '2');
INSERT INTO `doctor` VALUES ('20', '薛毅', '男', 41, '主治医师', '3301130', '6');
INSERT INTO `doctor` VALUES ('3', '张仲景', '男', 41, '主任医师', '3301113', '2');
INSERT INTO `doctor` VALUES ('4', '葛洪', '男', 41, '副主任医师', '3301114', '2');
INSERT INTO `doctor` VALUES ('5', '陈实功', '男', 45, '副主任医师', '3301115', '1');
INSERT INTO `doctor` VALUES ('6', '钱乙', '男', 46, '主任医师', '3301116', '4');
INSERT INTO `doctor` VALUES ('7', '唐博渊', '男', 46, '主任医师', '3301117', '3');
INSERT INTO `doctor` VALUES ('8', '从春雨', '男', 53, '副主任医师', '3301118', '3');
INSERT INTO `doctor` VALUES ('9', '鲍姑', '女', 52, '副主任医师', '3301119', '3');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `Meid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Mename` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Price` float(4, 0) NULL DEFAULT NULL,
  `Firm` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Type` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Waid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Price1` float(4, 0) NULL DEFAULT NULL,
  `Snumber` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`Meid`) USING BTREE,
  INDEX `21`(`Waid`) USING BTREE,
  CONSTRAINT `21` FOREIGN KEY (`Waid`) REFERENCES `warehouse` (`Waid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', '青霉素', 22, '哈药集团', '消炎', '1', 12, 921);
INSERT INTO `medicine` VALUES ('10', '美林', 19, '方胜制药', '退热', '2', 9, 1000);
INSERT INTO `medicine` VALUES ('11', '羚羊感冒片', 18, '灵岩药业', '感冒', '3', 11, 1100);
INSERT INTO `medicine` VALUES ('12', '快克', 19, '灵岩药业', '感冒', '3', 12, 1100);
INSERT INTO `medicine` VALUES ('13', '氯雷他定片', 10, '华中药业', '免疫', '2', 5, 122);
INSERT INTO `medicine` VALUES ('2', '利巴韦林', 25, '哈药集团', '消炎', '1', 13, 1985);
INSERT INTO `medicine` VALUES ('3', '罗红霉素', 25, '哈药集团', '消炎', '2', 15, 2100);
INSERT INTO `medicine` VALUES ('4', '健胃消食片', 18, '江中药业', '胃肠', '2', 10, 2000);
INSERT INTO `medicine` VALUES ('5', '奥美拉唑胶囊', 33, '建生制药', '胃肠', '2', 22, 2000);
INSERT INTO `medicine` VALUES ('6', '肠炎宁', 34, '建生制药', '胃肠', '2', 22, 2000);
INSERT INTO `medicine` VALUES ('7', '莲花清瘟胶囊', 30, '以岭药业', '抗病毒', '3', 22, 1900);
INSERT INTO `medicine` VALUES ('8', '抗病毒口服液', 31, '建生制药', '抗病毒', '3', 22, 3000);
INSERT INTO `medicine` VALUES ('9', '安瑞克颗粒', 16, '哈药集团', '退热', '2', 8, 1000);

-- ----------------------------
-- Table structure for opener
-- ----------------------------
DROP TABLE IF EXISTS `opener`;
CREATE TABLE `opener`  (
  `RXid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Doid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Meid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Onumber` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`RXid`, `Meid`) USING BTREE,
  INDEX `8`(`Doid`) USING BTREE,
  INDEX `9`(`Meid`) USING BTREE,
  CONSTRAINT `7` FOREIGN KEY (`RXid`) REFERENCES `rx` (`RXid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `8` FOREIGN KEY (`Doid`) REFERENCES `doctor` (`Doid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `9` FOREIGN KEY (`Meid`) REFERENCES `medicine` (`Meid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of opener
-- ----------------------------
INSERT INTO `opener` VALUES ('1', '1', '1', 2);
INSERT INTO `opener` VALUES ('1', '1', '7', 2);
INSERT INTO `opener` VALUES ('2', '2', '2', 2);
INSERT INTO `opener` VALUES ('2', '2', '3', 2);
INSERT INTO `opener` VALUES ('3', '1', '2', 4);
INSERT INTO `opener` VALUES ('3', '1', '5', 2);
INSERT INTO `opener` VALUES ('4', '1', '2', 2);
INSERT INTO `opener` VALUES ('4', '1', '3', 2);
INSERT INTO `opener` VALUES ('6', '5', '2', 2);
INSERT INTO `opener` VALUES ('6', '5', '3', 2);

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `Pid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pname` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Psex` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Page` int(3) NULL DEFAULT NULL,
  `Account` float(10, 0) NULL DEFAULT NULL,
  `Place` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `State` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1', '安达', '男', 22, 100, '山东潍坊', '无');
INSERT INTO `patient` VALUES ('2', '刘文清', '男', 22, 1000, '山东菏泽', '无');
INSERT INTO `patient` VALUES ('3', '王山', '男', 24, 2000, '山东青岛', '学生');
INSERT INTO `patient` VALUES ('4', '赵信', '男', 30, 2000, '山东济南', '无');
INSERT INTO `patient` VALUES ('5', '刘明', '男', 32, 1000, '北京顺义', '无');
INSERT INTO `patient` VALUES ('6', '王珊', '女', 33, 1000, '河北唐山', '无');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `Pid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Payid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cost1` float(7, 0) NULL DEFAULT NULL,
  `Cost2` float(7, 0) NULL DEFAULT NULL,
  `Cost` float(8, 0) NULL DEFAULT NULL,
  `RXid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `State` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Payid`) USING BTREE,
  INDEX `11`(`RXid`) USING BTREE,
  INDEX `10`(`Pid`) USING BTREE,
  CONSTRAINT `10` FOREIGN KEY (`Pid`) REFERENCES `patient` (`Pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `11` FOREIGN KEY (`RXid`) REFERENCES `rx` (`RXid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('2', '1', 300, 100, 400, '2', '未缴费');
INSERT INTO `payment` VALUES ('1', '2', 300, 104, 404, '1', '已收费');
INSERT INTO `payment` VALUES ('1', '3', 300, 100, 400, '4', '未缴费');
INSERT INTO `payment` VALUES ('1', '4', 200, 100, 300, '6', '已收费');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `Doid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Disease` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Date` date NULL DEFAULT NULL,
  PRIMARY KEY (`Doid`, `Pid`) USING BTREE,
  INDEX `13`(`Pid`) USING BTREE,
  CONSTRAINT `12` FOREIGN KEY (`Doid`) REFERENCES `doctor` (`Doid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `13` FOREIGN KEY (`Pid`) REFERENCES `patient` (`Pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1', '咽炎', '2021-05-03');
INSERT INTO `record` VALUES ('1', '3', '轻型肺炎', '2021-05-06');
INSERT INTO `record` VALUES ('10', '1', '', '2022-05-17');
INSERT INTO `record` VALUES ('12', '1', '', '2022-05-04');
INSERT INTO `record` VALUES ('2', '2', '胃肠炎', '2021-05-04');
INSERT INTO `record` VALUES ('3', '2', '', '2022-05-04');

-- ----------------------------
-- Table structure for rx
-- ----------------------------
DROP TABLE IF EXISTS `rx`;
CREATE TABLE `rx`  (
  `RXid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Doid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`RXid`) USING BTREE,
  INDEX `14`(`Pid`) USING BTREE,
  INDEX `15`(`Doid`) USING BTREE,
  CONSTRAINT `14` FOREIGN KEY (`Pid`) REFERENCES `patient` (`Pid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `15` FOREIGN KEY (`Doid`) REFERENCES `doctor` (`Doid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rx
-- ----------------------------
INSERT INTO `rx` VALUES ('1', '1', '1');
INSERT INTO `rx` VALUES ('2', '2', '2');
INSERT INTO `rx` VALUES ('3', '3', '1');
INSERT INTO `rx` VALUES ('4', '1', '1');
INSERT INTO `rx` VALUES ('6', '1', '5');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `Waid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Meid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Snumber` int(10) NULL DEFAULT NULL,
  `store_id` int(10) NOT NULL,
  PRIMARY KEY (`store_id`) USING BTREE,
  INDEX `16`(`Waid`) USING BTREE,
  INDEX `17`(`Meid`) USING BTREE,
  CONSTRAINT `16` FOREIGN KEY (`Waid`) REFERENCES `warehouse` (`Waid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `17` FOREIGN KEY (`Meid`) REFERENCES `medicine` (`Meid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '1', 100, 1);
INSERT INTO `store` VALUES ('1', '2', 100, 2);
INSERT INTO `store` VALUES ('2', '3', 100, 3);
INSERT INTO `store` VALUES ('2', '4', 100, 4);
INSERT INTO `store` VALUES ('1', '1', 100, 5);
INSERT INTO `store` VALUES ('2', '3', 100, 6);
INSERT INTO `store` VALUES ('1', '1', 200, 7);
INSERT INTO `store` VALUES ('1', '1', 21, 8);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL,
  `name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(20) NOT NULL,
  PRIMARY KEY (`id`, `status`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'abc123', 0);
INSERT INTO `user` VALUES (1, '扁鹊', 'abc123', 1);
INSERT INTO `user` VALUES (1, '安达', 'abc123', 2);
INSERT INTO `user` VALUES (2, '华佗', 'abc123', 1);
INSERT INTO `user` VALUES (2, '刘文清', 'abc123', 2);
INSERT INTO `user` VALUES (3, '王山', 'abc123', 2);
INSERT INTO `user` VALUES (5, '陈实功', 'abc123', 1);
INSERT INTO `user` VALUES (10, '罗有明', 'abc123', 1);

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `Waid` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Place` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Principal` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Waid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', '一号楼', '张三丰');
INSERT INTO `warehouse` VALUES ('2', '二号楼', '张无忌');
INSERT INTO `warehouse` VALUES ('3', '三号楼', '赵志敬');

-- ----------------------------
-- View structure for dest
-- ----------------------------
DROP VIEW IF EXISTS `dest`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `dest` AS select `booking_form`.`Booktime` AS `Booktime`,`department`.`Dename` AS `Dename`,`booking_form`.`Pid` AS `Pid`,`patient`.`Pname` AS `Pname`,`doctor`.`Doname` AS `Doname` from (((`department` join `booking_form`) join `doctor`) join `patient`) where ((`doctor`.`Deid` = `department`.`Deid`) and (`patient`.`Pid` = `booking_form`.`Pid`) and (`booking_form`.`Doid` = `doctor`.`Doid`));

-- ----------------------------
-- View structure for mest
-- ----------------------------
DROP VIEW IF EXISTS `mest`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `mest` AS select `medicine`.`Mename` AS `Mename`,`medicine`.`Snumber` AS `Snumber` from `medicine`;

-- ----------------------------
-- View structure for pay
-- ----------------------------
DROP VIEW IF EXISTS `pay`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `pay` AS select `opener`.`RXid` AS `RXid`,sum((`opener`.`Onumber` * `medicine`.`Price`)) AS `SUM(opener.Onumber*medicine.Price)` from (`opener` join `medicine`) where (`medicine`.`Meid` = `opener`.`Meid`) group by `opener`.`RXid`;

-- ----------------------------
-- Procedure structure for DEST1
-- ----------------------------
DROP PROCEDURE IF EXISTS `DEST1`;
delimiter ;;
CREATE PROCEDURE `DEST1`(IN `date1` LONGTEXT,IN `date2` LONGTEXT)
BEGIN
	#Routine body goes here...
SELECT Dename,COUNT(*)
FROM department,booking_form,doctor
WHERE doctor.Deid=department.Deid and booking_form.Doid=doctor.Doid and Booktime BETWEEN date1 AND date2
GROUP BY department.Deid;


END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for DEST2
-- ----------------------------
DROP PROCEDURE IF EXISTS `DEST2`;
delimiter ;;
CREATE PROCEDURE `DEST2`(IN `date1` longtext,IN `date2` longtext)
BEGIN
	#Routine body goes here...
SELECT Booktime,Dename,booking_form.Pid,patient.Pname,doctor.Doname
FROM department,booking_form,doctor,patient
WHERE doctor.Deid=department.Deid and patient.Pid=booking_form.Pid AND booking_form.Doid=doctor.Doid and Booktime BETWEEN date1 AND date2;

END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table booking_form
-- ----------------------------
DROP TRIGGER IF EXISTS `re`;
delimiter ;;
CREATE TRIGGER `re` AFTER INSERT ON `booking_form` FOR EACH ROW BEGIN
	INSERT INTO record VALUES(new.Doid,new.Pid," ",new.Booktime);
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table deliver
-- ----------------------------
DROP TRIGGER IF EXISTS `t_i_s`;
delimiter ;;
CREATE TRIGGER `t_i_s` AFTER INSERT ON `deliver` FOR EACH ROW BEGIN
	UPDATE  medicine SET Snumber=Snumber-new.Dnumber 
	WHERE Meid = new.Meid;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table doctor
-- ----------------------------
DROP TRIGGER IF EXISTS `t_i_s2`;
delimiter ;;
CREATE TRIGGER `t_i_s2` AFTER INSERT ON `doctor` FOR EACH ROW BEGIN
	UPDATE department SET Dsum=Dsum+1  WHERE Deid = new.Deid;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table doctor
-- ----------------------------
DROP TRIGGER IF EXISTS `t_i_s4`;
delimiter ;;
CREATE TRIGGER `t_i_s4` AFTER DELETE ON `doctor` FOR EACH ROW BEGIN
	UPDATE department SET Dsum = Dsum - 1 WHERE Deid = old.Deid;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table payment
-- ----------------------------
DROP TRIGGER IF EXISTS `pay`;
delimiter ;;
CREATE TRIGGER `pay` AFTER UPDATE ON `payment` FOR EACH ROW BEGIN
   UPDATE patient SET Account=Account-new.Cost WHERE new.State='已收费' AND patient.Pid=new.Pid;
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table store
-- ----------------------------
DROP TRIGGER IF EXISTS `t_i_s1`;
delimiter ;;
CREATE TRIGGER `t_i_s1` AFTER INSERT ON `store` FOR EACH ROW BEGIN
	UPDATE medicine SET Snumber=Snumber+new.Snumber  WHERE Meid=new.Meid;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
