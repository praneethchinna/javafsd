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
<div style="text-align: center;">

<h1>Search Flights Here</h1>
<form action="SearchFlights" method="post">
From :<input type="text" name="from" required /><br/><br/>
TO : <input  type="text" name="to" required /><br/><br/>
Select Date :<input type="date" name="date" value="2022-06-23" required><br/><br/>
Travelers :<input type="number" name="travellers" step="1" value="1" max="5" required><br/><br/>
<input type="submit" value="Register">

</form>

<% String isavailable=(String)request.getAttribute("msg");
if(isavailable!=null)
{%>
	<h1> Not Available</h1>
	<%}
%>
</div>
</body>
</html>

