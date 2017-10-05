package com.cg.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.bank.bean.CustomerBean;
import com.cg.bank.dbutil.DbUtil;


public class CustomerDaoImpl implements ICustomerDao{
	
	Connection conn= null;

	@Override
	public int addCustomer(CustomerBean bean) {
		{
			
		
			int row=0;
			try
			{
				conn = DbUtil.getConnection();
				System.out.println(conn);
				
				PreparedStatement ps=conn.prepareStatement("INSERT INTO CustomerDetails VALUES(cid_seq.nextval,?,?,?,?)");
				
				
				ps.setString(1, bean.getCustomerName());
				ps.setString(2, bean.getPhoneNo());
				ps.setString(3, bean.getPassword());
				ps.setString(4, bean.getRe_password());
				
				row = ps.executeUpdate();
			}
			catch(SQLException e)
			{
				
			}
		
		return row;
	}

}

	@Override
	public ArrayList<CustomerBean> retrieveDetails()  {
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		try{
		conn = DbUtil.getConnection();
		String sql = "Select * from CustomerDetails";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		
		while(rs.next())
		{
			String name = rs.getString(2);
			String phone = rs.getString(3);
			String password = rs.getString(4);
			String rePassword = rs.getString(5);
			
			list.add(new CustomerBean(name,phone,password,rePassword));
			
		}}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return list;
	}
}