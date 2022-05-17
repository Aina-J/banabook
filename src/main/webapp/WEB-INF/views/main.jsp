<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

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