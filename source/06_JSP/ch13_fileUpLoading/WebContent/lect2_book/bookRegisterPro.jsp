<%@page import="com.lec.ex.BookDao"%>
<%@page import="com.lec.ex.BookDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String conPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<%=conPath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		// 첨부한 파일 저장하고 파일 이름 받아오기.
	String path = request.getRealPath("bookImg");
	out.println("서버에 저장될 폴더: " + path + "<br>");
	int maxSize = 1024 * 1024 * 3;
	String[] images = { "", "" }; //첨부를 안하면 null, 하면 파일이름이 들어감.
	MultipartRequest mRequest = null;
	try {
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		//첨부한 파일이 저장됨. 패러미터 이름을 Enumeration으로 가져옴
		Enumeration<String> parameters = mRequest.getFileNames(); // 파일 이름이 있는 '패러미터 이름'을 가져오는 것
		int idx = 0;
		while (parameters.hasMoreElements()) {
			String param = parameters.nextElement();
			images[idx] = mRequest.getFilesystemName(param);
			System.out.println(idx + "번째 처리한 패러미터 :" + param + "/파일명 : " + images[idx]);
			idx++;
		}

	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
	// 복사
	for (String fileNames : images) {
		InputStream is = null;
		OutputStream os = null;
		try {
			File serverFile = new File(path + "/" + fileNames);
			//if(filename!=null){
			if (serverFile.exists()) {
		is = new FileInputStream(serverFile); // 서버에 업로드된 파일
		os = new FileOutputStream("D:/webPro/source/06_JSP/ch13_fileUpLoading/WebContent/bookImg/" + fileNames); // 소스폴더로 복사될 파일
		byte[] bs = new byte[(int) serverFile.length()];
		while (true) {
			int readByteCnt = is.read(bs);
			if (readByteCnt == -1)
				break;
			os.write(bs, 0, readByteCnt);
		}
		System.out.println(fileNames + " 복사 완료");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (os != null)
		os.close();
			if (is != null)
		is.close();
		}
	}
	// btitle, bprice, bcontent, bdiscount 패러미터 받기
	String btitle = mRequest.getParameter("btitle");
	int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
	String bimg1 = images[1] == null ? "noImg.png" : images[1];// 배열에 들어갈 때는 반대로 들어가므로 순서를 반대로 해줘야
	String bimg2 = images[0] == null ? "NOTHING.JPG" : images[0];
	// 파일명만 가져온 것이므로 경로필요x
	String bcontent = mRequest.getParameter("bcontent");
	int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));
	// DB 저장
	BookDto dto = new BookDto(0, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, null); // 넣을 책 정보를 담은 객체를 생성하기
	BookDao dao = BookDao.getInstance();
	int result = dao.insertBook(dto);
	if (result == BookDao.SUCCESS) {
		out.print("<h2>책등록성공</h2>");
	} else {
		out.print("<h2>책등록실패</h2>");
	}
	%>
	<h2>
		책이름
		<%=btitle%></h2>
	<%
		int finalPrice = bprice * (100 - bdiscount) / 100;
	%>
	<%
		if (bdiscount != 0) {
	%>
	<h3>
		책가격
		<del><%=bprice%></del>
		<b><%=finalPrice%>원(<%=bdiscount%>% 할인)</b>
	</h3>
	<%
		} else {
	%>
	<h3>
		책가격 <b><%=bprice%>원</b>
	</h3>
	<%
		}
	%>
	<h3>
		대표이미지:
		<%=path%>/<%=bimg1%></h3>
	<h3>
		추가이미지:
		<%=path%>/<%=bimg2%></h3>
	<img src="<%=conPath%>/bookImg/<%=bimg1%>" alt='1번그림'>
	<img src="<%=conPath%>/bookImg/<%=bimg2%>" alt='2번그림'>
</body>
</html>