<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Patient Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-patient">New Patient</a></li>
					<li><a href="all-patients">All Patients</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to hospital registration page</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_TASKS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>Registered patients</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Patient Name</th>
								<th>Doctor Name</th>
								<th>Room Number</th>
								<th>Aditional comment</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="patient" items="${registeredPatients}">
								<tr>
									<td>${patient.id}</td>
									<td>${patient.patient_name}</td>
									<td>${patient.doctor_name}</td>
									<td>${patient.room_number}</td>
									<td>${patient.aditional_comment}</td>
									<td><a href="update-patient?id=${patient.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete-patient?id=${patient.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Patients</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-patient">
					<input type="hidden" name="id" value="${patient.id}"/>
					<div class="form-group">
						<label class="control-label col-md-3">Patient`s name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="patient_name" value="${patient.patient_name}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Doctor`s Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="doctor_name" value="${patient.doctor_name}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Room Number</label>
						<div class="col-md-7">
							<input type="number" class="form-control" name="room_number" value="${patient.room_number}"/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Aditional Comment</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="aditional_comment" value="${patient.aditional_comment}"/>
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_OK'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Operation is successfull</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_ERROR'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Oops! Something went wrong</h1>
				</div>
			</div>
		</c:when>
	</c:choose>

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>