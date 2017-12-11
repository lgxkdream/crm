package org.jsoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.base.controller.BaseController;
import org.jsoft.service.ISysRoleMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import utils.PageData;
import utils.UUIDTool;

@Controller
@RequestMapping("/sys/sysRoleMenu")
public class SysRoleMenuController extends BaseController{
	
	@Resource
	private ISysRoleMenuService sysRoleMenuService;

	@RequestMapping("getMenu")
	public void getMenu(HttpServletRequest request, HttpServletResponse response){
		PageData pd = new PageData(request);
		List<PageData> menuList = null;
		try {
			menuList = sysRoleMenuService.listAll(pd);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.writeJSON(response, menuList);
	}
	
	@RequestMapping("updateMenu")
	public void updateMenu(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("MENU_IDS");
		String roleId = request.getParameter("ROLE_ID");
		String[] idArr = ids.split(",");
		List<PageData> pdList = new ArrayList<PageData>();
		if(idArr != null && idArr.length > 0){
			for(String s : idArr){
				PageData pd = new PageData();
				pd.put("id", UUIDTool.getUUID());
				pd.put("menu_id", s);
				pd.put("role_id", roleId);
				pdList.add(pd);
			}
		}
		try {
			sysRoleMenuService.updateMenu(pdList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ISysRoleMenuService getSysRoleMenuService() {
		return sysRoleMenuService;
	}

	public void setSysRoleMenuService(ISysRoleMenuService sysRoleMenuService) {
		this.sysRoleMenuService = sysRoleMenuService;
	}
}
