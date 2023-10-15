<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>관리자모드</title>
	<link href = "${conPath }/main/css/style2.css" rel = "stylesheet">
	<link href = "${conPath }/main/css/admin.css" rel = "stylesheet">
	<link rel="icon" type="image/x-icon" href="${conPath }/img/logo4.gif" sizes="144x144">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script>
	$(document).ready(function(){
		$("#tabs").tabs();		
		$('input.gameSearch').click(function(){
			$.ajax({				
			});
			
		});
	});	
	</script>
	<script>
	function displayImg(input){
		if (input.files && input.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				$('#preview').attr('src', e.target.result);
				$('#preview').css('display', 'inline');
			};	
			
			reader.readAsDataURL(input.files[0]);
		}
	}
	</script>
</head>
<body>
<div class = "controller">
          <ul>
            <li><a class = "control" href = "${conPath }/main/main3.jsp">메인페이지</a></li>
          	<li><a class = "control" href = "${conPath }/main/admin.jsp">관리자모드</a></li>
			<li><a class = "control" href = "${conPath }/main/modifyChk.jsp">회원정보수정</a></li>          
            <li><a class = "control" href = "${conPath }/main/loginForm.jsp">로그인</a></li>            
            <li><a class = "control" href = "${conPath }/main/findAccount.jsp">아이디/비밀번호찾기</a></li>            
            <li><a class = "control" href = "${conPath }/main/joinForm.jsp">회원가입</a></li>
          </ul>
        </div>
<div id="tabs">
	  <ul>
	    <li><a href="#tabs-1">신규 게임 추가</a></li>
	    <li><a href="#tabs-2">회원 리스트 출력</a></li>
	    <li><a href="#tabs-3">게임정보 변경</a></li>
	    <li><a href="#tabs-4">관리자 추가/제거</a>
	  </ul>
	  <div id="tabs-1">
	     <form action = "${conPath }/addGame.do">
	    	<table>	   
	    		<tr>
	    			<th>게시판아이디</th>
	    			<td><input type = "text" id = "gid"></td> 	
	    		<tr>
	    			<th>게임명</th>
	    			<td><input type = "text" id = "gname"></td>
	    		</tr>
	    		<tr>
	    			<th>개발사</th> 
	    			<td><input type = "text" id = "gpub"></td>
	    		</tr>
	    		<tr>	
	    			<th>출시일</th>
	    			<td><input type = "text" id = "grel"></td>
	    		</tr>
	    		<tr>	
	    			<th>게임아이콘</th>
	    			<td><input type = "file" id ="gicon" onchange = "displayImg(this)" style = "margin-top:20px;"><img id = "preview" height = "100"></td>
	    			
	    		</tr>
	    		<tr>	    			
	    			<th>게임설명 </th>
	    			<td>
	    			<textarea cols="20" rows="3" id = "gdes"></textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td><input type = "submit" value = "게임추가">	
	    	</table>
	    </form>	    
	  </div>
	  <div id="tabs-2">
	    <p>
			회원리스트 (총 ${cnt }명)
		</p>	
			<table>
			<tr>
				<th> ID </th><th> 이름 </th><th>이메일</th><th>휴대폰번호</th>
			</tr>
			</table>			
	  </div>
	  <div id="tabs-3">
	   	<form action = "${conPath }/modifyGame.do">
	   	<input type = "hidden" id = "gid">
	    	<table>	   
	    		<tr>
	    			<th>게시판아이디</th>
	    			<td><input type = "text" id = "gidSearch"></td><td><input type = "button" value = "검색" class = "gameSearch"></td> 	
	    		<tr>
	    			<th>게임명</th>
	    			<td><input type = "text" id = "gname"></td>
	    		</tr>
	    		<tr>
	    			<th>개발사</th> 
	    			<td><input type = "text" id = "gpub"></td>
	    		</tr>
	    		<tr>	
	    			<th>출시일</th>
	    			<td><input type = "text" id = "grel"></td>
	    		</tr>
	    		<tr>	
	    			<th>게임아이콘</th>
	    			<td><input type = "file" id ="gicon" onchange = "displayImg(this)" style = "margin-top:20px;"><img id = "preview" height = "100"></td>
	    			
	    		</tr>
	    		<tr>	    			
	    			<th>게임설명 </th>
	    			<td>
	    			<textarea cols="20" rows="3" id = "gdes"></textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td><input type = "submit" value = "정보변경">	
	    	</table>
	    </form>	    
	  </div>
	   <div id="tabs-4">	   		
	    	<table>	   
	    		<tr>
	    			<th>아이디 검색</th>
	    			<td><input type = "text" id = "gid"></td><td><input type = "button" value = "검색" class = "gameSearch"></td>	    			
	    		</tr>	    		
	    		<tr>
	    			<td>
	    			<input type = "button" value = "관리자추가" id = "addAdmin" style = "width:150px;">
	    			&nbsp;	    					    			
	    			<input type = "button" value = "관리자삭제" id = "removeAdmin" style = "width:150px;">
	    			</td>
	    		</tr>			    			
	    	</table>	    
	  </div>
	</div>
</body>
</html>