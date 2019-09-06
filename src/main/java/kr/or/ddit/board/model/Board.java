package kr.or.ddit.board.model;

public class Board {

	private int boardId;
	private String userId;
	private String boardNm;
	private String useCk;
	private String boardUp;
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	
	public String getUseCk() {
		return useCk;
	}
	public void setUseCk(String useCk) {
		this.useCk = useCk;
	}
	public String getBoardUp() {
		return boardUp;
	}
	public void setBoardUp(String boardUp) {
		this.boardUp = boardUp;
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", userId=" + userId + ", boardNm=" + boardNm + ", useCk=" + useCk
				+ ", boardUp=" + boardUp + "]";
	}
	
	public Board() {
	}
	public Board(String userId, String boardNm, String useCk) {
		this.userId = userId;
		this.boardNm = boardNm;
		this.useCk = useCk;
	}
	public Board(int boardId, String useCk) {
		this.boardId = boardId;
		this.useCk = useCk;
	}
}
