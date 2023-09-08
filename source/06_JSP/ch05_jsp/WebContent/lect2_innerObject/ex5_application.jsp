<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Reader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		String conPath = request.getContextPath(); // /ch05_jsp
	String appPath = application.getContextPath(); // /ch05_jsp
	String absolutePath = application.getRealPath("."); // 현재 실행되는 경로	
	String filePath = application.getRealPath("files/test.txt");
	out.println(filePath + "의 내용입니다<br>");

	/* Reader reader = null;
	BufferedReader br = null;
	try{
		reader = new FileReader(filePath); // 기본스트림 reader 생성
		br = new BufferedReader(reader); //보조스트림은 기본스트림을 통해 생성
		while (true){
		String linedata = br.readLine(); // 한 줄마다로 읽음. ('\n')마다	
		if (linedata == null) break;		
		out.println(linedata + "<br>");	//한줄씩 줄바꿈하면서 출력	
		}
		out.println("파일입력 끝");	
	}catch (Exception e){	
		System.out.println(e.getMessage());
	}finally {
		try{
			if (br!=null) br.close();
			if (reader!= null) reader.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	 */
	// 일반적으로 자바에서는 위와 같이 try - catch - finally를 이용하여 예외를 잡지만,
	// jsp 환경에서는 브라우저에 대신 에러를 출력하여 굳이 필요하지 않으므로 걷어냄.	
	
	Reader reader = new FileReader(filePath); // 기본스트림 reader 생성
	BufferedReader br = new BufferedReader(reader); //보조스트림은 기본스트림을 통해 생성
	while (true) {
		String linedata = br.readLine(); // 한 줄마다로 읽음. ('\n')마다	
		if (linedata == null)
			break;
		out.println(linedata + "<br>"); //한줄씩 줄바꿈하면서 출력	
	}
	out.println("파일입력 끝");
	if (br != null)
		br.close();
	if (reader != null)
		reader.close();
	%>


	<h2>
		conPath =
		<%=conPath%></h2>
	<h2>
		appPath =
		<%=appPath%></h2>
	<h2>
		절대경로 =
		<%=absolutePath%></h2>

	<h2>
		텍스트경로 =
		<%=filePath%></h2>



</body>
</html>