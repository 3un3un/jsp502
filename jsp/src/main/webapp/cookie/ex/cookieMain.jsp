<%@page import="com.z3un3un.utils.CookieManager"%>
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
<script>
	//모두 같다. js에서도 자바 사용가능하다는 것 기억하기
	//alert("none");
	//alert("<%=none%>");
	//alert('<%="none"%>');

	//alert("안녕하세요");
	//alert("<%=str%>");
	//alert('<%="안녕하세요"%>');
	
	/*
	document.querySelector('선택자');
	선택자
	.클래스
	#아이디
	태그명
 	*/
	//document.querySelector("#popup");
	//display속성을 none으로 설정하면 화면에서 출력
	//popup.style.display = 'none';
	//display속성을 block으로 설정하면 화면에서 출력
	//document.querySelector("#popup").style.display='block';
	/*
		querySelector : 요소를 하나 선택
		querySelectorAll
			- 여러 개의 요소를 선택할 때 사용
			- nodeList를 반환하며 리스트와 같이 ([0]) 방번호를 이용해 접근이 가능하다.
			ex)document.querySelectorAll('.none')[0]
	*/
	
	window.onload = function(){
		//popupCookie 쿠키가 없으면 팝업을 화면에 출력
		<%
		String display = "none";
		String popupCookie = CookieManager.readCookie(request, "popupCookie");
		//out.print("popupCookie : " + popupCookie);
		if(!"Y".equals(popupCookie)){
			display = "block";
		}
		%>
		//화면에 출력
		document.querySelector("#popup").style.display="<%=display%>";
			
			//닫기버튼 클릭하면 form 전송
			document.querySelector("#closeBtn").onclick = function() {
				//닫기버튼 클릭 시 체크박스 체크되었는지 확인
					
				//document.querySelector("input[id=inactiveToday]")
				if(document.querySelector("input[id=inactiveToday]:checked")){
					popupForm.submit();
				} else {
				document.querySelector("#popup").style.display='none';
				}
					
			}
		}

	
	
</script>

<!--
	<%=none %> : 변수선언 후에 사용
	<%="none" %>
	태그에 속성을 정의할 때, 홑따옴표 또는 쌍따옴표로 감싸주는 이유는
	해당 속성의 값이 어디까지인지 정의하는 것
	
	class 속성에 값을 여러 개 정의할 수 있다.
	class="none w30"
  -->
 <h2 class="none">쿠키 - 팝업 연습</h2>
<form action="cookieAction.jsp" name="popupForm">
<%
	//String popupCookie = CookieManager.readCookie(request, "popupCookie");
	//out.print("popupCookie : " + popupCookie);
	//if(!"Y".equals(popupCookie)) {
	
%>
	<div id="popup" class="none">
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right">
	            <input type="checkbox" checked id="inactiveToday"
	            	name = inactiveToday value="Y" /> 
	            하루 동안 열지 않음
	            <input type="button" value="닫기" id="closeBtn" /> 
        </div>
    </div>
    //<%
    //}
    //%>
</form> 
</body>
</html>