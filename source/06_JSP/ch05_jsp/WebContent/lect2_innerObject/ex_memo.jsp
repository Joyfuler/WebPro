<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String context = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href = "<%=context%>/css/ex2.css" rel = "stylesheet">
	<script>
	window.onload = () => {
		var memo = document.querySelector('input[name="memo"]');
		memo.onkeyup = () => {
			var span = document.getElementsByTagName('span')[0];
			span.innerHTML = memo.value.length + "/30";
			// input(memo)창 내부에 키를 누를 때마다, 입력한 텍스트의 길이를 출력하도록 하는 함수.
		}
	}
	</script>
</head>
<body>
	<form action = "ex2_memoPro.jsp" method = "post">
	<table>
		<tr>
		<th>작성자</th> 
		<th>한줄메모</th>
		</tr>
		<tr>
		<td><input type = "text" name = "writer" size = "3"></td>
		<td><input type = "text" name = "memo" maxlength="30" size="30">
		<span>0/30</span>
		</td>
		</tr>
		<tr>
		<td colspan="2"> <input type = "submit" value = "작성"></td>
		</tr>
	</table>
	</form>
</body>
</html>