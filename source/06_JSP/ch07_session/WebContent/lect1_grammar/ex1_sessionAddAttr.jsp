<%@page import="com.lec.ex.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<%
	Member member = new Member("aaa","111","홍길동");
%>
<%-- session은 사용자의 정보가 추가(가입)되었을때 일시적으로 보관하는 곳.
세션에 데이터를 저장하기 위해서는 세션에 속성을 추가해야 함. (패러1 - 이름 패러2 - 값) --%>
<%session.setAttribute("sessionName", "aaa"); 
  session.setAttribute("sessionNum", 111); // 기본타입으로도 생성가능
  session.setAttribute("member", member); // 멤버 객체의 정보를 세션에 저장하였음.
  // jsp에서는 session이 내부 객체라 바로 사용 가능.자바(서블릿)에서는 session을 바로 사용 x
  HttpSession session2 = request.getSession(); // 서블릿에서 사용하는 방법으로 httpSession객체를 만들어 사용.
  

%>
	<h2>session의 sessionName 속성값 : <%=session.getAttribute("sessionName") %></h2>
	<h2>session의 sessionNum 속성값 : <%=session.getAttribute("sessionNum") %></h2>
	<h2>session의 sessionMember 속성값 : <%=session.getAttribute("member") %></h2>
	<hr>
	<h2> 세션 ID : <%=session.getId() %></h2>
	<h2> 세션 유효시간: <%=session.getMaxInactiveInterval() %></h2>
	<!-- 해당 시간이 지나면 자동으로 세션이 사라짐. 즉 로그아웃 -->
	<hr>
	<a href ="ex1_sessionAddAttr.jsp">세션 데이터 추가</a><br>
	<a href = "ex2_sessionGet.jsp">특정 세션 가져오기 </a><br>
	<a href = "ex3_sessionList.jsp">세션의 모든 데이터를 가져오는 방법</a><br>
	<a href = "ex4_sessionRemove.jsp">세션 제거하기</a><br>
	
</body>
</html>