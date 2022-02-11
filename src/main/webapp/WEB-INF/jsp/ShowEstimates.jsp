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
</head>
<body>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="table-responsive">
			<div>
				<input type="text" class="form-control" name="projectId"
					id="projectId" hidden="true"> <label
					style="font-weight: bold; font-style: italic; color: black; font-size: 20px;">
					Project : ${projectName} </label>

				<button type="button" class="btn btn-warning float-right ml-2"
					onclick="location.href = '/ShowCustomer';">Back</button>
			</div>


			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Estimate Name</th>
						<th>Version</th>
						<th>Edit Estimate</th>
						<th>View Detail Estimate</th>
						<th>Download</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
							<td>${item.estimate_name}</td>
							<td>${item.version_id}</td>
							<c:choose>
								<c:when test="${item.flag == 'false'}">
									<td></td>
								</c:when>
								<c:when test="${item.flag == 'true'}">
									<td><a type="button" class="btn btn-success"
										href="/editTsEstimation?estimateId=${item.estimate_id}&version=${item.version_id}">Edit Estimate
									</a></td>
								</c:when>
							</c:choose>

							<td><a type="button" class="btn btn-warning"
								href="/viewDetailEstimate?estimateId=${item.estimate_id}&version=${item.version_id}">View Details</a></td>
							<td><a type="button" class="btn btn-success"
								href="/export?estimateId=${item.estimate_id}&version=${item.version_id}">Download</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>