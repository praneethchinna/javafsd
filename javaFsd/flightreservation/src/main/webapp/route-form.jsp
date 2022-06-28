<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Route Form</title>
</head>
<body>
<jsp:include page="adminhome.jsp" />
 <center>
  <h1>Route Form</h1>
        <h2>
       <a href="RouteCurd?msg=new">Add New Route</a>
         &nbsp;&nbsp;&nbsp;
         <a href="RouteCurd?msg=list">List All Route</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${existingroute != null}">
   <form action="RouteCurd?msg=update" method="post">
        </c:if>
        <c:if test="${existingroute == null}">
   <form action="RouteCurd?msg=insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${existingroute != null}">
               Edit Route
              </c:if>
              <c:if test="${existingroute == null}">
               Add New Route
              </c:if>
             </h2>
            </caption>
          <c:if test="${existingroute != null}">
           <input type="hidden" name="id" value="<c:out value='${existingroute.id}' />" />
          </c:if>            
            <tr>
                <th>Source: </th>
                <td>
                 <input type="text" name="source" size="45"
                   value="<c:out value='${existingroute.source}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Destination: </th>
                <td>
                 <input type="text" name="destination" size="45"
                   value="<c:out value='${existingroute.destination}' />"
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