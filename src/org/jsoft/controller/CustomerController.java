package org.jsoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.base.controller.BaseController;
import org.jsoft.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.PageData;

@Controller
@RequestMapping("/sys/customer")
public class CustomerController extends BaseController{
	
	@Resource
	private ICustomerService customerService;

	@RequestMapping("/list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		List<PageData> list = new ArrayList<PageData>();
		try {
			list = customerService.listAll(new PageData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", list);
		this.writeJSON(response, result);
	}
	
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tbl2");
		return mv;
	}
	
	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}
}
