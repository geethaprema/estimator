<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Service</title>

</head>
<body>
	<div class="note">
		<h4>TRANSITION SERVICE</h4>
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
			<form method="post">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Service Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="service_name"
							required="required" placeholder="Service Name"
							value="${data.service_name}"> <input type="text"
							class="form-control" name="service_id" value="${data.service_id}"
							hidden="">
					</div>
				</div>
				<button type="Submit" class="btn btn-primary" value="/addService">Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/admin';">Back</button>
			</form>
			<div class="form-group row">
				<label for="details" class="col-sm-2 col-form-label">Available
					Services : </label>
				<table class="table" id="dynTable">
					<thead class="thead-dark">
						<tr>
							<th>Service Name</th>
							<th>Update</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${results}" var="item">
							<tr>
								<td>${item.service_name}</td>
								<td><a type="button" class="btn btn-success"
									href="/editService?service_id=${item.service_id}">Edit </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>