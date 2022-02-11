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
<title>Estimate</title>
<script type="text/javascript">
	var techId = new Array();
	var effort = new Array();
	var ru = new Array();
	var version ;
	$(document).ready(
			function() {
				getVersionId();
				loadService();
				$('#checkAll').click(
						function() {
							var isChecked = $(this).prop("checked");
							$('#taskTable tbody tr:has(td)').find(
									'input[type="checkbox"]').prop('checked',
									isChecked);
							$(".effortCls").attr("disabled", !isChecked);
						});
			});
	function getVersionId() {
		$.ajax({
			type : 'POST',
			url : '/getVersionId',
			data : {
				'estimateName' : $('#estimateName').val()
			},
			cache : false,
			success : function(data) {
				version = data;
			},
			error : function(xhr, statusText, err) {
				if (xhr.status == 400)
					alert("Error");
				else
					alert("Error Occured");
			}
		});
	}
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
				loadTechnology();
			},
			error : function(xhr, statusText, err) {
				if (xhr.status == 400)
					alert("Error: Please Enter all the details");
				else
					alert("Error Occured");
			}
		});
	}
	function loadTechnology() {
		var serviceId = $('#service :selected').val();
		$
				.ajax({
					type : 'POST',
					url : '/loadTechnology',
					data : {
						'serviceId' : serviceId
					},
					cache : false,
					success : function(data) {
						var html = '';
						var len = data.length;
						$('#taskTable tbody').empty();
						if (len > 0) {
							$('#taskTable').show();
							$('#showTasks').hide();
							for (var i = 0; i < len; i++) {
								html = "<tr onclick='getCurrentRow(this)' class = 'taskRowCls'><td><input type='checkbox'></td><td>"
										+ " <label for=" + data[i][1] + ">"
										+ data[i][0]
										+ "</label></td><td><input type='number' class = 'effortCls' disabled name='RU' ></td>"
										+ "<td><input type='number' class = 'effortCls' disabled name='effort' ></td></tr>";
								$('#taskTable').append(html);
							}
						} else {
							$('#taskTable').hide();
							$('#showTasks').show();
						}
					},
					error : function(xhr, statusText, err) {
						if (xhr.status == 400)
							alert("Error: Please Enter all the details");
						else
							alert("Error Occured");
					}

				});
	}
	function getCurrentRow(_this) {
		var isChecked = $(_this).find('input[type="checkbox"]').prop("checked");
		if (isChecked) {
			$(_this).find(".effortCls").attr("disabled", !isChecked);
		} else {
			$(_this).find(".effortCls").attr("disabled", !isChecked);
		}
	}
	function getAllTechId() {
		techId = [];
		effort = [];
		ru = [];
		$("tr.taskRowCls").each(
				function() {
					var isChecked = $(this).find('input[type="checkbox"]')
							.prop("checked");
					if (isChecked) {
						techId.push($(this).find('label').attr("for"));
						var currentEffort = $(this)
								.find('input[name="effort"]').val();
						var currentRU = $(this).find('input[name="RU"]').val();
						if (currentEffort === undefined
								|| currentEffort === null
								|| currentEffort === '') {
							effort.push(0);
						} else {
							effort.push(currentEffort);
						}
						if (currentRU === undefined || currentRU === null
								|| currentRU === '') {
							ru.push(0);
						} else {
							ru.push(currentRU);
						}
					}
				});

	}
	function saveEstimates() {
		getAllTechId();
		var serviceId = $('#service :selected').val();
		var projectId = $('#projectId').val();
		var estimateName = $('#estimateName').val();
		var description = $('#description').val();
		console.log("service : "+serviceId);
		if ((estimateName)) {
			$.ajax({
				type : 'POST',
				url : '/saveEstimates',
				data : {
					'estimateName' : estimateName,
					'description':description,
					'serviceId' : serviceId,
					'techId' : techId,
					'ru' : ru,
					'effort' : effort,
					'projectId':projectId,
					'version' : version
				},
				traditional : true,
				cache : false,
				success : function(data) {
					$('#dynTable tbody').empty();
					if (data.length > 0) {
						$('#dynTable').show();
						$('#showTaskDetails').hide();
						for (var i = 0; i < data.length; i++) {
							var rows = "<tr>" + "<td >" + data[i][0] + "</td>"
									+ "<td >" + data[i][1] + "</td>" + "<td >"
									+ data[i][2] + "</td>" + "<td >"
									+ data[i][3] + "</td>" + "<td></tr>";
							$('#dynTable tbody').append(rows);

						}
						alert("Estimation Created");
					}
				},
				error : function(xhr, statusText, err) {
					if (xhr.status == 400)
						alert("Error: Please Enter all the details");
					else
						alert("Error Occured");
				}

			});
		} else {
			alert("Please enter all the details")
		}

	}
</script>
</head>
<body>
	<div class="note">
		<h4>NEW TRANSITION ESTIMATE</h4>
	</div>
	<div class="sidebar">
		 <a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a> <a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="form-content">

			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Customer Name : </label>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control" name="customerName"
						readonly="readonly" value="${customerName}">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Project Name : </label>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control" name="project_name"
						value="${projectName}" readonly="readonly"> <input
						type="number" class="form-control" name="projectId" id = "projectId" hidden="true"
						value="${projectId}" >
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Estimate Name : </label>
				<div class="form-group mx-sm-3 mb-2">
					<input type="text" class="form-control" id="estimateName" value = "${estimateName}"
						readonly="readonly">
				</div>
			</div>
				<div class="form-group row">
				<label class="col-sm-2 col-form-label">Description : </label>
				<div class="form-group mx-sm-3 mb-2">
					<textarea class="form-control" id="description" name = description rows="4" cols="70"
						>${description}</textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">Service Name :</label>
				<div class="form-group mx-sm-3 mb-2">
					<select class="form-control" id="service" 
						required="required" onchange="loadTechnology()">
						<option value="0" selected="selected">--SELECT--</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="technologyName" class="col-sm-2 col-form-label">Technology
					Name :</label>
				<div id="showTasks" style="font-weight: bold;">Not Available</div>
				<table id="taskTable" class="table"
					style="display: none;">
					<thead class="thead-dark">
						<tr>
							<th><input type="checkbox" name="checkAll" id="checkAll"></th>
							<th>Technology Name</th>
							<th>No. Of RU's</th>
							<th>Effort(Phrs)</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<button type="Submit" class="btn btn-primary"
				onclick="saveEstimates()">Submit</button>
			<button type="button" class="btn btn-warning center"
				onclick="location.href = '/viewEstimates?projectId=${projectId}&projectName=${projectName}';">Back</button>
			<div class="form-group row">
				<label for="details" class="col-sm-2 col-form-label">Available
					Estimations : </label>
				<table class="table " id="dynTable">
					<thead class="thead-dark">
						<tr>
							<th>Service Name</th>
							<th>Technology Name</th>
							<th>RU</th>
							<th>Effort</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${results}" var="item">
						<tr>
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
	</div>

</body>
</html>