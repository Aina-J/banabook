<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(function() {
		init();
		bind();
	})

	function init() {
		
	}

	function bind() {
		$(".banner").off("click").on("click",function(){
			let url = "http://localhost:8090/web/productApi/main/novel";
			api(url, "get", null, fnSucc);
		})
	}
	
	function api(url, method, data, fnSucc, fnFail, fnComplete){
	    let option = {
	        "url": url,
	        "type": method,
	        "contentType": "application/json; charset=utf-8",
	        "dataType": "json"
	    }
	        
	    console.log(option);
	    
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
		console.log("data:" +  data);
		console.log(data[0].name);
        
// 		$(".wrap").html("");
// 		if (obj.length != 0) {
   
// 			let html = "";
// 			for(let i = 0; i < obj.length; i++) {
// 				html += "   <div class=\"best_item\">"
// 				html += "   <div class=\"best_item_ul\"> "
// 				html += "      <ul class=\"ul_margin\" onclick=\"location.href=\"'${contextPath}/product/detail?code='" + obj[0].code + ">  "       
// 				html += "         <li><img class=\"thumbnail\"> alt=\"이미지\"></li>  "
// 				html += "               $(\".thumbnail\").attr('src', "+ obj[0].representative + "); "
// 				html += "         <div>  "
// 				html += "            <li>" + obj[0].name + "</li>  "
// 				html += "            <li>" + obj[0].price + "원</li>  "
// 				html += "         </div>  "
// 				html += "      </ul>  "
// 				html += "   </div>  "
// 				html += "   </div>  "          
// 			}
// 			$(".wrap").append(html);
// 		}
	}
</script>


<link rel="stylesheet" href="${contextPath}/resources/css/contents.css">
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