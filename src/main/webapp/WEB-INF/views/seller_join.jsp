<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.js"></script>


  <script>
    $(function() {
      bind();
    });

    function bind() {
      $('input[name=join]:first').off('click').on('click', e => {
        console.log(sha256($('input[name=pwd]').val()));
      });
    }
  </script>

	<link rel="stylesheet" href="${contextPath}/resources/css/join_seller.css">

	<div class="box">
	
	    <h2>판매자 회원가입</h2>
	
	    <hr>
	
	    <div>아이디</div>
	    <input class="sec" type="text" name="id"><br>
	
	    <div>비밀번호</div>
	    <input class="sec" type="password" name="pwd"><br>
	
	    <div>비밀번호 확인</div>
	    <input class="sec" type="password" name="pwd_confirm"><br>
	
	    <div>사업장명</div>
	    <input class="sec" type="text" name="name"><br>
	
	    <div>사업자 번호</div>
	    <input class="sec" type="tel" name="mytel"><br>
	
	    <div>사업자 이름</div>
	    <input class="sec" type="text" name="name"><br>
	
	    <div>사업장 주소</div>
	    <input class="sec" type="text" name="addr"><br>
	
	    <div>전화번호</div>
	    <input class="sec" type="tel" name="mytel"><br>
	
	    <div>생년월일</div>
	    <input class="sec" type="date" name="birthday"><br><br><br>
	    ※ 가입 승인까지 기간이 소요됩니다. ※ <br>
	
	    <input class="join_button" type="submit" name="join" value="가입신청">
	    
	</div>
