<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align ="center" style="color: red">Books searched with ${search}</h1>

<div align="center">
<table border="1">
<thead>
<tr>
<td>BookId</td>
<td>BookName</td>
<td>Category</td>
<td>Price</td>
<td>Author</td>
</tr>
</thead>
<c:forEach var="book"   items="${books}">
<tr>
<td>${book.id}</td>
<td>${book.name}</td>
<td>${book.category}</td>
<td>${book.price}</td>
<td>${book.author}</td>
</tr>

</c:forEach>
</table>
</div>
</body>
</html>