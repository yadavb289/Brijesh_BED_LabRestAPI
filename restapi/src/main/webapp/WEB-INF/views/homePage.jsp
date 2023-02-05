<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<html>

		<head>
			<!-- Required meta tags -->
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

			<!-- Bootstrap CSS -->
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
				integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
				crossorigin="anonymous">
			<title>Students Registration Application</title>
		</head>

		<body>
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark text-white">
				<a class="navbar-brand" href="/StudentManagement/student/list">Students Registration Application</a>
			</nav>
			<div class="container p-3">
				<h3 class="container text-center">List of Registered Students</h3>
				<hr>
				<!-- Add button -->
				<a href="/StudentManagement/student/showFormForAdd" class="btn btn-outline-success col-12"
					type="button"> Add Student</a>
				<table class="table table-bordered table-striped">
					<thead class="thead-light">
						<tr>
							<th>Student ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Course Name</th>
							<th>Country Name</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${Students}" var="tempStudent">
							<tr>
								<td>
									<c:out value="${tempStudent.id}" />
								</td>
								<td>
									<c:out value="${tempStudent.firstName}" />
								</td>
								<td>
									<c:out value="${tempStudent.lastName}" />
								</td>
								<td>
									<c:out value="${tempStudent.course}" />
								</td>
								<td>
									<c:out value="${tempStudent.country}" />
								</td>
								<td>
									<!-- Add "update" and "Delete" button/link --> <a
										href="/StudentManagement/student/showFormForUpdate?studentId=${tempStudent.id}"
										class="btn btn-outline-success"> Update </a> <!-- Add "delete" button/link -->
									<a href="/StudentManagement/student/delete?studentId=${tempStudent.id}"
										class="btn btn-outline-danger"
										onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
										Delete </a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- Added logout button -->
				<a href="/StudentManagement/logout" class="btn btn-outline-secondary col-12" type="button"> Logout</a> 
			</div>
		</body>
		</html>