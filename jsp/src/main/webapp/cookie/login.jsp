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
<h2>쿠키값 확인</h2>
<%
	// userId 쿠키에서 찾는다.
	// request 헤더
	// 요청객체로부터 쿠키정보를 꺼내서 userId 값을 변수에 저장
	String userId = "";
	String checked = ""; //체크박스 checked 옵션 변수 생성
	Cookie[] cookies = request.getCookies();
	
	userId = CookieManager.readCookie(request, "userId");
	checked = !"".equals(userId)? "checked" : "";
	/*
	if(cookies != null) {
		for(Cookie cookie : cookies) {
			if("userId".equals(cookie.getName())) {
				userId = cookie.getValue();
				checked = "checked"; //아이디가 존재하면 체크될 수 있도록 함
				//userId가 존재하지 않으면(F12를 통해 수동으로 세션 0 만들기)
				//새로고침했을 때(뒤로가기X) textbox에 userId가 사라진다.
				break;
			}
		}
	}
	*/
%>

<form action="loginAction.jsp" method="post">
<div class='loginbox'>
        <div id='login'>
            <input type="text" name="id" id="userid" placeholder='ID를 입력해주세요.' 
            				required="required" value=<%= userId %>><br>
            				
            <input type="password" name="pw" id="userpw" value="1234" placeholder='PW를 입력해주세요.' required="required"><br>
            <input type="checkbox" <%= checked %> name="save_check" value="Y">아이디 저장하기<br>
        </div>
        <div id='button'>
        <input type="submit" value="로그인">
        </div>
    </div>
    <div id='info'>
        <a href="">회원가입</a>
        <a href="">ID찾기</a>
        <a href="">PW찾기</a>
    </div> 
    
</form>
</body>
</html>