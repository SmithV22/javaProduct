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
<title>Insert title here</title>
<meta charset="ISO-8859-1">
<title>Add A Customer</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="webjars/bootstrap/css/bootstrap.min.css">
<script src="webjars/jquery/jquery.min.js"></script>
<script src="webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/header.jsp" %>
	<div class="container row p-3 mt-5 bg-dark text-light w-50 mx-auto">
			<div class="col">
				<h3>Add A Project</h3>
				<form:form action="/project/edit" method="POST" modelAttribute="project">
				<input type="hidden" name="_method" value="put"/>
					<div class="form-group mt-3">
						<form:label path="type">Type:</form:label>
						<form:errors path="type" class="text-danger"/>
						<form:input class="form-control" path="type"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="description">Description:</form:label>
						<form:errors path="description" class="text-danger"/>
						<form:input class="form-control" path="description"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="price">Price:</form:label>
						<form:errors path="price" class="text-danger"/>
						<form:input class="form-control" path="price" />
					</div>
					<div class="form-group mt-3">
						<form:label path="assignedTo">Assigned To:</form:label>
						<form:errors path="assignedTo" class="text-danger"/>
						<form:input class="form-control" path="assignedTo"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="completed">Completed:</form:label>
						<form:errors path="completed" class="text-danger"/>
						<form:select class="form-control" path="completed" >
							<form:option value="">Please select one</form:option>
							<form:option value="Yes">Yes</form:option>
							<form:option value="No">No</form:option>
						</form:select>
					</div>
					<div class="form-group mt-3">
						<form:label path="sentToBilling">Sent to Billing:</form:label>
						<form:errors path="sentToBilling" class="text-danger"/>
						<form:select class="form-control" path="sentToBilling" >
							<form:option value="">Please select one</form:option>
							<form:option value="Yes">Yes</form:option>
							<form:option value="No">No</form:option>
						</form:select>
					</div>
					<div class="form-group mt-3">
						<form:label path="paid">Paid:</form:label>
						<form:errors path="paid" class="text-danger"/>
						<form:select class="form-control" path="paid" >
							<form:option value="">Please select one</form:option>
							<form:option value="Yes">Yes</form:option>
							<form:option value="No">No</form:option>
						</form:select>
					</div>
					<div>
						<form:input type="hidden" path="customerProj" value="${ customer.id }"/>
						<form:hidden path="id" value="${ project.id }"/>
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