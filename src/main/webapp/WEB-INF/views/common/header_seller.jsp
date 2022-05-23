<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/header_seller.css">

<div class="logo_sec">
	<a href="${contextPath}/main"><img class="logo" src="${contextPath}/resources/img/logo.png" alt="로고"></a>
</div>
<<<<<<< Updated upstream
    <div class="seller_login">
      
      <div>	

        <div class="seller_user">
          <span>${id}</span> 님 반갑습니다.
		<c:if test="${not empty id}">
			<a href="${contextPath}/member/logOut" style="padding: 5px; margin-left: 20px;">LOGOUT</a>
		</c:if>
        </div>
        <hr style="border: solid 1px #173153; margin: 10px 0;">
        <a href="${contextPath}/seller/mypage">판매자 관리센터</a>
      </div>

    </div>
=======
<div class="seller_login">
	<div>
	
		<div class="seller_user">
			<span>${id}</span> 님 반갑습니다.
		</div>
		
		<hr style="border: solid 1px #173153; margin: 10px 0;">
		<a href="${contextPath}/seller/mypage">판매자 관리센터</a>
	</div>
</div>
>>>>>>> Stashed changes
