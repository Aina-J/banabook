<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/join.css">

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script>

</script>

<div class="box">
	
	<h2>회원가입</h2>
	
	<hr>
	
	<form action="/member/joinConfirm" method="post" id="join_form">
	<div>아이디</div>
	<input class="sec" type="text" name="id"><br>
	
	<div>비밀번호</div>
	<input class="sec" type="password" name="pw"><br>
	
	<div>비밀번호 확인</div>
	<input class="sec" type="password" name="pw_check"><br>
	
	<div>이름</div>
	<input class="sec" type="text" name="name"><br>
	
	<div>전화번호</div>
	<input class="sec" type="tel" name="tel"><br>
	
	<div>주소</div>
	<input class="sec" type="text" name="addresss"><br>
	
	<div>생년월일</div>
	<input class="sec" type="date" name="birth"><br>
	
	<input class="join_button" type="submit" name="join" value="회원가입">
	</form>
 </div>