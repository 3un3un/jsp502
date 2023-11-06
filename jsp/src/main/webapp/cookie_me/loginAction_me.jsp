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
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

String save_check = request.getParameter("save_check");
out.print("save_check : " + save_check);

if(save_check != null) {
	Cookie cookie = new Cookie("userId", id);
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
	out.print("아이디를 쿠키에 저장했다");
}



if(true){
	out.print("<h2>로그인 성공</h2>");
} else {
	out.print("<h2>로그인 실패</h2>");
}

%>



</body>
</html>
