package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public class BoardDao implements IBoardDao{

	@Override
	public List<Board> getBoardList(SqlSession sqlSession) {
		List<Board> boardList = sqlSession.selectList("board.getBoardList");
		sqlSession.close();
		return boardList;
	}

	@Override
	public int insertNewBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("board.insertNewBoard", board);
	}

	@Override
	public int updateBoard(SqlSession sqlSession, Board board) {
		return sqlSession.update("board.updateBoard", board);
	}

}
