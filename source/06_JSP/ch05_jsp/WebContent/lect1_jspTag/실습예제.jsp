<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String num = request.getParameter("num");
	int trimedNum = 0;
	int total = 0;
	if (num != null) {
		trimedNum = Integer.parseInt(num.trim());
		for (int i = 0; i <= trimedNum; i++) {
			total += i;
		}
	}
	%>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="" method="get">
			숫자 <input type="number" name="num" min="1"
				value="<%=num != null ? num : ""%>"> <input type="submit"
				value="누적">
		</form>
	</fieldset>
	<%
		if (num != null) {
		out.println("<h2>요청하신 " + trimedNum + "까지의 숫자의 총합은 " + total + "입니다</h2>");
	%>
	<h2>
		요청하신 <%=trimedNum%> 까지의 숫자 총합은 <%=total%>입니다. (body)
	</h2>
	<%
	} // if 괄호 안에 넣은 h2 태그 및 문구는 if 조건을 만족하지 않는 경우 출력되지 않음.
	%>

</body>
</html>