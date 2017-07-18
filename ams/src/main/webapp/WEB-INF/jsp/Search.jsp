<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
	<head> 
		<title>My first chart using FusionCharts Suite XT</title> 
		<script type="text/javascript" src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script> 
		<script type="text/javascript" src="http://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.fint.js?cacheBust=56"></script> 
		
		<script type="text/javascript"> 
			FusionCharts.ready(function(){
				var fusioncharts = new FusionCharts({ 
					type: 'column2d', 
					renderAt: 'chart-container-for-conc', 
					id: 'myChart1', 
					width: '500', 
					height: '300', 
					dataFormat: 'json', 
					dataSource: {
						"chart": { 
							"caption": "concentration of Pollutants", 
							"subcaption": "${airQuality.state}", 
							"xaxisname": "pollutant", 
							"yaxisname": "Concentration", 
							"numberprefix": "", 
							"theme": "fint" 
						}, 
						
						"data": 
							[{ "label": "pm10", "value": "${airQuality.pm10}" }, 
							{ "label": "pm2dot5", "value": "${airQuality.pm2dot5}" }, 
							{ "label": "no2", "value": "${airQuality.no2}" }, 
							{ "label": "o3", "value": "${airQuality.o3}" },
							{ "label": "co", "value": "${airQuality.co}" },
							{ "label": "so2", "value": "${airQuality.so2}" },
							{ "label": "so2", "value": "${airQuality.nh3}" },
							{ "label": "so2", "value": "${airQuality.pb}" }]
					} 
				} ); 
				
				fusioncharts.render();
				
				var fusioncharts2 = new FusionCharts({ 
					type: 'line', 
					renderAt: 'chart-container-for-AQI', 
					id: 'myChart2', 
					width: '500', 
					height: '300', 
					dataFormat: 'json', 
					dataSource: {
						"chart": { 
							"caption": "AQI for past 5 days", 
							"subcaption": "${airQuality.state}", 
							"xaxisname": "dates", 
							"yaxisname": "AQI", 
							"showValues": "0", 
							"theme": "fint" 
						}, 
						
						"data": 
							[{ "label": "${airQuality.date.get(0)}", "value": "${airQuality.dateAqi.get(airQuality.date.get(0))}"},
								{ "label": "${airQuality.date.get(1)}", "value": "${airQuality.dateAqi.get(airQuality.date.get(1))}" },
								{ "label": "${airQuality.date.get(2)}", "value": "${airQuality.dateAqi.get(airQuality.date.get(2))}" },
								{ "label": "${airQuality.date.get(3)}", "value": "${airQuality.dateAqi.get(airQuality.date.get(3))}" },
								{ "label": "${airQuality.date.get(4)}", "value": "${airQuality.dateAqi.get(airQuality.date.get(4))}" }]
					} 
				} ); 
				
				fusioncharts2.render();
				}); 
			</script> 
		</head> 
		<body> 
			<div id="chart-container-for-conc">FusionCharts XT will load here!</div>
			<div id="chart-container-for-AQI">FusionCharts XT will load here!</div> 
			
		</body> 
	</html>
