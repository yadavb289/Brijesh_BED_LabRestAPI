<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
			integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
		<title>HTTP Status 403</title>
	</head>

	<body>
		<div class="container text-center">
			<h3>HTTP Status 403 - Access is denied</h3>
			<h4>${msg}</h4>
			<hr>
			<a href="/StudentManagement/student/list" class="btn btn-outline-secondary">Go to Students List</a>
		</div>

	</body>
	</html>