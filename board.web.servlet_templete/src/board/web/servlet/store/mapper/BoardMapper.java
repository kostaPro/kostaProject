package board.web.servlet.store.mapper;

import java.util.List;

import board.web.servlet.domain.Board;

public interface BoardMapper {

	void insert(Board board);

	Board select(String boardId);

	void update(Board board);

	void delete(String boardId);

	List<Board> selectAll();
}
