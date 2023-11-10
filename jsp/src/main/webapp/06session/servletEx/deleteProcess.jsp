<%@page import="com.z3un3un.utils.JSFunction"%>
<%@page import="com.z3un3un.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	if(request.getParameter("num") != null) {
		String num = request.getParameter("num").toString();
		BoardDao dao = new BoardDao();
		if(dao.deleteBoard(num) != 1) {
			JSFunction.alertBack("존재하지 않는 게시글입니다.", out);
		}
		
		//정상적으로 삭제처리가 된 경우
		//메세지 처리 후 리스트 페이지로 이동한다.
		JSFunction.alertLocation("삭제되었습니다.", "/boardList", out);
	} else {
		/*
		out.print("<script type='text/javascript'>");
		//메세지 출력 후 이전 페이지로 출력하기
		out.print("alert('게시물번호(num)를 확인할 수 없습니다.');");
		//뒤로가기
		out.print("history.back()");
		out.print("</script>");
		*/
		//JSFunction으로 코드 줄이기
		String msg = "게시물번호(num)를 확인할 수 없습니다.";
		JSFunction.alertBack(msg, out);
	}
%>

</body>
</html>