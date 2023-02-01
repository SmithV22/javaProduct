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
<title>Customer Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/dash.css">
<link rel="stylesheet" href="/css/project.css">
</head>
<body>
	<%@include file="/WEB-INF/header.jsp" %>
	<div class="container p-4 w-75">
		<div class="d-flex justify-content-between">
			<div class="text-center">
				<h5>Project Customer: </h5>
				<p> ${ project.customerProj.firstName } ${ project.customerProj.lastName }</p>
			</div>
		</div>
		<div class="d-flex">
			<div>
				<div>
					<h5>Type: </h5>
					<p> ${ project.type }</p>
				</div>
				<div >
					<h5> Description: </h5>
					<p> ${ project.description }</p>
				</div>
				<div >
					<h5> Price: </h5>
					<p>$ ${ project.price }</p>
				</div>
				<div >
					<h5>Assigned To:</h5>
					<p>${ project.assignedTo }</p>
				</div>
			</div>
			<div>
				<div>
					<h5>Completed:</h5>
					<p>${ project.completed }</p>
				</div>
				<div >
					<h5>Sent to Billing:</h5>
					<p>${ project.sentToBilling }</p>
				</div>
				<div >
					<h5>Paid:</h5>
					<p>${ project.paid }</p>
				</div>
			</div>
		</div>
		<div class="d-flex justify-content-evenly">
			<a class="dash__links" href="/project/edit/${ project.id }">| Edit | </a>
			<a class="dash__links" href="/project/comment/add/${id}">| Add Comment | </a>
			<a class="dash__links" href="/dashboard">| Project Dash | </a>
		</div>
		<div class="dash__line mt-4"></div>
		<div>
			<div>
				<c:forEach items="${project.comments }" var="oneComment">
				<div>
					<div class="project__comment d-flex">
						<h5>Written By: ${ oneComment.user.firstName } ${ oneComment.user.lastName }</h5>
						<h5><fmt:formatDate value="${oneComment.createdAt}" pattern="MM-dd-yyyy HH:mm:ss" /></h5>
					</div>
					<div class="project__text">	
						<p>${ oneComment.text}</p>
					</div>
					<div class="dash__line mt-4"></div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>