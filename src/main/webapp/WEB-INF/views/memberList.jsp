<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>PASSWORD</th>
				<th>BIRTH</th>
				<th>NAME</th>
				<th>TEL</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="memberList" items="${ memberList }">
				<tr>
					<th>${memberList.id}</th>
					<th>${memberList.password}</th>
					<th>${memberList.birth}</th>
					<th>${memberList.name}</th>
					<th>${memberList.tel}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>