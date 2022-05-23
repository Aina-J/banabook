<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/contents.css">
<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">


<script>
   $(function() {
      init();
      sellerCheck();
   })
   
   function init() {
      if(getParam('_cate') != '' && getParam('_cate') != null) {
    	  let _cate = getParam('_cate');
    	  ajaxProductList(_cate + "?page=1");
      }
   }
   
	function sellerCheck(){
		if("${message}" == "seller"){
			console.log("판매자 메인 진입")
		} else if("${message}" == "not-seller"){
			alert('판매자가 아닙니다. 판매자로 로그인 해주세요.');
		}
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
      console.log("ajax Success!");
      let html = "";
      
      if(data != null) {
         // 돔 비우기
         $('.wrap').html("");
         // 돔 만들기
          html += "<div class='list_item'>";
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
          let code = data.data[0].code.substring(0, data.data[0].code.indexOf('_'));
          console.log(code);
          if(data.pre) {
        	  // 이전 버튼 만들기
             html += "<a href='javascript:void(0)' onclick=ajaxProductList(\"" + code + "?page=" + (data.beginPage - 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_l.png' alt='페이지왼쪽화살표'></a>";
          }
          for(let i = data.beginPage; i <= data.endPage; i++) {
        	 // 페이징 버튼 만들기, 버튼 클릭하면 page=? 파라미터 추가해서 다시 ajax 호출
             html += "<a href='javascript:void(0)' onclick=ajaxProductList(\"" + code + "?page=" + i + "\")>" + i + "</a>";             
          }
          console.log(data.endPage);
          if(data.next) {
        	  // 다음 버튼 만들기
			html += "<a href='javascript:void(0)' onclick=ajaxProductList(\"" + code + "?page=" + (data.endPage + 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_r.png' alt='페이지오른쪽화살표'></a>";
          }
          html += "</div></div>";
          
          $('.wrap').append(html);
      }
   }
   
   function getParam(sname) {
	    var params = location.search.substr(location.search.indexOf("?") + 1);
	    var sval = "";
	    params = params.split("&");
	    for (var i = 0; i < params.length; i++) {
	        temp = params[i].split("=");
	        if ([temp[0]] == sname) { sval = temp[1]; }
	    }
	    return sval;
	}
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
     
     		 <div class="best_item_ul">
    
       		 <c:forEach var="bestSeller" items="${ bestSellerList }" begin="0" end="3">
          		<ul>
            	 <li><img src="${ bestSeller.representative }" alt="베스트셀러"></li>
             	 <li>${ bestSeller.name }</li>
              	 <li>${ bestSeller.price }</li>
            	</ul>
         	</c:forEach>
       		</div>
     	</div>
  	</div>
 </div>