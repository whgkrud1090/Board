package kr.or.ddit.post.model;

public class Comment {
	private int commentId;
	private int postId;
	private String commentCnt;
	private String commentUser;
	private int commentDel;
	private String commentUp;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(String commentCnt) {
		this.commentCnt = commentCnt;
	}
	public String getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}
	public int getCommentDel() {
		return commentDel;
	}
	public void setCommentDel(int commentDel) {
		this.commentDel = commentDel;
	}
	public String getCommentUp() {
		return commentUp;
	}
	public void setCommentUp(String commentUp) {
		this.commentUp = commentUp;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", postId=" + postId + ", commentCnt=" + commentCnt
				+ ", commentUser=" + commentUser + ", commentDel=" + commentDel + ", commentUp=" + commentUp + "]";
	}
	
}
