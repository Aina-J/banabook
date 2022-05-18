<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">

    
<div class="wrap">

	<div class="best_item">
	
		<div class="best_item_ul">
		
		<!-- 김나영 @ 22-05-18 (작업완료되면 삭제할 주석입니다.)
			이미지 DB값은 아직 데이터가 없어서 img는 일단 고정입니다.
			DB값 받아와서 화면에 뿌려주는것까지는 확인 완료입니다. -->
		<c:forEach var="productList" items="${productList }">
			<ul class="ul_margin">
				<li><img src="${contextPath}/resources/img/thum/1.jpg" alt="이미지"></li>
				<div>
					<li>${productList.name }</li>
					<li>${productList.price }</li>
				</div>
			</ul>
		</c:forEach>
		
		</div>
	
	</div>

</div>