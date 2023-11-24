<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 메세지 출력후 다른 페이지를 요청 하거나 뒤로가기 합니다. -->
<script type="text/javascript">
	//서버로부터 전달받은 메세지를 출력한다.
	let msg = '${msg}';
	
	//서버로부터 전달받은 url로 이동한다.
	//단, url이 없다면 뒤로가기를 시행한다.
	let url = '${url }';
	
	
	if(msg != ''){
		alert('${msg }');
	}
	
	// 만약 url에 값이 있다면 url 요청(location.href=url)
	if(url != ''){
		//웹브라우저객체 DOM
		location.href = url; // url로 이동
	} else {
		// 뒤로가기	
		history.back();
	}
</script>

</body>
</html>