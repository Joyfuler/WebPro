package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.MJoinService;
import com.lec.ex.service.MLoginService;
import com.lec.ex.service.MLogoutService;
import com.lec.ex.service.MModifyService;
import com.lec.ex.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = null;
		String viewPage = null;
		String uri = request.getRequestURI(); // /ch18_mvcMember/main.do
		String conPath = request.getContextPath(); // /ch18_mvcMember
		String command = uri.substring(conPath.length());
		if (command.equals("/main.do")){ // 메인페이지로 가는경우
			// service = new service(); 메인에 처리해야 할 db가 없다면 생략.
			viewPage = "member/main.jsp";
		} else if (command.equals("/loginView.do")) { // 로그인 화면으로 가는 경우.		
			viewPage = "member/login.jsp"; 
		} else if (command.equals("/login.do")) { // 로그인 화면에서 정보 입력, 실제로 로그인 작업 수행. 세션 처리하고 메인 페이지로
			service = new MLoginService();
			service.execute(request, response);
			// next 패러미터에 따라 forward가 달라질 수 있음.
			if (!request.getParameter("next").equals("")) {
				viewPage = request.getParameter("next");
			} else {
				viewPage = "member/main.jsp";
			}
		} else if (command.equals("/joinView.do")) { // 회원가입 화면으로 가는 경우			
			viewPage = "member/join.jsp";
		} else if (command.equals("/join.do")) { // 회원가입 정보 입력 후 이를 db에 넣고, 로그인 페이지로 이동하도록 한다. id에는 가입했을 때 입력한 id가 출력된다.
			service = new MJoinService();
			service.execute(request, response);
			viewPage = "loginView.do"; // 아무 패러미터를 넘기지 않은 채로 로그인창으로 이동.
		} else if (command.equals("/logout.do")) { // 로그아웃 처리. 세션을 invalidate하고 메인 페이지로.
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (command.equals("/modifyView.do")) { // 수정화면으로 이동
			// service = new MGetMemberService(); 만일 데이터베이스에 있는 데이터를 세션으로 가져오겠다면.. 그러나 로그인시 받은 세션을 그대로 넣을 수 있음.			
			viewPage = "member/modify.jsp";
		} else if (command.equals("/modify.do")) {
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		} else if (command.equals("/allView.do")) { // 회원 전체리스트를 출력할 때. pageNum이 있을때와 없을 때를 구분하여 출력함.
					
		} else if (command.equals("withdrawl.do")) { // 회원탈퇴 기능 수행. 이후 로그아웃 필요
			
		}	
		
		//viewPage로 forward함
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
