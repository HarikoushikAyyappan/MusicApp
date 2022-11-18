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

<h1>Edit Genre</h1>

<c:url var="saveUrl" value="/saveGenre?id=${genreAttribute.genreId}" />
<c:url var="addCUrl" value="/addSong?id=${genreAttribute.genreId}" />


<form:form modelAttribute="genreAttribute"  method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="genreId">GenreId:</form:label></td>
			<td><form:input path="genreId" disabled="true"/></td>
		</tr>

		<tr>
			<td><form:label path="genreName">GenreName:</form:label></td>
			<td><form:input path="genreName"/></td>
		</tr>
	</table>
	<input type="submit" value="Save" />

	<table border=1.5 width='600' cellpadding='1' cellspacing='1'>
	<tr>
		<th>ItemId</th>
		<th>ItemName</th>
		<th>Delete</th>

	</tr>
	<tbody>


		<c:forEach items="${genreAttribute.songList}" var="item">
		<tr>

				<c:url var="deleteCUrl" value="/deleteSong?id=${item.songId}" />
				<td><c:out value="${item.songId}" /></td>
				<td><c:out value="${item.songName}"/></td>
				<td><a href="${editCUrl}">EditSong</a></td>
				<td><a href="${deleteCUrl}">DeleteSong</a></td>
		</tr>
		</c:forEach>


		  <p><a href="${addCUrl}">Add Song</a></p>


	</tbody>
</table>
</form:form>
</div>
</center>
</body>
</html>