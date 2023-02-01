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
<title>Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center mb-4 mt-3">Welcome </h1>
		<div class="container row p-3 bg-dark text-light w-50 mx-auto">
			<div class="col">
				<h1>Register</h1>
				<h4><a href="/">Already Registered? Login Here</a></h4>
				<form:form action="/register" method="POST" modelAttribute="user">
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
						<form:input class="form-control" path="email" type="email"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="text-danger"/>
						<form:input class="form-control" path="password" type="password"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="confirmPass">Confirm Password:</form:label>
						<form:errors path="confirmPass" class="text-danger"/>
						<form:input class="form-control" path="confirmPass" type="password"/>
					</div>
					<div>
						<input class="btn btn-primary mt-3" type="submit" value="Register"/>
					</div>
				</form:form>
			</div>
		</div>
</body>
</html>