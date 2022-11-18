<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approval Manager</title>
</head>
<body>
<div align="center">
    <h2>PurchaseApproval</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>BasketID</th>

        </tr>
        <c:forEach items="${baskets}" var="customer">
        <tr>
            <td>${customer.basketId}</td>
             <td>
              <a href="http://localhost:8080/MusicApp/approve?id=${customer.basketId}">getDetails</a>
                           &nbsp;&nbsp;&nbsp;
              <a href="http://localhost:8080/MusicApp/deletePurchase?id=${customer.basketId}">Delete</a>
                </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>