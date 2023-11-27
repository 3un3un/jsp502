<%@page import="com.z3un3un.lib.dto.BookDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function goPage(pageNo) {
				
	}
</script>
<title>Insert title here</title>
<!-- 부트스트랩 css -->
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<style type="text/css">
.pointer {
	cursor: pointer;
}
</style>


</head>
<body>
	<!-- header 추가 -->
	<%@ include file="../header.jsp"%>

	<script type="text/javascript">
/*
	스크립트에서 함수를 정의하는 방법
 	function 함수명(파람0, 파람1, ...) {
	
	}
	함수의 호출
	함수명(파람0, 파람1, ...);
	
 */
  window.onload = function() {
 	let regBtn = document.querySelector('#regBtn');
 	regBtn.addEventListener('click', function(){
 		location.href= '/book/reg.jsp';
 	});
 	
 	let searchBtn = document.querySelector('#searchBtn');
 	searchBtn.addEventListener('click', function(){
 		searchForm.searchField.value;
 		searchForm.searchWord.value;
 		searchForm.action ='/book/list';
 		searchForm.submit();
 	});
 	
	 
 } 
 
 
 
 
 function msg(str) {
	 alert(str);
 }

 //화면 요청
 function view(no){
	 location.href = "/book/view?no=" + no;
 }
 
 function goPage(pageNo){
	 searchForm.pageNo.value = pageNo;
	 //searchForm.pageNo.value = 1;
	 searchForm.submit();
	 
 }
 
 
</script>

	<!-- 메인컨텐츠 영역 -->
	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">도서관</h1>
		<p class="mb-4">
			DataTables is a third party plugin that is used to generate the demo
			table below. For more information about DataTables, please visit the
			<a target="_blank" href="https://datatables.net">official
				DataTables documentation</a>.
		</p>

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">도서목록</h6>
			</div>
			<!-- searchForm 시작 -->
			<div class="card-body">
				<div class="table-responsive">
					<form name="searchForm" action="/book/list">
					
						pageNo : <input type="text" name="pageNo"
							value="${pageDto.cri.pageNo }"> num : <input type="text"
							name="no" value="${dto.num }">
					
						<div class="input-group">
							<select class="form-select" name="searchField"
								aria-label="Example select with button addon">
								<!-- 선택된 요소의 value값이 서버로 넘어간다. -->
								<option value="title"
									${pageDto.cri.searchField eq 'title' ? 'selected' : ''}>도서명</option>
								<option value="author"
									${pageDto.cri.searchField eq 'id' ? 'selected' : ''}>작가</option>
							</select> <input type="text" name="searchWord"
								value="${pageDto.cri.searchWord }" class="form-control"
								aria-label="Text input with dropdown button">
							<button class="btn btn-outline-secondary" id="searchBtn"
								type="submit">검색</button>
						</div>
					</form><br>
			
					<!-- searchForm 끝 -->

					<!-- 등록하기 -->
					<p>
						<button class="btn btn-dark" id="regBtn">도서등록</button>
					</p>
					<!-- 등록하기 끝 -->

					<!-- 만든 부분 -->
					<table class="table">
						<thead>
							<tr>
								<th scope="col">도서번호</th>
								<th scope="col">도서명</th>
								<th scope="col">작가</th>
								<th scope="col">대여여부</th>
							</tr>
						</thead>
						<tbody>
							<!-- 리스트가 비어있다면 메세지 출력 -->
							<c:if test="${empty list }" var="res">
								<tr>
									<td colspan="4">도서목록이 존재하지 않습니다.</td>
								</tr>
							</c:if>
							<!-- 리스트가 비어있지 않다면 도서목록 출력 -->
							<c:if test="${!res }">
								<c:forEach items="${list }" var="dto">
									<tr>
										<th scope="row">${dto.no}</th>
										<td class="pointer" onclick="view(${dto.no })">${dto.title}</td>
										<td>${dto.author}</td>
										<!-- rentyn값(Y/N)에 따라 출력하기 -> 대여/대여중 -->
										<td>${dto.rentynStr}</td>
									</tr>
								</c:forEach>
							</c:if>

						</tbody>
					</table>
					<!-- 만든 부분 끝 -->

				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->
	<!-- 메인컨텐츠 영역 끝 -->





	<!-- page navi -->
	<!-- pageDto -->
	<%@ include file="/06session/servletEx/pageNavi.jsp"%>

	<!-- footer 추가 -->
	<%@ include file="../footer.jsp"%>
	<!-- 부트스트랩 js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>