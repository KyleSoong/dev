create database dev;
use dev;
set global time_zone='+8:00';
create table tb_user(
	id varchar(32),
	user_name varchar(25),
	password varchar(32),
	age int(3),
	role int(11),
	flag int(11));

INSERT INTO `tb_user` VALUES ('101', 'kyle', '123', '12', '1', '1');
INSERT INTO `tb_user` VALUES ('102', 'sasha', '111', '11', '0', '0');

rename table tb_user to t_user_info;
--用户信息表
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