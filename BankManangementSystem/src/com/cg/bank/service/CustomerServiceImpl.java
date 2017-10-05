package com.cg.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bank.bean.CustomerBean;
import com.cg.bank.dao.CustomerDaoImpl;
import com.cg.bank.dao.ICustomerDao;

public class CustomerServiceImpl implements ICustomerService{

	ICustomerDao dao = new CustomerDaoImpl();
	
	@Override
	public int addCustomer(CustomerBean bean) {
		
		dao = new CustomerDaoImpl();
		return dao.addCustomer(bean);
	}

	@Override
	public ArrayList<CustomerBean> retrieveDetails() throws SQLException {
	
		
	return dao.retrieveDetails();
	}

}
