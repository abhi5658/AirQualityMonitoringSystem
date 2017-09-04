<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pollution Chart</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Air Quality</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/search.css"/>">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript"
	src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>
<script type="text/javascript"
	src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.fint.js?cacheBust=56"></script>

<script type="text/javascript">
	FusionCharts.ready(function() {
		var sample = '${finalJsondata}';
		//alert("2nd: "+ '${finalJsondata}');

		var fusioncharts1 = new FusionCharts({
			type : 'column2d',
			renderAt : 'chart-container-for-conc',
			id : 'myChart1',
			width : '350',
			height : '300',
			dataFormat : 'json',
			dataSource : {
				"chart" : {
					"caption" : "Concentration of Pollutants",
					"subcaption" : "${airQuality.state}",
					"xaxisname" : "Pollutants---->",
					"yaxisname" : "Concentration",
					"numberprefix" : "",
					"theme" : "fint"
				},

				"data" : [ {
					"label" : "PM10",
					"value" : "${airQuality.pm10}"
				}, {
					"label" : "PM2.5",
					"value" : "${airQuality.pm2dot5}"
				}, {
					"label" : "NO2",
					"value" : "${airQuality.no2}"
				}, {
					"label" : "O3",
					"value" : "${airQuality.o3}"
				}, {
					"label" : "CO",
					"value" : "${airQuality.co}"
				}, {
					"label" : "SO2",
					"value" : "${airQuality.so2}"
				}, {
					"label" : "NH3",
					"value" : "${airQuality.nh3}"
				}, {
					"label" : "Pb",
					"value" : "${airQuality.pb}"
				} ]
			}
		});

		fusioncharts1.render();

		var fusioncharts = new FusionCharts({
			type : 'scrollline2d',
			renderAt : 'chart-container-for-AQI',
			width : '350',
			height : '300',
			dataFormat : 'json',
			dataSource : sample
		});
		fusioncharts.render();
	});
</script>
</head>
<body>
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
			<c:if test="${userType eq  user}">
				<a href="search"><button class="btn-change7" type="submit">Search</button></a>
			</c:if>
			<c:url var="logout" value="/logout" />
			<a href="${logout}"><button class="btn-change7" type="button">Logout</button></a>
			<c:url var="noti" value="/getNotification" />
			<a href="${noti}"><button class="btn-change8" type="button">Noti</button></a>
		</div>
		</nav>
		<div class="w3-panel w3-card-4"
			Style="margin: 5% 10% 5% 10%; padding: 1% 0% 0% 0%;">
			<div class="row">
				<div id="chart-container-for-conc" class="col-sm-6"
					style="padding: 5%;">Loading Concentration...</div>
				<div id="chart-container-for-AQI" class="col-sm-6"
					style="padding: 5%;">Loading AQI...</div>
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
