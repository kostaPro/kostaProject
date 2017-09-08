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

@WebServlet("/article/modify.do")
public class ArticleModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();

		String articleId = request.getParameter("articleId");
		Article article = service.findArticle(articleId);

		List<Board> boards = service.findAllBoards();

		request.setAttribute("articleDetail", article);
		request.setAttribute("boards", boards);

		request.getRequestDispatcher("/views/article/articleModify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();
		
		String articleId = request.getParameter("articleId");
		String contents = request.getParameter("contents");
		
		Article article = new Article();
		article.setContents(contents);
		article.setArticleId(articleId);
		
		service.modifyArticle(article);
		
		article.setArticleId(request.getParameter("articleId"));

		response.sendRedirect(request.getContextPath() + "/article/find.do?articleId=" + article.getArticleId());

	}

}
