<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/header_seller.css">

<div class="logo_sec">
	<a href="${contextPath}/seller_info_admin"><img class="logo" src="${contextPath}/resources/img/logo.png" alt="로고"></a>
</div>
<div class="seller_login">
	<div>
	
		<div class="seller_user">
			<span>${id}</span> 님 반갑습니다.
		</div>
		
		<hr style="border: solid 1px #173153; margin: 10px 0;">
		<a href="${contextPath}/member/logOut">관리자 로그아웃</a>
	</div>
</div>