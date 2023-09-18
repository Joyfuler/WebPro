<%@page import="java.sql.Date"%>
<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<%! String id; String pw; String name; String phone1; String phone2;
String phone3; String gender; String email; Date birth; String address;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
<script>
 // submit 이벤트 제한 추가: pw와 pwChk 동일여부
</script>
</head>
<body>
<% MemberDto member = (MemberDto)session.getAttribute("member"); 
if (member == null){
response.sendRedirect("login.jsp?method=modify");// 로그인x상태에서 회원수정시 로그인으로 이동. 
// 그 후 메인으로 강제 이동하므로 method를 패러미터를 추가하여 메인으로 가지 못하도록 구분시킴. (만일 로그인했다면 method에는 세션값이, 안 했다면 null이 들어감.)


} else { // 세션에서 받아온 각 데이터를 모두 대입하여 회원정보 수정시 input창에 보이도록 할 예정
	id = member.getId();
	pw = member.getPw();
	name = member.getName();
	phone1 = member.getPhone1();
	phone2 = member.getPhone2();
	phone3 = member.getPhone3();
	gender = member.getGender();
	email = member.getEmail();
	birth = member.getBirth();
	address = member.getAddress();	
}%>
	<form action = "modifyOk.jsp" method = "post">
	<table>
	<caption>회원정보수정</caption>
	<tr>
	<th>아이디</th><td><input type = "text" name = "id" value = "<%=id%>" readonly="readonly"></td>
	</tr>
	<tr>
	<th>현재 비밀번호 </th>
	<td><input type = "password" name = "oldPw" required="required"></td></tr>
	<tr>
	<th>새비밀번호</th><td><input type = "password" name = "pw" placeholder = "비밀번호 수정을 원치 않으면 입력하지 마세요"></td>
	</tr>
	<tr>
	<th>새비밀번호확인</th><td><input type = "password" name = "pwChk"></td>
	</tr>
	<tr>
	<th>이름</th><td><input type = "text" name = "name" value ="<%=name%>"></td>
	</tr>
	<tr>
	<th>전화번호</th><td><select name = "phone1">
	<option></option>
	<option
	<%if ("010".equals(phone1)){
		out.print("selected='selected'");
		}%>>010</option>
	<option
	<%if ("02".equals(phone1)){
		out.print("selected='selected'");
		}%>>02</option>
	<option
	<%if ("031".equals(phone1)){
		out.print("selected='selected'");
		}%>>031</option>	
	<option
	<%if ("032".equals(phone1)){
		out.print("selected='selected'");
		}%>>032</option>	
	</select> -
	<input type = "text" name = "phone2" size = "2" value = "<%=phone2 != null? phone2: ""%>"> -	
	<input type = "text" name = "phone3" size = "2" value = "<%=phone3 != null? phone3: ""%>">	
	</td>
	</tr>
	<tr>
	<th>성별</th><td>
	<%if ("m".equals(gender)){ //남자체크%>
	<input type = "radio" name = "gender" value = "m" id="m" checked = "checked"><label for = "m">남자</label>
	<input type = "radio" name = "gender" value = "f" id = "f"><label for = "f">여자</label>
	<%} else if ("f".equals(gender)){ //여자체크%>
	<input type = "radio" name = "gender" value = "m" id="m"><label for = "m">남자</label>
	<input type = "radio" name = "gender" value = "f" id = "f" checked = "checked"><label for = "f">여자</label>	
	<%} else { // 성별이 null인 경우 %>
	<input type = "radio" name = "gender" value = "m" id="m"><label for = "m">남자</label>
	<input type = "radio" name = "gender" value = "f" id = "f"><label for = "f">여자</label>
	<%}%>	
	</td>
	</tr>
	<tr>
	<th>이메일</th><td><input type = "text" name = "email" value = "<%=email != null ? email : "" %>"></td>
	</tr>
	<tr>
	<th>생년월일</th><td><input type = "date" name = "tempBirth" value ="<%=birth== null? "": birth%>"></td>
	</tr>
	<%-- parameter이름을 birth로 할 경우, bin태그 사용시 날짜 입력하면 500에러가 발생하니 주의 --%>	
	<tr>
	<th>주소</th><td><input type = "text" name = "address" value = "<%=address == null? "" : address%>">
	</td>
	</tr>
	<tr>
	<td colspan = "2"><input type = "submit" value = "정보수정">
	<input type = "reset" value = "취소">
	<input type = "button" value = "로그아웃" onclick = "location.href = 'logout.jsp'"></td>
	</tr>
	</table>
	</form>


</body>
</html>