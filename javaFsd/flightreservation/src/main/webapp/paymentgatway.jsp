
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

<% Flights flights=(Flights)request.getAttribute("flights"); 

AirLines airlines=flights.getAirline_id();
double price=flights.getPrice();
int travellers=UserDetails.getTravellers();
double temp =price*travellers;


%>

Airlines      :<%= airlines.getAirline() %><br>
Full Name     :<%=  (String)request.getParameter("fullname") %><br><br>

<div style="text-align: center; ">
<form action="TransactionDetailsInfo?flightid=<%= flights.getId()%>&userid=<%=request.getParameter("userid") %>" method="post">

Total Fare    :<input type="number"  name="totalfare" value="<%= temp %>" readonly><br><br>
Enter CVV     :<input type="number" name="cvv" maxlength="3" required><br><br>
Password	  :<input type="password" name="cvvpassword" required><br><br>
<input type="submit" value="Submit"><br>




</form>
</div>
</body>
</html>