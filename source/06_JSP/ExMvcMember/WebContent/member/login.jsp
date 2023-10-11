<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath}/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<c:if test="${not empty joinResult }">
<script>
	alert('${joinResult }');
</script>
</c:if>
	로그인페이지입니다.
	<form action = "${conPath }/login.do" method = "post">
	<input type = "hidden" name = "next" value = "${param.next }">	
	<table>
		<tr>
			<td> ID : <input type = "text" name = "mid" value = "${member.mid }">
			</td>				
		</tr>
		<tr>
			<td> PW : <input type = "password" name = "mpw">
		</td>	
		</tr>
		<tr>
			<td>
			<input type = "submit" value = "로그인" class = "btn">				
			<input type = "button" onclick = "location.href='${conPath }/joinView.do'" value = "회원가입" class = "btn">
			<input type = "button" onclick = "location.href='${conPath}/main.do'" value = "메인으로" class = "btn">
			</td>
		</tr>
	</table>	 
	</form>
</body>
</html>