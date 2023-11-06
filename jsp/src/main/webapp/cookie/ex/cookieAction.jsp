<%@page import="com.z3un3un.utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	팝업용 쿠키를 생성후 cookieMain페이지로 전환
 -->
 <%
 if("Y".equals(request.getParameter("inactiveToday"))){
	 //서버에서는 response(응답객체)에 추가해주면 브라우저가 확인 후 쿠키에 저장
	 CookieManager.makeCookie(response, "popupCookie", "Y", 3600);
	 response.sendRedirect("cookieMain.jsp");
	 //request.getRequestDispatcher("cookieMain.jsp").forward(request, response);
 }

 %>
 
 

</body>
</html>