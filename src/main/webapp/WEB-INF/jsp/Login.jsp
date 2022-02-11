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
<link rel="stylesheet" href="css/login.css">
<title>Login</title>
</head>
<body>
	<div class="content">
		<div
			style="text-align: center; font-size: 18px; font-weight: bold; color: red;">
			<c:out value="${message}" />
		</div>
		<form action="/" method="post">
			<div class="container">
				<h1>Login</h1>
				<hr>

				<label for="email"><b>Email</b></label> <input type="text"
					placeholder="Enter Email" name="emailAddress" id="email" required>

				<label for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="password" id="psw" required>

				<button type="submit" class="registerbtn">Login</button>
			</div>

		</form>
	</div>
</body>
</html>