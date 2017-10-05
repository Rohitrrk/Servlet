package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cg.bean.CustomerBean;
import com.cg.dbutil.DbUtil;

public class CustomerDaoImpl implements ICustomerDao
{
	public int addDetails(CustomerBean bean)
	{
		
		Connection conn= null;
		int row=0;
		try
		{
			conn = DbUtil.getConnection();
			System.out.println(conn);
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO Billdetails VALUES(?,?,?,?)");
			
			ps.setInt(1, bean.getConsumerNo());
			ps.setString(2, bean.getCustomerName());
			ps.setString(3, bean.getEmail());
			ps.setString(4, bean.getPhoneNo());
			//ps.setInt(5, bean.getPayAmount());
			
			
			row  = ps.executeUpdate();
		}
		catch(Exception e)
		{
			
			
		}
		return row;
		
	}

}
