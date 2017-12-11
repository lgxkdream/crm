package org.jsoft.service.impl;

import javax.annotation.Resource;

import org.jsoft.base.service.impl.BaseServiceImpl;
import org.jsoft.dao.ICustomerDao;
import org.jsoft.service.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl implements ICustomerService{

	private ICustomerDao customerDao;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	@Resource
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
		this.dao = customerDao;
	}
	
}
