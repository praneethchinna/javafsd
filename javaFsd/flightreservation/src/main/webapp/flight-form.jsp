
<%@page import="java.util.List"%>

<%@page import="flightreservation.entity.*"%>
<%@page import="flightreservation.service.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
<%! ServiceLayer service=new ServiceLayerImpl();
List<AirLines> airlines=service.getAllAirLines();
List<Route> route=service.getAllRoute();


%>
 <center>
  <h1>List of Flights</h1>
         <h2>
         <a href="FlightCrud?msg=new">Add New Flights</a>
         &nbsp;&nbsp;&nbsp;
         <a href="FlightCrud?msg=list">List of Flights</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${existingFlights != null}">
   <form action="FlightCrud?msg=update" method="post">
        </c:if>
        <c:if test="${existingFlights == null}">
   <form action="FlightCrud?msg=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${existingFlights != null}">
               Edit Flights
              </c:if>
              <c:if test="${existingFlights == null}">
               Add New Flights
              </c:if>
             </h2>
            </caption>
          <c:if test="${existingFlights != null}">
           <input type="hidden" name="id" value="<c:out value='${existingFlights.id}'/>" />
          </c:if>            
            <tr>
                <th>Flights Name: </th>
               <td><select name="airlineid"  >
               
              
               <%
               Flights flight=(Flights)request.getAttribute("existingFlights");
               if(flight!=null){
               AirLines airline=flight.getAirline_id();
               
               %>
               <option value="<%=airline.getId()%>" selected="selected"> <%=airline.getAirline() %></option>
              <% }%>
            		<%for(AirLines airlines1:airlines)
            			
            		{%>
            			<option value="<%=airlines1.getId()%>"><%=airlines1.getAirline() %></option>
            		<%}%>
            		
            		</select>
            		</td>
            </tr>
            <tr>
                <th>Route  </th>
                <td>
                <select name="routeid"  >
                <%
               Flights flight1=(Flights)request.getAttribute("existingFlights");
               if(flight1!=null){
              Route route1=flight1.getRoute_id();
               
               %>
                
                 <option value="<%=route1.getId()%>" selected="selected">From: <%=route1.getSource()  %> &nbsp; TO: <%=route1.getDestination()  %> </option>
                <% }%>
                
                <%for(Route route2:route)
            			
            		{%>
            		 <option value="<%=route2.getId()%>">From: <%=route2.getSource()  %> &nbsp; TO: <%=route2.getDestination()  %> </option>
            		<%}%>
                
                </select>
                </td>
            </tr>
             <tr>
                <th>Price: </th>
                <td>
                 <input type="number" name="price" 
                   value="<c:out value='${existingFlights.price}' />"
                 />
                </td>
            </tr>
            
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Save" />
             </td>
            </tr>
        </table>
        </form>
    </div> 

</body>
</html>