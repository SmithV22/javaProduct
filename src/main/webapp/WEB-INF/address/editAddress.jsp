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
<title>Add Customer Address</title>
<link href="/css/header.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%@include file="/WEB-INF/header.jsp" %>
	<div class="container row p-3 mt-5 bg-dark text-light w-50 mx-auto">
			<div class="col">
				<h3 class="text-center">Edit address for ${ customer.firstName } ${ customer.lastName }</h3>
				<form:form action="/address/edit" method="POST" modelAttribute="address">
				<input type="hidden" name="_method" value="put"/>
					<div class="form-group mt-3">
						<form:label path="street">Street Address:</form:label>
						<form:errors path="street" class="text-danger"/>
						<form:input class="form-control" path="street"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="city">City:</form:label>
						<form:errors path="city" class="text-danger"/>
						<form:input class="form-control" path="city"/>
					</div>
					<div class="form-group mt-3">
						<form:label path="state">State:</form:label>
						<form:errors path="state" class="text-danger"/>
						
						<form:select class="form-select" path="state">
							<form:option value="NONE">Please Select One</form:option>
							<form:option value="Connecticut"> Connecticut </form:option>
							<form:option value="New York"> New York </form:option>
							<form:option value="New Jersey"> New Jersey </form:option>
							<form:option value="New York"> New York </form:option>
							<form:option value="Pennsylvania"> Pennsylvania </form:option>
						</form:select>
						
					</div>
					<div class="form-group mt-3">
						<form:label path="zip">Zip Code:</form:label>
						<form:errors path="zip" class="text-danger"/>
						<form:input class="form-control" path="zip" />
					</div>
					<div>
						<form:input type="hidden" path="customer" value="${ customer.id }"/>
						<form:hidden path="id" value="${ address.id }"/>
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