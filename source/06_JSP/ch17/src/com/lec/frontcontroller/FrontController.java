package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.*;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 어떤 요청이 들어왔는지 판별(select.do? delete.do? insert.do? update.do?)
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("들어온 요청 : " + command);
		//response.getWriter().append("<h1>"+command+"</h1>");
		// 들어온 요청에 따라 다른 일을 한 후 view단으로 forward함
		String viewPage = null; // 뷰페이지 변수
		Service service = null; // InsertService나 SelectService, UpdateService, DeleteService 등
		if (command.equals("/insert.do")) {
			//insert.do로 요청이 들어오면 할 일			
			service = new InsertService(); // insert.do에서 호출받으면 InsertService 함수를 수행함.
			service.execute(request, response); // insertService에서 받은 request.setAttribute 객체(insertResult)를 다시 전달.
			viewPage = "select.do"; // 게시글 작성 후 리스트로 돌아감.
			// 단, select.jsp로 가는 경우에는 list 기능을 호출하지 않았으므로 항목이 없음. select.do로 가야 함.
		} else if (command.equals("/select.do")) {
			service = new SelectService();
			service.execute(request, response);
			viewPage = "ex2/select.jsp";
		} else if (command.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response); // request에 updateResult 추가 (0)
			viewPage = "select.do";
		} else if (command.equals("/delete.do")) {
			service = new DeleteService();
			service.execute(request, response); // request에 deleteResult 추가(삭제성공)
			viewPage = "select.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
