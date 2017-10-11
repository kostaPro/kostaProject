package board.web.servlet.controller.article;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.web.servlet.domain.Article;
import board.web.servlet.service.BoardService;
import board.web.servlet.service.ServiceFactory;

@WebServlet("/article/remove.do")
public class ArticleDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();

		String articleId = request.getParameter("articleId");

		service.removeArticle(articleId);
		
		Article article = new Article();
		
		article.setBoardId(request.getParameter("boardId"));

		response.sendRedirect(request.getContextPath() + "/board/find.do?boardId=" + article.getBoardId());
	}

}
