
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
    <div align="center">
        <h2>New Customer</h2>
        <form:form action="saveUserForm" method="post" modelAttribute="userFormAttribute">
            <table border="0" cellpadding="5">
            <tr>
                     <td>FormId: </td>
                    <td><form:input path="formId" /></td>
                    <tr>
                    <td>UserId: </td>
                    <td><form:input path="userId" /></td>
                </tr>
                <tr>
                    <td>UserName: </td>
                    <td><form:input path="userName" /></td>
                </tr>
                <tr>
                    <td>role: </td>
                    <td><form:input path="role" /></td>
                </tr>
         <tr>
                    <td>Password: </td>
                    <td><form:input path="password" /></td>
                </tr>

             <tr>
                    <td>AddressId: </td>
                    <td><form:input path="faddressId" /></td>

                </tr>
                 <tr>
                    <td>Street: </td>
                    <td><form:input path="street" /></td>

                  </tr>
                  <tr>
                    <td>City: </td>
                    <td><form:input path="city" /></td>
                </tr>

                    <tr>
                    <td>District: </td>
                    <td><form:input path="district" /></td>

                </tr>
           <tr>
                    <td>PinCode: </td>
                    <td><form:input path="pinCode" /></td>

                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>