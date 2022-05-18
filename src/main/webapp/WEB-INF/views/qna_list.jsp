<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/qna_list.css">
    
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

        <tbody>
          <tr>
            <td>1</td>
            <td><a href="javascript:void(0)"> 문의드립니다.</a></td>
            <td>O</a></td>
          </tr>
        </tbody>
      </table>

      <div class="item_page">
        <div class="item_sec">
          <a href="javascript:void(0)">1</a>
          <a href="javascript:void(0)">2</a>
          <a href="javascript:void(0)">3</a>
          <a href="javascript:void(0)">4</a>
          <a href="javascript:void(0)">5</a>
          <a href="javascript:void(0)"><img class="arrow_b_r" src="asset/img/arrow_b_r.png" alt="페이지오른쪽화살표"></a>
        </div>
      </div>
      
    </div>
  </div>
