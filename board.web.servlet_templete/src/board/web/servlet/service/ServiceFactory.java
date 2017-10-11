package board.web.servlet.service;

import board.web.servlet.service.logic.BoardServiceLogic;

public class ServiceFactory {

	private static ServiceFactory instance = new ServiceFactory();
	
	private BoardService boardService;
	
	private ServiceFactory() {
		boardService = new BoardServiceLogic();
	}
	
	public static BoardService getBoardService() {
		return instance.boardService;
	}
}
