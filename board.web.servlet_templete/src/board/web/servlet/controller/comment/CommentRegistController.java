package board.web.servlet.controller.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.web.servlet.domain.Article;
import board.web.servlet.domain.Comment;
import board.web.servlet.service.BoardService;
import board.web.servlet.service.ServiceFactory;

@WebServlet("/comment/regist.do")
public class CommentRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BoardService service = ServiceFactory.getBoardService();
		
		Comment comment = new Comment();
		
		comment.setArticleId(request.getParameter("articleId"));
		comment.setComments(request.getParameter("comments"));
		comment.setAuthorName((String)request.getSession().getAttribute("id"));
		
		service.registerComment(comment);
		
		Article article = service.findArticle(comment.getArticleId());
		
		request.setAttribute("article", article);
		
		response.sendRedirect(request.getContextPath() + "/article/find.do?articleId=" + comment.getArticleId());
	}

}
