<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/contents.css">
<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">
<script src="${contextPath}/resources/js/paging.js"></script>

<script>
	$(function() {
		init();
	})
	
	function init() {
		
	}
	
	function ajaxProductList(cate) {
		let url = "http://localhost:8080/web/productApi/main/" + cate;
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
		let html = "";
		
		if(data != null) {
			// 돔 비우기
			$('.wrap').html("");
			// 돔 만들기
		    html += "<div class='best_item'>";
		    html += "<div class='best_item_list'>";
		    for(let i = 0; i < data.data.length; i++) {
		    	html += "<div class='items' onclick='location.href=\"http://localhost:8080/web/product/list?code="+ data.data[i].code +"\"'>";
		    	html += "<div><img src='" + data.data[i].representative + "' alt='이미지'></div>";
		    	html += "<div class='item_info'>";
		    	html += "<div>" + data.data[i].name + "</div>";
		    	html += "<div>" + data.data[i].price + "원</div>";
			    html += "</div></div>";
		    }
		    html += "</div></div>";

		    html += "<div class='item_page'>"
		    html += "<div class='item_sec'>"
		    html += "<a href='javascript:void(0)'><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_l.png' alt='페이지왼쪽화살표'></a>"
		    for(let i = data.beginPage; i <= data.endPage; i++) {
			    html += "<a href='javascript:void(0)'onclick='paging(" + i + ")'>" + i + "</a>"		    	
		    }
		    html += "<a href='javascript:void(0)'><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_r.png' alt='페이지오른쪽화살표'></a>"
		    html += "</div>";
		    
		    $('.wrap').append(html);
		}
	}
	
	function urlParser() {
		let url = window.location.href();
	}
	
	// 돔을 만드는 메소드
</script>

<div class="wrap">
  <div class="banner_sec">
    <img class="banner" src="${contextPath}/resources/img/banner.jpg" alt="메인배너">

    <div class="arr">
      <a href="#"><img class="banner_arr_l" src="${contextPath}/resources/img/arrow_l.png" alt="왼쪽화살표"></a>
      <a href="#"><img class="banner_arr_r" src="${contextPath}/resources/img/arrow_r.png" alt="오른쪽화살표"></a>
    </div>
  </div>


  <!-- 베스트셀러 -->

  <div class="best_item">

    <div class="best">&nbsp; · BEST</div>

    <div class="best_item_ul">
      <ul>
        <li><img src="${contextPath}/resources/img/dummy300400.jpg" alt="이미지"></li>
        <div>
          <li>title</li>
          <li>0</li>
        </div>
      </ul>

      <ul>
        <li><img src="${contextPath}/resources/img/dummy300400.jpg" alt="이미지"></li>
        <div>
          <li>title</li>
          <li>0</li>
        </div>
      </ul>

      <ul>
        <li><img src="${contextPath}/resources/img/dummy300400.jpg" alt="이미지"></li>
        <div>
          <li>title</li>
          <li>0</li>
        </div>
      </ul>

      <ul>
        <li><img src="${contextPath}/resources/img/dummy300400.jpg" alt="이미지"></li>
        <div>
          <li>title</li>
          <li>0</li>
        </div>
      </ul>
    </div>
  </div>
</div>