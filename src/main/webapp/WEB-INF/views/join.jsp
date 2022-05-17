<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="resources/css/join.css">
</head>
<body>

	<div class="box">

    <h2>회원가입</h2>

    <hr>

    <div>아이디</div>
    <input class="sec" type="text" name="id"><br>

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

    <input class="join_button" type="submit" name="join" value="회원가입">

  </div>

</body>
</html>