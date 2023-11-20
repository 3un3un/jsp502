<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.z3un3un.dto.Criteria"%>
<%@page import="com.z3un3un.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.z3un3un.dao.BoardDao"%>
<%@page import="com.z3un3un.dto.MemberDto"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<script>
//화면에서 동적 처리
window.onload = function() {
	console.log('onload event ================');
	let logoutBtn = document.querySelector("#logoutBtn");
	if(logoutBtn != null) {
		logoutBtn.onclick = function(){
			//로그아웃
			loginForm.action="/logout";
			loginForm.submit();
		}
	}	
	let loginBtn = document.querySelector("#loginBtn");
	if(loginBtn != null) {
		loginBtn.addEventListener('click', function(){
			//로그인페이지로 이동
			//같은 경로
			loginForm.action="/06session/servletEx/loginForm.jsp";
			loginForm.submit();
			
		});
		
	
	}
}
</script>
<!-- 로그인 여부를 체크
	로그인을 했을 때 = 세션에 userId가 저장되어 있으면 
		- 로그아웃 버튼을 출력
	없으면
		- 로그인 버튼을 출력

-->

<!-- 
	submit : form의 요소들을 파라메터로 가지고 서버에 요청
	action : 서버에 요청할 url 주소
	method : 요청 방식
				get : 조회용 파라메터
				post : 등록, 수정용 파라메터
	*버튼 생성했더라도 form안에 버튼이 하나밖에 없다면 해당 버튼은 submit 버튼이 된다.

 -->
<form method="get" name="loginForm">

	<c:if test="${not empty userId }">
	${userId }님 환영합니다.
	<button id="logoutBtn">로그아웃</button>
	</c:if>

	<c:if test="${empty userId }">
	<button id="loginBtn">로그인</button>
	</c:if>


</form>
<h2>게시판</h2>

<!-- 변수를 4가지 영역 중 한 곳에 저장 -->
<%-- 리스트 : ${list } --%>
<!-- 만약 리스트의 사이즈가 0이라면 조회된 데이터가 없습니다 출력
	 만약 리스트의 사이즈가 0이 아니라면 목록을 출력 -->
	 
<table border="1">
	<tr>
		<th>일련번호</th>
		<th style="width:20%">제목</th>
		<th style="width:20%">내용</th>
		<th>작성자</th>
		<th style="width:20%">작성일</th>
		<th>조회수</th>
	</tr>
	
<c:if test="${empty list}">
	<tr>
		<td colspan="6">게시판이 존재하지 않습니다.</td>
	</tr>
</c:if>

<c:if test="${!empty list}">

<c:forEach var="boardDto" items="${list }">
	<tr>
		<th><a href="/boardRead?num=${dto.getNum() }">${boardDto.num }</a></th>
		<th>${boardDto.title }</th>
		<th>${boardDto.content }</th>
		<th>${boardDto.id }</th>
		<th>${boardDto.postdate }</th>
		<th>${boardDto.visitcount }</th>
	</tr>
</c:forEach>
</c:if>
</table>
<hr>


<!--  페이지 네비게이션 작성
	- 페이지 번호 pageNo
	- 페이지블럭당 페이지 수 ? ->아래에서 pagePerBlock으로 생성
		페이지블럭의 시작번호 ~ 페이지블럭의 끝번호
		
	- 총 게시물의 수 totalCnt
	- 페이지당 게시물의 수 amount
		진짜 블럭의 끝번호

 -->
 
 <!-- pageNavi include -->
<%@include file="pageNavi.jsp" %> 



</body>
</html>