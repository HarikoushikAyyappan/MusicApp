
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<div align="center">
    <h2>Registration Requests</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>UserID</th>
            <th>UserName</th>
            <th>Password</th>
            <th>Role</th>
            <th>AddressId</th>
            <th>Street</th>
             <th>City</th>
            <th>District</th>
              <th>PinCode</th>
        </tr>
        <c:forEach items="${userForm}" var="customer">
        <tr>
            <td>${customer.userId}</td>
            <td>${customer.userName}</td>
            <td>${customer.password}</td>
            <td>${customer.role}</td>
            <td>${customer.faddressId}</td>
            <td>${customer.street}</td>
          <td>${customer.district}</td>
            <td>${customer.pinCode}</td>
            <td>
                <a href="http://localhost:8080/MusicApp/approveRegistration?bid=${customer.formId}">Approve</a>
                &nbsp;&nbsp;&nbsp;
                <a href="http://localhost:8080/MusicApp/deleteUserForm?id=${customer.formId}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
