<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/emp.css" rel = "stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous">
</script>
<script>
	$(document).ready(function(){
		$('input[type="text"]').keyup(function(){
			$('form').submit();
		});
		$('select').change(function(){
			$('form').submit();
		});
	});
</script>
</head>
<body>
	<div id = "wrap">
		<form action = ""> 
		<!-- 이 페이지로 온 것이 이미 emp.do이므로, form에서 "" 를 해도 emp.do?패러미터= 등으로 온다. -->
			사원명 <input type = "text" name = "ename" size = "5" value = "${searchEmp.ename }">
			직책 <input type = "text" name = "job" size = "5" value = "${searchEmp.job }">
			부서번호
			<select name = "deptno">
				<option value = "0">전체</option>
				<c:forEach var = "dept" items = "${deptList }">
				<option value = "${dept.deptno }"
					<c:if test = "${param.deptno eq dept.deptno}">
					selected = "selected"
					</c:if>					
				>
				${dept.deptno } - ${dept.dname } - ${dept.loc }
				</option>								
				</c:forEach>				
			</select>
			<!-- <input type = "submit" value = "검색"> -->			
		</form>
		부서정보들 : ${deptList }	
		<table>
			<tr>
				<th>사원번호</th>
				<th>사원명</th>
				<th>직책</th>
				<th>관리자</th>
				<th>입사일</th>
				<th>급여</th>
				<th>상여</th>
				<th>부서번호</th>				
			</tr>
			<c:if test = "${empList.size() eq 0 }">
				<tr>
					<td colspan = "8">
					검색 결과에 맞는 사원이 없습니다.
					</td>
				</tr>
			</c:if>
			<c:forEach var = "emp" items = "${empList }">
				<tr>
					<td>${emp.empno }</td>
					<td>${emp.ename }</td>
					<td>${emp.job }</td>
					<td>${emp.mgr == 0? "상사없음": emp.mgr }</td>
					<td><fmt:formatDate value ="${emp.hiredate }" pattern="yy년MM월dd일(E)"/></td>
					<td>
						${emp.sal }
					</td>
					<td>${emp.comm }</td>
					<td>${emp.deptno }</td>					
				</tr>
			</c:forEach>
		</table>		
		사원정보들 : ${empList }
	</div>	
</body>
</html>