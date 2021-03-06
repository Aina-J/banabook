<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/header.css">

<div class="logo_sec">
 	<c:if test="${ sessionScope.authority_id eq 20 }">
		<a href="${contextPath}/seller_main"><img class="logo" src="${contextPath}/resources/img/logo.png" alt="로고"></a>
	</c:if>
	<c:if test="${ sessionScope.authority_id eq 30 }"> 
		<a href="${contextPath}/main"><img class="logo" src="${contextPath}/resources/img/logo.png" alt="로고"></a>
 	</c:if>
	<c:if test="${ sessionScope.authority_id eq null }">
		<a href="${contextPath}/main"><img class="logo" src="${contextPath}/resources/img/logo.png" alt="로고"></a>
	</c:if> 
</div>
<div class="navi_sec">
	<ul>
		<c:if test="${empty id || id eq ''}">
		   	<li><a href="${contextPath}/login/loginForm">LOGIN</a></li>
		</c:if>
		<c:if test="${not empty id}">
			<li><a href="${contextPath}/member/logOut">LOGOUT</a></li>
		</c:if>
		<c:if test="${empty id || id eq ''}">
	   		<li><a href="${contextPath}/join/joinMenu">JOIN</a></li>
		</c:if>
	   	<li><a href="${contextPath}/general/mypage.do">MY PAGE</a></li>
	   	<!-- <li><a href="#">CART</a></li> -->
	   	<li><a href="${contextPath}/memOrder/orderView.do">ORDER</a></li>
	   	<li><a href="${contextPath}/general/loadInquiry.do">Q & A</a></li>
	</ul>
</div>