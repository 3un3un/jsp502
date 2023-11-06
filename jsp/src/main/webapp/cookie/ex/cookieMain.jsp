<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.none {
		display:none;
	}
	.w30 {
		width:30px;
	}
</style>
</head>
<body>
<%
	String none = "none";
	String str = "안녕하세요";
%>
<script type="text/javascript">
	//모두 같다. js에서도 자바 사용가능하다는 것 기억하기
	alert("none");
	alert("<%=none%>");
	alert('<%="none"%>');

	alert("안녕하세요");
	alert("<%=str%>");
	alert('<%="안녕하세요"%>');
	
	/*
	document.querySelector('선택자');
	선택자
	.클래스
	#아이디
	태그명
 	*/
	document.querySelector("#popup");
	
</script>

<h2 class="none">쿠키 - 팝업 연습</h2>


<!--
	<%=none %> : 변수선언 후에 사용
	<%="none" %>
	태그에 속성을 정의할 때, 홑따옴표 또는 쌍따옴표로 감싸주는 이유는
	해당 속성의 값이 어디까지인지 정의하는 것
	
	class 속성에 값을 여러 개 정의할 수 있다.
	class="none w30"
  -->
  
  
<div id="popup" class="<%=none%>">
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right">
	            <input type="checkbox" checked id="inactiveToday"
	            	name = inactiveToday value="Y" /> 
	            하루 동안 열지 않음
	            <input type="button" value="닫기" id="closeBtn" /> 
        </div>
    </div>

</body>
</html>