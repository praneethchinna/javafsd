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
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class AirLinesCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayer;  
   
    public AirLinesCrud() {
    	serviceLayer=new ServiceLayerImpl();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 String msg = request.getParameter("msg");
if(msg!=null) {
	        try {
	            switch (msg) {
	                case "new":
	                	createNewAirLine(request, response);
	                    break;
	                case "insert":
	                	insertAirLine(request, response);
	                    break;
	                case "delete":
	                    deleteUser(request, response);
	                    break;
	                case "edit":
	                	showEditAirLine(request, response);
	                    break;
	                case "update":
	                	updateAirLine(request, response);
	                    break;
	                default:
	                	listAirLines(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	}
	private void listAirLines(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		System.out.println("list");
		        List < AirLines > listAirLines = serviceLayer.getAllAirLines();
		       
		        request.setAttribute("listAirLines", listAirLines);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("airlines-list.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void createNewAirLine(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    	System.out.println("hi");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("airline-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditAirLine(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        AirLines existingAirLine = serviceLayer.getAirLinesById(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("airline-form.jsp");
		        request.setAttribute("existingAirLine", existingAirLine);
		        dispatcher.forward(request, response);

		    }

		    private void insertAirLine(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	
		        String airlineName = request.getParameter("airlinename");
		        int seats = Integer.parseInt(request.getParameter("seats"));
		       
		        AirLines airline = new AirLines(airlineName,seats);
		        boolean iscreated=serviceLayer.createAirline(airline);
		        System.out.println(iscreated);
		        response.sendRedirect("AirLinesCrud?msg=list");
		    }

		    private void updateAirLine(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	int id=Integer.parseInt(request.getParameter("id"));
		    	String airlineName = request.getParameter("airlinename");
		        int seats = Integer.parseInt(request.getParameter("seats"));;

		        AirLines airline = new AirLines(id,airlineName,seats);
		       serviceLayer.updateAirlineById(airline);
		        response.sendRedirect("AirLinesCrud?msg=list");
		    }

		    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        serviceLayer.deleteAirlineById(id);
		        response.sendRedirect("AirLinesCrud?msg=list");
		    }
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
