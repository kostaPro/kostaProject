
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select.do")
public class SelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<String> group1 = new ArrayList<>();
		ArrayList<String> group2 = new ArrayList<>();
		
		group1.add("'A'");
		group1.add("'B'");
		group1.add("'C'");
		group1.add("'D'");

		group2.add("1");
		group2.add("2");
		group2.add("3");
		group2.add("4");
		group2.add("5");
		
		request.setAttribute("group1", group1);
		request.setAttribute("group2", group2);
		
		request.getRequestDispatcher("select.jsp").forward(request, response);
	}

}
