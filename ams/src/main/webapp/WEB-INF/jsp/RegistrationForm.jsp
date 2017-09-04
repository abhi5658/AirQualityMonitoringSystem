<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Sign Up</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/registration.css"/>">
</head>
<body>
	<!-- <h1>Hello, world!</h1> -->
	<div class="bg">
		<nav class="navbar navbar-toggleable-md navbar-inverse"
			style="background-color: none;">
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
				</ul>

				<!--           <a href="#"><button class="btn-change8" type="button" data-target="#loginModal" data-toggle="modal">Login</button></a> -->
			</div>
		</nav>
		<div class="main-name">
			<h1>Sign Up</h1>
			<center>
				<div class="underline"></div>
			</center>
			<div class="registration-table">
				<center>
					<form:form method="post" action="addUser">
						<table>
							<tr>
								<td>Full name:</td>
								<td><form:input type="text" name="full-name"
										placeholder="Full Name" path="fName" /></td>
							</tr>

							<tr>
								<td>E-mail:</td>
								<td><form:input type="email" name="user-email"
										placeholder="E-mail Address" path="email" /></td>
							</tr>

							<tr>
								<td>Password:</td>
								<td><form:input type="password" name="user-password"
										placeholder="Password" path="password" /></td>
							</tr>

							<tr>
								<td>Street Address</td>
								<td><form:input type="text" name="location"
										placeholder="Location" path="location" /></td>
							</tr>
							<tr>
								<td>City:</td>
								<td><form:input type="text" name="city" placeholder="City"
										path="city" /></td>
							</tr>

							<tr>
								<td>State:</td>
								<td><form:input type="text" name="state"
										placeholder="State" path="state" /></td>
							</tr>



							<tr>
								<td colspan="2"><input type="submit" value="Submit"
									name="submit"></td>
							</tr>
						</table>
					</form:form>
				</center>
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