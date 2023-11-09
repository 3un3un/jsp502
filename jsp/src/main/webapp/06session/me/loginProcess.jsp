<%@page import="com.z3un3un.dto.me.MemberDto"%>
<%@page import="com.z3un3un.dao.me.MemberDao"%>
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
String id = request.getParameter("user_id");
String pass = request.getParameter("user_pw");
MemberDao dao = new MemberDao();
MemberDto dto = dao.login(id, pass);

if(dto!=null) {
	session.setAttribute("MemberDto", dto);
	session.setAttribute("userId", dto.getId());
	response.sendRedirect("main.jsp");
} else {
	
	request.getRequestDispatcher("loginForm.jsp?isError=1").forward(request, response);
	
}

%>

</body>
</html>