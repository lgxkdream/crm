package org.jsoft.dao.impl;

import java.util.List;

import org.jsoft.base.dao.impl.BaseDaoImpl;
import org.jsoft.dao.ISysMenuDao;
import org.springframework.stereotype.Repository;

import utils.PageData;

@Repository
public class SysMenuDaoImpl extends BaseDaoImpl implements ISysMenuDao {

	public List<PageData> selectMenu(Object obj) throws Exception {
		String method = this.className + ".selectMenu";
		return sqlSessionTemplate.selectList(method, obj);
	}
	
}
