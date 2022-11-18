<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#AAE6FA">
<center>
<h1>Create New Record</h1>

<c:url var="saveUrl" value="/addGenre" />
<form:form modelAttribute="genreAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="genreId">GenreId</form:label></td>
			<td><form:input path="genreId"/></td>
		</tr>

		<tr>
			<td><form:label path="genreName">Genre Name</form:label></td>
			<td><form:input path="genreName"/></td>
		</tr>
	</table>

	<input type="submit" value="Save" />
</form:form>
</center>
</body>
</html>