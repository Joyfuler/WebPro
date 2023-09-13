<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/main.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<jsp:include page="../member/header.jsp"></jsp:include>
<%
Enumeration<String> sAttrNames = session.getAttributeNames();
int cnt = 0;
while (sAttrNames.hasMoreElements()){ //세션의 다음 속성값이 있는 동안 반복.
	cnt++;
	String sname = sAttrNames.nextElement(); //처음부터 끝까지 속성값의 이름 출력
	String svalue = session.getAttribute(sname).toString();  //위 속성값의 이름의 값을 출력
	out.println("<h2>" + cnt + "." + sname + "(세션속성이름):" + svalue + "(세션값)</h2>");
}
if (cnt ==0){
	out.println("<h2>세션 내 데이터가 없습니다.");
}

%>

<jsp:include page="../member/footer.jsp"></jsp:include>
</body>
</html>