<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: center;">
<form action="AdminLogin" method="post">

Username:<input type="text" placeholder="Enter Username" name="uname" required><br><br>
Password:<input type="password" placeholder="Enter Password" name="pass" required><br><br>
<button type="submit">Login</button>
</form>

<% String isvalid=request.getParameter("msg");
if(isvalid!=null)
{%>
	
	<h1>invalid username or password try again!</h1>
	
	<%}

%>
</div>


</body>
</html>