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
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机',
  `age` tinyint(4) DEFAULT NULL COMMENT '年龄',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `introduce` text COMMENT '自我介绍',
  `create_time` timestamp,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_valid` tinyint(4) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE t_user_auth(
	id INT(6)	PRIMARY KEY AUTO_INCREMENT,
	user_id		INT(6),
	identity_type	TINYINT(1) COMMENT '验证方式',
	identifier	VARCHAR(50) COMMENT '标志',
	credential	varchar(50) COMMENT '凭证',
	verified	TINYINT(1) COMMENT '是否验证',
	create_time	TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	is_valid	TINYINT(1) COMMENT '有效位',
	CONSTRAINT `fk_user_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user_info` (`id`) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;