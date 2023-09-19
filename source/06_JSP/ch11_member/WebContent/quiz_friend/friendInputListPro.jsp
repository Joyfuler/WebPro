<%@page import="com.lec.friend.FriendDto"%>
<%@page import="com.lec.friend.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String name = request.getParameter("name");
String tel = request.getParameter("tel");
FriendDao dao = FriendDao.getInstance();
FriendDto dto = new FriendDto();
dto.setName(name);
dto.setTel(tel);
int result = dao.insertFriend(dto);
if (result == FriendDao.SUCCESS){%>
	<script>
	alert("친구 추가 성공. 리스트로 돌아갑니다.");
	location.href='friendInputList.jsp';
	</script>
<%} else {%>
	<script>
	alert("에러로 인해 친구 추가가 실패했습니다. 리스트로 돌아갑니다.");
	location.href='friendInputList.jsp';	
	</script>
<%}%>
</body>
</html>