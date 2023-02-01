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
<title>Add Comment</title>
<link href="/css/header.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%@include file="/WEB-INF/header.jsp" %>
	<div class="container row p-3 mt-5 bg-dark text-light w-50 mx-auto">
			<div class="col">
				<h3 class="text-center">Add Comment for project ${ project.type } </h3>
				<form:form action="/project/addComment/${ project.id }" method="POST" modelAttribute="comment">
					<div class="form-group mt-3">
						<form:label path="text">Comment:</form:label>
						<form:errors path="text" class="text-danger"/>
						<form:textarea class="form-control" path="text"/>
					</div>

					<div class="d-flex justify-content-between">
						<input class="btn  mt-3" style="background: #a1d7e3;" type="submit" value="Submit"/>
						<button class="btn btn-primary mt-3 border-dark" style="background: #a1d7e3;"><a  href="/dashboard" class="text-decoration-none text-dark ">Cancel</a></button>
					</div>
				</form:form>
			</div>
		</div>
</body>
</html>