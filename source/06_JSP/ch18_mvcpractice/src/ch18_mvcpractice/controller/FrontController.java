package ch18_mvcpractice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch18_mvcpractice.service.MemberJoinService;
import ch18_mvcpractice.service.MemberListService;
import ch18_mvcpractice.service.Service;

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
		actionDo(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if (command.equals("/memberList.do")) { //리스트 출력요청시
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "member/memberList.jsp";
		} else if (command.equals("/memberJoinView.do")) {
		//회원가입 페이지로 이동할 때
			viewPage = "member/memberJoin.jsp";
			joinMode = true;
		} else if (command.equals("/memberJoin.do")) {
			if (joinMode) {
			service = new MemberJoinService();
			service.execute(request, response);
			joinMode = false;
			}
		viewPage = "memberList.do";
		//회원가입이 완료되면 다시 memberList로 돌아가게끔.
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	dispatcher.forward(request, response);
	}

}
