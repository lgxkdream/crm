package org.jsoft.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jsoft.base.service.impl.BaseServiceImpl;
import org.jsoft.dao.ISysMenuDao;
import org.jsoft.service.ISysMenuService;
import org.springframework.stereotype.Service;

import utils.BeanTool;
import utils.PageData;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl implements ISysMenuService{

	private ISysMenuDao sysMenuDao;

	public ISysMenuDao getSysMenuDao() {
		return sysMenuDao;
	}

	@Resource
	public void setSysMenuDao(ISysMenuDao sysMenuDao) {
		this.sysMenuDao = sysMenuDao;
		this.dao = sysMenuDao;
	}

	@Override
	public PageData selectMenu(Object obj) throws Exception {
		PageData result = new PageData();
		List<PageData> menuList = sysMenuDao.selectMenu(obj);
		result = this.createMenuTree(menuList);
		return result;
	}
	
	public PageData selectAllMenu(Object obj) throws Exception {
		PageData result = new PageData();
		List<PageData> menuList = sysMenuDao.listAll(obj);
		result = this.createMenuTree(menuList);
		return result;
	}
	
	private PageData createMenuTree(List<PageData> menuList){
		PageData result = null;
		if(!BeanTool.isNull(menuList)){
			Map<String, List<PageData>> map = new HashMap<String, List<PageData>>();
			for(int i = 0; i < menuList.size(); i++){
				PageData p = menuList.get(i);
				List<PageData> list = map.get(p.get("LEVEL") + "");
				if(!BeanTool.isNull(list)){
					list.add(p);
				}else{
					list = new ArrayList<PageData>();
					list.add(p);
					map.put(p.get("LEVEL") + "", list);
				}
			}
			for(int i = map.size(); i >= 0; i--){
				List<PageData> list_low = map.get(i + "");
				if(i - 1 >= 0){
					List<PageData> list_up = map.get((i - 1) + "");
					if(!BeanTool.isNull(list_low) && !BeanTool.isNull(list_up)){
						for(PageData pLow : list_low){
							for(PageData pUp : list_up){
								if(pLow.get("PARENT_ID").equals(pUp.get("ID"))){
									@SuppressWarnings("unchecked")
									List<PageData> childList = (List<PageData>)pUp.get("childList");
									if(!BeanTool.isNull(childList)){
										childList.add(pLow);
									}else{
										childList = new ArrayList<PageData>();
										childList.add(pLow);
										pUp.put("childList", childList);
									}
								}
							}
						}
					}
				}
			}
			result = map.get("0").get(0);
		}
		return result;
	}
	
}
