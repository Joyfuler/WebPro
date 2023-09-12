<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href='join.css' rel='stylesheet'>
<title>Insert title here</title>
</head>
<body>
	<%
	String conPath = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pwOut = "";
	for (int idx = 0; idx < pw.length(); idx++) {
		pwOut += "*";
	}
	String birth = request.getParameter("birth");
	Date birthDate = null; // 날짜만 필요한 경우
	birthDate = Date.valueOf(birth);
	Timestamp birthTS = null; // 날짜와 시간이 모두 필요한 경우
	birthTS = Timestamp.valueOf(birth + " 00:00:00");
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	if (gender.equalsIgnoreCase("f")) {
		gender = "여자";
	} else {
		gender = "남자";
	}
	String email = request.getParameter("email");
	String getMail = request.getParameter("getmail");
	%>	
	<fieldset>
		<h2>회원가입정보</h2>
		<hr>
	<table>				
		<tr>
			<td>이름 : <%=name%></td>
		</tr>		
		<tr>
			<td>아이디 : <%=id%></td>
		</tr>
		<tr>
			<td>비번 : <%=pwOut%></td>
		</tr>		
		<tr>
			<td>생년월일 : <%=(birth.contentEquals("") ? "-" :birth)%>	</td>
		</tr>
		<tr>
			<td>생년월일(Date) : <%=(birthDate == null ? "-" : birthDate) %></td>
		</tr>
		<tr>
			<td>생년월일(TimeStamp) : <%=(birthTS == null ? "-" : birthTS)%></td>					
		</tr>		
		<tr>
			<td>취미 : <%
			int cnt = 1; 
			if (hobby.length ==0) { 
				out.println("취미없음"); 
			} else if (hobby.length < 2) {
				out.println(hobby[0]); 
			} else { 
				for (int idx = 0; idx <hobby.length; idx++) { 
				out.println(cnt + ". " + hobby[idx] + " ");
				cnt++;
				}
			}
			
			%></td>
		</tr>		
		<tr>
			<td>성별 : <%=gender%></td>
		</tr>
		<tr>
			<td>이메일 : <%=email%></td>
		</tr>		
		<tr>
			<td>수신할 이메일 : <%=getMail%>	</td>
		</tr>		
		<tr>
			<td>가입일 : <%
			Date date = new Date(System.currentTimeMillis());
			%> <%=date%></td></tr>
		<tr>
			<td>가입IP : 	<%= request.getRemoteAddr()%>
	</table>	
	<button class = "joinBtn_style" onclick = "location.href ='<%=conPath%>/member/login.jsp'">로그인</button>
	</fieldset>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>