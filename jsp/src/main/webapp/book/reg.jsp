<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.w-15{width:15%}
	.w-20{width:20%}
</style>
</head>
<body>
<script type="text/javascript">
window.onload = function() {
 	let bookRegBtn = document.querySelector('#bookRegBtn');
 	bookRegBtn.addEventListener('click', function(){
 		bookRegForm.submit();
 	});
	 
 }

</script>
<!-- 도서등록 화면 -->
<%@include file="/header.jsp" %>
<!-- 메인컨텐츠 영역 -->
<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- DataTales Example -->
  <div class="card shadow mb-4">
       <div class="card-header py-3">
        	<h6 class="m-0 font-weight-bold text-primary">도서등록</h6>
		</div>
		<div class="card-body">
			<!-- 등록폼 -->
			<form action='/book/bookRegProcess' name="bookRegForm" method="post">
				<div class="input-group mb-3">
		  			<span class="w-15 input-group-text" id="basic-addon1">도서명</span>
		  			<!-- 서버에 값을 넘길 요소 -->
		  			<input type="text" class="form-control" name="title"
		  			 aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
		  			<span class="w-15 input-group-text" id="basic-addon1">작가명</span>
		  			<!-- 서버에 값을 넘길 요소 -->
		  			<input type="text" class="form-control" name="author"
		  			 aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
		  			<span class="w-15 input-group-text" id="basic-addon1">도서소개</span>
		  			<!-- 서버에 값을 넘길 요소 -->
		  			<input type="text" class="form-control" name="content"
		  			 aria-label="Username" aria-describedby="basic-addon1">
				</div>
				<div class="input-group mb-3">
					<span class="w-15 input-group-text" id="basic-addon1">표지이미지</span>
  						<input type="file" class="form-control" name="imgFile"
  						id="inputGroupFile01">
				</div>
				<button class="btn btn-dark" id="bookRegBtn">도서등록</button>
			</form>
		</div>
		
	</div>
</div>




<%@ include file="/footer.jsp" %>
</body>
</html>