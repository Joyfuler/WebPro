package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.Service;
import com.lec.ex.service.boardContentService;
import com.lec.ex.service.boardDeleteService;
import com.lec.ex.service.boardListService;
import com.lec.ex.service.boardWriteService;
import com.lec.ex.service.memailConfirmService;
import com.lec.ex.service.midConfirmService;
import com.lec.ex.service.modifyService;
import com.lec.ex.service.withdrawalService;
import com.lec.ex.service.AdminLoginService;
import com.lec.ex.service.JoinService;
import com.lec.ex.service.LogOutService;
import com.lec.ex.service.LoginServce;
import com.lec.ex.service.MAllViewService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = "";
		Service service = null;
		if (command.equals("/main.do")) {
			viewPage = "main/main.jsp";
		} else if (command.equals("/adminLoginView.do")) {
			viewPage = "admin/adminLogin.jsp";
		} else if (command.equals("/adminLogin.do")) {
			service = new AdminLoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		} else if (command.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		} else if (command.equals("/logout.do")) {
			service = new LogOutService();
			service.execute(request, response);
			viewPage = "main.do";
		} else if (command.equals("/loginView.do")) {
			viewPage = "member/login.jsp";
		} else if (command.equals("/login.do")) {
			service = new LoginServce();
			service.execute(request, response);
			viewPage = "main.do";
		} else if (command.equals("/joinView.do")) {
			viewPage = "member/join.jsp";
		} else if (command.equals("/join.do")) {
			service = new JoinService();
			service.execute(request, response);
			viewPage = "loginView.do";
		} else if (command.equals("/midConfirm.do")) {
			service = new midConfirmService(); 
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";	
		} else if (command.equals("/memailConfirm.do")) {
			service = new memailConfirmService();
			service.execute(request, response);
			viewPage = "member/memailConfirm.jsp";
		} else if (command.equals("/modifyView.do")) {
			viewPage = "member/modify.jsp";
		} else if (command.equals("/modify.do")) {
			service = new modifyService();
			service.execute(request, response);
			viewPage = "main.do";
		} else if (command.equals("/withdrawal.do")){
			service = new withdrawalService();
			service.execute(request, response);
			viewPage = "main.do";				
		} else if (command.equals("/boardList.do")) {
			service = new boardListService();
			service.execute(request, response);
			viewPage = "fileBoard/boardList.jsp";
		} else if (command.equals("/boardContent.do")) {
			service = new boardContentService();
			service.execute(request, response);
			viewPage = "fileBoard/boardContent.jsp";
		} else if (command.equals("/boardWriteView.do")) {
			viewPage = "fileBoard/boardWrite.jsp";
		} else if (command.equals("/boardWrite.do")) {
			service = new boardWriteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		} else if (command.equals("/boardDelete.do")) {
			service = new boardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);		
	}
}
