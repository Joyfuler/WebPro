<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
		$(document).ready(function(){
		$('input[name="mid"]').keyup(function(){
			var mid = $(this).val();
			var pattern = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			if (mid.match(pattern)){
				$('div#midConfirmResult').html('');
				$('div#midConfirmResult').html('<b>한글이 포함되지 않은 아이디로 입력');
			} else if (mid.length <3){
				$('div#midConfirmResult').html('');
				$('div#midConfirmResult').html('<b>아이디는 3글자 이상으로 입력');
			} else {
				$.ajax({
					type : 'post',
					url : '${conPath}/midConfirm.do',
					data : {mid: mid} ,
					dataType : 'html',
					success : function(data){
						$('div#midConfirmResult').html('');
						$('div#midConfirmResult').html(data.trim());
					},
		  		});
			}
		});
		
		$('.mpw, .mpwChk').keyup(function(){
			var mpw = $('.mpw').val();
			var mpwChk = $('.mpwChk').val();
				if (mpw != '' && mpwChk != ''){
					if (mpw != mpwChk){
					$('#mpwChkResult').html('<b>두 비밀번호가 서로 다릅니다</b>');
				} else if (mpw == mpwChk){
					$('#mpwChkResult').html('<b>두 비밀번호가 서로 일치합니다.</b>');				
				}		
			} else {
				$('#mpwChkResult').html('');
			}	
		});	
		
		$('input[name="memail"]').keyup(function(){
			var memail = $(this).val();			
			var pattern = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$";
			if (!memail.match(pattern)){
				$('div#memailConfirmResult').html('');
				$('div#memailConfirmResult').html('<b>메일 주소 형식이 맞지 않습니다.</b>');				
			} else {
				$.ajax({				
				url: '${conPath}/memailConfirm.do',
				type : 'post',
				data : {memail : memail},
				dataType : 'html',
				success : function(data){
					$('div#memailConfirmResult').html('');
					$('div#memailConfirmResult').html(data.trim());	
				},
			});
		}		
	});
});		
	</script>
	<script>	
	function submitChk(){
		var midConfirmResult = $('div#midConfirmResult').text().trim(); 
		var mpwConfirmResult = $('div#mpwChkResult').text().trim();
		var memailConfirmResult = $('div#memailConfirmResult').text().trim();
		if (idConfirmResult != '사용 가능한 ID입니다'){
			alert('아이디 형식을 체크하세요');
			return false;
		} else if (pwConfirmResult != '두 비밀번호가 서로 일치합니다.'){
			alert('비밀번호 형식을 체크하세요');
			return false;
		} else if (memailConfirmResult != '사용 가능한 이메일입니다'){
			alert('중복된 이메일 주소입니다.');
			return false;
		}
	}
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
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content_form">
		<form action="${conPath }/join.do" method="post" enctype="multipart/form-data">
			<table>
				<caption>회원가입</caption>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="mid" required="required" autofocus="autofocus" autocomplete="off">
						<div id="midConfirmResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="mpw" required="required" class = "mpw"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="mpwChk" required="required" class = "mpwChk">
						<div id="mpwChkResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="mname" required="required"></td>
				</tr>
				<tr>
					<th>메일</th>
					<td>
						<input type="text" name="memail" autocomplete="off">
						<div id="memailConfirmResult"> &nbsp; </div>
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="mphoto"></td>
				</tr>
				<tr>
					<th>생년월일</th><td><input type="text" name="mbirth" id="datepicker" autocomplete="off"></td>
				</tr>
				<tr>
					<th>주소</th><td><input type="text" name="maddress"></td>
				</tr>
				<tr>
					<td colspan="2">
						<p>
							<input type="submit" value="회원가입" class="btn" onclick = "return submitChk()">
							<input type="button" value="로그인" class="btn" onclick="location='${conPath}/loginView.do'">
						</p>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>