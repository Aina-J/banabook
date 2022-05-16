# banabook
JAVA Digital Convergence Developer Course /  'Banabook' online-bookstore team project

<h1> 스프링 프로젝트 기본 세팅  </h1>

JAVA 11 <br>
Springframework 5.2.8. <br>
Apache Tomcat 9.0 <br>
Oracle 11G <br>
<hr>
 22-05-16일자 설정 
<br>

<h3> pom.xml 파일 변경  </h3>
Lombok 1.18.12 라이브러리 추가 <br>
log4j 1.2.17 버전 추가 <br>
커넥션 풀 라이브러리 추가를 위한 HikariCP 추가 <br>
MyBatis 사용을 위한 mybatis, mybatis-spring, spring-jdbc, spring-tx 라이브러리 추가 <br>
JUnit 4.12로 버전 변경 <br>

<h3> web.xml 파일 변경 </h3>
welcome-file-list 를 사용해 index.jsp 로 이동하는 경로 추가  <br>
UTF-8 인코딩 파라미터 설정 추가  <br>
자바 Bean 관련 context 설정 추가  <br>

<h3> DB 연결 확인 </h3> 
DataSourceTest, JDBCTest로 oracle db연결 확인  <br>

<hr>
