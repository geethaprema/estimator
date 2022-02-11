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
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="table-responsive">
			<div>
				<input type="text" class="form-control" name="custId" id="custId"
					hidden="true"> <label id="customer_name"
					style="font-weight: bold; font-style: italic; color: black; font-size: 20px;">Customer
					: ${customer_name}</label>
				<button type="button" class="btn btn-warning float-right ml-2"
					onclick="location.href = '/ShowCustomer';">Back</button>
			</div>


			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>Project Name</th>
						<th>Project Type</th>
						<th>Edit Project</th>
						<th>Estimates</th>
						<th> Questionnaire</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
							<td>${item.project_name}</td>
							<td>${item.project_type}</td>
							<td><a type="button" class="btn btn-success"
								href="/editProject?projectId=${item.project_id}&projectType=${item.project_type}&customerName=${customer_name}">Edit
									Project </a></td>
							<c:choose>
								<c:when test="${item.flag == 'True'}">
									<td><a type="button" class="btn btn-warning"
										href="/viewEstimates?projectId=${item.project_id}&projectName=${item.project_name}">View
											Estimates</a></td>

								</c:when>
								<c:when test="${item.flag == 'False'}">
									<td><a type="button" class="btn btn-primary"
										href="/addTsEstimation?custId=${custId}&projectId=${item.project_id}&customerName=${customer_name}&projectName=${item.project_name}">Create
											Estimate</a></td>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${item.quesFlag == 'True'}">
									<td><a type="button" class="btn btn-success"
										href="/editQuestionnaire?projectId=${item.project_id}&projectName=${item.project_name}">Edit
									</a></td>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${item.quesFlag == 'False'}">
									<td><a type="button" class="btn btn-success"
								href="/showQuestionnaire?projectId=${item.project_id}&projectName=${item.project_name}">Add
							</a></td>
							
								</c:when>
							</c:choose>
							

						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>