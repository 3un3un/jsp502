<%@page import="com.z3un3un.dto.BoardDto"%>
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
<script type="text/javascript">
window.onload = function() {
	document.querySelector('#listBtn').onclick = function(){
		location.href='/boardList';
		
	}
	deleteBtn.addEventListener('click',()=> { //function대신 화살표 함수 사용
		//jsp를 단독으로 실행할 경우, 경로문제가 발생하지 않는다. (같은 경로에 들어있기 때문)
		//하지만 서블릿을 통해 들어오는 경우, 경로문제가 발생할 수 있다.
		//그래서 루트경로부터 풀 경로를 적어주는 것이 오류가 발생하지 않도록 하는 방법이다.
		location.href='/06session/servletEx/deleteProcess.jsp?num=<%=request.getAttribute("num")%>';
	});
<%-- 	document.querySelector('#deleteBtn').onclick = function() {
		<%
		BoardDao dao = new BoardDao();
		dao.deleteBoard(request.getAttribute("num").toString());

		%>
		alert('삭제완료');
		
	} --%>
	
}


</script>
<h2>게시글 상세보기</h2>
<button id="listBtn"> 리스트로 이동</button>
<button id="editBtn"> 수정</button>
<button id="deleteBtn"> 삭제</button>


<%	
	//String n = request.getAttribute("dto").toString();
	if(request.getAttribute("dto")!=null) {
		BoardDto dto = (BoardDto)request.getAttribute("dto");
	
%>

<br>제목 : <%=dto.getTitle() %>
<br>내용 : <%=dto.getContent() %>
<br>작성자 : <%=dto.getId()%>
<br>작성일 : <%=dto.getPostdate() %>
<br>조회수 : <%=dto.getVisitcount() %>
<%} %>
</body>
</html>