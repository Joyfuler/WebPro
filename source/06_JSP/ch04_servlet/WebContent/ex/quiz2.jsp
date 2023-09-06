<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
button {
	margin: 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		document.getElementsByTagName('form')[0].onsubmit = function(){
			var numberChk = parseInt(document.querySelector('input[name="number"]').value);
			if (isNaN(numberChk) || (numberChk % 1)!== 0 || numberChk <0){
				alert("숫자는 자연수를 입력해주세요.");
				return false;
			}		
		}
	}
</script>
</head>
<body>
	<form action="../Quiz2" method="get">
		<fieldset>
			<legend>누적하고 싶은 최종 수 입력</legend>
			<input type="text" name="number">
			<button>누적결과</button>
		</fieldset>
	</form>
</body>
</html>