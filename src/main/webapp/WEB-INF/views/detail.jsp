<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/contents.css">
<link rel="stylesheet" href="${contextPath}/resources/css/detail_page.css">
<link rel="stylesheet" href="${contextPath}/resources/css/table_paging.css">

<script>
	$(function() {
		init();
	})
	
	function init() {
		ajaxReviewList();
	}
	
	function ajaxReviewList() {
		let url = "http://localhost:8080/web/reviewApi/reviewApi/novel_1";
		api(url, "get", null, fnSucc);
	}
	
	function api(url, method, data, fnSucc, fnFail, fnComplete){
		
	    let option = {
	        "url": url,
	        "type": method,
	        "contentType": "application/json; charset=utf-8;",
	        "dataType": "json"
	    }
	    
	    if(data != undefined) {
	        option.data = data;
	    }
	    if(typeof fnSucc == "function") {
	        option.success = fnSucc;
	    }
	    if(fnFail) option.fail = fnFail;
	    if(fnComplete) option.complete = fnComplete;
	        
	    $.ajax(option);
	}
	
	function fnSucc(data) {
		console.log(JSON.stringify(data));
		let html = "";
		
		if(data != null) {
			// 돔 비우기
			$('.review_sec').html("");
			// 돔 만들기
			
			
			html += "<h2>review</h2>";
			html += "<table border=\"1\"> ";
			html += "	<thead> ";
			html += "		<tr>";
			html += "			<th>제목</th>";
			html += "			<th>작성자</th>";
			html += "			<th>작성일</th>";
			html += "		</tr>";
			html += "	</thead>";
			html += "	<tbody>";
			
			for(let i = 0; i < data.length; i++) {
				
				html += "		<tr>";
				html += "			<td class=\"title" + i + "\""+"><a href=\"javascript:void(0)\" onclick=\"openContent('" + i + "')\">" + data[i].title + "</a></td>";
				html += "			<td>" + data[i].id + "</td>";
				html += "			<td>" + data[i].write_date + "</td>";
				html += "		</tr>";
				html += "		<tr class=\"content content" + i +"\""+">";
				html += "			<td colspan='3'>" + data[i].content + "</td>";
				html += "		</tr>";
				
				
			}
			html += "	</tbody>";
			html += "</table>";
			
		    $('.review_sec').append(html);
		}
	}
	
	
</script>

<div class="thum">
      <img src="${dto.representative}" alt="미드나잇">

      <div class="item_info">

        <ul>
          <div class="good_bt">
            <img src="${contextPath}/resources/img/good_a.png" alt="좋아요버튼">
          </div>

          <li>${dto.name}</li>
          <li>${dto.price}</li>
          <li>수량</li>
          <li><input type="number" name="quantity" min="1" max="99" step="1" value="1"></li>
        </ul>

        <div class="cart_buy">
          <input class="cart" type="submit" value="장바구니">
          <input class="buy" type="submit" value="바로구매">
        </div>
      </div>
    </div>
  </div>


  <!-- 리스트 본문 -->

  <div class="wrap">

    <hr>

    <div class="page_img">
      <img src="${dto.details}" alt="미드나잇">
    </div>

    <hr>

    <!-- Review -->

    <div class="review_sec">


    </div>


    <div class="item_page">
      <div class="item_sec">
        <a href="#"><img class="arrow_b_l" src="${contextPath}/resources/img/arrow_b_l.png" alt="왼쪽화살표"></a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#"><img class="arrow_b_r" src="${contextPath}/resources/img/arrow_b_r.png" alt="오른쪽화살표"></a>
      </div>

      <div class="edit_bt">
        <input type="submit" value="등록하기"></input>
      </div>
    </div>
  </div>
  
  <script>
  
  
// 리뷰 제목 클릭하면 본문 보여주는 기능
	function openContent(title) {
	
		let content_list = document.querySelectorAll(".content");
	
		for (let i = 0; i < content_list.length; i++) {
			console.log(document.querySelector(".content" + i));
			document.querySelector(".content" + i).style.display = "none";
		}
		document.querySelector(".content" + title).style.display = "block";
	}

  </script>