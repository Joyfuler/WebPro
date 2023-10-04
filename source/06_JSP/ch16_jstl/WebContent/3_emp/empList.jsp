<%@page import="com.lec.emp.EmpDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.emp.EmpDao"%>
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
	<%--requestScope.emps를 출력 --%>
	<table>
		<tr>
			<th>사번</th><th>급여</th><th>이름</th><th>직책</th><th>상사사번</th><th>입사일(t)</th>
			<th>입사일(d)</th><th>상여</th><th>부서</th>
		</tr>	
		<c:if test="${lists.size() eq 0 }"> <%--requestScope.emps에서 앞을 생략해도 무방. --%>
			<tr><td colspan = "9"> 등록된 사원이 없습니다. </td></tr>
		</c:if>
		<c:if test="${lists.size() != 0}">
			<c:forEach var= "emp" items="${lists }">
				<tr>
					<td> ${emp.empno }</td> <!-- 기존의 경우 getEmpno()등으로 사용했으나 el이라면 그냥 사용가능 -->
					<td>
						<c:if test="${emp.sal >=2500 }"><%--월급이 2500이상이면 그림 hot --%>
							<img src = "${conPath }/3_emp/img/hot.gif"><fmt:formatNumber value = "${emp.sal }" groupingUsed="true"/>				
						</c:if>
						<c:if test="${emp.sal <2500 }">
							<fmt:formatNumber value = "${emp.sal }" groupingUsed="true"/>
						</c:if>	
					</td>
					<td>	
						<c:if test ="${emp.mgr eq 0 }"> <%--상사가 없는 킹왕짱이라면 강조 --%>
						<b style = "color:red">${emp.ename }</b>
						</c:if>
						<c:if test = "${emp.mgr != 0 }">
						${emp.ename }
						</c:if>
					</td>
					<td>${emp.job }</td>
					<td>${emp.mgr eq 0 ? "-" : emp.mgr }</td>
					<td><fmt:formatDate value="${emp.hiredate }" pattern = "yy년 MM월 dd일 (E)요일 hh:mm(a)"/></td>
					<td><fmt:formatDate value="${emp.hiredate }" type = "both" dateStyle="long" timeZone="short"/></td>
					<td>
						<c:if test="${emp.comm eq 0 }"> - </c:if>
						<c:if test="${emp.comm != 0 }"><fmt:formatNumber value ="${emp.comm }" groupingUsed="true"></fmt:formatNumber></c:if>
					</td>
					<td>${emp.deptno }</td>	
				</tr>
			</c:forEach>
		
		</c:if>
			
	</table>
</body>
</html>