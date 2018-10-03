<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
            <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
                <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit profile</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<form:form action="editProfile.do" method="post" modelAttribute="customer">
	
		<center><form:label path="email">Customer email:</form:label></center>
		<center><form:input path="email"></form:input></center>
		<br>
			
	
		<center><form:label path="Address">Customer Address:</form:label></center>
		<center><form:input path="Address"></form:input></center>
		<br>
			
	
		<center><form:label path="dateOfBirth">DOB:</form:label></center>
		<center><form:input path="dateOfBirth" readonly="true"></form:input></center>
		<br>
			
	
		<center><form:label path="customerName">Customer name:</form:label></center>
		<center><form:input path="customerName" readonly="true"></form:input></center>
		<br>
		<center><form:label path="customerId">Customer id:</form:label></center>
		<center><form:input path="customerId" readonly="true"></form:input></center>
		<br>
		
				<center><input type="submit" value="submit"></center>
		
	</form:form>
</body>
</html>