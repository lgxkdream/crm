package org.jsoft.controller;

import javax.annotation.Resource;

import org.jsoft.base.controller.BaseController;
import org.jsoft.service.ISysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys/sysRole")
public class SysRoleController extends BaseController{
	
	@Resource
	private ISysRoleService sysRoleService;

	public ISysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
}
