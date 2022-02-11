<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="webjars/bootstrap/4.0.0/css/bootstrap.min.css" />
<script src="webjars/jquery/3.6.0/jquery.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.slim.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.bundle.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.js"></script>
<script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/dataCenter.css">
<link rel="stylesheet" href="/css/sideBar.css">

<title>Customer</title>
</head>
<body>
	<div class="note">
		<h4>UPDATE CUSTOMER INFO</h4>
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
		<div class="form-content">
			<form method="POST" action="editCustomer">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Customer Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="customerName"
							value="${results.customer_name}" required="required"
							readonly="readonly" placeholder="Enter Name"> <input
							type="number" class="form-control" name="custId"
							value="${results.customer_id}" required="required" hidden="true">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Address : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="address"
							value="${results.customer_address}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Location : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="location_person"
							value="${results.customer_location}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Contact Person : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="contactPerson"
							value="${results.customer_contact}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Phone Number : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="phoneNumber"
							value="${results.customer_phone}">
					</div>
				</div>
				<button type="submit" class="btn btn-success">Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/ShowCustomer';">Back</button>
			</form>
		</div>
	</div>
</body>
</html>