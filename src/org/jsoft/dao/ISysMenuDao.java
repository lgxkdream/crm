package org.jsoft.dao;

import java.util.List;

import org.jsoft.base.dao.IBaseDao;

import utils.PageData;

public interface ISysMenuDao extends IBaseDao{

	public List<PageData> selectMenu(Object obj) throws Exception;
	
}
