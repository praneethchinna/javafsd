
<%@page import="java.util.List"%>

<%@page import="flightreservation.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Air Lines</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
 <center>
  <h1>List of Air Lines</h1>
        <h2>
         <a href="AirLinesCrud?msg=new">Add New AirLine</a>
         &nbsp;&nbsp;&nbsp;
         <a href="AirLinesCrud?msg=list">List of Air Lines</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2> Air Lines List</h2></caption>
            <tr>
                <th>ID</th>
                <th>Air Line</th>
                <th>Total Seats</th> 
                 <th>Actions</th>
                
            </tr>
            
            <% List<AirLines> airlines=(List<AirLines>)request.getAttribute("listAirLines"); 
            if(airlines!=null)
            {
            	for(AirLines airlines1:airlines)
            	{%>
            		
            		
            		
            		<tr>
            		<td><%= airlines1.getId() %></td>
            		<td><%= airlines1.getAirline() %></td>
            		<td><%= airlines1.getSeats() %></td>
            		
            		<td><button><a href="AirLinesCrud?msg=edit&id=<%= airlines1.getId() %>">edit</a></button>
            		&nbsp;&nbsp;&nbsp;&nbsp;
            		<button><a href="AirLinesCrud?msg=delete&id=<%= airlines1.getId() %>">delete</a></button>
            		</td>
            		
            		</tr>
            		
            	<%}%>
            	
        <%   }%>
        </table>
    </div> 
</body>
</html>