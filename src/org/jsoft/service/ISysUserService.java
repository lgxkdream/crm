package org.jsoft.service;

import org.jsoft.base.service.IBaseService;

import utils.PageData;

public interface ISysUserService extends IBaseService {

	public PageData getSysUserDetail(PageData pd) throws Exception;
	
}
