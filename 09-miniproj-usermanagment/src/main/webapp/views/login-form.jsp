<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="jquery-3.5.1.min.js"></script>



<style>



</style>


</head>
<body>

	<h2>Login</h2>

	<form:form action="LoginPost" modelAttribute="user" method="post"
		>

		<font color='red'><span id="errId"></span></font>

		<table>
			<tr>
				<td>Your Email :</td>
				<td><form:input path="email"  id="username"/>
			
			
				
				</td>
			</tr>
			<tr>
				<td>Enter Password :</td>
				<td><form:password path="password" id="pass"/>
				
				
				
				

				
				
				
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" id ="login_btn" value="Login"
					 />
					
					 
					 </td>
			</tr>
		</table>
	</form:form>
	
		<div class="errorLogin" style="display:none">Please Inter your email</div>
		
		
				<div class="errorLogin" style="display:none">Please Inter your email</div>
				
</body>
</html>











