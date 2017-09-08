package board.web.servlet.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.web.servlet.domain.Board;
import board.web.servlet.store.BoardStore;
import board.web.servlet.store.mapper.BoardMapper;

public class BoardStoreLogic implements BoardStore{

	@Override
	public String create(Board board) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		
		try {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			mapper.insert(board);
			session.commit();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			session.close();
		}
		return board.getBoardId();
	}

	@Override
	public Board retrieve(String boardId) {
		SqlSession session  = BoardSessionFactory.getInstance().getSession();
		
		Board board = null;
		
		try {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			board = mapper.select(boardId);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return board;
	}

	@Override
	public void update(Board board) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		
		try {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			mapper.update(board);
			session.commit();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(String boardId) {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		
		try {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			mapper.delete(boardId);
			session.commit();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Board> retrieveAll() {
		SqlSession session = BoardSessionFactory.getInstance().getSession();
		
		List<Board> list = null;
		
		try {
			BoardMapper mapper = session.getMapper(BoardMapper.class);
			list = mapper.selectAll();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		return list;
	}

}









