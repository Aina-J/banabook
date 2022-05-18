<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/join_menu.css">

<div class="box">

    <h2>가입 종류를 선택해 주세요.</h2>

    <hr>

    <div class="select">
      <a href="javascript:void(0)"><div class="box_select">일반회원가입</div></a>
      <a href="javascript:void(0)"><div class="box_select">판매자 회원가입</div></a>
    </div>

  </div>
