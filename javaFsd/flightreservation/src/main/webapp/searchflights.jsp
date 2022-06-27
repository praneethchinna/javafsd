<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="makemecenter">

<h1>Search Flights Here</h1>
<form action="SearchFlights" method="post">
From :<input type="text" name="from" required /><br/>
TO : <input  type="text" name="to" required /><br/>
Select Date :<input type="date" name="date" value="2022-06-23" required>
Travelers :<input type="number" name="travellers" step="1" value="1" max="5" required>
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

