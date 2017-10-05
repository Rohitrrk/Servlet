package com.cg.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.CustomerBean;
import com.cg.service.CustomerServiceImpl;
import com.cg.service.ICustomerService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.obj")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBean bean = new CustomerBean();
		ICustomerService service = new CustomerServiceImpl();
		String target = null;;
		String path = request.getServletPath();
		
		switch(path)
		{
		
		case "/Customer.obj":
			
			String consumerNo = request.getParameter("consNo");
			int conNo= Integer.parseInt(consumerNo);
			String cName = request.getParameter("custName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			//String payAmount = request.getParameter("payAmt");	
			//int payAmt= Integer.parseInt(payAmount);
			
			bean.setConsumerNo(conNo);
			bean.setCustomerName(cName);
			bean.setEmail(email);
			bean.setPhoneNo(phone);
			//bean.setPayAmount(payAmt);
			
			int res = service.addDetails(bean);
			if(res == 1)
			{
				 target = "success.html";
			}
			else
			{
				target = "error.html";
			}
			
			
		break;
		
		}
	
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);
	}

	
}
