<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Material Purchase Entry</title>
<script type="text/javascript">
	function getUnitAndTypeList() {

		document.forms["form1"].action = "getUnitAndTypeList.html";

		document.forms["form1"].method = "GET";

		document.forms["form1"].submit();
	}
</script>
<style>
.error {
	color: #ff0000;
	font-style: bold;
}
</style>
</head>
<body>
	<a href="loginPurchase.html">Purchase Entry</a>&emsp;
	<a href="purchaseDateWise.html">Purchase Report - Date Wise</a>&emsp;
	<a href=".html">Vendor-Purchased Item Report</a>&emsp;
	<a href="login.html">Logout</a>

	<hr />
	<center>
		<h2>purchase details</h2>
		<form:form modelAttribute="purchaseEntryObj" method="POST"
			action="${pageContext.request.contextPath}/savedetails.html"
			name="form1">

			<br>

			<table border="2">

				<tr>

					<th>Vendor Name</th>
					<td><form:select path="vendorName">
							<form:option label="--Select--" value="" />
							<form:options items="${vendorList}" itemValue="vendorId"
								itemLabel="vendorName" />
						</form:select></td>
					<td><form:errors path="vendorName" cssClass="error" /></td>
				</tr>

				<tr>
					<th>Material Category</th>
					<td><form:select path="materialCategoryId"
							onchange="getUnitAndTypeList()">
							<form:option label="--Select--" value="" />
							<form:options items="${materialCategory}" itemValue="categoryId"
								itemLabel="categoryName" />
						</form:select></td>
					<td><form:errors path="materialCategoryId" cssClass="error" /></td>
				</tr>
				<tr>

					<th>Material Type</th>
					<td><form:select path="materialTypeId">
							<form:option label="--Select--" value="" />
							<form:options items="${materialType}" itemValue="typeId"
								itemLabel="typeName" />
						</form:select></td>
					<td><form:errors path="materialTypeId" cssClass="error" /></td>
				</tr>
				<tr>

					<th>Unit</th>
					<td><form:select path="unitId">
							<form:option label="--Select--" value="" />
							<form:options items="${unitType}" itemValue="unitId"
								itemLabel="unitName" />
						</form:select></td>
					<td><form:errors path="unitId" cssClass="error" /></td>
				</tr>


				<tr>
					<th>Brand Name</th>
					<td><form:input path="brandName" /></td>
					<td><form:errors path="brandName" cssClass="error" /></td>
				</tr>


				<tr>
					<th>Quantity</th>
					<td><form:input path="quantity" /></td>
					<td><form:errors path="quantity" cssClass="error" /></td>
				</tr>

				<tr>
					<th>Purchase Amount</th>
					<td><form:input path="purchaseAmount" /></td>
					<td><form:errors path="purchaseAmount" cssClass="error" /></td>
				</tr>

				<tr>
					<th>Purchase Date</th>
					<td><form:input path="purchaseDate" placeholder="dd-MMM-yyyy" /></td>
					<td><form:errors path="purchaseDate" cssClass="error" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Add Purchase Entry" />
			<br />
			<br />

			<spring:hasBindErrors name="purchaseEntryObj">
				<h3>All Errors</h3>
				<form:errors path="*" cssClass="error" />
			</spring:hasBindErrors>
		</form:form>

		<font style="color: red">${message}</font><br>
		<br>
		<br>
		<div>
			<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
				© 2018 Accenture All Rights Reserved.</p>
		</div>
	</center>
</body>
</html>