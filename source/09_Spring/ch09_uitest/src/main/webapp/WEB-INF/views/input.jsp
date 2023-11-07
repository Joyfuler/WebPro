<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "conPath" value = "${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "${conPath }/css/style.css" rel = "stylesheet">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script>
	function submitChk(){
		var name = $('input[name="name"]').val();
		var kor = $('input[name="kor"]').val();
		var eng = $('input[name="eng"]').val();
		var mat = $('input[name="mat"]').val();
		if (name == ''){
			alert('이름이 비었습니다. 최소 1글자 이상 입력해주세요.');			
			$('input[name="name"]').focus();			
			return false;
		} else if (kor == '' || kor <0 || kor >100){
			alert('각 성적은 0점과 100점 사이에서 입력해주세요');
			$('input[name="kor"]').val(''); 
			$('input[name="kor"]').focus();
			return false;
		} else if (eng == '' || eng <0 || eng >100){
			alert('각 성적은 0점과 100점 사이에서 입력해주세요');
			$('input[name="eng"]').val('');
			$('input[name="eng"]').focus();
			return false;		
		} else if (mat == '' || mat <0 || mat >100){
			alert('각 성적은 0점과 100점 사이에서 입력해주세요');
			$('input[name="mat"]').val('');			
			$('input[name="mat"]').focus();
			return false;
		}		
	}
</script>
</head>

<body>
<span> "현재 총 ${cnt } 명"</span>
	<form action = "${conPath }/input.do" method = "post">	
	<table>
			<caption> 개인 정보 입력 </caption>
			<tr>
				<td> 
					이름 : <input type = "text" name = "name" placeholder="홍길동">
				</td>
			</tr>
			<tr>
				<td>
					국어 : <input type = "number" name = "kor" placeholder= "100">
				</td>
			</tr>
			<tr>
				<td>
					영어: <input type = "number" name = "eng" placeholder = "100">
				</td>
			</tr>
			<tr>
				<td>
					수학: <input type = "number" name = "mat" placeholder = "99">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "submit" value = "입력" onclick = "return submitChk()">
	</table>	
	</form>
</body>
</html>