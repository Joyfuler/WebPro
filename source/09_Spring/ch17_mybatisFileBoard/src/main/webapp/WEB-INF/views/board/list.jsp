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
<script src="https://code.jquery.com/jquery-3.7.1.js"
	  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	  crossorigin="anonymous"></script>
</head>
<script>
	
	$(document).ready(function(){		
		/*	$('tr').click(function(){
			var no = $(this).children().eq(2).text().trim(); // 클릭한 tr의 자식(td)의 세번째의 (글번호) 글자를 띄어쓰기 지워서
			// 만일 숫자 데이터가 있다면, 클릭했을 때 해당 게시글의 상세보기로 가야함
			if (!isNaN(Number(no))){
				location.href= '${conPath }/board/content.do?bid='+no+'&pageNum=${param.pageNum }'
			}
		});
		*/				
	});
	const trClicked = bid => {
		location.href= '${conPath}/content.do?pageNum=${paging.currentPage}&bid='+bid;		
	}
	
</script>
<body>
	<c:set var = "SUCCESS" value="1"/>
	<c:set var = "FAIL" value = "0"/>
	<c:if test="${writeResult eq SUCCESS }">
		<script>
		alert('글쓰기성공');
		</script>
	</c:if>
	<c:if test="${writeResult eq FAIL }">
		<script>
		alert('글쓰기실패');
		history.back();
		</script>
	</c:if>
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
	<c:if test="${not empty deleteResult }">
		<script>
		alert('${deleteResult eq 1 ? "삭제성공" : "삭제실패"}');
		</script>
	</c:if>	
	<c:if test = "${replyResult eq SUCCESS }">
		<script>
		alert('${param.bid}번째 글 답변글 작성완료');
		</script>
	</c:if>
	<c:if test = "${replyResult eq FAIL }">
		<script>
		alert('${param.bid}번째 글 답변글 작성실패');
		</script>
	</c:if>	
	<table>
		<caption>게시판</caption>
			<tr>
				<td><a href = "${conPath }/write.do">글쓰기</a>
				</td>
			</tr>
	</table>
	<table>
		<tr><th>순번</th><th>역번</th>
			<th>글번호</th><th>작성자</th><th>글제목</th><th>IP</th><th>작성시간</th><th>조회수</th>
		</tr>
		<c:if test="${boardList.isEmpty() }">
		<tr>
			<td colspan = "8"> 게시글이 없습니다. </td>
		</tr>		
		</c:if>	
		<c:set var = "oNum" value = "${paging.orderNum }"/>
		<c:set var = "iNum" value = "${paging.inverseNum }"/>
		<c:forEach var="dto" items = "${boardList }">
		<tr onclick = "trClicked(${dto.bid})">
			<td>${oNum }</td>			
			<td>${iNum }</td>
			<td>${dto.bid }</td>
			<td><b>${dto.bname }</b></td>
			<td class = "left">
			<!--  bindent만큼 들여쓰기 -->
			<c:forEach var = "i" begin="1" end = "${dto.bindent }">
				<c:if test="${i eq dto.bindent}"> <!-- 만일 indent가 0인 경우는 수행하지 않음, 1이라면  1회 수행.-->
				┗
				</c:if>
				<c:if test="${i != dto.bindent }">
				&nbsp;&nbsp;&nbsp;
				</c:if>		
			</c:forEach>
				<%--<a href = "${conPath }/content.do?bid=${dto.bid }&pageNum=${pageNum }"> <!-- 제목클릭시 상세보기로 감. setattribute된 것은 getparameter하지 않아도 사용됨.--> --%>
				${dto.btitle }				
				<c:if test="${dto.bhit >= 10 }">
				<b>(*)</b>
				</c:if>
				</td>
				<td>${dto.bip }</td>
				<td>
				<fmt:formatDate value="${dto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss"/>
				</td>
				<td>${dto.bhit }</td>
			<!-- i가 bindent보다 작으면 띄어쓰기를, i와 bindent가 동일한 경우에는 └ 를 표시하도록 함. -->			
				</tr>
			<c:set var= "oNum" value = "${oNum +1 }"/>
			<c:set var= "iNum" value = "${iNum -1 }"/>					
		</c:forEach>
	</table>
	${paging.currentPage } / ${paging.endPage }
	<div class = "paging">
		<c:if test="${paging.startPage > paging.blockSize }"> <!--  현재 11페이지 시작, 10페이지까지 있다면 이전 표기 -->
		<a href ="${conPath }/boardList.do?pageNum=${paging.startPage -1 }">[이전]</a>
		</c:if>
		<c:forEach var = "i" begin = "${paging.startPage }" end = "${paging.endPage }"><!-- 현재 페이지라면 빨간색강조, 다른 페이지는 a태그로. -->
			<c:if test= "${i eq paging.currentPage }">
			[<b>${i }</b>]
			</c:if>
			<c:if test= "${i != paging.currentPage }">
			<a href = "${conPath }/boardList.do?pageNum=${i }">[${i }]</a>
			</c:if>			
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
		<a href = "${conPath }/boardList.do?pageNum=${paging.endPage +1 }">[다음]</a>
		</c:if>
	</div>
</body>
</html>