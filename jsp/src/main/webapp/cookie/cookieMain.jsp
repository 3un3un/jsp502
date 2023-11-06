<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Cookie</h2>

<!-- 
cookie
 
 	클라이언트의 상태 정보를 클라이언트 PC에 저장한다.
 	로그인 아이디를 저장하거나, 팝업창을 제어하는데 주로 사용된다.
 	
 	- 3000개까지 생성 가능
 	- 하나의 호스트 또는 도메인당 50개까지 생성 가능
 	- 쿠키 하나당 최대 크기는 4096byte이다.

 -->
 
 <h3>1. 쿠기 설정</h3>
 
 
 <%
 /*
 쿠키 생성
 new Cookie(이름, 값);
 	이름 : 쿠키를 구별하는 이름
 	값 : 쿠키에 저장할 실제 데이터
 */
 	Cookie cookie = new Cookie("myCookie", "value");
 	
 	//쿠키가 유지될 시간을 초단위로 설정(3600초 = 1시간)
 	cookie.setMaxAge(3600);
 	
 	//생성한 쿠키를 응답객체를 통한 브라우저로 전달
 	response.addCookie(cookie);
 %>
 
 <h3>2. 페이지 이동 후 쿠키값 확인</h3>
 <a href="cookieResult.jsp">쿠키값 확인</a>
 
 
 
</body>
</html>