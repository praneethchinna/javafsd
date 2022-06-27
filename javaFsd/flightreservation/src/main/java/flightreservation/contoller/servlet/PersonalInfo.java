package flightreservation.contoller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightreservation.entity.Flights;
import flightreservation.entity.Users;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class PersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ServiceLayer serviceLayer;
    
    public PersonalInfo() {
    	serviceLayer=new ServiceLayerImpl();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if((String)request.getParameter("msg")!=null) {
		int id=Integer.parseInt(request.getParameter("msg"));
		
		System.out.println(id);
		Flights flights= serviceLayer.getFlightsById(id);
		System.out.println("ann namste ne "+flights.getId());
		
		request.setAttribute("flights", flights);
		RequestDispatcher dispatcher=request.getRequestDispatcher("personalinfo.jsp");
		dispatcher.forward(request,response);
		}
		else {
		int id2=Integer.parseInt(request.getParameter("id"));
		String fullName=request.getParameter("fullname");
		String age=request.getParameter("age");
		String gender =request.getParameter("gender");
		String address=request.getParameter("address");
		String phnumber=request.getParameter("phnumber");
		String email=request.getParameter("email");
		
		Users users=new Users(fullName,email,phnumber,address,Integer.parseInt(age),gender);
		
		Flights flights=serviceLayer.getFlightsById(id2);
		boolean isCreated=serviceLayer.createUser(users);
		if(isCreated)
		{
			int id1=serviceLayer.getUserdIdFromName(fullName);
			RequestDispatcher dispatcher1=request.getRequestDispatcher("PaymentDetails?flightid="+flights.getId()+"&userid="+id1);
			dispatcher1.forward(request,response);
		}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
