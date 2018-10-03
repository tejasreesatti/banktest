<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body >


	<%@ include file="header.jsp"%>

	<%-- 	<form action="login.do" method="post">
	
		<label>Customer Id: </label>
		<input type="text" size="15" name = "customerId" required>
		<br>
		
		<label>Password: </label>
		<input type="password" size="15" name = "password" required>
		<br>
	
	
			<input type="submit" value="Log In">
		
	
	</form> --%>
	<form:form action="login.do" method="post" modelAttribute="customer">
	
	<br><br><br>
		<center><form:label path="customerId">Customer Id:</form:label></center>
		<center><form:input path="customerId" required="required" /></center>
		<form:errors path="customerId" />

		<br>
		<br>
		<center><form:label path="password">Password</form:label></center>
		<center><form:input type="password" path="password" required="required" /></center>
		<form:errors path="password" />
		<br>
		<br>

		<center><input type="submit" value="log in" /></center>
	</form:form>
</body>
</html>