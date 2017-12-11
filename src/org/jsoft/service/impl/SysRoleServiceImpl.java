package org.jsoft.service.impl;

import javax.annotation.Resource;

import org.jsoft.base.service.impl.BaseServiceImpl;
import org.jsoft.dao.ISysRoleDao;
import org.jsoft.service.ISysRoleService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl implements ISysRoleService{

	private ISysRoleDao sysRoleDao;

	public ISysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	@Resource
	public void setSysRoleDao(ISysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
		this.dao = sysRoleDao;
	}
	
}
