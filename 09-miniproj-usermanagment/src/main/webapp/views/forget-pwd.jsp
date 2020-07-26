<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
</head>

<body>
<form:form action="#"   modelAttribute="email" method="post">

<table>

<tr>

    <th><h3>Enter  the Email</h3></th>
   
    <td>
        <form:input path="userEmail"/>
    
    
    </td>


</tr>


</table>
<input type="submit" value="Submit"/>







</form:form>



</body>
</html>