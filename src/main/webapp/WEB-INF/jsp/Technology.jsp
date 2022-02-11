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
<title>Technology</title>
<script type="text/javascript">
	$(document).ready(function() {
		loadService();
	});

	function loadService() {
		$.ajax({
			type : 'POST',
			url : '/loadService',
			cache : false,
			success : function(data) {
				var html = '';
				var len = data.length;
				if (len > 0) {
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].service_id + '">'
								+ data[i].service_name + '</option>';
					}
				} else {
					html += '<option value= 0 >--SELECT-- </option>';
				}
				html += '</option>';
				$('#service').html(html);
			},
			error : function(xhr, statusText, err) {
				if (xhr.status == 400)
					alert("Error: Please Enter all the details");
				else
					alert("Error Occured");
			}
		});
	}
</script>
</head>
<body>
	<div class="note">
		<h4>TRANSITION TECHNOLOGY</h4>
	</div>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a></div>
	<div class="content">
		<div
			style="text-align: center; font-size: 18px; font-weight: bold; color: green;">
			<c:out value="${message}" />
		</div>
		<div class="form-content">
			<form  method="post" action = "/addTechnology">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Service Name :</label>
					<div class="form-group mx-sm-3 mb-2">
						<select class="form-control" id="service" name="service_id"
							required="required">
							<option value="0" selected="selected">--SELECT--</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Technology Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="technologyName"
							required="required" >
					</div>
				</div>
				<button type="Submit" class="btn btn-primary" >Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/admin';">Back</button>
			</form>
			<div class="form-group row">
				<label for="details" class="col-sm-2 col-form-label">Available
					Technologies: </label>
				<table class="table " id="dynTable">
					<thead class="thead-dark">
						<tr>
							<th>Service Name</th>
							<th>Technology Name</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						 <c:forEach items="${results}" var="item">
							<tr>
								<td>${item.service_name}</td>
								<td>${item.technology_name}</td>
							<td><a type="button" class="btn btn-danger"
							href="/deleteTechnology?service_id=${item.service_id}&technology_id=${item.technology_id}">Delete </a></td>
							</tr>
						</c:forEach> 
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>