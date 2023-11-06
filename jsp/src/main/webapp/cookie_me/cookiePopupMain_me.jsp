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
<script>


//html 먼저 띄운 후
window.onload = function(){
	//닫기 버튼 클릭시
	closeBtn.onclick = function(){
		//체크박스 체크하면 alert, 해제하면 팝업창 없애기
		if(document.querySelector('#inactiveToday').checked){
			alert('체크박스 체크되었음.');
			
			popupForm.submit();		
			
		} else {
			document.querySelector("#popup").style.display = 'none';
			console.log("체크박스 해제되었음.");
		}
		
		
		
		
		
	}
	
	
}


</script>










<form action="cookiePopupAction_me.jsp" name="popupForm">
	<div id="popup" >
        <h2 align="center">공지사항 팝업입니다.</h2>
        <div align="right">
	            <input type="checkbox" id="inactiveToday"
	            	name = inactiveToday value="Y" --checked-- /> 
	            하루 동안 열지 않음
	            <input type="button" value="닫기" id="closeBtn" /> 
        </div>
    </div>    

	
   </form>




</body>
</html>