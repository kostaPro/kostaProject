package board.web.servlet.store;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import board.web.servlet.domain.Board;
import board.web.servlet.store.logic.BoardStoreLogic;

public class BoardStoreLogicTest {
	
	private BoardStore store;
	
	@Before
	public void setUp() {
		store = new BoardStoreLogic();
	}

	@Test
	public void testCreate() {
		Board board = new Board();
		
		board.setName("Android");
		board.setCreatorName("park");
		
		store.create(board);
	}

	@Test
	public void testRetrieve() {
	
	}

	@Test
	public void testUpdate() {

	}

	@Test
	public void testDelete() {

	}

	@Test
	public void testRetrieveAll() {
		 assertNotNull(store.retrieveAll());
	}

}
