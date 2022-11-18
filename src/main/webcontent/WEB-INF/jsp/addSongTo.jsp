<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
<h1>Add New Song</h1>

<c:url var="Url" value="/saveSongs?id=${genreId}" />

<form:form modelAttribute="songAttribute"   method="POST" action="${Url}">
	<table>

		<tr>
			<td>GenreId:</td>
			<td><input type="text" value="${genreId}" />
		</tr>

		<tr>
			<td><form:label path="songId">SongId</form:label></td>
			<td><form:input path="songId" /></td>
		</tr>

		<tr>
			<td><form:label path="songName">SongName:</form:label></td>
			<td><form:input path="songName"/></td>
		</tr>
		<tr>
        			<td><form:label path="downloads">Downloads:</form:label></td>
        			<td><form:input path="downloads"/></td>
        		</tr>
     	<tr>
                   	<td><form:label path="block">Block:</form:label></td>
                    <td><form:input path="block"/></td>
        </tr>

    	</tr>

	</table>

	<input type="submit" value="Save" />
</form:form>
</div>
</center>
</body>
</html>