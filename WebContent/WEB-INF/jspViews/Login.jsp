<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inventory Management System</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<h1>Inventory Management System</h1>
	<hr>
	<h2>Login</h2>
	<hr>


	<form:form modelAttribute="loginObj" method="POST"
		action="${pageContext.request.contextPath}/save.html">
		<br>
		<table border="2">
			<tr>
				<th>UserName</th>
				<td><form:input path="username" /></td>
				<td><form:errors path="username"  cssClass="error"/></td>
			</tr>

			<tr>
				<th>Password</th>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password"  cssClass="error"/></td>
			</tr>
		</table>
		<br />
		<input type="submit" value="submit" />
		<br />
		
		<spring:hasBindErrors name="loginObj">
			<h3>All Errors</h3>
			<form:errors path="*"  cssClass="error"/>
	   </spring:hasBindErrors>
	   
	</form:form>
	
	<font style="color: red">${message}</font><br><br><br>
	<hr>
	<div>
		<p align="Right" style="font-family: calibri; color: #6666CC;">Copyright
			© 2018 Accenture All Rights Reserved.</p>
	</div>
</body>
</html>