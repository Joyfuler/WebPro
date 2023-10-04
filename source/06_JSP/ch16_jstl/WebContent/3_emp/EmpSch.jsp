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
	<script>
		function resetParam(){						
			document.getElementsByName("schName")[0].value = '';			
			document.getElementsByName("schJob")[0].value = '';
		}
	</script>
</head>

<body>
	<form action = "">
	<p class = "paging">
	이름 <input type = "text" name = "schName" value = "${param.schName.toUpperCase().trim() }"> 
	직책<input type = "text" name = "schJob" value = "${param.schJob.toUpperCase().trim() }"><input type = "submit" value = "검색">
	<input type = "button" value = "초기화" onclick = "resetParam()">
	</p>
	</form>
		<table>
		<tr>
		<td>사번</td><td>이름</td><td>직책</td><td>상사사번</td><td>입사일(시간)</td><td>급여</td><td>상여</td><td>부서번호</td>
		</tr>		
		<c:forEach var = "emp" items = "${lists}">
		<c:if test="${emp.isEmpty()}">
		<td>등록된 사원이 없습니다.</td>
		</c:if>
		<c:if test="${emp.isEmpty()}">
		<tr>
		<td>${emp.empno }</td>
		<c:if test="${emp.sal > 2000 }">
		<td><img src = "${conPath }/3_emp/img/hot.gif"><b>${emp.ename }</b></td>
		</c:if>
		<c:if test="${emp.sal <=2000 }">
		<td>${emp.ename }</td>
		</c:if>		
		<td>${emp.job }</td>
		<td>${emp.mgr == 0 ? "상사없음": emp.mgr}</td>
		<td><fmt:formatDate value="${emp.hiredate }" type = "both" dateStyle="long" timeStyle="short"/></td>
		<td><fmt:formatNumber value = "${emp.sal }" groupingUsed="true"/></td>
		<td><fmt:formatNumber value = "${emp.comm }" groupingUsed="true"/></td>
		<td>${emp.deptno }</td>		
		</tr>
		</c:if>
		</c:forEach>
		</table>			
</body>
</html>