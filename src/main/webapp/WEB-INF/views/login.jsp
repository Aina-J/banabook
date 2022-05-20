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
      
      /**************************************/
      console.log($('input[name=id]').val());
      let id = $('input[name=id]').val();
      let pw = $('input[name=pwd]').val();
      if(id == '' || pw == ''){
    	  alert("아이디 또는 비밀번호를 입력해주세요.");
    	  document.location.href='${contextPath}/login/loginForm';
      }else{
			$(function(){
				let url = "http://localhost:8080/web/member/loginConfirm";
  				
  				let data = {
  					id: id,
  					password: sha256(pw)
  				}
  				
  				$.ajax({
  					url: url,
  					type: "post",
  					contentType: "application/json",
  					data: JSON.stringify(data),
  					success : function(data){
  						console.log("login 확인");
  						document.location.href='${contextPath}/main';
  					},
  					fail : function(data){
  						console.log("fail, ", data);
  					},
  					complete: function(data){
  						console.log("comp", data);
  					}
  				})
  			});
      }
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