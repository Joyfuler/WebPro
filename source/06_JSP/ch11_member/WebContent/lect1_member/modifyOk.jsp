<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%-- modifyOk.jsp 에서 전달받은 패러미터는 id, pw, name, phone1~3, gender, email, address 
(MemberDto 변수와 동일한 이름), 단 oldPw는 존재하지 않았음. (현재비밀번호), tempBirth(Memberdto에 없는 변수이름)
--%>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="dto" class="com.lec.member.MemberDto"></jsp:useBean>
	<%-- 객체를 한번에 가져다 쓰기 위해 usebean사용하였음 --%>
	<jsp:setProperty property="*" name="dto" />
	<%-- 9개 객체를 모두 받아서 사용 가능해짐. 이후 dto.getName()등을 통해 사용. String이나 int등 기초 데이터 타입은 자동 형변환을 통해 사용 가능함. --%>
	<%
		String tempBirth = request.getParameter("tempBirth");
	if (!tempBirth.equals("")) { // 아무것도 입력 x시 빈칸
		dto.setBirth(Date.valueOf(tempBirth)); // tempbirth의 값을 date로 바꾸어 dto 객체 속 birth에 넣는다
	}
	MemberDto member = (MemberDto) session.getAttribute("member"); // 세션에 있는 member객체의 pw를 가져와 비교함.
	String sessionPw = null;
	String oldPw = request.getParameter("oldPw");
	if (member != null) { // 멤버가 빈값이 아니면(세션이 있으면) 비밀번호를 대입해 넣어줌.
		sessionPw = member.getPw();
	}
	if (sessionPw.equals(oldPw)) {
		if (dto.getPw() == null) { // 새 비밀번호 입력 x시
			dto.setPw(oldPw); // 이전에 사용하던 암호를 그대로 다시 set함.
		}
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.modifyMember(dto); // 세팅한 dto객체를 dao의 modifyMember 메소드에 매개변수로 산입.
		if (result == MemberDao.SUCCESS) {
			session.setAttribute("member", dto);
	%>
	<script>
		alert('정보 수정이 완료되었습니다.');
		location.href = "main.jsp";
	</script>
	<%
		} else {
	%>
	<script>
		alert('정보 수정실패하였습니다. 아이디/비밀번호 길이를 확인해주세요');
		location.href = "modify.jsp";
	</script>
	<%
	}
	%>
	<%
	} else { // 현재 비밀번호를 맞게 입력하지 못하였음.
	%>
	<script>
		alert('현재 비밀번호가 올바르지 않습니다. 다시 확인해주세요');
		history.go(-1);
	</script>
	<%
	}
	%>
</body>
</html>