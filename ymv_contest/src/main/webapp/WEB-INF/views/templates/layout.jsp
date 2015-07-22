<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tiles Layout</title>
<script type="text/javascript" src="${initParam.root}resources/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root}css/home.css" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="http://bootswatch.com/cerulean/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- 달력 -->
  <link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" media="all" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"
	type="text/javascript"></script>
</head>
<body>
<div id="container">
	<div id="header"><tiles:insertAttribute name="header" /></div>
	<div id="left"><tiles:insertAttribute name="left" /></div>
	<div id="main"><tiles:insertAttribute name="main" /></div>
	<div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>


