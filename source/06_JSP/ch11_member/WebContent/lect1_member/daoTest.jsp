<%@page import="com.lec.member.MemberDao"%>
<%@page import="com.lec.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String conPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
 <h1> 테스트 페이지 </h1>
 <%
 	MemberDao mDao = MemberDao.getInstance(); // 객체생성. 싱글톤
  	String id = "bbb";
  	int result = mDao.confirmID(id);
  	if (result == MemberDao.MEMBER_EXISTENT){ // 이미 회원이 존재하는 경우
  		out.print("<h3>1. confirmID 결과 : " + id + "는 중복된 아이디로 회원가입 불가");
  	} else {
  		out.print("<h3>1. confirmID 결과 : " + id + "는 회원가입 가능한 아이디입니다");
  		// 각종 변수들을 넣는 것은 dto 역할, sql 메소드를 실행하는 것은 dao 역할!
  		MemberDto dto = new MemberDto(id, "cbc", "송송송", null, null, null, "f",
  				"tt@rr.dd", null, null, null); //회원가입할 객체 생성
  		result = mDao.joinMember(dto); // 가입해보고 정상이면 1, 안되면 0
  		if (result == MemberDao.SUCCESS){ // 성공시
  			out.print("<h3>2. join 결과 : " + id + "로 회원가입 성공");
  		} else {
  			out.print("<h3>2. join 결과 : " + id + "로 회원가입 실패");
  		}
  	}
  	
  	out.print("<h3> 3. loginCheck 결과 </h3>");
  	id = "bbb"; 
  	String pw = "cbc";
  	result = mDao.loginCheck(id, pw);
  	if (result == MemberDao.LOGIN_SUCCESS){
  		out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공 <br>");
  	} else if (result == MemberDao.LOGIN_FAIL_PW){
  		out.print("비밀번호가 틀려 로그인할 수 없습니다.");
  	} else if (result == MemberDao.LOGIN_FAIL_ID){
  		out.print("해당하는 아이디가 존재하지 않습니다.");
  	}
  	
  	id = "HAN"; 
  	pw = "cac";
  	result = mDao.loginCheck(id, pw);
  	if (result == MemberDao.LOGIN_SUCCESS){
  		out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공 <br>");
  	} else if (result == MemberDao.LOGIN_FAIL_PW){
  		out.print("비밀번호가 틀려 로그인할 수 없습니다." + "id는 " + id + ", pw는 " + pw);
  	} else if (result == MemberDao.LOGIN_FAIL_ID){
  		out.print("해당하는 아이디가 존재하지 않습니다." + "id는 " + id + ", pw는 " + pw);
  	}
  	out.print("<h3> 4. id로 dto 가져오기 (나중에 세션에 넣기 위함)</h3>");
  	MemberDto dto = mDao.getMember(id); // dao는 메소드, dto는 데이터들!
  	out.print("id = " + id +"인 사람의 dto 정보 " + dto + "<br>");
  	dto = mDao.getMember("ggg");
  	out.print("id = ggg인 사람의 dto 정보 : " + dto + "<br>");
  	out.print("<h3> 5. 정보수정 </h3>");
  	out.print("id = AAA인 멤버 수정 전 : " + mDao.getMember("AAA") + "<br>");
  	dto = new MemberDto("AAA", "333", "을이순", "02", "9999", "8888", "f",
  			"xxxx@shin.com", null, null, null);
  	result = mDao.modifyMember(dto);
  	if (result == MemberDao.SUCCESS){
  		out.print("수정성공. db 수정 후 데이터는 :" + mDao.getMember("AAA") + "<br>"); 		
  	} else {
  		out.print(dto.getId() + "수정 실패");
  	}
 %> 
</body>
</html>