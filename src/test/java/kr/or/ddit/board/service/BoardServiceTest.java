package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.model.Board;

public class BoardServiceTest {

	private IBoardService boardService;
	@Before
	   public void setup() {
		boardService = new BoardService();
	      
	   }
	
	//@Test
	public void getBoardListTest() {
		
		/***Given***/

		/***When***/
		List<Board> boardList = boardService.getBoardList();
		/***Then***/
		assertEquals(12, boardList.size());
	}

	//@Test
	public void insertNewBoardTest() {
		/***Given***/
		Board board = new Board();
		
		board.setUserId("sally");
		board.setBoardNm("test04");
		board.setUseCk("1");
		
		/***When***/
		int insertCnt = boardService.insertNewBoard(board);
		
		/***Then***/
		assertEquals(insertCnt, 1);
		
	}
	
	@Test
	public void updateBoardTest() {
		/***Given***/
		Board board = new Board();

		board.setUseCk("0");
		board.setBoardId(152);

		/***When***/
		int updateCnt = boardService.updateBoard(board);
		
		/***Then***/
		assertEquals(updateCnt, 1);
		
	}
}
