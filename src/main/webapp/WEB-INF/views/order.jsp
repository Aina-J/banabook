<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/order.css">

  <div class="mypage">

    <h2>주문내역</h2>

    <hr style="border: solid 1px #173153;">

    <div class="table_wrap">
      <table>

        <thead>
          <tr>
            <th>주문일자</th>
            <th>상품명</th>
            <th>수량</th>
            <th>금액</th>
            <th>배송상태</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>2022-05-01</td>
            <td><a href="javascript:void(0)">title</a></td>
            <td><input style="width: 50px; text-align: center;" type="number" name="quantity" min="1" max="99" step="1" value="1"></td>
            <td>0</td>
            <td>배송완료</td>
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
          <a href="javascript:void(0)"><img class="arrow_b_r" src="${contextPath}/resources/img/arrow_b_r.png" alt="페이지오른쪽화살표"></a>
        </div>
      </div>

    </div>
  </div>