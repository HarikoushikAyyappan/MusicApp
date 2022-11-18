<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
    <div align="center">
        <h2>Admin Login</h2>
            <form method="get" action="/MusicApp/adminPage">
                <input type="text" name="adminId" /> &nbsp;
                 <input type="text" name="password" /> &nbsp;
                <input type="submit" value="login" />
            </table>
        </form>
        <a href="http://localhost:8080/MusicApp">Home</a>
    </div>
</body>
</html>