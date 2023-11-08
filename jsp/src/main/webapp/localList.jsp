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

	//jsp를 단독으로 실행할 경우, null이 출력될 수 있다.
	//servlet에서 request에 list를 저장하기 때문에 servlet에서 실행해야 원하는 값이 나온다.
	List<LocDto> list = (List<LocDto>)request.getAttribute("list");
	out.print(list);
%>

</body>
</html>