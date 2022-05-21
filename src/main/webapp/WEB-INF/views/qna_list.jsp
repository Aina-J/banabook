<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/css/qna_list.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	
   $(function() {
		init();
   })
   
   function init() {
	   ajaxInquiryList();
	   console.log("${id}");
   }
   
	   function ajaxInquiryList() {
	      let url = "http://localhost:8080/web/memberApi/inquiry/${id}";
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
      console.log(JSON.stringify(data));
      console.log(data.data[0]);
      let html = "";
      if(data.data[0] == 0) {
    	  // 돔 비우기
          $('#inquiry').html("");
          // 돔 만들기
             	html += "<tr>";
            	html += "   <td>1</td>";
             	html += "   <td onclick=\"openContentForm()\" > 등록된 문의가 없습니다. </a></td>";
 	        	html += "   <td> X </td>";
             	html += " </tr>";
           $('#inquiry').append(html);
      } else if(data.data[0] != 0 || data != null) {
         // 돔 비우기
         $('#inquiry').html("");
         // 돔 만들기
         for(let i = 0; i < data.data.length; i++) {
            html += "<tr>";
           	html += "   <td>" + (i + 1) + "</td>";
            html += "   <td onclick=\"openContentForm()\" >" + data.data[i].title + "</a></td>";
	            if((data.data[i].pi_id)==0){
	            	html += "   <td> 답변대기중 </td>";
	            }
	            if((data.data[i].pi_id)!=0){
	        		html += "   <td> 답변완료 </td>";
	            }
            html += " </tr>";
            console.log("pi id : " + data.data[i].pi_id);
          }
          if(data.pre) {
        	 html += "<div class='item_page'>"
             html += "<div class='item_sec'>"
             html += "<a href='javascript:void(0)' onclick=ajaxProductList(\"" + code + "?page=" + (data.beginPage - 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_l.png' alt='페이지왼쪽화살표'></a>";
          } else {
             
          }
          for(let i = data.beginPage; i <= data.endPage; i++) {
             html += "<a href='javascript:void(0)' onclick=ajaxProductList(\"" + code + "?page=" + i + "\")>" + i + "</a>";             
          }
          console.log(data.endPage);
          if(data.next) {             
             html += "<a href='javascript:void(0)' onclick=ajaxProductList(\"" + code + "?page=" + (data.endPage + 1) + "\")><img class='arrow_b_r' src='http://localhost:8080/web/resources/images/arrow_b_r.png' alt='페이지오른쪽화살표'></a>";
          }
          html += "</div></div>";
          
          $('#inquiry').append(html);
      }
   }
   
   function hello() {
      console.log("hello!");
   }
   
   // 돔을 만드는 메소드
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

    </div>
  </div>
