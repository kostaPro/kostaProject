package board.web.servlet.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("inputEmail");
		String password = request.getParameter("inputPassword");
		
		HttpSession session = request.getSession();
		
		if(password.equals("admin")) {
			session.setAttribute("id", email);
			session.setAttribute("name", email);
		}
		response.sendRedirect(request.getContextPath() + "/board/list.do");
	}
}
