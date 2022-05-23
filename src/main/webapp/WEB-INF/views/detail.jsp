<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/contents.css">
<link rel="stylesheet" href="${contextPath}/resources/css/detail_page.css">
<link rel="stylesheet" href="${contextPath}/resources/css/table_paging.css">
<link rel="stylesheet" href="${contextPath}/resources/css/review.css">
<link rel="stylesheet" href="${contextPath}/resources/css/qna.css">

<script>
	$(function() {
		init();
	})
	
	function init() {
		ajaxReviewList();
		ajaxInquiryList();
	}
	
	function ajaxReviewList(page) {
	    if(typeof page == "undefined" || page == null || page == ""){
	    	data = 1;
	    } else {
	    	data = page;
	    }
		let url = "http://localhost:8080/web/reviewApi/reviewApi/${dto.code}?page=" + data;
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
		
		
		if(data.data[0] == 0) {
    	// 돔 비우기
        $('.review_sec').html("");
        // 돔 만들기
        	html += "<h2>review</h2>";
			html += "<table> ";
			html += "	<thead> ";
			html += "		<tr>";
			html += "			<th>제목</th>";
			html += "			<th>작성자</th>";
			html += "			<th>작성일</th>";
			html += "		</tr>";
			html += "	</thead>";
			html += "	<tbody>";
           	html += "		<tr>";
           	html += " 	  		<td colspan=\"3\" style=\"text-align: center;\"> 등록된 리뷰가 없습니다. </a></td>";
           	html += "		</tr>";
			html += "	</tbody>";
			html += "</table>";
			
	        // 리뷰 등록하기 버튼
	        html += "<div class=\"edit_bt\">";
	        html += "	<input onclick=\"openInsertForm()\" type=\"submit\" value=\"등록하기\"></input>";
	        html += "</div>";
	        
	        html += "</div>";
	        
        $('.review_sec').append(html);
        
		} else if(data != null) {
			// 돔 비우기
			$('.review_sec').html("");
			// 돔 만들기
			html += "<h2>review</h2>";
			html += "<table> ";
			html += "	<thead> ";
			html += "		<tr>";
			html += "			<th>제목</th>";
			html += "			<th>작성자</th>";
			html += "			<th>작성일</th>";
			html += "		</tr>";
			html += "	</thead>";
			html += "	<tbody>";
			
			for(let i = 0; i < data.data.length; i++) {
				
				html += "		<tr>";
				html += "			<td class=\"title" + i + "\""+"><a href=\"javascript:void(0)\" onclick=\"openContent('" + i + "')\">" + data.data[i].title + "</a></td>";
				html += "			<td>" + data.data[i].id + "</td>";
				html += "			<td>" + data.data[i].write_date + "</td>";
				html += "		</tr>";
				html += "		<tr class=\"content content" + i +"\""+">";
				html += "			<td colspan='3'>" + "내용 : " + data.data[i].content + "</td>";
				html += "		</tr>";
				
			}
			html += "	</tbody>";
			html += "</table>";
			
			// 페이징
	        html += "<div class='item_page'>"
	        html += "	<div class='item_sec'>"
	        let code = data.data[0].code.substring(0, data.data[0].code.indexOf('_'));
	        console.log(code);
	        if(data.pre) {
	        	  // 이전 버튼 만들기
	           html += "<a href='javascript:void(0)' onclick=ajaxReviewList(\"" + (data.beginPage - 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_l.png' alt='페이지왼쪽화살표'></a>";
	        }
	        for(let i = data.beginPage; i <= data.endPage; i++) {
	        	 // 페이징 버튼 만들기, 버튼 클릭하면 page=? 파라미터 추가해서 다시 ajax 호출
	           html += "<a href='javascript:void(0)' onclick=ajaxReviewList(\"" + i + "\")>" + i + "</a>";             
	        }
	        console.log(data.endPage);
	        if(data.next) {
	        	  // 다음 버튼 만들기
	    	html += "<a href='javascript:void(0)' onclick=ajaxReviewList(\"" + (data.endPage + 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_r.png' alt='페이지오른쪽화살표'></a>";
	        }
	        html += "</div>";
	        
	        // 리뷰 등록하기 버튼
	        html += "<div class=\"edit_bt\">";
	        html += "	<input onclick=\"openInsertForm()\" type=\"submit\" value=\"등록하기\"></input>";
	        html += "</div>";
	        
	        html += "</div>";
			
		    $('.review_sec').append(html);
		    
		}
	}
	
	
	/* 작성하기 버튼 누르면 작성 폼을 보여주는 기능 */
	function openInsertForm() {
		document.querySelector(".review").style.display = "block";
	}
  
	/* 리뷰 제목 클릭하면 본문 보여주는 기능 */
	function openContent(title) {
		
		let content_list = document.querySelectorAll(".content");
		console.log("content_list는 " + content_list.length);
		
		if (document.querySelector(".content" + title).style.display === "none") {
			for (let i = 0; i < content_list.length; i++) {
				console.log(document.querySelector(".content" + i));
				document.querySelector(".content" + i).style.display = "none";
			}
			document.querySelector(".content" + title).style.display = "block";
		} else { 
			document.querySelector(".content" + title).style.display = "none";
		}
	}
	
	/* 리뷰 등록하기 버튼을 누르면 DB에 저장되는 기능 */
	$("#btn_insert").click(function () {
		if ( $("input[name='title']").val() == "" || $("input[name='title']").val() == null) {
			alert('제목을 입력해주세요.');
			return;
		} else if ($("input[name='content']").val() == "" || $("input[name='content']").val() == null) {
			alert('내용을 입력해주세요.');
			return;
		} else {
			$("#review_form").attr("action", "/web/review/insert/${dto.code}");
			$("#review_form").submit();
		}
	})
	
	/* 작성하기 버튼 누르면 작성 폼을 보여주는 기능 */
	function openInsertForm() {
		document.querySelector(".review").style.display = "block";
	}
	
	/* 리뷰 제목 클릭하면 본문 보여주는 기능 */
	function openContent(title) {
	
		let content_list = document.querySelectorAll(".review_sec .content");
	
		console.log("content_list는 " + content_list.length);
		
		
		for (let i = 0; i < content_list.length; i++) {
			console.log(document.querySelector(".review_sec .content" + i));
			document.querySelector(".review_sec .content" + i).style.display = "none";
		}
		document.querySelector(".review_sec .content" + title).style.display = "block";
	}
	
	/* 리뷰 등록하기 버튼을 누르면 DB에 저장되는 기능 */
    $(".reivew_sec #btn_insert").click(function () {

      if ( $("input[name='title']").val() == "" || $("input[name='title']").val() == null) {
        alert('제목을 입력해주세요.');
        return;
      } else if ($("input[name='content']").val() == "" || $("input[name='content']").val() == null) {
        alert('내용을 입력해주세요.');
        return;
      } else {
        $("#review_form").attr("action", "/web/review/insert/${dto.code}");
        $("#review_form").submit();
      }
    })
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
    
    
	<!-- Paging -->


	<!-- Review 작성 form -->
	  <div class="review">
	
	    <h2>Review 작성</h2>
	
	    <hr style="border: solid 1px #173153;">
	
	    <form method="POST" id="review_form">
	
	      <div class="write_sec">
	        <span>제목</span>
	        <input type="text" name="title" placeholder="제목을 입력해 주세요.">
	      </div>
	
	      <div class="write_sec_2">
	        <span>내용</span>
	        <input type="text" name="content" placeholder="내용을 입력해 주세요.">
	      </div>
	
	      <div class="edit_bt_review">
	        <input id="btn_insert" value="리뷰 등록하기"></input>
	      </div>
	
	    </form>
	  </div>

    
    <!-- Inquiry -->

    <div class="inquiry_sec">
	<!-- 자바스크립트에서 append해줍니다. -->
    </div>
    
    



	<!-- inquiry 작성 form -->
	  <div class="inquiry">
	
	    <h2>Q & A 작성</h2>
	
	    <hr style="border: solid 1px #173153;">
	
	    <form method="POST" id="inquiry_form">
	
	      <div class="write_sec">
	        <span>제목</span>
	        <input type="text" name="title" placeholder="제목을 입력해 주세요.">
	      </div>
	
	      <div class="write_sec_2">
	        <span>내용</span>
	        <input type="text" name="content" placeholder="내용을 입력해 주세요.">
	      </div>
	
	      <div class="edit_bt_inquiry">
	        <input id="btn_insert" value="문의 등록하기"></input>
	      </div>
	
	    </form>
	  </div>

  </div>

  
  <script>
  

	//inquriy 관련//////////////////////////////////////////////////////////////////////////////////
	function ajaxInquiryList(page) {
	    if(typeof page == "undefined" || page == null || page == ""){
	    	data = 1;
	    } else {
	    	data = page;
	    }
		let url = "http://localhost:8080/web/inquiryApi/inquiryApi/${dto.code}?page=" + data;
		apiInquiry(url, "get", null, fnSuccInquiry);
	}
	function apiInquiry(url, method, data, fnSucc, fnFail, fnComplete){
		
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
	function fnSuccInquiry(data) {
 		console.log(JSON.stringify(data));
		
		let html = "";
		
		
		if(data.data[0] == 0) {
    	// 돔 비우기
        $('.inquiry_sec').html("");
        // 돔 만들기
        	html += "<h2>Q & A</h2>";
			html += "<table> ";
			html += "	<thead> ";
			html += "		<tr>";
			html += "			<th>제목</th>";
			html += "			<th>작성자</th>";
 			html += "			<th>작성일</th>"; 
			html += "		</tr>";
			html += "	</thead>";
			html += "	<tbody>";
           	html += "		<tr>";
           	html += " 	  		<td colspan=\"3\" style=\"text-align: center;\"> 등록된 리뷰가 없습니다. </a></td>";
           	html += "		</tr>";
			html += "	</tbody>";
			html += "</table>";
			
	        // 리뷰 등록하기 버튼
	        html += "<div class=\"edit_bt\">";
	        html += "	<input onclick=\"openInsertInquiryForm()\" type=\"submit\" value=\"등록하기\"></input>";
	        html += "</div>";
	        
	        html += "</div>";
	        
        $('.inquiry_sec').append(html);
        
		} else if(data != null) {
			// 돔 비우기
			$('.inquiry_sec').html("");
			// 돔 만들기
			html += "<h2>Q & A</h2>";
			html += "<table> ";
			html += "	<thead> ";
			html += "		<tr>";
			html += "			<th>제목</th>";
			html += "			<th>작성자</th>";
 			html += "			<th>작성일</th>"; 
			html += "		</tr>";
			html += "	</thead>";
			html += "	<tbody>";
			
			for(let i = 0; i < data.data.length; i++) {
				
				html += "		<tr>";
				if(data.data[i].pi_id == 0){
					html += "			<td class=\"title" + i + "\""+"><a href=\"javascript:void(0)\" onclick=\"openInquiryContent('" + i + "')\">" + data.data[i].title + "</a></td>";
				}else{
					html += "			<td class=\"title" + i + "\""+"><a href=\"javascript:void(0)\" onclick=\"openInquiryContent('" + i + "')\"> ㄴ" + data.data[i].title + "</a></td>";
				}
				html += "			<td>" + data.data[i].id + "</td>";
 				html += "			<td>" + data.data[i].write_date + "</td>"; 
				html += "		</tr>";
				html += "		<tr class=\"content content" + i +"\""+">";
				html += "			<td colspan='3'>" + "내용 : " + data.data[i].content + "</td>";
				html += "		</tr>";
				
			}
			html += "	</tbody>";
			html += "</table>";
			
			// 페이징
	        html += "<div class='item_page'>"
	        html += "	<div class='item_sec'>"
	        let code = data.data[0].code.substring(0, data.data[0].code.indexOf('_'));
	        console.log(code);
	        if(data.pre) {
	        	  // 이전 버튼 만들기
	           html += "<a href='javascript:void(0)' onclick=ajaxReviewList(\"" + (data.beginPage - 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_l.png' alt='페이지왼쪽화살표'></a>";
	        }
	        for(let i = data.beginPage; i <= data.endPage; i++) {
	        	 // 페이징 버튼 만들기, 버튼 클릭하면 page=? 파라미터 추가해서 다시 ajax 호출
	           html += "<a href='javascript:void(0)' onclick=ajaxReviewList(\"" + i + "\")>" + i + "</a>";             
	        }
	        console.log(data.endPage);
	        if(data.next) {
	        	  // 다음 버튼 만들기
	    	html += "<a href='javascript:void(0)' onclick=ajaxReviewList(\"" + (data.endPage + 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_r.png' alt='페이지오른쪽화살표'></a>";
	        }
	        html += "</div>";
	        
	        // 리뷰 등록하기 버튼
	        html += "<div class=\"edit_bt\">";
	        html += "	<input onclick=\"openInsertInquiryForm()\" type=\"submit\" value=\"등록하기\"></input>";
	        html += "</div>";
	        
	        html += "</div>";
			
		    $('.inquiry_sec').append(html); 
		}
	}
	//inquriy 관련//////////////////////////////////////////////////////////////////////////////////
	
	/* Inquriy *********** 작성하기 버튼 누르면 작성 폼을 보여주는 기능 */
	function openInsertInquiryForm() {
		document.querySelector(".inquiry").style.display = "block";
	}
  
	/* inquriy 제목 클릭하면 본문 보여주는 기능 */
	function openInquiryContent(title) {
	
		let content_list = document.querySelectorAll(".inquiry_sec .content");
	
		console.log("content_list는 " + content_list.length);
		
		
		for (let i = 0; i < content_list.length; i++) {
			console.log(document.querySelector(".inquiry_sec .content" + i));
			document.querySelector(".inquiry_sec .content" + i).style.display = "none";
		}
		document.querySelector(".inquiry_sec .content" + title).style.display = "block";
	}
	
	/* inquriy 등록하기 버튼을 누르면 DB에 저장되는 기능 */
    $(".inquiry_sec #btn_insert").click(function () {

      if ( $("input[name='title']").val() == "" || $("input[name='title']").val() == null) {
        alert('제목을 입력해주세요.');
        return;
      } else if ($("input[name='content']").val() == "" || $("input[name='content']").val() == null) {
        alert('내용을 입력해주세요.');
        return;
      } else {
        $("#inquiry_form").attr("action", "/web/review/insert/${dto.code}");
        $("#inquiry_form").submit();
      }
    })

  </script>
