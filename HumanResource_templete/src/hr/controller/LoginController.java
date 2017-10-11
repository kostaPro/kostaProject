package hr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("loginId");
		String pw = request.getParameter("passwd");
		
		if(id.equals("aa") && pw.equals("ss")) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", id);
			session.setAttribute("userName", "mei");
			response.sendRedirect("menu.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
