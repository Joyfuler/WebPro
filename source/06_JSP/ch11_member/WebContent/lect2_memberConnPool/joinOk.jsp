<%@page import="com.lec.member.MemberDaoCP"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%-- 회원가입 페이지에서 각종 데이터를 받기 전, 이름 등 한글이 있을 것을 대비하여 인코딩을 세팅해둠. --%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto" scope="page" />
	<%-- MemberDto dto = new MemberDto()와 동일. 이후 아래에서 기존과 동일하게 dto 안의 패러미터를 사용 가능 --%>
	<jsp:setProperty property="*" name="dto" />
	<%-- join에서 입력했던 패러미터를 모두 property에 넣음. 단, birth는 타입오류 떄문에 tempbirth로 지정 --%>
	<%
		String tempBirth = request.getParameter("tempBirth"); // "" 이거나 "1999-12-12" 
		if (!tempBirth.equals("")) { // 빈값이 아니라, 날짜가 제대로 들어왔다면
			dto.setBirth(Date.valueOf(tempBirth));
			//dto의 birth가 TimeStamp형이면 dt.setBirth(Timestamp.valueof(tempBirth + " 00:00:00"));
		}
		// jsp 액션태그로 회원가입 정보를 모두 가져왔다면, dao를 통해 db에 넣는 작업을 시작.
		MemberDaoCP mDao = new MemberDaoCP();
		int result = mDao.confirmID(dto.getId()); // id 중복체크
		if (result == MemberDaoCP.MEMBER_NONEXISTENT) {
			//사용가능한 아이디 / 회원가입 진행 -> session에 id데이터 추가 -> login 페이지로
			result = mDao.joinMember(dto); // 중복체크후 문제없으면 dto의 객체를이용해 db에 넣는다
			if (result == MemberDaoCP.SUCCESS) {
		session.setAttribute("id", dto.getId()); // 회원가입이 완료되었으면 id를 세션에 넣는다.
	%>
	<script>
			alert("<%=dto.getName()%>님 회원가입 감사합니다");			
			location.href = 'login.jsp';
	</script>
	<%
		} else {
	%>
	// 회원가입이 실패되었을 때
	<script>
		alert("회원가입이 실패되었습니다. 길이 제한이 있습니다");
		//history.go(-1);
		location.href = 'join.jsp';
	</script>
	<%
		}
	%>
	<%
		} else {
	%>
	<script>
		alert("중복된 아이디입니다. 다른 아이디를 사용하세요");
		history.back();
	</script>
	<%
		}
	%>
</body>
</html>