<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script> -->
<link href="${conPath }/main/css/style2.css" rel = "stylesheet">
<link rel="icon" type="image/x-icon" href="${conPath }/img/logo4.gif" sizes="144x144">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>             
<script> 
        window.onload = function() {
        document.getElementById('searchForm').addEventListener('submit', function (event) {
            event.preventDefault();
            var searchInput = document.getElementById('searchInput');
            if (searchInput.value.trim() === '') {                
                searchInput.value = '세나키우기';
            }            
            this.submit();
        });
      }
</script>
</head>
<body>
	 <div class = "controller">
          <ul>
          	<li><a class = "control" href = "${conPath }/main/admin.jsp">관리자모드</a></li>
			<li><a class = "control" href = "${conPath }/main/modifyChk.jsp">회원정보수정</a></li>          
            <li><a class = "control" href = "${conPath }/main/loginForm.jsp">로그인</a></li>            
            <li><a class = "control" href = "${conPath }/main/findAccount.jsp">아이디/비밀번호찾기</a></li>            
            <li><a class = "control" href = "${conPath }/main/joinForm.jsp">회원가입</a></li>
          </ul>
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-dark navbar-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="${conPath }/index.jsp"><img src = "${conPath }/main/img/logo6.png" height = "35"> &nbsp;Game-Idaa</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav me-auto">
                  <li class="nav-item item1">
                    <a class="nav-link" aria-current="page" href="${conPath }/index.jsp">메인페이지</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#notice">공지사항</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="${conPath }/main/intro.jsp">Game-Idaa소개</a>
                  </li>      
                     <li class="nav-item">
                      <a class="nav-link" href="#qna">문의게시판</a>
                    </li>    
                    <li class="nav-item">
                      <a class="nav-link" href="${conPath }/main/favorite_modify.jsp" onclick = "window.open(this.href,'즐겨찾기수정','resizable=no width=450 height=550');return false">즐겨찾기</a>
                    </li>                                                         
                </ul>
                <button class="navbar-toggler" type="button" id="closeMenuButton">▲닫기</button>
                <script>
  $(document).ready(function() {    
    $('#closeMenuButton').click(function() {
      $('.navbar-collapse').collapse('hide');
    });
  });
</script>
              </div>
            </div>
          </nav>    
          <div class="search">          
            <form action ="${conPath }/main/search.jsp" method = "get" id="searchForm">                
                <input style="padding-left: 10px;" id = "searchInput" class = "searchBox" type="text" name="query" placeholder="요즘핫한 신작, 세나키우기 평가하러 Go!"/>
                <button type = "submit" style = "border:0; background: transparent">
                <img src="${conPath }/main/img/searchbutton.png" width="30" height="30" alt ="submit" class = "searchButton">
                </button><br><br>
             </form>               
          </div>           
          <div class="text-center">          	
            <div class="row row1 bg-dark text-white" style = "margin:0 5px 0 5px;">
              <div class="col-2"><a href = "#sevenknights"><img src = "${conPath }/main/img/thum1.jpg" height="25" class = "thum">세나키우기</a></div>
              <div class="col-2"><a href = "#fconline"><img src = "${conPath }/main/img/thum2.jpg" height="25" class = "thum">FC ONLINE</a></div>
              <div class="col-2"><a href = "#wos"><img src = "${conPath }/main/img/thum3.jpg" height="25" class = "thum">WOS</a></div>
              <div class="col-2"><a href = "#fcm"><img src = "${conPath }/main/img/thum4.jpg" height="25" class = "thum">FC모바일</a></div>             
              <div class="col-2"><a href = "#nightcrow"><img src = "${conPath }/main/img/thum5.jpg" height="25" class = "thum">나이트크로우</a></div>
              <div class="col-2"><a href = "#odin"><img src = "${conPath }/main/img/thum6.jpg" height="25" class = "thum">오딘:발할라라이징</a></div>
            </div>
            <div class="row row2 bg-dark text-white" style = "margin:0 5px 0 5px;">                            
              <div class="col-2"><a href = "#lineagem"><img src = "${conPath }/main/img/thum7.jpg" height="25" class = "thum">리니지M</a></div>
              <div class="col-2"><a href = "#pixelh"><img src = "${conPath }/main/img/thum8.jpg" height="25" class = "thum">픽셀히어로</a></div>
              <div class="col-2"><a href = "#genshin"><img src = "${conPath }/main/img/thum9.jpg" height="25" class = "thum">원신</a></div>
              <div class="col-2"><a href = "#cookie"><img src = "${conPath }/main/img/thum10.jpg" height="25" class = "thum">쿠키런:킹덤</a></div>
              <div class="col-2"><a href = "#cod"><img src = "${conPath }/main/img/thum11.jpg" height="25" class = "thum">콜오브드래곤즈</a></div>
              <div class="col-2"><a href = "#tang"><img src = "${conPath }/main/img/thum12.jpg" height="25" class = "thum">탕탕특공대</a></div>              
            </div>
            <div class="row row3 bg-dark text-white" style = "margin:0 5px 0 5px;">
              <div class="col-2"><a href = "#royal"><img src = "${conPath }/main/img/thum13.jpg" height="25" class = "thum">로얄 매치</a></div>
              <div class="col-2"><a href = "#dm"><img src = "${conPath }/main/img/thum14.jpg" height="25" class = "thum">던파 모바일</a></div>
              <div class="col-2"><a href = "#archiagewar"><img src = "${conPath }/main/img/thum15.jpg" height="25" class = "thum">아키에이지 워</a></div>
              <div class="col-2"><a href = "#bg"><img src = "${conPath }/main/img/thum16.jpg" height="25" class = "thum">배틀그라운드</a></div>
              <div class="col-2"><a href = "#kartrider"><img src = "${conPath }/main/img/thum17.jpg" height="25" class = "thum">카트라이더</a></div>
              <div class="col-2"><a href = "#maplem"><img src = "${conPath }/main/img/thum18.jpg" height="25" class = "thum">메이플스토리M</a></div>              
            </div>
          </div>    
          <hr>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>