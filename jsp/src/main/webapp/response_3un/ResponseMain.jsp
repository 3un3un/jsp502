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
	out.print(request.getParameter("loginErr"));

%>

<Form action="ResponseLogin.jsp" method="post">
아이디 : <input type="text" name="id" value="3un3un">
비밀번호 : <input type="password" name="pw" value="1234">
<button>로그인</button>

</Form>

</body>
</html>