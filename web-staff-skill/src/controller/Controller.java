package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.InsertForm;
import action.SearchForm;
import action.insertFormAction;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	protected void doPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPro메소드 호출됨");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println("RequestURI :" + RequestURI);
		System.out.println("contextPath :" + contextPath);
		System.out.println("command :" + command);
		FrontController front = null;
		Action action = null;

		// 조회화면으로 갈 때 religion, graduate, skill값 조회
		if (command.equals("/jsp/staffSearch.staff")) {
			System.out.println("조회화면으로 갈 때 religion, graduate, skill값 조회");
			action = new SearchForm();

			try {
				front = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 입력정보를 전부 입력 후 db로 insert
		if (command.equals("/jsp/insertFormAction.staff")) {
			System.out.println("입력화면에서 입력버튼 클릭확인");
			action = new insertFormAction();

			try {
				front = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 입력화면으로 갈때 religion와 skill, graduate값 가지고 화면으로 이동
		if (command.equals("/jsp/staffInsert.staff")) {
			System.out.println("입력화면으로 갈때 religion와 skill, graduate값 가지고 화면으로 이동");
			action = new InsertForm();

			try {
				front = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

			

			}
		
		if (front != null) {
			if (front.isRedirect()) {
				response.sendRedirect(front.getPath());
			} else {
				System.out.println("포워딩 시작");
				RequestDispatcher dispatcher = request.getRequestDispatcher(front.getPath());
				System.out.println("front.getPath :" + front.getPath());

				System.out.println("dispatcher에 입력된 path :" + dispatcher);
				dispatcher.forward(request, response);
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get방식 요청으로 컨트롤러접속");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post방식 요청으로 컨트롤러접속");
		doPro(request, response);
	}

}
