<%@page import="com.z3un3un.dto.Criteria"%>
<%@page import="com.z3un3un.dto.PageDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


<%
	// Controller에서 request 영역 저장한 pageDto를 화면에서 사용할 수 있도록 변수에 저장한다.
	PageDto pageDto = null;
	if(request.getAttribute("pageDto") != null
		&&!"".equals(request.getAttribute("pageDto"))){
		pageDto = (PageDto)request.getAttribute("pageDto");
	} else {
		pageDto = new PageDto(0, new Criteria());
	}



/* 	int totalCnt = 160;
	Criteria cri = new Criteria(); // 기본값 pageNo = 1, amount = 10
	cri.setPageNo(13);
	PageDto pageDto = new PageDto(totalCnt, cri); */

%>
<%-- <jsp:useBean id ="pageDto" class="com.z3un3un.dto.pageDto"></jsp:useBean>
<jsp:getPropery property="pageNo" name="pageDto2"/> --%>


</head>
<body>

<!-- 페이지 네비게이션 -->
<nav aria-label="...">
  <ul class="pagination">
  	<!-- 앞으로 가기 버튼 disabled : 비활성화 -->
    <li class="page-item <%= pageDto.isPrev() ? "" : "disabled"%>">
      <a class="page-link" href="/boardList?pageNo=<%=pageDto.getStartNo()-1%>">Previous</a>
    </li>
    <!-- 앞으로 가기 버튼 끝 -->
    
    <% for(int i=pageDto.getStartNo(); i<=pageDto.getEndNo(); i++) {%>
	    <li class="page-item">
	    	<a class="page-link <%=pageDto.getCri().getPageNo() == i ? "active" : ""%>" 
	    	href="/boardList?pageNo=<%=i %>">
	    	 	<%=i %></a>
	    </li>
    
    <%} %>

        
    <!-- 뒤로가기 버튼 시작 -->
    <li class="page-item <%= pageDto.isNext()? "" : "disabled"%>">
      <a class="page-link" href="/boardList?pageNo=<%=pageDto.getEndNo()+1 %>">Next</a>
    </li>
    <!-- 뒤로가기 버튼 시작 끝 -->
  </ul>
</nav>


<!-- 부트스트랩 JS -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>