<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath}/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
	<!-- 만일 로그인하지 않은 사람이 회원정보수정 페이지에 들어왔다면, 로그인 페이지에서 먼저 로그인 처리 후 이곳으로 이동하도록 설정 -->
	<c:if test="${empty member}">
	<!--  sessionScope.member = 즉 로그인이 안 된 상태. -->
		<script>
		location.href= '${conPath}/loginView.do?next=modifyView.do';
		</script>
	</c:if>
	<form action = "${conPath }/modify.do" method = "post" enctype = "multipart/form-data">
		<!-- 입력한 이전 비밀번호가 실제 db에 있는 비밀번호와 동일한지 확인 필요 -->
		<input type = "hidden" name = "dbmpw" value = "${member.mpw }">
		<!-- 정보수정 시 기존 프로필사진이 있고, 새로 프로필사진 수정 x시 해당 패러미터를 전달 필요 -->
		<input type = "hidden" name = "dbmphoto" value = "${member.mphoto }">
		<table>
			<caption>정보수정페이지 </caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type = "text" name = "mid" value = "${member.mid }" size = "3" readonly = "readonly">
					</td>
					<td rowspan="4">
						<img src = "${conPath }/memberPhotoUp/${member.mphoto }" alt="${member.mname } 사진">
					</td>
				</tr>
				<tr>
					<th>현재비밀번호</th>
					<td>
						<input type = "password" name = "oldmpw" required = "required" size = "3">
					</td>		
				</tr>
				<tr>
					<th>새비밀번호</th>
					<td>
						<input type = "password" name = "mpw" size = "3">			
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type = "text" name = "mname" value = "${member.mname }" required = "required" size = "3">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type = "email" name = "memail" value = "${member.memail }">
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td colspan = "2">
						<input type = "file" name = "mphoto">
						<!-- 첨부x시 사진은 기존사진 그대로 사용. -->
					</td>
				</tr>		
				<tr>
					<th>생년월일</th>
					<td>
						<input type = "date" name = "mbirth" value = "${member.mbirth }">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan="2">
						<input type = "text" name = "maddress" value = "${member.maddress }">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					<p>
						<input type = "submit" value = "정보수정">
						<input type = "button" value = "초기화" onclick = "location.href='${conPath }/main.do'">
						<input type = "button" value = "회원탈퇴" onclick = "location.href='${conPath }/withdrawal.do'">
					</p>
					</td>
				</tr>									
		</table>
	</form>
</body>
</html>