package kr.or.ddit.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.model.Board;
import kr.or.ddit.util.MybatisUtil;

public class BoardService implements IBoardService{
	
	private IBoardDao boardDao;
	public BoardService() {
		boardDao = new BoardDao();
	}

	@Override
	public List<Board> getBoardList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Board> boardList = boardDao.getBoardList(sqlSession);
		
		sqlSession.close();
		return boardList;
	}

	@Override
	public int insertNewBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int insertCnt = boardDao.insertNewBoard(sqlSession, board);
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int updateBoard(Board board) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int updateCnt = boardDao.updateBoard(sqlSession, board);
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}
}
