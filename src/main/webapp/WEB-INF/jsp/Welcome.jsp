<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
<script src="webjars/jquery/3.6.0/jquery.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/dataCenter.css">
<link rel="stylesheet" href="/css/sideBar.css">

<title>NORAM2 - WELCOME</title>
</head>
<body>
	<div class="note">
		<h4>NORAM2</h4>
		<div></div>
	</div>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="container register-form">
			<p>Welcome ${message}</p>
		</div>
	</div>
</body>
</html>