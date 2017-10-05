package com.cg.service;

import com.cg.bean.CustomerBean;
import com.cg.dao.CustomerDaoImpl;
import com.cg.dao.ICustomerDao;

public class CustomerServiceImpl implements ICustomerService {


	ICustomerDao dao = new CustomerDaoImpl();
	
	public int addDetails(CustomerBean bean) 
	{
		dao = new CustomerDaoImpl();
		return dao.addDetails(bean);
	}

}
