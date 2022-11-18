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
</head>
<body bgcolor="#AAE6FA">

<div class="myDiv">
<%-- //////////////////////////////////////////////////////////////// --%>
<center>

<h1>Filter Item By Category</h1>

<c:url var="Url" value="/durationList" />

<form:form modelAttribute="durationAttribute" method="POST" action="${Url}">
	<table>
		<%--
		<tr>
			<td><form:label path="durationId"></form:label></td>
			<td><form:input path="durationId" type="hidden"/></td>
		</tr>
		--%>

		<tr>
	 		<td>Duration:</td>
			<td><form:select path="timeDuration">
				<c:forEach items="${durations}" var="category">
    				<form:option value="${category.timeDuration}"></form:option>
    			</c:forEach>
			</form:select>
		<input type="submit" value="Filter" />
		</td>

		</tr>
	</table>
</form:form>

</center>
</div>
<h2> </h2>
<%-- //////////////////////////////////////////////////////// --%>

<div class="container">
<div class = "left">
<table border='1.5' width='200' cellpadding='1' cellspacing='1'>
	<tr>

		<th>Duration</th>
	</tr>
	<tbody>
	<c:forEach items="${durations}" var="category">
			<tr>
	 		<td><c:out value="${category.durationId}" /></td>

			</tr>
	</c:forEach>
	</tbody>

</table>
<div class="myDiv">
</div>
</div>

<center>
<div class="right">
<table border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<tr>
   <%--	<th>SongId</th> --%>
		<th>SongName</th>
		<th>Downloads</th>

	</tr>
	<tbody>
	<c:forEach items="${items}" var="item">
			<tr>
			<%-- <td><c:out value="${item.songId}" /></td>  --%>
				<td><c:out value="${item.songName}" /></td>
				<td><c:out value="${item.downloads}" /></td>


			</tr>
			</c:forEach>
	</tbody>

</table>

</div>
</center>
</div>

<div id="footer">
	<p><a href="http://localhost:8080/MusicApp">Home</a></p>
</div>

</body>
</html>