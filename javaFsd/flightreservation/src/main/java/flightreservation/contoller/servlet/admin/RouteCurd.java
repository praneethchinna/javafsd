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
import flightreservation.entity.Route;
import flightreservation.service.ServiceLayer;
import flightreservation.service.ServiceLayerImpl;


public class RouteCurd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer serviceLayer;  
   
    public RouteCurd() {
    	serviceLayer=new ServiceLayerImpl();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		
		if(msg!=null) {
	        try {
	            switch (msg) {
	                case "new":
	                	createNewRoute(request, response);
	                    break;
	                case "insert":
	                	insertRoute(request, response);
	                    break;
	                case "delete":
	                    deleteRoute(request, response);
	                    break;
	                case "edit":
	                	showEditRoute(request, response);
	                    break;
	                case "update":
	                	updateRoute(request, response);
	                    break;
	                default:
	                	listRoute(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	}

	
	private void listRoute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("list route");
		List<Route> route=serviceLayer.getAllRoute();
		request.setAttribute("route", route);
		RequestDispatcher dispatcher=request.getRequestDispatcher("route-list.jsp");
		
			dispatcher.forward(request, response);
		
		
	}


	private void updateRoute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	int id=Integer.parseInt(request.getParameter("id"));
    	String source = request.getParameter("source");
    	String destination = request.getParameter("destination");

    	Route route=new Route(id,source,destination);
       serviceLayer.updateRoute(route);
        response.sendRedirect("RouteCurd?msg=list");
		
	}


	private void showEditRoute(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Route existingroute = serviceLayer.getRouteById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("route-form.jsp");
        request.setAttribute("existingroute", existingroute);
        dispatcher.forward(request, response);
		
	}


	private void deleteRoute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceLayer.deleteRouteById(id);
        response.sendRedirect("RouteCurd?msg=list");
		
	}


	private void insertRoute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
       
        Route route=new Route(source,destination);
        boolean iscreated=serviceLayer.createRoute(route);
        System.out.println(iscreated);
        response.sendRedirect("RouteCurd?msg=list");
		
	}


	private void createNewRoute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	System.out.println("hi");
        RequestDispatcher dispatcher = request.getRequestDispatcher("route-form.jsp");
        dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
