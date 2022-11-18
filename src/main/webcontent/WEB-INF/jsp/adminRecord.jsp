<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
.msg1{
	color:red
}
</style>
</head>
<body bgcolor="#AAE6FA">
<center>


<c:url var="addUrl" value="/newGenre" />
<div id="Table-box">
<div class="msg1">
<b>Records</b>
</div>
<table border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<tr>
		<th>GenreId</th>
		<th>GenreName</th>
		<th>Edit</th>

	</tr>
	<tbody>
	<c:forEach items="${genres}" var="category">
		<c:url var="editUrl" value="/editGenre?id=${category.genreId}" />
		<c:url var="deleteUrl" value="/deleteGenre?id=${category.genreId}" />

			<tr>
				<td><c:out value="${category.genreId}" /></td>
				<td><c:out value="${category.genreName}" /></td>

				<td><a href="${editUrl}">Edit</a></td>


			</tr>
			</c:forEach>

	</tbody>
</table>
</div>
<p><a href="${addUrl}">Create new record</a></p>
<a href="http://localhost:8080/MusicApp">Home</a>
</center>
</body>
</html>