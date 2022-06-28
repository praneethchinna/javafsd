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

<% TransactionDetails transaction=(TransactionDetails)request.getAttribute("transaction");

Flights flights=transaction.getFlight_d();
AirLines airlines=flights.getAirline_id();
Route route=flights.getRoute_id();
Users users=transaction.getUser_id();

%>
<div style="text-align: center; ">
<h2>Airways:<%=airlines.getAirline() %></h2> <br><br>
<h2>From &nbsp : <%=route.getSource() %>&nbsp TO &nbsp :<%=route.getDestination() %></h2><br><br>
<h2>Full Name: <%=users.getFull_name() %></h2><br><br>
<h2> Total Travellers: <%=transaction.getSeats() %></h2><br><br>
<h2>  Date Of Journey: <%= transaction.getDate_of_journey() %></h2><br><br>
<h2>Total Fare : <%=transaction.getTotal_price() %></h2><br><br>
<h1> payment Successfull Happy Journey</h1>

</div>
</body>
</html>