package org.jsoft.base.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.codehaus.jackson.map.util.JSONPObject;

import utils.PageData;

public class BaseController {

	@SuppressWarnings("rawtypes")
	protected Object returnObject(PageData pd, Map map){
		if(pd.containsKey("callback")){
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, map);
		}else{
			return map;
		}
	}
	
	protected void writeJSON(HttpServletResponse response, Object obj) {
		response.setContentType("text/html;charset=utf-8");
		String json = "";
		if(obj instanceof List){
			json = JSONArray.fromObject(obj).toString();
		}else{
			json = JSONObject.fromObject(obj).toString();
		}
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
