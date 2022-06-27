package flightreservation.contoller.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flightreservation.entity.AirLines;
import flightreservation.entity.Flights;
import flightreservation.entity.Route;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class FlightCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayer;   
   
    public FlightCrud() {
    	serviceLayer=new ServiceLayerImpl();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String msg = request.getParameter("msg");
if(msg!=null) {
	        try {
	            switch (msg) {
	                case "new":
	                	createNewFlight(request, response);
	                    break;
	                case "insert":
	                	insertFlight(request, response);
	                    break;
	                case "delete":
	                    deleteFlight(request, response);
	                    break;
	                case "edit":
	                	showEditFlight(request, response);
	                    break;
	                case "update":
	                	updateFlight(request, response);
	                    break;
	                default:
	                	listFlights(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	}

	private void listFlights(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		System.out.println("list");
		        List < Flights > listfllights = serviceLayer.getAllFlights();
		       
		        request.setAttribute("listfllights", listfllights);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-list.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void createNewFlight(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	System.out.println("hi");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditFlight(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Flights existingFlights= serviceLayer.getFlightsById(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
		        request.setAttribute("existingFlights", existingFlights);
		        dispatcher.forward(request, response);

		    }

		    private void insertFlight(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	
		        int airlineid =Integer.parseInt( request.getParameter("airlineid"));
		        int routeid = Integer.parseInt(request.getParameter("routeid"));
		        double price=Double.parseDouble(request.getParameter("price"));
		       
		        AirLines airlines=serviceLayer.getAirLinesById(airlineid);
		        Route route=serviceLayer.getRouteById(routeid);
		        
		        boolean iscreated=serviceLayer.registerFlight(airlines, route, price);
		        System.out.println(iscreated);
		        response.sendRedirect("FlightCrud?msg=list");
		    }

		    private void updateFlight(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	int id=Integer.parseInt(request.getParameter("id"));
		    	int airlineid =Integer.parseInt( request.getParameter("airlineid"));
		        int routeid = Integer.parseInt(request.getParameter("routeid"));
		        double price=Double.parseDouble(request.getParameter("price"));
		       
		        AirLines airlines=serviceLayer.getAirLinesById(airlineid);
		        Route route=serviceLayer.getRouteById(routeid);

		        Flights flights=new Flights(id,airlines,route,price);
		       serviceLayer.updateFlightsById(flights);
		        response.sendRedirect("FlightCrud?msg=list");
		    }

		    private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        serviceLayer.deleteFlightsById(id);
		        response.sendRedirect("FlightCrud?msg=list");
		    }
		
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
