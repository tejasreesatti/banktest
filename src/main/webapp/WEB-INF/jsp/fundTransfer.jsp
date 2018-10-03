<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<form action="fundTransfer.do" method="post">
		<br><br><br>
		<center><label>Payee Account number:</label></center>
		<center><input type="number" name="payeeAccountNumber" size=15 required></center>
		<br><br>
		<center><label>Amount:</label></center>
		<center><input type="number" name="amount" size=15 required></center>
		<br><br>
		<center><input type="submit" value="Pay"></center>
	</form>
</body>
</html>