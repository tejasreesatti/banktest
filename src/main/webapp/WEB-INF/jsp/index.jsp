<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>

</head>
<body background="/resources/images/bck3.jpg">

<%@ include file="header.jsp" %>  


<br><br><br><br>
 <c:if test="${sessionScope.customer.customerId==null}">
	      	<center><h1>Welcome to our bank application!!!</h1></center>
	      </c:if>
	      
	       <c:if test="${sessionScope==invalidate}">
	      	<center><h1>Thankyou for using our bank application!! See you soon</h1></center>
	      </c:if>
	      

	
<center><img  src="images/image5.jpg"></center>
</body>
</html>