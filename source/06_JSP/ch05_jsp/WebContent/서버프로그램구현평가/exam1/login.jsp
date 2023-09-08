<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href = "login.css" rel = "stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
const loginPro = function(){
	location.href = "loginPro.jsp?id="+document.querySelector('input[name="id"]'.value)+"&pw="+document.querySelector('input[name="pw"]'.value);
};
</script>
</head>
<body>
  <form action = "loginPro.jsp" method = "get">
	
	<fieldset>
	로그인 화면
	<hr>	
	<table>
	<tr>
	<td></td><th>아 이 디</th><td> <input type = "text" name = "id"></td>
	</tr>
	<tr>
	<td></td><th>패스워드</th><td> <input type = "password" name = "pw"></td>
	</tr>
	<tr><td></td><td colspan="2">
	<input type = "submit" value = "로그인"></td></tr>		
	</table>	
	<%String msg = request.getParameter("msg");
		if (msg != null){
		out.println(msg);
		}
		%>
	</fieldset>
  </form>
</body>
</html>