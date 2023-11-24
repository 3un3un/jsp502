<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<button>목록</button>
<button>수정</button>
<button>삭제</button>
<h2>도서 정보</h2>
요청도서번호 : ${param.no }
<ul>
	<li>도서정보 : ${bookDto.title}</li>
	<li>작가 : ${bookDto.author}</li>
	<li>rentyn : ${bookDto.rentyn}</li>
	<li>${bookDto.rentynStr}</li>
</ul>


</body>
</html>