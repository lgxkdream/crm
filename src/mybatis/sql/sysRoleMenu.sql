DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu (
  	id varchar(32) NOT NULL,
	menu_id varchar(128) default NULL,
	role_id varchar(32) default NULL,

	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
