<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.ArrayList"%>
<%
	LinkedHashMap<String,ArrayList<String>> movieId_time
			= (LinkedHashMap<String,ArrayList<String>>)request.getAttribute("showtime");
	HashMap<String,ArrayList<String>> movieInfo 
			= (HashMap<String,ArrayList<String>>)request.getAttribute("movieInfo");
%>
<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>爪蛙免費電影-電影場次</title>
	
	<link
		href="https://fonts.googleapis.com/css?family=Merriweather:300,400|Montserrat:400,700"
		rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	
	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	
	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">
	
	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
		<script src="js/respond.min.js"></script>
		<![endif]-->
	
  </head>
  <style>
	.movie div {
		display: inline-block;
	    vertical-align:top;
	    text-align:left;
	}
	
	.movie {
	    text-align:center;
	    width:95%;
	}
  </style>
  <body>
    <div id="page">
      <%@ include file="header.jsp" %>
      <div class="gtco-container">
        <div class="row">
<%
	if(movieId_time == null || movieInfo == null){
		out.print("data is null.");
	}else{
		for(String movieId:movieId_time.keySet()){
%>
		  <div class="movie">
  			<div><img width="70%" height="70%" src="movie_picture/<%=movieId%>.jpg"></div>
		    <div>
		  	  <h3><%=movieInfo.get(movieId).get(0)%></h3>
		  	  <lu>
		  	    <li>上映日期: <%=movieInfo.get(movieId).get(1) %></li>
		  	    <li>片長: <%=movieInfo.get(movieId).get(2) %></li>
		  	    <li>級數: <%=movieInfo.get(movieId).get(3) %></li>
		  	  </lu>
		  	  <p>
		  	  <div><a href="http://localhost:8080/JavaMovie/movieInfo?id=<%=movieId%>" class="btn btn-sm btn-special">電影介紹</a></div>
		  	  <br><br>
<%
			String date="";
			String time="";
			
			for(String showtime:movieId_time.get(movieId)){
				time=showtime.substring(15, 20);
				if(date.equals(showtime.substring(0, 15))){
					out.print("<label>"+time+" | </label>");
				}else{
					date=showtime.substring(0, 15);
					out.print("<br><label style='color:red'>"+date+"</label><br>"+"<label>"+time+" | </label>");
				}
			}
%>
		    </div>
<%
	}}
%>
          </div><!-- class="movie" -->
        </div><!-- class="row" -->
      </div><!-- class="gtco-container" -->
      
      
      <%@ include file="footer.jsp" %>
    </div><!-- class="page" -->
    <div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
  </body>
</html>