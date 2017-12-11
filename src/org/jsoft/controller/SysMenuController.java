package org.jsoft.controller;

import java.util.List;

import javax.annotation.Resource;

import org.jsoft.base.controller.BaseController;
import org.jsoft.service.ISysMenuService;
import org.jsoft.service.ISysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.PageData;

@Controller
@RequestMapping("/sys/sysMenu")
public class SysMenuController extends BaseController{
	
	@Resource
	private ISysMenuService sysMenuService;
	@Resource
	private ISysRoleService sysRoleService;
	
	@RequestMapping("menu")
	public ModelAndView menu(){
		ModelAndView mv = new ModelAndView();
		PageData menu = null;
		List<PageData> roleList = null;
		try {
			menu = sysMenuService.selectAllMenu(new PageData());
			roleList = sysRoleService.listAll(new PageData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.addObject("menuList", menu);
		mv.addObject("roleList", roleList);
		mv.setViewName("/menu/menu");
		return mv;
	}
	
	public ISysMenuService getSysMenuService() {
		return sysMenuService;
	}

	public void setSysMenuService(ISysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}

	public ISysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
}
