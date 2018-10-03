<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer success</title>
</head>
<body>
	<%@ include file="header.jsp" %>  
	<center><h1>Success</h1></center>
	<br><br><br>
	<center><h2><i>updated balance ${sessionScope.customer.bankAccount.balance}</i></h2></center>
	<br>
	<center><img  src="images/image5.jpg"></center>
</body>
</html>