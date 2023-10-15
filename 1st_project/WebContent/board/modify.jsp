<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글수정</title>
    <link rel="icon" type="image/x-icon" href="${conPath}/img/logo4.gif" sizes="144x144">    
    <link href="${conPath}/main/css/boardWrite.css" rel="stylesheet">
    <script>    
	function noImage(imageElement) {
	 	imageElement.src = "${conPath }/img/noimg.jpg";
	}
    </script>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<jsp:include page="../main/rightArea.jsp"/>
<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3 style = "text-align:left;"><img src = "../img/thum10.jpg" height = "44px"><b>드래곤플라이 - 게시글수정</b></h3>         
        </div>
  </div>
  <div id="contents">
		<div class="article">						
			<div class="gray_frame">				
				<form action = "" method="get">					
					<div class = "writeForm">
						<table class="board-table">							
							<tbody>
								<tr>
									<td rowspan="2" style = "text-align: center;"> <img src = "${conPath }/img/logo5.png" height = "45px">																																									
									<b>&nbsp;&nbsp;글제목 &nbsp;</b>
									</td>
									<td rowspan="2">
									<input id="btitle" name="btitle" class = "writeInput" maxlength="100" tabindex="2"
										type="text">										
									</td>
								</tr>
								<tr>
								</tr>
								<tr>
									<th>글내용 </th>
									<td><textarea cols="30" rows="15" maxlength="4000"></textarea>										
									</td>
								</tr>								
								<tr>
									<th>파일첨부</th>
									<td>
									<input type = "file" name = "bfile">
									</td>
								</tr>
								<tr>
									<td colspan= "3">
									<input type = "button" name = "writeButton" value = "글작성" style = "margin-left: 400px;"> 
									<input type = "button" value = "초기화" style = "margin-left: 10px;"> 
									<input type = "button" value = "글목록" onclick = "location.href='${conPath}/board/list.jsp'" style = "margin-left: 10px;"> 
									</td>
							</tbody>
						</table>
					</div>	
				</form>
			</div>
		</div>
	</div>								
</section>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>