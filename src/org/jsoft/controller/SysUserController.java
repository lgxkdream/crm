package org.jsoft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.base.controller.BaseController;
import org.jsoft.service.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.PageData;

@Controller
@RequestMapping("/sys/sysUser")
public class SysUserController extends BaseController{
	
	@Resource
	private ISysUserService sysUserService;
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		PageData pd = new PageData(request);
		String errInfo = "1";
		try {
			PageData user = sysUserService.getSysUserDetail(pd);
			if(user != null){
			}else{
				errInfo = "用户名或密码错误！";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", errInfo);
		this.writeJSON(response, result);
	}
	
	@RequestMapping("/home")
	public ModelAndView toHome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tbl");
		return mv;
	}

	public ISysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
}
