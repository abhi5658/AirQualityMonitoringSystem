<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    
    <spring:url value="/resources/css/form1.css" var="form1CSS" />
    <link rel="stylesheet" type="text/css" href="${form1CSS}">
    <style type="text/css">
		#form1{
			color: white;
		}    	
    </style>
    </head>
  <body>
    <!-- <h1>Hello, world!</h1> -->
    <div class="bg">
      <nav class="navbar navbar-toggleable-md navbar-inverse" style="background-color: none;">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#" style="padding-left: 80px;">AMS</a>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <!--  a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a> -->
          </li>
        </ul>
        <a href="#"><button class="btn-change7" type="submit">Search</button></a>
        <c:url var="logout" value="/logout"/>
        <a href="${logout}"><button class="btn-change8" type="button" >Logout</button></a>
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
                    <li class="nav-item">
                      <a class="nav-link active" data-toggle="tab" href="#login" role="tab">Login</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" data-toggle="tab" href="#register" role="tab">Admin Login</a>
                    </li>
                  </ul>

                  <!-- Tab panes -->
                  <div class="tab-content" style="padding-top: 20px;">
                    <div class="tab-pane active" id="login" role="tabpanel">
                      <form action="#" method="post">
                        <label for="inputEmail" class="sr-only">User name</label>
                        <input type="text" id="inputEmail" class="form-control" placeholder="User name" required autofocus name="username" required="true">
                        
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required="true"> 
                        <br>
                        <a href="forgotpassword.php">Forgot Password?</a>
                        <input type="submit" value="Sign in">
                      </form>
                    </div>
                    <div class="tab-pane" id="register" role="tabpanel">
                      <form method="post" action="#">
                        <label for="inputEmail" class="sr-only">User name</label>
                        <input type="text" id="inputEmail" class="form-control" placeholder="User name" required autofocus name="username" required="true">
                        
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required="true"> 
                        <br>
                        <a href="forgotpassword.php">Forgot Password?</a>
                        <input type="submit" value="Sign in">
                      </form>
                        
                    </div>
                  </div>
                          
                              
                  
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
              </div>
              
            </div>
          </div>
      </div>
    </nav>
    <div class="container">
    		<p style="text-align: center;font-size: 2em;color: white;padding-top: 50px;">Enter cardinalities</p>
    </div>
       <form:form method="post" action="save">  
      	
         <div class="container" id="form">
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>PM<sub>10</sub></label>
    			</div>
    			<div class="col-4">
    				<form:input path = "pm10"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>PM<sub>2.5</sub></label>
    			</div>
    			<div class="col-4">
    				<form:input path = "pm2dot5"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>NO<sub>2</sub></label>
    			</div>
    			<div class="col-4">
    				<form:input  path = "no2"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>O<sub>3</sub></label>
    			</div>
    			<div class="col-4">
    				<form:input path = "o3"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>CO</label>
    			</div>
    			<div class="col-4">
    				<form:input path = "co"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>SO<sub>2</sub></label>
    			</div>
    			<div class="col-4">
    				<form:input path = "so2"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>NH<sub>3</sub></label>
    			</div>
    			<div class="col-4">
    				<form:input path = "nh3"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 10px;">
    			<div class="col-4">
    				
    			</div>
    			<div class="col-1">
    				<label>pb</label>
    			</div>
    			<div class="col-4">
    				<form:input path = "pb"/>
    			</div>
    		</div>
    		<div class="row" style="padding-top: 40px;">
    			<div class="col-5">
    				
    			</div>
    			<div class="col-1">
    				<input type="submit" name="">
    			</div>
    			<div class="col-4">
    				
    			</div>
    		</div>
    		<div class="row" style="padding-top: 40px;">
    			<div class="col-5">
    				
    			</div>
    			<div class="col-3">
    				<p style="font-size:1.5em;"><strong>Select location</strong></p>	
    			</div>
    			<div class="col-4">
    				
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-2">
    				
    			</div>
    			<div class="col-3">
	    		
	    		<sql:setDataSource var = "snapshot" driver = "org.postgresql.Driver" 
					url = "jdbc:postgresql://aqidetail.cg0cosijewak.us-west-2.rds.amazonaws.com:5432/AQIDetail"
					user = "abhi"  password = "12345678"/>
				<sql:query dataSource = "${snapshot}" var = "result">
					select * from statemaster;
				</sql:query>
				<sql:query dataSource = "${snapshot}" var = "cityresult">
					select * from citymaster;
				</sql:query>
				<sql:query dataSource = "${snapshot}" var = "locationresult">
					select * from locationmaster;
				</sql:query>
				
				
			    <strong>Select State:</strong> 
			     <form:select path = "state">
					<c:forEach var ="row" items = "${result.rows}">
						<form:option value = "${row.stateid}">${row.state}</form:option>
					</c:forEach>
				</form:select>
			      </div>
			      <div class="col-3">
	    		
			    <strong>Select City:</strong> 
			       <form:select path = "city">
					<c:forEach var ="row" items = "${cityresult.rows}">
						<form:option value = "${row.cityid}">${row.city}</form:option>
					</c:forEach>
				</form:select>
			      </div>
			      <div class="col-3">
	    		
			    <strong>Select Location:</strong> 
			       <form:select path = "location">
					<c:forEach var ="row" items = "${locationresult.rows}">
						<form:option value = "${row.locationid}">${row.location}</form:option>
					</c:forEach>
					</form:select>
			      </div>
			    <div class="col-3">
    				
    			</div>
    		</div>	
    	</div>       
       </form:form>  
       <footer class="footer">
	    <p style="font-size: 40px;"><img src="<c:url value="/resources/images/tata.png" />" style="width: 10%;"> CONSULTANCY SERVICES</p>
	    <p>Copyright @2017 Tata Contultancy Services</p>
	</footer>
	    <!-- jQuery first, then Tether, then Bootstrap JS. -->
	    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	</body>
</html>