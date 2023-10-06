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
<c:set var = "SUCCESS" value = "1"/>
<c:set var = "FAIL" value = "0"/>
<c:if test = "${modifyResult eq SUCCESS }">
		<script>
		alert('${param.bid } 번 글 수정 성공');
		</script>
	</c:if>	
	<c:if test = "${modifyResult eq FAIL }">
		<script>
		alert('${param.bid } 번 글 수정실패');
		</script>
	</c:if>
<body>
	<table>
		<caption>${param.bid }상세보기</caption>
		<tr>
			<th>글번호</th><td>${contentBoard.bid }</td>
		</tr>
		<tr>
			<th>글제목</th><td>${contentBoard.btitle }</td>
		</tr>	
		<tr>
			<th>글내용</th><td><pre>${contentBoard.bcontent }</pre></td>
		</tr>
		<tr>
			<th>작성일</th><td><fmt:formatDate value = "${contentBoard.bdate }" pattern = "yy/MM/dd일 (E)요일"/></td>
		</tr>
		<tr>
			<th>조회수</th><td>${contentBoard.bhit }</td>
		</tr>
		<tr>
			<th>IP</th><td>${contentBoard.bip }</td>
		</tr>
		<tr>
			<td colspan = "2"> 
				<button onclick = "location.href='${conPath }/updateView.do?bid=${param.bid }&pageNum=${param.pageNum }'">수정</button>
				<button onclick = "location.href='${conPath }/delete.do?bid=${param.bid }&pageNum=${param.pageNum }'">삭제</button>
				<!--  삭제해야 할 글 번호수를 알아야 하므로 bid 필요, 삭제 후 돌아가야 할 페이지를 알아야 하므로 pageNum도 필요. -->
				<button onclick = "location.href='${conPath }/replyView.do?bid=${param.bid }&pageNum=${param.pageNum }'">답변</button>
				<!-- 원글에 대한 bid를 받아서 replyview.do로 전달 -->
				<button onclick = "location.href='${conPath }/list.do?pageNum=${param.pageNum }'">목록</button>
			</td>
		</tr>				
	</table>
</body>
</html>