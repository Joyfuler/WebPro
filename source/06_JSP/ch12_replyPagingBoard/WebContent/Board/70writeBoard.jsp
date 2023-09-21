<%@page import="com.lec.ex.dto.BoardDto"%>
<%@page import="com.lec.ex.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String conPath = request.getContextPath();%>
<title>Insert title here</title>
</head>
<body>
<%
	BoardDao bDao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for (int idx=0; idx<70; idx++){
		dto.setBname(idx+"번째아이");
		dto.setBtitle(idx+"번째게시글");
		dto.setBcontent(idx+"번째아이가배고프다울지요");
		if (idx %2 ==0){
			dto.setBemail("hong"+idx+"@hong.com");
		} else {
			dto.setBemail("kim"+idx+"@kim.com");
		}
		dto.setBpw("111");
		dto.setBip("192.168.0." + idx);
		int result = bDao.writeBoard(dto);
		System.out.println(result==BoardDao.SUCCESS? idx+"번째 성공": idx+"번째 실패");	
	}
	response.sendRedirect(conPath + "/Board/list.jsp");
%>
</body>
</html>