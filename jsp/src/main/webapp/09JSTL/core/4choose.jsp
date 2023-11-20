<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>다중 조건문</h2>

<p>홀짝 판단하기</p>
<!-- 변수 선언 -->
<c:set var="num" value="101" />

<!-- 다중 조건문 사용하기 -->
<c:choose>
	<c:when test="${num % 2 eq 0 }">
	num(${num })은 짝수입니다.	
	</c:when>
	<c:otherwise >
	num(${num })은 홀수입니다.	
	</c:otherwise>
</c:choose>


<h2>국, 영, 수 점수를 입력하면 평균을 내어 학점을 출력</h2>
<p> >=90 : A학점, >=80 : B학점, >= 70 : C학점, >=60 : D학점</p>


<form action="">
	<br>국어 : <input type="text" name="kor" >
	<br>영어 : <input type="text" name="eng" >
	<br>수학 : <input type="text" name="math" >
	<br>
	<button id="btn">학점 구하기</button>
</form>

<c:set var="avg" value="${(param.kor+param.eng+param.math)/3}" />
	국어 : ${param.kor }<br>
	영어 : ${param.eng }<br>
	수학 : ${param.math }<br>
	평균 ${avg }<br>
<c:choose>
	<c:when test="${avg >= 90} ">
	A학점입니다.<br>
	${avg}
	</c:when>
	<c:when test="${avg >= 80} ">
	B학점입니다.<br>
	${avg}
	</c:when>
	<c:when test="${avg>= 70} ">
	C학점입니다.<br>
	${avg}
	</c:when>
	<c:otherwise>
	D학점입니다.<br>
	</c:otherwise>
</c:choose>




</body>
</html>