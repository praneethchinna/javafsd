package flightreservation.contoller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightreservation.entity.AirLines;
import flightreservation.entity.Flights;
import flightreservation.entity.Users;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class PaymentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayer; 
    
    public PaymentDetails() {
    	serviceLayer=new ServiceLayerImpl();
          
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flightid=Integer.parseInt((String) request.getParameter("flightid"));
		int userid=Integer.parseInt((String) request.getParameter("userid"));
		
		Flights flights=serviceLayer.getFlightsById(flightid);
		
		Users users=serviceLayer.getUserById(userid);
		String fullName=users.getFull_name();
		request.setAttribute("flights", flights);
		RequestDispatcher dispatcher=request.getRequestDispatcher("paymentgatway.jsp?fullname="+fullName+"&userid="+userid);
		dispatcher.forward(request,response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
