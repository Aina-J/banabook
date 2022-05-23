<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/qna_list.css">
<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">
<link rel="stylesheet" href="${contextPath}/resources/css/sellerinfo_admin.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<div class="mypage">

  <h2>판매자 승인 관리</h2>

  <hr style="border: solid 1px #173153;">

  <div class="table_wrap">
    <table>
    	<thead>
          <tr>
            <th>아이디</th>
            <th>사업장</th>
            <th>사업자</th>
            <th>승인여부</th>
            <th>승인확인</th>
          </tr>
        </thead>
      <tbody>
          <c:forEach var="item" items="${members.data}">
	        <tr>
	          <td>${item.id}</td>
	          <td>${item.address}</td>
	          <td>${item.com_name}</td>
	          <td>
	            <label><input type="radio" name="chk_info" value="o"> 승인</label>
	            <label><input type="radio" name="chk_info" value="x"> 미승인</label>
	          </td>
	          <!-- 등록버튼 -->
	          <td>
	            <input style="width:60px; height: 30px; 
	            cursor: pointer;
	            background-color: #173153; 
	            border: #173153; 
	            border-radius: 5px; 
	            color: #fff;" type="submit" value="확인">
	          </td>
	        </tr>
      	</c:forEach>
      	</tbody>
    </table>



    <!-- 페이징 -->

    <div class="item_page">
      <div class="item_sec">
      
   		<c:if test="${item.pre}">
   			<a href="javascript:void(0)"><img class="arrow_b_r" src="${contextPath}/resources/img/arrow_b_l.png" alt="페이지왼쪽화살표"></a>
   		</c:if>
      	<c:forEach var="item" begin="${members.beginPage}" end="${members.endPage}">
      		<c:set var="i" value="${i+1 }"></c:set>
				<a href="http://localhost:8080/web/seller_info_admin?page=${i }">${i }</a>
      	</c:forEach>
      	
   		<c:if test="${item.next}">
   			<a href="javascript:void(0)"><img class="arrow_b_r" src="${contextPath}/resources/img/arrow_b_r.png" alt="페이지오른쪽화살표"></a>
   		</c:if>
   		
      </div>
    </div>

  </div>

</div>