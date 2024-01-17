<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<h1>Inventory Management System</h1>
<hr />
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>

<body>
	<a href="loginPurchase.html">Purchase Entry</a>&emsp;
	<a href="purchaseDateWise.html">Purchase Report - Date Wise</a>&emsp;
	<a href="loadPurchaseReport.html">Vendor-Purchased Item Report</a>&emsp;
	<a href="login.html">Logout</a>

	<hr />

	<h2 align="center">Material Purchase Entry</h2>

	<f:form modelAttribute="dateObj"
		action="${pageContext.request.contextPath}/ReportDateWise.html"
		method="POST">
		<center>
			<h2>Purchase Report-DateWise</h2>
			<table border="2">
				<tr>
					<td>From Date:<f:input path="fromDate" /></td>
					<td><f:errors path="fromDate"  cssClass="error"/></td>
					<td>To Date:<f:input path="toDate" /></td>
					<td><f:errors path="toDate"  cssClass="error"/></td>
				</tr>
			</table>
			<br> <input type="submit" value="Search"> <br> <br>
			<br>
			<c:if test="${not empty List}">
				<table border="2">
					<tr>
						<th>Material Category</th>
						<th>Material Type</th>
						<th>Brand</th>
						<th>Quantity</th>
						<th>Unit</th>
						<th>Price</th>
						<th>Vendor</th>
					</tr>

					<c:forEach items="${List}" var="itr">
						<tr>
							<td><c:out value="${itr.materialCategoryName}" /></td>
							<td><c:out value="${itr.materialTypeName}" /></td>
							<td><c:out value="${itr.brandName}" /></td>
							<td><c:out value="${itr.quantity}" /></td>
							<td><c:out value="${itr.unitName}" /></td>
							<td><fmt:formatNumber value="${itr.purchaseAmount}"
									type="currency" currencySymbol="INR."></fmt:formatNumber></td>
							<td><c:out value="${itr.vendorName}" /></td>
						</tr>
					</c:forEach>

				</table>

			</c:if>
		</center>

		<spring:hasBindErrors name="dateObj">
			<h3>All Errors</h3>
			<f:errors path="*" cssClass="error" />
		</spring:hasBindErrors>
	</f:form>
	<font style="color: red">${message}</font>
	<br>
	<br>
	<br>
	<hr />
	<div>
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2018 Accenture All Rights Reserved.</p>
	</div>
	<hr />
</body>
</html>