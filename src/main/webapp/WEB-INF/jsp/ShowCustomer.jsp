<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="/css/dataCenter.css">
<link rel="stylesheet" href="/css/sideBar.css">
<title>CUSTOMER</title>
</head>
<body>
	<div class="note">
		<h3>CUSTOMER</h3>
	</div>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="table-responsive">
			<p>Welcome ${userName}</p>
			<div style="text-align: center;">
				<button type="button" class="btn btn-warning float-left  ml-2"
					onclick="location.href = '/AddCustomer';">Add Customer</button>
			</div>


			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Customer Name</th>
						<th>Location</th>
						<th>Update Customer</th>
						<th>View Project</th>
						<th>Transition Project</th>
						<th>Delete Customer</th>
<!-- 						<th>Transformation Project</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
							<td>${item.customer_name}</td>
							<td>${item.customer_location}</td>
							<td><a type="button" class="btn btn-primary"
								href="/editCustomer?custId=${item.customer_id}">Edit
									Customer</a></td>
							<td><a type="button" class="btn btn-primary"
								href="/viewProjects?custId=${item.customer_id}&customerName=${item.customer_name}">View
									Projects</a></td>
							<td><a type="button" class="btn btn-primary"
								href="/addProject?custId=${item.customer_id}&customerName=${item.customer_name}">New
									Transition Project</a></td>
							<td><a type="button" class="btn btn-danger"
								href="/deleteCustomer?custId=${item.customer_id}">Delete</a></td>
							<%-- <td><a type="button" class="btn btn-primary"
								href="/addTFProject?custId=${item.customer_id}&customerName=${item.customer_name}">New
									Tranformation Project</a></td> --%>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>