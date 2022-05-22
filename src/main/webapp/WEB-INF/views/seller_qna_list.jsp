<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/qna_list.css">
<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	
   	$(function() {
		init();
   	})
   
   	function init() {
		   ajaxInquiryList();
   	}
   
	function ajaxInquiryList(page) {
	      if(typeof page == "undefined" || page == null || page == ""){
	    	  data = 1;
	      } else {
	    	  data = page;
	      }
	      let url = "http://localhost:8080/web/memberApi/sellerInquiry/${id}?page="+data;
	      api(url, "GET", null, fnSucc);
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
      console.log(JSON.stringify(data));
      let html = "";
      if(data.data[0] == 0) {
    	  // 돔 비우기
          $('#inquiry').html("");
          // 돔 만들기
             	html += "<tr>";
            	html += "   <td>1</td>";
             	html += "   <td onclick=\"openContentForm()\" > 등록된 문의가 없습니다. </a></td>";
 	        	html += "   <td></td>";
             	html += " </tr>";
           $('#inquiry').append(html);
      } else if(data.data[0] != 0 || data != null) {
         // 돔 비우기
         $('#inquiry').html("");
         // 돔 만들기
         var length = data.data.length;
         for(let i = 0; i < data.data.length; i++) {
            html += "<tr class=\"count\">";
           	html += "   <td>" + (i + 1) + "</td>";
	            if((data.data[i].pi_id)==0){
            		html += "   <td onclick=\"openContentForm("+i+")\" >" + data.data[i].title + "</a></td>";
	            	let original = data.data[i].inquiry_id;
	            	var matched = false;
	            	for(let j = 0; j < data.data.length; j++){
	            		if(original == data.data[j].pi_id){
	            			var matched = true;
	            		}
	            	}
	    	            	if(matched){
	    	            		html += "   <td>답변완료</td>";
	    	            	} else{
	    	            		html += "   <td>답변대기중</td>";
	    	            	}

	            } else if((data.data[i].pi_id)!=0){
	            	html += "   <td onclick=\"openContentForm("+i+")\" >ㄴ " + data.data[i].title + "</a></td>";
	        		html += "   <td></td>";
	            }
            html += " </tr>";
	    	html += "   <td class=\"content"+ i +"\" style=\"display:none;\" colspan=\"3\"> 게시글 내용 :  " + data.data[i].content + "</td>";
          }
         	$('#inquiry').append(html);
         	
             let htmlP = "";
         	 $('#paging').html("");
             htmlP += "<div class='item_page'>";
             htmlP += "<div class='item_sec' style='width:780px;'>";
          if(data.pre) {
        	 // 이전 버튼 만들기
             htmlP += "<a href='javascript:void(0)' onclick=ajaxInquiryList(\"" + (data.beginPage - 1) + ");openContentForm()><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_l.png' alt='페이지왼쪽화살표'></a>";
          } 
          for(let i = data.beginPage; i <= data.endPage; i++) {
        	 // 페이징 버튼 만들기, 버튼 클릭하면 page=? 파라미터 추가해서 다시 ajax 호출
        	  htmlP += "<a href='javascript:void(0)' onclick=ajaxInquiryList(\"" + i + "\")>" + i + "</a>";             
          }
          if(data.next) {
        	 // 다음 버튼 만들기
             htmlP += "<a href='javascript:void(0)' onclick=ajaxInquiryList(\"" + (data.endPage + 1) + ");openContentForm()><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_r.png' alt='페이지오른쪽화살표'></a>";
          }
          htmlP += " </div> ";
       	  htmlP += " </div> ";
          
          $('#paging').append(htmlP);
      	}
   	}
   
   	
    /* 문의 제목 클릭하면 본문 보여주는 기능 */
    function openContentForm(num) {
    		let count = document.querySelectorAll(".count").length;
    	    for (let i = 0; i < count ; i++) {
    	       console.log(document.querySelector(".content" + i));
    	       document.querySelector(".content" + i).style.display = "none";
    	    }
    	    document.querySelector(".content" + num).style.display = "table-cell";
	   	}
    
    
</script>

<div class="mypage">

    <h2>문의내역</h2>

    <hr style="border: solid 1px #173153;">

    <div class="table_wrap">
      <table>

        <thead>
          <tr>
            <th>No.</th>
            <th>문의제목</th>
            <th>답변여부</th>
          </tr>
        </thead>

        <tbody id="inquiry">
        </tbody>
      </table>
	<div id="paging">
	</div>
    </div>
  </div>
