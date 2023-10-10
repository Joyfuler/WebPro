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
<!-- 회원가입을 완료한 후에도 로그인 페이지로 올 것이므로 이 때 넘어오는 패러미터를 처리해준다. id에 회원가입시 입력했던 id를 입력 -->
	<c:if test="${not empty joinResult  }">
		<script>
		alert('${joinResult}');
		</script>
	</c:if>
	<c:if test="${not empty joinErrorMsg }"> <!--  회원가입 실패시. -->
		<script>
		alert('${joinErrorMsg}');
		history.back();
		</script>
	</c:if>	
	<form action = "${conPath }/login.do" method = "post">
		<input type = "text" name = "next" value = "${param.next }"> 
		<table>
			<caption>로그인</caption>
			<tr>
				<th> 아이디 </th><td><input type = "text" name = "mid" value = "${mid }" required = "required">
				<!-- el이라면 굳이 !=null 등을 입력하지 않더라도 nullpointerException이 발생하지 않음. -->
			</tr>
			<tr>
				<th> 비밀번호</th><td><input type = "password" name = "mpw" required = "required"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<p>
						<input type = "submit" value = "로그인">
						<input type = "button" value = "회원가입" onclick = "location.href='${conPath}/joinView.do'">
					</p>
				</td>	
			</tr>				
		</table>
	</form>
</body>
</html>