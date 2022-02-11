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
<title>Questionnaire</title>
<script type="text/javascript">
	var question = new Array();
	var query = new Array();
	var ans = new Array();
	$(document).ready(function() {
		loadQuestion();
	});
	function loadQuestion() {
		$
				.ajax({
					type : 'GET',
					url : '/loadQuestions',
					cache : false,
					success : function(data) {
						var html = '';
						var len = data.length;
						$('#dynTable tbody').empty();
						if (len > 0) {
							$('#dynTable').show();
							$('#showTasks').hide();
							for (var i = 0; i < len; i++) {
								html = "<tr  class = 'taskRowCls'>"
										+ "<td> <label id='question' for=" + data[i].question_id + ">"
										+ data[i].question
										+ "</label></td>"
										+ "<td> <label id='queries' for=" + data[i].query_id + ">"
										+ data[i].queries + "</label></td>";
								if (data[i].ansType == 'check') {
									html += "<td><input type='checkbox'></td></tr>";
								} else {
									html += "<td><input type='text' value ='NA'></td></tr>";
								}
								$('#dynTable').append(html);
							}
						} else {
							$('#dynTable').hide();
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
	function getAllTechId() {
		question = [];
		query = [];
		ans = [];
		$("tr.taskRowCls")
				.each(
						function() {
							var isChecked = $(this).find(
									'input[type="checkbox"]').prop("checked");
							var textVal = $(this).find('input[type="text"]')
									.val();
							question.push($(this).find('label[id="question"]')
									.attr("for"));
							query.push($(this).find('label[id="queries"]')
									.attr("for"));
							if (typeof textVal === "undefined") {
								if (isChecked) {
									ans.push('yes');
								} else {
									ans.push('no');
								}
							}
							else if(typeof isChecked === "undefined"){
								ans.push($(this).find('input[type="text"]')
										.val());
							}
						});
		console.log(question);
		console.log(query);
		console.log(ans);
	}
	function save() {
		getAllTechId();
		$.ajax({
			type : 'POST',
			url : '/saveQuestionarie',
			cache : false,
			data : {
				'question' : question,
				'query' : query,
				'ans' : ans,
				'projectId' : $('#projectId').val()
			// 						'feedback' : $('#feedback').val(),
			},
			traditional : true,
			cache : false,
			success : function(data) {
				alert(data);
				/* $('#dynTable').hide();
				$('#showTasks').show();
				$('<p>' + data.success + '</p>').appendTo('#showTasks'); */

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
		<h3>ADD QUESTIONNAIRE</h3>
	</div>
	<div class="sidebar">
		<a href="/RegisterNewUser">New User</a><a href="/admin">Admin User</a>
		<a href="/ShowCustomer">Customers</a>
	</div>
	<div class="content">
		<div class="table-responsive" style="height: 90%;">
			<p>Welcome ${userName}</p>
			<div>
				<input type="text" class="form-control" id="projectId"
					id="projectId" value="${projectId}" hidden="true">
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Project Name : </label>
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" class="form-control" id="projectName"
							readonly="readonly" value="${projectName}">
					</div>
				</div>
			</div>

			<div id="showTasks" style="font-weight: bold;">Not Available</div>
			<table class="table" id="dynTable">
				<thead class="thead-dark">
					<tr>
						<th>Track</th>
						<th>Query</th>
						<th>Yes/No</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
		<div style="text-align: center;">
			<!-- 	<div class="form-group row">
				<label class="col-sm-2 col-form-label">Additional Queries? </label>
				<div class="form-group mx-sm-3 mb-2">
					<textarea class="form-control" name="queries" rows="2" id = "feedback"
						required="required" cols="70"> </textarea>
				</div>
			</div> -->
			<button type="button" class="btn btn-success float-left  ml-2"
				onclick="save()">Submit</button>
			<button type="button" class="btn btn-warning float-right ml-2"
				onclick="location.href = '/ShowCustomer';">Back</button>
		</div>
	</div>
</body>
</html>