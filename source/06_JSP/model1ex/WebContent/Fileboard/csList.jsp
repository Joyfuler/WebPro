<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=conPath%>/Fileboard/css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"
></script>
<body>
	<jsp:include page="../main/header.jsp" />
	<%
		String result = request.getParameter("result");
	if (result != null && result.equals("1")) {
	%>
	<script>
		alert("게시글 작성 완료");
	</script>
	<%
		} else if (result != null && result.equals("0")) {
	%>
	<script>
		alert("게시글 작성 실패");
	</script>
	<%
		}
	%>
	<table>
		<caption>고객센터 게시판</caption>
		<tr onclick="location.href='<%=conPath%>/Fileboard/writeForm.jsp'">
			<td id="writeForm"><a
				href="<%=conPath%>/Fileboard/writeForm.jsp"
			>글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>첨부파일</th>
			<th>조회수</th>
			<%
				// 페이지 등을 클릭한 경우에는 해당 pageNum이 출력
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1"; //전달받은 패러미터 x시 1페이지 처리
			}
			int currentPage = Integer.parseInt(pageNum); //String이므로 int화	
			final int PAGESIZE = 10, BLOCKSIZE = 5;
			int startRow = (currentPage - 1) * PAGESIZE + 1;
			int endRow = startRow + PAGESIZE - 1;
			FileBoardDao fbDao = FileBoardDao.getInstance();
			CustomerDao cDao = CustomerDao.getInstance();
			int totalCnt = fbDao.getTotalCntcsBoard();
			if (totalCnt == 0) {
				out.print("<tr><td colspan='5'>아직 게시글이 없습니다</td></tr>");
			} else {
				ArrayList<FileBoardDto> lists = fbDao.csBoardList(startRow, endRow);
				for (FileBoardDto dtos : lists) {
					CustomerDto writerInfo = cDao.getCustomerDto(dtos.getCid());
					out.print("<tr><td>" + dtos.getFid() + "</td>"); // 글번호
					out.print("<td>" + writerInfo.getCname() + "</td>"); // 작성자
					//제목 (왼쪽정렬 + hot이미지 출력 / 클릭시 상세보기)
					out.print("<td class = 'left'>");
					if (dtos.getFindent() > 0) { // 답변글인 경우는 이미지를 가지고 indent를 넣어줌. 이미지 넓이를 indent로 조절함.
				int width = dtos.getFindent() * 15;
			%>
			<img src="<%=conPath%>/img/level.gif" width="<%=width%>">
			<img src="<%=conPath%>/img/re.gif">
			<%
				}

			if (dtos.getFhit() >= 10) {
			%>
			<img src="<%=conPath%>/img/hot.gif">
			<%
				}
			%>
			<%=dtos.getFtitle()%>
			</td>
			<%
				//메일
			String file = dtos.getFilename();
			out.print("<td>" + (file == null
					? "-"
					: "<a href = '" + conPath + "/fileboardUpload/" + dtos.getFilename() + "'><img src = '" + conPath
					+ "/img/fileup.jpg' height = '25'>" + "</a></td>"));
			//조회수
			out.print("<td>" + dtos.getFhit() + "</td></tr>");
			}
			}
			%>
		
	</table>
	<div class="paging">
		<%
			int pageCnt = (int) Math.ceil((double) totalCnt / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		if (startPage > BLOCKSIZE) {
			out.print("<a href = '" + conPath + "/Fileboard/csList.jsp?pageNum=" + (startPage - 1) + "'>[ 이전 ]</a>");
		}
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				out.print("[<b>" + i + "</b>]");
			} else {
				out.print("[<a href ='" + conPath + "/Fileboard/csList.jsp?pageNum=" + i + "'>" + i + "</a>]");
			}
		}
		if (endPage < pageCnt) {
			out.print("<a href='" + conPath + "/Fileboard/csList.jsp?pageNum=" + (endPage + 1) + "'>[다음]</a>");
		}
		%>
	</div>
	<p>
		startPage =
		<%=startPage%>
		/ endPage :
		<%=endPage%>
		/ pageCnt :
		<%=pageCnt%>
		/ Blocksize :
		<%=BLOCKSIZE%>
		/ totCnt :
		<%=totalCnt%>
	</p>
	<jsp:include page="../main/footer.jsp" />

	<script>
			$(document).ready(function(){	
				$('tr').click(function(){
					var fid = $(this).children().eq(0).text().trim(); // 클릭한 tr의 자식(td)의 첫번째의 글자를 띄어쓰기 지워서 
					if (!isNaN(Number(fid))){
						location.href= 'content.jsp?pageNum=<%=pageNum%>
		&fid='
															+ fid;
												}
											});
						});
	</script>
</body>
</html>
