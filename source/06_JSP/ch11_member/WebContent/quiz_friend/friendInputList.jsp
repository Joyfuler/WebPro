<%@page import="com.lec.friend.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "../css/style.css" rel = "stylesheet">
<script>
function searching(){
	var name = document.querySelector("input[name='name']").value;
	var tel = document.querySelector("input[name='tel']").value;
	if (name == null || name == ''){
		alert("이름은 반드시 입력하셔야 합니다.");
	} else {
	location.href = "friendInputList.jsp?name="+name+"&tel="+tel;
	}
}

function resetDefault(){
	location.href = "friendInputList.jsp";
}
</script>
</head>
<body>
	<form action = "friendInputListPro.jsp">
	<p>
	이름 <input type = "text" name = "name" required = "required">
	전화 <input type = "text" name = "tel">
	<input type = "button" value = "검색" onclick = "searching()">
	<input type = "submit" value = "친구추가">
	<input type = "button" value = "검색초기화 " onclick = "resetDefault()">
	</p>
	</form>
	<table>
	<caption>DB에 입력된 친구들 리스트</caption>
	<tr><td>순번</td><td>이름</td><td>전화</td></tr>
	<%
	FriendDao dao = FriendDao.getInstance();
	String nameSearch = request.getParameter("name");
	String telSearch = request.getParameter("tel");
	ArrayList<FriendDto> friends = dao.friendList(nameSearch,telSearch);
	if (friends.size()==0){
		out.println("<tr><td colspan = '3'>친구가 없습니다.</td></tr>");
	} else {
		for (int idx=0; idx < friends.size(); idx++){
			out.print("<tr><td>"+friends.get(idx).getNo()+"</td>");
			out.print("<td>"+friends.get(idx).getName()+"</td>");
			String telStr = friends.get(idx).getTel();
			out.print("<td>"+(telStr!= null? telStr: "없음")+"</td>");
		}
	}
	%>
	</table>
</body>
</html>