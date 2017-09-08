package board.web.servlet.service.logic;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import board.web.servlet.domain.Article;
import board.web.servlet.domain.Board;
import board.web.servlet.domain.Comment;
import board.web.servlet.service.BoardService;
import board.web.servlet.store.ArticleStore;
import board.web.servlet.store.BoardStore;
import board.web.servlet.store.CommentStore;
import board.web.servlet.store.logic.ArticleStoreLogic;
import board.web.servlet.store.logic.BoardStoreLogic;
import board.web.servlet.store.logic.CommentStoreLogic;

public class BoardServiceLogic implements BoardService {

	private BoardStore boardStore;
	private ArticleStore articleStore;
	private CommentStore commentStore;

	public BoardServiceLogic() {
		boardStore = new BoardStoreLogic();
		articleStore = new ArticleStoreLogic();
		commentStore = new CommentStoreLogic();
	}

	@Override
	public void registerArticle(Article article) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		article.setRegDate(today);

		articleStore.create(article);

	}

	@Override
	public Article findArticle(String articleId) {
		Article article = articleStore.retrieve(articleId);

		if (article == null) {
			return null;
		}

		// Comment에 대한 retieveAll();
		List<Comment> comments = commentStore.retrieveAll(articleId);
		article.setComments(comments);

		return article;
	}

	@Override
	public Board findBoard(String boardId) {
		Board board = boardStore.retrieve(boardId);
		if (board == null) {
			return null;
		}
		List<Article> articles = articleStore.retrieveAll(boardId);
		board.setArticles(articles);
		return board;
	}

	@Override
	public void removeArticle(String articleId) {
		articleStore.delete(articleId);
		
		List<Comment> list = commentStore.retrieveAll(articleId);
		for (int i = 0; i < list.size(); i++) {
			String comment = list.get(i).getCommentId();
			commentStore.delete(comment);
		}

	}

	@Override
	public void modifyArticle(Article article) {
		articleStore.update(article);

	}

	@Override
	public void registerBoard(Board board) {
		// Date today = new Date(Calendar.getInstance().getTimeInMillis());
		// board.setCreatedDate(today);

		boardStore.create(board);
	}

	@Override
	public List<Board> findAllBoards() {
		return boardStore.retrieveAll();
	}

	@Override
	public void modifyBoard(Board board) {

		boardStore.update(board);

	}

	@Override
	public void removeBoard(String boardId) {

		boardStore.delete(boardId);
		
		List<Article> list = articleStore.retrieveAll(boardId);
		for (int i = 0; i < list.size(); i++) {
			String article = list.get(i).getArticleId();
			removeArticle(article);
		}

	}

	@Override
	public void registerComment(Comment comment) {
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		comment.setRegDate(today);
		commentStore.create(comment);
	}

	@Override
	public void removeComment(String commentId) {
		commentStore.delete(commentId);
	}

}
