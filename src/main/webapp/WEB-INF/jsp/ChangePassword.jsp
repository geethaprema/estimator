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
<title>Change Password</title>
</head>
<body>
	<div class="content">
		<form action="/changePwd" method="post">
			<div class="container">
				<h1>Change Password</h1>
				<p>Please Change ${message} password</p>
				<hr>

				<label for="emailId"><b>Email Address</b></label> <input type="text"
					 name="emailAddress" id="email" value= "${emailId}" readonly="readonly">
				<label for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="password" id="psw" required>	
					
				<button type="submit" class="registerbtn">Change Password</button>
			</div>

		</form>
	</div>
</body>
</html>