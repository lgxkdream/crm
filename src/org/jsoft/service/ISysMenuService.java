package org.jsoft.service;

import org.jsoft.base.service.IBaseService;

import utils.PageData;

public interface ISysMenuService extends IBaseService {

	public PageData selectMenu(Object obj) throws Exception;
	
	public PageData selectAllMenu(Object obj) throws Exception;
	
}
