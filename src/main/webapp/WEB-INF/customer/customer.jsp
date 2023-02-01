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
</head>
<body>
	<%@include file="/WEB-INF/header.jsp" %>
	<div class="container p-4 w-75">
		<div class="d-flex justify-content-between">
			<h1 class="mb-4">Customer ${ customer.firstName } ${ customer.lastName }</h1>
		</div>
		<div></div>
		<div class="d-flex justify-content-space-evenly">
			<div>
			<div>
				<h5>Address:</h5>
				<p> ${ customer.address.street}</p>
				<p> ${ customer.address.city}</p>
				<p> ${ customer.address.state}</p>
				<p> ${ customer.address.zip}</p>
			</div>
			<div>
				<h5> Phone: </h5>
				<p>  ${ customer.phone } <p>
			</div>
		</div>
		<div>
			<div>
				<h5> Email: </h5>
				<p> ${ customer.email } </p>
				</div>
				<div>
					<h5 class="">Projects:</h5>
					<p>${ customer.projects.size() }</p>
				</div>
			</div>
		</div>
		<div class="d-flex justify-content-evenly mb-3">
		<a class="text-decoration-none text-secondary" href="/customer/edit/${ customer.id }">| Edit | </a>
		<c:if test="${ customer.address == null }">
			<a class="text-decoration-none text-secondary" href="/address/add/${ customer.id }">| Add address for this customer | </a>
		</c:if>
		
		<a href="/project/add/${id}" class="text-decoration-none text-secondary">| Add Project |</a>
		
		</div>
		<div class="dash__line mt-4"></div>
		<h5 class="text-center mt-5">Projects</h5>
		
		<div class="container w-80 mt-3">
			<table class="table table-striped table-info table-hover table-bordered">
				<thead>
					<tr>
						<th>Project Id</th>
						<th> Type</th>
						<th>Completed</th>
						<th>Sent To Billing</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${customer.projects }" var="project">
					<tr>
						<td><a class="text-decoration-none" href="/project/details/${ project.id }">${ project.id }</a> </td>
						<td>${ project.type } </td>
						<td>${ project.completed }</td>
						<td>${ project.sentToBilling }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
		<div class="dash__line mt-4"></div>

	</div>
</body>
</html>