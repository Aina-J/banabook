<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="src/main/webapp/resources/css/login.css">
</head>
<body>

	<div class="box">

	    <div>아이디</div>
	    <input class="box_id" type="text" name="id"><br>
	
	    <div>비밀번호</div>
	    <input class="box_pw" type="password" name="pwd"><br>
	
	    <input class="button" type="submit" name="login" value="로그인">

	</div>

</body>
</html>