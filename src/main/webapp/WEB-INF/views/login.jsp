<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.js"></script>
<script>
  $(function() {
    bind();
  });

  function bind() {
    $('input[name=login]:first').off('click').on('click', e => {
      console.log(sha256($('input[name=pwd]').val()));
    });
  }
</script>

<div class="box">

    <div>아이디</div>
    <input class="box_id" type="text" name="id"><br>

    <div>비밀번호</div>
    <input class="box_pw" type="password" name="pwd"><br>

    <input class="button" type="submit" name="login" value="로그인">

</div>