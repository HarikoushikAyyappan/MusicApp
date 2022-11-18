
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#Table-box {
	width: 600px;
	padding: 20px;
	margin: 100px auto;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
	border: 1px solid #31708f;
}
.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
</head>
<body bgcolor="#AAE6FA">
<center>
<div id="Table-box">

<h1>Edit User</h1>

<c:url var="saveUrl" value="/editUserSave?id=${userAttribute.userId}" />
<form:form modelAttribute="userAttribute"  method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="userId">UserId:</form:label></td>
			<td><form:input path="userId" disabled="true"/></td>
		</tr>

		<tr>
			<td><form:label path="userName">UserName:</form:label></td>
			<td><form:input path="userName"/></td>
		</tr>
                 <tr>
			<td><form:label path="role">Role:</form:label></td>
			<td><form:input path="role"/></td>
		</tr>
		<td><form:label path="password">Password:</form:label></td>
        			<td><form:input path="password"/></td>
        		</tr>
	</table>
	<input type="submit" value="Save" />

	<table border=1.5 width='600' cellpadding='1' cellspacing='1'>
	<tr>
		<th>AddressId</th>
		<th>Street</th>
		<th>City</th>
		<th>District</th>
                <th>Pincode</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<tbody>
		<c:forEach items="${addressList}" var="item">
		<tr>
				<c:url var="editCUrl" value="/editAddress?bid=${userAttribute.userId}&cid=${item.addressId}" />

				<td><c:out value="${item.addressId}" /></td>
				<td><c:out value="${item.street}"/></td>
				<td><c:out value="${item.city}"/></td>
				<td><c:out value="${item.district}"/></td>
		                <td><c:out value="${item.pinCode}"/></td>
				<td><a href="${editCUrl}">EditAddress</a></td>
		</tr>
		</c:forEach>
</tbody>
</table>
</form:form>
</div>
</center>
</body>
</html>
