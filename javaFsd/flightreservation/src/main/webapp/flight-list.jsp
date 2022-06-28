<%@page import="java.util.List"%>

<%@page import="flightreservation.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Flights</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
 <center>
  <h1>List of Flights</h1>
        <h2>
         <a href="FlightCrud?msg=new">Add New Flights</a>
         &nbsp;&nbsp;&nbsp;
         <a href="FlightCrud?msg=list">List of Flights</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2> Air Lines List</h2></caption>
            <tr>
               <th>ID</th>
                <th>Airways</th>
                <th>available seats</th>
                <th>From</th>
                <th>To</th>
                <th>Price</th>
                <th>Actions</th>
                
            </tr>
            
             <% List<Flights> flightslist=(List<Flights>)request.getAttribute("listfllights"); 
            if(flightslist!=null)
            {
            	for(Flights flights:flightslist)
            	{%>
            		<% AirLines airlines=flights.getAirline_id();   %>
            		<% Route route=flights.getRoute_id();       %>
            		
            		
            		<tr>
            		<td><%= flights.getId() %></td>
            		<td><%= airlines.getAirline() %></td>
            		<td><%= airlines.getSeats() %></td>
            		<td><%= route.getSource() %></td>
            		<td><%= route.getDestination() %></td>
            		<td><%= flights.getPrice() %></td>
            		
            		<td><button><a href="FlightCrud?msg=edit&id=<%= flights.getId() %>">edit</a></button>
            		&nbsp;&nbsp;&nbsp;&nbsp;
            		<button><a href="FlightCrud?msg=delete&id=<%= flights.getId() %>">delete</a></button>
            		</td>
            		
            		</tr>
            		
            	<%}%>
            	
        <%   }%>
        </table>
    </div> 
</body>
</html>