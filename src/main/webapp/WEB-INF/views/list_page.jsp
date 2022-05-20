<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">

<script>

</script>

<div class="wrap">

	<div class="best_item">
	
		<div class="best_item_ul">
		
		<c:forEach var="productList" items="${productList }">
			<ul class="ul_margin" onclick="location.href='${contextPath}/product/detail?code=${productList.code}'">
				<li><img src='${productList.representative }' alt='이미지'></li>
				<div>
					<li>${productList.name }</li>
					<li>${productList.price }원</li>
				</div>
			</ul>
		</c:forEach>
		
		</div>
	
	</div>

</div>