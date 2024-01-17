<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<h1>Inventory Management System</h1>
<hr />
</head>
<body>
	<a  href="loginPurchase.html">Purchase Entry</a>&emsp;
   <a  href="purchaseDateWise.html">Purchase Report - Date Wise</a>&emsp;
    <a  href="loadPurchaseReport.html">Vendor-Purchased Item Report</a>&emsp;
     <a  href="login.html">Logout</a>
   
  <hr/>
	

		<h2>Vendor-Purchase Item Report</h2>
		<f:form action="${pageContext.request.contextPath}/FetchRecordsWithVendorName.html"
			modelAttribute="beanObj" method="POST">
			<table border="2">
				<tr>
					<td><label>Vendor Name</label></td>
					<td><f:select path="vendorName" required>
							<f:option label="--Select--" value="" />
							<f:options items="${listVendor}" itemValue="vendorId"
								itemLabel="vendorName" />
						</f:select><%--  <font color="red"><f:errors path="materialTypeId" /></font></td> --%>
				</tr>
			</table>
			<br>
			<input type="submit" value="Search">
			<br>
			<br>
			<br>
			<c:if test="${not empty listALL}">

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

					<c:forEach items="${listALL}" var="itr">
						<tr>
							<td><c:out value="${itr.materialCategoryName}" /></td>
							<td><c:out value="${itr.materialTypeName}" /></td>
							<td><c:out value="${itr.brandName}" /></td>
							<td><c:out value="${itr.quantity}" /></td>
							<td><c:out value="${itr.unitId}" /></td>
							<td><fmt:formatNumber value="${itr.purchaseAmount}"
									type="currency" currencySymbol="INR."></fmt:formatNumber></td>
							<td><c:out value="${itr.vendorName}" /></td>
						</tr>
					</c:forEach>

				</table>

			</c:if>


		</f:form>
<font style="color: red">${message}</font><br><br><br>
	<hr />
	<div>
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2018 Accenture All Rights Reserved.</p>
	</div>
	<hr />
</body>
</html>