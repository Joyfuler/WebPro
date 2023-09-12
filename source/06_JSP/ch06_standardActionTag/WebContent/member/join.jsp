<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String conPath = request.getContextPath(); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>	

	<link href = "<%=conPath%>/css/join.css" rel = "stylesheet">
	<script>
	window.onload = function(){
		document.querySelector('form').onsubmit = function(){
			var nameStr = document.querySelector('input[name="name"]').value;
			var idStr = document.querySelector('input[name="id"]').value;
			var pwStr = document.querySelector('input[name="pw"]').value;
			var pwChkStr = document.querySelector('input[name="pwChk"]').value;
			var emailStr = document.querySelector('input[name="email"]').value;
			var birth = document.querySelector('input[name="birth"]').value; 
			var hobbys = document.querySelectorAll('input[name="hobby"]');
			var namePattern = /^[a-zA-Z가-힣]+$/;
			var idPattern = /^[a-zA-Z0-9]{4,12}$/;
			var pwPattern = /^[A-Z]+[0-9]+[a-zA-Z0-9]{4,12}$/;
			var mailPattern = /^[a-z0-9]+@[a-z]+\.[a-z]{2,3}$/;
			var hobbyCount = 0;			
			for (var i=0; i<hobbys.length; i++){
				if (hobbys[i].checked){
					hobbyCount += 1; 
				}
			}
			
			if (!nameStr.match(namePattern)){
				alert('이름은 영문 대/소문자, 혹은 한글로만 입력할 수 있습니다');
				return false;
			} else if (!idStr.match(idPattern)){
				alert('아이디는 영문/숫자로 4~12자로만 입력 가능합니다.')
				return false;
			} else if (!pwStr.match(pwPattern)){
				alert('비밀번호는 영문 대문자, 숫자를 포함하여 영문/숫자로 8~12자만 입력 가능합니다.');
				return false;
			} else if (pwStr != pwChkStr){
				alert('첫번째 비밀번호와 두번째 비밀번호가 서로 다릅니다.');
				return false;
			} else if (birth == ''){
				alert('생년월일은 필수 입력사항입니다.');
				return false;			
			} else if (hobbyCount ==0){
				alert('취미는 적어도 1개 이상을 선택해주세요.');
				return false;
			} else if (!emailStr.match(mailPattern)){
				alert('올바른 형식의 이메일을 입력해주세요');
				return false;
			}
			
		};
	};
	
	</script>
</head>
<body>
	<div id ="joinForm_wrap">
		<div id = "join_title">회원가입</div>
		<form action ="joinPro.jsp" method ="post">		
		<table>
		<tr><td>이름</td><td><input type = "text" name = "name" class = "name"></td></tr> 
		<tr><td>아이디</td><td><input type = "text" name = "id" class = "id"></td></tr>
		<tr><td>비밀번호</td><td><input type = "password" name = "pw" class = "pw"></td></tr>
		<tr><td>비밀번호확인</td><td><input type = "password" name = "pwChk" class = "pwChk"></td></tr>
		<tr><td>생년월일</td><td><input type = "date" name = "birth" class = "birth"></td></tr>
		<tr><td>취미</td>
		<td><input type = "checkbox" name="hobby" value = "독서">독서
		<input type = "checkbox" name="hobby" value = "요리">요리
		<input type = "checkbox" name="hobby" value = "운동">운동
		<input type = "checkbox" name="hobby" value = "취침">취침
		<input type = "checkbox" name="hobby" value = "기타">기타
		</td></tr>
		<tr><td>성별</td><td><input type = "radio" name="gender" value = "m" checked="checked">남자
		<input type = "radio" name="gender" value = "f">여자</td></tr>
		<tr><td>이메일</td><td><input type = "text" name="email"></td></tr>			
		<tr><td>메일수신</td><td><select name = "getmail" class = "getmail">
		<option value = "광고">광고</option>
		<option value = "배송">배송</option>
		<option value = "공지">공지</option>		
		</select></td></tr>
		<tr><td colspan="2"><input type = "submit" value = "가입하기" class = "joinBtn_style">
		<input type = "reset" value = "다시하기" class = "joinBtn_style">
		<input type = "button" value = "로그인" onClick = "location.href ='<%=conPath%>/member/login.jsp'" class = "joinBtn_style"></td></tr>		
		</table>
		</form>		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>