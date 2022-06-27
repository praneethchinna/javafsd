package flightreservation.contoller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightreservation.entity.Flights;
import flightreservation.entity.TransactionDetails;
import flightreservation.entity.UserDetails;
import flightreservation.entity.Users;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class TransactionDetailsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayer; 
   
    public TransactionDetailsInfo() {
    	serviceLayer=new ServiceLayerImpl();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flightid=Integer.parseInt(request.getParameter("flightid"));
		int userid=Integer.parseInt(request.getParameter("userid"));
		
		double totalFare=Double.parseDouble(request.getParameter("totalfare"));
		
		int seatsbooked=UserDetails.getTravellers();
		String date=UserDetails.getDate();
		Flights flight=serviceLayer.getFlightsById(flightid);
		Users users=serviceLayer.getUserById(userid);
		System.out.println(date+" "+seatsbooked+" "+userid);
		int isCreated=serviceLayer.createTransaction(flight, users, seatsbooked, totalFare, date);
		if(isCreated!=0)
		{
			TransactionDetails transaction=serviceLayer.getDetasilsById(userid);
			request.setAttribute("transaction", transaction);
			RequestDispatcher dispatcher=request.getRequestDispatcher("transactiondetails.jsp");
			dispatcher.forward(request,response);
		}
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
