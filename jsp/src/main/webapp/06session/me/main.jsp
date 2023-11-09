<%@page import="com.z3un3un.dao.me.MemberDao"%>
<%@page import="com.z3un3un.dto.me.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= session.getAttribute("userId") %>
<%
	MemberDto dto = (MemberDto)session.getAttribute("MemberDto");
	out.print("id :" + dto.getId());
	out.print("name :" + dto.getName());
	out.print("regidate :" + dto.getRegidate());
%>


</body>
</html>