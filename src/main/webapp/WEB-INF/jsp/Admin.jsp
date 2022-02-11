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
<title>Admin</title>
</head>
<body>
	<div class="note">
		<h4>ADMIN MODULE</h4>
	</div>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="form-content">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Transition : </label>
			</div>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/addService';">Add Service</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/addTechnology';">Add Technology</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/addTSTrack';">Add Track</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/addTSQueries';">Add Queries</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/fileUpload';">File Upload</button>
			<button type="button" class="btn btn-warning center"
				onclick="location.href = '/';">Back</button>

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Transformation : </label>
			</div>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/serviceTf';">Add Service</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/techTf';">Add Technology</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/taskTf';">Add Task</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/addTechnology';">Add TF Track</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href = '/addTFQues';">Add TF Queries</button>
			<button type="button" class="btn btn-warning center"
				onclick="location.href = '/';">Back</button>

		</div>
	</div>
</body>
</html>