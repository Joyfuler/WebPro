<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기관리 - 게임아이다</title>
<link href = "${conPath }/main/css/style2.css" rel = "stylesheet">
<link rel="icon" type="image/x-icon" href="${conPath }/img/logo4.gif" sizes="144x144">
	<script>
		function deleteConfirm(){
			if (confirm('정말 삭제하시겠습니까?')){
				location.href="delete.do?gameName="	
			}
		}
	</script>
</head>
<body>
	즐겨찾기를 삭제하거나 추가할 수 있습니다.
	<form action = "" method = "post">
	<input type = "text" name = "gameName"> <input type = "submit" value = "검색">
	</form>
	<br>
	 <p class="favorite_title">내 즐겨찾기</p>
    <table>
                <tr>
          			<td class="td01"><img src="${conPath }/img/thum10.jpg" height ="45px" alt="" onerror="noImage(this)"/> <a href="#favorite1">즐겨찾기1</a><img src = "img/delete.png" width= "20px" onclick ="deleteConfirm()"></td>
        		</tr>
                <tr>
          			<td class="td01"><img src="${conPath }/img/thum11.jpg" height = "45px" alt="" onerror="noImage(this)"/> <a href="#favorite2">즐겨찾기2</a></td>
        		</tr>
                <tr>
          			<td class="td01"><img src="${conPath }/img/thum12.jpg" height = "45px" alt="" onerror="noImage(this)"/> <a href="#favorite3">즐겨찾기3즐겨찾기3</a></td>
        		</tr>
                <tr>
          			<td class="td01"><img src="${conPath }/img/thum13.jpg" height = "45px" alt="" onerror="noImage(this)"/> <a href="#favorite4">즐겨찾기4즐겨찾기4즐겨찾기4</a></td>
		        </tr>
                <tr>
          			<td class="td01"><img src="${conPath }/img/thum14.jpg" height = "45px" alt="" onerror="noImage(this)"/> <a href="#favorite5">즐겨찾기5즐겨찾기5즐겨찾기5즐겨찾기5</a></td>
        		</tr>               
    </table>        
</body>
</html>