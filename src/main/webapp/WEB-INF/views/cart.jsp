<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/cart.css">

<div class="mypage">

    <h2>장바구니</h2>

    <hr style="border: solid 1px #173153;">

    <div class="table_wrap">
      <table>

        <thead>
          <tr>
            <th>선택</th>
            <th>상품명</th>
            <th>수량</th>
            <th>금액</th>
            <th>삭제</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td><input type="checkbox"></td>
            <td><a href="javascript:void(0)">title</a></td>
            <td><input style="width: 50px; text-align: center;" type="number" name="quantity" min="1" max="99" step="1" value="1"></td>
            <td>0</td>
            <td>
              <button>&nbsp; X &nbsp;</button>
            </td>
          </tr>
        </tbody>
      </table>

      <div class="item_page">
        <div class="item_sec">
          <button>선택주문</button>
          <button>전체주문</button>
        </div>
      </div>

    </div>
  </div>
</body>
</html>