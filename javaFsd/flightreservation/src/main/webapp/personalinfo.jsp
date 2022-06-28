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
<% 
Flights flights=(Flights)request.getAttribute("flights");
if(flights!=null){

	AirLines airlines=flights.getAirline_id();
	Route route=flights.getRoute_id();
	%>
	
	<h1>Thanks for choosing: <u><%= airlines.getAirline() %> &nbsp Airlines</u></h1>
	<br>
	<hr>
	<%}%>
	<div style="text-align: center; ">
	<form action="PersonalInfo?id=<%= flights.getId() %>" method="post">
	Full Name:<input type="text" name="fullname" size="30" required><br><br>
	Age      :<input type="text" name="age"  max="100" required><br><br>
	Gender   :<input type="radio" id="html" name="gender" value="male" >&nbsp male &nbsp
	 &nbsp<input type="radio" id="html" name="gender" value="female">&nbsp female <br><br>
	Address  :<input type="text" name="address" size="30" required><br><br>
	Phone No :<input type="text" name="phnumber" size="30" required><br><br>
	email    :<input type="email" name="email" placeholder="your@email.com" size="30" required><br><br>
	<input type="submit" value="Submit"><br>
	

</form>
</div>
</body>
</html>