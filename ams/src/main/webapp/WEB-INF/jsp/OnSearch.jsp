<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>View Air Quality</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/search.css"/>">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
		url="jdbc:postgresql://testnear.cqvriimggiec.ap-south-1.rds.amazonaws.com:5432/AQIDetail"
		user="abhi" password="12345678" />
	<sql:query dataSource="${snapshot}" var="result">
            select * from statemaster;
          </sql:query>
	<sql:query dataSource="${snapshot}" var="cityresult">
            select * from citymaster;
          </sql:query>
	<sql:query dataSource="${snapshot}" var="locationresult">
            select * from locationmaster;
          </sql:query>
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
				<li class="nav-item active"><a class="nav-link" href="homepage">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active">
					<div class="navbar-brand" style="padding-left: 80px;">${user.username}</div>
				</li>
			</ul>
			<!-- <a href="#"><button class="btn-change7" type="submit" disabled="disabled">${user.username}</button></a>-->
			<c:set var="userType" value="${userType}" />
			<c:set var="admin" value="admin" />
			<c:if test="${userType eq  admin}">
				<a href="adminInput"><button class="btn-change7" type="submit">Menu</button></a>
			</c:if>
			<c:url var="logout" value="/logout" />
			<a href="${logout}"><button class="btn-change7" type="button">Logout</button></a>
			<c:url var="noti" value="/getNotification" />
			<a href="${noti}"><button class="btn-change8" type="button">Noti</button></a>
		</div>
		</nav>
		<div class="main-name w3-panel w3-card">
			<h1>Search</h1>
			<center>
				<div class="underline"></div>
			</center>
			<div class="search-table">
				<center>
					<form:form method="post" action="processsearch">
						<table>
							<tr>
								<td>State:</td>
								<td><form:select path="state">
										<c:forEach var="row" items="${result.rows}">
											<form:option value="${row.stateid}">${row.state}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>

							<tr>
								<td>City:</td>
								<td><form:select path="city">
										<c:forEach var="row" items="${cityresult.rows}">
											<form:option value="${row.cityid}">${row.city}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>

							<tr>
								<td>Location:</td>
								<td><form:select path="location">
										<c:forEach var="row" items="${locationresult.rows}">
											<form:option value="${row.locationid}">${row.location}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td style="padding-bottom:0px;">Range(Optional) :</td>
							</tr>
							<tr>
								<td>Start Date:</td>
								<td><form:input path="fromdate" type="date"
										value="2000-01-01" /></td>
							</tr>
							<tr>
								<td>End Date:</td>
								<td><form:input path="todate" type="date"
										value="2000-01-01" /></td>
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