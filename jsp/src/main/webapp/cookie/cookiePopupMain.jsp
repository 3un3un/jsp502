<%@page import="com.z3un3un.utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    div#popup {
        position: absolute; top:100px; left:50px; color:yellow;  
        width:270px; height:100px; background-color:gray;
    }
    div#popup>div {
        position: relative; background-color:#ffffff; top:0px;
        border:1px solid gray; padding:10px; color:black;
    }
</style> 
<title>Insert title here</title>
</head>
<body>
<h2>쿠키를 이용한 팝업창 제어 ver1.0</h2>

<!-- script 화면(요소의) 동적인 제어 -->
<script>
// window객체의 onload이벤트가 발생하면 실행
// HTML요소가 모두 생성된 상태에서 실행 (**코드는 순서대로 실행되기때문)
window.onload = function(){
	
	//팝업클로즈 쿠키의 값이 'Y'이면, 팝업창을 화면에서 숨김처리
	
	//<%
	//String popupClose = CookieManager.readCookie(request, "popupClose");
	//if("Y".equals(popupClose)){
	//%>
	//document.querySelector("#popup").style.dislay='none';
		
	//<%
	//}
	//%>
	
	
	//버튼에 이벤트 추가, 버튼id 이용해서 접근
	closeBtn.onclick = function(){

		//팝업창 숨기기
		//popup.style.display='none';
		
		//체크박스 선택시 alert창 띄우기
		if(document.querySelector('#inactiveToday').checked) { //체크유무
			alert('체크박스가 선택되었습니다.');
		
		// 서버에 요청 방법
		// 1. href query : queryString을 이용해서 파라메터를 전달
		// 2. form submit : form안에 요소들을 가지고 이동
		popupForm.submit(); //메소드로 form 전송하기.
		
		} else {
			//display속성을 none으로 설정하면 화면에서 출력
			popup.style.display = 'none';
			//out.print('체크박스가 선택되지 않았습니다.');
		}
		
		
	}	
}



</script>


<!-- 
	1. 닫기 버튼을 클릭하면 cookiePopupAction.jsp 파일을 호출
		- 팝업닫힘 쿠키를 생성
	
	2. 팝업닫힘 쿠키가 생성이 되어있다면, 더 이상 팝업창을 보여주지 않도록 처리

 -->






<form action="cookiePopupAction.jsp" name="popupForm">

	<%
	String popupClose = CookieManager.readCookie(request, "popupClose");
	//popupClose의 값이 Y가 아니면 팝업을 보여줘
	if(!"Y".equals(popupClose)){
	%>

	<div id="popup" >
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right">
	            <input type="checkbox" checked id="inactiveToday"
	            	name = inactiveToday value="Y" /> 
	            하루 동안 열지 않음
	            <input type="button" value="닫기" id="closeBtn" /> 
        </div>
    </div>    
    <%
	}
	%>
	
   </form>



</body>
</html>