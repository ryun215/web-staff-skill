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
		System.out.println("doPro�޼ҵ� ȣ���");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println("RequestURI :" + RequestURI);
		System.out.println("contextPath :" + contextPath);
		System.out.println("command :" + command);
		FrontController front = null;
		Action action = null;

		// ��ȸȭ������ �� �� religion, graduate, skill�� ��ȸ
		if (command.equals("/jsp/staffSearch.staff")) {
			System.out.println("��ȸȭ������ �� �� religion, graduate, skill�� ��ȸ");
			action = new SearchForm();

			try {
				front = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// �Է������� ���� �Է� �� db�� insert
		if (command.equals("/jsp/insertFormAction.staff")) {
			System.out.println("�Է�ȭ�鿡�� �Է¹�ư Ŭ��Ȯ��");
			action = new insertFormAction();

			try {
				front = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// �Է�ȭ������ ���� religion�� skill, graduate�� ������ ȭ������ �̵�
		if (command.equals("/jsp/staffInsert.staff")) {
			System.out.println("�Է�ȭ������ ���� religion�� skill, graduate�� ������ ȭ������ �̵�");
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
				System.out.println("������ ����");
				RequestDispatcher dispatcher = request.getRequestDispatcher(front.getPath());
				System.out.println("front.getPath :" + front.getPath());

				System.out.println("dispatcher�� �Էµ� path :" + dispatcher);
				dispatcher.forward(request, response);
			}

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get��� ��û���� ��Ʈ�ѷ�����");
		doPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post��� ��û���� ��Ʈ�ѷ�����");
		doPro(request, response);
	}

}
