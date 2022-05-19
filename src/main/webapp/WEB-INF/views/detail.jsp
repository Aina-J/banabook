<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/contents.css">
<link rel="stylesheet" href="${contextPath}/resources/css/detail_page.css">
<link rel="stylesheet" href="${contextPath}/resources/css/table_paging.css">


<div class="thum">
      <img src="${productList[0].representative}" alt="미드나잇">

      <div class="item_info">

        <ul>
          <div class="good_bt">
            <img src="${contextPath}/resources/img/good_a.png" alt="좋아요버튼">
          </div>

          <li>${productList[0].name}</li>
          <li>${productList[0].price}</li>
          <li>수량</li>
          <li><input type="number" name="quantity" min="1" max="99" step="1" value="1"></li>
        </ul>

        <div class="cart_buy">
          <input class="cart" type="submit" value="장바구니">
          <input class="buy" type="submit" value="바로구매">
        </div>
      </div>
    </div>
  </div>


  <!-- 리스트 본문 -->

  <div class="wrap">

    <hr>

    <div class="page_img">
      <img src="${productList[0].details}" alt="미드나잇">
    </div>

    <hr>

    <!-- QnA -->

    <div class="review_sec">

      <h2>review</h2>

      <table>
        <thead>
          <tr>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td><a href="#">배송이 빨라서 좋아요</a></td>
            <td>user</td>
            <td>0000-00-00</td>
          </tr>

          <tr>
            <td><a href="#">배송이 빨라서 좋아요</a></td>
            <td>user</td>
            <td>0000-00-00</td>
          </tr>

          <tr>
            <td><a href="#">배송이 빨라서 좋아요</a></td>
            <td>user</td>
            <td>0000-00-00</td>
          </tr>

          <tr>
            <td><a href="#">배송이 빨라서 좋아요</a></td>
            <td>user</td>
            <td>0000-00-00</td>
          </tr>

          <tr>
            <td><a href="#">배송이 빨라서 좋아요</a></td>
            <td>user</td>
            <td>0000-00-00</td>
          </tr>
        </tbody>

      </table>

    </div>


    <div class="item_page">
      <div class="item_sec">
        <a href="#"><img class="arrow_b_l" src="${contextPath}/resources/img/arrow_b_l.png" alt="왼쪽화살표"></a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#"><img class="arrow_b_r" src="${contextPath}/resources/img/arrow_b_r.png" alt="오른쪽화살표"></a>
      </div>

      <div class="edit_bt">
        <input type="submit" value="등록하기"></input>
      </div>
    </div>
  </div>

