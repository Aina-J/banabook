<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><tiles:insertAttribute name="title"/></title>
	
	<link rel="stylesheet" href="resources/css/contents.css">
	<link rel="stylesheet" href="resources/css/footer.css">
	
</head>
<body>

	<div class="header">
		<tiles:insertAttribute name="header"/>
	</div>

	<div class="contents">
		<tiles:insertAttribute name="aside"/>
		<tiles:insertAttribute name="contents"/>
	</div>
 
	<div class="footer">
		<tiles:insertAttribute name="footer"/>
	</div>

</body>
</html>