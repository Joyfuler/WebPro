<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/join.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<!--  $('#id')의 keyup이벤트에 $.ajax()구현 -->
	<script>
		function submitChk(){
			var idConfirmResult = $('div#idConfirmResult').text().trim(); 
			var pwConfirmResult = $('div#pwChkResult').text().trim();
			if (idConfirmResult != '사용 가능한 ID입니다'){
				alert('아이디 형식을 체크하세요');
				return false;
			} else if (pwConfirmResult != '두 비밀번호가 서로 일치합니다.'){
				alert('비밀번호 형식을 체크하세요');
				return false;
			}
		}
	</script>
	<script>
		$(document).ready(function(){
		$('input#id').keyup(function(){
			var mid = $(this).val();			
			var pattern = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			if (mid.match(pattern)){
				$('div#idConfirmResult').html('');
				$('div#idConfirmResult').html('<b>한글이 포함되어 있습니다. 영문만 입력해주세요.</b>');
			} else if (mid.length<4){
				$('div#idConfirmResult').html('<b>아이디는 4글자 이상만 입력해주세요.</b>');	
			} else {
				$.ajax({				
				url: '${conPath}/midConfirm.do',
				type : 'post',
				data : {mid : mid},
				dataType : 'html',
				success : function(data){
					$('div#idConfirmResult').html('');
					$('div#idConfirmResult').html(data.trim());	
				},
			});
		}	
	});	
	<!--  $('#pw, #pwChk)의 keyup이벤트에 두 비밀번호 같은지를 체크 -->		
		$('#pw, #pwChk').keyup(function(){
			var pw = $('#pw').val();
			var pwChk = $('#pwChk').val();
			if (pw != '' && pwChk != ''){
				if (pw != pwChk){
					$('#pwChkResult').html('<b>두 비밀번호가 서로 다릅니다</b>');
				} else if (pw == pwChk){
					$('#pwChkResult').html('<b>두 비밀번호가 서로 일치합니다.</b>');				
				}		
			} else {
				$('#pwChkResult').html('');
			}	
		});
		
		
		
	 });	
	</script>
	 <script>
  $( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat: "yy-mm-dd",
    	monthNames: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
    	showMonthAfterYear: true,
    	yearSuffix: '년',
    	changeMonth: true,
    	changeYear: true,
    	monthNamesShort:["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
    	yearRange: "c-100:c+3", //년도 선택 select box를 현재 년도에서 이전 100년 / 이후 10년으로 설정
    });	    
  });
  </script>		
	<!--  $('form'의 submit 이벤트에 유효성검사 결과를 (#idCOnfirmResult), (#pwConfirmResult)에 출력 -->
	<!--  생일 입력란 datepicker 부분 -->
</head>
<body>
	<div id="joinForm_wrap">
		<form>
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td>
						<input type="text" name="mid" id="id" class="id" required="required">
						<div id="idConfirmResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="pw">비밀번호</label></th>
					<td><input type="password" name="pw" id="pw" class="pw"></td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호확인</label></th>
					<td>
						<input type="password" name="pwChk" id="pwChk" class="pwChk">
						<div id="pwChkResult"> &nbsp; &nbsp; &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th><label for="name">이름</label></th>
					<td><input type="text" name="name" id="name" class="name"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="birth" id="datepicker" autocomplete="off"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class="joinBtn_style" onclick = "return submitChk()">
						<input type="reset" value="다시하기" class="joinBtn_style">
						<input type="button" value="로그인" class="joinBtn_style">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>