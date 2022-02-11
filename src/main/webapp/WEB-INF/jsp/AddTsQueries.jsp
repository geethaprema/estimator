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
<title>Queries</title>
<script type="text/javascript">
	$(document).ready(function() {
		loadTrack();
	});

	function loadTrack() {
		$.ajax({
			type : 'POST',
			url : '/loadTrack',
			cache : false,
			success : function(data) {
				var html = '';
				var len = data.length;
				if (len > 0) {
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].question_id + '">'
								+ data[i].question + '</option>';
					}
				} else {
					html += '<option value= 0 >--SELECT-- </option>';
				}
				html += '</option>';
				$('#question').html(html);
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
		<h4>TRANSITION QUERIES</h4>
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
			<form action="/addTSQueries" method="post">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Track Name :</label>
					<div class="form-group mx-sm-3 mb-2">
						<select class="form-control" id="question" name="question_id"
							required="required">
							<option value="0" selected="selected">--SELECT--</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Queries: </label>
					<div class="form-group mx-sm-3 mb-2">
					<textarea class="form-control" name="queries" rows="4" required="required" 
							cols="70"> </textarea>
					</div>
				</div>
				<div class="form-group row">
				<label class="col-sm-2 col-form-label">Answer Type: </label>
				<div class="btn-group btn-group-toggle" data-toggle="buttons" >
					<label class="btn btn-outline-info active"> <input 
						type="radio" name="ansType" id="check"
						value="check" autocomplete="off" checked> Check Box
					</label> <label class="btn btn-outline-info"> <input type="radio" 
						name="ansType" id="text" value="text"
						autocomplete="off"> Description
					</label>
				</div>
			</div>
				<button type="Submit" class="btn btn-primary">Submit</button>
				<button type="button" class="btn btn-warning center"
					onclick="location.href = '/admin';">Back</button>
			</form>
			<div class="form-group row">
				<label for="details" class="col-sm-2 col-form-label">Available
					Queries: </label>
				<table class="table " id="dynTable">
					<thead class="thead-dark">
						<tr>
							<th>Track Name</th>
							<th>Queries</th>
		            		<th>Answer Type</th>
							
							<th>Update Queries</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${results}" var="item">
							<tr>
								<td>${item.question}</td>
								<td>${item.queries}</td>
								<td>${item.ansType}</td>
								
								<td><a type="button" class="btn btn-success"
									href="/editTSQueries?question_id=${item.question_id}&query_id=${item.query_id}">Edit
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>