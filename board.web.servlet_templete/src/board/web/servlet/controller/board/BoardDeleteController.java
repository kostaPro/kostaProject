package board.web.servlet.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.web.servlet.service.BoardService;
import board.web.servlet.service.ServiceFactory;


@WebServlet("/board/remove.do")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		BoardService service = ServiceFactory.getBoardService();
		
		String boardId = request.getParameter("boardId");
	
		service.removeBoard(boardId);
		
		response.sendRedirect(request.getContextPath() + "/board/mgntList.do");
	}

}
