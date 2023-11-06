<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cookie</h1>

<h2>1. 쿠키 설정</h2>
<%
	Cookie cookie = new Cookie("name", "value");
	
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
%>


<h2>2. 페이지 이동 후 쿠키값 확인</h2>

<a href="cookieResult_me.jsp">쿠키값확인</a>
</body>
</html>