DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  	id varchar(32) NOT NULL,
	role_id varchar(32) default NULL,
	login_name varchar(32) default NULL,
	name varchar(32) default NULL,
	password varchar(32) default NULL,

	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
