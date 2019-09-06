package kr.or.ddit.post.model;

public class Post {

	private int postId;
	private int boardId;
	
	//상위 게시글 번호
	private int parentpostId;
	
	private String userId;
	private String postNm;
	private String postCont;
	private String postUp;
	private int postDel;
	
	private int page;
	private int pagesize;
	
	public Post(int page, int pagesize, int boardId) {
		this.page = page;
		this.pagesize = pagesize;
		this.boardId = boardId;
	}
	public Post(int boardId) {
		this.boardId = boardId;
	}
	public Post(int boardId, String userId, String postNm, String postCont) {
		this.boardId = boardId;
		this.userId = userId;
		this.postNm = postNm;
		this.postCont = postCont;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getParentpostId() {
		return parentpostId;
	}
	public void setParentpostId(int parentpostId) {
		this.parentpostId = parentpostId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPostNm() {
		return postNm;
	}
	public void setPostNm(String postNm) {
		this.postNm = postNm;
	}
	public String getPostCont() {
		return postCont;
	}
	public void setPostCont(String postCont) {
		this.postCont = postCont;
	}
	public String getPostUp() {
		return postUp;
	}
	public void setPostUp(String postUp) {
		this.postUp = postUp;
	}
	public int getPostDel() {
		return postDel;
	}
	public void setPostDel(int postDel) {
		this.postDel = postDel;
	}
	public Post() {
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", boardId=" + boardId + ", parentpostId=" + parentpostId + ", userId="
				+ userId + ", postNm=" + postNm + ", postCont=" + postCont + ", postUp=" + postUp + ", postDel="
				+ postDel + ", page=" + page + ", pagesize=" + pagesize + "]";
	}
}
