package org.jsoft.base.service.impl;

import java.util.List;

import org.jsoft.base.dao.IBaseDao;
import org.jsoft.base.service.IBaseService;

import utils.PageData;

public class BaseServiceImpl implements IBaseService {

	protected IBaseDao dao;

	/**
	 * 新增
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	@Override
	public Object save(Object obj) throws Exception {
		return this.dao.save(obj);
	}

	/**
	 * 批量新增
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	@Override
	public Object saveBatch(List<PageData> objs) throws Exception {
		return this.dao.saveBatch(objs);
	}

	/**
	 * 批量删除
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            删除对象的主键
	 * @return 删除数量
	 * @throws Exception
	 */
	@Override
	public Object deleteBatch(String[] ids) throws Exception {
		return this.dao.deleteBatch(ids);
	}

	/**
	 * 删除
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            删除对象主键
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object delete(String id) throws Exception {
		String[] ids = {id};
		return this.deleteBatch(ids);
	}

	/**
	 * 修改
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            修改对象
	 * @return 修改数量
	 * @throws Exception
	 */
	@Override
	public Object update(Object obj) throws Exception {
		return this.dao.update(obj);
	}

	/**
	 * 查询所有
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            查询条件对象
	 * @return 查询结果
	 * @throws Exception
	 */
	@Override
	public List<PageData> listAll(Object obj) throws Exception {
		return this.dao.listAll(obj);
	}

	/**
	 * 按照ID查询
	 * 
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj
	 *            新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	@Override
	public Object listById(String id) throws Exception {
		return this.dao.listById(id);
	}

	public IBaseDao getDao() {
		return dao;
	}

	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}

}
