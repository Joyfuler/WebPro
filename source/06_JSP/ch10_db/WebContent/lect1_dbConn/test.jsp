<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<%String deptnoStr = request.getParameter("deptno");
 if (deptnoStr == null){
	 deptnoStr = "0";
}
	int deptnoInput = Integer.parseInt(deptnoStr);
	String param = request.getParameter("param");
	if (param == null){
		param = "";
}

%>

<form action ="">
<table><tr><th>부서번호</th><td><select name = "deptno">
<option value = "0"></option>
<option value = "10" <%if(deptnoInput ==10){ 
				out.print("selected='selected'");
				}%>>뉴욕</option>
<option value = "20" <%if(deptnoInput ==20){ 
				out.print("selected='selected'");
				}%>>댈러스</option>
<option value = "30" <%if(deptnoInput ==30){ 
				out.print("selected='selected'");
				}%>>런던</option>
<option value = "40" <%if(deptnoInput ==40){ 
				out.print("selected='selected'");
				}%>>서울</option>
</select>
<input type = "text" name = "param" class = "btn" value ="<%=param.trim().toUpperCase()%>">
<input type = "submit" value = "검색" class="btn">
</table> 
</form>
</body>
</html>