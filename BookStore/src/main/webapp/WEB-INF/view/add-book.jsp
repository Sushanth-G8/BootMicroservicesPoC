<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h1>ADD New Book</h1>
<form:form action="/bookstore/savebook" modelAttribute="book">

<label>ID: </label>
<form:input path="id"/>
<br/>

<label>Name: </label>
<form:input path="name"/>
<br/>

<label>Category: </label>
<form:input path="category"/>
<br/>

<label>Price: </label>
<form:input path="price"/>
<br/>

<label>Author: </label>
<form:input path="author"/>
<br/>
<input type="submit" value="ADD Book">

</form:form>

</div>

</body>
</html>