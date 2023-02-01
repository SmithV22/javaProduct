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
<title>Add A Customer</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="/css/header.css" rel="stylesheet">
<link rel="stylesheet" href="webjars/bootstrap/css/bootstrap.min.css">
<script src="webjars/jquery/jquery.min.js"></script>
<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/header.jsp" %>
	<div class="container row p-3 mt-5 bg-dark text-light w-50 mx-auto" >
			<div class="col">
				<h3>Add A Customer</h3>
				<form:form action="/customer/add" method="POST" modelAttribute="customer">
					<div class="form-group mt-3">
						<form:label path="firstName">First Name:</form:label>
						<form:errors path="firstName" class="text-danger"/>
						<form:input class="form-control" path="firstName"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="lastName">Last Name:</form:label>
						<form:errors path="lastName" class="text-danger"/>
						<form:input class="form-control" path="lastName"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="email">Email:</form:label>
						<form:errors path="email" class="text-danger"/>
						<form:input class="form-control" path="email" />
					</div>
					<div class="form-group mt-3">
						<form:label path="phone">Phone:</form:label>
						<form:errors path="phone" class="text-danger"/>
						<form:input class="form-control" path="phone" />
					</div>
					<div class="d-flex justify-content-between">
						<input class="btn  mt-3" style="background: #a1d7e3;" type="submit" value="Submit"/>
						<button class="btn btn-primary mt-3 border-dark" style="background: #a1d7e3;"><a  href="/customer/custDash" class="text-decoration-none text-dark ">Cancel</a></button>
					</div>
				</form:form>
						
			</div>
		</div>
	
</body>
</html>