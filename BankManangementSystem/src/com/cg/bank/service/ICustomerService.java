package com.cg.bank.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bank.bean.CustomerBean;

public interface ICustomerService {

	public int addCustomer(CustomerBean bean);
	
	public ArrayList<CustomerBean >retrieveDetails() throws SQLException;
}
