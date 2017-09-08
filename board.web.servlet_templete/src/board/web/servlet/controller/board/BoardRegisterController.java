package board.web.servlet.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.web.servlet.domain.Board;
import board.web.servlet.service.BoardService;
import board.web.servlet.service.ServiceFactory;

@WebServlet("/board/regist.do")
public class BoardRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();
		List<Board> boards = service.findAllBoards();
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher("/views/board/boardCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();
		Board board = new Board();
		board.setName(request.getParameter("name"));
		board.setCreatorName((String)request.getSession().getAttribute("name"));
		service.registerBoard(board);
		
		response.sendRedirect(request.getContextPath() + "/board/mgntList.do");
	}

}
