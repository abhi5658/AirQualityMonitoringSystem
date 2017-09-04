<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>
<!-- Bootstrap CSS -->
<spring:url value="/resources/css/index.css" var="indexCSS" />
<spring:url
	value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	var="bootstrapCSS" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous" />
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
				<c:if test="${!empty userType}">
					<div class="navbar-brand" style="padding-left: 80px;">${user.username}</div>
				</c:if>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<!--   <a class="nav-link" href="registerForm">Sign Up <span class="sr-only">(current)</span></a> -->
					</li>
				</ul>

				<c:if test="${empty userType}">
					<a href="registerForm"><button class="btn-change7"
							type="submit">Sign Up</button></a>
					<a href="#"><button class="btn-change8" type="button"
							data-target="#loginModal" data-toggle="modal">Login</button></a>
				</c:if>

				<c:if test="${!empty userType}">
					<c:set var="userType" value="${userType}" />

					<c:set var="user" value="user" />
					<c:set var="admin" value="admin" />

					<c:if test="${userType eq  user}">
						<a href="search"><button class="btn-change7" type="submit">Search</button></a>
					</c:if>
					<c:if test="${userType eq  admin}">
						<a href="adminInput"><button class="btn-change7" type="submit">Menu</button></a>
					</c:if>
					<c:url var="logout" value="/logout" />
					<a href="${logout}"><button class="btn-change7" type="button">Logout</button></a>
					<c:url var="noti" value="/getNotification" />
					<a href="${noti}"><button class="btn-change8" type="button">Noti</button></a>

				</c:if>

			</div>
		</nav>
		<div class="modal fade" id="loginModal" role="dialog">
			<div class="modal-dialog modal-md">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Login</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<!-- Nav tabs -->

						<ul class="nav nav-tabs" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#login" role="tab">Login</a></li>
							<li class="nav-item"><a class="nav-link" data-toggle="tab"
								href="#register" role="tab">Admin Login</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content" style="padding-top: 20px;">
							<div class="tab-pane active" id="login" role="tabpanel">
								<form:form method="post" action="userLogin">
									<label for="inputEmail" class="sr-only">Email ID</label>
									<form:input type="text" path="username" id="inputEmail"
										class="form-control" placeholder="Email ID" required="true" />

									<label for="inputPassword" class="sr-only">Password</label>
									<form:input type="password" path="password" id="inputPassword"
										class="form-control" placeholder="Password" name="password"
										required="true" />
									<br>
									<a href="#">Forgot Password?</a>
									<input type="submit" value="Sign in">
								</form:form>
							</div>
							<div class="tab-pane" id="register" role="tabpanel">
								<form:form method="get" action="admininput">
									<label for="inputEmail" class="sr-only">User name</label>
									<form:input type="text" path="username" id="inputEmail"
										class="form-control" placeholder="User name" required="true" />

									<label for="inputPassword" class="sr-only">Password</label>
									<form:input type="password" path="password" id="inputPassword"
										class="form-control" placeholder="Password" name="password"
										required="true" />
									<br>
									<a href="#">Forgot Password?</a>
									<input type="submit" value="Sign in">
								</form:form>
							</div>
						</div>



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>

		<!--displaying message -->
		<div>
			<h6 align="center">
				<span style="color: maroon"><%=(session.getAttribute("message") == null) ? "" : (session.getAttribute("message"))%></span>
			</h6>
			<%
				if (session.getAttribute("message") != "") {
					session.setAttribute("message", null);
				}
			%>
		</div>


		<div class="main-name">
			<p>Air Monitoring System</p>
			<section id="section04" class="demo">
				<a href="#content1"><span></span></a>
			</section>
		</div>
	</div>
	<div class="content" id="content1" style="text-align: justify;">
		<h1>AQI</h1>
		<br>
		<h3>
			<strong>What is AQI?</strong>
		</h3>
		<h6>An air quality index is defined as an overall scheme that
			transforms the weighed values of individual air pollution related
			parameters (for example, pollutant concentrations) into a single
			number or set of numbers . The result is a set of rules that
			translate parameter values into a more simple form by means of
			numerical manipulation .</h6>
		<h3 style="padding-top: 20px;">
			<strong>How we calculate AQI</strong>
		</h3>
		<h6>
			<strong>Primarily two steps are involved in formulating an
				AQI:</strong><br>
			<br> (i) formation of sub-indices (for each pollutant) and <br>
			<br>(ii) aggregation of sub-indices to get an overall AQI.
			Formation of sub-indices (I<sub>1</sub>, I<sub>2</sub>,...., I<sub>n</sub>)
			for n pollutant variables (X<sub>1</sub>, X<sub>2</sub>...., X<sub>n</sub>)
			is carried out using subindex functions that are based on air quality
			standards and health effects.<br>
			<br> Mathematically:<br>
			<br> I<sub>i</sub>=f(X<sub>i</sub>), i=1, 2,...,n Each sub-index
			represents a relationship between pollutant concentrations and health
			effects. The functional relationship between sub-index value (I<sub>i</sub>)
			and pollutant concentrations (X<sub>i</sub>) is explained later in
			the text. Aggregation of sub-indices, I<sub>i</sub> is carried out
			with some mathematical function to obtain the overall index (I),
			referred to as AQI. I=F(I<sub>1</sub>,I<sub>2</sub>,....,I<sub>n</sub>)
			The aggregation function usually is a summation or multiplication
			operation or simply a maximum operator.
		</h6>
		<h3 style="padding-top: 100px;">
			<strong></strong>
		</h3>
	</div>

	<footer class="footer">
		<p style="font-size: 4vw;">
			<img src="<c:url value="/resources/images/tata.png" />"
				style="width: 13%;"> CONSULTANCY SERVICES
		</p>
		<p>Copyright @2017 Tata Contultancy Services</p>
	</footer>
	<!-- jQuery first, then Tether, then Bootstrap JS. -->
	<spring:url value="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		var="tempCSS" />
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>

	<spring:url
		value="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		var="temCSS" />
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>

	<spring:url
		value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		var="teCSS" />
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
		integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
		crossorigin="anonymous"></script>

</body>
</html>