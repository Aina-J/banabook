<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/header.css">

<div class="logo_sec">
	<a href="${contextPath}/main"><img class="logo" src="${contextPath}/resources/img/logo.png" alt="로고"></a>
</div>
<div class="navi_sec">
	<ul>
	   	<li><a href="${contextPath}/login/loginForm">LOGIN</a></li>
	   	<li><a href="${contextPath}/join/joinMenu">JOIN</a></li>
	   	<li><a href="#">MY PAGE</a></li>
	   	<li><a href="#">CART</a></li>
	   	<li><a href="#">ORDER</a></li>
	   	<li><a href="#">Q & A</a></li>
	</ul>
</div>