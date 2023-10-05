package com.lec.ch18.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.AddressingFeature.Responses;

import com.lec.ch18.service.MemberJoinService;
import com.lec.ch18.service.MemberListService;
import com.lec.ch18.service.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    private boolean joinMode = false;
    public FrontController() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어온 요청 판별. 어떤 .do인지 그에 따라 service.execute()를 호출한 후 viewPage로 forward
		String uri = request.getRequestURI(); // "/ch18_mvc/memberlist.do"
		// 앞의 conpath를 빼고, 뒤의 command만 가져오도록 함.
		String conPath = request.getContextPath(); //"ch18_mvc"
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if (command.equals("/memberList.do")) {
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "member/memberList.jsp";
		} else if (command.equals("/memberJoinView.do")) {
			// 직접 컨트롤하는 페이지가 아니라 보여주는 페이지이므로 service x, 이후 회원가입 페이지에서 패러미터 받음.
			viewPage = "member/memberJoin.jsp";
			joinMode = true;
		} else if (command.equals("/memberJoin.do")) { 
			// 사용자가 회원가입 정보를 입력한 후 가야할 페이지. 패러미터를 받아서 처리해야 함.
			if(joinMode) {
				service = new MemberJoinService();
				service.execute(request, response); // joinResult와 joinMsg가 request에 담김.
				joinMode = false;
			}
			//회원가입이 완료되었으므로 리스트로 돌아가야함.
			viewPage = "memberList.do";
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
