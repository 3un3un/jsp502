<%@page import="com.z3un3un.lib.dto.PageDto"%>
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
<!-- header 외부파일 인클루드 -->
<%@ include file="common/header.jsp" %>

<!-- 도서목록을 출력한다. -->
도서목록을 출력합니다.

<form>
	<table border="1">
		<tr>
			<th>일련번호</th>
			<th>제목</th>
			<th>작가</th>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<td>${dto.no}</td>
			<td>${dto.title}</td>
			<td>${dto.author}</td>
		</tr>
		</c:forEach>
	</table>

</form>
<!-- 페이징 -->
<%
PageDto pageDto = null;
if(request.getAttribute("pageDto") != null) {
	pageDto = (PageDto)request.getAttribute("pageDto");
}
%>
<nav aria-label="...">
  <ul class="pagination">
  	<!-- 앞으로 가기 버튼 disabled : 비활성화 -->
    <li class="page-item <%= pageDto.isPrev() ? "" : "disabled"%>">
      <a class="page-link" onclick="goPage(<%=pageDto.getStartNo()-1%>)">Previous</a>
    </li>
    <!-- 앞으로 가기 버튼 끝 -->
    
    <% for(int i=pageDto.getStartNo(); i<=pageDto.getEndNo(); i++) {%>
	    <li class="page-item">
	    <!-- href="..."링크로 이동할 경우, 검색어가 유지되지 않는다. -->
	    <!-- 검색어를 유지하기 위해 searchForm을 전송하도록 goPage함수를 생성했다. -->
	    <!-- 링크를 함수호출로 변경 onClick이벤트가 발생하면 goPage() 함수를 호출한다.
	    	함수의 파라메터로 페이지번호를 넣어줘야 한다.
	    	
	    -->
	    	<a class="page-link <%=pageDto.getCri().getPageNo() == i ? "active" : ""%>" 
	    	onclick="goPage(<%=i %>)">
	    	 	<%=i %></a>
	    </li>
    
    <%} %>

        
    <!-- 뒤로가기 버튼 시작 -->
    <li class="page-item <%= pageDto.isNext()? "" : "disabled"%>">
      <a class="page-link" onclick="goPage(<%=pageDto.getEndNo()+1 %>)">Next</a>
    </li>
    <!-- 뒤로가기 버튼 시작 끝 -->
  </ul>
</nav>

<!-- footer 외부파일 인클루드 -->
<%@ include file="common/footer.jsp" %>
</body>
</html>