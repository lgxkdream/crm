package org.jsoft.base.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.jsoft.base.dao.IBaseDao;
import org.mybatis.spring.SqlSessionTemplate;

import codeGenerater.CGUtil;
import utils.PageData;

public class BaseDaoImpl implements IBaseDao{

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate sqlSessionTemplate;
	protected String className;
	
	public BaseDaoImpl(){
		String str = this.getClass().getName();
		String[] strArr = str.split("\\.");
		className = CGUtil.lowerFirst(strArr[strArr.length - 1].split("Dao")[0]);
	}
	
	/**
	 * 新增
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	@Override
	public Object save(Object obj) throws Exception {
		String str = this.className + ".insert";
		return sqlSessionTemplate.insert(str, obj);
	}

	/**
	 * 批量新增
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	@Override
	public Object saveBatch(List<PageData> objs) throws Exception {
		String str = this.className + ".saveBatch";
		return sqlSessionTemplate.insert(str, objs);
	}

	/**
	 * 批量删除
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 删除对象
	 * @return 删除数量
	 * @throws Exception
	 */
	@Override
	public Object deleteBatch(String[] ids) throws Exception {
		String str = this.className + ".deleteBatch";
		return sqlSessionTemplate.delete(str, ids);
	}

	/**
	 * 修改
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 修改对象
	 * @return 修改数量
	 * @throws Exception
	 */
	@Override
	public Object update(Object obj) throws Exception {
		String str = this.className + ".update";
		return sqlSessionTemplate.update(str, obj);
	}

	/**
	 * 查询所有
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 查询条件对象
	 * @return 查询结果
	 * @throws Exception
	 */
	@Override
	public List<PageData> listAll(Object obj) throws Exception {
		String str = this.className + ".listAll";
		return sqlSessionTemplate.selectList(str, obj);
	}

	/**
	 * 按照ID查询
	 * @author WZ
	 * @date 2016-5-19
	 * @param obj 新增对象
	 * @return 新增数量
	 * @throws Exception
	 */
	@Override
	public Object listById(String id) throws Exception {
		String str = this.className + ".selectById";
		return sqlSessionTemplate.selectOne(str, id);
	}

}
