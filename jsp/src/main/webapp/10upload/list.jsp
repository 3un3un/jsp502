<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="">
<button>목록</button>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>카테고리</th>
			<th>ofile</th>
			<th>sfile</th>
			<th>게시날짜</th>
		</tr>
		
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.file_no }</td>
			<td>${dto.name }</td>
			<td>${dto.title }</td>
			<td>${dto.cate }</td>
			<td>${dto.ofile }</td>
			<td>${dto.sfile }</td>
			<td>${dto.postdate }</td>
		</tr>
	</c:forEach>
	
	</table>
</form>
<!-- ofile : 원본파일명
	 sfile : 저장된 파일명
 -->
<a href="filedownload.jsp?ofile=이클립스 위치.txt
		&sfile=이클립스 위치_202311332_102029916.txt">
	파일명(링크 - ofile)</a>






















</body>
</html>