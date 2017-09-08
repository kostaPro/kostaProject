package board.web.servlet.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.web.servlet.domain.Article;
import board.web.servlet.store.ArticleStore;
import board.web.servlet.store.mapper.ArticleMapper;

public class ArticleStoreLogic implements ArticleStore {

	@Override
	public String create(Article article) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();

		try {
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			mapper.insert(article);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return article.getArticleId();
	}

	@Override
	public Article retrieve(String articleId) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		Article article = null;
		try {
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			article = mapper.select(articleId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return article;
	}

	@Override
	public List<Article> retrieveAll(String boardId) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		List<Article> list = null;
		try {
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			list = mapper.selectAll(boardId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void update(Article article) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();

		try {
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			mapper.update(article);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(String articleId) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();

		try {
			ArticleMapper mapper = session.getMapper(ArticleMapper.class);
			mapper.delete(articleId);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

	}

}
