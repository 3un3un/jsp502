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
<h2>팝업용 쿠키를 생성하는 페이지</h2>





<%
	////1. inactiveToday값을 출력하자
	//체크박스의 name을 통해 value값 불러서 체크유무 알아보기
	//value 속성의 값 = request.getParameter("name속성의 값")
	out.print("inactiveToday : " + request.getParameter("inactiveToday"));


	if("Y".equals(request.getParameter("inactiveToday"))){//체크를 했다면
		////2. 팝업닫기용(popupClose, Y) 쿠키 생성
		//CookieManager 이용하기
		CookieManager.makeCookie(response, "popupClose", "Y", 3600);
		
		////3. main페이지 전환
		response.sendRedirect("cookiePopupMain.jsp");
	}

%>





</body>
</html>