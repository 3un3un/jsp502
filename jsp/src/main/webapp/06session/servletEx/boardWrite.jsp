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

	out.print("title : " + title);
	out.print("content : " + content);
%>
<script type="text/javascript">
window.load
writeBtn.onclick()

</script>


<h2>게시글 작성</h2>
<form action="">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea style="width:95%; height:100px" name="content"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			
			<button type="submit" name="writeBtn">작성</button>
			<button type="reset" name ="resetBtn">초기화</button>
			<button type="button" name = "listBtn">목록보기</button>
		</tr>
	</table>
</form>

</body>
</html>