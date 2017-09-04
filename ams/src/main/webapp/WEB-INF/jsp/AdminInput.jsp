<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Admin Panel</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/update.css"/>">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<!-- <h1>Hello, world!</h1> -->
	<div class="bg">
		<nav
			class="w3-panel w3-card-4 navbar navbar-toggleable-md navbar-inverse"
			style="background-color: none; margin: 2px 0 2px 0; padding: 3px 0 3px 0;">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="#" style="padding-left: 80px;">AMS</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="homepage">Home <span class="sr-only">(current)</span></a></li>

					<li class="nav-item active">
						<div class="navbar-brand" style="padding-left: 80px;">${user.username}</div>
					</li>
				</ul>
				<a href="logout"><button class="btn-change7" type="button"
						data-target="#loginModal" data-toggle="modal">Logout</button></a>
				<c:url var="noti" value="/getNotification" />
				<a href="${noti}"><button class="btn-change8" type="button">Noti</button></a>
			</div>
		</nav>
		<div class="main-name w3-panel w3-card">
			<h1>Admin Panel</h1>
			<center>
				<div class="underline"></div>
			</center>

			<div class="update">
				<a href="form"><button class="update-button">ADD AQI
						DETAILS</button>
					<br></a> <a href="addscl"><button class="update-button">ADD
						NEW LOCATION</button>
					<br></a> <a href="search"><button class="update-button">VIEW
						AIR QUALITY</button></a>
			</div>
		</div>
	</div>
	<footer class="footer">
		<p style="font-size: 4vw;">
			<img src="<c:url value="/resources/images/tata.png" />"
				style="width: 13%;"> CONSULTANCY SERVICES
		</p>
		<p>Copyright @2017 Tata Consultancy Services</p>
	</footer>
	<!-- jQuery first, then Tether, then Bootstrap JS. -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>
</body>
</html>