<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<!-- 이전 방식 -->
	<% 
	String[] names = {"홍길동","신길동","김길동"};
	// request.setAttribute("names", names); 사용x
	/* for (String name: names){
		out.print("<p>" + name + "</p>");
	}
	for (int idx=0; idx<names.length; idx++){
		out.print("<p>" + idx + "번째: " + names[idx] + "</p>");
	} */
	%>
	<c:set var = "names" value = "<%=names %>"/>
	<c:forEach var = "name" items="${names }">
	<!--  확장for문 역시 사용가능 -->
	<p>${name }</p>
	</c:forEach>
	
	<hr>
	<c:forEach var = "name" items="${names }" begin="0" end = "1">
	<p>${name }</p>
	<!--  확장 for문이면서도 begin과 end를 설정하여 일부만 돌 수 있도록 할 수 있음. -->
	</c:forEach>
	<c:set var = "idx" value = "0"/> <!-- idx 변수를 선언하고 0으로 할당함-->
	<c:forEach var = "name" items = "${names }">
	<p> ${idx }번째: ${name }</p>
	<c:set var = "idx" value = "${idx+1 }"/>
	</c:forEach>
	<p> 최종 idx값은 ${idx }입니다.</p>
</body>
</html>