<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
<div style="text-align: center;">
<% String name=request.getParameter("msg");
if(name!=null)
{%>
	
	<h1>welcome back <%= name%></h1>
		<%}
%><br><br>

<ol>
  <li><h3><a href="AirLinesCrud?msg=list">List Of AirLines</a></h3></li>
  <li><h3><a href="RouteCurd?msg=list">List Of Route</a></h3></li>
  <li><h3><a href="FlightCrud?msg=list">List Of Flights</a></h3></li>
  
</ol>



</div>

</body>
</html>