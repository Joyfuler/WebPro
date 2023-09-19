<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> 테스트 페이지 </h1>
 <%
 	CustomerDao cDao = new CustomerDao(); // 싱글톤이 없는 dao객체 생성
  	String id = "bbb";
  	int result = cDao.confirmID(id);
  	if (result == CustomerDao.CUSTOMER_EXISTENT){ // 이미 회원이 존재하는 경우
  		out.print("<h3>1. confirmID 결과 : " + id + "는 중복된 아이디로 회원가입 불가");
  	} else {
  		out.print("<h3>1. confirmID 결과 : " + id + "는 회원가입 가능한 아이디입니다");
  		// 각종 변수들을 넣는 것은 dto 역할, sql 메소드를 실행하는 것은 dao 역할!
  		CustomerDto dto = new CustomerDto(id, "222", "싱싱싱", "010-8353-7777", "re@a.com", "경상때구", null,
  				"f", null); //회원가입할 객체 생성
  		result = cDao.joinCustomer(dto); // 가입해보고 정상이면 1, 안되면 0
  		if (result == CustomerDao.SUCCESS){ // 성공시
  			out.print("<h3>2. join 결과 : " + id + "로 회원가입 성공");
  		} else {
  			out.print("<h3>2. join 결과 : " + id + "로 회원가입 실패");
  		}
  	}
  	
  	out.print("<h3> 3. loginCheck 결과 </h3>");
  	id = "aa123"; 
  	String pw = "11234";
  	result = cDao.loginCheck(id, pw);
  	if (result == CustomerDao.LOGIN_SUCCESS){
  		out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공 <br>");
  	} else if (result == CustomerDao.LOGIN_FAIL){
  		out.print("아이디 혹은 비밀번호가 틀려 로그인할 수 없습니다.");  
  	}
  	id = "HAN"; 
  	pw = "cac";
  	result = cDao.loginCheck(id, pw);
  	if (result == CustomerDao.LOGIN_SUCCESS){
  		out.print("id는 " + id + ", pw는 " + pw + " : 로그인 성공 <br>");
  	} else if (result == CustomerDao.LOGIN_FAIL){
  		out.print("아이디 혹은 비밀번호가 틀려 로그인할 수 없습니다.");  	
  		out.print("<h3> 4. id로 dto 가져오기 (나중에 세션에 넣기 위함)</h3>");
  	}
  	id = "aaa";
  	CustomerDto dto = cDao.getCustomerDto(id); // dao는 메소드, dto는 데이터들!
  	out.print("id = " + id +"인 사람의 dto 정보 " + dto + "<br>");
  	dto = cDao.getCustomerDto("ggg");
  	out.print("id = ggg인 사람의 dto 정보 : " + dto + "<br>");
  	out.print("<h3> 5. 정보수정 </h3>");
  	out.print("id = aaa 인 멤버 수정 전 : " + cDao.getCustomerDto("aaa") + "<br>");
  	dto = new CustomerDto("aaa","444","가가가", "010-3535-2525","ee@bb.com", "부산부산", null, "f", null);
  	/* CustomerDto(String cid, String cpw, String cname, String ctel, String cemail, String caddress, Date cbirth,
	String cgender, Timestamp crdate)		 */  	
   	result = cDao.modifyCustomer(dto);
  	if (result == CustomerDao.SUCCESS){
  		out.print("수정성공. db 수정 후 데이터는 :" + cDao.getCustomerDto("aaa") + "<br>"); 		
  	} else {
  		out.print(dto.getCid() + " 수정 실패");
  	}
 %> 
</body>
</html>