<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
</head>
<body>
	
	<div class="navbg">
		<div class="dash__line"></div>
		<h1 class="dash__heading pt-4">Project Manager</h1>
		<div class="dash__signedIn">
			<h5> ${ user.firstName } ${ user.lastName } is signed in</h5>
			<a href="/https://neiasoftwaredesign.com" class="dash__links">Return To Portfolio</a>
			<a href="/logout" class="dash__links">Logout</a>
		</div>
		<div class="dash__line"></div>
			<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #a1d7e3;">
				<div id="navbarNav">
					<div class="navbar-nav" >
						<a href="/dashboard" class="nav-link">Projects</a>
						<a href="/customer/custDash" class="nav-link">Customers</a>
					</div>
				</div>
			</nav>
		</div>
		<div class="dash__line"></div>
	</div>
	
	
</body>
</html>