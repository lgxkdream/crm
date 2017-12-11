package org.jsoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jsoft.base.service.impl.BaseServiceImpl;
import org.jsoft.dao.ISysUserDao;
import org.jsoft.service.ISysMenuService;
import org.jsoft.service.ISysUserService;
import org.springframework.stereotype.Service;

import utils.BeanTool;
import utils.PageData;

@Service
public class SysUserServiceImpl extends BaseServiceImpl implements ISysUserService{

	private ISysUserDao sysUserDao;
	@Resource
	private ISysMenuService sysMenuService;
	
	public PageData getSysUserDetail(PageData pd) throws Exception{
		PageData result = null;
		PageData user = null;
		List<PageData> userList = sysUserDao.listAll(pd);
		if(!BeanTool.isNull(userList)){
			user = userList.get(0);
			result = sysMenuService.selectMenu(user);
		}
		return result;
	}

	public ISysUserDao getSysUserDao() {
		return sysUserDao;
	}

	@Resource
	public void setSysUserDao(ISysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
		this.dao = sysUserDao;
	}

	public ISysMenuService getSysMenuService() {
		return sysMenuService;
	}

	public void setSysMenuService(ISysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}

}
