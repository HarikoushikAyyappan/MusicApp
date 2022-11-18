<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
<div align="center">
    <h2>Search Result</h2>
    <table border="1" cellpadding="5">
        <tr>
            <th>UserID</th>

        </tr>
        <tr>
        <td>${basket.user.userId}</td>
        </tr>
        <tr>
        <th>SongId</th>
        <th>SongName</th>
        <th>Downloads</th>
        <th>Action</th>
        </tr>
        <c:forEach items="${basket.songList}" var="customer">
        		<tr>
        			<td>${customer.songId}</td>
        			<td>${customer.songName}</td>
        			<td>${customer.downloads}</td>
        			 <td>
                                    <a href="http://localhost:8080/MusicApp/doApprove?bid=${customer.songId}&cid=${basket.basketId}">DoApprove</a>
                                    &nbsp;&nbsp;&nbsp;

                                </td>
        			</tr>
        			</c:forEach>
        
    </table>
</div>
</body>
</html>