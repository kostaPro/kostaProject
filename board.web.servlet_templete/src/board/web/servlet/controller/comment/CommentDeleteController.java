package board.web.servlet.controller.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.web.servlet.domain.Comment;
import board.web.servlet.service.BoardService;
import board.web.servlet.service.ServiceFactory;

@WebServlet("/comment/remove.do")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BoardService service = ServiceFactory.getBoardService();

		String commentId = request.getParameter("commentId");

		service.removeComment(commentId);
		
		Comment comment = new Comment();
		
		comment.setArticleId(request.getParameter("articleId"));

		response.sendRedirect(request.getContextPath() + "/article/find.do?articleId=" + comment.getArticleId());
	}

}
