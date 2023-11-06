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

//체크박스 value가 Y면 쿠키만들고 Main으로 전환하기
if("Y".equals(request.getParameter("inactiveToday"))){//
	
	CookieManager.makeCookie(response,"popupClose", "Y", 3600);
	out.print(request.getParameter("inactiveToday"));
	response.sendRedirect("cookiePopupMain_me.jsp");
}



%>

</body>
</html>