<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

  <link rel="stylesheet" href="${contextPath}/resources/css/my_page_seller.css">

<div class="mypage">

	<div>
		<img src="${contextPath}/resources/img/sellert_banner.jpg" alt="셀러배너">
	</div>

	<h2>판매자 관리 센터</h2>

	<hr style="border: solid 1px #173153;">

	<div class="my_menu">
		<a href="${contextPath}/seller/manageProduct">상품관리</a>
		<a href="${contextPath}/seller/manageReview">리뷰관리</a>
		<a href="${contextPath}/seller/manageInquiry">문의관리</a>
	</div>

</div>