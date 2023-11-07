<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
</head>
<body>
	<span> "현재 총 ${cnt } 명"</span>	
	<h2> 결과는 다음과 같습니다.</h2>
	<h4> 이 름 : ${student.name }</h4>
	<h4> 국 어 : ${student.kor }</h4>
	<h4> 영 어 : ${student.eng }</h4>
	<h4> 수 학 : ${student.mat }</h4>
	<h4> 총 점 : ${student.total }</h4>
	<h4> 평균 : <fmt:formatNumber value = "${student.avg }" pattern = "#,##0.00"/></h4>
	
	<button onclick = "history.back()">뒤로가기</button><button onclick = "location.href='${conPath}'">다시입력</button>
</body>
</html>