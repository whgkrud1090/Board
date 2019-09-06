package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.model.Board;

public interface IBoardDao {

	/**
	* Method : getBoardList
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 조회
	 */
	List<Board> getBoardList(SqlSession sqlSession);
	
	/**
	* Method : insertNewBoard
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 생성
	 */
	int insertNewBoard(SqlSession sqlSession, Board board);
	
	/**
	* Method : updateBoard
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(SqlSession sqlSession, Board board);
}
