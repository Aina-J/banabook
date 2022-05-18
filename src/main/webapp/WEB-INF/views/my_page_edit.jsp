<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/my_page_edit.css">

<div class="box">

    <h2>회원정보수정</h2>

    <hr>

    <div>아이디</div>
    <div style="font-weight: 400;">user</div><br>

    <div>비밀번호</div>
    <input class="sec" type="password" name="pwd"><br>

    <div>비밀번호 확인</div>
    <input class="sec" type="password" name="pwd"><br>

    <div>이름</div>
    <input class="sec" type="text" name="name"><br>

    <div>전화번호</div>
    <input class="sec" type="tel" name="mytel"><br>

    <div>주소</div>
    <input class="sec" type="text" name="addr"><br>

    <div>생년월일</div>
    <input class="sec" type="date" name="birthday"><br>

    <input class="join_button" type="submit" name="join" value="회원정보수정">

</div>