<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet"
	href="${contextPath}/resources/css/item_seller.css">
<script>

	$(function() {
		init();
   	})
   
   	function init() {
		   insertCheck();
   	}
	
	function insertCheck(){
		if("${message}" == "empty"){
			console.log("initial page")
		} else if("${message}" == "success"){
			alert('상품 등록에 성공하였습니다.');
		} else if("${message}" == "error"){
			alert('상품 등록에 실패하였습니다.');
		}
	}
	
	
	$(document).ready(function(){

	//상품 등록 버튼 클릭 이벤트
	$(".upload").click(function(){
		
		if($("input[name='name']").val() == "" || $("input[name='name']").val() == null ||
			$("input[name='price']").val() == "" || $("input[name='price']").val() == null ||
			$("input[name='representative']").val() == "" || $("input[name='representative']").val() == null ||
			$("input[name='details']").val() == "" || $("input[name='details']").val() == null)
		{
			alert("모든 내용을 입력해주세요.");
			return;
		}  else  {
 		$("#upload").attr("action", "/web/seller/uploadProduct");
 		$("#upload").submit();
		} 
	})
});

</script>
<div class="mypage">

	<h2>상품관리</h2>

	<hr style="border: solid 1px #173153;">

	<div class="table_wrap">
		<table>

			<thead>
				<tr>
					<th>카테고리</th>
					<th>상품명</th>
					<th>가격</th>
					<th>대표이미지</th>
					<th>상세이미지</th>
					<th>등록</th>
				</tr>
			</thead>

			<tbody>
				<form method="POST" id="upload">
					<tr>
						<td><select name="code">
								<option value="novel" selected>소설/시</option>
								<option value="essay">에세이</option>
								<option value="magazine">잡지/매거진</option>
								<option value="comic">만화</option>
								<option value="kid">어린이</option>
								<option value="reference">참고서</option>
						</select></td>
						<td><input class="item_name" type="text" name="name" placeholder="상품명을 입력해주세요"></td>
						<td><input class="item_name" type="text" name="price" placeholder="판매가격을 입력해주세요"></a></td>
						<td><input class="item_name" type="text" name="representative" placeholder="대표 이미지의 링크를 입력해주세요"></td>
						<td><input class="item_name" type="text" name="details"	placeholder="상세 이미지 링크를 입력해주세요"></td>
						<!-- 등록버튼 -->
						<td><input class="upload"
							style="width: 60px; height: 30px; cursor: pointer; text-align:center; background-color: #173153; border: #173153; border-radius: 5px; color: #fff;"
							value="등록"></td>
					</tr>
				</form>
			</tbody>
		</table>
	</div>
</div>