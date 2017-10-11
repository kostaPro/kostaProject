package board.web.servlet.store;

import java.util.List;

import board.web.servlet.domain.Board;

public interface BoardStore {

    String create(Board board);
    Board retrieve(String boardId);
    void update(Board board);
    void delete(String boardId);
	List<Board> retrieveAll();
}
