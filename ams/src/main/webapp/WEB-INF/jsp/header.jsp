<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<html lang="en">
<head>
    <meta charset="utf-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <spring:url value="/resources/css/index.css" var="indexCSS" />
    <spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" var="bootstrapCSS" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   
    <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>

<nav class="navbar navbar-toggleable-md navbar-inverse" style="background-color: none;">
         
          <a class="navbar-brand" href="#" style="padding-left: 80px;">AMS</a>
          <c:if test="${!empty userType}">
		  	<div class="navbar-brand"  style="padding-left: 80px;">${user.username}</div>
          </c:if>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
             <!--   <a class="nav-link" href="registerForm">Sign Up <span class="sr-only">(current)</span></a> -->
            </li>
          </ul>
          
          <c:if test="${empty userType}">
              	<a href="registerForm"><button class="btn-change7" type="submit">Sign Up</button></a>  
          		<a href="#"><button class="btn-change8" type="button" data-target="#loginModal" data-toggle="modal">Login</button></a>
          </c:if>
          
          <c:if test="${!empty userType}">
          	<c:set var="userType" value="${userType}"/>
			<!--         
		   	<c:set var="user" value="user"/>
          	<c:set var="admin" value="admin"/> 
      		--> 
         	<c:if test="${userType eq  user}">
              	<a href="search"><button class="btn-change7" type="submit">Search</button></a>
          	</c:if>
          	<c:if test="${userType eq  admin}">
              	<a href="adminInput"><button class="btn-change7" type="submit">Menu</button></a>
          	</c:if>
          	<c:url var="logout" value="/logout"/>
        	<a href="${logout}"><button class="btn-change8" type="button">Logout</button></a>
          </c:if>
          
        </div>
      </nav>
      
</body>
</html>