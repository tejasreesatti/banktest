<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Failed Transfer</title>
</head>
<body>
	<%@ include file="header.jsp" %>  
	<br><br><br>
	<center><h1 style="color: red;">OOPS! Transfer Failed!!Please try after sometime!!!
	</h1></center>
	<p>${requestScope.fundTransferFail}</p>
	
	<center><img  src="images/oops.jpg"></center>
</body>
</html>