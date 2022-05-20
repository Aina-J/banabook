<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.js"></script>

	<script>
	$(document).ready(function(){
		//회원가입 버튼(회원가입 기능 작동)
		$(".join_button").click(function(){
			
			if($("input[name='id']").val() == "" || $("input[name='id']").val() == null ||
				$("input[name='pw']").val() == "" || $("input[name='pw']").val() == null ||
				$("input[name='pw_check']").val() == "" || $("input[name='pw_check']").val() == null ||
				$("input[name='com_name']").val() == "" || $("input[name='com_name']").val() == null ||
				$("input[name='cr_no']").val() == "" || $("input[name='cr_no']").val() == null ||
				$("input[name='name']").val() == "" || $("input[name='name']").val() == null ||
				$("input[name='tel']").val() == "" || $("input[name='tel']").val() == null ||
				$("input[name='address']").val() == "" || $("input[name='address']").val() == null ||
				$("input[name='birth']").val() == "" || $("input[name='birth']").val() == null)
			{
				alert('모든 내용을 입력해주세요.');
				return;
			} else if($("input[name='pw']").val() != $("input[name='pw_check']").val()){
				alert('비밀번호 확인이 일치하지 않습니다.');
				return;
			} else {
			let encrypt = sha256($("input[name='pw']").val());
			let encrypt_check = sha256($("input[name='pw_check']").val());
			$("input[name='pw']").val(encrypt);
			$("input[name='pw_check']").val(encrypt_check);
	 		$("#join_form").attr("action", "/web/seller/joinConfirm");
	 		$("#join_form").submit();
			} 
		})
	});
  </script>

	<link rel="stylesheet" href="${contextPath}/resources/css/join_seller.css">

	<div class="box">
	
	    <h2>판매자 회원가입</h2>
	
	    <hr>
	    
		<form method="post" id="join_form">
	    <div>아이디</div>
	    <input class="sec" type="text" name="id"><br>
	
	    <div>비밀번호</div>
	    <input class="sec" type="password" name="pw"><br>
	
	    <div>비밀번호 확인</div>
	    <input class="sec" type="password" name="pw_check"><br>
	
	    <div>사업장명</div>
	    <input class="sec" type="text" name="com_name"><br>
	
	    <div>사업자 번호</div>
	    <input class="sec" type="tel" name="cr_no"><br>
	
	    <div>사업자 이름</div>
	    <input class="sec" type="text" name="name"><br>
	
	    <div>사업장 주소</div>
	    <input class="sec" type="text" name="address"><br>
	
	    <div>전화번호</div>
	    <input class="sec" type="tel" name="tel"><br>
	
	    <div>생년월일</div>
	    <input class="sec" type="date" name="birth"><br><br><br>
	    ※ 가입 승인까지 기간이 소요됩니다. ※ <br>
	
	    <input class="join_button" name="join" value="가입신청">
	    </form>
	    
	</div>
