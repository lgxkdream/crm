DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu (
  	id varchar(32) NOT NULL,
	level int default NULL,
	sort varchar(32) default NULL,
	name varchar(32) default NULL,
	html varchar(128) default NULL,
	type varchar(4) default NULL,
	parent_id varchar(32) default NULL,

	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
