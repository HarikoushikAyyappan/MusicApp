<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Music World</title>
</head>
<body>
<div align="center">
    <h2>Welcome to the Music World</h2>

          <form method="get"  action="/MusicApp/userLogin">
                 </br>User Login    <input type="submit"  value="Login"/></form>
          <form method="get"  action="/MusicApp/adminLogin">
             </br>Admin login   <input type="submit"  value="Login"/></form>
             <form method="get"  action="/MusicApp/superAdminLogin">
                          </br>SuperAdmin login   <input type="submit"  value="Login"/></form>
              <form method="get" action="/MusicApp/createUserForm">
                </br>Register      <input type="submit" value="createUserForm" />
                  </form>


</div>
</body>
</html>
