<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link href="/css/header.css" rel="stylesheet">
<link href="/css/dash.css" rel="stylesheet">
<link rel="stylesheet" href="webjars/bootstrap/css/bootstrap.min.css">
<script src="webjars/jquery/jquery.min.js"></script>
<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<%@include file="/WEB-INF/header.jsp" %>
		<h5 class="dash__heading mt-5">Projects</h5>
		<div class="container w-80 mt-3">
			<table class="table table-striped table-info table-hover table-bordered">
				<thead>
					<tr>
						<th>Project Id</th>
						<th> Type</th>
						<th>Price</th>
						<th>Completed</th>
						<th>Sent to Billing</th>
						<th>Paid</th>
						<th>Assigned To</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ allProjects }" var="project">
					<tr>
						<td><a class="text-decoration-none" href="/project/details/${ project.id }">${ project.id }</a> </td>
						<td>${ project.type } </td>
						<td>$ ${ project.price }</td>
						<td>${ project.completed }</td>
						<td>${ project.sentToBilling }</td>
						<td>${ project.paid }</td>
						<td>${ project.assignedTo }</td>
						<td><a href="/project/edit/${ project.id }">Edit |</a><a href="/project/delete/${ project.id }">Delete</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>