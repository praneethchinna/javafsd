
<%@page import="java.util.List"%>

<%@page import="flightreservation.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirLine Form</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
<%!int i=0; %>
 <center>
  <h1>AirLine Form</h1>
        <h2>
         <a href="AirLinesCrud?msg=new">Add New AirLine</a>
         &nbsp;&nbsp;&nbsp;
         <a href="AirLinesCrud?msg=list">List of Air Lines</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${existingAirLine != null}">
   <form action="AirLinesCrud?msg=update" method="post">
        </c:if>
        <c:if test="${existingAirLine == null}">
   <form action="AirLinesCrud?msg=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${existingAirLine != null}">
               Edit AirLine
              </c:if>
              <c:if test="${existingAirLine == null}">
               Add New AirLine
              </c:if>
             </h2>
            </caption>
          <c:if test="${existingAirLine != null}">
           <input type="hidden" name="id" value="<c:out value='${existingAirLine.id}' />" />
          </c:if>            
            <tr>
                <th>Airline Name: </th>
                <td>
                 <input type="text" name="airlinename" size="45"
                   value="<c:out value='${existingAirLine.airline	}' />"/>
                 
                </td>
            </tr>
            <tr>
                <th>Total Seats  </th>
                <td>
                 <input type="number" name="seats" 
                 <% AirLines airline=(AirLines)request.getAttribute("existingAirLine");
                 if(airline!=null)
                 {
                	 i=airline.getSeats();
                 }  
                 else
                 {
                	 i=0;
                 }
                %>
                   
                value="<%= i %>" />
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