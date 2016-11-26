<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="images/favicon.ico">
	<title>CS472 TwitterBar Project</title>
	<meta name="keywords" content="TwitterBar, Web Programming, MUM, WAP Project, WAP, goole map, google infowindow, twitter4j, twitter REST API, web service" />
	<meta name="description" content="TwitterBar project is a web based application. It uses twitter REST API to fetch the latest tweets from the search query and closest trends on the google map according to the current location and also based in the location selected(clicked) on google map." />
	<link href="css/stylesheet.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery.1.7.2.min.js" type="text/javascript"></script>
	<script src="js/jquery.cookie.js" type="text/javascript"></script>
	<script src="js/myscript.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<header class="header">
		<h1><a href="tweets"><span>CS472</span> TwitterBar</a></h1>
		<button class="icon" id="menuIcon">&#9776;</button>
		<ul class="menu" id="myTopnav">
			<li><a href="tweets" title="Tweets">Tweets</a></li>
			<!-- <li><a href="trends" title="Map">Map</a></li> -->
			<li><a href="trends" title="Trends">Trends</a></li>
		</ul>
		<div class="clear"></div>
		</header>