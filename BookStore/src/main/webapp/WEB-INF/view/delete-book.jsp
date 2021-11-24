<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/bookstore/deletedata">
<div align="center">
<h1 align="center">Delete Book</h1>
<hr>
<label for="book_id">Book ID:</label>
<input type="text" name="bookid" placeholder="Enter Book ID ??" id="book_id">
<br>
<input type="submit" value="Delete Book">
</div>
</form>
</body>
</html>