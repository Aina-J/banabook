<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/qna.css">

  <div class="mypage">

    <h2>문의하기</h2>

    <hr style="border: solid 1px #173153;">

    <div class="write_sec">
      <span>제목</span>
      <input type="text" name="title" placeholder="제목을 입력해 주세요.">
    </div>

    <div class="write_sec_2">
      <span>내용</span>
      <input type="text" name="title" placeholder="내용을 입력해 주세요.">
    </div>

    <div class="edit_bt">
      <input type="submit" value="등록하기"></input>
    </div>

  </div>