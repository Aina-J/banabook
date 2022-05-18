<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath}" />

<link rel="stylesheet" href="${contextPath}/resources/css/list_page.css">
<c:forEach var="product" items="${ productList }">
	${productList.code}
	${productList.id}
	${productList.name}
	${productList.price}
	${productList.representative}
	${productList.details}
</c:forEach>    
        <div class="wrap">

      <div class="best_item">

        <div class="best_item_ul">

          <ul>
            <li><img src="${contextPath}/resources/img/thum/1.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/2.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/3.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/4.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>
        </div>
      </div>

      <div class="best_item">

        <div class="best_item_ul">

          <ul>
            <li><img src="${contextPath}/resources/img/thum/5.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/6.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/7.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/8.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>
        </div>
      </div>

      <div class="best_item">

        <div class="best_item_ul">

          <ul>
            <li><img src="${contextPath}/resources/img/thum/9.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/10.jpg" alt="이미지"></li>
            <div>
              <li>title</li>
              <li>0</li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/null.png" alt="이미지"></li>
            <div>
              <li></li>
              <li></li>
            </div>
          </ul>

          <ul>
            <li><img src="${contextPath}/resources/img/thum/null.png" alt="이미지"></li>
            <div>
              <li></li>
              <li></li>
            </div>
          </ul>
        </div>
      </div>

    </div>

  </div>