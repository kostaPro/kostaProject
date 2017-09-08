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

@WebServlet("/board/modify.do")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardService service = ServiceFactory.getBoardService();
		
		String boardId = request.getParameter("boardId");
		Board board = service.findBoard(boardId);
		
		List<Board> boards = service.findAllBoards();
		
		request.setAttribute("boardDetail", board);
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher("/views/board/boardModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();
		
		String boardId = request.getParameter("boardId");
		String boardName = request.getParameter("name");
		
		Board board = new Board();
		board.setName(boardName);
		board.setBoardId(boardId);
		board.setCreatorName((String)request.getSession().getAttribute("id"));
		
		service.modifyBoard(board);
		
		response.sendRedirect(request.getContextPath() + "/board/mgntList.do");
	}

}
