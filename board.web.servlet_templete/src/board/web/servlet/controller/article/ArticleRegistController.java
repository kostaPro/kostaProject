package board.web.servlet.controller.article;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.web.servlet.domain.Article;
import board.web.servlet.domain.Board;
import board.web.servlet.service.BoardService;
import board.web.servlet.service.ServiceFactory;

@WebServlet("/article/regist.do")
public class ArticleRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardService service = ServiceFactory.getBoardService();
		
		String boardId = request.getParameter("boardId");
		
		List<Board> boards = service.findAllBoards();
		Board boardDetail = service.findBoard(boardId);
		
		request.setAttribute("boards", boards);
		request.setAttribute("boardDetail", boardDetail);
		
		request.getRequestDispatcher("/views/article/articleWrite.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardService service = ServiceFactory.getBoardService();
		
		Article article = new Article();
		
		article.setAuthorName((String)request.getSession().getAttribute("id"));
		article.setTitle(request.getParameter("title"));
		article.setContents(request.getParameter("contents"));
		article.setBoardId(request.getParameter("boardId"));
		
		service.registerArticle(article);
		
		response.sendRedirect(request.getContextPath() + "/board/find.do?boardId=" + article.getBoardId());
	}

}
