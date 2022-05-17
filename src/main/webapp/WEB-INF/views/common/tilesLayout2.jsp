<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" type="image/x-icon" href="${contextPath}/resources/img/favicon.png">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400&display=swap" rel="stylesheet">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<div class="header">
		<tiles:insertAttribute name="header"/>
	</div>

	<tiles:insertAttribute name="content"/>
 
	<div class="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>