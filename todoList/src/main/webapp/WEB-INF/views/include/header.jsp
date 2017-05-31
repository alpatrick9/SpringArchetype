<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Spring MVC - TODO list</title>

<link href="<c:url value="/css/styles.css"/>" rel="stylesheet">
<link href="<c:url value="/css/bootstrap/bootstrap.css"/>" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"/>">

</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/secure/"/>">Spring MVC Todo list</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li id="home-menu"><a href="<c:url value="/secure/"/>">Home</a></li>
					<li id="admin-menu"><a href="<c:url value="/secure/users"/>">Admin</a></li>
				</ul>
				<div id="logout">
					<a href="<c:url value="/logout"/>">Déconnecter</a>
					<div>Session de ${sessionScope.username }</div>
				</div>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<div class="container">