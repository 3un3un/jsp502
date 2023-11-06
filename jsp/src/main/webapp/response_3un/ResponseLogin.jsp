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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if("3un3un".equals(id) && "1234".equals(pw)){
		response.sendRedirect("ResponseWelcome.jsp?id="+id);				
	} else{
		request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
		.forward(request, response);
	}
	
	
	
	
	
%>

</body>
</html>