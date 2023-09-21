<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "xx.jsp">에러 페이지로 이동</a>
	<%BoardDao bDao = BoardDao.getInstance(); 
	out.println("<h3>1. 글목록 </h3>");
	ArrayList<BoardDto> dtos = bDao.boardList(11, 13);
	for (BoardDto dto: dtos){
		out.println(dto + "<br>");
	}
	out.println ("<h3> 2. 글갯수  :" + bDao.getBoardTotalCnt() + "</h3>");
	out.println ("<h3> 3. 게시판 원글작성 (이름,제목,내용,비밀번호 객체)");
	BoardDto dto = new BoardDto(0, "홍길동동", "제목: 5교시", "내용: 냉무", null, 0, "2222", 0, 0, 0, request.getRemoteAddr(), null);
	int result = bDao.writeBoard(dto);
	out.print(result == BoardDao.SUCCESS ? " : 성공</h3>" : " : 실패 </h3>");
	out.print("<h3> 6. 조회수 안올리고, 글번호로 dto만 가져오기(글수정위함)");
	out.println("<h3> 1번글 :" + bDao.getBoardNothitup(1) + "<br>");	
	out.print("<h3> 4와 5. 조회수 올리고, 글번호로 dto 가져오기");
	bDao.hitUp(2);
	out.print("<h3> 2번글 상세보기 조회수업 - 게시글보기): "+ bDao.getBoardNothitup(2) + "상세보기는 hitup 수행");
	out.print("<h3> 7. 글수정 --> 2번글을 수정하기 : ");	
	dto = bDao.getBoardNothitup(2); // 2번글 정보를 넣음
	dto.setBname("신성기사");
	dto.setBtitle("신기한제목");
	dto.setBcontent("신기한내용");
	dto.setBpw("tlsrl");
	result =bDao.modifyBoard(dto);
	out.print(result == BoardDao.SUCCESS? "수정성공</h3>": "수정실패</h3>");
	out.print("<h4>8. 글삭제하기 - ");
	result = bDao.deleteBoard(12, "2222");
	out.print(result == BoardDao.SUCCESS? "삭제완료" : "삭제실패. 게시글이 없거나 비밀번호가 틀림");
	%>	
</body>
</html>