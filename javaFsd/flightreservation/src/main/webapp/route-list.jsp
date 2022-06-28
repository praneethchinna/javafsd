<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Route Management</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
 <center>
  <h1>Route Management</h1>
        <h2>
         <a href="RouteCurd?msg=new">Add New Route</a>
         &nbsp;&nbsp;&nbsp;
         <a href="RouteCurd?msg=list">List All Route</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Route</h2></caption>
            <tr>
                <th>ID</th>
                <th>Source</th>
                <th>Destination</th>
                
                <th>Actions</th>
            </tr>
            <c:forEach var="route" items="${route}">
                <tr>
                    <td><c:out value="${route.id}" /></td>
                    <td><c:out value="${route.source}" /></td>
                    <td><c:out value="${route.destination}" /></td>
                 
                    <td>
                     <a href="RouteCurd?msg=edit&id=<c:out value='${route.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="RouteCurd?msg=delete&id=<c:out value='${route.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>