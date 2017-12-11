DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  	id varchar(32) NOT NULL,
	name varchar(32) default NULL,

	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
