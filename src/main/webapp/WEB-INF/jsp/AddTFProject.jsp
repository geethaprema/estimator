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

<title>Project</title>
<script type="text/javascript">
	function updateDuration() {
		var complexityVal = document.getElementById("complexity").value;
		if (complexityVal == "Simple") {
			$("#duration").val("10 - 12 Weeks");
		} else if (complexityVal == "Medium") {
			$("#duration").val("14 - 18 Weeks");
		} else {
			$("#duration").val("19 - 24 Weeks");
		}
	}
</script>
</head>
<body>
	<div class="note">
		<h4>ADD NEW TRANSFORMATION PROJECT</h4>
	</div>
	<div class="sidebar">
		 <a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a> <a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div
			style="text-align: center; font-size: 18px; font-weight: bold; color: green;">
			<c:out value="${message}" />
		</div>
		<div class="form-content">
			<form method="POST" action="/addProject">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Customer Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="customerName"
							readonly="readonly" value="${customer_name}"> <input
							type="text" class="form-control" id="custId" hidden=""
							name="custId" value="${custId}">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Project Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="projectName"
							required="required">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Project Description : </label>
					<div class="form-group mx-sm-3 mb-2">
						<textarea  class="form-control" name="project_Description" rows="4" cols="70"
							></textarea>
					</div>
				</div>
				<div class="form-row">
					<label class="col-sm-2 col-form-label">Data Centers : </label>
					<div class="col-2">
						<label class="col-sm-2 col-form-label">USA: </label> <input
							type="number" class="form-control" name="USA_DC">
					</div>
					<div class="col-2">
						<label class="col-sm-2 col-form-label">EMEA: </label> <input
							type="number" class="form-control" name="EMEA_DC">
					</div>
					<div class="col-2">
						<label class="col-sm-2 col-form-label">APAC: </label> <input
							type="number" class="form-control" name="APAC_DC">
					</div>
				</div>
				<div class="form-row">
					<label class="col-sm-2 col-form-label">Remote Sites : </label>
					<div class="col-2">
						<label class="col-sm-2 col-form-label">USA: </label> <input
							type="text" class="form-control" name="USA_RS">
					</div>
					<div class="col-2">
						<label class="col-sm-2 col-form-label">EMEA: </label> <input
							type="text" class="form-control" name="EMEA_RS">
					</div>
					<div class="col-2">
						<label class="col-sm-2 col-form-label">APAC: </label> <input
							type="text" class="form-control" name="APAC_RS">
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Complexity : </label>
					<div class="col-sm-10">
						<div class="dropdown">
							<select name="complexity" id="complexity"
								onchange="updateDuration()">
								<option value="Simple" selected="selected">Simple</option>
								<option value="Medium">Medium</option>
								<option value="Complex">Complex</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Project Duration : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" name="duration"
							id="duration" value="10 - 12 Weeks"
							placeholder="Duration(Months)" readonly="readonly">
					</div>
				</div>
				<div class="form-group row" id="cloudDropdown">
					<label class="col-sm-2 col-form-label">Cloud Vendor :</label>
					<div class="col-sm-10">
						<div class="dropdown">
							<select name="cloudVendor" id="cloudVendor" required>
							<option value="0" selected="selected">--SELECT--</option>
								<option value="AWS" >AWS</option>
								<option value="Azure">Microsoft Azure</option>
								<option value="GCP">Google Cloud</option>
								<option value="Private">Private Cloud</option>
							</select>
						</div>
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