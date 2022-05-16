<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="header"/>
	
	<tiles:insertAttribute name="content"/>
	
	<tiles:insertAttribute name="footer"/>
</body>
</html>