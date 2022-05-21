<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/aside.css">
  
  <script>
  
	  $(function() {
		  if(window.location.href == "http://localhost:8080/web/main") {
		      bind_aside();
		      $('.aside ul li a').each((idx, item) => {
		    	 $(item).attr('href', 'javascript:void(0)'); 
		      });
		  }
	  })
	
	  function bind_aside() {
	    $('.cate').each((idx, item) => {
	    	$(item).off('click').on('click', e => {
	    		_cate = $(item).data("value");
	    		ajaxProductList(_cate);
	    	})
	    })
	    
	    $('.aside_used a').off("click").on("click", e => {
	    	_cate = $('.aside_used a').data("value");
	    	ajaxProductList(_cate);
	    })
	  }
 
  </script>
  
    <div class="aside">
      <ul>
        <li class="cate" data-value="novel?page=1"><a href="http://localhost:8080/web/main">· 소설/시</a></li>
        <li class="cate" data-value="essay?page=1"><a href="http://localhost:8080/web/main">· 에세이</a></li>
        <li class="cate" data-value="magazine?page=1"><a href="javascript:void(0)">· 잡지/매거진</a></li>
        <li class="cate" data-value="comic?page=1"><a href="javascript:void(0)">· 만화</a></li>
        <li class="cate" data-value="kid?page=1"><a href="javascript:void(0)">· 어린이</a></li>
        <li class="cate" data-value="reference?page=1"><a href="javascript:void(0)">· 참고서</a></li>
      </ul>
	<div class="aside_used">
		<a class="used" href="#">중고서적</a>
	</div>
</div>