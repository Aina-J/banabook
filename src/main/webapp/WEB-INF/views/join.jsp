<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/join.css">

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js">
</script>
<script>

$(document).ready(function(){

	//회원가입 버튼(회원가입 기능 작동)
	$(".join_button").click(function(){
		
		if($("input[name='id']").val() == "" || $("input[name='id']").val() == null ||
			$("input[name='pw']").val() == "" || $("input[name='pw']").val() == null ||
			$("input[name='pw_check']").val() == "" || $("input[name='pw_check']").val() == null ||
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
		} /* else if(${errorMsg} != null || ${errorMsg} == "true"){
			alert('중복된 아이디가 있습니다.');
			return;
		} */ else  {
		let encrypt = sha256($("input[name='pw']").val());
		let encrypt_check = sha256($("input[name='pw_check']").val());
		$("input[name='pw']").val(encrypt);
		$("input[name='pw_check']").val(encrypt_check);
 		$("#join_form").attr("action", "/web/general/joinConfirm");
 		$("#join_form").submit();
		} 
	})
});

</script>

<div class="box">
	
	<h2>회원가입</h2>
	
	<hr>
	
	<form method="post" id="join_form">
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
	<input class="sec" type="text" name="address"><br>
	
	<div>생년월일</div>
	<input class="sec" type="date" name="birth"><br>
	
	<input class="join_button" name="join" value="회원가입">
	</form>
 </div>