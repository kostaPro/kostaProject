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

@WebServlet("/article/find.do")
public class ArticleDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();
		
		Article article = service.findArticle(request.getParameter("articleId"));
		request.setAttribute("article", article);
		
		Board boardDetail = service.findBoard(article.getBoardId());
		request.setAttribute("boardDetail", boardDetail);
		
		List<Board> boards = service.findAllBoards();
		request.setAttribute("boards", boards);
		
		request.getRequestDispatcher("/views/article/articleDetail.jsp").forward(request, response);
		
	}

}
