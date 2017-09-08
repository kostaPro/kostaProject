package board.web.servlet.store.mapper;

import java.util.List;

import board.web.servlet.domain.Article;

public interface ArticleMapper {

	void insert(Article article);

	Article select(String articleId);

	List<Article> selectAll(String boardId);

	void update(Article article);

	void delete(String articleId);
}
