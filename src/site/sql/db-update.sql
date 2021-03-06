create database dev;
use dev;
set global time_zone='+8:00';
CREATE TABLE `t_user_info` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `age` tinyint(2) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(20) DEFAULT NULL COMMENT '头像',
  `introduce` text COMMENT '自我介绍',
  `create_time` timestamp DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(1) DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_user_auth(
	id INT(6)	PRIMARY KEY AUTO_INCREMENT,
	user_id		INT(6),
	identity_type	TINYINT(1) COMMENT '验证方式',
	identifier	VARCHAR(50) COMMENT '标志',
	credential	varchar(50) COMMENT '凭证',
	salt		varchar(50),
	verified	TINYINT(1) COMMENT '是否验证',
	locked		TINYINT(1) COMMENT '是否被锁定',
	create_time timestamp DEFAULT CURRENT_TIMESTAMP,
  	update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	is_delete	TINYINT(1) COMMENT '删除标志',
	CONSTRAINT `fk_user_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user_info` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

use dev;

DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'URL地址',
  `description` varchar(64) DEFAULT NULL COMMENT '描述',
  `isActivated` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `role` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(10) DEFAULT NULL COMMENT '描述',
  `isActivated` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `role_id` int(6) DEFAULT NULL COMMENT '角色ID',
  `permission_id` int(6) DEFAULT NULL COMMENT '权限ID',
  `isActivated` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
DROP TABLE IF EXISTS `t_user_role`;
CREATE table t_user_role(
	`user_id` INT(6) COMMENT '用户ID',
	`role_id` int(6) COMMENT '角色ID',
	`isActivated` tinyint(1) DEFAULT '1'
);