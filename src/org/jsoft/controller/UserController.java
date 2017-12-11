package org.jsoft.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.jsoft.base.controller.BaseController;
import org.jsoft.constants.SysConstants;
import org.jsoft.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.BeanTool;
import utils.PageData;
import utils.UUIDTool;

@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController{
	
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		PageData pd = new PageData(request);
		String errInfo = "";
		try {
			List<PageData> list = userService.listAll(pd);
			if(!BeanTool.isNull(list)){
				Subject subject = SecurityUtils.getSubject(); 
				Session session = subject.getSession();
				session.setAttribute(SysConstants.USER, list.get(0));
			    UsernamePasswordToken token = new UsernamePasswordToken((String)(pd.get("username")), (String)(pd.get("password"))); 
			    try { 
			        subject.login(token); 
			    } catch (AuthenticationException e) { 
			    	errInfo = "身份验证失败！";
			    }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", errInfo);
		this.writeJSON(response, result);
	}
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData(req);
		pd.put("id", UUIDTool.getUUID());
		try {
			userService.save(pd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");

		return mv;
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	} 

	@RequestMapping("/addBatch")
	public ModelAndView addBatch(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<PageData> list = new ArrayList<PageData>();
		for (int i = 0; i < 3; i++) {
			PageData pd = new PageData();
			pd.put("name", "a");
			pd.put("password", "a");
			pd.put("id", UUIDTool.getUUID());
			pd.put("birth", new Date());
			list.add(pd);
		}
		try {
			userService.saveBatch(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");
		return mv;
	}
	
	@RequestMapping("/deleteBatch")
	public ModelAndView deleteBatch(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String[] ids = {"2","3","4"};
		try {
			System.out.println(userService.deleteBatch(ids));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(userService.delete("2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd.put("id", "2");
		pd.put("name", "a");
		pd.put("password", "b");
		try {
			System.out.println(userService.update(pd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");
		return mv;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd.put("name", "a");
		try {
			System.out.println(userService.listAll(pd));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");
		return mv;
	}
	@RequestMapping("/listOne")
	public ModelAndView listOne(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		try {
			System.out.println(userService.listById("2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		mv.setViewName("MyJsp");
		return mv;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
