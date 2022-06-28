
<%@page import="java.util.List"%>

<%@page import="flightreservation.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="userhome.jsp" />
<h1>Available Flight Details</h1> <br>
<hr>
<table border="1" cellpadding="5" style="text-align: center; ">
            <caption><h2>List of Flights</h2></caption>
            <tr>
                <th>ID</th>
                <th>Airways</th>
                <th>available seats</th>
                <th>From</th>
                <th>To</th>
                <th>Price</th>
                <th>Actions</th>
            
            </tr>
            <%! UserDetails userDetails=new UserDetails(); %>
            <% List<Flights> flightslist=(List<Flights>)request.getAttribute("availableflights"); 
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
            		<td><%= flights.getPrice() %>x<%=request.getParameter("msg")  %></td>
            		<td><button><a href="PersonalInfo?msg=<%= flights.getId() %>">book</a></button></td>
            		
            		</tr>
            		
            	<%}%>
            	
        <%   }%>
            
            
           
            
           
        </table>

</body>
</html>