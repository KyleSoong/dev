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
