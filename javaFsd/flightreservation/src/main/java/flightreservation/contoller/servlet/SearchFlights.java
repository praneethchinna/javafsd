package flightreservation.contoller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightreservation.entity.Flights;
import flightreservation.entity.UserDetails;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class SearchFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private ServiceLayer serviceLayer;
    public SearchFlights() {
    	serviceLayer=new ServiceLayerImpl();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String from=request.getParameter("from");
			String to=request.getParameter("to");
			String date=request.getParameter("date");
			int travellers=Integer.parseInt(request.getParameter("travellers"));
			
			
			
			UserDetails.setDate(date);
			UserDetails.setTravellers(travellers);
			System.out.println(UserDetails.getTravellers());
			
			List<Flights> flights=serviceLayer.getFlightsByRoute( from, to);
			for (Flights flights2 : flights) {
				System.out.println(flights2.getId());
			}
			
			if(flights!=null)
			{
				request.setAttribute("availableflights", flights);
				RequestDispatcher dispatcher=request.getRequestDispatcher("flightdetails.jsp?msg="+travellers);
				dispatcher.forward(request,response);
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("searchflights.jsp?msg=unavailable");
				dispatcher.forward(request,response);
			}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
