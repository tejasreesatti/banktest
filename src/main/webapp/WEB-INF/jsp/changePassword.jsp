<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<form action="changePassword.do" method="post">
	<br><br>
	<center><label>Old Password</label></center>
	<center><input type="password" size=20 name="oldPassword"></center>
	
	<br><br>
	<center><label>New Password</label></center>
	<center><input type="password" size=20 name="newPassword" ></center>
	
	<br><br>
	<center><label>confirm new Password</label></center>
	<center><input type="password" size=20 name="confirmNewPassword"></center>
	
	
	<center><input type="submit" value="GO"></center>
	</form>

</body>
</html>