package org.jsoft.service;

import java.util.List;

import org.jsoft.base.service.IBaseService;

import utils.PageData;

public interface ISysRoleMenuService extends IBaseService {

	public void updateMenu(List<PageData> list) throws Exception;
	
}
