package kr.or.ddit.post.model;

public class Attachment {
	
	private int attafIleid;
	private int postId;
	private String upFilenm;
	private String detailFile;

	//생성자
	public Attachment(int postId, String upFilenm, String detailFile) {
		this.postId = postId;
		this.upFilenm = upFilenm;
		this.detailFile = detailFile;
	}
	
	public Attachment() {
	}
	
	public int getAttafIleid() {
		return attafIleid;
	}
	public void setAttafIleid(int attafIleid) {
		this.attafIleid = attafIleid;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUpFilenm() {
		return upFilenm;
	}
	public void setUpFilenm(String upFilenm) {
		this.upFilenm = upFilenm;
	}
	public String getDetailFile() {
		return detailFile;
	}
	public void setDetailFile(String detailFile) {
		this.detailFile = detailFile;
	}
	@Override
	public String toString() {
		return "Attachment [attafIleid=" + attafIleid + ", postId=" + postId + ", upFilenm=" + upFilenm
				+ ", detailFile=" + detailFile + "]";
	}

}
