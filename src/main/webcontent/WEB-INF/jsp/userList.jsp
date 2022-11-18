<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Manager</title>
</head>
<body>
<div align="center">
    <h2>Customer Manager</h2>
    </form>
    <h3><a href="/new">EditUserRole</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>UserID</th>
            <th>UserName</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${userList}" var="customer">
        <tr>
            <td>${customer.userId}</td>
            <td>${customer.userName}</td>
            <td>${customer.role}</td>
            <td>
                <a href="http://localhost:8080/MusicApp/editRole?id=${customer.userId}">EditRole</a>
                &nbsp;&nbsp;&nbsp;

            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>