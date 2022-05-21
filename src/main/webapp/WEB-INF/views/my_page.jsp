<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/my_page.css">

<div class="mypage">

    <h2>마이페이지</h2>

    <hr style="border: solid 1px #173153;">

    <div class="my_menu">
      <a href="${contextPath}/general/edit">회원정보수정</a>
      <a href="javascript:void(0)">장바구니</a>
    </div>

    <div class="my_menu">
      <a href="${contextPath}/memOrder/orderView">주문내역</a>
      <a href="${contextPath}/general/loadInquiry">문의내역</a>
    </div>

  </div>