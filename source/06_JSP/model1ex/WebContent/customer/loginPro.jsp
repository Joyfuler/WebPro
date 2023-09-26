<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String conPath = request.getContextPath(); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String cid = request.getParameter("cid");
String cpw = request.getParameter("cpw");
String method = request.getParameter("method");
CustomerDao cDao = new CustomerDao();
int result = cDao.loginCheck(cid, cpw);
if (result == CustomerDao.LOGIN_SUCCESS){
	CustomerDto customer = cDao.getCustomerDto(cid);
	session.setAttribute("customer", customer);
	if (method.equals("null")){
		response.sendRedirect("../main/main.jsp");
	} else if (method.equals("writeForm")){
		response.sendRedirect("../Fileboard/writeForm.jsp");
	} else {
		response.sendRedirect("../"+ method + ".jsp");
		// 로그아웃 상태에서 회원수정을 하면 login.jsp로 가며 method = 'modify' 패러미터를 추가하여 보낸다.
		// 이후 login.jsp에서 받아온 modify가 input 창에 들어가며 loginPro.jsp까지 넘어온다.
	}
} else {%>
	<script>
	alert("아이디 혹은 비밀번호를 확인해주세요");	
	</script>	
<%
response.sendRedirect("loginForm.jsp?msg=false");
}%>
</body>
</html>