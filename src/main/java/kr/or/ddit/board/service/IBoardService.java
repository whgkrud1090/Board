package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.Board;

public interface IBoardService {
	
	/**
	* Method : getBoardList
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 게시판 리스트 조회
	 */
	List<Board> getBoardList();
	
	/**
	* Method : insertNewBoard
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 생성
	 */
	int insertNewBoard(Board board);
	
	/**
	* Method : updateBoard
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param board
	* @return
	* Method 설명 : 게시판 수정
	 */
	int updateBoard(Board board);
}
