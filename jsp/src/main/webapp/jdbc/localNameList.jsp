<%@page import="com.z3un3un.dto.LocDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.z3un3un.dao.LocDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>출력하기</h2>

<%
	LocDao dao = new LocDao(application);
	List<LocDto> list = dao.getList();
	dao.close();
	
%>

<table border="1">
	<tr>
		<td>부서ID</td>
		<td>부서명</td>
		<td>지역명</td>
	</tr>
	<%
	for(LocDto dto : list) {
	%>
	<tr>
		<td><%= dto.getDept_id() %></td>
		<td><%= dto.getDept_title()%></td>
		<td><%= dto.getLocal_name()%></td>
	</tr>

	<%
	}
	%>
	
</table>

</body>
</html>