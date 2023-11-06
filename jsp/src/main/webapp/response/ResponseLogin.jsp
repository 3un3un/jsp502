<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// id == 3un3un, pw == 1234 로그인 성공
	// id.equals("3un3un")일 때는 null일 경우 NEP이므로 
	//다음과 같이 작성하는 것이 좋다.
	if("3un3un".equals(id) && "1234".equals(pw)){
		// 로그인 성공
		// 페이지 전환 -> 웹브라우저 -> 웹브라우저가 다시 요청
		// senㅇRedirect() : 페이지 전환. 특징 : 기존 요청정보가 공유되지 않아 직접 적어줘야한다.
		//아이디를 파라메터로 넘겨주지 않으면 id값이 공유되지 않는다. ?id="+request.getParameter("id")
		//forword는 안적어도 O
		response.sendRedirect("ResponseWelcome.jsp?id="+request.getParameter("id"));
	} else {
		// 로그인 실패
		// 기존 요청정보가 공유된다.
		request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
		.forward(request, response);
	}
	
%>
<h2>페이지를 전환하는 방법</h2>
<p>sendRedirect</p>
<p>forward</p>
id : <%=id %> <br>
pw : <%=pw %>
</body>
</html>