package org.jsoft.base.dao;

import java.util.List;

import utils.PageData;


public interface IBaseDao {

	/**
	 * 新增
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	public Object save(Object obj) throws Exception;
	
	/**
	 * 批量新增
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	public Object saveBatch(List<PageData> objs) throws Exception;
	
	/**
	 * 批量删除
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 删除对象
	 * @return 删除数量
	 * @throws Exception
	 */
	public Object deleteBatch(String[] ids) throws Exception;
	
	/**
	 * 修改
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 修改对象
	 * @return 修改数量
	 * @throws Exception
	 */
	public Object update(Object obj) throws Exception;
	
	/**
	 * 查询所有
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 查询条件对象
	 * @return 查询结果
	 * @throws Exception
	 */
	public List<PageData> listAll(Object obj) throws Exception;
	
	/**
	 * 按照ID查询
	 * @author WZ
	 * @date 2016-5-19
	 * @param id 新增对象ID
	 * @return 
	 * @throws Exception
	 */
	public Object listById(String id) throws Exception;
	
}
