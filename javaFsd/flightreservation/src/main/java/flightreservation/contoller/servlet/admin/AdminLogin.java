package flightreservation.contoller.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightreservation.entity.Admin;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayer;  
    
    public AdminLogin() {
    	serviceLayer=new ServiceLayerImpl();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		
		Admin admin=new Admin(username,password);
		boolean isValid=serviceLayer.isValid(admin);
		if(isValid)
		{
			System.out.println(username+" "+password);
			RequestDispatcher dispatcher = request.getRequestDispatcher("flightmanagment.jsp?msg="+username);
	        dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminlogin.jsp?msg=invalid");
	        dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
