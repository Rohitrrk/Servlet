package com.cg.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbUtil {
	
	static Connection  con= null;
	public static Connection getConnection()
	{
	
		try 
		{
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/jdbc/OracleDS");
			con = ds.getConnection();
			
			System.out.println(con);
			
	
		}
		catch (NamingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		 catch (SQLException e)
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return con;
	
	
		
	}
	
}
