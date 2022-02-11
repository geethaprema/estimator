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
<title>Projects</title>

<script type="text/javascript">
$(document)
.ready(
		function() {
		    $('#custId').val(${custId});
		});
		
</script>
</head>
<body>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a> <a href="/admin">Admin
			User</a> <a href="/ShowCustomer">Customers</a> 
	</div>
	<div class="content">
		<div class="table-responsive">
			<div>
				<input type="text" class="form-control" name="projectId"
					id="projectId" hidden="true"> <label
					style="font-weight: bold; font-style: italic; color: black; font-size: 20px;">
					Customer : ${customerName} &nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					Project : ${projectName} &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Estimate :
					${estimateName}</label>
				<button type="button" class="btn btn-warning float-right ml-2"
					onclick="location.href = '/ShowCustomer';">Back</button>
			</div>


			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Estimate Description</th>
						<th>Service Name</th>
						<th>Technology Name</th>
						<th>Resource Unit</th>
						<th>Effort</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
							<td>${item.estimate_description}</td>
							<td>${item.service_name}</td>
							<td>${item.technology_name}</td>
							<td>${item.resource_unit}</td>
							<td>${item.effort}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>