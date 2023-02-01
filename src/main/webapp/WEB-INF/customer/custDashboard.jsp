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
<title>Customer Dashboard</title>
<link href="/css/header.css" rel="stylesheet">
<link href="/css/dash.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
	<div>
		<%@include file="/WEB-INF/header.jsp" %>
		<h5 class="d-flex justify-content-around mt-5">Customers</h5>
		<div class="d-flex justify-content-between">
			<a href="/customer/add" class="dash__links">| Add Customer |</a>				
		</div>
		<div class="container w-80 mt-4 ">
			<table class="table table-striped table-hover table-bordered table-info">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ allCustomers }" var="customer">
					<tr>
						<td><a class="dash__links" href="/customer/details/${ customer.id }">${ customer.firstName } ${ customer.lastName }</a> </td>
						<td>${ customer.email } </td>
						<td>${ customer.phone }</td>
						<td><a href="/customer/edit/${ customer.id }" class="dash__links">Edit </a><a href="/customer/delete/${ customer.id }" class="dash__links" class="color-red">Delete</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>