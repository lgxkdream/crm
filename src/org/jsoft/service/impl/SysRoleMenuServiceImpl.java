package org.jsoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jsoft.base.service.impl.BaseServiceImpl;
import org.jsoft.dao.ISysRoleMenuDao;
import org.jsoft.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;

import utils.PageData;

@Service
public class SysRoleMenuServiceImpl extends BaseServiceImpl implements ISysRoleMenuService {

	private ISysRoleMenuDao sysRoleMenuDao;

	public void updateMenu(List<PageData> list) throws Exception {
		PageData pd = new PageData();
		pd.put("role_id", list.get(0).get("role_id"));
		List<PageData> pdList = sysRoleMenuDao.listAll(pd);
		if(pdList != null && pdList.size() > 0){
			String[] deleteIds = new String[pdList.size()];
			for(int i = 0; i < pdList.size(); i++){
				deleteIds[i] = pdList.get(i).getString("ID");
			}
			sysRoleMenuDao.deleteBatch(deleteIds);
		}
		sysRoleMenuDao.saveBatch(list);
	}

	public ISysRoleMenuDao getSysRoleMenuDao() {
		return sysRoleMenuDao;
	}

	@Resource
	public void setSysRoleMenuDao(ISysRoleMenuDao sysRoleMenuDao) {
		this.sysRoleMenuDao = sysRoleMenuDao;
		this.dao = sysRoleMenuDao;
	}

}
