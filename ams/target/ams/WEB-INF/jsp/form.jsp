<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search for AirQuality</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#states").change(function(){
		alert("fdnjn");
		$.ajax({
			url:"getCityList",
			data: {"state": $("#states").val()},
			success: function(data){
				alert(data);
				var slctSubcat = $("#cities"), option= "";
	            
	            for(var sb =0; sb<data.length; sb++){
	                option = option + "<option value='" + data[sb] + "'>" +data[sb] + "</option>";
	            }
	            alert(option);
	            slctSubcat.append(option);
	            
			}
		});
	});
	
	$("#cities").change(function(){
		alert("fdnjn");
		$.ajax({
			url:"getLocList",
			data: {"state": $("#cities").val()},
			success: function(data){
				alert(data);
				var slctSubcat = $("#locations"), option= "";
	            
	            for(var sb =0; sb<data.length; sb++){
	                option = option + "<option value='" + data[sb] + "'>" +data[sb] + "</option>";
	            }
	            alert(option);
	            slctSubcat.append(option);
	            
			}
		});
	});
});
</script>
</head>
<body>
	
	<h1>"${userType}"</h1>
	
	<c:url value="/search" var="actionUrl"/>
       
       <form:form action="${actionUrl}" modelAttribute="pollutant">
       		<label>state: </label> 
       		<form:select id= "states" path="state">
       			<form:option value="NONE" label="--- Select state ---" />
				<form:options items="${stateList}" />
       		</form:select>
       		<label>city: </label> 
       		<form:select id="cities" path="city">
    			<form:option value="-" label="--Select city--"/>
			</form:select>
       		<label>location: </label> 
       		<form:select id="locations" path="location">
    			<form:option value="-" label="--Select location--"/>    		
       		</form:select>
       		<input type="submit" value="submit"/>
       </form:form>
</body>
</html>