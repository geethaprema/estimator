<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
<script src="webjars/jquery/3.6.0/jquery.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/login.css">
<link rel="stylesheet" href="/css/dataCenter.css">
<link rel="stylesheet" href="/css/sideBar.css">
<title>Register</title>
</head>
<body>
	<div class="note">
		<h3>Register</h3>
	</div>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div
			style="text-align: center; font-size: 18px; font-weight: bold; color: green;">
			<c:out value="${message}" />
		</div>
		<form action="/RegisterNewUser" method="post">
			<div class="container">
				<p style="color: blue">Please fill in this form to create an
					account.</p>
				<hr>

				<label for="email"><b>Email</b></label> <input type="text"
					placeholder="Enter Email" name="emailAddress" id="email" required>

				<label for="userName"><b>User Name</b></label> <input type="text"
					placeholder="User Name" name="userName" id="userName" required>
				<div>
					<label for="adminUser"><b>Admin User?</b></label>
					<div class="btn-group btn-group-toggle" data-toggle="buttons">
						<label class="btn btn-outline-info active"> <input
							type="radio" name="adminUser" id="adminUser" value="Y" checked>
							Yes
						</label> <label class="btn btn-outline-info"> <input type="radio"
							name="adminUser" id="adminUser" value="N"> No
						</label>
					</div>
				</div>
				<button type="submit" class="registerbtn">Register</button>
			</div>

		</form>
	</div>
</body>
</html>