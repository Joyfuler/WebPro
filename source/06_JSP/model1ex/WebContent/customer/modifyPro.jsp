<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath(); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet">
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="CustomerDto" class="com.lec.dto.CustomerDto" />
	<jsp:setProperty property="*" name="CustomerDto" />
	<%
		String tempCbirth = request.getParameter("tempCbirth");
	if (tempCbirth != "") {
		CustomerDto.setCbirth(Date.valueOf(tempCbirth));
	}
	CustomerDto customer = (CustomerDto) session.getAttribute("customer"); // 세션에 있는 각종 정보 가져옴.
	String sessionCpw = null;
	String oldCpw = request.getParameter("oldCpw");
	if (customer != null) {
		sessionCpw = customer.getCpw();
	}
	if (sessionCpw.equals(oldCpw)) {
		if (CustomerDto.getCpw() == null) {
			CustomerDto.setCpw(oldCpw); // 패러미터 이름을 다르게 받았던 birth와 password의 올바른 세팅이 완료되었다면 이제 수정.			
		}
		CustomerDao cDao = new CustomerDao();
		int result = cDao.modifyCustomer(CustomerDto);
		if (result == CustomerDao.SUCCESS) { // 회원정보를 무사히 변경한 경우
			session.setAttribute("customer", CustomerDto);
	%>
	<script>
		alert('정보수정 완료');
		location.href = "../main/main.jsp";
	</script>
	<%
		} else {
	%>
	<script>
		alert("비밀번호나 아이디의 길이가 너무 깁니다.");
		history.go(-1);
	</script>
	<%
		}
	%>
	<%
		} else {
	%>
	<script>
		alert('현재 비밀번호가 다릅니다. 다시 확인해주세요');
		history.go(-1);
	</script>
	<%
		}
	%>
</body>
</html>