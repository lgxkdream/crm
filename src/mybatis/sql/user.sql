CREATE TABLE user (
  	id varchar(32) NOT NULL,
	name varchar(32) default NULL,
	password varchar(32) default NULL,
	birth datetime default NULL,

	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
