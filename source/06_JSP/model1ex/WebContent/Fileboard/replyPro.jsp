<%@page import="com.lec.dto.FileBoardDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.lec.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String conPath = request.getContextPath();%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href = "<%=conPath%>/css/style.css" rel = "stylesheet" type = "text/css">
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//String 
	FileBoardDao dao = FileBoardDao.getInstance();
	String path = request.getRealPath("fileboardUpload");//첨부할 파일이 저장될 서버(WAS)의 폴더
	int maxSize = 1024*1024*10; // 업로드 최대 용량 10M
	String filename = "";
	String originalFilename = "";
	MultipartRequest mRequest = null;
	try{
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
							new DefaultFileRenamePolicy());	
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파일 첨부한 파라미터 이름들
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement(); // param="file"
			filename = mRequest.getFilesystemName(param); // 파라미터로 서버에 저장된 파일이름
			originalFilename = mRequest.getOriginalFileName(param); // 파라미터에 첨부한 오리지널 파일이름		
		}
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
	
	InputStream is = null;
	OutputStream os = null;
	try {
		File serverFile = new File(path + "/" + filename);
	
		if (serverFile.exists()) {
			is = new FileInputStream(serverFile); // 서버에 업로드된 파일
			os = new FileOutputStream(
			"D:\\webPro\\source\\06_JSP\\" + "model1ex\\WebContent\\fileboardUpload\\" + filename);
			byte[] bs = new byte[(int) serverFile.length()];
			while (true) {
		int readByteCnt = is.read(bs);
		if (readByteCnt == -1)
			break;
		os.write(bs, 0, readByteCnt);
			}
			System.out.println("서버에 업로드 한 파일을 소스 폴더로 복사 완료");
		} else {
			System.out.println("첨부 파일이 없어서 복사 안 함");
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		if (os != null)
			os.close();
		if (is != null)
			is.close();
	}
	//fname ftitle fcontent filename fpw 패러미터 받기
	String cid = mRequest.getParameter("cid");
	String fname = mRequest.getParameter("fname");
	String ftitle = mRequest.getParameter("ftitle");
	String fcontent = mRequest.getParameter("fcontent");	
	String fpw = mRequest.getParameter("fpw");
	String fgroup = mRequest.getParameter("fgroup");
	String findent = mRequest.getParameter("findent");
	String fstep = mRequest.getParameter("fstep");
	String fip = request.getRemoteAddr();
	
	FileBoardDto dto = new FileBoardDto(0,cid,ftitle,fcontent,filename,0,fpw,Integer.parseInt(fgroup),Integer.parseInt(fstep),Integer.parseInt(findent),fip,null);	
	int result = dao.replycsBoard(dto);
	if (result == FileBoardDao.SUCCESS){
		%> 
		<script>
		alert("글작성성공");
		location.href = '<%=conPath%>/Fileboard/csList.jsp'
		</script>
		<%} else { %>
		<script>
		alert('글작성실패');
		location.href = '<%=conPath%>/Fileboard/csList.jsp'
		</script>		
	<%}%>
</body>
</html>