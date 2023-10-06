package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BContentService;
import com.lec.service.BListService;
import com.lec.service.BReplyService;
import com.lec.service.BReplyViewService;
import com.lec.service.BWriteService;
import com.lec.service.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int writeMode = 0;    
    public BController() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // "/ch18_mvcBoard/list.do
		String conPath = request.getContextPath(); // "/ch18_mvcBoard
		String command = uri.substring(conPath.length()); // "/list.do
		String viewPage = null;
		Service service = null;		
			if (command.equals("/list.do")) { // 글목록 list.do?pageNum=2
				service = new BListService();
				service.execute(request, response);
				viewPage = "board/list.jsp"; // 실제로 사용자에게 보여줄 페이지
			} else if (command.equals("/writeView.do")) { // 글쓰기 페이지 이동했을 때
				writeMode = 1;
				viewPage = "board/write.jsp";
			} else if (command.equals("/write.do")){ // 사용자가 글을 쓴 후에 글쓰기를 눌렀을 때
				if (writeMode == 1) {
				service = new BWriteService();
				service.execute(request, response);
				 // list.jsp로 갈 경우 보여주는 기능을 수행하지 않으므로 빈칸이 출력됨
				writeMode = 0;
				}
				viewPage = "list.do";
			} else if (command.equals("/content.do")) { // 글작성 완료 후?
				service = new BContentService();
				service.execute(request, response);
				viewPage = "board/content.jsp";
			} else if (command.equals("/updateView.do")) { // 글수정 눌렀을 때				
				service = new BModifyViewService(); // 글수정할 때에는 원래 쓰여진 글의 정보를 받아와야 함. db와의 상호작용을 위해 service 필요
				service.execute(request, response);
				viewPage = "board/modify.jsp"; // 
			} else if (command.equals("/update.do")) { // 글수정 입력 후 완료 눌렀을 때
				service = new BModifyService();
				service.execute(request, response);
				viewPage = "content.do?after=u"; // requestScope.modifyResult, param.pageNum, param.bid, param.bname
				// forward로 가므로 주소가 바뀌지 않음. 따라서 parameter도 보존되어 넘어가는 것.
			} else if (command.equals("/delete.do")) { // 글 삭제할 때
				service = new BDeleteService(); // 글 삭제시에는 jsp페이지에서 원글의 bid를 받아옴.
				service.execute(request, response); // request에 deleteMsg가 담겨 list.do로 넘어간다. 주소가 바뀌지 않았으므로 pageNum 패러미터도 전달됨.
				viewPage = "list.do"; 
			} else if (command.equals("/replyView.do")) { // 답변글 눌러서 입력하는 페이지 갈 때. 원글의 정보를 가져와야 하므로 역시 service 필요
				service = new BReplyViewService();
				service.execute(request, response); //request에 replyBoard 정보를 담아서 보냄.
				viewPage = "board/reply.jsp";
			} else if (command.equals("/reply.do")) {
				service = new BReplyService();
				service.execute(request, response); // request에 replyResult 추가
				viewPage = "list.do"; //pageNum과 bid 패러미터가 남아 전달됨. 				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);			
		}
	}
