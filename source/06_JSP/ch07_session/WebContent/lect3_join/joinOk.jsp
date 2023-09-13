<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String agree = request.getParameter("agree");
if ("yes".equals(agree)){ // 약관에 동의한 경우 세션 속성값(id,pw,name)받아 파일을 저장. 세션(pw,name)만 삭제하고
	// 다음 로그인창에서 가입했던 아이디를 보여주기 위해 id를 남김.
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String name = (String)session.getAttribute("name");
	// 파일저장 (소스폴더 -> webContent/WEB-INF/id.txt)
	String fileLoc = "D:\\webPro\\source\\06_JSP\\ch07_session\\WebContent\\WEB-INF\\"+id+".txt";
	PrintWriter writer = new PrintWriter(fileLoc);
	writer.println("오늘은 DB insert 대신 파일 출력을 하겠습니다.");
	writer.println("id = " + id);
	String pwStr = "";			
			for (int i=0; i<pw.length(); i++){
				pwStr += "*";		
	}
	writer.println("pw = " + pwStr);
	writer.println("name = " + name);
	writer.close();
	session.removeAttribute("pw");
	session.removeAttribute("name");
	// id 속성은 지우지 않고, 다음 로그인시 표시할 예정
	response.sendRedirect(conPath + "/lect3_join/result.jsp?msg=success");	
} else { // 약관에 동의하지 않은 경우, 이 주소부터 실행한경우 : 세션에 이미 데이터가 들어와 있으므로, 세션 데이터를 지워야함.
	// 이후 result.jsp?msg=fail 회원가입 실패	
	response.sendRedirect(conPath + "/lect3_join/result.jsp?msg=fail");	
	
}

%>
</body>
</html>