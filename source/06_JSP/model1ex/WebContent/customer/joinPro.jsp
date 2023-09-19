<%@page import="com.lec.dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="CustomerDto" class = "com.lec.dto.CustomerDto"/>
<jsp:setProperty property="*" name="CustomerDto"/>
	<% String tempCbirth = request.getParameter("tempCbirth");
	if (!tempCbirth.equals("")){
	CustomerDto.setCbirth(Date.valueOf(tempCbirth));
	} 
	CustomerDao cDao = new CustomerDao();
	int result = cDao.confirmID(CustomerDto.getCid());
	if (result == CustomerDao.CUSTOMER_NONEXISTENT){
		result = cDao.joinCustomer(CustomerDto);
		if (result == CustomerDao.SUCCESS){
			session.setAttribute("cid", CustomerDto.getCid());
			%>
			<script>
			alert("<%=CustomerDto.getCname()%>님 회원가입 감사합니다. 로그인 후 이용해주세요");
			location.href = "loginForm.jsp";
			</script>
		<%} else {%>
			<script>
			alert("회원가입이 실패하였습니다. 아이디/비밀번호 길이를 확인해주세요");
			history.go(-1);
			</script>
		<%	}%>
		<%}else{ %>
			<script>
			alert("중복된 아이디입니다. 다른 아이디를 사용해주세요");
			history.go(-1);
			</script>	
		<%}%>
</body>
</html>