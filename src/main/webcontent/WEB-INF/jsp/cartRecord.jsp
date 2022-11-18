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
.right {
    background:#d9edf7;
    white-space:nowrap;
    overflow:hidden;
    text-overflow:ellipsis;
    -ms-text-overflow:ellipsis;
    float: right;
}
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
#myDiv{
	background-color: #d9edf7;
	border-color: #bce8f1;
	width: 200px;

}
</style>
</head>
<body bgcolor="#AAE6FA">
<center>

<div id="Table-box">

<h1>Your Cart</h1>

<%--
<c:url var="saveUrl" value="/editGenre?id=${genreAttribute.genreId}" />
--%>
<%-- /////////////////////////////////////////////////////////////////////////////////////////////// --%>
<table border='1.5' width='100' cellpadding='1' cellspacing='1'>
	<tr>
		<td>Id</td>
		<td>${CurrentUser.userId}</td>
	</tr>
</table>

<%-- /////////////////////////////////////////////////////////////////////////////////--%>

<h2> Item Saved in Cart</h2>
<table border='1.5' width='600' cellpadding='1' cellspacing='1'>
	<tr>
		<th>SongId</th>
		<th>SongName</th>
		<th>Downloads</th>


	</tr>
	<tbody>

	<c:forEach items="${CurrentSongs}" var="item">
			<tr>
			    <td><c:out value="${item.songId}"/></td>
				<td><c:out value="${item.songName}" /></td>
				<td><c:out value="${item.downloads}" /></td>
			</tr>
	</c:forEach>

	</tbody>

</table>

</center>

</div>
<%--
<div class="myDiv">
--%>


<center>

<form action="/MusicApp/checkOut?id=${CurrentUser.userId}" method="post">
	<table>
	<tr>
		<td>BasketId:</td>
		<td><input type = "text" name = "basketId"/></td>
	</tr>

		<td><input type = "submit" value = "CheckOut"/></td>
	</tr>
	</table>
</form>
</center>
</body>
</html>