<%@page import="com.z3un3un.dto.LocDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서 목록</h2>
<%
List<LocDto> list = (List<LocDto>)request.getAttribute("list");
	out.print(list);
%>

</body>
</html>