package com.cg.bank.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bank.bean.CustomerBean;

public interface ICustomerDao {

	public int addCustomer(CustomerBean bean);

	public ArrayList<CustomerBean> retrieveDetails() throws SQLException;

}
