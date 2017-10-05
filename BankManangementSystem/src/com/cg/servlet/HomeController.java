package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bank.bean.CustomerBean;
import com.cg.bank.service.CustomerServiceImpl;
import com.cg.bank.service.ICustomerService;



@WebServlet("*.obj")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		CustomerBean bean = new CustomerBean();
		ICustomerService service = new CustomerServiceImpl();
		String target = null;;
		String path = request.getServletPath();
      
		PrintWriter out = response.getWriter();
		switch(path)
		{
		
		case "/Customer.obj":
			
			target = "NewCustomer.html";
			RequestDispatcher rhome = request.getRequestDispatcher(target);
			rhome.forward(request,response);
			
			
		break;
			
			
		case "/addCustomer.obj":
		
			String cName = request.getParameter("custName");
			String phone = request.getParameter("phone");
			String pass = request.getParameter("pwd");
			String repass = request.getParameter("rePwd");
			
			if(pass.equals(repass))
			{
				
			bean.setCustomerName(cName);
			bean.setPhoneNo(phone);
			bean.setPassword(pass);
			bean.setRe_password(repass);
			
			int res = service.addCustomer(bean);
			if(res==1)
			{
			  target = "success.html";
			
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request,response);
				
	
			}
			else
			{
				target = "error.html";
			
				RequestDispatcher rd1 = request.getRequestDispatcher(target);
				rd1.forward(request,response);
				
			}
			}
		else
			{
				
				target="NewCustomer.html";
				RequestDispatcher rd2 = request.getRequestDispatcher(target);
				rd2.include(request, response);
				out.println("Sorry Your Password doesn't Matches!!!!!!!!!!!!!");
				
			}
			break;
		case "/retrieveDetails.obj":
			
			
			ArrayList<CustomerBean> list= new ArrayList<CustomerBean>();
		
		
			try {
				list= service.retrieveDetails();
			
				for(CustomerBean o:list)
				{
					System.out.println("in for each loop");
					out.println(o);
					
				}
				target = "displayDetails.html";
				
				RequestDispatcher rd3 = request.getRequestDispatcher(target);
				rd3.include(request,response);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
	
			
		}
		
	
	}

	


}
