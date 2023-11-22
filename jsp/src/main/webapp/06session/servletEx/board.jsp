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
	
	//select 요소의 옵션을 선택하는 방법
	var searchField = '${pageDto.cri.searchField }'; //선택한 옵션
	console.log("searchField : ", searchField);
	var options = searchForm.searchField.options;
	
	//select 요소 옵션 selected 속성 제거
	for(let i=0; i<options.length; i++) {
		options[i].removeAttribute("selected");
	}
	//선택한 옵션일 때 select 요소 옵션의 selected 속성 부여
	for(var i=0; i<options.length; i++){
		console.log(options[i].value);
		if(options[i].value == searchField) {
			options[i].setAttribute("selected", "selected");
		}
	}
	
	
}

//함수는 onload() 외부에 작성합니다.
/**
 * 입력받은 페이지 번호로 이동한다.
 */
function goPage(pageNo){
	//파라메터로 넘어온 페이지 번호를 searchForm에 pageNo을 입력
	searchForm.action = '/boardList';
	searchForm.pageNo.value = pageNo;
	searchForm.submit();
}
/**
 * 상세페이지로 이동
 */
function goDetail(num){
	//파라메터로 넘어온 페이지 번호를 searchForm에 pageNo을 입력
	searchForm.action = '/boardRead';
	searchForm.num.value = num;
	searchForm.submit();
	

}

/**
 * 폼을 전송(요청)합니다.
 */
 function formSubmit(){
	//1. 폼을 선택 - 폼의 이름을 불러준다.
	//2. 폼의 요소를 선택 - 폼.요소의 이름
	searchForm.pageNo.value = '페이지 번호';
	//form.action = '';
	//3. 폼 전송하기 - form의 action속성에 정의된 url을 요청합니다.
	//			 - 폼안에 요소들을 파라메터로 전달
	searchForm.submit();
	
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
<%@include file="header.jsp"  %>


<!-- 변수를 4가지 영역 중 한 곳에 저장 -->
<%-- 리스트 : ${list } --%>
<!-- 만약 리스트의 사이즈가 0이라면 조회된 데이터가 없습니다 출력
	 만약 리스트의 사이즈가 0이 아니라면 목록을 출력 -->


<table width="90%" align="center">
	<tr>
		<td>
<h2>게시글 목록</h2>
<!-- 검색폼 --> 
<%-- pageDto : ${pageDto }
<br>cri : ${pageDto.cri }
<br>pageNo : ${pageDto.cri.pageNo }
<br>searchField : ${pageDto.cri.searchField }
<br>searchWord : ${pageDto.cri.searchWord } --%>


<form name="searchForm">
pageNo : <input type="text" name="pageNo" value="${pageDto.cri.pageNo }">
num : <input type="text" name="num" value="${dto.num }">
<div class="input-group">
  <select class="form-select" name="searchField" aria-label="Example select with button addon">
				<!-- 선택된 요소의 value값이 서버로 넘어간다. -->
				<option value="title"
					${pageDto.cri.searchField eq 'title' ? 'selected' : ''}
					>제목</option>
				<option value="id" 
				${pageDto.cri.searchField eq 'id' ? 'selected' : ''}
				>작성자</option>
				<option value="content"
				${pageDto.cri.searchField eq 'content' ? 'selected' : ''}
				>내용</option>
  </select>
   <input type="text" name="searchWord" value="${pageDto.cri.searchWord }" class="form-control" aria-label="Text input with dropdown button">
  <button class="btn btn-outline-secondary" id="subBtn" type="submit">검색</button>
</div>

</form>


<table border="1" class="table">
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

<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.num }</td>
		<td><a onclick="goDetail(${dto.num })">${dto.title }</a></td>
		<td>${dto.content }</td>
		<td>${dto.id }</td>
		<td>${dto.postdate }</td>
		<td>${dto.visitcount }</td>
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

		</td>
	</tr>
</table>

</body>
</html>