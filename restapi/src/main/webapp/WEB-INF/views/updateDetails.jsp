<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

			<!-- Bootstrap CSS -->
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
				integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
				crossorigin="anonymous">

			<title>Students Registration App</title>
		</head>

		<body>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white">
				<a class="navbar-brand" href="/StudentManagement/student/list">Students Registration Application</a>
			</nav>

			<div class="container">
				<hr>
				<p class="h4 mb-4" class="container text-center">Update Student Details</p>
				<form action="/StudentManagement/student/save" method="POST">

					<!-- Add hidden form field to handle update -->
					<input type="hidden" name="id" value="${Student.id}" />

					<div class="form-inline">
						<input type="text" name="firstName" value="${Student.firstName}" class="form-control mb-4 col-4"
							placeholder="First Name">
					</div>

					<div class="form-inline">
						<input type="text" name="lastName" value="${Student.lastName}" class="form-control mb-4 col-4"
							placeholder="Last Name">
					</div>

					<div class="form-inline">
						<input type="text" name="course" value="${Student.course}" class="form-control mb-4 col-4"
							placeholder="Course Name">
					</div>

					<div class="form-inline">
						<input type="text" name="country" value="${Student.country}" class="form-control mb-4 col-4"
							placeholder="Country Name">
					</div>

					<button type="submit" class="btn btn-outline-success col-2">Save</button>
					<a href="/StudentManagement/student/list" class="btn btn-outline-secondary col-2">Go Back</a>
				</form>
				<hr>
			</div>

				</body>

		</html>
