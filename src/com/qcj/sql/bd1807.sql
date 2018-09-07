/*
 Navicat MySQL Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : bd1807

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 29/08/2018 16:27:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` decimal(20, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'zs', 1000.00);
INSERT INTO `account` VALUES (2, 'ls', 1000.00);

-- ----------------------------
-- Table structure for classroom
-- ----------------------------
DROP TABLE IF EXISTS `classroom`;
CREATE TABLE `classroom`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom
-- ----------------------------
INSERT INTO `classroom` VALUES (1, 'bd11');
INSERT INTO `classroom` VALUES (2, 'bd12');
INSERT INTO `classroom` VALUES (3, 'bd13');
INSERT INTO `classroom` VALUES (4, 'bd14');
INSERT INTO `classroom` VALUES (5, 'bd15');
INSERT INTO `classroom` VALUES (6, NULL);

-- ----------------------------
-- Table structure for classroom1
-- ----------------------------
DROP TABLE IF EXISTS `classroom1`;
CREATE TABLE `classroom1`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classroom1
-- ----------------------------
INSERT INTO `classroom1` VALUES (1, 'bd12');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` int(11) NOT NULL,
  `dname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `loc` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO `dept` VALUES (20, 'RESEARCH', 'DALLAS');
INSERT INTO `dept` VALUES (30, 'SALES', 'CHICAGO');
INSERT INTO `dept` VALUES (40, 'OPERATIONS', 'BOSTON');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `empno` int(11) NOT NULL,
  `ename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `job` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` datetime(0) DEFAULT NULL,
  `sal` decimal(10, 2) DEFAULT NULL,
  `comm` decimal(10, 2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`) USING BTREE,
  INDEX `FK_DEPTNO`(`deptno`) USING BTREE,
  INDEX `index_ename`(`ename`) USING BTREE,
  INDEX `index_empno`(`empno`) USING BTREE,
  CONSTRAINT `FK_DEPTNO` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20 00:00:00', 1600.00, 300.00, 30);
INSERT INTO `emp` VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22 00:00:00', 1250.00, 500.00, 30);
INSERT INTO `emp` VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02 00:00:00', 2975.00, NULL, 20);
INSERT INTO `emp` VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28 00:00:00', 1250.00, 1400.00, 30);
INSERT INTO `emp` VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01 00:00:00', 2850.00, NULL, 30);
INSERT INTO `emp` VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09 00:00:00', 2500.00, NULL, 10);
INSERT INTO `emp` VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19 00:00:00', 3000.00, NULL, 20);
INSERT INTO `emp` VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17 00:00:00', 5000.00, NULL, 10);
INSERT INTO `emp` VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08 00:00:00', 1500.00, 0.00, 30);
INSERT INTO `emp` VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23 00:00:00', 1100.00, NULL, 20);
INSERT INTO `emp` VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03 00:00:00', 950.00, NULL, 30);
INSERT INTO `emp` VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03 00:00:00', 3000.00, NULL, 20);
INSERT INTO `emp` VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23 00:00:00', 1300.00, NULL, 10);

-- ----------------------------
-- Table structure for emp1
-- ----------------------------
DROP TABLE IF EXISTS `emp1`;
CREATE TABLE `emp1`  (
  `empno` int(11) NOT NULL,
  `ename` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `job` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` datetime(0) DEFAULT NULL,
  `sal` decimal(10, 2) DEFAULT NULL,
  `comm` decimal(10, 2) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp1
-- ----------------------------
INSERT INTO `emp1` VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17 00:00:00', 800.00, NULL, 20);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL DEFAULT 0,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` bit(1) DEFAULT b'1',
  `birthday` date DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zs', b'0', '1998-09-09');
INSERT INTO `user` VALUES (2, 'ls', b'1', NULL);
INSERT INTO `user` VALUES (6, 'ww', b'0', '1998-09-09');
INSERT INTO `user` VALUES (7, 'zl', b'1', '1998-08-08');
INSERT INTO `user` VALUES (8, 'fq', b'0', '1997-07-07');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` bit(1) DEFAULT b'1',
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, 'zs', b'0', '1998-09-09');
INSERT INTO `userinfo` VALUES (2, 'ls', b'1', NULL);
INSERT INTO `userinfo` VALUES (6, 'ww', b'0', '1998-09-09');
INSERT INTO `userinfo` VALUES (7, 'zl', b'1', '1998-08-08');
INSERT INTO `userinfo` VALUES (8, 'fq', b'0', '1997-07-07');

-- ----------------------------
-- Table structure for userinfo1
-- ----------------------------
DROP TABLE IF EXISTS `userinfo1`;
CREATE TABLE `userinfo1`  (
  `uid` int(11) NOT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo1
-- ----------------------------
INSERT INTO `userinfo1` VALUES (2, 'ls', '222');
INSERT INTO `userinfo1` VALUES (3, 'ww', '333');

-- ----------------------------
-- Table structure for userinfo2
-- ----------------------------
DROP TABLE IF EXISTS `userinfo2`;
CREATE TABLE `userinfo2`  (
  `uid` int(11) NOT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo2
-- ----------------------------
INSERT INTO `userinfo2` VALUES (1, 'zs', '111');

-- ----------------------------
-- Table structure for userinfos
-- ----------------------------
DROP TABLE IF EXISTS `userinfos`;
CREATE TABLE `userinfos`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfos
-- ----------------------------
INSERT INTO `userinfos` VALUES (3, 'demo2', '123');

-- ----------------------------
-- View structure for view_emp_dept
-- ----------------------------
DROP VIEW IF EXISTS `view_emp_dept`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `view_emp_dept` AS select `emp`.`empno` AS `empno`,`emp`.`ename` AS `ename`,`emp`.`job` AS `job`,`emp`.`mgr` AS `mgr`,`emp`.`hiredate` AS `hiredate`,`emp`.`sal` AS `sal`,`emp`.`comm` AS `comm`,`emp`.`deptno` AS `deptno`,`dept`.`dname` AS `dname`,`dept`.`loc` AS `loc` from (`emp` join `dept`) where (`emp`.`deptno` = `dept`.`deptno`)  WITH CASCADED CHECK OPTION;

-- ----------------------------
-- Procedure structure for calc
-- ----------------------------
DROP PROCEDURE IF EXISTS `calc`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calc`()
begin
			declare i int;
			declare sum int;
			set i = 1;
			set sum = 0;	
			#while
			while i<=100 do 
				set sum = sum + i;
				set i = i + 1;
			end while;
			
			select sum;
		end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for calc1
-- ----------------------------
DROP PROCEDURE IF EXISTS `calc1`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calc1`()
begin
			declare i int;
			declare sum int;
			set i = 1;
			set sum = 0;	
			#loop
			lip:loop #添加一个别名
				set sum = sum + i;
				set i = i + 1;
				if i>100 then
					leave lip; -- 离开循环
				end if;  -- 不要忘记
			end loop;
			
			select sum;
		end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for calc2
-- ----------------------------
DROP PROCEDURE IF EXISTS `calc2`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calc2`()
begin
			declare i int;
			declare sum int;
			set i = 1;
			set sum = 0;	
			#repeat
			repeat
				set sum = sum + i;
				set i = i + 1;
				until i > 100
			end repeat;
			
			select sum;
		end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for findEmpByNo
-- ----------------------------
DROP PROCEDURE IF EXISTS `findEmpByNo`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findEmpByNo`(eno int)
begin
			select * from emp where deptno = eno;
	 end
;;
delimiter ;

-- ----------------------------
-- Function structure for findNameByNo
-- ----------------------------
DROP FUNCTION IF EXISTS `findNameByNo`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `findNameByNo`(eno int) RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
begin
		declare v_name varchar(20);
		select ename into v_name from emp where empno = eno;
		return v_name;
	end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for findNameByNo
-- ----------------------------
DROP PROCEDURE IF EXISTS `findNameByNo`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findNameByNo`(eno int,out v_name varchar(20))
begin
			select ename into v_name from emp where empno = eno;
		end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for score_level
-- ----------------------------
DROP PROCEDURE IF EXISTS `score_level`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `score_level`(score int)
begin
			# 变量的声明 
			declare v_level varchar(20);  
			if score > 80 then 
				#变量的赋值
				set v_level = 'A';
			elseif score>=60 then 
				set v_level = 'B';
			else 
			  set v_level = 'C';
			end if; -- 别忘了
			select v_level;
		end
;;
delimiter ;

-- ----------------------------
-- Function structure for selectDnameByEno
-- ----------------------------
DROP FUNCTION IF EXISTS `selectDnameByEno`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `selectDnameByEno`(eno int) RETURNS varchar(20) CHARSET utf8
begin
	declare d_name varchar(20);
	select dname  into d_name from emp,dept where emp.deptno = dept.deptno and emp.empno = 7788;
	return d_name;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for selectEnameByDno
-- ----------------------------
DROP PROCEDURE IF EXISTS `selectEnameByDno`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectEnameByDno`(dno int)
begin
		select ename from emp where deptno = dno;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for sel_emp
-- ----------------------------
DROP PROCEDURE IF EXISTS `sel_emp`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sel_emp`()
begin
			#一组sql
			select dname,ename from emp,dept where dept.deptno = emp.deptno;
	 end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table emp
-- ----------------------------
DROP TRIGGER IF EXISTS `tri_emp`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `tri_emp` AFTER DELETE ON `emp` FOR EACH ROW begin
	insert into emp1 values(old.empno,old.ename,old.job,old.mgr,old.hiredate,old.sal,old.comm,old.deptno);
end
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table userinfo1
-- ----------------------------
DROP TRIGGER IF EXISTS `tri_user`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `tri_user` AFTER DELETE ON `userinfo1` FOR EACH ROW begin
		  # old new 记录的对象用old表示
			insert into userinfo2 values(old.uid,old.uname,old.password);
		end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
