<%@page import="com.z3un3un.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.z3un3un.dao.BoardDao"%>
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
	String isError = request.getParameter("isError");
	if("1".equals(isError)) {
		out.print("아이디, 비밀번호를 확인해주세요.");
	}
%>

		



<%
BoardDao dao = new BoardDao();
List<BoardDto> boardDto = (List<BoardDto>)dao.getList();
session.setAttribute("boardDto", boardDto.toString());

%>
<form action="loginProcess" method="post" name="loginFrm">
        아이디 : <input type="text" name="user_id" required="required" value="test" /><br />
        패스워드 : <input type="password" name="user_pw" required="required" value="1234" /><br />
        <input type="submit" value="로그인하기" />
</form> 

</body>
</html>