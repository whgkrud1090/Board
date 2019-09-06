package kr.or.ddit.board.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.Board;
import kr.or.ddit.util.MybatisUtil;

public class BoardDaoTest {
	
	private SqlSession sqlSession;
	private IBoardDao boardDao;

	@Before
	public void setup() {
		boardDao = new BoardDao();
		sqlSession = MybatisUtil.getSession();
	}
	@After
	public void tearDown() {
		sqlSession.close();
	}
	
	/**
	 * @After
	 * Method : tearDown
	 * 작성자 : PC-03
	 * 변경이력 :
	 * Method 설명 : 보드 리스트 조회 테스트
	 */
	//@Test
	public void getBoardListTest() {
		/***Given***/

		/***When***/
		List<Board> boardList = boardDao.getBoardList(sqlSession);
		/***Then***/
		assertEquals(13, boardList.size());
		
	}
	
	//@Test
	public void insertNewBoardTest() {
		/***Given***/
		Board board = new Board();
		
		board.setUserId("sally");
		board.setBoardNm("test02");
		board.setUseCk("0");
		
		/***When***/
		int insertCnt = boardDao.insertNewBoard(sqlSession, board);
		sqlSession.commit();
		
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
		int updateCnt = boardDao.updateBoard(sqlSession, board);
		sqlSession.commit();
		
		/***Then***/
		assertEquals(updateCnt, 1);
	}

}
