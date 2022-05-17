<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/aside.css">

<div class="aside">
	<ul>
		<li><a href="#">· 소설/시</a></li>
		<li><a href="#">· 에세이</a></li>
		<li><a href="#">· 잡지/매거진</a></li>
		<li><a href="#">· 만화</a></li>
		<li><a href="#">· 어린이</a></li>
		<li><a href="#">· 참고서</a></li>
	</ul>
	<div class="aside_used">
		<a class="used" href="#">중고서적</a>
	</div>
</div>