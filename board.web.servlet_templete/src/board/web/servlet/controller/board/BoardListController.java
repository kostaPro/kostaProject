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

@WebServlet("/board/list.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		BoardService serivce = ServiceFactory.getBoardService();
		
		List<Board> list = serivce.findAllBoards();
		
		request.setAttribute("boards", list);
		
		request.getRequestDispatcher("/views/article/articleMain.jsp").forward(request, response);
	}
}
